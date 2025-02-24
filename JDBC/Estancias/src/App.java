import entidades.Cliente;
import persistencia.*;
import servicios.ClientService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class App {
        public static void main(String[] args) throws Exception {

            Scanner sc= new Scanner(System.in);
          //Creo una nueva instancia de la Clase 'ClienteDAO'
          //  ClienteDAO clienteDAO=new ClienteDAO();

            //Pruebo el método de listar todos los Clientes registrados
           // clienteDAO.listarTodosLosClientes();

            //Pruebo el método Buscar Cliente por ID
//            System.out.println("Ingrese el ID del cliente que desea Buscar: ");
//            int idSearch= sc.nextInt();
//            Cliente clienteBuscado= clienteDAO.buscarClientePorId(idSearch);
//
//            if(clienteBuscado!=null) {
//                System.out.println(clienteBuscado);}
//            else System.out.println("No existe cliente con el ID= "+idSearch);


            //Creo una instancia de la clase Entidad: 'Cliente' e invoco a su constructor con los datos.
           // Cliente clienteA= new Cliente(8,"Valeria Guzman","Av.Cordoba",123,"5000","Cordoba Capital","Argentina","mimail@gmail.com");

            // invoco al método guardar de la Clase de Persistencia ClienteDAO
            // enviando por parámetro el nuevo cliente creado.
            //clienteDAO.guardarCliente(clienteA);

            //invoco al método 'eliminiar' de la clase ClienteDao
            //clienteDAO.eliminarClientePorId(8);

            //verifico registro insertado/eliminado
           // clienteDAO.listarTodosLosClientes();

            //Creo una nueva instancia de la Clase 'CasaDAO'
           // CasaDAO casaDAO=new CasaDAO();

            //Pruebo el método de listar todos las Casas registradas
           // casaDAO.listarTodasLasCasas();

            //Creo una nueva instancia de la Clase 'ComentarioDAO'
           // ComentarioDAO comentarioDAO=new ComentarioDAO();

            //Pruebo el método de listar todos los Comentarios registrados
           //comentarioDAO.listarTodosLosComments();

            //Creo una nueva instancia de la Clase 'EstanciaDAO'
            // EstanciaDAO estanciaDAO=new EstanciaDAO();

            //Pruebo el método de listar todas las ESTANCIAS registradas
           //estanciaDAO.listarTodasLasEstancias();
//  ---------------------------------------------------------------------------------------------
           // Probando los SERVICIOS
           // Creo una instancia del ClienteService
            ClientService clientService=new ClientService();

            //Pruebo el método de Crear un cliente
            //clientService.crearNuevoCliente("Luisa Prueba","Av SiempreViva",
            //       742,"5000","Springfield", "USA","testemial@email.com" );

            //Pruebo la validación al Crear un Cliente
            clientService.crearNuevoCliente("","test2",1234,"1234","test2",
                    "test2","");
        }
}


