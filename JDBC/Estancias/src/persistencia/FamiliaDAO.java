package persistencia;

import entidades.Estancia;
import entidades.Familia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FamiliaDAO extends DAO{
    public void guardarFamilia(Familia familia) throws Exception {
        try {
            // if (familia == null) {
            //    throw new Exception("La Familia NO puede ser nula");

            // las VERIFICACIONES VAN EN SERVICIO. Ej. Si familia.getIdEstancia() ya existe, informar que debe ser
            // mayor al último id, y mostrarlo.
            String sql = "INSERT INTO familias (nombre,edad_minima, edad_maxima,num_hijos, email,id_casa_familia) VALUES ('" +
                    //familia.getIdFamilia() + "', '" +
                    familia.getNombreFamilia() + "', '" +
                    familia.getEdadMin() + "', '" +
                    familia.getEdadMax() + "', '" +
                    familia.getCantHijos() + "', '" +
                    familia.getEmail() + "', '" +
                    familia.getIdCasa() + "');";

            insertarModificarEliminarDataBase(sql);
        }
         catch (SQLException e) {
            throw e;
        }
    }
    public List<Familia> listarTodasLasFamilias() throws Exception {

        List<Familia> familias = new ArrayList<>();
        String sql = "SELECT * FROM familias";
        try {
            consultarDataBase(sql);

            while (resultSet.next()) {
                Familia familia = new Familia();
                familia.setIdFamilia(resultSet.getInt("id_familia"));
                familia.setNombreFamilia(resultSet.getString("nombre"));
                familia.setEdadMin(resultSet.getInt("edad_minima"));
                familia.setEdadMax(resultSet.getInt("edad_maxima"));
                familia.setCantHijos(resultSet.getInt("num_hijos"));
                familia.setEmail(resultSet.getString("email"));
                familia.setIdCasa(resultSet.getInt("id_casa_familia"));
                familias.add(familia);

            }
            System.out.println("=== Lista de FAMILIA ===");
            for (Familia familia: familias) {
                // Utiliza el método toString() de la clase FAMILIA para mostrar los datos.
                System.out.println(familia);
            }

        } catch (SQLException e) {
            throw e;
        } finally {
            cerrarConexion(conexion); // Cierra la conexión después de usar el ResultSet
        }
        return familias;
    }
    public void eliminarFamiliaPorId(int id) throws Exception {
        try {
            String sql = "DELETE FROM familias WHERE id_familia = " + id;
            insertarModificarEliminarDataBase(sql);
        } catch (SQLException e) {
            throw e;
        }
    }

    //ACLARACIÓN SOBRE MANEJEO EN LA BD
    /* Ahora agrego una nueva restricción de clave foránea que permita la eliminación en cascada.
    Esto asegurará que, al eliminar un registro de la tabla Casas, los registros correspondientes
    en Familias también se eliminen automáticamente.

    ALTER TABLE familias
    ADD CONSTRAINT fk_id_casa_familia_familias
    FOREIGN KEY (id_casa_familia)
    REFERENCES casas (id_casa)
    ON DELETE CASCADE; */

    //PENDIENTE DE IMPLEMENTAR
    //Propuesta de resolución Genérica y más segura, usando PreparedStatement (Gracias Guille Funaro)
    //PENDIENTE DE IMPLEMENTAR en mi solución actual.
    /* public boolean crearFamilia(Familia familia) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO fimilias(nombre, edad_minima, edad_maxima, num_hijos, email, id_casa_familia)
         VALUES(?, ?, ?, ?, ?, ?)";

        ejecutarModificacion(
                sql,
                familia.getNombre(),
                familia.getEdadMinima(),
                familia.getEdadMaxima(),
                familia.getNumHijos(),
                familia.getEmail(),
                familia.getIdCasaFamilia());

        return true;
    } */
}
