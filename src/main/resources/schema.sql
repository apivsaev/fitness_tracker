create table user
(
   id bigint auto_increment primary key,
   name varchar(255) not null,
   age integer not null
);

create table exercise
(
   id bigint auto_increment primary key,
   name varchar(255) not null,
   description varchar(1000)
);

create table training
(
   id bigint auto_increment primary key,
   date timestamp not null,
   calories integer,
   user_id bigint not null,
   foreign key (user_id) references user(id) on delete cascade
);

create table set
(
   id bigint auto_increment primary key,
   repeat int,
   duration int,
   weight double(2),
   exercise_id bigint not null,
   training_id bigint not null,
   foreign key (exercise_id) references exercise(id),
   foreign key (training_id) references training(id) on delete cascade
);

-- set.duration - duration in seconds
-- set.weight - weight in kg