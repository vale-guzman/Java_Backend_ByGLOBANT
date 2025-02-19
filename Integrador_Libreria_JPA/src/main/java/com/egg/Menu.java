package com.egg;

import com.egg.servicios.AutorServicio;
import com.egg.servicios.EditorialServicio;
import com.egg.servicios.LibroServicio;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    String selected = ""; // bandera de la opción seleccionada

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion = -1; // Inicializo con un valor inválido para que el bucle siga
        // hasta que el usuario ingrese 0.

        do {
            System.out.println("\n===== MENÚ LIBRERÍA =====");
            System.out.println("1.✅ CRUD Editorial");
            System.out.println("2.\uD83D\uDC64 CRUD Autor"); //emoji person: \uD83D\uDC64= 👤
            System.out.println("3.\uD83D\uDCDA CRUD Libro"); //emoji books: \uD83D\uDCDA= 📚
            System.out.println("0. \uD83D\uDEAA Salir"); // emoji door: \uD83D\uDEAA=🚪
            System.out.print("Seleccione una opción: ");

/*
            System.out.println("10. \uD83D\uDC64 Buscar autor por nombre");
            System.out.println("11. \uD83D\uDD0D\uD83D\uDCDA Buscar libro por ISBN"); //emoji zoom: \uD83D\uDD0D=🔍
            System.out.println("12. \uD83D\uDD0D\uD83D\uDCDA Buscar libro por título");
            System.out.println("13. \uD83D\uDD0D\uD83D\uDCDA Buscar libro/s por nombre de autor");
            System.out.println("14. \uD83D\uDD0D\uD83D\uDCDA Buscar libro/s por nombre de editorial");
*/

            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer

                switch (opcion) {
                    case 1:
                        selected = "EDITORIAL";
                        int selection = 1;
                        subMenu(selection,scanner);
                        break;
                    case 2:
                        selected = "AUTOR";
                        selection = 2;
                        subMenu(selection,scanner);
                        break;
                    case 3:
                        selected = "LIBRO";
                        selection = 3;
                        subMenu(selection,scanner);
                        break;
                    /* case 4:
                        System.out.println("Buscando autor por nombre...");
                        break;
                    case 5:
                        System.out.println("Buscando libro por ISBN...");
                        break;
                    case 6:
                        System.out.println("Buscando libro por título...");
                        break;
                    case 7:
                        System.out.println("Buscando libro/s por nombre de autor...");
                        break;
                    case 8:
                        System.out.println("Buscando libro/s por nombre de editorial...");
                        break;

                     */
                    case 0:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("⚠️ Opción no válida, intente nuevamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("⚠️ ERROR-CARACTER INVÁLIDO: Ingrese un número válido.");
                scanner.nextLine(); // Limpiar el buffer para evitar un bucle infinito
            }
        } while (opcion != 0);

        scanner.close();
    }

    public void subMenu(int selection, Scanner scanner) {

        int subOpcion = -1; // Inicializo con un valor inválido para que el bucle siga
        // hasta que el usuario ingrese 0.

        do {
            System.out.println("\n===== MENÚ " + selected + " =====");
            System.out.println("1.✅ Dar de ALTA " + selected);
            System.out.println("2.✏️ EDITAR " + selected);
            System.out.println("3.✏️ LISTAR " + selected);
            System.out.println("4.❌ Dar de BAJA " + selected);
            System.out.println("0.🚪 Volver al MENÚ PRINCIPAL");
            try {
                subOpcion = scanner.nextInt();
                scanner.nextLine(); // limpia el buffer

                switch (subOpcion) {
                    case 1:
                        if (selection == 1) { // Si seleccionó Editorial
                            System.out.println("Creando " + selected + "...");
                            // Instanciar la clase EditorialServicio para acceder a sus métodos
                            EditorialServicio editorialServicio = new EditorialServicio();

                            // Pido los datos
                            System.out.println("Ingrese el Nombre de la nueva Editorial");
                            String nom = scanner.nextLine();
                            // scanner.nextLine(); // limpia el buffer

                            System.out.println("Dando de ALta la Editorial " + nom);
                            // Llamar al método del servicio para crear una nueva Editorial
                            editorialServicio.crearEditorial(nom, true);
                            break;
                        }
                        if (selection == 2) { //Si seleccionó Autor
                            System.out.println("Creando " + selected + "...");
                            // Instanciar la clase AutorServicio para acceder a sus métodos
                            AutorServicio autorServicio = new AutorServicio();

                            // Pido los datos
                            System.out.println("Ingrese el Nombre del nuevo Autor");
                            String nom = scanner.nextLine();
                            scanner.nextLine(); // limpia el buffer

                            System.out.println("Dando de ALta el Autor " + nom);
                            // Llamar al método del servicio para crear una nueva Editorial
                            autorServicio.crearAutor(nom, true);
                            break;
                        } else { //entonces seleccionó Libro
                            System.out.println("Creando " + selected + "...");

                            // Instanciar la clase LibroServicio para acceder a sus métodos
                            LibroServicio libroServicio = new LibroServicio();
                            // Pido los datos
                            System.out.println("Ingrese el ISNB del nuevo Libro");
                            Long isbn = scanner.nextLong();
                            scanner.nextLine(); // limpia el buffer

                            System.out.println("Ingrese el Titulo del nuevo Libro");
                            String title = scanner.nextLine();
                            scanner.nextLine(); // limpia el buffer

                            System.out.println("Ingrese el año del nuevo Libro");
                            int year = scanner.nextInt();
                            scanner.nextLine(); // limpia el buffer

                            System.out.println("Ingrese la cantidad de EJEMPLARES del nuevo Libro");
                            int cant = scanner.nextInt();
                            scanner.nextLine(); // limpia el buffer

                            System.out.println("Dando de ALta el libro " + title);
                            // Llamar al método del servicio para crear una nueva Editorial
                            libroServicio.crearLibro(isbn, title, year, cant, true);
                            break;
                        }

                    case 2:
                        System.out.println("Editando " + selected + "...en progreso...");

                        break;
                    case 3:
                        System.out.println("Listando " + selected + "...");

                        if (selection == 1) { // Si seleccionó Editorial
                            //Instanciar la clase EditorialServicio para acceder a sus métodos
                            EditorialServicio editorialServicio = new EditorialServicio();
                            editorialServicio.listarEditoriales();
                            break;
                        }
                        if (selection == 2) { //Si seleccionó Autor
                            //Instanciar la clase AutorServicio para acceder a sus métodos
                            AutorServicio autorServicio = new AutorServicio();
                            autorServicio.listarAutores();
                            break;

                        } else { //entonces seleccionó Libro
                            //Instanciar la clase LibroServicio para acceder a sus métodos
                            LibroServicio libroServicio = new LibroServicio();
                            libroServicio.listarLibros();
                            break;
                        }

                    case 4:
                        System.out.println("Eliminando " + selected + "...");

                        if (selection == 1) { // Si seleccionó Editorial
                            System.out.println("Eliminando " + selected + "...");
                            //Instanciar la clase EditorialServicio para acceder a sus métodos
                            EditorialServicio editorialServicio = new EditorialServicio();

                            //Pido los datos
                            System.out.println("Ingrese el ID de la Editorial a Dar De BAJA: ");
                            int id = scanner.nextInt();

                            System.out.println("Dando de BAJA la Editorial " + id);
                            // Llamar al método del servicio para crear una nueva Editorial
                            editorialServicio.darDeBajaEditorial(id);
                            break;

                        }
                        if (selection == 2) { //Si seleccionó Autor
                            System.out.println("Eliminando " + selected + "...");
                            //Instanciar la clase AutorServicio para acceder a sus métodos
                            AutorServicio autorServicio = new AutorServicio();

                            //Pido los datos
                            System.out.println("Ingrese el ID del Autor a Dar De BAJA: ");
                            int id = scanner.nextInt();

                            System.out.println("Dando de BAJA el Autor " + id);
                            // Llamar al método del servicio para crear una nueva Editorial
                            autorServicio.darDeBajaAutor(id);
                            break;
                        } else { //entonces seleccionó Libro
                            System.out.println("Eliminando " + selected + "...");
                            //Instanciar la clase LibroServicio para acceder a sus métodos
                            LibroServicio libroServicio = new LibroServicio();

                            //Pido los datos
                            System.out.println("Ingrese el ISBN del Libro a Dar De BAJA: ");
                            Long isbn = scanner.nextLong();

                            System.out.println("Dando de BAJA el Libro " + isbn);
                            // Llamar al método del servicio para crear una nueva Editorial


                            if (libroServicio.obtenerLibroPorIsbn(isbn) != null) {
                                libroServicio.darDeBajaLibro(isbn);
                            } else System.out.println("El libro no existe.");
                            break;
                        }
                    case 0:
                        System.out.println("Volviendo al Menú Principal...");
                        break;
//                    default:
//                        System.out.println("⚠️ Opción no válida, intente nuevamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("⚠️ ERROR-CARACTER INVÁLIDO: Ingrese un número válido.");
                scanner.nextLine(); // Limpiar el buffer para evitar un bucle infinito
            }
        } while (subOpcion != 0);
    }
}

