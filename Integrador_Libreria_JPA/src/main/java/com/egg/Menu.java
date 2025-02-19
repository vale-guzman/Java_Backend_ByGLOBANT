package com.egg;

import java.util.Scanner;

public class Menu {
    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===== MENÚ LIBRERÍA =====");
            System.out.println("1. Dar de ALTA Editorial");
            System.out.println("2. Dar de BAJA Editorial");
            System.out.println("3. EDITAR Editorial");
            System.out.println("4. Dar de ALTA Autor");
            System.out.println("5. Dar de BAJA Autor");
            System.out.println("6. EDITAR Autor");
            System.out.println("7. Dar de ALTA Libro");
            System.out.println("8. Dar de BAJA Libro");
            System.out.println("9. EDITAR Libro");
            System.out.println("10. Buscar autor por nombre");
            System.out.println("11. Buscar libro por ISBN");
            System.out.println("12. Buscar libro por título");
            System.out.println("13. Buscar libro/s por nombre de autor");
            System.out.println("14. Buscar libro/s por nombre de editorial");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.println("Dando de ALTA Editorial...");
                    // Llamar a un método que realice la creación de la BD
                    break;
                case 2:
                    System.out.println("Dando de BAJA Editorial...");
                    break;
                case 3:
                    System.out.println("Editando Editorial...");
                    break;
                case 4:
                    System.out.println("Dando de ALTA Autor...");
                    break;
                case 5:
                    System.out.println("Dando de BAJA Autor...");
                    break;
                case 6:
                    System.out.println("Editando Autor...");
                    break;
                case 7:
                    System.out.println("Dando de Alta Libro...");
                    break;
                case 8:
                    System.out.println("Dando de BAJA Libro...");
                    break;
                case 9:
                    System.out.println("Editando Libro...");
                    break;
                case 10:
                    System.out.println("Buscando autor por nombre...");
                    break;
                case 11:
                    System.out.println("Buscando libro por ISBN...");
                    break;
                case 12:
                    System.out.println("Buscando libro por título...");
                    break;
                case 13:
                    System.out.println("Buscando libro/s por nombre de autor...");
                    break;
                case 14:
                    System.out.println("Buscando libro/s por nombre de editorial...");
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida, intente nuevamente.");
            }
        } while (opcion != 0);

        scanner.close();
    }


}

