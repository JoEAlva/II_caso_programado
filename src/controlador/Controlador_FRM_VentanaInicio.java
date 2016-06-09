/*
 * Segundo proyecto programado del curso de programación.
 * Universidad de Costa Rica - Sede del Pacífico Arnoldo Ferreto Segura
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.HiloCreditos;
import modelo.HiloCronometro;
import modelo.Sonido;
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
    
    Sonido s;
    
    HiloCronometro hiloCronometro;
    HiloCreditos hiloCreditos;
    
    //Contructor de la clase
    public Controlador_FRM_VentanaInicio(FRM_VentanaInicio fRM_VentanaInicio, FRM_VentanaJuego fRM_VentanaJuego, FRM_VentanaPuntajes fRM_VentanaPuntajes, FRM_VentanaCreditos fRM_VentanaCreditos) {
        
        this.fRM_VentanaInicio = fRM_VentanaInicio;
        this.fRM_VentanaJuego = fRM_VentanaJuego;
        this.fRM_VentanaPuntajes = fRM_VentanaPuntajes;
        this.fRM_VentanaCreditos = fRM_VentanaCreditos;
        
        s = new Sonido();
        
        s.musicaInicio();
    }
    
    public void actionPerformed (ActionEvent e) {
        
        if(e.getActionCommand().equals("Jugar")) {
            this.fRM_VentanaJuego.setVisible(true);
            this.fRM_VentanaInicio.setVisible(false);
            
//            hiloCronometro = new HiloCronometro(this.fRM_VentanaJuego);
//            hiloCronometro.start();

            /**
             * Cuándo este evento se ejecute el cronometro debe empezar a correr
             */
            s.detenerMusica();
            s.musicaJuego();
                    
        }
        
        if(e.getActionCommand().equals("Puntajes")) {
            this.fRM_VentanaPuntajes.setVisible(true);
            this.fRM_VentanaInicio.setVisible(false);

        }
        
        if(e.getActionCommand().equals("Creditos")) {
            this.fRM_VentanaCreditos.setVisible(true);
            this.fRM_VentanaInicio.setVisible(false);
            hiloCreditos = new HiloCreditos(fRM_VentanaCreditos);
            hiloCreditos.start();
        }
        
    }//Fin del método actionPerformed
    
    /**
     * Método que es llamado por un evento KeyPressed en la clase
     * FRM_VentanaInicio. Sirve para iniciar el juego con la tecla -Intro-
     */
    public void jugarRapido() {
        
        this.fRM_VentanaJuego.setVisible(true);
        this.fRM_VentanaInicio.setVisible(false);
        hiloCronometro = new HiloCronometro(this.fRM_VentanaJuego);
        hiloCronometro.start();
        
    }
    
    /**
     * Método que es llamado por un evento KeyPressed en la clase
     * FRM_VentanaInicio. Sirve para ver los puntajes con la tecla -Intro-
     */
    public  void puntajesRapido() {
        
        this.fRM_VentanaPuntajes.setVisible(true);
        this.fRM_VentanaInicio.setVisible(false);
        
    }
    
    /**
     * Método que es llamado por un evento KeyPressed en la clase
     * FRM_VentanaInicio. Sirve para ver los creditos con la tecla -Intro-
     */
    public  void creditosRapido() {
        
        this.fRM_VentanaCreditos.setVisible(true);
        this.fRM_VentanaInicio.setVisible(false);
        
    }
    
}//Fin de la clase Controlador_FRM_VentanaInicio
