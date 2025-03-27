-- schema.sql
CREATE TABLE IF NOT EXISTS groceries (
    id      VARCHAR(60)  DEFAULT RANDOM_UUID() PRIMARY KEY,
    name    VARCHAR      NOT NULL
);
