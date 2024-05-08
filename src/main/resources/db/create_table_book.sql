CREATE TABLE IF NOT EXISTS books
(
    id       serial PRIMARY KEY,
    name     VARCHAR(255) NOT NULL,
    language VARCHAR(255) NOT NULL,
    category VARCHAR(255) NOT NULL
);