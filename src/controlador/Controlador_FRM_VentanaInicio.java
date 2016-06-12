/*
 * Segundo proyecto programado del curso de programación.
 * Universidad de Costa Rica - Sede del Pacífico Arnoldo Ferreto Segura
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.HiloCreditos;
import modelo.HiloTiempo;
//import modelo.Jugador_XML;
import modelo.ArchivosJugador;
import modelo.MetodosJugador;
import modelo.Sonido;
import vista.FRM_RegistroJugador;
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
    FRM_RegistroJugador fRM_RegistroJugador;
    ArchivosJugador archivosJugador;
    MetodosJugador metodosJugador;
    
//    Jugador_XML jugador_XML;
    
    Sonido s;
    
    HiloTiempo hiloTiempo;
    HiloCreditos hiloCreditos;
    
    //Contructor de la clase
    public Controlador_FRM_VentanaInicio(FRM_VentanaInicio fRM_VentanaInicio,
                                         FRM_VentanaJuego fRM_VentanaJuego,
                                         FRM_VentanaPuntajes fRM_VentanaPuntajes,
                                         FRM_VentanaCreditos fRM_VentanaCreditos,
                                         FRM_RegistroJugador fRM_RegistroJugador
                                         ) {
        
        this.fRM_VentanaInicio = fRM_VentanaInicio;
        this.fRM_VentanaJuego = fRM_VentanaJuego;
        this.fRM_VentanaPuntajes = fRM_VentanaPuntajes;
        this.fRM_VentanaCreditos = fRM_VentanaCreditos;
        this.fRM_RegistroJugador = fRM_RegistroJugador;
//        this.jugador_XML = jugador_XML;
                
        s = new Sonido();
        
        hiloTiempo = new HiloTiempo(this.fRM_VentanaJuego);
        hiloTiempo.start();
//        s.musicaInicio();

        archivosJugador = new ArchivosJugador();
        metodosJugador = new MetodosJugador(archivosJugador);
        
        if(archivosJugador.cargarInfoArchivoJugador()) {
            System.out.println("Se cargó el archvio en controlador-");
        }else {
            System.out.println("No se cargó el archivo en controlador");
        }
        
        metodosJugador.arrayJugador = archivosJugador.leerInfoArchivoEstudiante();

    }//Fin del constructor
    
    public void actionPerformed (ActionEvent e) {
        
        if(e.getActionCommand().equals("Jugar")) {
            
            this.fRM_VentanaInicio.setVisible(false);
            this.fRM_VentanaJuego.setVisible(true);
            
            this.fRM_VentanaJuego.limpiarTiempo();
            this.fRM_VentanaJuego.limpiarPuntaje();
            
              
            
            this.fRM_VentanaJuego.agregarTiempo(hiloTiempo.obtenerTiempo());
            
            hiloTiempo.resetearTiempo();
            fRM_VentanaJuego.resetearPuntaje();
           
//            s.detenerMusica();
//            s.musicaJuego();
                    
        }
        
        if(e.getActionCommand().equals("Puntajes")) {
            this.fRM_VentanaInicio.setVisible(false);
            this.fRM_VentanaPuntajes.setVisible(true);
        }
        
        if(e.getActionCommand().equals("Creditos")) {
            this.fRM_VentanaCreditos.setVisible(true);
            this.fRM_VentanaInicio.setVisible(false);
            hiloCreditos = new HiloCreditos(fRM_VentanaCreditos);
            hiloCreditos.start();
        }
        
        if(e.getActionCommand().equals("Guardar")) {
            if(!this.fRM_RegistroJugador.getNombre().equals("")) {
//                jugador_XML.guardarEnXML(this.fRM_RegistroJugador.extraerDatos());
                this.fRM_RegistroJugador.setVisible(false);
                this.fRM_VentanaInicio.setVisible(true);
                this.fRM_RegistroJugador.limpiarCampos();                
            }else {
                this.fRM_RegistroJugador.msjJugador();
            }

        }
        
        if(e.getActionCommand().equals("Atras")) {
            this.fRM_VentanaInicio.manejoDeVentanas();
        }
        
    }//Fin del método actionPerformed
    
    /**
     * Método que es llamado por un evento KeyPressed en la clase
     * FRM_VentanaInicio. Sirve para iniciar el juego con la tecla -Intro-
     */
    public void jugarRapido() {
        
        this.fRM_VentanaJuego.setVisible(true);
        this.fRM_VentanaInicio.setVisible(false);
        hiloTiempo = new HiloTiempo(this.fRM_VentanaJuego);
        hiloTiempo.start();
        
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
