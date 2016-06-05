/*
 * Segundo proyecto programado del curso de programación.
 * Universidad de Costa Rica - Sede del Pacífico Arnoldo Ferreto Segura
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.FRM_VentanaCreditos;

import vista.FRM_VentanaInicio;
import vista.FRM_VentanaJuego;
import vista.FRM_VentanaPuntajes;

/**
 *
 * @author JorgeIgnacio
 */
public class Controlador_FRM_VentanaInicio implements ActionListener {
    
    //Referencias de clases
    FRM_VentanaInicio fRM_VentanaInicio;
    FRM_VentanaJuego fRM_VentanaJuego;
    FRM_VentanaPuntajes fRM_VentanaPuntajes;
    FRM_VentanaCreditos fRM_VentanaCreditos;
    
    //Contructor de la clase
    public Controlador_FRM_VentanaInicio(FRM_VentanaInicio fRM_VentanaInicio, FRM_VentanaJuego fRM_VentanaJuego, FRM_VentanaPuntajes fRM_VentanaPuntajes, FRM_VentanaCreditos fRM_VentanaCreditos) {
        
        this.fRM_VentanaInicio = fRM_VentanaInicio;
        this.fRM_VentanaJuego = fRM_VentanaJuego;
        this.fRM_VentanaPuntajes = fRM_VentanaPuntajes;
        this.fRM_VentanaCreditos = fRM_VentanaCreditos;
        
    }
    
    public void actionPerformed (ActionEvent e) {
        
        if(e.getActionCommand().equals("Jugar")) {
            this.fRM_VentanaJuego.setVisible(true);
            this.fRM_VentanaInicio.setVisible(false);
        }
        
        if(e.getActionCommand().equals("Puntajes")) {
            this.fRM_VentanaPuntajes.setVisible(true);
            this.fRM_VentanaInicio.setVisible(false);

        }
        
        if(e.getActionCommand().equals("Creditos")) {
            this.fRM_VentanaCreditos.setVisible(true);
        }
        
    }
    
}//Fin de la clase Controlador_FRM_VentanaInicio
