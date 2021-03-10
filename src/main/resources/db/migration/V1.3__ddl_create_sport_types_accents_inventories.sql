DROP TABLE IF EXISTS gofit.sport_types;

CREATE TABLE gofit.sport_types (
    id                  smallserial NOT NULL UNIQUE,
    description varchar(50) NOT NULL,
    CONSTRAINT sport_types_pk PRIMARY KEY (id)
);

DROP TABLE IF EXISTS gofit.accents;

CREATE TABLE gofit.accents (
    id                  smallserial NOT NULL UNIQUE,
    description         varchar(150) NOT NULL UNIQUE,
    CONSTRAINT accents_pk PRIMARY KEY (id)
);

DROP TABLE IF EXISTS gofit.inventories;

CREATE TABLE gofit.inventories (
    id                  smallserial NOT NULL UNIQUE,
    description         varchar(100) NOT NULL UNIQUE,
    CONSTRAINT inventory_pk PRIMARY KEY (id)
);