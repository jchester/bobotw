# frozen_string_literal: true

require "sinatra/base"
require "phlex-sinatra"
require "sequel"
require_relative "views/layout"
require_relative "views/home_page"
require_relative "views/rank"


class App < Sinatra::Application
  helpers Phlex::Sinatra

  DB = Sequel.sqlite("bobotw.db", loggers: [Logger.new('log/db.log', level: Logger::DEBUG)])

  videos = DB[:videos]
  tags = DB[:tags]

  top_video = DB[:videos_with_confidence_bounds].reverse(:confidence_lower_bound)
                                                .first

  get '/' do
    phlex HomePage.new(top_title: top_video[:title], episode_title: top_video[:episode_title])
  end
end

App.run!