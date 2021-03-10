DROP TABLE IF EXISTS gofit.client_transactions;

CREATE TABLE gofit.client_transactions
(
    id                  bigserial NOT NULL UNIQUE,
    date_time           timestamp NOT NULL,
    client_profile_id   bigint NOT NULL,
    subscription_id     bigint NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (client_profile_id) REFERENCES client_profiles (id),
    FOREIGN KEY (subscription_id) REFERENCES subscriptions (id)
);

DROP TABLE IF EXISTS gofit.income_coach_transactions;

CREATE TABLE gofit.income_coach_transactions
(
    id                  bigserial NOT NULL UNIQUE,
    date_time           timestamp NOT NULL,
    coach_profile_id    bigint NOT NULL,
    subscription_id     bigint NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (coach_profile_id) REFERENCES coach_profiles (id),
    FOREIGN KEY (subscription_id) REFERENCES subscriptions (id)
);

DROP TABLE IF EXISTS gofit.outcome_coach_transactions;

CREATE TABLE gofit.outcome_coach_transactions
(
    id                  bigserial NOT NULL UNIQUE,
    date_time           timestamp NOT NULL,
    coach_profile_id    bigint NOT NULL,
    account             varchar(100) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (coach_profile_id) REFERENCES coach_profiles (id)
);