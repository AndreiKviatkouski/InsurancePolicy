CREATE TABLE IF NOT EXISTS client_passport
(
    id                INTEGER PRIMARY KEY,
    series_and_number VARCHAR(255) NOT NULL,
    registration_date date         NOT NULL
);



CREATE TABLE IF NOT EXISTS client_address
(
    id     INTEGER PRIMARY KEY,
    city   TEXT     NOT NULL,
    street TEXT     NOT NULL,
    home   VARCHAR(255) NOT NULL,
    flat   VARCHAR(255) NOT NULL
);


CREATE TABLE IF NOT EXISTS client
(
    id                 INTEGER PRIMARY KEY,
    first_name         VARCHAR(255)                                                         NOT NULL,
    last_name          VARCHAR(255)                                                         NOT NULL,
    birth_day          date                                                                 NOT NULL,
    email              TEXT                                                                 NOT NULL,
    phone              TEXT                                                                 NOT NULL,
    passport_id        BIGINT REFERENCES client_passport (id) DEFERRABLE INITIALLY DEFERRED NOT NULL,
    address_id         BIGINT REFERENCES client_address (id) DEFERRABLE INITIALLY DEFERRED  NOT NULL,
    driving_experience TEXT                                                                 NOT NULL
);



INSERT INTO client_passport
VALUES (1, 'MR123456', '10-10-2000'),
       (2, 'MR123459', '10-10-2010');


INSERT INTO client_address
VALUES (1, 'Minsk', 'Platonova', '10', '10'),
       (2, 'Minsk', 'Nezavisimosti', '7', '189');


INSERT INTO client
VALUES (1, 'Vaso', 'Petrov', '10-10-1990', 'vpetrov@jr.com', '+375 (29) 322-22-33)', 1, 1, '2'),
       (2, 'Petr', 'Sidorov', '08-10-2000', 'sidorov@jr.com', '+375 (29) 422-22-33)', 2, 2, '3');


