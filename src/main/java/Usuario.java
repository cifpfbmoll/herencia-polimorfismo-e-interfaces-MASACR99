
import java.util.Arrays;
import java.util.Scanner;

/**
 * Clase usuario con padre persona, añade telefono, direccion, codigo postal, mail y reservas.
 * @author masa
 */
public class Usuario extends Persona {
    private int telefono;
    private String direccion;
    private int codigo_postal;
    private String mail;
    private Reserva[] reservas;
    
    /**
     * Constructor vacío
     */
    public Usuario(){
        
    }

    /**
     * Construcotr completo con persona
     * @param telefono
     * @param direccion
     * @param codigo_postal
     * @param mail
     * @param reservas
     * @param pers 
     */
    public Usuario(int telefono, String direccion, int codigo_postal, String mail, Reserva[] reservas, Persona pers) {
        super(pers);
        this.telefono = telefono;
        this.direccion = direccion;
        this.codigo_postal = codigo_postal;
        this.mail = mail;
        this.reservas = reservas;
    }

    /**
     * Constructor completo con todos los parámetros
     * @param telefono
     * @param direccion
     * @param codigo_postal
     * @param mail
     * @param reservas
     * @param nombre
     * @param apellido1
     * @param apellido2
     * @param edad 
     */
    public Usuario(int telefono, String direccion, int codigo_postal, String mail, Reserva[] reservas, String nombre, String apellido1, String apellido2, int edad) {
        super(nombre, apellido1, apellido2, edad);
        this.telefono = telefono;
        this.direccion = direccion;
        this.codigo_postal = codigo_postal;
        this.mail = mail;
        this.reservas = reservas;
    }
    
    /**
     * Constructori copia
     * @param user 
     */
    public Usuario(Usuario user){
        super.setEdad(user.getEdad());
        super.setApellido1(user.getApellido1());
        super.setApellido2(user.getApellido2());
        super.setNombre(user.getNombre());
        this.telefono = user.getTelefono();
        this.direccion = user.getDireccion();
        this.codigo_postal = user.getCodigo_postal();
        this.mail = user.getMail();
        this.reservas = user.getReservas();
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(int codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Reserva[] getReservas() {
        return reservas;
    }

    public void setReservas(Reserva[] reservas) {
        this.reservas = reservas;
    }
    
    /**
     * Se encarga de controlar el array de reservas y añadir las nuevas reservas realizadas.
     * @param res Reserva
     */
    public void añadirReserva(Reserva res){
        Reserva[] aux = new Reserva[this.reservas.length+1];
        System.arraycopy(this.reservas, 0, aux, 0, this.reservas.length);
        aux[aux.length-1] = res;
        this.reservas = aux;
    }
    
    /**
     * Se encarga de controlar el array de reservas y quitar las reservas (devolución).
     * @param ISBN Identificador del libro
     * @return true ISBN encontrado y devuelto, false otherwise
     */
    public boolean quitarReserva(int ISBN){
        boolean ret = false;
        for(int i=0; i < this.reservas.length && !ret;i++){
            if(this.reservas[i].getLibro().getISBN()==ISBN){
                ret = true;
                Reserva[] aux = new Reserva[this.reservas.length-1];
                //Copiamos el array original pero nos saltamos el sitio con el ISBN a borrar
                for(int j=0;j<this.reservas.length;j++){ 
                    if(i>j){
                        aux[j-1] = this.reservas[j];
                    }else if(i<j){
                        aux[j] = this.reservas[j];
                    }
                }
                this.reservas = aux;
            }
        }
        return ret;
    }

    @Override
    public String toString() {
        return "Usuario{" + super.toString() + "telefono=" + telefono + ", direccion=" + direccion + ", codigo_postal=" + codigo_postal + ", mail=" + mail + ", reservas=" + Arrays.toString(reservas) + '}';
    }

    /**
     * Constructor que pide los datos al usuario.
     * @return Persona con los datos puestos
     */
    @Override
    public Persona solicitarDatosPersona() {
        Scanner sc = new Scanner(System.in);
        String[] inp = new String[0];
        while (inp.length < 3){ //Asegurarse de que hay 3 string (nombre y ambos apellidos)
            System.out.println("Introduce el nombre y apellidos del Usuario separado por espacios");
            String input = sc.nextLine();
            inp = input.split(" ");
        }
        while(inp.length > 3){ //Comprovar si hay algún nombre compuesto, si es así, juntarlos en posicion 0
            String[] aux = new String[inp.length-1];
            aux[0] = inp[0] + " " + inp[1];
            for(int i = 1; i < (inp.length-1); i++){ //Mover todos los valores del array a la izquierda excepto el 0, borrando asi el valor 1
                aux[i] = inp[i+1];
            }
            inp = aux; //Not sure if this works as I intend it to, should be fine(?)
        }
        super.setNombre(inp[0]);
        super.setApellido1(inp[1]);
        super.setApellido2(inp[2]);
        System.out.println("Introduce la edad del usuario");
        super.setEdad(sc.nextInt());
        sc.nextLine();
        System.out.println("Introduce el telefono del usuario");
        this.setTelefono(sc.nextInt());
        sc.nextLine();
        System.out.println("Introduce la dirección del usuario");
        this.setDireccion(sc.nextLine());
        System.out.println("Introduce el código postal del usuario");
        this.setCodigo_postal(sc.nextInt());
        sc.nextLine();
        System.out.println("Introduce el mail del usuario");
        this.setMail(sc.nextLine());
        this.reservas = new Reserva[0];
        return this;
    }

    /**
     * Función para controlar el cambio de teléfono y/o correo.
     */
    @Override
    public void cambiarContraseña() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Quieres cambiar el teléfono, el correo o nada?(T/C/N)");
        switch(sc.nextLine()){
            case "T":
            case "t":
                System.out.println("Escribe el nuevo teléfono");
                this.setTelefono(sc.nextInt());
                sc.nextLine();
                break;
            case "C":
            case "c":
                System.out.println("Escribe el nuevo correo");
                this.setMail(sc.nextLine());
                break;
            case "N":
            case "n":
                System.out.println("Entendible");
                break;
        }
    }
}
