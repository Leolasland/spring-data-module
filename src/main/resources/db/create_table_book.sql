CREATE TABLE book
(
    id          serial PRIMARY KEY,
    title       VARCHAR(255),
    language    VARCHAR(255),
    category_id BIGINT  NOT NULL,
    active      BOOLEAN NOT NULL
);

ALTER TABLE book
    ADD CONSTRAINT FK_BOOK_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES category (id);