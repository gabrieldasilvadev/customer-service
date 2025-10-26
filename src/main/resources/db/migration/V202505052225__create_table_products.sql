-- create products category table
CREATE TYPE product_category AS ENUM ('SNACK', 'DRINK', 'DESSERT', 'SIDE_DISH');

-- create product table
CREATE TABLE products
(
    id          UUID PRIMARY KEY,
    sku         VARCHAR(16),
    name        VARCHAR(255)     NOT NULL,
    category    product_category NOT NULL,
    description VARCHAR(255)     NOT NULL,
    price       NUMERIC(18, 4)   NOT NULL,
    active      BOOLEAN                   DEFAULT TRUE,
    image       VARCHAR(255),
    created_at  TIMESTAMPTZ      NOT NULL DEFAULT NOW(),
    updated_at  TIMESTAMPTZ
);
