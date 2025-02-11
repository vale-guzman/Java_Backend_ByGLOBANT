package persistencia;

import entidades.Casa;
import entidades.Estancia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstanciaDAO extends DAO{
    public void guardarEstancia(Estancia estancia) throws Exception {
        try {
            if (estancia == null) {
                throw new Exception("La Estancia NO puede ser nula");
            }
            // las VERIFICACIONES VAN EN SERVICIO. Ej. Si estancia.getIdEstancia() ya existe, informar que debe ser
            // mayor al último id, y mostrarlo.
            String sql = "INSERT INTO estancias (id_estancias,id_cliente, id_casa, nombre_huesped,fechaDesde, fechaHasta) VALUES ('" +
                    estancia.getIdEstancia() + "', '" +
                    estancia.getIdCliente() + ", '" +
                    estancia.getIdCasa() + "', '" +
                    estancia.getNombreCliente()+ "', '" +
                    estancia.getFechaDesde() + "', '" +
                    estancia.getFechaHasta()+ "');";
            insertarModificarEliminarDataBase(sql);
        } catch (SQLException e) {
            throw e;
        }
    }
    public List<Estancia> listarTodasLasEstancias() throws Exception {

        List<Estancia> estancias = new ArrayList<>();
        String sql = "SELECT * FROM estancias";
        try {
            consultarDataBase(sql);

            while (resultSet.next()) {
                Estancia estancia = new Estancia();
                estancia.setIdEstancia(resultSet.getInt("id_estancia"));
                estancia.setIdCliente(resultSet.getInt("id_cliente"));
                estancia.setIdCasa(resultSet.getInt("id_casa"));
                estancia.setNombreCliente(resultSet.getString("nombre_huesped"));
                estancia.setFechaDesde(resultSet.getDate("fecha_desde"));
                estancia.setFechaHasta(resultSet.getDate("fecha_hasta"));
                estancias.add(estancia);
            }
            System.out.println("=== Lista de ESTANCIAS ===");
            for (Estancia estancia : estancias) {
                // Utiliza el método toString() de la clase ESTANCIA para mostrar los datos.
                System.out.println(estancia);
            }

        } catch (SQLException e) {
            throw e;
        } finally {
            cerrarConexion(conexion); // Cierra la conexión después de usar el ResultSet
        }
        return estancias;
    }
    public void eliminarEstanciasPorId(int id) throws Exception {
        try {
            String sql = "DELETE FROM estancias WHERE id_esancia = " + id;
            insertarModificarEliminarDataBase(sql);
        } catch (SQLException e) {
            throw e;
        }
    }
}
