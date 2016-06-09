/*
 * Segundo proyecto programado del curso de programación.
 * Universidad de Costa Rica - Sede del Pacífico Arnoldo Ferreto Segura
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Jugador_XML;
import vista.FRM_RegistroJugador;
import vista.FRM_VentanaInicio;


/**
 *
 * @author JorgeIgnacio
 */
public class Controlador_FRM_RegistroJugador implements ActionListener{

    //Referencias de clases
    FRM_RegistroJugador fRM_RegistroJugador;
    Jugador_XML jugador_XML;
    
    //Método constructor de la clase
    public Controlador_FRM_RegistroJugador(FRM_RegistroJugador fRM_RegistroJugador) {
        
        //Instancias
        this.fRM_RegistroJugador = fRM_RegistroJugador;
        jugador_XML = new Jugador_XML();
    }
        
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("GUARDAR")) {
            jugador_XML.guardarEnXML(this.fRM_RegistroJugador.extraerDatos());
            this.fRM_RegistroJugador.limpiarCampos();
        }
        
    }
    

}//Fin de la clase
