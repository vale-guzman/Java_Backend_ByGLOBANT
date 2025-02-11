package persistencia;

import entidades.Casa;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CasaDAO extends DAO{
    public void guardarCasa(Casa casa) throws Exception {
        try {
            if (casa == null) {
                throw new Exception("La Casa NO puede ser nula");
            }
            // las VERIFICACIONES VAN EN SERVICIO. Ej. Si cliente.getIdCliente() ya existe, informar que debe ser
            // mayor al último id, y mostrarlo.
            String sql = "INSERT INTO casas (calle, numero, codigo_postal, ciudad, pais, fechaDesde, fechaHasta,tiempoMin, tiempoMAx, precio, tipoCasa) VALUES ('" +
                    casa.getCalle() + "', '" +
                    casa.getNro() + ", '" +
                    casa.getCp() + "', '" +
                    casa.getCiudad() + "', '" +
                    casa.getPais() + "', '" +
                    casa.getFechaDesde() + "', '" +
                    casa.getFechaHasta() + "', '" +
                    casa.getTimeMin() + "', '" +
                    casa.getTimeMax() + "', '" +
                    casa.getPriceRoom() + "', '" +
                    casa.getTypeVivienda() + "');";

            insertarModificarEliminarDataBase(sql);
        } catch (SQLException e) {
            throw e;
        }
    }
    public List<Casa> listarTodasLasCasas() throws Exception {

        List<Casa> casas = new ArrayList<>();
        String sql = "SELECT * FROM casas";
        try {
            consultarDataBase(sql);

            while (resultSet.next()) {
                Casa casa = new Casa();
                casa.setIdCasa(resultSet.getInt("id_casa"));
                casa.setCalle(resultSet.getString("calle"));
                casa.setNro(resultSet.getInt("numero"));
                casa.setCp(resultSet.getString("codigo_postal"));
                casa.setCiudad(resultSet.getString("ciudad"));
                casa.setPais(resultSet.getString("pais"));
                casa.setFechaDesde(resultSet.getDate("fecha_desde"));
                casa.setFechaHasta(resultSet.getDate("fecha_hasta"));
                casa.setTimeMin(resultSet.getInt("tiempo_minimo"));
                casa.setTimeMax(resultSet.getInt("tiempo_maximo"));
                casa.setPriceRoom(resultSet.getFloat("precio_habitacion"));
                casa.setTypeVivienda(resultSet.getString("tipo_vivienda"));
                casas.add(casa);
            }
            System.out.println("=== Lista de CASAS ===");
            for (Casa casa : casas) {
                // Utiliza el método toString() de la clase CASA para mostrar los datos.
                System.out.println(casa);
            }

        } catch (SQLException e) {
            throw e;
        } finally {
            cerrarConexion(conexion); // Cierra la conexión después de usar el ResultSet
        }
        return casas;
    }
    public void eliminarCasaPorId(int id) throws Exception {
        try {
            String sql = "DELETE FROM casas WHERE id_casa = " + id;
            insertarModificarEliminarDataBase(sql);
        } catch (SQLException e) {
            throw e;
        }
    }
}
