public class Contacto { // Creamos la clase Contacto

    private String nombre; // Atributo de la clase contacto
    private String telefono; // Atributo de la clase contacto
    private String email; // Atributo de la clase contacto

    // Constructor que recibe todos los atributos.
    public Contacto(String nombre, String telefono, String email) { // Contacto contacto = new Contacto("nombre", "telefono", "email");
        this.nombre = nombre; // Atributo del objeto que recibe el valor como parametro
        this.telefono = telefono; // Atributo del objeto que recibe el valor como parametro
        this.email = email; // Atributo del objeto que recibe el valor como parametro
    }

    // Getters para todos los atributos.
    public String getNombre() { // Permite consultar el valor de un atributo nombre.
        return nombre;
    }
    public String getTelefono() { // Permite consultar el valor de un atributo telefono.
        return telefono;
    }
    public String getEmail() { // Permite consultar el valor de un atributo email.
        return email;
    }

    // Setters para todos los atributos.
    public void setNombre(String nombre) { // Permite modificar el valor del atributo nombre
        this.nombre = nombre;
    }
    public void setTelefono(String telefono) { // Permite modificar el valor del atributo telefono
        this.telefono = telefono;
    }
    public void setEmail(String email) { // Permite modificar el valor del atributo email
        this.email = email;
    }

    // Mostrar los datos del contacto
    @Override
    public String toString() {return nombre + " | Telefono: " + telefono + " | Email: " + email;}
}