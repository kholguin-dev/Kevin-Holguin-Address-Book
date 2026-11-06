import java.util.*;

public class Agenda {
    private Map<String, Contacto> contactos;
    private Set<String> grupos;
    private Map<String, Set<String>> contactosPorGrupo;
    private List<Contacto> historial;

    public Agenda() {
        this.contactos = new TreeMap<>();
        this.grupos = new TreeSet<>();
        this.contactosPorGrupo = new TreeMap<>();
        this.historial = new ArrayList<>();
    }

    public void agregarContacto(Contacto c) {
        if (contactos.containsKey(c.getNombre())) {
            System.out.println("Error: Ya existe un contacto con el nombre '" + c.getNombre() + "'");
        } else {
            contactos.put(c.getNombre(), c);
            historial.add(c);
            System.out.println("Contacto agregado: " + c.getNombre());
        }
    }

    public Contacto buscarContacto(String nombre) {
        return contactos.get(nombre);
    }

    public boolean eliminarContacto(String nombre) {
        Contacto c = contactos.remove(nombre);
        if (c == null) {
            return false;
        }


        historial.remove(c);

        for (Set<String> miembrosGrupo : contactosPorGrupo.values()) {
            miembrosGrupo.remove(nombre);
        }

        return true;
    }

    public void listarContactos() {
        for (Contacto c : contactos.values()) {
            System.out.println(c.toString());
        }
    }

    public void listarHistorial() {
        for (Contacto c : historial) {
            System.out.println(c.toString());
        }
    }

    public void agregarGrupo(String nombreGrupo) {
        if (grupos.contains(nombreGrupo)) {
            System.out.println("Error: El grupo '" + nombreGrupo + "' ya existe");
        } else {
            grupos.add(nombreGrupo);
            contactosPorGrupo.put(nombreGrupo, new TreeSet<>());
            System.out.println("Grupo '" + nombreGrupo + "' creado");
        }
    }

    public void agregarContactoAGrupo(String nombreContacto, String nombreGrupo) {
        if (!contactos.containsKey(nombreContacto)) {
            System.out.println("Error: El contacto '" + nombreContacto + "' no existe");
            return;
        }
        if (!grupos.contains(nombreGrupo)) {
            System.out.println("Error: El grupo '" + nombreGrupo + "' no existe");
            return;
        }

        contactosPorGrupo.get(nombreGrupo).add(nombreContacto);
        System.out.println("Contacto agregado al grupo '" + nombreGrupo + "'");
    }

    public void listarGrupos() {
        for (String grupo : grupos) {
            System.out.println(grupo);
        }
    }

    public void mostrarContactosPorGrupo(String nombreGrupo) {
        if (!grupos.contains(nombreGrupo)) {
            System.out.println("Error: El grupo '" + nombreGrupo + "' no existe");
            return;
        }

        Set<String> nombresEnGrupo = contactosPorGrupo.get(nombreGrupo);
        if (nombresEnGrupo.isEmpty()) {
            System.out.println("El grupo '" + nombreGrupo + "' no tiene contactos");
        } else {
            System.out.println("Contactos en '" + nombreGrupo + "':");
            for (String nombre : nombresEnGrupo) {
                System.out.println(contactos.get(nombre).toString());
            }
        }
    }
}