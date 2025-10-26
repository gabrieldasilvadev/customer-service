-- enable UUID extension
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- create customer table
CREATE TABLE customers
(
    id                  UUID PRIMARY KEY,
    name                VARCHAR(255)        NOT NULL,
    email               VARCHAR(255) UNIQUE NOT NULL,
    phone               VARCHAR(20) UNIQUE,
    document_identifier VARCHAR(11) UNIQUE  NOT NULL,
    created_at          TIMESTAMPTZ         NOT NULL DEFAULT NOW()
);
