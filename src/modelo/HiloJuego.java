/*
 * Segundo proyecto programado del curso de programación.
 * Universidad de Costa Rica - Sede del Pacífico Arnoldo Ferreto Segura
 */
package modelo;

import vista.FRM_VentanaCreditos;
import vista.FRM_VentanaJuego;

/**
 *
 * @author tecnologiamultimedia
 */
public class HiloJuego extends Thread{

    //Referencias de la clase
    FRM_VentanaJuego ventana;
    FRM_VentanaCreditos ventanaCreditos;
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
               
               //Método que sirve para mover el lpersonaje principal entre el escenario
               metodosPersonaje.moverPersonaje();
               
               //Método que sirve para diparar la bala del pesonaje
               metodosBala.dispararCañon();
               metodosBala.estadoInicialBala();
               
               //Condición que evalua los movimientos del enemigo
               if(metodosEnemigo.puedeMoverse()) {
                   metodosEnemigo.moverse();
               }else {
                   metodosEnemigo.cambiarDireccion();
               }

               //Métodos que comprueban las colisiones entre los objetos
               ventana.detectarColisionNave();
               ventana.detectarColisionBala();
                            
               //Método que mueve la imagen de créditos
               
               
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
