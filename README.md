# The Dumbest Thing I Could Do

This is the repo for the code powering [Best of _Best of the Worst_](https://bobotw.com), a silly, simple ranking system
created purely for my own amusement and the entertainment of other fans. In this README I will outline what I did, how I
did it, and why I did it that way.

## Here Begins The Rambling

I don't remember the first time I thought, "shit, I'm old now". But in the dense band of such occasions which thereafter
followed, I know that one such thought was immediately preceded by "gee, developing web apps sucks now". When I was
younger you could follow a problem anywhere it led in the code and solve it, either yourself or with the help of
teammates. But now web dev means teams and committees and tense video meetings and back channel haggling and design
documents at twenty paces. "Depressing" fails to capture the despair this engenders in the way that "bored" incompletely
describes any child after 30 seconds waiting in a line without a screen.

So when I set out to write this little bit of code, I thought: I want to play a bit, sure, but I want to keep it simple.
I'm just pissfarting around here. No need to be formal and fancy. This is for fun, not professional completeness.

And so, by weird coincidence, I stepped into a time machine that zapped me back to 2007. An era so distant that Facebook
was a website and we were still living with the mutant offspring of the 90s and the War on Terror. What happened is that
I made some basic technology choices:

* _The site needs to be stupidly simple, I don't want a full MVC parade_. OK, I'll use Sinatra.
* _I guess that rules out Rails, but thank god it also rules out ActiveRecord_. I suppose I'll use Sequel.
* _I want to use a cheap VPS and my site will get bugger-all traffic_. OK, I'll use SQLite.

SQLite was released in 2001. Sinatra and Sequel were released in 2007. I had fallen into the magic cave and stumbled
out the other side into a world where HTML was the main show and not just a family embarrassment that had to be
stoically, silently endured by React.

Let me tell you. It was wonderful.

Dumb forms. Why? Because the backend is fast enough that it looks instant. Dumb server-side rendering. Why? Because the
backend is fast enough that it looks instant. Dumb simple slow friendly Ruby code. Why? Because computers are somewhere
between a bajillion and a hojillion times faster than they were when I first rented at VPS (in 2007, as it so happens).
`<form>` tags. Hyperlinks. Tiny data. Total network traffic under 200k per page. Two threads for two cores. It was
enough.

I even eschewed HTMX. I bought the book! It's great, it made me feel hopeful, I want to use it someday. But I just ...
didn't need it. This is a dumb simple site. The interactive vibe is an illusion bred by being simple and light and dumb.

## Some Decisions 

* I like SQL. It is neat. It is powerful. I will use it to simplify the Ruby code. Until LLMs came along query planners
were the closest thing we had to magic.
* Speaking of AI, is it any use? Well, somewhat. It writes half-useful CSS. It saves time on some things (but also makes
bizarre choices on other things -- whatevs). I basically paired with it occasionally. It was OK. Saved a few episodes of
_Midsommer Google Searches_. It drafted the first version of the "about" page, which I mostly rewrote. Who in their
sane earthly mind still writes "Questions? Suggestions?" or "Crowdsourced" in this the year of our flying zombie two
thousand and twenty five? Nobody except an absurdly self-confident cloud of floats, that's who.
* I will store tag colors in the database and inline them when I render the tag in HTML. I could create classes and IDs
and whatnot, but I could also just splurt it out inline from a quick query.
* The image names are based on the IDs in the database. So I don't need another field to store a filename. Wouldn't
scale if I were accepting stuff from users, but I'm not, so who cares?
* I don't want to put up a stupid cookie banner. But I also want to stop double-voting. Solution: the dumbest cookie 
scheme in history. But with Rack magic so that it's robust. -ish.
* I kinda dislike templating engines. Why not just write code? With methods and other such conveniences. In Java I'd use
j2html, in Go I'd use Gomponents. In Ruby it's Phlex. Created by a former coworker. Small world.
* Did I mention forms? You can just spray them into HTML and never use `fetch` at all. It's built in! Magical.
* OK so I used a tiny bit of JavaScript, to prevent people double-clicking on the buttons. Sue me.
* I made some concessions to fashionable overengineering. One was Phlex -- so chic, when I could've gotten by with Erb
in a pinch. Another was using UUIDv7 for cookie ID values. Will the improvement to database index fragmentation ever
matter? Not really, but fuck it, I wouldn't be a true software engineer if I didn't optimize without profiling first.
* Speaking of which, AI suggested a silly but fun optimization: load the image filenames once so that the code doesn't
have to do a seek/stat/whatever on every request. Time saved? Probably miniscule. Satisfaction? Maxiscule.
* The leaderboard is just upvotes vs downvotes, with a subtle statistical twist I stole from a link I saw on HN. There
are other much more clever schemes. Elo, for example. But who cares? Up-vs-down is easy to write and fast to query.
* Kubernetes? Container images? App platforms? Nah: rsync to a VPS and SSH to restart the process.

## Conclusion

It was actually fun. No weird APIs to flatter. No coaxing the corner case into the open before trapping it. Just some
honest, uncomplicated noodling around on my laptop. It was glorious. For the first time it made me dream of the life of
a retiree, a dream hitherto completely obscured by my very pedestrian career trajectory.

Maybe I'll do something else. Maybe I won't. But for a brief, glorious moment, I was a programmer. Ruler of my little
digital domain.

Stay hopeful, brothers and sisters. This stuff can still be fun.
