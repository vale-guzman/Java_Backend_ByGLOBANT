package com.egg;

import java.util.Scanner;

public class Menu {
    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===== MENÚ LIBRERÍA =====");
            System.out.println("1. Crear base de datos Librería");
            System.out.println("2. Configurar unidad de persistencia");
            System.out.println("3. Crear entidades (Libro, Autor, Editorial)");
            System.out.println("4. Generar tablas con JPA");
            System.out.println("5. Crear servicios para manipulación de entidades");
            System.out.println("6. Persistir entidades en la base de datos");
            System.out.println("7. Dar de alta/baja o editar entidades");
            System.out.println("8. Buscar autor por nombre");
            System.out.println("9. Buscar libro por ISBN");
            System.out.println("10. Buscar libro por título");
            System.out.println("11. Buscar libro/s por nombre de autor");
            System.out.println("12. Buscar libro/s por nombre de editorial");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.println("Creando base de datos Librería...");
                    // Llamar a un método que realice la creación de la BD
                    break;
                case 2:
                    System.out.println("Configurando unidad de persistencia...");
                    break;
                case 3:
                    System.out.println("Creando entidades Libro, Autor, Editorial...");
                    break;
                case 4:
                    System.out.println("Generando tablas con JPA...");
                    break;
                case 5:
                    System.out.println("Creando servicios para manipulación de entidades...");
                    break;
                case 6:
                    System.out.println("Persistiendo entidades en la base de datos...");
                    break;
                case 7:
                    System.out.println("Dando de alta/baja o editando entidades...");
                    break;
                case 8:
                    System.out.println("Buscando autor por nombre...");
                    break;
                case 9:
                    System.out.println("Buscando libro por ISBN...");
                    break;
                case 10:
                    System.out.println("Buscando libro por título...");
                    break;
                case 11:
                    System.out.println("Buscando libro/s por nombre de autor...");
                    break;
                case 12:
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

