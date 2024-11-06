insert into videos(id, title, episode_title)
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
       (17, 'Roger Corman''s Fantastic Four', 'Supergirl, Captain America (1990), and Roger Corman''s Fantastic Four'),
       (18, 'Lethal Ninja', 'Ninja Movies'),
       (19, 'SOS', 'Wheel of the Worst #5'),
       (20, 'Terror in Beverly Hills', 'Ghetto Blaster, Terror in Beverly Hills, and Killing American Style')
;

insert into tags(id, text, color)
values (1, '2013', '#48d3aa'),
       (2, '2014', '#48d3ab'),
       (3, '2015', '#48d3ac'),
       (4, '2016', '#48d3ad'),
       (5, '2017', '#48d3ae'),
       (6, '2018', '#48d3af'),
       (7, '2019', '#48d3ba'),
       (8, '2020', '#48d3bb'),
       (9, '2021', '#48d3bc'),
       (10, '2022', '#48d3bd'),
       (11, '2023', '#48d3be'),
       (12, '2024', '#48d3bf'),
       (13, 'Wheel of the Worst', '#77bb41'),
       (14, '🇨🇦 Colin and/or Jim from Canada', '#d80621'),
       (15, '🎃 Halloween Spooktacular', '#ff6600'),
       (16, 'Sequel', '#341253'),
       (17, '🎅 Christmas', '#009933'),
       (18, '🥷 Len Kabasinski', '#121212'),
       (19, 'Cameron Mitchell', '#34de53')
;

insert into tags_on_videos(video_id, tag_id)
values
    -- Years
    -- 2013
    (1, 1),
    (2, 1),
    (3, 1),
    (4, 1),
    (5, 1),
    (6, 1),
    (7, 1),
    (8, 1),
    (9, 1),
    (10, 1),
    (11, 1),
    (12, 1),
    (13, 1),
    (14, 1),
    -- 2014
    (15, 2),
    (16, 2),
    (17, 2),
    (18, 2),
    (19, 2),
    (20, 2),
    -- Wheel
    (5, 13),
    (8, 13),
    (12, 13),
    (16, 13),
    (19, 13),
    -- Colin/Jim from Canada
    (9, 14),
    (20, 14),
    -- Halloween
    (11, 15),
    -- Sequel show
    (13, 16),
    -- Christmas
    (14, 17),
    -- Len Kabasinski
    (11, 18),
    (18, 18),
    -- Cameron Mitchell
    (20, 19)
;