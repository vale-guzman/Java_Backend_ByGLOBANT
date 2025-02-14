package com.egg.servicios;
import com.egg.entidades.Oficina;
import com.egg.persistencia.OficinaDAO;
public class OficinaServicio {

        private final OficinaDAO daoOficina;// Instancio a la unidad de persistencia para acceder a los metodos del EM

        public OficinaServicio() { this.daoOficina = new OficinaDAO();  }

        public void crearOficna(String codigodOficina, String ciudad, String pais,
                                String region, String telefono, String codigoPostal) {

            try {
            // Crear una nueva instancia de Oficina
                Oficina oficinaNueva = new Oficina();

                oficinaNueva.setCodOficina(codigodOficina);
                oficinaNueva.setCiudad(ciudad);
                oficinaNueva.setPais(pais);
                oficinaNueva.setRegion(region);
                oficinaNueva.setPhone(telefono);
                oficinaNueva.setCodPostal(codigoPostal);

            // Llamar al método de OficinaDAO para guardar la nueva oficina
                daoOficina.guardarOficina(oficinaNueva);

            } catch (Exception e) {
                System.out.println(e.toString() + "No se guardo la nueva oficina de manera correcta");
            }
        }
    }




