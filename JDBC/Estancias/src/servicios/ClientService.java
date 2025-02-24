package servicios;

import entidades.Cliente;
import persistencia.ClienteDAO;

public class ClientService {
    private ClienteDAO clienteDAO;
    public  ClientService(){  this.clienteDAO =  new ClienteDAO();  }

    public Cliente crearNuevoCliente( String nombre, String calle, int nro,String CP, String ciudad,
                                  String pais, String email)throws Exception{
        //Validación de Nombre e Email
        validarNameyEmail(nombre,email);

        Cliente cliente=new Cliente(nombre,calle,nro,CP,ciudad,pais,email);
        clienteDAO.guardarCliente(cliente);
        return cliente;
    }

    public void validarNameyEmail(String nombreCliente, String email) throws Exception{
        if (nombreCliente == null | nombreCliente.isBlank()) {
            throw new Exception("El nombre del Cliente no puede ser nulo.");
        }
        if (email == null | email.isBlank()) {
            throw new Exception("Es obligatorio ingresar un email.");
        }
    }
}
