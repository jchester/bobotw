# frozen_string_literal: true

require_relative "layout"

class Rank < Phlex::HTML
  DB = Sequel.sqlite("bobotw.db", loggers: [Logger.new('log/db.log', level: Logger::DEBUG)])

  def initialize(left_video:, right_video:, ranked:, possible:)
    @left_video = left_video
    @right_video = right_video
    @ranked = ranked
    @possible = possible

    @left_tags = DB[:tags]
                   .join(:tags_on_videos, tag_id: :tag_id)
                   .join(:videos, video_id: :video_id)
                   .where(Sequel[:tags_on_videos][:video_id] => left_video[:video_id])
    @right_tags = DB[:tags]
                    .join(:tags_on_videos, tag_id: :tag_id)
                    .join(:videos, video_id: :video_id)
                    .where(Sequel[:tags_on_videos][:video_id] => right_video[:video_id])
  end

  def view_template
    render Layout.new(title: "Rank!") do
      link(rel: "stylesheet", href: "/style/rank.css")
      main {
        p { "You have ranked #{@ranked} out of #{@possible} matchups." }

        button_form("/images/jay-bauman.jpg", @left_video, @right_video, @left_tags)
        button_form("/images/mike-stoklasa.jpg", @right_video, @left_video, @right_tags)
      }
    end
  end

  private

  def tags(tags)
    tags.each do |tag|
      span(class: "tag", style: "background-color: #{tag[:color]}") {
        tag[:text]
      }
    end
  end

  def button_form(image, winner, loser, tags)
    form(method: :post, action: "/rank") {
      div(class: "card") {
        button { "Select as winner" }
        h4 { winner[:title] }
        img(src: image)
        input(hidden: true, name: "winner_id", value: winner[:video_id])
        input(hidden: true, name: "loser_id", value: loser[:video_id])
        div(class: "tags") {
          tags(tags)
        }
      }
    }
  end
end
