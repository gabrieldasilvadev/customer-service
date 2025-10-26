CREATE TYPE payment_status AS ENUM (
    'PENDING',
    'APPROVED',
    'FINISHED',
    'FAILED'
    );

CREATE TABLE payments
(
    id             UUID PRIMARY KEY,
    order_id       UUID                        NOT NULL,
    customer_id    UUID                        NOT NULL,
    payment_method VARCHAR(255)                NOT NULL,
    amount         NUMERIC(18, 4)              NOT NULL,
    status         payment_status              NOT NULL,
    created_at     TIMESTAMP(6) WITH TIME ZONE NOT NULL,
    processed_at   TIMESTAMP(6) WITH TIME ZONE
);

CREATE INDEX idx_payments_status ON payments (status);