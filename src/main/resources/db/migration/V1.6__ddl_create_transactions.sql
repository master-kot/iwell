DROP TABLE IF EXISTS client_transactions;

CREATE TABLE client_transactions
(
    id                  bigserial NOT NULL UNIQUE,
    date_time           timestamp NOT NULL,
    client_profile_id   bigint NOT NULL,
    subscription_id     bigint NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (client_profile_id) REFERENCES client_profiles (id),
    FOREIGN KEY (subscription_id) REFERENCES subscriptions (id)
);

DROP TABLE IF EXISTS income_coach_transactions;

CREATE TABLE income_coach_transactions
(
    id                  bigserial NOT NULL UNIQUE,
    date_time           timestamp NOT NULL,
    coach_profile_id    bigint NOT NULL,
    subscription_id     bigint NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (coach_profile_id) REFERENCES coach_profiles (id),
    FOREIGN KEY (subscription_id) REFERENCES subscriptions (id)
);

DROP TABLE IF EXISTS outcome_coach_transactions;

CREATE TABLE outcome_coach_transactions
(
    id                  bigserial NOT NULL UNIQUE,
    date_time           timestamp NOT NULL,
    coach_profile_id    bigint NOT NULL,
    account             varchar(100) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (coach_profile_id) REFERENCES coach_profiles (id)
);