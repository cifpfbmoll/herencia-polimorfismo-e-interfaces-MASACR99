import java.util.Scanner;

/**
 * Clase libro, incluye ISBN, titulo, autor, editoria, copias y copias
 * disponibles.
 * @author masa
 */
public class Libro {
    private int ISBN;
    private String titulo;
    private String autor;
    private String editorial;
    private int copias; //Must always be > 1
    private int copias_disponibles;
    
    /**
     * Constructor vacío.
     */
    public Libro(){
        //This thing empty :(
    }
    /**
     * Constructor de libro, recibe todos los datos directamente y se
     * asignan, si no hay problema con el dato copias.
     * @param ISBN
     * @param titulo
     * @param autor
     * @param editorial
     * @param copias
     * @param disponible 
     */
    public Libro(int ISBN, String titulo, String autor, String editorial, int copias, int disponible){
        if (copias < 1){
            System.out.println("Copias debe tener un número mayor o igual a 1");
        }else{
            this.ISBN = ISBN;
            this.titulo = titulo;
            this.autor = autor;
            this.editorial = editorial;
            this.copias = copias;
            this.copias_disponibles = disponible;
        }
    }
    
    /**
     * Constructor copia, recibe un libro y copia todas las variables a un
     * nuevo libro.
     * @param libro 
     */
    public Libro(Libro libro){
        this.ISBN = libro.getISBN();
        this.titulo = libro.getTitulo();
        this.autor = libro.getAutor();
        this.editorial = libro.getEditorial();
        this.copias = libro.getCopias();
        this.copias_disponibles = libro.getCopias_disponibles();
    }
    
    //Igual que el constructor, pero lo hace usando un scanner y devuelve
    //el libro para poder ser añadido a una lista/biblioteca
    /**
     * Se encarga de preguntar al usuario los datos necesarios para crear
     * un libro, además de controlar la validez de las copias totales
     * y copias disponibles.
     * @return 
     */
    public static Libro añadirLibro(){
        Libro libro = new Libro();
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el ISBN del libro sin guiones");
        libro.ISBN = sc.nextInt();
        sc.nextLine();
        System.out.println("Escribe el titulo del libro");
        libro.titulo = sc.nextLine();
        System.out.println("Escribe el autor del libro");
        libro.autor = sc.nextLine();
        System.out.println("Escribe la editorial del libro");
        libro.editorial = sc.nextLine();
        System.out.println("Escribe el número de copias totales");
        int error_checking = sc.nextInt();
        sc.nextLine();
        //Bucle para que el usuario se vea forzado a poner almenos una copia
        while (error_checking < 1){
            System.out.println("Debe haber almenos una copia!");
            error_checking = sc.nextInt();
            sc.nextLine();
        }
        libro.copias = error_checking;
        System.out.println("Escribe el número de copias disponibles");
        error_checking = sc.nextInt();
        sc.nextLine();
        while (error_checking > libro.copias){
            System.out.println("No puede haber más copias disponibles que originales");
            error_checking = sc.nextInt();
            sc.nextLine();
        }
        libro.copias_disponibles = error_checking;
        return libro;
    }
    
    /**
     * Se reserva un libro si tiene copias disponibles.
     * @return true reserva válida, false otherwise
     */
    public boolean reservar(){
        if(copias_disponibles > 0){
            copias_disponibles -= 1;
        }else{
            return false;
        }
        return true;
    }
    
    /**
     * Se devuelve un libro.
     */
    public void devolver(){
        copias_disponibles += 1;
    }
    
    /**
     * Getter variable ISBN.
     * @return 
     */
    public int getISBN() {
        return ISBN;
    }

    /**
     * Getter variable titulo.
     * @return 
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Getter variable autor.
     * @return 
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Getter variable editorial.
     * @return 
     */
    public String getEditorial() {
        return editorial;
    }

    /**
     * Getter variable copias.
     * @return 
     */
    public int getCopias() {
        return copias;
    }

    /**
     * Getter variable copias disponibles.
     * @return 
     */
    public int getCopias_disponibles() {
        return copias_disponibles;
    }

    /**
     * Setter ISBN.
     * @param ISBN 
     */
    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    /**
     * Setter titulo.
     * @param titulo 
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Setter autor.
     * @param autor 
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * Setter editorial.
     * @param editorial 
     */
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    /**
     * Setter copias, con checkeo de validez.
     * @param copias 
     */
    public void setCopias(int copias) {
        if (copias < 1){
            System.out.println("Como vas a tener menos de 1 copia?");
        }else{
            this.copias = copias;
        }
    }

    /**
     * Setter copias disponibles con checkeo de validez.
     * @param copias_disponibles 
     */
    public void setCopias_disponibles(int copias_disponibles) {
        if (copias_disponibles > this.copias){
            System.out.println("No puede haber más copias disponibles del total");
        }else{
            this.copias_disponibles = copias_disponibles;
        }
    }

    /**
     * Método que devuelve un string con todas las variables del libro.
     * @return 
     */
    @Override
    public String toString() {
        return "Libro{" + "ISBN=" + ISBN + ", titulo=" + titulo + ", autor=" + autor + ", editorial=" + editorial + ", copias=" + copias + ", copias_disponibles=" + copias_disponibles + '}';
    }
}
