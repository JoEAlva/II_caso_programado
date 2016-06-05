/*
 * Segundo proyecto programado del curso de programación.
 * Universidad de Costa Rica - Sede del Pacífico Arnoldo Ferreto Segura
 */
package modelo;

/**
 *
 * @author JorgeIgnacio
 */
public class MetodosCronometro {
    
    
    //Referencia de clases

    public MetodosCronometro() {
        
    }
    
    /**
     * Método que sirve para crear un relój
     */
    public void tiempoCronometro() {
        
        for(int minutos = 0; minutos < 60; minutos++) {
            for(int segundos = 0; segundos < 60; segundos++) {
                retrasarSegundos();
            }
        }
        
    }//Fin del método tiempoCronometro
    
    private static void retrasarSegundos() {
        
        try {
            
            Thread.sleep(1000);
            
        }catch(Exception e) {
            System.err.println("Error " + e);
        }
        
    }

}//Fin de la clase MetodosCronometro
