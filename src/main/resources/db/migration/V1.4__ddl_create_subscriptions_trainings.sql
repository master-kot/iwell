DROP TABLE IF EXISTS subscriptions;

CREATE TABLE subscriptions (
    id                  bigserial NOT NULL UNIQUE,
    start_date_time     timestamp NOT NULL,
    end_date_time       timestamp,
    initial_amount      smallint NOT NULL,
    remaining_amount    smallint NOT NULL,
    total_price         integer NOT NULL,
    unit_price          integer NOT NULL,
    duration            smallint NOT NULL,
    client_profile_id   bigint NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (client_profile_id) REFERENCES client_profiles (id)
);

DROP TABLE IF EXISTS traininings;

CREATE TABLE traininings (
    id                  bigserial NOT NULL UNIQUE,
    name                varchar(50),
    start_date_time     timestamp NOT NULL,
    end_date_time       timestamp,
    sport_type_id       smallint,
    sport_level_id      smallint NOT NULL,
    accent_id           smallint,
    coach_profile_id    bigint NOT NULL,
    client_profile_id   bigint,
    video_link          varchar(150),
    capacity            smallint,
    duration            smallint NOT NULL,
    subscription_id     bigint,
    was_completed       boolean NOT NULL,
    comment             varchar(100),
    PRIMARY KEY (id),
    FOREIGN KEY (sport_type_id) REFERENCES sport_types (id),
    FOREIGN KEY (accent_id) REFERENCES accents (id),
    FOREIGN KEY (coach_profile_id) REFERENCES coach_profiles (id),
    FOREIGN KEY (client_profile_id) REFERENCES client_profiles (id),
    FOREIGN KEY (subscription_id) REFERENCES subscriptions (id)
);

DROP TABLE IF EXISTS traininings_inventories;

CREATE TABLE traininings_inventories (
    trainining_id       bigint,
    inventory_id        smallint,
    PRIMARY KEY (trainining_id, inventory_id),
    FOREIGN KEY (trainining_id) REFERENCES traininings (id),
    FOREIGN KEY (inventory_id) REFERENCES inventories (id)
);