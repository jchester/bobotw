# frozen_string_literal: true

require_relative "layout"

class HomePage < Phlex::HTML
  def initialize(top_title:, episode_title:, video_count:, image_path:)
    @top_title = top_title
    @episode_title = episode_title
    @video_count = video_count
    @image_path = image_path
  end

  def view_template
    render Layout.new(title: "Best of Best of the Worst") do
      main {
        h1 { "Best of Best of the Worst" }
        div {
          p { "Out of #{@video_count} videos in the DB, the current Best of Best of the Worst is:" }
          h2 { @top_title }
          img(src: @image_path)
          p { "As seen in the episode entitled '#{@episode_title}'." }
        }
      }
    end
  end
end
