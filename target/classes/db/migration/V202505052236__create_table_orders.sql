-- create order table
CREATE TABLE orders
(
    id              UUID PRIMARY KEY,
    customer_id     UUID           NOT NULL,
    total_price     NUMERIC(18, 4) NOT NULL CHECK (total_price > 0),
    discount_amount NUMERIC(18, 4)          DEFAULT 0 CHECK (discount_amount >= 0),
    observation     VARCHAR(255),
    created_at      TIMESTAMPTZ    NOT NULL DEFAULT NOW(),
    updated_at      TIMESTAMPTZ
);

-- create order_item table
CREATE TABLE order_items
(
    id               UUID PRIMARY KEY,
    order_id         UUID           NOT NULL REFERENCES orders (id) ON DELETE CASCADE,
    product_id       UUID           NOT NULL,
    product_name     VARCHAR(255)   NOT NULL, -- Denormalized for historical accuracy
    product_quantity INTEGER        NOT NULL CHECK (product_quantity > 0),
    unit_price       NUMERIC(18, 4) NOT NULL CHECK (unit_price > 0),
    discount_amount  NUMERIC(18, 4)          DEFAULT 0 CHECK (discount_amount >= 0),
    created_at       TIMESTAMPTZ    NOT NULL DEFAULT NOW(),
    updated_at       TIMESTAMPTZ
);
