import java.util.ArrayList; // Permite crear una lista dinámica
import java.util.List; // Permite declarar una variable de tipo lista
import java.util.Map; // Permite trabajar con pares de clave y valor
import java.util.Set; // Elimina los elementos duplicados en una lista
import java.util.TreeMap; // Ordena por clave
import java.util.TreeSet; // Conjunto ordenado

public class Agenda {


    Map<String, Contacto> contactos = new TreeMap<>(); // Búsqueda rápida por nombre y orden alfabético garantizado
    Set<String> grupos = new TreeSet<>(); // Grupos únicos y ordenados alfabéticamente
    Map<String, Set<String>> contactosPorGrupo = new TreeMap<>(); // Relación grupo → nombres de contactos
    List<Contacto> historial = new ArrayList<>(); // Historial de contactos en orden de inserción.

    public void agregarContacto(Contacto c) { // Agregar un contacto

        String nombre = c.getNombre(); // Se agrega el valor a la variable nombre

        if (contactos.containsKey(nombre)) { // Verifica si ya existe una clave con ese valor
            System.out.println("Error: Ya existe un contacto con el nombre " + nombre);
            return;
        }

        contactos.put(nombre, c); // Si no existe el valor - Guarda una clave con valor asignado
        historial.add(c); // Agrega el contacto al final de la lista historial

        System.out.println("Contacto agregado: " + nombre);
    }

    public Contacto buscarContacto(String nombre) { // Buscar un con // Busca el contacto por su nombre
        return contactos.get(nombre);
    }

    public boolean eliminarContacto(String nombre) { // Eliminar un contacto de todas las colecciones

        if (!contactos.containsKey(nombre)) { // Verifica que el contacto no exista en la lista
            return false;
        }

        contactos.remove(nombre); // Elimina el nombre si esta asociado a la lista

        // Eliminar del historial
        historial.removeIf(contacto -> contacto.getNombre().equals(nombre)); // Se elimina del historial el nombre asiganado

        // Eliminar de todos los grupos
        for (Set<String> nombres : contactosPorGrupo.values()) { // Recorre todos los grupos de contactos para eliminar el nombre que se desea eliminar
            nombres.remove(nombre);
        }

        return true; // Confirma la eliminación del nombre que se desea eliminar
    }

    // Listar contactos en orden alfabetico
    public void listarContactos() {

        System.out.println("--- LISTA DE CONTACTOS (orden alfabetico) ---");

        if (contactos.isEmpty()) { // isEmpty - verifica si la colección está vacía
            System.out.println("No hay contactos registrados");
            return;
        }

        for (Contacto contacto : contactos.values()) { // Recorre toda la colección para mostrar cada objeto
            System.out.println(contacto); // Muestra cada objeto en orden alfabético garantizado
        }
    }

    // Listar historial en orden de insercion
    public void listarHistorial() {System.out.println("--- HISTORIAL (orden de insercion) ---");

        if (historial.isEmpty()) { // isEmpty - verifica si la colección está vacía
            System.out.println("No hay contactos en el historial");
            return;
        }

        for (Contacto contacto : historial) { // Recorre todos los objetos de la lista historial
            System.out.println(contacto); // Muestra cada objeto en el orden de inserción
        }
    }

    // Crear un grupo
    public void agregarGrupo(String nombreGrupo) {

        if (grupos.contains(nombreGrupo)) { // Comprueba si el nombre del grupo ya existe
            System.out.println("Error: El grupo " + nombreGrupo + " ya existe");
            return;
        }

        grupos.add(nombreGrupo); // Agrega el nombre al conjunto de grupos
        contactosPorGrupo.put(nombreGrupo, new TreeSet<>()); // Guarda la clave con su valor del conjunto donde se guardaran los nombres de los contactos.

        System.out.println("Grupo '" + nombreGrupo + "' creado"); // Muestra el grupo creado
    }

    // Agregar un contacto a un grupo
    public void agregarContactoAGrupo(String nombreContacto, String nombreGrupo) { // EL metodo agregar contacto recibe dos parametros (nombre del contacto y nombre del grupo)

        if (!contactos.containsKey(nombreContacto)) { // Verifica que el contacto no este registrado
            System.out.println("Error: El contacto " + nombreContacto + " no existe");
            return;
        }

        if (!grupos.contains(nombreGrupo)) { // Verifica que el nombre del grupo no exista
            System.out.println("Error: El grupo " + nombreGrupo + " no existe");
            return;
        }

        contactosPorGrupo.get(nombreGrupo).add(nombreContacto); // Obtiene el conjunto de nombres asociados y agrega el nombre  del contacto al conjunto

        System.out.println("Contacto agregado al grupo " + nombreGrupo); // Muestra el contacto agregado al grupo
    }

    // Listar grupos en orden alfabetico
    public void listarGrupos() {

        System.out.println("--- LISTA DE GRUPOS ---");

        if (grupos.isEmpty()) { // Comprueba si no hay grupos
            System.out.println("No hay grupos registrados");
            return;
        }

        for (String grupo : grupos) { // Recorre los grupos registrados y los muestra en orden alfabético
            System.out.println(grupo);
        }
    }

    // Mostrar contactos de un grupo
    public void mostrarContactosPorGrupo(String nombreGrupo) {

        if (!grupos.contains(nombreGrupo)) { // Comprueba si el nombre del grupo esta registrado
            System.out.println("Error: El grupo " + nombreGrupo + " no existe");
            return;
        }

        Set<String> nombres = contactosPorGrupo.get(nombreGrupo); // Trae los nombres de contacto que esten asociados al conjunto

        if (nombres.isEmpty()) { // Verifica que el conjunto esta vació
            System.out.println("El grupo " + nombreGrupo + " no tiene contactos"
            );
            return;
        }

        System.out.println("Contactos en '" + nombreGrupo + "':");

        for (String nombre : nombres) { // Busca el objeto completo de contactos del conjunto
            System.out.println(contactos.get(nombre)); // Muestra los datos completos de cada objeto de contacto
        }
    }
}