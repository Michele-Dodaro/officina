CREATE TYPE state AS ENUM (
    'ARRIVATO',
    'ACCETTATO',
    'IN LAVORAZIONE',
    'PRONTO'
);

CREATE TABLE customer (
    id serial PRIMARY KEY,
    first_name text NOT NULL,
    last_name text NOT NULL
);

CREATE TABLE car (
    id serial PRIMARY KEY,
    id_customer integer NOT NULL,
    plate text NOT NULL,
    arrive timestamp NOT NULL DEFAULT CURRENT_DATE,
    state state NOT NULL DEFAULT 'ARRIVATO',
    start_check timestamp,
    end_check timestamp,
    withdraw timestamp,
    CONSTRAINT fk_customer FOREIGN KEY (id_customer) REFERENCES customer (id),
    CONSTRAINT ck_plate CHECK (length(plate) = 7)
);

INSERT INTO customer (first_name, last_name) VALUES
('Marco', 'Rossi'),
('Laura', 'Bianchi'),
('Giuseppe', 'Verdi'),
('Francesca', 'Russo'),
('Alessandro', 'Ferrari'),
('Chiara', 'Esposito'),
('Luca', 'Romano'),
('Elena', 'Colombo'),
('Matteo', 'Ricci'),
('Sofia', 'Marino');

INSERT INTO car (id_customer, plate, arrive, state, start_check, end_check, withdraw) VALUES
(1, 'GA123BC', '2026-11-16 08:30:00', 'PRONTO', '2026-11-16 09:00:00', '2026-11-16 11:30:00', '2026-11-16 12:15:00'),
(1, 'FZ987XY', '2026-11-16 14:00:00', 'ARRIVATO', NULL, NULL, NULL),
(2, 'GH456DE', '2026-11-16 09:15:00', 'IN_LAVORAZIONE', '2026-11-16 10:00:00', NULL, NULL),
(3, 'FR321ZW', '2026-11-16 10:45:00', 'ACCETTATO', NULL, NULL, NULL),
(3, 'FN901KL', '2026-11-16 15:00:00', 'ARRIVATO', NULL, NULL, NULL),
(4, 'GL789MN', '2026-11-15 15:20:00', 'PRONTO', '2026-11-16 08:30:00', '2026-11-16 10:45:00', NULL),
(5, 'GB654PQ', '2026-11-16 11:10:00', 'IN_LAVORAZIONE', '2026-11-16 11:45:00', NULL, NULL),
(6, 'GE112RS', '2026-11-16 13:30:00', 'ARRIVATO', NULL, NULL, NULL),
(7, 'FT889TV', '2026-11-14 09:00:00', 'PRONTO', '2026-11-14 09:30:00', '2026-11-14 16:00:00', '2026-11-14 17:30:00'),
(8, 'GK554UV', '2026-11-16 12:00:00', 'ACCETTATO', NULL, NULL, NULL),
(9, 'GC332WX', '2026-11-16 08:00:00', 'PRONTO', '2026-11-16 08:15:00', '2026-11-16 09:45:00', '2026-11-16 10:15:00'),
(10, 'GD776YZ', '2026-11-16 14:30:00', 'IN_LAVORAZIONE', '2026-11-16 14:45:00', NULL, NULL);