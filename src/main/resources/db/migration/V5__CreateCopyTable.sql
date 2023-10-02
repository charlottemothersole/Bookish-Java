DROP TABLE if exists copy;

CREATE TABLE copy (
    id SERIAL PRIMARY KEY,
    checked_out_by INT NULL REFERENCES member(id),
    book_id INT REFERENCES book(id)
);