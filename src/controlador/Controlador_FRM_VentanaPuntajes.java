/*
 * Segundo proyecto programado del curso de programación.
 * Universidad de Costa Rica - Sede del Pacífico Arnoldo Ferreto Segura
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.FRM_VentanaInicio;

import vista.FRM_VentanaPuntajes;

/**
 *
 * @author JorgeIgnacio
 */
public class Controlador_FRM_VentanaPuntajes implements ActionListener {

    //Referencias de clase
    FRM_VentanaPuntajes fRM_VentanaPuntajes;
    FRM_VentanaInicio fRM_VentanaInicio;
    
    //Constructor de la clase
    public Controlador_FRM_VentanaPuntajes(FRM_VentanaPuntajes fRM_VentanaPuntajes, FRM_VentanaInicio fRM_VentanaInicio) {
        this.fRM_VentanaPuntajes = fRM_VentanaPuntajes;
        this.fRM_VentanaInicio = fRM_VentanaInicio;
    }
        
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("Atras")) {
            
            this.fRM_VentanaPuntajes.setVisible(false);
            this.fRM_VentanaInicio.setVisible(true);
            
        }
        
    }
    
}//Fin de la clase Controlador_FRM_VentanaPuntajes
