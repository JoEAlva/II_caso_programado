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
public class MetodosPuntaje {

    //Variables de la clase
    private int puntaje = 0;
    
    //Referencias de clase
    FRM_VentanaJuego fRM_VentanaJuego;
    
    //Constructor de la clase
    public MetodosPuntaje(FRM_VentanaJuego fRM_VentanaJuego) {
        
        //Instancias de clase
        this.fRM_VentanaJuego = fRM_VentanaJuego;
        
    }
    
    public void puntaje() {
        
        puntaje = puntaje + 1;
        
    }

    public String getPuntaje() {
        return ""+puntaje;
    }
    
    public void estadoInicialPuntaje() {
        puntaje = 0;
    }
        
}//Fin de la clase MetodosPuntaje
