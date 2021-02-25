
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Clase para controlar las reservas de libros, implementa la interfaz {@see Material}
 * @author masa
 */
public class Reserva implements Material{
    private Libro libro;
    private Date hora_reserva;
    private Date hora_devolucion;
    
    /**
     * Constructor vacío
     */
    public Reserva(){
        
    }
    
    /**
     * Constructor con los datos por parámetro
     * @param lib
     * @param hora 
     */
    public Reserva(Libro lib, Date hora){
        this.libro = lib;
        this.hora_reserva = hora;
        this.hora_devolucion = this.hora_reserva;
        this.hora_devolucion.setMonth(this.hora_reserva.getMonth()+1); //Deprecated may need update
        
    }
    
    /**
     * Constructor copia
     * @param res 
     */
    public Reserva(Reserva res){
        this.libro = res.getLibro();
        this.hora_reserva = res.getHoraReserva();
        this.hora_devolucion = res.obtenerFechaDevolucion();
    }

    public Date getHora_reserva() {
        return hora_reserva;
    }

    public void setHora_devolucion(Date hora_devolucion) {
        this.hora_devolucion = hora_devolucion;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Date getHoraReserva() {
        return hora_reserva;
    }

    public void setHoraReserva(Date hora_reserva) {
        this.hora_reserva = hora_reserva;
        this.hora_devolucion = this.hora_reserva;
        this.hora_devolucion.setMonth(this.hora_reserva.getMonth()+1); //Deprecated may need update
    }

    @Override
    public String toString() {
        return "Reserva{" + "libro=" + libro + ", hora_reserva=" + hora_reserva + '}';
    }

    /**
     * Muestra por pantalla el título del libro reservado y la fecha de devolucion.
     */
    @Override
    public void mostrarReservaChula() {
        System.out.println(this.libro.getTitulo() + " debe ser devuelto antes de: "+ this.hora_devolucion.toString()+".");
    }

    /**
     * Devuelve la hora de devolución.
     * @return 
     */
    @Override
    public Date obtenerFechaDevolucion() {
        return this.hora_devolucion;
    }
    
}
