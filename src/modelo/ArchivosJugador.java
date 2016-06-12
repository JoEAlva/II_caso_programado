/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author JorgeIgnacioElizondoAlvarado
 */
public class ArchivosJugador 
{
    
    ObjectOutputStream salida;
    ObjectInputStream entrada;
    
    /*
    crearArchivosUsuario
    */
    public void crearArchivoJugador()
    {
        try
        {
            salida = new ObjectOutputStream( new FileOutputStream("jugador.dat") );
            System.out.println("Se creó el archivo jugador correctamente");
        }
        catch(Exception ex)
        {
            System.out.println("No se creó el archivo jugador " + ex);
        }
    }//End crearArchivosUsuario
    
    /*
    addInfoFileStudent
    */
    public void escribirInfoArchivoJugador(Jugador jugador)
    {
        try
        {
            salida.writeObject(jugador);
            System.out.println("Se escribió en el archivo jugador");
        }
        catch(Exception ex)
        {
            System.out.println("Error al escribir en el archivo jugador " + ex);
        }
    }//End addInfoFileStudent
    
    /*
    chargeInfoFileStudent
    */
    public boolean cargarInfoArchivoJugador()
    {
        boolean existe = false;
        try
        {
            entrada = new ObjectInputStream( new FileInputStream("jugador.dat"));
            existe = true;
        }
        catch(Exception ex)
        {
            System.out.println("Error al cargar la información " + ex);
        }
        
        return existe;
        
    }//End chargeInfoFileStudent
    
    /*
    leerInformacionArchivo
    */
    public ArrayList<Jugador> leerInfoArchivoEstudiante() {
        
        ArrayList<Jugador> arrayJugador = new ArrayList<Jugador>();
        
        try
        {
           while(true)
           {
               arrayJugador.add((Jugador)entrada.readObject());
           }
           
        }
        catch(Exception e)
        {
            System.out.println("Se llegó al final dal archivo " + e);
        }
        
        return arrayJugador;
        
    }//leerInfoArchivoEstudiente
    
}
