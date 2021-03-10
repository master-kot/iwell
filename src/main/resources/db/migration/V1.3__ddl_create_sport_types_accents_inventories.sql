DROP TABLE IF EXISTS sport_types;

CREATE TABLE sport_types (
    id                  smallserial NOT NULL UNIQUE,
    description varchar(50) NOT NULL,
    CONSTRAINT sport_types_pk PRIMARY KEY (id)
);

DROP TABLE IF EXISTS accents;

CREATE TABLE accents (
    id                  smallserial NOT NULL UNIQUE,
    description         varchar(150) NOT NULL UNIQUE,
    CONSTRAINT accents_pk PRIMARY KEY (id)
);

DROP TABLE IF EXISTS inventories;

CREATE TABLE inventories (
    id                  smallserial NOT NULL UNIQUE,
    description         varchar(100) NOT NULL UNIQUE,
    CONSTRAINT inventory_pk PRIMARY KEY (id)
);