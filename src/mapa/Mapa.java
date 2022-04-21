/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapa;

import graficos.Pantalla;
import mapa.cuadro.Cuadro;

/**
 *
 * @author Eber
 */
public abstract class Mapa {
    protected int ancho;
    protected int alto;
    
    protected int[] cuadros;
    
    public Mapa(int ancho, int alto){
        this.ancho = ancho;
        this.alto = alto;
        
        cuadros = new int[ancho * alto];
        generarMapa();
    
    }
    
    public Mapa(String ruta){
        cargarMapa(ruta);
        
    }
    
    protected void generarMapa(){
    
        
    }
    
    private void cargarMapa(String ruta){
    
        
    }
    
    public void actualizar(){
    
    }
    
    public void mostrar(final int compensacionX, final int compensacionY, Pantalla pantalla){
        int oeste = compensacionX >>5; // /32
        int este = (compensacionX + pantalla.get_ancho())>>5;
        int norte = compensacionY >>5; 
        int sur = (compensacionY + pantalla.get_alto())>>5;
        
        
    }
    
    public Cuadro get_cuadro(final int x,final int y){
        switch(cuadros[x+y *ancho]){
            case 0:
                return Cuadro.ASFALTO;
                
                
            default:
                return null;
            
        }
        
        
    }
}
