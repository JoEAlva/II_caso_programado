/*
 * Segundo proyecto programado del curso de programación.
 * Universidad de Costa Rica - Sede del Pacífico Arnoldo Ferreto Segura
 */
package modelo;

import vista.FRM_VentanaJuego;

/**
 *
 * @author tecnologiamultimedia
 */
public class Hilo extends Thread{

    //Referencias de la clase
    FRM_VentanaJuego ventana;
    MetodosPersonaje metodosPersonaje;
    MetodosEnemigo metodosEnemigo;
  
    
   public Hilo(FRM_VentanaJuego ventana, MetodosPersonaje mp, MetodosEnemigo me)
   {
       this.ventana=ventana;
       this.metodosPersonaje = mp;
       this.metodosEnemigo = me;
  
   }
   
   @Override
   
   //Método que inicia el hilo
   public void run()
   {
       try{

           while(true)
           {
               sleep(100);
//               ventana.moverFondo();
               metodosPersonaje.moverPersonaje();
               if(metodosEnemigo.puedeMoverse()) {
                   metodosEnemigo.moverse();
               }else {
                   metodosEnemigo.cambiarDireccion();
               }
//               metodosPersonaje.comprobarColision();
               if(metodosPersonaje.comprobarColision()) {
                   
//                   this.suspend();
               }
               ventana.detectarColision();
           }
           
           
       }
       catch(Exception e)
       {
           System.out.println("Error en la ejecución: "+e);
       }
   }
   
  
}//Fin de la clase Hilo
