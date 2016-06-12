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
public class MetodosPersonaje {
    
    //Referencias de la clase
    FRM_VentanaJuego ventana;
    
    //Variables de la clase
    int velocidad = 60;
    
    //Constructor de la clase
    public MetodosPersonaje(FRM_VentanaJuego ventana) {
        this.ventana = ventana;
    }    
    
    /**
     * Método que mediante condicionales permite y limita el movimiento del
     * objeto en el mundo
     */
    public void moverPersonaje() {
        
        //Si el jugador presionó la flecha izquierda
        if(ventana.estado.equals("izquierda")) {
            
            ventana.jL_Personaje.setLocation(ventana.jL_Personaje.getX() - velocidad, ventana.jL_Personaje.getY());
            
            if(comprobarIzq()) { 
                ventana.jL_Personaje.setLocation(ventana.jL_Personaje.getX() + velocidad, ventana.jL_Personaje.getY());
            }
            //Si el jugador soltó la flecha izquierda
        }else if(ventana.estado.equals("EnElSuelo")) {
            ventana.jL_Personaje.setLocation(ventana.jL_Personaje.getX(), ventana.jL_Personaje.getY());
        }
        
//        //Si el jugador presionó la flecha arriba
//        if(ventana.estado.equals("arriba")) {
//            
//            ventana.jL_Personaje.setLocation(ventana.jL_Personaje.getX(), ventana.jL_Personaje.getY() - velocidad);
//            
//            if(comprobarArriba()) {
//                ventana.jL_Personaje.setLocation(ventana.jL_Personaje.getX(), ventana.jL_Personaje.getY() + velocidad);
//            }
//            //Si el jugador soltó la tecla flecha arriba
//        }else if(ventana.estado.equals("EnElSuelo")) {
//            ventana.jL_Personaje.setLocation(ventana.jL_Personaje.getX(), ventana.jL_Personaje.getY());
//        }

        //Si el jugador presionó la flecha derecha
        if(ventana.estado.equals("derecha")) {
            
            ventana.jL_Personaje.setLocation(ventana.jL_Personaje.getX() + velocidad, ventana.jL_Personaje.getY());
            
            if(comprobarDer()) {
                ventana.jL_Personaje.setLocation(ventana.jL_Personaje.getX() - velocidad, ventana.jL_Personaje.getY());
            }
            //Si el jugador soltó la tecla flecha derecha
        }else if(ventana.estado.equals("EnElSuelo")) {
            ventana.jL_Personaje.setLocation(ventana.jL_Personaje.getX(), ventana.jL_Personaje.getY());
        }
        
//        //Si el jugadorpresionó la flecha abajo
//        if(ventana.estado.equals("abajo")) {
//            
//            ventana.jL_Personaje.setLocation(ventana.jL_Personaje.getX(), ventana.jL_Personaje.getY() + velocidad);
//            
//            if(comprobarAbajo()) {
//                ventana.jL_Personaje.setLocation(ventana.jL_Personaje.getX(), ventana.jL_Personaje.getY() - velocidad);
//            }
//            //Si el jugador soltó la tecla 
//        }else if(ventana.estado.equals("EnElSuelo")) {
//            ventana.jL_Personaje.setLocation(ventana.jL_Personaje.getX(), ventana.jL_Personaje.getY());
//        }
        
    }//Fin del método moverPersonaje
    
    /**
     * Método que verifica si el personaje se encuentra en -x- posición en la 
     * pantalla.
     * @return limiteIzq se convierte en -true- si se cumple la condición. 
     */
    public boolean comprobarIzq() {
        
        boolean limiteIzq = false;
        
        int location = ventana.jL_Personaje.getX();
        //System.out.println("Location" + location);
        
        if(location <= -30) {
            limiteIzq = true;
        }
        
        return limiteIzq;
    }
    
    /**
     * Método que verifica si el personaje se encuentra en -y- posición en la 
     * pantalla.
     * @return limiteArriba se convierte en -true- si se cumple la condición. 
     */
//    public boolean comprobarArriba() {
//        
//       boolean limiteArriba = false;
//       
//       int location = ventana.jL_Personaje.getY(); 
//       
//       if(location < -5) {
//           limiteArriba = true;
//       }
//       
//       return limiteArriba;
//    }
        
    /**
     * Método que verifica si el personaje se encuentra en -x- posición en la 
     * pantalla.
     * @return limiteDer se convierte en -true- si se cumple la condición. 
     */
    public boolean comprobarDer() {
        
        boolean limiteDer = false;
        
        int location = ventana.jL_Personaje.getX();
        
        if(location > 860) {
            limiteDer = true;
        }
       
        return limiteDer;
    }
    
    /**
     * Método que verifica si el personaje se encuentra en -y- posición en la 
     * pantalla.
     * @return limiteIzq se convierte en -true- si se cumple la condición. 
     */
//    public boolean comprobarAbajo() {
//        
//        boolean limiteAbajo = false;
//        
//        int location = ventana.jL_Personaje.getY();
//        
//        if(location > 610) {
//            limiteAbajo = true;
//        }
//        return limiteAbajo;   
//    }  

    
}//Fin de la clase MetodosPersonaje
