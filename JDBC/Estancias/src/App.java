import persistencia.ClienteDAO;
import persistencia.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    public class App {
        public static void main(String[] args) throws Exception {
            ClienteDAO clienteDAO=new ClienteDAO();
            clienteDAO.listarTodosLosClientes();

        }
    }


