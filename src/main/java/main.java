
import java.util.Scanner;


/*
IMPORTANTE!!!:
Como el codigo es extenso y el ejercicio muy simple voy a poner
aqui el conjunto de errores que se han usado y donde se pueden encontrar:
1- IllegalArgumentException: En la clase Libro, linea 85 para tratar, throw en linea: 203
2- Uso de la clase Error (creo que entendi mal el enunciado): En la clase main, lineas: 261 y 270.
Tambien al final de cada función de menús, menu_libros, menu_personas y menu_reservas como default
3- Generación y tratamiento de excepción en la misma clase: Clase Bibliotecario lineas 150 y 103.
*/

/**
 *
 * @author masa
 */
public class main {

    private static final Biblioteca biblioteca = new Biblioteca();
    private static final Scanner sc = new Scanner(System.in);
    private static boolean menu_global = true;
    private static boolean menus_peq = true;
    private static char input;
    private static int menu_input;

    private static void menu_libros() {
        System.out.println("Bienvenido al menú de control de los libros");
        while (menus_peq) {
            System.out.println("Que quieres hacer?");
            System.out.println("1- Añadir libro");
            System.out.println("2- Añadir libro copia");
            System.out.println("3- Eliminar libro");
            System.out.println("4- Buscar libro por ISBN");
            System.out.println("5- Buscar libro por título");
            System.out.println("6- Mostrar libros");
            System.out.println("7- Mostrar libros disponibles");
            System.out.println("8- Volver al menú anterior");
            menu_input = sc.nextInt();
            sc.nextLine();
            switch (menu_input) {
                case 1:
                    //Añadir un libro a la biblioteca
                    biblioteca.añadirLibro();
                    break;
                case 2:
                    //Añadir copia de un libro y editar
                    System.out.println("Escibe el ISBN del libro a copiar:");
                    int ISBN = sc.nextInt();
                    sc.nextLine();
                    biblioteca.añadirLibroCopia(ISBN);
                    break;
                case 3:
                    //Eliminar un libro de la biblioteca
                    System.out.println("Pon el ISBN del libro que quieres eliminar");
                    biblioteca.eliminarLibro(sc.nextInt());
                    break;
                case 4:
                    //Buscar un libro por ISBN
                    System.out.println("Pon el ISBN del libro que quieres buscar");
                    System.out.println("El libro esta en la posicion: " + biblioteca.buscarISBN(sc.nextInt()));
                    break;
                case 5:
                    //Buscar libro por titulo
                    System.out.println("Pon el titulo del libro/s que quieres buscar");
                    biblioteca.buscarTitulo(sc.nextLine());
                    break;
                case 6:
                    //Mostrar libros
                    biblioteca.mostrarLibros();
                    break;
                case 7:
                    //Mostrar solo disponibles
                    biblioteca.mostrarDisponibles();
                    break;
                case 8:
                    //Salir del while
                    menus_peq = false;
                    break;
                default:
                    try{
                        Error error = new Error(1);
                    }catch(Exception ex){
                        ex.printStackTrace(); //Simplemente imprimimos el error
                    }
                    break;
            }
        }
    }

    public static void menu_personas() {
        //Abrir menú control de personal
        System.out.println("Bienvenido al menú de control de las personas de la biblioteca");
        while (menus_peq) {
            System.out.println("Que quieres hacer?");
            System.out.println("1- Añadir persona");
            System.out.println("2- Eliminar persona");
            System.out.println("3- Ver personal");
            System.out.println("4- Cambiar contraseña");
            System.out.println("5- Volver al menú anterior");
            menu_input = sc.nextInt();
            sc.nextLine();
            switch (menu_input) {
                case 1:
                    //Añadir una persona a la biblioteca
                    System.out.println("Quieres añadir un nuevo empleado o un usuario? (1/2)");
                    int small_input = sc.nextInt();
                    switch (small_input) {
                        case 1:
                            Bibliotecario bib = new Bibliotecario();
                            bib.solicitarDatosPersona();
                            biblioteca.añadirPersona(bib);
                            break;
                        case 2:
                            Usuario user = new Usuario();
                            user.solicitarDatosPersona();
                            biblioteca.añadirPersona(user);
                            break;
                        default:
                            System.out.println("Menú incorrecto, prueba otra vez");
                            break;
                    }
                    break;
                case 2:
                    //Eliminar una persona de la biblioteca
                    System.out.println("Pon el NIF o el correo de la persona a borrar");
                    biblioteca.eliminarPersona(sc.nextLine());
                    break;
                case 3:
                    //Mostrar todas las personas
                    biblioteca.mostrarPersonas();
                    break;
                case 4:
                    //Cambiar contraseña/datos
                    biblioteca.cambiarContraseña();
                    break;
                case 5:
                    //Volver al menu anterior
                    menus_peq = false;
                    break;
                default:
                    try{
                        Error error = new Error(1);
                    }catch(Exception ex){
                        ex.printStackTrace(); //Simplemente imprimimos el error
                    }
                    break;
            }
        }
    }

    public static void menu_reservas() {
        //menu gestion reservas
        menus_peq = true;
        System.out.println("Bienvenido al menú de reservas");
        System.out.println("Por favor inicie sesión");
        System.out.println("NIF:");
        String username = sc.nextLine();
        System.out.println("Contraseña");
        String pass = sc.nextLine();
        try {
            //Obligar al inicio de sesión de un bibliotecario
            while (!username.equals("exit") && !(biblioteca.iniciarSesion(username, pass) instanceof Bibliotecario)) { //Solo el administrador puede entrar
                System.out.println("Mal input, prueba otra vez. Puedes usar 'exit' para salir");
                System.out.println("NIF:");
                username = sc.nextLine();
                System.out.println("Contraseña");
                pass = sc.nextLine();
            }
        } catch (Exception ex) {
            System.out.println("You shouldn't see this, report the following to the admin:");
            ex.printStackTrace();
        }
        //Si un bibliotecario inicia sesión abrimos menú
        //Pedimos input al usuario
        //Primero iniciar sesión
        if (!username.equals("exit")) {
            Usuario user = null; //User se define aquí para evitar errores de compilación en el switch posterior porque "user no esta definido"
            System.out.println("Usuario, inicie sesión");
            System.out.println("Escribe tu telefono:");
            String tel = sc.nextLine();
            System.out.println("Escribe tu correo:");
            String mail = sc.nextLine();
            try {
                if (biblioteca.iniciarSesion(tel, mail) instanceof Usuario usuario) { //Comprobar que el inicio de sesión es de un usuario
                    user = usuario;
                } else {
                    System.out.println("No se pudo iniciar sesión");
                    menus_peq = false;
                }
            } catch (Exception ex) {
                System.out.println("Shouldn't see this, report to an admin");
                ex.printStackTrace();
            }
            while (menus_peq) {
                //Pedir input del menú
                //Si se ha iniciado sesión se muestra el menú
                //Sino se sale del bucle
                if (menus_peq) {
                    System.out.println("1- Reservar libro");
                    System.out.println("2- Devolver libro");
                    System.out.println("3- Ver reservas");
                    System.out.println("4- Volver al menú anterior");
                    menu_input = sc.nextInt();
                    sc.nextLine();
                } else {
                    menu_input = 3;
                }
                switch (menu_input) {
                    case 1:
                        //Realizar una reserva, requiere inicio de sesion del usuario
                        System.out.println("Escriba el ISBN del libro a reservar");
                        biblioteca.reservarLibro(sc.nextInt(), user);
                        sc.nextLine();
                        break;
                    case 2:
                        //Devolver un libro, requiere inicio de sesion del usuario
                        System.out.println("Escriba el ISBN del libro a devolver");
                        biblioteca.devolverLibro(sc.nextInt(), user);
                        sc.nextLine();
                        break;
                    case 3:
                        //Mostrar todos los libros reservados por el usuario
                        biblioteca.mostrarReservas(user);
                        break;
                    case 4:
                        //Volver atrás
                        menus_peq = false;
                        break;
                    default:
                        try{
                            Error error = new Error(1);
                        }catch(Exception ex){
                            ex.printStackTrace(); //Simplemente imprimimos el error
                        }
                        break;
                }
            }
        }
    }

    /**
     * Inicio del programa, inicializará el conjunto de variables necesarias
     * para el uso del programa y mostrará por consola los menús necesarios para
     * navegar y usar el programa.
     *
     * @param args
     */
    public static void main(String[] args) {
        //Define variables necesarias
        //Menú post-implementación usuario
        System.out.println("Bienvenido al controlador de la biblioteca");
        while (menu_global) {
            menus_peq = true; //Reset to true to keep submenus open
            System.out.println("""
                                        Que quiere hacer?
                               L- Controlar libros
                               P- Control de las personas
                               R- Control de las reservas
                               S- Salir
                               """);
            input = sc.nextLine().toCharArray()[0];
            switch (input) {
                case 'l':
                case 'L':
                    menu_libros();
                    break;
                case 'p':
                case 'P':
                    menu_personas();
                    break;
                case 'r':
                case 'R':
                    menu_reservas();
                    break;
                case 's':
                case 'S':
                    System.out.println("Apagando programa...");
                    menu_global = false;
                    break;
                default:
                    try{
                        Error error = new Error(5);
                    }catch(Exception ex){
                        ex.printStackTrace(); //Simplemente imprimimos el error
                    }
                    break;
            }
        }
    }
}
