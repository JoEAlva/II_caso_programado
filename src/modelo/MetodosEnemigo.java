/*
 * Segundo proyecto programado del curso de programación.
 * Universidad de Costa Rica - Sede del Pacífico Arnoldo Ferreto Segura
 */
package modelo;

import vista.Ventana;
/**
 *
 * @author JorgeIgnacio
 */
public class MetodosEnemigo {

    //Referencias de la clase
    Ventana ventana;
    
    //Variables de la clase
    private static final int ESTE = 1;
    private static final int OESTE = 2;
    
    
    private int direccion;
    
    //Contructor de la clase
    public MetodosEnemigo(Ventana ventana) {
        this.ventana = ventana;
        setDireccion(OESTE);
    }
    
    /**
     * Método que verifica si el enemigo se encuentra en -x- posición en la
     * pantalla.
     * @return colisionDer se convierte en -true- si se cumple la condición.
     */
    public boolean comprobarDer() {   
        boolean colisionDerecha = false;
        int posicion = ventana.jL_naveEnemigo.getX();
        if(posicion > 325) {
            colisionDerecha = true;
        }
        return colisionDerecha;
    }
    
    public boolean comprobarIzq(){
        boolean colision = false;
        int posicion = ventana.jL_naveEnemigo.getX();
        if(posicion < 5) {
            colision = true;
        }
        return colision;
    }
    
    /*
    Método que 
    */
    public void moverEnemigo() {
        if(ventana.estado.equals("izquierda")){
            ventana.jL_naveEnemigo.setLocation(ventana.jL_naveEnemigo.getX()+15, ventana.jL_naveEnemigo.getY());
            if(comprobarDer()){
                ventana.jL_naveEnemigo.setLocation(ventana.jL_naveEnemigo.getX()-15, ventana.jL_naveEnemigo.getY());
            }
        }
        if(ventana.estado.equals("derecha")) {
            ventana.jL_naveEnemigo.setLocation(ventana.jL_naveEnemigo.getX()-15, ventana.jL_naveEnemigo.getY());
            if(comprobarIzq()){
                ventana.jL_naveEnemigo.setLocation(ventana.jL_naveEnemigo.getX()+15, ventana.jL_naveEnemigo.getY());
            }
        }
    }
    
    public void moverse() {
        if(!puedeMoverse()) {
            return;
        }
        switch(direccion) {
            case ESTE:
                ventana.jL_naveEnemigo.setLocation(ventana.jL_naveEnemigo.getX()+10, ventana.jL_naveEnemigo.getY());
                break;
            case OESTE:
                ventana.jL_naveEnemigo.setLocation(ventana.jL_naveEnemigo.getX()-10, ventana.jL_naveEnemigo.getY());
                break;
        }
        
    }
    
    public boolean puedeMoverse() {
        
        int anchoVentana = ventana.getWidth();
        int x = ventana.jL_naveEnemigo.getX();
        switch(direccion) {
            case ESTE:
                x++;
                break;
                
            case OESTE:
                x--;
                break;
        }
        //Prueba para el borde exterior
        if(x > 320) {
            return false;
        }else if( x < 0) {
            return false;
        }
        return true;
    }
        
    public void cambiarDireccion() {
    
        switch(direccion) {
            case ESTE:
                setDireccion(OESTE);
                break;
            case OESTE:
                setDireccion(ESTE);
                break;
        }
    }

    public int getDireccion() {
        return direccion;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }
     
    
}//Fin de la clase MetodosEnemigo
