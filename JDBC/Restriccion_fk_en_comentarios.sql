ALTER TABLE comentarios DROP FOREIGN KEY comentarios_ibfk_1;  /*restricción sobre fk: id_casa*/

/* Ahora agrego una nueva restricción de clave foránea que permita la eliminación en cascada. Esto asegurará que, al eliminar un registro de la tabla Casas, los registros correspondientes en Comentarios también se eliminen automáticamente.*/
ALTER TABLE comentarios
ADD CONSTRAINT fk_id_casa_comentarios
FOREIGN KEY (id_casa)
REFERENCES casas (id_casa)
ON DELETE CASCADE;

