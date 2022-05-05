/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;

/**
 *
 * @author Eber
 */
public final class Sprite {
    private final int lado;
    
    private int x;
    private int y;
    
    
    public int[] pixeles;
    private  HojaSprites hoja;
    
    
    //Coleccion de sprites
        public static final Sprite PASTO = new Sprite(32,0,0,0,HojaSprites.desierto);
        public static final Sprite VACIO = new Sprite(32,0);
        public static final Sprite AGUA = new Sprite(32,0,1,0,HojaSprites.desierto);
        
    
    //fin de la coleccion
    
    public Sprite(int lado, final int columna,final int fila,final int version,final HojaSprites hoja){
        this.lado = lado;
        
        pixeles = new int[lado * lado];
        
        this.hoja = hoja;
        this.x = columna * lado;
        this.y = fila * lado;
        
      
        cargarSprite(version);
        
        
    
    }
    
    public Sprite(final int lado, final int color){
        this.lado = lado;
        pixeles = new int[lado * lado];
        for(int i = 0; i<pixeles.length;i++){
            pixeles[i] = color;
        }
    }
    
    public int get_lado(){
        return lado;
    }
    
    private void cargarSprite(int version){
        if(version == 0){
            cargaNormal();
        }else{
            
        }
    }
    
    private void cargaNormal(){
         for(int y=0;y<lado;y++){
            for(int x = 0; x<lado; x++){
                pixeles[x + y * lado] = hoja.pixeles[(x + this.x) + (y + this.y) * hoja.get_ancho()];
            }
        }
     }
    
    
    
}
