package persistencia;

import entidades.Cliente;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class ClienteDAO extends DAO{
    public void guardarCliente(Cliente cliente) throws Exception {
        try {
            if (cliente == null) {
                throw new Exception("El cliente no puede ser nulo");
            }
           // las VERIFICACIONES VAN EN SERVICIO. Ej. Si cliente.getIdCliente() ya existe, informar que debe ser
            // mayor al último id, y mostrarlo.
            String sql = "INSERT INTO clientes (nombre, calle, numero, codigo_postal, ciudad, pais, email) VALUES ('" +
                    cliente.getNombre() + "', '" +
                    cliente.getCalle() + "', " +
                    cliente.getNumero() + ", '" +
                    cliente.getCodigoPostal() + "', '" +
                    cliente.getCiudad() + "', '" +
                    cliente.getPais() + "', '" +
                    cliente.getEmail() + "');";

            insertarModificarEliminarDataBase(sql);
        } catch (SQLException e) {
            throw e;
        }
    }

    public List<Cliente> listarTodosLosClientes() throws Exception {

        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM clientes";
        try {
           consultarDataBase(sql);

            while (resultSet.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(resultSet.getInt("id_cliente"));
                cliente.setNombre(resultSet.getString("nombre"));
                cliente.setCalle(resultSet.getString("calle"));
                cliente.setNumero(resultSet.getInt("numero"));
                cliente.setCodigoPostal(resultSet.getString("codigo_postal"));
                cliente.setCiudad(resultSet.getString("ciudad"));
                cliente.setPais(resultSet.getString("pais"));
                cliente.setEmail(resultSet.getString("email"));
                clientes.add(cliente);
            }
            System.out.println("=== Lista de Clientes ===");
            for (Cliente cliente : clientes) {
                // Utiliza el método toString() de la clase Cliente
                System.out.println(cliente);
            }

        } catch (SQLException e) {
            throw e;
        } finally {
            cerrarConexion(conexion); // Cierra la conexión después de usar el ResultSet
        }
        return clientes;
    }

    public void eliminarClientePorId(int id) throws Exception {
        try {
            String sql = "DELETE FROM clientes WHERE id_cliente = " + id;
            insertarModificarEliminarDataBase(sql);
        } catch (SQLException e) {
            throw e;
        }
    }

}
