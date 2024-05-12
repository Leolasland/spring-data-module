CREATE TABLE author
(
    id         serial NOT NULL,
    first_name VARCHAR(255),
    last_name  VARCHAR(255),
    phone      VARCHAR(255),
    CONSTRAINT pk_author PRIMARY KEY (id)
);

CREATE TABLE author_book
(
    author_id BIGINT NOT NULL,
    book_id   BIGINT NOT NULL,
    CONSTRAINT pk_author_book PRIMARY KEY (author_id, book_id)
);

ALTER TABLE author_book
    ADD CONSTRAINT fk_autboo_on_author FOREIGN KEY (author_id) REFERENCES author (id);

ALTER TABLE author_book
    ADD CONSTRAINT fk_autboo_on_book FOREIGN KEY (book_id) REFERENCES book (id);