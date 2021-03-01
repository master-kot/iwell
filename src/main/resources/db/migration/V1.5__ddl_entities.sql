
alter table users add address VARCHAR(255),
    add    birthday_date VARCHAR(255),
    add gender        VARCHAR(255),
    add last_name     VARCHAR(255),
    add phone         VARCHAR(255),
    add photo_link    VARCHAR(255),
    add user_info     VARCHAR(255);

create table coach_training_rel (coach_id int8 not null, training_id int8 not null);
create table coaches (id  bigserial not null, address varchar(255), birthday_date varchar(255), couch_info varchar(255), enabled boolean not null, first_name varchar(255), gender varchar(255), last_name varchar(255), password varchar(255), phone varchar(255), photo_link varchar(255), user_name varchar(255) not null, primary key (id));
create table schedulers (id  bigserial not null, end_event TIMESTAMP, start_event TIMESTAMP, coach_id int8 not null, training_id int8 not null, primary key (id));
create table subscriptions (id  bigserial not null, count_visits int4, kind_service varchar(255), price_subscription numeric(19, 2) not null, training_name varchar(255) not null, primary key (id));
create table trainings (id  bigserial not null, kind_of_training varchar(255), primary key (id));
create table visits (id  bigserial not null, card_id int8 not null, scheduled_id int8 not null, primary key (id));
create table cards (id  bigserial not null, lost_visits int4, time_start TIMESTAMP, time_stop TIMESTAMP, subscription_id int8 not null, user_id int8 not null, primary key (id));

alter table if exists coaches add constraint UK_f9dine2jwdvmykkbosdf1d5b6 unique (user_name);
alter table if exists users add constraint UK_k8d0f2n7n88w1a16yhua64onx unique (user_name);
alter table if exists coach_training_rel add constraint FKspx5dte7djnmy382mwirttowk foreign key (training_id) references trainings;
alter table if exists coach_training_rel add constraint FK4j51me65ohmfw17aah0021j1p foreign key (coach_id) references trainings;
alter table if exists schedulers add constraint FKnmhiry353uacugk6u6nkjyft8 foreign key (coach_id) references coaches;
alter table if exists schedulers add constraint FKebwewn6r2o86xgkuojiu7bwi1 foreign key (training_id) references trainings;
alter table if exists visits add constraint FK4y6u6tsx208u14n24v71e0hig foreign key (card_id) references cards;
alter table if exists visits add constraint FK6ab51ep0kll1p7qqn77i1vei4 foreign key (scheduled_id) references schedulers;
alter table if exists сards add constraint FK1idda3lnul8uvs1ww7f9utnal foreign key (subscription_id) references subscriptions;
alter table if exists сards add constraint FK8ts4tign0ipn53tx80xxk7eew foreign key (user_id) references users;

