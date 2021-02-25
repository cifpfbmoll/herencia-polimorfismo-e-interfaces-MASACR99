import java.util.ArrayList;
import java.util.Date;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;  
import java.util.Scanner;

/**
 * Clase biblioteca, incluye nombre, lista de libros, lista del personal
 * y cantidad total de libros.
 * @author masa
 */
public class Biblioteca {
    private String nombre;
    private ArrayList<Libro> listaLibros = new ArrayList<>();
    private ArrayList<Persona> listaPersonas = new ArrayList<>();
    private int cantidadLibrosTotal = 0;
    
    /**
     * Constructor vacio.
     */
    public Biblioteca(){
        
    }
    
    /**
     * Constructor cópia de biblioteca.
     * @param biblio 
     */
    public Biblioteca(Biblioteca biblio){
        this.nombre = biblio.nombre;
        this.listaLibros = biblio.listaLibros;
        this.listaPersonas = biblio.listaPersonas;
        this.cantidadLibrosTotal = biblio.cantidadLibrosTotal;
    }
    
    /**
     * Contrsuctor de biblioteca.
     * 
     * El constructor no necesita la cantidad de libros totales
     * ya que los buscará automàticamente.
     * @param nombre
     * @param listaLibros
     * @param listaPersonal 
     */
    public Biblioteca(String nombre, ArrayList<Libro> listaLibros, ArrayList<Persona> listaPersonal){
        if (nombre.charAt(0) == nombre.toUpperCase().charAt(0)){
            this.nombre = nombre;
            this.listaLibros = listaLibros;
            this.listaPersonas = listaPersonal;

            //Bucle que revisará la cantidad de libros totales de cada Libro
            //para obtener el número total de libros en la biblioteca
            for (int i = 0; i < listaLibros.size(); i++){
                this.cantidadLibrosTotal += listaLibros.get(i).getCopias();
            }
        }else{
            System.out.println("El nombre de la biblioteca debe empezar en mayúscula");
        }
        
    }
    
    /**
     * Se llama a la funcion estática de {@see Libro} {@see Libro.añadirLibro()},
     * y se añade a la lista de libros de la biblioteca además de añadir
     * las copias al total, también se comprueba que el ISBN sea único.
     */
    public void añadirLibro(){
        Libro lib = Libro.añadirLibro();
        if(this.buscarISBN(lib.getISBN()) != -1){
            System.out.println("Este ISBN ya existe!");
        }else{
            this.listaLibros.add(lib);
            this.cantidadLibrosTotal += lib.getCopias();
        }
    }
    
    /**
     * Realiza un libro copia de otro y se añade a la lista, excepto si el 
     * ISBN no ha sido cambiado.
     * @param ISBN Identificador del libro a copiar
     */
    public void añadirLibroCopia(int ISBN){
        Libro lib_orig = null;
        Scanner sc = new Scanner(System.in);
        int save = this.buscarISBN(ISBN);
        if (save !=-1){
            lib_orig = this.listaLibros.get(save);
        }else{
            System.out.println("No se encontró ese libro");
        }
        if(lib_orig != null){
            Libro lib = new Libro(lib_orig);
            boolean menu = true;
            while(menu){
                System.out.println("Que datos quieres editar?");
                System.out.println("1- ISBN");
                System.out.println("2- Titulo");
                System.out.println("3- Autor");
                System.out.println("4- Editorial");
                System.out.println("5- Copias");
                System.out.println("6- Copias disponibles");
                System.out.println("7- Salir");
                int menu_in = sc.nextInt();
                sc.nextLine();
                switch(menu_in){
                    case 1:
                        System.out.println("Escribe el nuevo ISBN:");
                        lib.setISBN(sc.nextInt());
                        sc.nextLine();
                        break;
                    case 2:
                        System.out.println("Escribe el nuevo titulo:");
                        lib.setTitulo(sc.nextLine());
                        break;
                    case 3:
                        System.out.println("Escribe el nuevo autor:");
                        lib.setAutor(sc.nextLine());
                        break;
                    case 4:
                        System.out.println("Escribe la nueva editorial:");
                        lib.setEditorial(sc.nextLine());
                        break;
                    case 5:
                        System.out.println("Escribe las nuevas copias totales:");
                        lib.setCopias(sc.nextInt());
                        break;
                    case 6:
                        System.out.println("Escribe las nuevas copias disponibles:");
                        lib.setCopias_disponibles(sc.nextInt());
                        break;
                    case 7:
                        menu = false;
                        break;
                }
            }
            if(this.buscarISBN(lib.getISBN()) != -1){
                System.out.println("Este ISBN ya existe!");
            }else{
                this.listaLibros.add(lib);
                this.cantidadLibrosTotal += lib.getCopias();
            }
        }
    }
    
    /**
     * Busca entre la lista de libros de la biblioteca hasta encontrar
     * el libro con el mismo ISBN o al llegar al final de la lista,
     * 
     * Una vez encontrado resta la cantidad de libros a la cantidad global
     * y quita el libro del ArrayList.
     * 
     * @param ISBN Identificador del libro a borrar
     */
    public void eliminarLibro(int ISBN){
        boolean found = false;
        for (int i = 0; (i < listaLibros.size() && !found); i++){
            if (this.listaLibros.get(i).getISBN() == ISBN){
                this.cantidadLibrosTotal -= this.listaLibros.get(i).getCopias();
                this.listaLibros.remove(i);
                found = true;
            }
        }
        if(found){
            System.out.println("Libro encontrado y eliminado");
        }else{
            System.out.println("No se ha encontrado el libro con ISBN: " + ISBN);
        }
    }
    
    /**
     * Busca en la lista de la biblioteca un libro con el ISBN indicado.
     * @param ISBN Identificador del libro a buscar
     * @return Posición del libro en la lista, -1 si no se encuentra.
     */
    public int buscarISBN(int ISBN){
        int ret = -1;
        for (int i = 0; i < listaLibros.size() && ret == -1; i++){
            if (this.listaLibros.get(i).getISBN() == ISBN){
                ret = i;
            }
        }
        return ret;
    }
    
    /**
     * Busca por toda la lista de libros e imprime por consola todos
     * los datos de los libros con el mismo título recibido por parámetro,
     * Si no se encuentra ninguno imprime "No se encontrado ningún libro con
     * título: {@titulo}".
     * @param titulo Titulo del libro a buscar
     */
    public void buscarTitulo(String titulo){
        String titulo_min = titulo.toLowerCase();
        boolean found_any = false;
        for (int i = 0; i < listaLibros.size(); i++){
            if (this.listaLibros.get(i).getTitulo().toLowerCase().equals(titulo_min)){
                System.out.println(this.listaLibros.get(i).toString());
                found_any = true;
            }
        }
        if (!found_any){
            System.out.println("No se ha encontrado ningún libro con título: " + titulo);
        }
    }
    
    /**
     * Imprime por consola todos los datos de todos los libros
     * con el método toString() de la clase Libro.
     */
    public void mostrarLibros(){
        for(int i =0;i<listaLibros.size();i++){
            System.out.println(listaLibros.get(i).toString());
        }
    }
    
    /**
     * Imprime por consola todos los datos de los libros, con almenos una
     * copia disponible, con el método toString() de la clase Libro.
     */
    public void mostrarDisponibles(){
        boolean found_any = false;
        for (int i = 0; i < listaLibros.size(); i++){
            if (this.listaLibros.get(i).getCopias_disponibles() > 0){
                System.out.println(this.listaLibros.get(i).toString());
                found_any = true;
            }
        }
        if (!found_any){
            System.out.println("No quedan libros disponibles, sentimos las molestias");
        }
    }
    
    /**
     * Se encarga de llamar a añadirPersona() dentro de la clase Persona
     * para crear una persona y añadirla a la lista del personal de la
     * biblioteca.
     * @param pers
     */
    public void añadirPersona(Persona pers){
        this.listaPersonas.add(pers);
    }
    
    /**
     * Busca en la lista del personal hasta encontrar el NIF introducido
     * y borra la persona de la lista. Si no lo encuentra imprime por consola
     * un mensaje de no encontrado, si lo encuentra imprime "Persona encontrada
     * y borrada".
     * @param deleter Identificador de bibliotecario o usuario a borrar
     */
    public void eliminarPersona(String deleter){
        boolean found = false;
        for (int i = 0; (i < listaPersonas.size() && !found); i++){
            if (this.listaPersonas.get(i) instanceof Bibliotecario bib) {
                if (bib.getNIF().equals(deleter)){
                    this.listaPersonas.remove(i);
                    found = true;
                }
            }else if (this.listaPersonas.get(i) instanceof Usuario user) {
                if (user.getMail().equals(deleter)){
                    this.listaPersonas.remove(i);
                    found = true;
                }
            }
        }
        if(found){
            System.out.println("Persona encontrada y borrada");
        }else{
            System.out.println("No se ha encontrado la persona con parametro de busqueda: " + deleter);
        }
    }
    
    /**
     * Muestra por consola todas las personas en el listado del personal.
     */
    public void mostrarPersonas(){
        for(int i = 0; i<listaPersonas.size();i++){
            System.out.println(listaPersonas.get(i).toString());
        }
    }

    /**
     * Busca entre las personas si hay algún inicio de sesión correcto
     * y devuelve la persona
     * @param username Identificador para encontrar la persona
     * @param identif Identificador para confirmar la persona correcta (contraseña)
     * @return Persona encontrada
     * @throws Exception 
     */
    public Persona iniciarSesion(String username, String identif) throws Exception{
        boolean found = false;
        Persona pers = null;
        for (int i = 0; (i < listaPersonas.size() && !found); i++){
            if (this.listaPersonas.get(i) instanceof Bibliotecario bib){
                if (bib.getNIF().equals(username) && bib.getPass().equals(identif)){
                    found = true;
                    pers = bib;
                }
            }else if (this.listaPersonas.get(i) instanceof Usuario user){
                if (user.getTelefono() == (Integer.parseInt(username)) && user.getMail().equals(identif)){
                    found = true;
                    pers = user;
                }
            }else{
                throw new Exception("This error shouldn't show");
            }
        }
        return pers;
    }
    
    /**
     * Realiza todas las comprobaciones para dar una reserva de un libro a un
     * usuario
     * @param ISBN Identificador del libro a encontrar
     * @param pers Persona que realiza la reserva
     */
    public void reservarLibro(int ISBN, Usuario pers){
        //1- Comprobar si existe el libro
        //2- Comprobar existencias
        //3- Crear reserva
        //4- Añadir reserva al usuario
        int posicion = buscarISBN(ISBN);
        if (posicion != -1){
            if (listaLibros.get(posicion).reservar()){
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                Reserva res = new Reserva(listaLibros.get(posicion),new Date(dtf.format(now)));
                pers.añadirReserva(res);
                System.out.println("Se ha reservado el libro");
                //Como guardo los datos de la reserva? Otra clase?
            }else{
                System.out.println("No quedan copias disponibles");
            }
        }else{
            System.out.println("El libro no existe");
        }
    }
    
    /**
     * Realiza todos los chequeos necesarios para devolver un libro
     * @param ISBN Identificador del libro a devolver
     * @param pers Persona que devuelve el libro
     */
    public void devolverLibro(int ISBN, Usuario pers){
        //1- Comprobar si libro en reserva por el usuario == ISBN
        //2- Eliminar reserva del usuario
        //3- Añadir stock al libro
        if(pers.quitarReserva(ISBN)){ //Busca entre el array del usuario y borra si encuentra
            int posicion = buscarISBN(ISBN);
            listaLibros.get(posicion).devolver();
        }else{
            System.out.println("No se encontró el libro");
        }
    }
    
    public void mostrarReservas(Usuario user){
        Reserva[] res = user.getReservas();
        for (int i = 0; i < res.length; i++){
            System.out.println(res[i].toString());
        }
    }
    
    /**
     * Función que controla el cambio de contraseña en el bibliotacario
     * i cambio de datos varios en el Usuario.
     */
    public void cambiarContraseña(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el telefono o NIF del usuario a cambiar contraseña");
        String username = sc.nextLine();
        boolean found = false;
        for(int i = 0; !found && i< this.listaPersonas.size();i++){
            if (this.listaPersonas.get(i) instanceof Bibliotecario bib){
                if (bib.getNIF().equals(username)){
                    found = true;
                    bib.cambiarContraseña();
                }
            }else if (this.listaPersonas.get(i) instanceof Usuario user){
                if (user.getTelefono() == (Integer.parseInt(username))){
                    found = true;
                    user.cambiarContraseña();
                }
            }
        }
    }
    
    /**
     * Getter variable nombre.
     * @return 
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Getter variable listaLibros.
     * @return 
     */
    public ArrayList<Libro> getListaLibros() {
        return listaLibros;
    }

    /**
     * Getter variable listaPersonal.
     * @return 
     */
    public ArrayList<Persona> getListaPersonas() {
        return listaPersonas;
    }

    /**
     * Getter variable cantidadLibrosTotal.
     * @return 
     */
    public int getCantidadLibrosTotal() {
        return cantidadLibrosTotal;
    }

    /**
     * Setter del nombre con checkeo de mayúscula.
     * @param nombre 
     */
    public void setNombre(String nombre) {
        if (nombre.charAt(0) == nombre.toUpperCase().charAt(0)){
            this.nombre = nombre;
        }else{
            System.out.println("El nombre de la biblioteca debe empezar en mayúscula");
        }
    }

    /**
     * Setter de la lista de libros.
     * @param listaLibros 
     */
    public void setListaLibros(ArrayList<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }

    /**
     * Setter de la lista de personal.
     * @param listaPersonal 
     */
    public void setListaPersonas(ArrayList<Persona> listaPersonal) {
        this.listaPersonas = listaPersonal;
    }

    /**
     * Setter de la cantidad de libros total.
     * @param cantidadLibrosTotal 
     */
    public void setCantidadLibrosTotal(int cantidadLibrosTotal) {
        this.cantidadLibrosTotal = cantidadLibrosTotal;
    }

    /**
     * Devuelve el string con todas las variables de la biblioteca,
     * incluidas las listas (Aunque seguramente sea la dirección de las
     * listas).
     * @return 
     */
    @Override
    public String toString() {
        return "Biblioteca{" + "nombre=" + nombre + ", listaLibros=" + listaLibros + ", listaPersonal=" + listaPersonas + ", cantidadLibrosTotal=" + cantidadLibrosTotal + '}';
    }
    
    
}
