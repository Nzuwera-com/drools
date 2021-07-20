DROP TABLE IF EXISTS ORDERS;

CREATE TABLE orders (
	id uuid NOT NULL,
	discount int4 NULL,
	order_id int4 NULL,
	payment_type varchar(255) NULL,
	total_price int4 NULL,
	CONSTRAINT orders_pkey PRIMARY KEY (id)
);