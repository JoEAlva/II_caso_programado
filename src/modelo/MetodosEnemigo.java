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
    private int velocidad = 10;
    
    private int direccion;
    
    //Contructor de la clase
    public MetodosEnemigo(Ventana ventana) {
        this.ventana = ventana;
        setDireccion(OESTE);
    }
        
    public void moverse() {
        if(!puedeMoverse()) {
            return;
        }
        switch(direccion) {
            case ESTE:
                ventana.jL_naveEnemigo.setLocation(ventana.jL_naveEnemigo.getX() + velocidad, ventana.jL_naveEnemigo.getY());
                break;
            case OESTE:
                ventana.jL_naveEnemigo.setLocation(ventana.jL_naveEnemigo.getX() - velocidad, ventana.jL_naveEnemigo.getY());
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
