
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Clase persona, tiene nombre, apellidos, NIF y contraseña
 * @author masa
 */
public abstract class Persona {
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int edad;

    /**
     * Constructor vacio
     */
    public Persona() {
        
    }
    
    /**
     * Constructor copia de persona
     * @param pers 
     */
    public Persona(Persona pers){
        this.nombre = pers.nombre;
        this.apellido1 = pers.apellido1;
        this.apellido2 = pers.apellido2;
        this.edad = pers.getEdad();
    }

    /**
     * Constructor de persona
     * @param nombre
     * @param apellido1
     * @param apellido2
     * @param NIF
     * @param contraseña 
     */
    public Persona(String nombre, String apellido1, String apellido2, int edad) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.edad = edad;
    }

    /**
     * Getter variable Nombre.
     * @return 
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Getter variable Apellido1.
     * @return 
     */
    public String getApellido1() {
        return apellido1;
    }

    /**
     * Getter variable Apellido2.
     * @return 
     */
    public String getApellido2() {
        return apellido2;
    }

    /**
     * Getter variable NIF
     * @return 
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Setter nombre.
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Setter apellido1.
     * @param apellido1 
     */
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }
    
    /**
     * Setter apellido2.
     * @param apellido2 
     */
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    /**
     * Setter edad.
     * @param Edad 
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    
    public abstract Persona solicitarDatosPersona();
    
    public abstract void cambiarContraseña();

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", edad=" + edad + '}';
    }
}
