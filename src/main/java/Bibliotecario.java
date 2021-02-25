
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Clase bibliotecario hija de {@see Persona}, añade puesto, NIF y contraseña.
 * @author masa
 */
public class Bibliotecario extends Persona {
    private String puesto;
    private String NIF;
    private String pass;

    /**
     * Constructor vacio
     */
    public Bibliotecario(){
        
    }
    /**
     * Constructor completo con Persona
     * @param puesto String del puesto de trabajo
     * @param NIF String documentación del usuario
     * @param pass String contraseña, debe ser almenos 8 carácteres
     * @param pers Persona para definir el padre
     * @throws Exception 
     */
    public Bibliotecario(String puesto, String NIF, String pass, Persona pers) throws Exception {
        super(pers);
        if (pass.length() > 8){
            this.puesto = puesto;
            this.NIF = NIF;
            this.pass = pass;
        }else{
            throw new Exception ("Password too short");
        }
        
    }

    /**
     * Construcotr completo con todas las variables por parámetro.
     * @param puesto String del puesto de trabajo
     * @param NIF String documentación del usuario
     * @param pass String contraseña, debe ser almenos 8 carácteres
     * @param nombre String nombre
     * @param apellido1 String primer apellido
     * @param apellido2 String segundo apellido
     * @param edad Integer edad
     * @throws Exception "Password too short"
     */
    public Bibliotecario(String puesto, String NIF, String pass, String nombre, String apellido1, String apellido2, int edad) throws Exception {
        super(nombre, apellido1, apellido2, edad);
        if (pass.length() > 8){
            this.puesto = puesto;
            this.NIF = NIF;
            this.pass = pass;
        }else{
            throw new Exception ("Password too short");
        }
    }
    
    /**
     * Constructor copia
     * @param bib Bibliotecario a copiar
     */
    public Bibliotecario(Bibliotecario bib){
        super.setEdad(bib.getEdad());
        super.setApellido1(bib.getApellido1());
        super.setApellido2(bib.getApellido2());
        super.setNombre(bib.getNombre());
        this.puesto = bib.getPuesto();
        this.NIF = bib.getNIF();
        this.pass = bib.getPass();
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) throws Exception {
        if (pass.length() > 8){
            this.pass = pass;
        }else{
            throw new Exception ("Password too short");
        }
    }

    @Override
    public String toString() {
        return "Bibliotecario{" + "puesto=" + puesto + ", NIF=" + NIF + ", pass=" + pass + '}';
    }

    /**
     * Funciona como un constructor, pero pregunta al usuario todos los datos.
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
                aux[i] = aux[i+1];
            }
            inp = aux; //Not sure if this works as I intend it to, should be fine(?)
        }
        super.setNombre(inp[0]);
        super.setApellido1(inp[1]);
        super.setApellido2(inp[2]);
        System.out.println("Introduce la edad del usuario");
        super.setEdad(sc.nextInt());
        sc.nextLine();
        System.out.println("Introduce el puesto del usuario");
        this.setPuesto(sc.nextLine());
        System.out.println("Introduce el NIF del usuario");
        this.setNIF(sc.nextLine());
        System.out.println("Introduce la contraseña del usuario");
        boolean pass_valid = false;
        while(!pass_valid){
            try{
                this.setPass(sc.nextLine());
                pass_valid = true;
            }catch(Exception ex){
                pass_valid = false;
                System.out.println("Password too short! Try again");
            }
        }
        return this;
    }

    /**
     * Pregunta al usuario la contraseña a cambiar y comprueba que sea válida.
     */
    @Override
    public void cambiarContraseña() {
        Scanner sc = new Scanner(System.in);
        boolean changed = false;
        System.out.println("Que contraseña quieres?");
        while(!changed){
            try{
                this.setPass(sc.nextLine());
                changed = true;
            }catch(Exception ex){
                System.out.println("La contraseña debe tener almenos 8 carácteres");
            }
        }
    }
    
}
