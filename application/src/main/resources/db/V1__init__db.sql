CREATE TABLE company
(
    name             VARCHAR NOT NULL,
    CONSTRAINT company_pk PRIMARY KEY (name)
);
CREATE TABLE product
(
    id     SERIAL,
    name   VARCHAR NOT NULL,
    company_name VARCHAR  NOT NULL REFERENCES company (name) ON UPDATE CASCADE ON DELETE CASCADE,
    amount int,
    CONSTRAINT invoices_pk PRIMARY KEY (id)
);