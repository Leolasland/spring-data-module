CREATE TABLE address
(
    id        serial NOT NULL,
    city      VARCHAR(255),
    street    VARCHAR(255),
    author_id BIGINT,
    CONSTRAINT pk_address PRIMARY KEY (id)
);

ALTER TABLE address
    ADD CONSTRAINT FK_ADDRESS_ON_AUTHOR FOREIGN KEY (author_id) REFERENCES author (id);