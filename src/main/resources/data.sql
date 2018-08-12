insert into user (name, age) values('Alex', 25);
insert into user (name, age) values('Petr', 30);
insert into user (name, age) values('Bob', 35);

insert into exercise (name) values ('Bench press');
insert into exercise (name) values ('Squats');
insert into exercise (name) values ('Abdominal crunches');
insert into exercise (name) values ('Dead lift');
insert into exercise (name) values ('Plank');
insert into exercise (name) values ('Bicep curls');

insert into training (date, user_id, calories) values (current_timestamp, 1, 1000);
insert into training (date, user_id, calories) values (current_timestamp, 2, 2000);
insert into training (date, user_id, calories) values (current_timestamp, 3, 3000);

insert into set (training_id, exercise_id, repeat, weight) values (1, 1, 5, 80);
insert into set (training_id, exercise_id, repeat, weight) values (1, 1, 5, 80);
insert into set (training_id, exercise_id, repeat, weight) values (1, 1, 5, 80);
insert into set (training_id, exercise_id, repeat, weight) values (1, 6, 12, 20);
insert into set (training_id, exercise_id, repeat, weight) values (1, 6, 10, 20);
insert into set (training_id, exercise_id, repeat, weight) values (1, 6, 8, 20);
insert into set (training_id, exercise_id, duration) values (1, 5, 180);
insert into set (training_id, exercise_id, duration) values (1, 5, 150);
insert into set (training_id, exercise_id, duration) values (1, 5, 125);

insert into set (training_id, exercise_id, repeat, weight) values (2, 1, 5, 90);
insert into set (training_id, exercise_id, repeat, weight) values (2, 1, 5, 90);
insert into set (training_id, exercise_id, repeat, weight) values (2, 1, 5, 90);
insert into set (training_id, exercise_id, repeat, weight) values (2, 2, 8, 120);
insert into set (training_id, exercise_id, repeat, weight) values (2, 2, 8, 120);
insert into set (training_id, exercise_id, repeat, weight) values (2, 2, 8, 120);
insert into set (training_id, exercise_id, duration) values (2, 5, 180);
insert into set (training_id, exercise_id, duration) values (2, 5, 180);
insert into set (training_id, exercise_id, duration) values (2, 5, 155);