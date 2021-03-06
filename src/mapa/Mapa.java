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
    protected Cuadro[] cuadrosCatalogo;
    
    public Mapa(int ancho, int alto){
        this.ancho = ancho;
        this.alto = alto;
        
        cuadros = new int[ancho * alto];
        generarMapa();
    
    }
    
    public Mapa(String ruta){
        cargarMapa(ruta);
        generarMapa();
        
    }
    
    protected void generarMapa(){
    
        
    }
    
    protected void cargarMapa(String ruta){
    
        
    }
    
    public void actualizar(){
    
    }
    
    public void mostrar(final int compensacionX, final int compensacionY, Pantalla pantalla){
       
        pantalla.estanlece_diferencia(compensacionX, compensacionY);
        
        int oeste = compensacionX >>5; // /32
        int este = (compensacionX + pantalla.get_ancho()+ Cuadro.LADO)>>5;
        int norte = compensacionY >>5; 
        int sur = (compensacionY + pantalla.get_alto() + Cuadro.LADO)>>5;
        
        for(int y = norte; y<sur;y++){
            for(int x = oeste;x<este;x++){
                //get_cuadro(x,y).mostrar(x, y, pantalla);
                if(x < 0  || y < 0 || x >= ancho || y >= alto){
                    Cuadro.VACIO.mostrar(x, y, pantalla);
                }else{
                    cuadrosCatalogo[x + y * ancho].mostrar(x, y, pantalla);
                }
            }
        }
    }
    
    public Cuadro get_cuadro(final int x,final int y){
        if(x <0 || y<0 || x >= ancho || y >= alto ){
            return Cuadro.VACIO;
        }
        switch(cuadros[x+y *ancho]){
            case 0:
                return Cuadro.PASTO;
            case 1: 
                return Cuadro.AGUA;
                
                
            default:
                return Cuadro.VACIO;
            
        }
        
        
    }
}
