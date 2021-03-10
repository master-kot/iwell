DROP TABLE IF EXISTS gofit.feedbacks;

CREATE TABLE gofit.feedbacks (
    id                  bigserial NOT NULL UNIQUE,
    name                varchar(50),
    phone               varchar(20),
    email               varchar(50) NOT NULL,
    message             varchar(500) NOT NULL,
    prefer_phone        boolean,
    prefer_email        boolean,
    prefer_whatsapp     boolean,
    prefer_telegram     boolean,
    PRIMARY KEY (id)
);