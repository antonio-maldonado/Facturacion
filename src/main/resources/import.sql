
INSERT INTO clientes ( nombre, apellido, email, create_at,foto) VALUES ( 'Juan', 'Perez', 'juan@example.com', '2023-11-22','');
INSERT INTO clientes ( nombre, apellido, email, create_at,foto) VALUES ( 'María', 'Gomez', 'maria@example.com', '2023-11-22','');
INSERT INTO clientes ( nombre, apellido, email, create_at,foto) VALUES ( 'Carlos', 'Lopez', 'carlos@example.com', '2023-11-22','');
INSERT INTO clientes ( nombre, apellido, email, create_at,foto) VALUES ( 'Ana', 'Martínez', 'ana@example.com', '2023-11-22','');

INSERT INTO clientes ( nombre, apellido, email, create_at,foto) VALUES ( 'Juan', 'Perez', 'juan@example.com', '2023-11-22','');
INSERT INTO clientes ( nombre, apellido, email, create_at,foto) VALUES ( 'María', 'Gomez', 'maria@example.com', '2023-11-22','');
INSERT INTO clientes ( nombre, apellido, email, create_at,foto) VALUES ( 'Carlos', 'Lopez', 'carlos@example.com', '2023-11-22','');
INSERT INTO clientes ( nombre, apellido, email, create_at,foto) VALUES ( 'Ana', 'Martínez', 'ana@example.com', '2023-11-22','');

INSERT INTO clientes ( nombre, apellido, email, create_at,foto) VALUES ( 'Juan', 'Perez', 'juan@example.com', '2023-11-22','');
INSERT INTO clientes ( nombre, apellido, email, create_at,foto) VALUES ( 'María', 'Gomez', 'maria@example.com', '2023-11-22','');
INSERT INTO clientes ( nombre, apellido, email, create_at,foto) VALUES ( 'Carlos', 'Lopez', 'carlos@example.com', '2023-11-22','');
INSERT INTO clientes ( nombre, apellido, email, create_at,foto) VALUES ( 'Ana', 'Martínez', 'ana@example.com', '2023-11-22','');

INSERT INTO clientes ( nombre, apellido, email, create_at,foto) VALUES ( 'Juan', 'Perez', 'juan@example.com', '2023-11-22','');
INSERT INTO clientes ( nombre, apellido, email, create_at,foto) VALUES ( 'María', 'Gomez', 'maria@example.com', '2023-11-22','');
INSERT INTO clientes ( nombre, apellido, email, create_at,foto) VALUES ( 'Carlos', 'Lopez', 'carlos@example.com', '2023-11-22','');
INSERT INTO clientes ( nombre, apellido, email, create_at,foto) VALUES ( 'Ana', 'Martínez', 'ana@example.com', '2023-11-22','');

INSERT INTO clientes ( nombre, apellido, email, create_at,foto) VALUES ( 'Juan', 'Perez', 'juan@example.com', '2023-11-22','');
INSERT INTO clientes ( nombre, apellido, email, create_at,foto) VALUES ( 'María', 'Gomez', 'maria@example.com', '2023-11-22','');
INSERT INTO clientes ( nombre, apellido, email, create_at,foto) VALUES ( 'Carlos', 'Lopez', 'carlos@example.com', '2023-11-22','');
INSERT INTO clientes ( nombre, apellido, email, create_at,foto) VALUES ( 'Ana', 'Martínez', 'ana@example.com', '2023-11-22','');


INSERT INTO productos (nombre, precio, create_at) VALUES ('Camisa', 25.99, '2023-11-27');
INSERT INTO productos (nombre, precio, create_at) VALUES ('Pantalón', 39.95, CURRENT_TIMESTAMP);
INSERT INTO productos (nombre, precio, create_at) VALUES ('Zapatos', 59.99, '2023-11-27');
INSERT INTO productos (nombre, precio, create_at) VALUES ('Gorra', 12.50, CURRENT_TIMESTAMP);
INSERT INTO productos (nombre, precio, create_at) VALUES ('Bolsa', 29.95, '2023-11-27');
INSERT INTO productos (nombre, precio, create_at) VALUES ('Bufanda', 18.75, CURRENT_TIMESTAMP);
INSERT INTO productos (nombre, precio, create_at) VALUES ('Calcetines', 9.99, '2023-11-27');
INSERT INTO productos (nombre, precio, create_at) VALUES ('Chamarra', 79.95, CURRENT_TIMESTAMP);
INSERT INTO productos (nombre, precio, create_at) VALUES ('Reloj', 99.50, '2023-11-27');
INSERT INTO productos (nombre, precio, create_at) VALUES ('Collar', 49.99, CURRENT_TIMESTAMP);

INSERT INTO facturas (descripcion,observacion,cliente_id,create_at) VALUES ('Factura de equipos',null,1,NOW());
INSERT INTO facturas_items (cantidad,factura_id,producto_id) VALUES(1,1,1);
INSERT INTO facturas_items (cantidad,factura_id,producto_id) VALUES(2,1,5);
INSERT INTO facturas_items (cantidad,factura_id,producto_id) VALUES(5,1,4);
INSERT INTO facturas_items (cantidad,factura_id,producto_id) VALUES(1,1,2);

INSERT INTO facturas (descripcion,observacion,cliente_id,create_at) VALUES ('Factura bicicleta',"Alguna nota importante",1,NOW());
INSERT INTO facturas_items (cantidad,factura_id,producto_id) VALUES(3,2,2);

INSERT INTO users (username,password,enabled) VALUES ('tony','$2a$12$Tq2ZcSpv1hcNX8xLROtHE.E2nnZ7f0SfvZwKFc0N2R/T1pDdbEQiu',1);
INSERT INTO users (username,password,enabled) VALUES ('admin','$2a$12$Tq2ZcSpv1hcNX8xLROtHE.E2nnZ7f0SfvZwKFc0N2R/T1pDdbEQiu',1);


INSERT INTO authorities (user_id,authority) VALUES (1,'ROLE_USER');
INSERT INTO authorities (user_id,authority) VALUES (2,'ROLE_ADMIN');
INSERT INTO authorities (user_id,authority) VALUES (2,'ROLE_USER');

--INSERT INTO facturas (descripcion,observacion,cliente_id,create_at) VALUES ('',null,,NOW());

