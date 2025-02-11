package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DAO {
    // Datos de conexión
    //private static final String URL = "jdbc:mysql://localhost:3305/estancias_exterior";
    private static final String URL = "jdbc:mysql://localhost:3305/estancias_exterior?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=America/Argentina/Buenos_Aires";

    protected Connection conexion = null;
    public ResultSet resultSet;
    protected Statement statement = null;
    private static final String USUARIO = "root";  // Cambiar según tu usuario
    private static final String PASSWORD = "root";
    // Esto especifica una zona horaria, en algunas zonas genera conflictos de conexión si no existiera
    // String zona = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public Connection conectar() throws SQLException, ClassNotFoundException {
        try {
            Connection conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            System.out.println("✅ Conexión exitosa a la BD 'Estancias'");
            return conexion;
        } catch (SQLException e) {
            System.out.println("❌ Error al conectar: " + e.getMessage());
            return null;
        }
    }

    protected void cerrarConexion(Connection conexion) {
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("✅ La conexión a la base de datos fue cerrada de manera exitosa");
            } catch (SQLException e) {
                System.out.println("❌ Error al cerrar la conexión:" + e.getMessage());
            }
        }
    }

    protected void insertarModificarEliminarDataBase(String sql) throws Exception {
        try {
            conexion= conectar();
            statement = conexion.createStatement();
            statement.executeUpdate(sql);


        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
    }

    protected void consultarDataBase(String sql) throws Exception {
        try {
           conexion= conectar();
           statement = conexion.createStatement();
            resultSet= statement.executeQuery(sql);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //Propuesta de resolución Genérica y más segura, usando PreparedStatement (Gracias Guille Funaro)
    //PENDIENTE DE IMPLEMENTAR en mi solución actual.
    /* protected void ejecutarModificacion(String sql, Object... parametros) throws SQLException, ClassNotFoundException {
        try (Connection conn = obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            for (int i = 0; i < parametros.length; i++) {
                stmt.setObject(i + 1, parametros[i]);
            }
            stmt.executeUpdate();
            System.out.println("Operación realizada con éxito.");
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println("Error en la base de datos: " + ex.getMessage());
            throw ex;
        } */
    }


