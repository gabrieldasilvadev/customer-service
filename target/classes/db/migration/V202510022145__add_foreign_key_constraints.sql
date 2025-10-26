-- Garante que todo pedido pertença a um cliente válido.
ALTER TABLE orders
ADD CONSTRAINT fk_orders_customer_id
FOREIGN KEY (customer_id) REFERENCES customers (id);

-- Garante que todo item de pedido referencie um produto válido.
-- Nota: A FK para order_id já existe na V202505052236__create_table_orders.sql
ALTER TABLE order_items
ADD CONSTRAINT fk_order_items_product_id
FOREIGN KEY (product_id) REFERENCES products (id);

-- Garante que todo pagamento esteja associado a um pedido e a um cliente válidos.
ALTER TABLE payments
ADD CONSTRAINT fk_payments_order_id
FOREIGN KEY (order_id) REFERENCES orders (id);

ALTER TABLE payments
ADD CONSTRAINT fk_payments_customer_id
FOREIGN KEY (customer_id) REFERENCES customers (id);