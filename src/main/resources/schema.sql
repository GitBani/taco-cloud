CREATE TABLE IF NOT EXISTS TACO_ORDER (
    id IDENTITY,
    delivery_Name VARCHAR(50) NOT NULL,
    delivery_Street VARCHAR(50) NOT NULL,
    delivery_City VARCHAR(50) NOT NULL,
    delivery_State VARCHAR(2) NOT NULL,
    delivery_Zip VARCHAR(10) NOT NULL,
    cc_number VARCHAR(16) NOT NULL,
    cc_expiration VARCHAR(5) NOT NULL,
    cc_cvv VARCHAR(3) NOT NULL,
    placed_at TIMESTAMP NOT NULL
);

CREATE TABLE IF NOT EXISTS TACO (
    id IDENTITY,
    name VARCHAR(50) NOT NULL,
    taco_order bigint NOT NULL,
    taco_order_key bigint NOT NULL,
    created_at TIMESTAMP NOT NULL,
    FOREIGN KEY (taco_order) REFERENCES TACO_ORDER(id)
);

CREATE TABLE IF NOT EXISTS INGREDIENT (
    id VARCHAR(4) UNIQUE NOT NULL,
    name VARCHAR(25) NOT NULL,
    type VARCHAR(10) NOT NULL
);

CREATE TABLE IF NOT EXISTS INGREDIENT_REF (
    ingredient_id VARCHAR(4) NOT NULL,
    taco bigint NOT NULL,
    taco_key bigint NOT NULL,
    FOREIGN KEY (ingredient_id) REFERENCES INGREDIENT(id)
