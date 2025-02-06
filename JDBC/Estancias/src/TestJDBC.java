import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    public class TestJDBC {
        public static void main(String[] args) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                /* En la conexión estoy desactivando la conexión segura de MySQL --> useSSL=false
                * además, permito la autenticación con contraseña sin SSL --> allowPublicKeyRetrieval=true */
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3305/vivero?serverTimezone=America/Argentina/Buenos_Aires&useSSL=false&allowPublicKeyRetrieval=true", "root", "root");
                System.out.println("✅ Conexión exitosa!");
                conn.close();
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
    }


