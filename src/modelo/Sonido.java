/*
 * Segundo proyecto programado del curso de programación.
 * Universidad de Costa Rica - Sede del Pacífico Arnoldo Ferreto Segura
 */
package modelo;

import java.applet.AudioClip;

/**
 *
 * @author JorgeIgnacio
 */
public class Sonido {
    
    AudioClip sonidoJuego;
 
    public void musicaInicio() {
        sonidoJuego = java.applet.Applet.newAudioClip(getClass().getResource("/Audios/The_Black_Moth_Project_-_Spaceship.wav"));
        sonidoJuego.loop();
    }

    public void detenerMusica() {
        sonidoJuego.stop();
    }
    
    public void musicaJuego() {
        sonidoJuego = java.applet.Applet.newAudioClip(getClass().getResource("/Audios/01_-_DANJYON_KIMURA_-_TELEPORTER.wav"));
        sonidoJuego.loop();
    }
    
}//Fin de la clase Sonido
