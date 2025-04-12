# frozen_string_literal: true

class Layout < Phlex::HTML
  def initialize(title:)
    @title = title
  end

  def view_template(&block)
    doctype
    html {
      head {
        meta charset: "utf-8"
        meta name: "viewport", content: "width=device-width, initial-scale=1.0"
        link rel: "stylesheet", href: "https://cdnjs.cloudflare.com/ajax/libs/picocss/2.1.0/pico.classless.min.css"
        title { @title }
        body {
          header {
            nav {
              ul {
                li { a(href: "/") { "Home" } }
                li { a(href: "/rank") { "Rank" } }
                li { a(href: "/leaderboard") { "Leaderboard" } }
                li { a(href: "/about") { "About" } }
              }
            }
          }
          yield
          footer {
            p {
              em { 'This site is in no way affiliated with "Toy Story" or Red Letter Media.' }
            }
          }
        }
      }
    }
  end
end
