/*
 * Segundo proyecto programado del curso de programación.
 * Universidad de Costa Rica - Sede del Pacífico Arnoldo Ferreto Segura
 */
package modelo;

import vista.FRM_VentanaJuego;

/**
 *
 * @author JorgeIgnacio
 */
public class HiloCronometro extends Thread {

    //Variables de la clase
    private int minutos = 0;
    private int segundos = 0;
    
    //Referencias de clase
    FRM_VentanaJuego fRM_VentanaJuego;
    
    //Constructor de la clase
    public HiloCronometro(FRM_VentanaJuego fRM_VentanaJuego) {
        
        this.fRM_VentanaJuego = fRM_VentanaJuego;
        
    }
        
    //Método que inicia el hilo
    public void run() {
        
        try {
            
            while (true) {
                
                try {
   
                    tiempo();
                    
                    
                } catch (Exception e) {
                }
                
            }
            
        } catch (Exception e) {
            System.err.println("Error " + e);
        }
        
    }
    
    public void tiempo() {
        
        for(minutos = 0; minutos < 60; minutos++) {
            for(segundos = 0; segundos < 60; segundos++) {
                this.fRM_VentanaJuego.agregarTiempo(obtenerTiempo());
                try {
                    sleep(1000);
                } catch (Exception e) {
                }
            }
        }
        
    }

    //Getter
    public String obtenerTiempo() {
        return ""+this.minutos+":"+this.segundos;
    }
        
}//Fin de la clase HiloCronometro
