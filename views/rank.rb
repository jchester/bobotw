# frozen_string_literal: true

require_relative "layout"

class Rank < Phlex::HTML
  def initialize(left_video:, right_video:, left_tags:, right_tags:, left_image:, right_image:, ranked:, possible:)
    @left_video = left_video
    @right_video = right_video
    @left_tags = left_tags
    @right_tags = right_tags
    @left_image = left_image
    @right_image = right_image
    @ranked = ranked
    @possible = possible
  end

  def view_template
    render Layout.new(title: "Rank!") do
      link(rel: "stylesheet", href: "/style/rank.css")
      main {
        p {
          plain "You have ranked #{@ranked} out of #{@possible} matchups. "
          a(href: "/rank") { "↺ Skip this pair." }
        }
        button_form(@left_image, @left_video, @right_video, @left_tags)
        button_form(@right_image, @right_video, @left_video, @right_tags)
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
    form(method: :post, action: "/rank", onsubmit: safe("btn.disabled = true; return true;")) {
      div(class: "card") {
        button(name: "btn") { "Select as winner" }
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
