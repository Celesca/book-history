DROP TABLE IF EXISTS inventory CASCADE;

CREATE TABLE inventory (
    id SERIAL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    author VARCHAR(100) NOT NULL,
    image VARCHAR(100) NOT NULL
);

INSERT INTO inventory (title, author, image) VALUES ('The Great Gatsby', 'F. Scott Fitzgerald', 'https://images-na.ssl-images-amazon.com/images/I/51ZQb8v3VHL._SX331_BO1,204,203,200_.jpg');