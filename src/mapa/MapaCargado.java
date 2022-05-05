/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapa;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import mapa.cuadro.Cuadro;

/**
 *
 * @author Eber
 */
public class MapaCargado extends Mapa {
    
    private int[] pixeles;
    
    public MapaCargado(String ruta) {
        super(ruta);
    }
    
    protected void cargarMapa(String ruta){
        try {
            BufferedImage imagen = ImageIO.read(MapaCargado.class.getResource(ruta));
            
            
            ancho = imagen.getWidth();
            alto = imagen.getHeight();
            
            cuadrosCatalogo = new Cuadro[ancho *  alto];
            pixeles = new int[ancho * alto];
            
            imagen.getRGB(0, 0, ancho, alto, pixeles, 0, ancho);
            
        } catch (IOException ex) {
            Logger.getLogger(MapaCargado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    protected void generarMapa(){
        for(int i = 0; i< pixeles.length;i++){
         
            
            switch(pixeles[i]){
                case 0xff17d11b:
                    cuadrosCatalogo[i] = Cuadro.PASTO;
                    continue;
                case 0xff7095fe:
                    cuadrosCatalogo[i] = Cuadro.AGUA;
                    continue;
                default:
                    cuadrosCatalogo[i] = Cuadro.VACIO;
            }
        }
    }
    
    
    
}
