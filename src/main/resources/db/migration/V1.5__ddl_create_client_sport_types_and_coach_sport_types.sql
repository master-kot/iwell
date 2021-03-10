DROP TABLE IF EXISTS gofit.coach_sport_types;

CREATE TABLE gofit.coach_sport_types
(
    coach_profile_id        bigint NOT NULL,
    sport_type_id           smallint NOT NULL,
    PRIMARY KEY (coach_profile_id, sport_type_id),
    FOREIGN KEY (coach_profile_id) REFERENCES coach_profiles (id),
    FOREIGN KEY (sport_type_id) REFERENCES sport_types (id)
);

DROP TABLE IF EXISTS gofit.client_sport_types;

CREATE TABLE gofit.client_sport_types
(
    client_profile_id        bigint NOT NULL,
    sport_type_id           smallint NOT NULL,
    PRIMARY KEY (client_profile_id, sport_type_id),
    FOREIGN KEY (client_profile_id) REFERENCES client_profiles (id),
    FOREIGN KEY (sport_type_id) REFERENCES sport_types (id)
);