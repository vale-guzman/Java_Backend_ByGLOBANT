use estancias_exterior;

SHOW CREATE TABLE familias;

table familias;
table casas;

ALTER TABLE familias DROP FOREIGN KEY familias_ibfk_1;

/* Ahora agrego una nueva restricción de clave foránea que permita la eliminación en cascada. Esto asegurará que, al eliminar un registro de la tabla Casas, los registros correspondientes en Familias también se eliminen automáticamente.*/
ALTER TABLE familias
ADD CONSTRAINT fk_id_casa_familia_familias
FOREIGN KEY (id_casa_familia)
REFERENCES casas (id_casa)
ON DELETE CASCADE;
