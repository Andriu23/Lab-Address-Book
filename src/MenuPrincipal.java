import java.util.Scanner; // Permite que el usuario escriba en consola

public class MenuPrincipal {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // Crea un objeto con los datos que ingresan por consola
        Agenda agenda = new Agenda(); // Crea una nueva instancia de la clase

        int opcion = 0;
        // Repetir el menu hasta elegir salir
        while (opcion != 10) { // Ejecuta el código una y otra vez, mientras la condición sea verdadera

            System.out.println("\n=== AGENDA DE CONTACTOS ===");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Buscar contacto");
            System.out.println("3. Eliminar contacto");
            System.out.println("4. Listar contactos (orden alfabetico)");
            System.out.println("5. Listar historial (orden de insercion)");
            System.out.println("6. Agregar grupo");
            System.out.println("7. Agregar contacto a grupo");
            System.out.println("8. Listar grupos");
            System.out.println("9. Mostrar contactos por grupo");
            System.out.println("10. Salir");
            System.out.println("===========================");
            System.out.print("Elige una opcion: ");

            if (!scanner.hasNextInt()) { // Valida que la opcion sea un numero entero
                scanner.nextLine(); // Consume la linea para que l programa no vuelva a leerla
                System.out.println("Opcion invalida, intenta de nuevo");
                continue;
            }

            opcion = scanner.nextInt(); // Lee el número ingresado
            scanner.nextLine();// Consumir el salto de linea pendiente

            switch (opcion) {

                case 1 -> {
                    System.out.println("--- AGREGAR CONTACTO ---");
                    String nombre = leerTexto(scanner, "Nombre: ");
                    String telefono = leerTexto(scanner, "Telefono: ");
                    String email = leerTexto(scanner, "Email: ");

                    Contacto contacto = new Contacto(nombre, telefono, email);
                    agenda.agregarContacto(contacto);
                }

                case 2 -> {
                    System.out.println("--- BUSCAR CONTACTO ---");
                    String nombre = leerTexto(scanner, "Nombre: ");
                    Contacto contacto = agenda.buscarContacto(nombre);

                    if (contacto != null) {
                        System.out.println(contacto);
                    } else {
                        System.out.println("Contacto no encontrado: " + nombre);
                    }
                }

                case 3 -> {
                    System.out.println("--- ELIMINAR CONTACTO ---");
                    String nombre = leerTexto(scanner, "Nombre: ");

                    if (agenda.eliminarContacto(nombre)) {
                        System.out.println("Contacto eliminado: " + nombre);
                    } else {
                        System.out.println("Contacto no encontrado: " + nombre);
                    }
                }

                case 4 -> agenda.listarContactos();

                case 5 -> agenda.listarHistorial();

                case 6 -> {
                    System.out.println("--- AGREGAR GRUPO ---");
                    String nombreGrupo = leerTexto(scanner, "Nombre del grupo: ");
                    agenda.agregarGrupo(nombreGrupo);
                }

                case 7 -> {
                    System.out.println("--- AGREGAR CONTACTO A GRUPO ---");
                    String nombreContacto = leerTexto(scanner, "Nombre del contacto: ");
                    String nombreGrupo = leerTexto(scanner, "Nombre del grupo: ");
                    agenda.agregarContactoAGrupo(nombreContacto, nombreGrupo);
                }

                case 8 -> agenda.listarGrupos();

                case 9 -> {
                    System.out.println("--- CONTACTOS POR GRUPO ---");
                    String nombreGrupo = leerTexto(scanner, "Nombre del grupo: ");
                    agenda.mostrarContactosPorGrupo(nombreGrupo);
                }

                case 10 -> System.out.println("Saliendo de la agenda...");

                default ->
                    System.out.println("Opcion invalida, intenta de nuevo");
            }
        }

        // Cerrar el Scanner al salir
        scanner.close();
    }

    // Metodo auxiliar para leer textos
    private static String leerTexto(
            Scanner scanner, String mensaje) {

        System.out.print(mensaje);
        return scanner.nextLine().trim();
    }
}