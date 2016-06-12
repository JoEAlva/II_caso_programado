/*
 * Segundo proyecto programado del curso de programación.
 * Universidad de Costa Rica - Sede del Pacífico Arnoldo Ferreto Segura
 */
package vista;
import java.awt.Rectangle;
import modelo.HiloJuego;
import modelo.MetodosBala;
import modelo.MetodosPersonaje;
import modelo.MetodosEnemigo01;
import modelo.MetodosEnemigo02;
import modelo.MetodosPuntaje;


/**
 *
 * @author JorgeIgnacioElizondoAlvarado
 */
public class FRM_VentanaJuego extends javax.swing.JFrame {

    //Referencias de clases
    HiloJuego hilo;
    FRM_VentanaInicio fRM_VentanaInicio;
    FRM_RegistroJugador fRM_RegistroJugador;
    
    //Referencias de métodos
    MetodosPersonaje metodosPersonaje;
    MetodosEnemigo01 metodosEnemigo01;
    MetodosEnemigo02 metodosEnemigo02;
    MetodosBala metodosBala;
    MetodosPuntaje metodosPuntaje;
    
    //Variables de la clase
    int puntaje = 0;
    int num = 0;
    
    //Se declaran las variables
    public String estado = "EnELSuelo";
    public String bala = "";
    
    //Constructor de la clase
    public FRM_VentanaJuego(FRM_VentanaInicio fRM_VentanaInicio, FRM_RegistroJugador fRM_RegistroJugador) {
        initComponents();
        
        this.setSize(980, 680);
        this.setLocation(200, 10);
        
        //Instancias de la clase
        metodosPersonaje = new MetodosPersonaje(this);
        metodosEnemigo01 = new MetodosEnemigo01(this);
        metodosEnemigo02 = new MetodosEnemigo02(this);
        metodosBala = new MetodosBala(this);
        metodosPuntaje = new MetodosPuntaje(this);
                
        //Instancia de la clase hileJuego
        this.fRM_VentanaInicio = fRM_VentanaInicio;
        this.fRM_RegistroJugador = fRM_RegistroJugador;
        hilo = new HiloJuego(this, metodosPersonaje, metodosEnemigo01, metodosBala, this.fRM_RegistroJugador, metodosEnemigo02);
        hilo.start();
                
    }//Fin del constructor de la clase
    
    /*
    Método que se encagar de verificar si hubo una colisión entre el personaje
    y la nave enemigo
    */
    public boolean detectarColisionNave() {
        
        boolean colision = false;
        int xPersonaje = jL_Personaje.getX();
        int yPersonaje = jL_Personaje.getY();
        
        int xEnemigo = jL_naveEnemigo01.getX();
        int yEnemigo = jL_naveEnemigo01.getY();
        
        
        Rectangle p = new Rectangle(xPersonaje, yPersonaje, jL_Personaje.getWidth(), jL_Personaje.getHeight());
        Rectangle e = new Rectangle(xEnemigo, yEnemigo, jL_naveEnemigo01.getWidth(), jL_naveEnemigo01.getHeight());
        
        if(p.intersects(e)) {
            
            colision = true;
            fRM_RegistroJugador.agregarPuntaje(metodosPuntaje.getPuntaje());
//            hilo.suspend();
            
        }
        return colision;
    }//Fin del método detectarColisionNave()
    
    /*
    Método que se encagar de verificar si hubo una colisión entre el personaje
    y la nave enemigo
    */
    public boolean detectarColisionNave02() {
        
        boolean colision = false;
        int xPersonaje = jL_Personaje.getX();
        int yPersonaje = jL_Personaje.getY();
        
        int xEnemigo = jL_naveEnemigo02.getX();
        int yEnemigo = jL_naveEnemigo02.getY();
        
        
        Rectangle p = new Rectangle(xPersonaje, yPersonaje, jL_Personaje.getWidth(), jL_Personaje.getHeight());
        Rectangle e = new Rectangle(xEnemigo, yEnemigo, jL_naveEnemigo02.getWidth(), jL_naveEnemigo02.getHeight());
        
        if(p.intersects(e)) {
            
            colision = true;
            fRM_RegistroJugador.agregarPuntaje(metodosPuntaje.getPuntaje());
//            hilo.suspend();
            
        }
        return colision;
    }//Fin del método detectarColisionNave02()
    
    
    
     /*
    Método que se encagar de verificar si hubo una colisión entre el personaje
    y la nave enemigo
    */
    public void detectarColisionBala() {
        //Si detectar colisión true aumente el puntaje. Esto en el hilo
        int xBala = jL_Bala.getX();
        int yBala = jL_Bala.getY();
        
        int xEnemigo =jL_naveEnemigo01.getX();
        int yEnemigo = jL_naveEnemigo01.getY();
        
        Rectangle b = new Rectangle(xBala, yBala, jL_Bala.getWidth(), jL_Bala.getHeight());
        Rectangle e = new Rectangle(xEnemigo, yEnemigo, jL_naveEnemigo01.getWidth(), jL_naveEnemigo01.getHeight());
        
        //Condición que evalua si el objeto bala colisionó con el enemigo01
        if(b.intersects(e)) {
            
            metodosEnemigo01.estadoInicial_01();
            //Método que se encarga de aumentar el puntaje por cada nave destruida
            metodosPuntaje.puntaje();
            agregarPuntaje(metodosPuntaje.getPuntaje());
        }
        
    }
    
    /*
    Método que se encagar de verificar si hubo una colisión entre el personaje
    y la nave enemigo
    */
    public void detectarColisionBalaEnemigo02() {
        //Si detectar colisión true aumente el puntaje. Esto en el hilo
        int xBala = jL_Bala.getX();
        int yBala = jL_Bala.getY();
        
        int xEnemigo =jL_naveEnemigo02.getX();
        int yEnemigo = jL_naveEnemigo02.getY();
        
        Rectangle b = new Rectangle(xBala, yBala, jL_Bala.getWidth(), jL_Bala.getHeight());
        Rectangle e = new Rectangle(xEnemigo, yEnemigo, jL_naveEnemigo02.getWidth(), jL_naveEnemigo02.getHeight());
        
        //Condición que evalua si el objeto bala colisionó con el enemigo01
        if(b.intersects(e)) {
            
            metodosEnemigo02.estadoInicial_02();

            //Método que se encarga de aumentar el puntaje por cada nave destruida
            metodosPuntaje.puntaje();
            agregarPuntaje(metodosPuntaje.getPuntaje());
        }
        
    }
        
    
    public void agregarTiempo(String tiempo) {
        this.jL_Tiempo.setText(tiempo);
    }
    
    public void agregarPuntaje(String puntaje) {
        this.jL_Puntaje.setText(puntaje);
    }

    public void limpiarTiempo() {
        this.jL_Tiempo.setText("");
    }
    public void limpiarPuntaje() {
        this.jL_Puntaje.setText("");
    }
    public void resetearPuntaje() {
        this.metodosPuntaje.estadoInicialPuntaje();
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
        jL_Tiempo = new javax.swing.JLabel();
        jL_Puntaje = new javax.swing.JLabel();
        jL_naveEnemigo01 = new javax.swing.JLabel();
        jL_Bala = new javax.swing.JLabel();
        jL_naveEnemigo02 = new javax.swing.JLabel();
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
        getContentPane().setLayout(null);

        jL_Personaje.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nave-personaje.png"))); // NOI18N
        jL_Personaje.setPreferredSize(new java.awt.Dimension(130, 105));
        getContentPane().add(jL_Personaje);
        jL_Personaje.setBounds(440, 560, 110, 90);

        jL_Tiempo.setBackground(new java.awt.Color(153, 153, 153));
        jL_Tiempo.setFont(new java.awt.Font("Impact", 2, 12)); // NOI18N
        jL_Tiempo.setForeground(new java.awt.Color(0, 255, 255));
        jL_Tiempo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jL_Tiempo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 255, 255), new java.awt.Color(0, 255, 255), null, null), "TIEMPO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Impact", 2, 14), new java.awt.Color(0, 255, 255))); // NOI18N
        getContentPane().add(jL_Tiempo);
        jL_Tiempo.setBounds(870, 0, 100, 40);

        jL_Puntaje.setBackground(new java.awt.Color(153, 153, 153));
        jL_Puntaje.setFont(new java.awt.Font("Impact", 2, 12)); // NOI18N
        jL_Puntaje.setForeground(new java.awt.Color(0, 255, 255));
        jL_Puntaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jL_Puntaje.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 255, 255), new java.awt.Color(0, 255, 255), null, null), "PUNTAJE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Impact", 2, 14), new java.awt.Color(0, 255, 255))); // NOI18N
        getContentPane().add(jL_Puntaje);
        jL_Puntaje.setBounds(870, 40, 100, 40);

        jL_naveEnemigo01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nave-enemigo.png"))); // NOI18N
        getContentPane().add(jL_naveEnemigo01);
        jL_naveEnemigo01.setBounds(10, 10, 110, 76);

        jL_Bala.setForeground(new java.awt.Color(0, 255, 255));
        jL_Bala.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bala-plasma.gif"))); // NOI18N
        jL_Bala.setPreferredSize(new java.awt.Dimension(30, 30));
        getContentPane().add(jL_Bala);
        jL_Bala.setBounds(480, 590, 30, 30);

        jL_naveEnemigo02.setForeground(new java.awt.Color(255, 0, 204));
        jL_naveEnemigo02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nave-enemigo02.png"))); // NOI18N
        getContentPane().add(jL_naveEnemigo02);
        jL_naveEnemigo02.setBounds(860, 10, 110, 80);

        jl_Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondo-juego.png"))); // NOI18N
        getContentPane().add(jl_Fondo);
        jl_Fondo.setBounds(0, 0, 980, 680);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed

        if(evt.getKeyCode() == 65 ) {

            estado = "izquierda";
            
        }
        if(evt.getKeyCode() == 68) {
            estado = "derecha";
            
        }
//        if(evt.getKeyCode() == 87) {
//            estado = "arriba";
//            
//        }
//        if(evt.getKeyCode() == 83) {
//            estado = "abajo";
//            
//        }
        
        if(evt.getKeyCode() == 32) {
            bala = "disparo";
            
        }
        
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        
        if(evt.getKeyCode() == 65 ) {

            estado = "EnELSuelo";
            
        }
        if(evt.getKeyCode() == 68) {
            estado = "EnELSuelo";
            
        }
        
    }//GEN-LAST:event_formKeyReleased
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel jL_Bala;
    public javax.swing.JLabel jL_Personaje;
    private javax.swing.JLabel jL_Puntaje;
    private javax.swing.JLabel jL_Tiempo;
    public javax.swing.JLabel jL_naveEnemigo01;
    public javax.swing.JLabel jL_naveEnemigo02;
    private javax.swing.JLabel jl_Fondo;
    // End of variables declaration//GEN-END:variables


}//Fin de la clase FRM_VentanaJuego
