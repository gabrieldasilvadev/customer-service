-- Adiciona um índice na coluna 'status' da tabela 'orders' para otimizar a busca da fila de pedidos.
CREATE INDEX idx_orders_status ON orders (status);

-- Adiciona índices nas colunas de chave estrangeira para acelerar os JOINs.
CREATE INDEX idx_orders_customer_id ON orders (customer_id);
CREATE INDEX idx_order_items_product_id ON order_items (product_id);
CREATE INDEX idx_payments_order_id ON payments (order_id);
CREATE INDEX idx_payments_customer_id ON payments (customer_id);