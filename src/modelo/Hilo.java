/*
 * Segundo proyecto programado del curso de programación.
 * Universidad de Costa Rica - Sede del Pacífico Arnoldo Ferreto Segura
 */
package modelo;

import vista.Ventana;

/**
 *
 * @author tecnologiamultimedia
 */
public class Hilo extends Thread{

    //Referencias de la clase
    Ventana ventana;
    MetodosPersonaje metodosPersonaje;
    MetodosEnemigo metodosEnemigo;
    
   public Hilo(Ventana ventana, MetodosPersonaje mp, MetodosEnemigo me)
   {
       this.ventana=ventana;
       this.metodosPersonaje = mp;
       this.metodosEnemigo = me;
   }
   
   @Override
   public void run()
   {
       try{
           
           while(true)
           {
               sleep(100);
               ventana.moverFondo();
               metodosPersonaje.moverPersonaje();
               if(metodosEnemigo.puedeMoverse()) {
                   metodosEnemigo.moverse();
               }else {
                   metodosEnemigo.cambiarDireccion();
               }
           }
       }
       catch(Exception e)
       {
           System.out.println("Error en la ejecución: "+e);
       }
   }
  
}//Fin de la clase Hilo
