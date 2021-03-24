/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author masa
 */
public class Error extends Exception{
    private Error err;
    
    private Error(String error){
        super(error);
    }
    
    /**
     * Recibe un código y según el mismo genera una excepción.
     * @param error
     * @throws Exception 
     */
    public Error(int error) throws Exception{
        /*  El siguiente código es una burrada y una completa tonteria, pero me lo
            tomé como un reto personal encontrar una solución con el objetivo de
            tener varios códigos en el constructor y a la vez poder usar el super
            para poder usar el e.getMessage() original de Exception */
        
        if (error<0){
            err = new Error("Inferior a 0");
        }else{
            switch(error){
                //Los primeros números son números de broma para rellenar
                case 69:
                    err = new Error("nice");
                    break;
                case 404:
                    err = new Error("No encontrado");
                    break;
                case 1337:
                    err = new Error("Hackerman");
                    break;
                case 1094795585:
                    //Para saber mas sobre el porque de este numero se puede ver
                    //El siguiente video: https://www.youtube.com/watch?v=bknybcgfjAk
                    err = new Error("Conocimientos elevados de sistema operativos");
                    break;
                //A partir de aqui numeros "serios"
                //Caso numero 0: El valor es 0 o nulo
                case 0:
                    err = new Error("Valor 0 o nulo");
                    break;
                //Caso numero 1: El valor es demasiado elevado
                case 1:
                    err = new Error("El valor es demasiado elevado");
                    break;
                //Caso numero 2: No se ha podido encontrar el usuario
                case 2:
                    err = new Error("No se pudo encontrar el usuario");
                    break;
                //Caso numero 3: No se ha podido encontrar el libro
                case 3:
                    err = new Error("No se ha podido encontrar el libro");
                    break;
                //Caso numero 4: No se pudo encontrar a la persona
                case 4:
                    err = new Error("No se pudo encontrar a la persona");
                    break;
                //Caso numero 5: Input no valido (error mas generico que valor elevado o nulo)
                case 5:
                    err = new Error("Entrada no válida");
                    break;
                default:
                    err = new Error(null);
                    break;
            }
        }
    }
}
