import entidades.Cliente;
import persistencia.ClienteDAO;
import persistencia.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    public class App {
        public static void main(String[] args) throws Exception {
           //Creo una nueva instancia de la Clase 'ClienteDAO'
            ClienteDAO clienteDAO=new ClienteDAO();

            //Pruebo el método de listar todos los Clientes registrados
            clienteDAO.listarTodosLosClientes();

            //Creo una instancia de la clase Entidad: 'Cliente' e invoco a su constructor con los datos.
            Cliente clienteA= new Cliente(8,"Valeria Guzman","Av.Cordoba",123,"5000","Cordoba Capital","Argentina","mimail@gmail.com");

            // invoco al método guardar de la Clase de Persistencia ClienteDAO
            // enviando por parámetro el nuevo cliente creado.
            clienteDAO.guardarCliente(clienteA);

            //verifico registro insertado
            clienteDAO.listarTodosLosClientes();


        }
    }


