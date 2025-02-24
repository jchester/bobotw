# frozen_string_literal: true

require_relative "layout"

class HomePage < Phlex::HTML
  def initialize(top_title:, episode_title:)
    @top_title = top_title
    @episode_title = episode_title
  end

  def view_template
    render Layout.new(title: "Best of Best of the Worst") do
      main {
        h1 { "Best of Best of the Worst" }
        div {
          p { "The current Best of Best of the Worst is" }
          h2 { @top_title }
          p { "As seen in the episode entitled #{@episode_title}" }
        }
      }
    end
  end
end
