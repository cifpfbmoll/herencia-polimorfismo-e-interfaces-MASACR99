/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author masa
 */
public class BibliotecaTest {
    
    public BibliotecaTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of añadirLibro method, of class Biblioteca.
     */
    @Test
    public void testAñadirLibro() {
        System.out.println("a\u00f1adirLibro");
        Biblioteca instance = new Biblioteca();
        instance.añadirLibro();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of añadirLibroCopia method, of class Biblioteca.
     */
    @Test
    public void testAñadirLibroCopia() {
        System.out.println("a\u00f1adirLibroCopia");
        int ISBN = 0;
        Biblioteca instance = new Biblioteca();
        instance.añadirLibroCopia(ISBN);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarLibro method, of class Biblioteca.
     */
    @Test
    public void testEliminarLibro() {
        System.out.println("eliminarLibro");
        int ISBN = 0;
        Biblioteca instance = new Biblioteca();
        instance.eliminarLibro(ISBN);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarISBN method, of class Biblioteca.
     */
    @Test
    public void testBuscarISBN() {
        System.out.println("buscarISBN");
        int ISBN = 0;
        Biblioteca instance = new Biblioteca();
        int expResult = 0;
        int result = instance.buscarISBN(ISBN);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarTitulo method, of class Biblioteca.
     */
    @Test
    public void testBuscarTitulo() {
        System.out.println("buscarTitulo");
        String titulo = "";
        Biblioteca instance = new Biblioteca();
        instance.buscarTitulo(titulo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarLibros method, of class Biblioteca.
     */
    @Test
    public void testMostrarLibros() {
        System.out.println("mostrarLibros");
        Biblioteca instance = new Biblioteca();
        instance.mostrarLibros();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarDisponibles method, of class Biblioteca.
     */
    @Test
    public void testMostrarDisponibles() {
        System.out.println("mostrarDisponibles");
        Biblioteca instance = new Biblioteca();
        instance.mostrarDisponibles();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of añadirPersona method, of class Biblioteca.
     */
    @Test
    public void testAñadirPersona() {
        System.out.println("a\u00f1adirPersona");
        Persona pers = null;
        Biblioteca instance = new Biblioteca();
        instance.añadirPersona(pers);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarPersona method, of class Biblioteca.
     */
    @Test
    public void testEliminarPersona() {
        System.out.println("eliminarPersona");
        String deleter = "";
        Biblioteca instance = new Biblioteca();
        instance.eliminarPersona(deleter);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarPersonas method, of class Biblioteca.
     */
    @Test
    public void testMostrarPersonas() {
        System.out.println("mostrarPersonas");
        Biblioteca instance = new Biblioteca();
        instance.mostrarPersonas();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of iniciarSesion method, of class Biblioteca.
     */
    @Test
    public void testIniciarSesion() throws Exception {
        System.out.println("iniciarSesion");
        String username = "";
        String identif = "";
        Biblioteca instance = new Biblioteca();
        Persona expResult = null;
        Persona result = instance.iniciarSesion(username, identif);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reservarLibro method, of class Biblioteca.
     */
    @Test
    public void testReservarLibro() {
        System.out.println("reservarLibro");
        int ISBN = 0;
        Usuario pers = null;
        Biblioteca instance = new Biblioteca();
        instance.reservarLibro(ISBN, pers);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of devolverLibro method, of class Biblioteca.
     */
    @Test
    public void testDevolverLibro() {
        System.out.println("devolverLibro");
        int ISBN = 0;
        Usuario pers = null;
        Biblioteca instance = new Biblioteca();
        instance.devolverLibro(ISBN, pers);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarReservas method, of class Biblioteca.
     */
    @Test
    public void testMostrarReservas() {
        System.out.println("mostrarReservas");
        Usuario user = null;
        Biblioteca instance = new Biblioteca();
        instance.mostrarReservas(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cambiarContraseña method, of class Biblioteca.
     */
    @Test
    public void testCambiarContraseña() {
        System.out.println("cambiarContrase\u00f1a");
        Biblioteca instance = new Biblioteca();
        instance.cambiarContraseña();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombre method, of class Biblioteca.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Biblioteca instance = new Biblioteca();
        String expResult = "";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaLibros method, of class Biblioteca.
     */
    @Test
    public void testGetListaLibros() {
        System.out.println("getListaLibros");
        Biblioteca instance = new Biblioteca();
        ArrayList<Libro> expResult = null;
        ArrayList<Libro> result = instance.getListaLibros();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaPersonas method, of class Biblioteca.
     */
    @Test
    public void testGetListaPersonas() {
        System.out.println("getListaPersonas");
        Biblioteca instance = new Biblioteca();
        ArrayList<Persona> expResult = null;
        ArrayList<Persona> result = instance.getListaPersonas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCantidadLibrosTotal method, of class Biblioteca.
     */
    @Test
    public void testGetCantidadLibrosTotal() {
        System.out.println("getCantidadLibrosTotal");
        Biblioteca instance = new Biblioteca();
        int expResult = 0;
        int result = instance.getCantidadLibrosTotal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombre method, of class Biblioteca.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "";
        Biblioteca instance = new Biblioteca();
        instance.setNombre(nombre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaLibros method, of class Biblioteca.
     */
    @Test
    public void testSetListaLibros() {
        System.out.println("setListaLibros");
        ArrayList<Libro> listaLibros = null;
        Biblioteca instance = new Biblioteca();
        instance.setListaLibros(listaLibros);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaPersonas method, of class Biblioteca.
     */
    @Test
    public void testSetListaPersonas() {
        System.out.println("setListaPersonas");
        ArrayList<Persona> listaPersonal = null;
        Biblioteca instance = new Biblioteca();
        instance.setListaPersonas(listaPersonal);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCantidadLibrosTotal method, of class Biblioteca.
     */
    @Test
    public void testSetCantidadLibrosTotal() {
        System.out.println("setCantidadLibrosTotal");
        int cantidadLibrosTotal = 0;
        Biblioteca instance = new Biblioteca();
        instance.setCantidadLibrosTotal(cantidadLibrosTotal);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Biblioteca.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Biblioteca instance = new Biblioteca();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
