merge into videos (id, title, episode_title) key (id)
    values (1, 'Russian Terminator', 'Episode 1'),
           (2, 'Aftermath', 'The New Gladiators, Exterminator 2, and The Aftermath'),
           (3, 'Xtro', 'The Killer Eye, They Bite, and Xtro'),
           (4, 'Miami Connection', 'Deadly Prey, Hard Ticket to Hawaii, and Miami Connection'),
           (5, 'Let''s Rap About Fire Safety', 'The Wheel of the Worst'),
           (6, 'R.O.T.O.R.', 'The Vindicator, Cyber Tracker, Robot Jox, and R.O.T.O.R.'),
           (7, 'Thunderpants', 'Playing Dangerous, Shapeshifter, and Thunderpants'),
           (8, 'Gary Coleman For Safety''s Sake', 'Wheel of the Worst #2'),
           (9, 'Gymkata', 'V-World Matrix, The Amazing Bulk, and ????'),
           (10, 'Crazy Fat Ethel II', 'Bloody Birthday, Crazy Fat Ethel II, and Psycho From Texas'),
           (11, 'Skull Forest', 'Night Beast, Trick or Treat, and Skull Forest'),
           (12, 'Incredible Instant Adoring Boyfriend', 'Wheel of the Worst #3'),
           (13, 'The Deadliest Prey', 'Playing Dangerous 2, The Exterminator, and The Deadliest Prey'),
           (14, 'Elves', 'Elves, Santa Claus, and Christmas Vacation 2'),
           (15, 'Yor: The Hunter from the Future', 'Robo-C.H.I.C., Alien Seed, and Yor: The Hunter from the Future'),
           (16, 'The Shoji Tabuchi Show', 'Wheel of the Worst #4'),
           (17, 'Roger Corman''s Fantastic Four',
            'Supergirl, Captain America (1990), and Roger Corman''s Fantastic Four'),
           (18, 'Lethal Ninja', 'Ninja Movies'),
           (19, 'SOS', 'Wheel of the Worst #5'),
           (20, 'Terror in Beverly Hills', 'Ghetto Blaster, Terror in Beverly Hills, and Killing American Style')
;

merge into tags (id, text, color) key (id)
    values (1, 'Wheel of the Worst', '#77bb41'),
           (2, '🇨🇦 Colin and/or Jim from Canada', '#d80621'),
           (3, '🎃 Halloween Spooktacular', '#ff6600'),
           (4, 'Sequel', '#341253'),
           (5, '🎅 Christmas', '#009933'),
           (6, '🥷 Len Kabasinski', '#121212'),
           (7, 'Cameron Mitchell', '#34de53')
;

merge into tags_on_videos (id, video_id, tag_id) key (id)
    values
        -- Wheel
        (1, 5, 1),
        (2, 8, 1),
        (3, 12, 1),
        (4, 16, 1),
        (5, 19, 1),
        -- Colin/Jim from Canada
        (6, 9, 2),
        (7, 20, 2),
        -- Halloween
        (8, 11, 3),
        -- Sequel show
        (9, 13, 4),
        -- Christmas
        (10, 14, 5),
        -- Len Kabasinski
        (11, 11, 6),
        (12, 18, 6),
        -- Cameron Mitchell
        (13, 20, 7)
;