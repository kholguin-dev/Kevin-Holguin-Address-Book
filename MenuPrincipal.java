import java.util.Scanner;

public class MenuPrincipal {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
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


            if (scanner.hasNextInt()) {
                int opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.println("--- AGREGAR CONTACTO ---");
                        System.out.print("Nombre: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Telefono: ");
                        String telefono = scanner.nextLine();
                        System.out.print("Email: ");
                        String email = scanner.nextLine();
                        agenda.agregarContacto(new Contacto(nombre, telefono, email));
                        break;

                    case 2:
                        System.out.print("Nombre del contacto a buscar: ");
                        String nomBuscar = scanner.nextLine();
                        Contacto c = agenda.buscarContacto(nomBuscar);
                        if (c != null) {
                            System.out.println(c.toString());
                        } else {
                            System.out.println("Contacto no encontrado: " + nomBuscar);
                        }
                        break;

                    case 3:
                        System.out.print("Nombre del contacto a eliminar: ");
                        String nomEliminar = scanner.nextLine();
                        if (agenda.eliminarContacto(nomEliminar)) {
                            System.out.println("Contacto eliminado: " + nomEliminar);
                        } else {
                            System.out.println("Contacto no encontrado: " + nomEliminar);
                        }
                        break;

                    case 4:
                        System.out.println("--- LISTA DE CONTACTOS (orden alfabetico) ---");
                        agenda.listarContactos();
                        break;

                    case 5:
                        System.out.println("--- HISTORIAL (orden de insercion) ---");
                        agenda.listarHistorial();
                        break;

                    case 6:
                        System.out.print("Nombre del grupo: ");
                        String nomNuevoGrupo = scanner.nextLine();
                        agenda.agregarGrupo(nomNuevoGrupo);
                        break;

                    case 7:
                        System.out.print("Nombre del contacto: ");
                        String nomContactoGrupo = scanner.nextLine();
                        System.out.print("Nombre del grupo: ");
                        String nomGrupoAsignar = scanner.nextLine();
                        agenda.agregarContactoAGrupo(nomContactoGrupo, nomGrupoAsignar);
                        break;

                    case 8:
                        System.out.println("--- LISTA DE GRUPOS ---");
                        agenda.listarGrupos();
                        break;

                    case 9:
                        System.out.print("Nombre del grupo a visualizar: ");
                        String nomGrupoVis = scanner.nextLine();
                        agenda.mostrarContactosPorGrupo(nomGrupoVis);
                        break;

                    case 10:
                        System.out.println("Saliendo de la agenda...");
                        continuar = false;
                        break;

                    default:
                        System.out.println("Opcion invalida, intenta de nuevo");
                        break;
                }
            } else {
                System.out.println("Opcion invalida, intenta de nuevo");
                scanner.nextLine();
            }
        }

        scanner.close();
    }
}