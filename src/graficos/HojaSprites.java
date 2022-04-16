/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Eber
 */
public class HojaSprites {
    public final int [] pixeles;
    private final int ancho;
    private final int alto;
    public HojaSprites(final String ruta,final int ancho,final int alto){
        this.alto = alto;
        this.ancho = ancho;
        
        pixeles = new int[ancho*alto];
        
        try {
            BufferedImage imagen = ImageIO.read(HojaSprites.class.getResource(ruta));
            imagen.getRGB(0, 0, ancho, alto, pixeles, 0, ancho);
        } catch (IOException ex) {
            Logger.getLogger(HojaSprites.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int get_ancho(){
        return ancho;
    }

}
