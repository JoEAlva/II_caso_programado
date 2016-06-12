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
public class HiloTiempo extends Thread {

    //Variables de la clase
    public int tiempo = 0;
    
    //Referencias de clase
    FRM_VentanaJuego fRM_VentanaJuego;
    
    //Constructor de la clase
    public HiloTiempo(FRM_VentanaJuego fRM_VentanaJuego) {
        
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
        
        while(true) {
            
            try {
                sleep(1000);
            } catch (Exception e) {
                
            }
            tiempo = tiempo + 1;
            this.fRM_VentanaJuego.agregarTiempo(obtenerTiempo());
        }
        
    }

    //Getter
    public String obtenerTiempo() {
        return ""+tiempo;
    }
    
    public void resetearTiempo() {
         this.tiempo = 0;
    }
   
        
}//Fin de la clase HiloTiempo
