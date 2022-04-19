/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapa.cuadro;

import graficos.Pantalla;
import graficos.Sprite;

/**
 *
 * @author Eber
 */
public abstract class Cuadro {
    public int x;
    public int y;
    
    public Sprite sprite;
    
    //Coleccion de cuadros
        public static final Cuadro asfalto = new CuadroAsfalto(Sprite.ASFALTO);
        
    //fin de la coleccion de cuadros
    
    
    public Cuadro(Sprite sprite){
        this.sprite = sprite;
    
    }
    
    public void mostrar(int x,int y, Pantalla pantalla){
        
    }
    
    public boolean solido(){
        
        
         return false;
    }
}
