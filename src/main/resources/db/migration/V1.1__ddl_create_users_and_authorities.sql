CREATE SCHEMA IF NOT EXISTS gofit;

DROP TABLE IF EXISTS gofit.users;

CREATE TABLE gofit.users
(
    id              BIGSERIAL NOT NULL UNIQUE,
    user_name       VARCHAR(50) NOT NULL UNIQUE,
    password        VARCHAR(150) NOT NULL,
    enabled         BOOLEAN NOT NULL,
    first_name      VARCHAR(50),
    last_name       varchar(50),
    address         varchar(100),
    phone           varchar(20),
    birthday_date   timestamp,
    gender          smallint NOT NULL,
    photo_link      varchar(100),
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS gofit.authorities;

CREATE TABLE gofit.authorities
(
    id              SMALLSERIAL,
    authority       VARCHAR(50) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS gofit.users_authorities;

CREATE TABLE gofit.users_authorities
(
    user_id         BIGINT,
    authority_id    SMALLINT,
    PRIMARY KEY (user_id, authority_id),
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (authority_id) REFERENCES authorities (id)
);
