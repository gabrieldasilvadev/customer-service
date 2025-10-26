CREATE TYPE order_status AS ENUM (
    'RECEIVED',
    'AWAITING_PAYMENT',
    'PAID',
    'IN_PREPARATION',
    'DONE',
    'DELIVERED'
    );

ALTER TABLE orders
    ADD COLUMN status order_status NOT NULL;
