-- @formatter:off
insert into episodes(id, title) values (1, 'Episode 1');
insert into episodes(id, title) values (2, 'The New Gladiators, Exterminator 2, and The Aftermath');
insert into episodes(id, title) values (3, 'The Killer Eye, They Bite, and Xtro');
insert into episodes(id, title) values (4, 'Deadly Prey, Hard Ticket to Hawaii, and Miami Connection');
insert into episodes(id, title) values (5, 'The Wheel of the Worst');
insert into episodes(id, title) values (6, 'The Vindicator, Cyber Tracker, Robot Jox, and R.O.T.O.R.');
insert into episodes(id, title) values (7, 'Playing Dangerous, Shapeshifter, and Thunderpants');
insert into episodes(id, title) values (8, 'Wheel of the Worst #2');
insert into episodes(id, title) values (9, 'V-World Matrix, The Amazing Bulk, and ????');
insert into episodes(id, title) values (10, 'Bloody Birthday, Crazy Fat Ethel II, and Psycho From Texas');


insert into videos(id, title, episode_id) values (1, 'Russian Terminator', 1);
insert into videos(id, title, episode_id) values (2, 'The New Gladiators', 2);
insert into videos(id, title, episode_id) values (3, 'The Aftermath', 2);
insert into videos(id, title, episode_id) values (4, 'Xtro', 3);
insert into videos(id, title, episode_id) values (5, 'Miami Connection', 4);

insert into rankers(id) values ('C5C8C703-5730-4511-BA55-224DD955E20D');

insert into pair_rankings(winner_id, loser_id, ranker_id) values (1, 3, 'C5C8C703-5730-4511-BA55-224DD955E20D');
insert into pair_rankings(winner_id, loser_id, ranker_id) values (1, 4, 'C5C8C703-5730-4511-BA55-224DD955E20D');
insert into pair_rankings(winner_id, loser_id, ranker_id) values (3, 2, 'C5C8C703-5730-4511-BA55-224DD955E20D');

