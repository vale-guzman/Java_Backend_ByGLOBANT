use estancias_exterior;

table casas;
table clientes;
table comentarios;
table estancias;
table familias;
ALTER TABLE casas DROP PRIMARY KEY;
ALTER TABLE casas MODIFY id_casa INT AUTO_INCREMENT PRIMARY KEY;

use vivero2;
/* ALTER TABLE cliente DROP PRIMARY KEY;
ALTER TABLE cliente DROP COLUMN id_cliente;
ALTER TABLE cliente MODIFY idCliente INT;

ALTER TABLE cliente ADD CONSTRAINT id_cliente_PK PRIMARY KEY (id_Cliente);

ALTER TABLE cliente CHANGE COLUMN idCliente id_cliente int; */

INSERT INTO gama_producto(id_gama, gama,descripcion_texto,imagen,descripcion_html) VALUES (1,'Herbaceas','Plantas para jardin decorativas',NULL,NULL);
INSERT INTO gama_producto(id_gama, gama,descripcion_texto,imagen,descripcion_html) VALUES (2,'Herramientas','Herramientas para todo tipo de acción',NULL,NULL);
INSERT INTO gama_producto(id_gama, gama,descripcion_texto,imagen,descripcion_html) VALUES (3,'Aromáticas','Plantas aromáticas',NULL,NULL);
INSERT INTO gama_producto(id_gama, gama,descripcion_texto,imagen,descripcion_html) VALUES (4,'Frutales','Árboles pequeños de producción frutal',NULL,NULL);
INSERT INTO gama_producto(id_gama, gama,descripcion_texto,imagen,descripcion_html) VALUES (5,'Ornamentales','Plantas vistosas para la decoración del jardín',NULL,NULL);



