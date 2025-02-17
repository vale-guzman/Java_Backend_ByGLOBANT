ALTER TABLE estancias DROP FOREIGN KEY estancias_ibfk_1;  /*restricción sobre fk: id_cliente*/
ALTER TABLE estancias DROP FOREIGN KEY estancias_ibfk_2;  /*restricción sobre fk: id_casa*/

/* Ahora agrego una nueva restricción de clave foránea que permita la eliminación en cascada. Esto asegurará que, al eliminar un registro de las tablas Casas y Clientes, los registros correspondientes en Estancias también se eliminen automáticamente.*/
ALTER TABLE estancias
ADD CONSTRAINT fk_id_casa
FOREIGN KEY (id_casa)
REFERENCES casas (id_casa)
ON DELETE CASCADE;

ALTER TABLE estancias
ADD CONSTRAINT fk_id_cliente
FOREIGN KEY (id_cliente)
REFERENCES clientes (id_cliente)
ON DELETE CASCADE;
