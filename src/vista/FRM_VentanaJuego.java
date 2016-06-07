/*
 * Segundo proyecto programado del curso de programación.
 * Universidad de Costa Rica - Sede del Pacífico Arnoldo Ferreto Segura
 */
package vista;
import java.awt.Rectangle;
import modelo.HiloJuego;
import modelo.MetodosBala;
import modelo.MetodosPersonaje;
import modelo.MetodosEnemigo;


/**
 *
 * @author JorgeIgnacioElizondoAlvarado
 */
public class FRM_VentanaJuego extends javax.swing.JFrame {

    //Referencias de clases
    HiloJuego hilo;

    MetodosPersonaje metodosPersonaje;
    MetodosEnemigo metodosEnemigo;
    MetodosBala metodosBala;
    
    //Se declaran las variables
    public String estado = "EnELSuelo";
    public String bala = "cargada";
    
    //Constructor de la clase
    public FRM_VentanaJuego() {
        initComponents();
        
        this.setLocation(200, 10);
        
        //Instancias de la clase
        metodosPersonaje = new MetodosPersonaje(this);
        metodosEnemigo = new MetodosEnemigo(this);
        metodosBala = new MetodosBala(this);
        
        hilo = new HiloJuego(this, metodosPersonaje, metodosEnemigo, metodosBala);
        hilo.start();
                        
    }
    
    /**
     * Método que posiciona la imagen de fondo en su posición inicial obteniendo
     * la posición en -y-. Si el valor de la imagen en -y- es menor que -50y lo de
     * vuvuelve a su ligar inicial.
     */
//    public void moverFondo()
//    {
//        if(jl_Fondo.getY()<-50)
//        {
//            jl_Fondo.setLocation(jl_Fondo.getX(),jl_Fondo.getY()+9);
//        }
//        else
//        {
//            jl_Fondo.setLocation(jl_Fondo.getX(), -2000);
//        }
//    }
    
    public void detectarColision() {
        int xPersonaje = jL_Personaje.getX();
        int yPersonaje = jL_Personaje.getY();
        
        int xEnemigo = jL_naveEnemigo01.getX();
        int yEnemigo = jL_naveEnemigo01.getY();
        
        
        Rectangle p = new Rectangle(xPersonaje, yPersonaje, jL_Personaje.getWidth(), jL_Personaje.getHeight());
        Rectangle e = new Rectangle(xEnemigo, yEnemigo, jL_naveEnemigo01.getWidth(), jL_naveEnemigo01.getHeight());
        
        if(p.intersects(e)) {
            System.out.println("Surpraise");
            hilo.suspend();
        }
    }
    
    public void agregarTiempo(String tiempo) {
//        this.jL_Tiempo.setText(tiempo);
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jL_Personaje = new javax.swing.JLabel();
        jL_naveEnemigo01 = new javax.swing.JLabel();
        jL_Bala = new javax.swing.JLabel();
        jl_Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jL_Personaje.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nave-personaje.png"))); // NOI18N
        jL_Personaje.setPreferredSize(new java.awt.Dimension(130, 105));
        getContentPane().add(jL_Personaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, 110, 90));

        jL_naveEnemigo01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nave-personaje.png"))); // NOI18N
        getContentPane().add(jL_naveEnemigo01, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 110, -1));

        jL_Bala.setForeground(new java.awt.Color(0, 255, 255));
        jL_Bala.setText("BALA");
        getContentPane().add(jL_Bala, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, -1, -1));

        jl_Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondo-juego.png"))); // NOI18N
        getContentPane().add(jl_Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 680));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed

        if(evt.getKeyCode() == 65 ) {

            estado = "izquierda";
            
        }
        if(evt.getKeyCode() == 68) {
            estado = "derecha";
            
        }
        if(evt.getKeyCode() == 87) {
            System.out.println("Funciona");
            estado = "arriba";
            
        }
        if(evt.getKeyCode() == 83) {
            estado = "abajo";
            
        }
        
        if(evt.getKeyCode() == 32) {
            
            bala = "disparo";
            
        }
        
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased

        if(evt.getKeyCode() == 65 ) {
            
            estado = "EnElSuelo";
            
        }
        if(evt.getKeyCode() == 68) {
            
            estado = "EnElSuelo";
            
        }
        if(evt.getKeyCode() == 87) {
            
            estado = "EnElSuelo";
            
        }
        if(evt.getKeyCode() == 83) {
            
            estado = "EnELSuelo";
            
        }
        
        if(evt.getKeyCode() == 32) {
            
            bala = "disparo";
            
        }
        
    }//GEN-LAST:event_formKeyReleased
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel jL_Bala;
    public javax.swing.JLabel jL_Personaje;
    public javax.swing.JLabel jL_naveEnemigo01;
    private javax.swing.JLabel jl_Fondo;
    // End of variables declaration//GEN-END:variables


}//Fin de la clase FRM_VentanaJuego
