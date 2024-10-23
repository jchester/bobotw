-- @formatter:off
insert into episodes(id, title) values (1, 'Best of the Worst');
insert into episodes(id, title) values (2, 'Best of the Worst 2');
insert into episodes(id, title) values (3, 'Best of the Worst 3');
insert into episodes(id, title) values (4, 'Best of the Worst 4');

insert into videos(id, title, episode_id) values (1, 'A likely title', 1);
insert into videos(id, title, episode_id) values (2, 'Another one', 2);
insert into videos(id, title, episode_id) values (3, 'The third', 3);
insert into videos(id, title, episode_id) values (4, 'Keepsake', 4);

insert into rankers(id) values ('C5C8C703-5730-4511-BA55-224DD955E20D');

insert into pair_rankings(winner_id, loser_id, ranker_id) values (1, 3, 'C5C8C703-5730-4511-BA55-224DD955E20D');
insert into pair_rankings(winner_id, loser_id, ranker_id) values (1, 4, 'C5C8C703-5730-4511-BA55-224DD955E20D');
insert into pair_rankings(winner_id, loser_id, ranker_id) values (3, 2, 'C5C8C703-5730-4511-BA55-224DD955E20D');

