# frozen_string_literal: true

require_relative "layout"

class Leaderboard < Phlex::HTML
  def initialize(count_of_rankings:, videos:)
    @count_of_rankings = count_of_rankings
    @videos = videos
  end

  def view_template
    render Layout.new(title: "BOBOTW Leaderboard") do
      main {
        p { "With #{@count_of_rankings} rankings submitted:"}
        table {
          thead {
            tr {
              th { "Overall Rank" }
              th { "Title" }
              th { "Adjusted Win %" }
            }
            videos
          }
        }
      }
    end
  end

  private

  def videos
    tbody do
      @videos.each do |video|
        tr {
          td { video[:rank] }
          td { video[:title] }
          td { "%0.2f" % (video[:confidence_lower_bound] * 100.0) }
        }
      end
    end
  end
end
