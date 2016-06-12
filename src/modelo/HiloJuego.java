/*
 * Segundo proyecto programado del curso de programación.
 * Universidad de Costa Rica - Sede del Pacífico Arnoldo Ferreto Segura
 */
package modelo;

import vista.FRM_RegistroJugador;
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
    FRM_RegistroJugador fRM_RegistroJugador;
    MetodosPersonaje metodosPersonaje;
    MetodosEnemigo01 metodosEnemigo;
    MetodosEnemigo02 metodosEnemigo02;
    MetodosBala metodosBala;
        
   public HiloJuego(FRM_VentanaJuego ventana, MetodosPersonaje mp, MetodosEnemigo01 me01, MetodosBala mb, FRM_RegistroJugador fRM_RegistroJugador, MetodosEnemigo02 me02)
   {
       this.fRM_RegistroJugador = fRM_RegistroJugador;
       this.ventana = ventana;
       this.metodosPersonaje = mp;
       this.metodosEnemigo = me01;
       this.metodosEnemigo02 = me02;
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
               
               //Método que sirve para mover el personaje principal entre el escenario
               metodosPersonaje.moverPersonaje();
               
               //Método que sirve para diparar la bala
               metodosBala.dispararCañon();
               metodosBala.estadoInicialBala();
               
               //Condición que evalua los movimientos del enemigo01
               if(metodosEnemigo.puedeMoverse()) {
                   metodosEnemigo.moverse();
               }else {
                   metodosEnemigo.cambiarDireccion();
               }
               
               //Método del enemigo
               metodosEnemigo.estadoInicialEnemigo();
               
               //Condición que evalua los movimientos del enemigo02
               if(metodosEnemigo02.puedeMoverse()) {
                   metodosEnemigo02.moverse();
               }else {
                   metodosEnemigo02.cambiarDireccion();
               }
               
               //Método del enemigo02
               metodosEnemigo02.estadoInicialEnemigo();

               //Métodos que comprueban las colisiones entre los objetos
               if(ventana.detectarColisionNave() || metodosEnemigo.comprobarEnemigo() || ventana.detectarColisionNave02() || metodosEnemigo02.comprobarEnemigo()) {
                   this.ventana.setVisible(false);
                   this.fRM_RegistroJugador.setVisible(true);
                   metodosEnemigo.estadoInicial_01();
                   metodosEnemigo02.estadoInicial_02();
               }
               
               //Método que evalua si la bala colisionó contra la nave enemigo
               ventana.detectarColisionBala();
               ventana.detectarColisionBalaEnemigo02();
                                          
           }
           
           
       }
       catch(Exception e)
       {
           System.out.println("Error en la ejecución hilo juego: "+e);
       }
   }
   
   public void cronometro() {
       
       
       
   }
   
  
}//Fin de la clase HiloJuego
