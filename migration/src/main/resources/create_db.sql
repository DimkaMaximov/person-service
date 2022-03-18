DROP VIEW IF EXISTS person_info;

DROP TABLE IF EXISTS illness;
DROP TABLE IF EXISTS person_data;
DROP TABLE IF EXISTS address;
DROP TABLE IF EXISTS medical_card;
DROP TABLE IF EXISTS contact;

DROP SEQUENCE IF EXISTS contact_seq;
DROP SEQUENCE IF EXISTS medical_card_seq;
DROP SEQUENCE IF EXISTS address_seq;
DROP SEQUENCE IF EXISTS person_data_seq;
DROP SEQUENCE IF EXISTS illness_seq;

CREATE SEQUENCE contact_seq START WITH 1 INCREMENT 1;
CREATE SEQUENCE medical_card_seq START WITH 1;
CREATE SEQUENCE address_seq START WITH 1;
CREATE SEQUENCE person_data_seq START WITH 1;
CREATE SEQUENCE illness_seq START WITH 1;

CREATE TABLE contact
(
    id  BIGINT PRIMARY KEY DEFAULT nextval('contact_seq'),
    phone_number    VARCHAR(32)     NOT NULL,
    email           VARCHAR(128)    UNIQUE,
    profile_link    TEXT            UNIQUE
);

CREATE TABLE medical_card
(
    id BIGINT PRIMARY KEY DEFAULT nextval('medical_card_seq'),
    client_status   CHAR (10),
    med_status      CHAR (10),
    registry_dt     DATE    NOT NULL,
    comment         TEXT
);

CREATE TABLE address
(
    id BIGINT PRIMARY KEY DEFAULT nextval('address_seq'),
    contact_id      BIGINT         NOT NULL,
    country_id      BIGINT         NOT NULL,
    city            VARCHAR(255)   NOT NULL,
    index           INTEGER,
    street          VARCHAR(255)   NOT NULL,
    building        VARCHAR(32)    NOT NULL,
    flat            VARCHAR(32),
    FOREIGN KEY (contact_id) REFERENCES contact(id)
);

CREATE TABLE person_data
(
    id BIGINT PRIMARY KEY DEFAULT nextval('person_data_seq'),
    last_name       VARCHAR(255)    NOT NULL,
    first_name      VARCHAR(255)    NOT NULL,
    birth_dt        DATE            NOT NULL,
    age             SMALLINT,
    sex             CHAR            NOT NULL,
    contact_id      BIGINT          NOT NULL,
    medical_card_id BIGINT          NOT NULL,
    parent_id       BIGINT,
    FOREIGN KEY (contact_id) REFERENCES contact(id),
    FOREIGN KEY (medical_card_id) REFERENCES medical_card(id),
    FOREIGN KEY (parent_id) REFERENCES person_data(id)
);

CREATE TABLE illness
(
    id BIGINT PRIMARY KEY DEFAULT nextval('illness_seq'),
    medical_card_id BIGINT          NOT NULL,
    type_id         BIGINT,
    heaviness       CHAR(10),
    appearance_dttm TIMESTAMP       NOT NULL,
    recovery_dt     DATE,
    FOREIGN KEY (medical_card_id) REFERENCES medical_card(id)
);