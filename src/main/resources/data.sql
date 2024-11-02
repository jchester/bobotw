-- @formatter:off
insert into videos(id, title, episode_title) values (1, 'Russian Terminator', 'Episode 1');
insert into videos(id, title, episode_title) values (2, 'The New Gladiators', 'The New Gladiators, Exterminator 2, and The Aftermath');
insert into videos(id, title, episode_title) values (3, 'Xtro', 'The Killer Eye, They Bite, and Xtro');
insert into videos(id, title, episode_title) values (4, 'Miami Connection', 'Deadly Prey, Hard Ticket to Hawaii, and Miami Connection');

insert into rankers(id) values ('C5C8C703-5730-4511-BA55-224DD955E20D');

insert into pair_rankings(ranker_id, winner_id, loser_id) values ('C5C8C703-5730-4511-BA55-224DD955E20D', 1, 3);
insert into pair_rankings(ranker_id, winner_id, loser_id) values ('C5C8C703-5730-4511-BA55-224DD955E20D', 1, 4);
insert into pair_rankings(ranker_id, winner_id, loser_id) values ('C5C8C703-5730-4511-BA55-224DD955E20D', 3, 2);

