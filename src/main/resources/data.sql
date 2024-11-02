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
       (11, 'Skull Forest', 'Night Beast, Trick or Treat, and Skull Forest')
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
       (14, '🇨🇦 Colin from Canada', '#d80621'),
       (15, 'Gillian', '#95f90a'),
       (16, '🎃 Halloween Spooktacular', '#ff6600')
;

insert into tags_on_videos(video_id, tag_id)
values
    -- Years
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
    -- Wheel
    (5, 13),
    (8, 13),
    -- Colin from Canada
    (9, 14),
    -- Gillian
    (10, 15),
    -- Halloween Spooktacular
    (11, 16)
;