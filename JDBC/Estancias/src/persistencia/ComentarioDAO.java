package persistencia;

import entidades.Casa;
import entidades.Comentario;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComentarioDAO extends DAO{
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
                System.out.println(comentario); // Utiliza el método toString() de la clase COMENTARIO para mostrar los datos.
            }

        } catch (SQLException e) {
            throw e;
        } finally {
            cerrarConexion(conexion); // Cierra la conexión después de usar el ResultSet
        }
        return comentarios;
    }
}
