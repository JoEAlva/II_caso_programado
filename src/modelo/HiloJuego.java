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
public class HiloJuego extends Thread{

    //Referencias de la clase
    FRM_VentanaJuego ventana;
    MetodosPersonaje metodosPersonaje;
    MetodosEnemigo metodosEnemigo;
    MetodosBala metodosBala;
  
    
   public HiloJuego(FRM_VentanaJuego ventana, MetodosPersonaje mp, MetodosEnemigo me, MetodosBala mb)
   {
       this.ventana=ventana;
       this.metodosPersonaje = mp;
       this.metodosEnemigo = me;
       this.metodosBala = mb;
  
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
               metodosBala.dispararCañon();
               
               if(metodosEnemigo.puedeMoverse()) {
                   metodosEnemigo.moverse();
               }else {
                   metodosEnemigo.cambiarDireccion();
               }
//               metodosPersonaje.comprobarColision();

               ventana.detectarColision();
           }
           
           
       }
       catch(Exception e)
       {
           System.out.println("Error en la ejecución: "+e);
       }
   }
   
   public void cronometro() {
       
       
       
   }
   
  
}//Fin de la clase HiloJuego
