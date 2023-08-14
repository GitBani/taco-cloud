DELETE FROM INGREDIENT_REF;
DELETE FROM TACO;
DELETE FROM TACO_ORDER;

DELETE FROM INGREDIENT;
INSERT INTO INGREDIENT (id, name, type)
    values ('FLTO', 'Flour Tortilla', 'WRAP');
INSERT INTO INGREDIENT (id, name, type)
    values ('COTO', 'Corn Tortilla', 'WRAP');
INSERT INTO INGREDIENT (id, name, type)
    values ('GRBF', 'Ground Beef', 'PROTEIN');
INSERT INTO INGREDIENT (id, name, type)
    values ('CARN', 'Carnitas', 'PROTEIN');
INSERT INTO INGREDIENT (id, name, type)
    values ('TMTO', 'Diced Tomatoes', 'VEGGIES');
INSERT INTO INGREDIENT (id, name, type)
    values ('LETC', 'Lettuce', 'VEGGIES');
INSERT INTO INGREDIENT (id, name, type)
    values ('CHED', 'Cheddar', 'CHEESE');
INSERT INTO INGREDIENT (id, name, type)
    values ('JACK', 'Monterrey Jack', 'CHEESE');
INSERT INTO INGREDIENT (id, name, type)
    values ('SLSA', 'Salsa', 'SAUCE');
INSERT INTO INGREDIENT (id, name, type)
    values ('SRCR', 'Sour Cream', 'SAUCE');
