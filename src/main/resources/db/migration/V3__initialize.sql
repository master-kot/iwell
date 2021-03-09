CREATE SCHEMA IF NOT EXISTS public;

CREATE TABLE public.coach_profiles (
                                       id bigserial NOT NULL,
                                       coach_info varchar(500),
                                       sports_achivments varchar(150),
                                       sports_grade varchar(150),
                                       completed_trainings_amount integer NOT NULL,
                                       rating float,
                                       money_amount integer NOT NULL,
                                       user_id bigserial NOT NULL,
                                       CONSTRAINT couhes_pk PRIMARY KEY (id)

);

CREATE TABLE public.traininings (
                                    id bigserial NOT NULL,
                                    name varchar(50),
                                    start_date_time timestamp NOT NULL,
                                    end_date_time timestamp NOT NULL,
                                    sport_level_id smallint NOT NULL,
                                    video_link varchar(150),
                                    capacity smallint NOT NULL,
                                    duration smallint NOT NULL,
                                    was_completed boolean NOT NULL,
                                    comment varchar(100),
                                    coach_profile_id bigint,
                                    subscription_id bigint,
                                    client_profile_id bigint,
                                    sport_type_id smallint,
                                    CONSTRAINT shedules_pk PRIMARY KEY (id)

);

CREATE TABLE public.client_profiles (
                                        id bigserial NOT NULL,
                                        user_info varchar(500),
                                        sports_achivments varchar(150),
                                        sports_grade varchar(150),
                                        CONSTRAINT clients_pk PRIMARY KEY (id)

);

CREATE TABLE public.subscriptions (
                                      id bigserial NOT NULL,
                                      start_date_time timestamp NOT NULL,
                                      end_date_time timestamp NOT NULL,
                                      initial_unit_amount smallint NOT NULL,
                                      remaining_unit_amount smallint NOT NULL,
                                      total_price integer NOT NULL,
                                      unit_price integer NOT NULL,
                                      duration smallint NOT NULL,
                                      client_profile_id bigint,
                                      CONSTRAINT subscriptions_pk PRIMARY KEY (id)

);

CREATE TABLE public.users (
                              id bigserial NOT NULL,
                              user_name varchar(50) NOT NULL,
                              password varchar(150) NOT NULL,
                              enabled boolean NOT NULL,
                              first_name varchar(50) NOT NULL,
                              last_name varchar(50) NOT NULL,
                              adress varchar(100) ,
                              birthday_date date NOT NULL,
                              gender smallint NOT NULL,
                              photo_link varchar(100),
                              phone varchar(20) ,
                              client_profile_id bigint,
                              coach_profile_id bigint,
                              CONSTRAINT users_pk PRIMARY KEY (id)

);

CREATE TABLE public.inventories (
                                    id smallint NOT NULL,
                                    description varchar(100),
                                    trainining_id bigint,
                                    CONSTRAINT inventory_pk PRIMARY KEY (id)

);

ALTER TABLE public.inventories ADD CONSTRAINT traininings_fk FOREIGN KEY (trainining_id)
    REFERENCES public.traininings (id) MATCH FULL
    ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE public.traininings ADD CONSTRAINT coach_profiles_fk FOREIGN KEY (coach_profile_id)
    REFERENCES public.coach_profiles (id) MATCH FULL
    ON DELETE SET NULL ON UPDATE CASCADE;

CREATE TABLE public.accents (
                                id smallserial NOT NULL,
                                description varchar(150) NOT NULL,
                                trainining_id bigint,
                                CONSTRAINT accents_pk PRIMARY KEY (id)

);

ALTER TABLE public.accents ADD CONSTRAINT traininings_fk FOREIGN KEY (trainining_id)
    REFERENCES public.traininings (id) MATCH FULL
    ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE public.users ADD CONSTRAINT client_profiles_fk FOREIGN KEY (client_profile_id)
    REFERENCES public.client_profiles (id) MATCH FULL
    ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE public.users ADD CONSTRAINT users_uq UNIQUE (client_profile_id);

ALTER TABLE public.users ADD CONSTRAINT coach_profiles_fk FOREIGN KEY (coach_profile_id)
    REFERENCES public.coach_profiles (id) MATCH FULL
    ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE public.users ADD CONSTRAINT users_uq1 UNIQUE (coach_profile_id);

ALTER TABLE public.traininings ADD CONSTRAINT subscriptions_fk FOREIGN KEY (subscription_id)
    REFERENCES public.subscriptions (id) MATCH FULL
    ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE public.subscriptions ADD CONSTRAINT client_profiles_fk FOREIGN KEY (client_profile_id)
    REFERENCES public.client_profiles (id) MATCH FULL
    ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE public.traininings ADD CONSTRAINT client_profiles_fk FOREIGN KEY (client_profile_id)
    REFERENCES public.client_profiles (id) MATCH FULL
    ON DELETE SET NULL ON UPDATE CASCADE;

CREATE TABLE public.sport_types (
                                    id smallint NOT NULL,
                                    description varchar(50) NOT NULL,
                                    CONSTRAINT sport_types_pk PRIMARY KEY (id)

);

CREATE TABLE public.sport_levels (
                                     id smallint NOT NULL,
                                     description varchar(50) NOT NULL,
                                     CONSTRAINT sport_level_pk PRIMARY KEY (id)

);

ALTER TABLE public.traininings ADD CONSTRAINT sport_types_fk FOREIGN KEY (sport_type_id)
    REFERENCES public.sport_types (id) MATCH FULL
    ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE public.traininings ADD CONSTRAINT sport_levels_fk FOREIGN KEY (sport_type_id)
    REFERENCES public.sport_levels (id) MATCH FULL
    ON DELETE SET NULL ON UPDATE CASCADE;

CREATE TABLE public.coach_sport_types (
                                          coach_profile_id bigint NOT NULL,
                                          sport_type_id smallint NOT NULL
);

ALTER TABLE public.coach_sport_types ADD CONSTRAINT coach_profiles_fk FOREIGN KEY ( coach_profile_id)
    REFERENCES public.coach_profiles (id) MATCH FULL
    ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE public.coach_sport_types ADD CONSTRAINT sport_types_fk FOREIGN KEY (sport_type_id)
    REFERENCES public.sport_types (id) MATCH FULL
    ON DELETE SET NULL ON UPDATE CASCADE;

CREATE TABLE public.income_coach_transactions (
                                                 id bigserial NOT NULL,
                                                 date_time timestamp NOT NULL,
                                                 coach_profile_id bigint,
                                                 CONSTRAINT income_coach_transaction_pk PRIMARY KEY (id)

);

ALTER TABLE public.income_coach_transactions ADD CONSTRAINT coach_profiles_fk FOREIGN KEY (coach_profile_id)
    REFERENCES public.coach_profiles (id) MATCH FULL
    ON DELETE SET NULL ON UPDATE CASCADE;

CREATE TABLE public.outcome_coach_transactions (
                                                   id bigserial NOT NULL,
                                                   date_time timestamp NOT NULL,
                                                   account varchar(100),
                                                   coach_profile_id bigint,
                                                   CONSTRAINT outcome_coach_transactions_pk PRIMARY KEY (id)

);

ALTER TABLE public.outcome_coach_transactions ADD CONSTRAINT coach_profiles_fk FOREIGN KEY (coach_profile_id)
    REFERENCES public.coach_profiles (id) MATCH FULL
    ON DELETE SET NULL ON UPDATE CASCADE;

CREATE TABLE public.reviews (
                                id integer NOT NULL,
                                text varchar(500) NOT NULL,
                                rating smallint NOT NULL,
                                coach_profile_id bigint NOT NULL,
                                client_profile_id bigint NOT NULL,
                                CONSTRAINT reviews_pk PRIMARY KEY (id)

);

ALTER TABLE public.reviews ADD CONSTRAINT coach_profiles_fk FOREIGN KEY (coach_profile_id)
    REFERENCES public.coach_profiles (id) MATCH FULL
    ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE public.reviews ADD CONSTRAINT client_profiles_fk FOREIGN KEY (client_profile_id)
    REFERENCES public.client_profiles (id) MATCH FULL
    ON DELETE SET NULL ON UPDATE CASCADE;

CREATE TABLE public.client_transactions (
                                           id bigserial NOT NULL,
                                           date_time timestamptz NOT NULL,
                                           client_profile_id bigint,
                                           CONSTRAINT client_transaction_pk PRIMARY KEY (id)

);

ALTER TABLE public.client_transactions ADD CONSTRAINT client_profiles_fk FOREIGN KEY (client_profile_id)
    REFERENCES public.client_profiles (id) MATCH FULL
    ON DELETE SET NULL ON UPDATE CASCADE;

CREATE TABLE public.client_sport_types (
                                           client_profile_id bigint NOT NULL,
                                           sport_type_id smallint NOT NULL
);

ALTER TABLE public.client_sport_types ADD CONSTRAINT client_profiles_fk FOREIGN KEY (client_profile_id)
    REFERENCES public.client_profiles (id) MATCH FULL
    ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE public.client_sport_types ADD CONSTRAINT sport_types_fk FOREIGN KEY (sport_type_id)
    REFERENCES public.sport_types (id) MATCH FULL
    ON DELETE SET NULL ON UPDATE CASCADE;

CREATE TABLE public.users_authorities (
                                          authority_id smallint NOT NULL,
                                          user_id bigint NOT NULL
);

CREATE TABLE public.authorities (
                                    id smallint NOT NULL,
                                    authority varchar(50) NOT NULL,
                                    CONSTRAINT authorities_pk PRIMARY KEY (id)

);

ALTER TABLE public.users_authorities ADD CONSTRAINT authorities_fk FOREIGN KEY (authority_id)
    REFERENCES public.authorities (id) MATCH FULL
    ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE public.users_authorities ADD CONSTRAINT users_fk FOREIGN KEY (user_id)
    REFERENCES public.users (id) MATCH FULL
    ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE public.coach_profiles ADD CONSTRAINT users_fk FOREIGN KEY (user_id)
    REFERENCES public.users (id) MATCH FULL
    ON DELETE SET NULL ON UPDATE CASCADE;

-- ALTER TABLE public.users ADD CONSTRAINT coach_profiles_fk FOREIGN KEY (coach_profiles_id)
--      REFERENCES public.coach_profiles (id) MATCH FULL
--      ON DELETE SET NULL ON UPDATE CASCADE;

INSERT INTO public.users
( id, user_name, password, enabled, birthday_date, first_name, last_name, gender, photo_link)
VALUES
(1,  'admin', '$2a$10$ArsakpPHT5jPbPEAeVc/lup1V4tJS9hqaa1PfRNIUy459JkPjK5xS', true, '2001-02-03', 'Иван', 'Иванов', 2, 'myfoto.png'),
(2, 'user', '$2a$10$7v8.w1xVYIu6TKY3a58CX.xcmSXPpW6mVLTqB11kAn10jezppGdE2', true, '2003-04-05',  'Катя', 'Петрова', 1,  'katya.png');

INSERT INTO public.authorities
(id, authority)
VALUES
(1, 'ROLE_ADMIN'),
( 2, 'ROLE_USER');

INSERT INTO public.users_authorities
(user_id, authority_id)
VALUES
(1, 2),
(2, 1);