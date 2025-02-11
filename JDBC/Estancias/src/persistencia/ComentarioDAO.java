package persistencia;

import entidades.Casa;
import entidades.Comentario;
import entidades.Estancia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComentarioDAO extends DAO{

    public void guardarComentario(Comentario comentario) throws Exception {
        try {
            if (comentario == null) {
                throw new Exception("El Comentario NO puede ser nulo");
            }
            // las VERIFICACIONES VAN EN SERVICIO. Ej. Si comentario.getIdComentario() ya existe, informar que debe ser
            // mayor al último id, y mostrarlo.
            String sql = "INSERT INTO comentarios (id_comentario,id_casa, comentario) VALUES ('" +
                    comentario.getIdComentario() + "', '" +
                    comentario.getIdCasa() + ", '" +
                   comentario.getComentario()+ "');";
            insertarModificarEliminarDataBase(sql);
        } catch (SQLException e) {
            throw e;
        }
    }
    public List<Comentario> listarTodosLosComments() throws Exception {

        List<Comentario> comentarios = new ArrayList<>();
        String sql = "SELECT * FROM comentarios";
        try {
            consultarDataBase(sql);

            while (resultSet.next()) {
                Comentario comentario = new Comentario();
                comentario.setIdComentario(resultSet.getInt("id_comentario"));
                comentario.setIdCasa(resultSet.getInt("id_casa"));
                comentario.setComentario(resultSet.getString("comentario"));
                comentarios.add(comentario);

            }
            System.out.println("=== Lista de COMENTARIOS ===");
            for (Comentario comentario : comentarios) {
                // Utiliza el método toString() de la clase COMENTARIO para mostrar los datos.
                System.out.println(comentario);
            }

        } catch (SQLException e) {
            throw e;
        } finally {
            cerrarConexion(conexion); // Cierra la conexión después de usar el ResultSet
        }
        return comentarios;
    }
    public void eliminarComentaroioPorId(int id) throws Exception {
        try {
            String sql = "DELETE FROM comentarios WHERE id_comentario = " + id;
            insertarModificarEliminarDataBase(sql);
        } catch (SQLException e) {
            throw e;
        }
    }
}
