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

        String nombre = c.getNombre();

        if (contactos.containsKey(nombre)) {
            System.out.println("Error: Ya existe un contacto con el nombre " + nombre);
            return;
        }

        contactos.put(nombre, c);
        historial.add(c);

        System.out.println("Contacto agregado: " + nombre);
    }

    public Contacto buscarContacto(String nombre) { // Buscar un contacto por nombre
        return contactos.get(nombre);
    }

    public boolean eliminarContacto(String nombre) { // Eliminar un contacto de todas las colecciones

        if (!contactos.containsKey(nombre)) {
            return false;
        }

        contactos.remove(nombre);

    }
}