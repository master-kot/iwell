DROP TABLE IF EXISTS coach_profiles;

CREATE TABLE coach_profiles (
    id                  bigserial NOT NULL UNIQUE,
    user_id             bigint NOT NULL,
    coach_info          varchar(500),
    sports_achivments   varchar(150),
    sports_grade        varchar(150),
    training_amount     integer NOT NULL,
    rating              float,
    money_amount        integer NOT NULL,
    CONSTRAINT couches_pk PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
);

DROP TABLE IF EXISTS client_profiles;

CREATE TABLE client_profiles (
    id                  bigserial NOT NULL UNIQUE,
    user_id             bigint NOT NULL,
    user_info           varchar(500),
    sports_achivments   varchar(150),
    sports_grade        varchar(150),
    CONSTRAINT clients_pk PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE reviews (
    id                  serial NOT NULL UNIQUE,
    text                varchar(500) NOT NULL,
    rating              smallint NOT NULL,
    coach_profile_id    bigint NOT NULL,
    client_profile_id   bigint NOT NULL,
    CONSTRAINT reviews_pk PRIMARY KEY (id),
    FOREIGN KEY (coach_profile_id) REFERENCES coach_profiles (id),
    FOREIGN KEY (client_profile_id) REFERENCES client_profiles (id)
);