/*
 * Segundo proyecto programado del curso de programación.
 * Universidad de Costa Rica - Sede del Pacífico Arnoldo Ferreto Segura
 */
package modelo;
import vista.FRM_VentanaCreditos;
/**
 *
 * @author JorgeIgnacio
 */
public class HiloCreditos extends Thread{

    //Referencias de clase
    FRM_VentanaCreditos fRM_VentanaCreditos;
    
    //COnstructor de la clase
    public HiloCreditos(FRM_VentanaCreditos fRM_VentanaCreditos) {
        this.fRM_VentanaCreditos = fRM_VentanaCreditos;
    }

        
    public void run() {
        
        try {
            
            while (true) {
                
                try {
                    sleep(100);
                    fRM_VentanaCreditos.moverFondo();
                    
                } catch (Exception e) {
                    System.err.println("Error en " + e);
                }
                
            }
            
        } catch (Exception e) {
            System.err.println("Error " + e);
        }
        
    }
        
}//Fin de la clase HiloCreditos
