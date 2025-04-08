# frozen_string_literal: true

require "sinatra/base"
require "phlex-sinatra"
require "sequel"
require "uuidx"
require_relative "views/layout"
require_relative "views/home_page"
require_relative "views/rank"
require_relative "views/leaderboard"

SESSION_SECRET = File.read("secret")

class App < Sinatra::Application
  helpers Phlex::Sinatra

  enable :sessions
  set :session_secret, SESSION_SECRET
  set :sessions, :expire_after => 60 * 24 * 365 * 10 # expire after 10ish years

  DB = Sequel.sqlite("bobotw.db", loggers: [Logger.new('log/db.log', level: Logger::DEBUG)])
  DB.run("PRAGMA foreign_keys = ON")

  get '/' do
    top_video = DB[:videos_with_confidence_bounds].reverse(:confidence_lower_bound)
                                                  .first
    phlex HomePage.new(top_title: top_video[:title], episode_title: top_video[:episode_title])
  end

  get '/rank' do
    ranker = session[:ranker]
    if ranker.nil?
      new_ranker_id = Uuidx.v7
      session[:ranker] = new_ranker_id
      DB[:rankers].insert(ranker_id: new_ranker_id)
    end

    # A little too fiddly to express using Sequel's DSL
    candidate_videos_sql = <<~SQL
      select l.video_id as left_id
           , r.video_id as right_id
      from videos_with_confidence_bounds l
               join videos_with_confidence_bounds r on l.video_id <> r.video_id
        where not exists(select 1
                       from pair_rankings
                       where ranker_id = ?
                         and winner_id in (l.video_id, r.video_id)
                         and loser_id in (l.video_id, r.video_id))
      order by cast(l.appearances as decimal) + cast(r.appearances as decimal) 
                   + ((random() + 9223372036854775808) / 18446744073709551616) -- hack to get random in range [0, 1]
      limit 1
    SQL

    #   if no more show no-more view

    video_ids = DB[candidate_videos_sql, session[:ranker]].first
    videos = DB[:videos]
    left_video = videos[video_id: video_ids[:left_id]]
    right_video = videos[video_id: video_ids[:right_id]]

    ranked = DB[:pair_rankings].count(:ranker_id => session[:ranker])
    video_count = DB[:videos].count
    possible = (video_count * (video_count - 1)) / 2

    phlex Rank.new(left_video:, right_video:, ranked:, possible:)
  end

  post '/rank' do
    ranker_id = session[:ranker]
    winner_id = params[:winner_id]
    loser_id = params[:loser_id]

    DB[:pair_rankings].insert(ranker_id:, winner_id:, loser_id:)

    redirect to("/rank")
  end

  get '/leaderboard' do
    count_of_rankings = DB[:pair_rankings].count
    videos = DB[:videos_with_confidence_bounds]

    phlex Leaderboard.new(count_of_rankings:, videos:)
  end

  get '/about' do
    send_file File.join(settings.public_dir, 'about.html')
  end
end

App.run!