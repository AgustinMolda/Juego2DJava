/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegorol2d;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Eber
 */
public class JuegoRol2D extends Canvas implements Runnable {

    private static JFrame ventana;
    private static Thread thread;
    private static final int ANCHO = 800;
    private static final int ALTO = 600;
    
    private static final String NOMBRE = "Juego";
    private JuegoRol2D(){
        setPreferredSize(new Dimension(ANCHO,ALTO));
        ventana  = new JFrame(NOMBRE);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setLayout(new BorderLayout());
        ventana.add(this, BorderLayout.CENTER);
        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        
        
    }
    
    public static void main(String[] args){
          JuegoRol2D juego = new JuegoRol2D();
          juego.iniciar();
        }

    
    private void iniciar(){
        thread = new Thread(this, "Graficos");
        thread.start();
    }
    
    private void detener(){
        
    }
   
    public void run() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("El thread funca con exito");
    }
}
