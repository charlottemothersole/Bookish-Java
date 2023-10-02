CREATE TABLE copy (
    id SERIAL PRIMARY KEY,
    checked_out_by VARCHAR(100) NULL,
    book_id INT REFERENCES book(id)
);
