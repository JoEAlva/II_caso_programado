/*
 * Segundo proyecto programado del curso de programación.
 * Universidad de Costa Rica - Sede del Pacífico Arnoldo Ferreto Segura
 */
package modelo;

import java.awt.Rectangle;
import vista.FRM_VentanaJuego;

/**
 *
 * @author JorgeIgnacio
 */
public class MetodosBala {

    //Referencias de clase
    FRM_VentanaJuego ventana;
    
    //Variables de la clase
    int velocidad = 60;
    String estadoBala = "";
    
    //Constructor de la clase
    public MetodosBala(FRM_VentanaJuego ventana) {
        
        this.ventana = ventana;
        
    }
    
    public void moverBala() {
        
        //Si el jugador presionó la flecha izquierda
        if(ventana.estado.equals("izquierda")) {
            
            ventana.jL_Bala.setLocation(ventana.jL_Bala.getX() - velocidad, ventana.jL_Bala.getY());
            
            if(comprobarIzq()) { 
                ventana.jL_Bala.setLocation(ventana.jL_Bala.getX() + velocidad, ventana.jL_Bala.getY());
            }
            //Si el jugador soltó la flecha izquierda
        }else if(ventana.estado.equals("EnElSuelo")) {
            ventana.jL_Bala.setLocation(ventana.jL_Bala.getX(), ventana.jL_Bala.getY());
        }
        
        //Si el jugador presionó la flecha arriba
        if(ventana.estado.equals("arriba")) {
            
            ventana.jL_Bala.setLocation(ventana.jL_Bala.getX(), ventana.jL_Bala.getY() - velocidad);
            
            if(comprobarArriba()) {
                ventana.jL_Bala.setLocation(ventana.jL_Bala.getX(), ventana.jL_Bala.getY() + velocidad);
            }
            //Si el jugador soltó la tecla flecha arriba
        }else if(ventana.estado.equals("EnElSuelo")) {
            ventana.jL_Bala.setLocation(ventana.jL_Bala.getX(), ventana.jL_Bala.getY());
        }

        //Si el jugador presionó la flecha derecha
        if(ventana.estado.equals("derecha")) {
            
            ventana.jL_Bala.setLocation(ventana.jL_Bala.getX() + velocidad, ventana.jL_Bala.getY());
            
            if(comprobarDer()) {
                ventana.jL_Bala.setLocation(ventana.jL_Bala.getX() - velocidad, ventana.jL_Bala.getY());
            }
            //Si el jugador soltó la tecla flecha derecha
        }else if(ventana.estado.equals("EnElSuelo")) {
            ventana.jL_Bala.setLocation(ventana.jL_Bala.getX(), ventana.jL_Bala.getY());
        }
        
//        //Si el jugadorpresionó la flecha abajo
//        if(ventana.estado.equals("abajo")) {
//            
//            ventana.jL_Bala.setLocation(ventana.jL_Bala.getX(), ventana.jL_Bala.getY() + velocidad);
//            
//            if(comprobarAbajo()) {
//                ventana.jL_Bala.setLocation(ventana.jL_Bala.getX(), ventana.jL_Bala.getY() - velocidad);
//            }
//            //Si el jugador soltó la tecla 
//        }else if(ventana.estado.equals("EnElSuelo")) {
//            ventana.jL_Bala.setLocation(ventana.jL_Bala.getX(), ventana.jL_Bala.getY());
//        }
        
    }//Fin del método moverPersonaje
    
    /**
     * Método que verifica si el personaje se encuentra en -x- posición en la 
     * pantalla.
     * @return limiteIzq se convierte en -true- si se cumple la condición. 
     */
    public boolean comprobarIzq() {
        
        boolean limiteIzq = false;
        
        int location = ventana.jL_Bala.getX();
        //System.out.println("Location" + location);
        
        if(location < 35) {
            limiteIzq = true;
        }
        
        return limiteIzq;
    }
    
    /**
     * Método que verifica si el personaje se encuentra en -y- posición en la 
     * pantalla.
     * @return limiteArriba se convierte en -true- si se cumple la condición. 
     */
    public boolean comprobarArriba() {
        
       boolean limiteArriba = false;
       
       int location = ventana.jL_Bala.getY(); 
       
       if(location < -10) {
           limiteArriba = true;
       }
       
       return limiteArriba;
    }
        
    /**
     * Método que verifica si el personaje se encuentra en -x- posición en la 
     * pantalla.
     * @return limiteDer se convierte en -true- si se cumple la condición. 
     */
    public boolean comprobarDer() {
        
        boolean limiteDer = false;
        
        int location = ventana.jL_Bala.getX();
        
        if(location > 900) {
            limiteDer = true;
        }
       
        return limiteDer;
    }
    
//    /**
//     * Método que verifica si el personaje se encuentra en -y- posición en la 
//     * pantalla.
//     * @return limiteIzq se convierte en -true- si se cumple la condición. 
//     */
//    public boolean comprobarAbajo() {
//        
//        boolean limiteAbajo = false;
//        
//        int location = ventana.jL_Bala.getY();
//        
//        if(location > 580) {
//            limiteAbajo = true;
//        }
//        return limiteAbajo;   
//    }
    
    /*
    Método que hace moverse la bala en línea recta
    */
    public void dispararCañon() {
        
        if(ventana.bala.equals("disparo")) {
            if(continuarMovBala()) {
                ventana.jL_Bala.setLocation(ventana.jL_Bala.getX(), ventana.jL_Bala.getY() - velocidad );
            }
            
        }else{
            moverBala();
        }
        
    }//Fin del método dispararCañon
    
    public boolean continuarMovBala() {
        
        boolean posBala = false;
        int posicionBala = ventana.jL_Bala.getY();
        
        if(posicionBala >= -15) {
            posBala = true;
        }
        
        return posBala;
    }
    
    public boolean verificarPosicionBala() {
        
        boolean fueraDeVentana = false;
        int posicionBala = ventana.jL_Bala.getY();
        
        if(posicionBala <= -15) {
            fueraDeVentana = true;
            ventana.bala="cargada";            
        }
        
        return fueraDeVentana;
    }
    
    public void estadoInicialBala() {
        if(verificarPosicionBala()) {
            if(ventana.bala.equals("cargada")) {
                ventana.jL_Bala.setLocation(ventana.jL_Personaje.getX()+40, ventana.jL_Personaje.getY()-30);
            }
        }
       
    }
        
}// Fin de la clase MetodosBala
