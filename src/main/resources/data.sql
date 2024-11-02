insert into videos(id, title, episode_title)
values (1, 'Russian Terminator', 'Episode 1'),
       (2, 'Aftermath', 'The New Gladiators, Exterminator 2, and The Aftermath'),
       (3, 'Xtro', 'The Killer Eye, They Bite, and Xtro'),
       (4, 'Miami Connection', 'Deadly Prey, Hard Ticket to Hawaii, and Miami Connection'),
       (5, 'Let''s Rap About Fire Safety', 'The Wheel of the Worst'),
       (6, 'R.O.T.O.R.', 'The Vindicator, Cyber Tracker, Robot Jox, and R.O.T.O.R.'),
       (7, 'Thunderpants', 'Playing Dangerous, Shapeshifter, and Thunderpants'),
       (8, 'Gary Coleman For Safety''s Sake', 'Wheel of the Worst #2'),
       (9, 'Gymkata', 'V-World Matrix, The Amazing Bulk, and ????')
;

insert into tags(id, text)
values (1, 'Wheel of the Worst'),
       (2, 'Colin from Canada');

insert into tags_on_videos(video_id, tag_id)
values (5, 1),
       (8, 1),
       (9, 2)
;