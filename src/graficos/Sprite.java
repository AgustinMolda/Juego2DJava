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
            cargaManipulada(version);
        }
    }
    
    private void cargaNormal(){
         for(int y=0;y<lado;y++){
            for(int x = 0; x<lado; x++){
                pixeles[x + y * lado] = hoja.pixeles[(x + this.x) + (y + this.y) * hoja.get_ancho()];
            }
        }
     }
    
    private void cargaManipulada(int version){
        int[] pixelesTemporales = iniciarPixelesTemporales();
        
        switch(version){
            case 1:
                invertirX(pixelesTemporales);
                break;
            case 2:
                invertirY(pixelesTemporales);
                break;
            
            case 3:
                invertirXY(pixelesTemporales);
                break;
            
            case 4:
                rotar90Izquierda(pixelesTemporales);
                break;   
            
            case 5:
                rotar90Derecha(pixelesTemporales);
                break;
                
             case 6:
                 rotarIzquierdaYInvertido(pixelesTemporales);
                break;
                
              case 7:
                  rotarDerechaYInvertido(pixelesTemporales);
                break; 
                
              default:
                        cargaNormal();
        }
    }
    
    
    private int[] iniciarPixelesTemporales(){
        int[] pixelesTemporales = new int[lado *lado];
         for(int y=0;y<lado;y++){
            for(int x = 0; x<lado; x++){
                pixelesTemporales[x + y * lado] = hoja.pixeles[(x + this.x) + (y + this.y) * hoja.get_ancho()];
            }
        }
         
         return pixelesTemporales;
    }
    
    
    //1
    private void invertirX(int[] pixelesTemporales){
        int i = 0;
        for(int y = 0;y< lado;y++){
            for(int x= lado-1; x>-1;x--){
                   pixeles[i] = pixelesTemporales[x+y*lado];
                   i++;
            }
        }
        
    
    }
    //2
    private void invertirY(int[] pixelesTemporales){
            int i = 0;
        for(int y = lado -1 ;y > -1; y--){
            for(int x=0 ; x<lado;x++){
                   pixeles[i] = pixelesTemporales[x+y*lado];
                   i++;
            }
        }
    }
    
    //3
    private void invertirXY(int[] pixelesTemporales){
     for(int i =0; i< pixeles.length;i++){
         pixeles[i] = pixelesTemporales[pixelesTemporales.length -1 - i];
     }
    }
    
    //4 
    private void rotar90Izquierda(int[] pixelesTemporales){
              int i = 0;
        for(int x = lado -1;x> -1;x--){
            for(int y= 0; y<lado;y++){
                   pixeles[i] = pixelesTemporales[x+y*lado];
                   i++;
            }
        }
        
    
        
    }
    //5
    private void rotar90Derecha(int[] pixelesTemporales){
        int i = 0;
        for(int x = 0 ;x< lado;x++){
            for(int y = lado -1; y> -1;y--){
                   pixeles[i] = pixelesTemporales[x+y*lado];
                   i++;
            }
        }
    }
    
    //6
    private void rotarIzquierdaYInvertido(int[] pixelesTemporales){
        int i =0;  
        for(int x = 0 ;x< lado;x++){
            for(int y = 0; y<lado;y++){
                   pixeles[i] = pixelesTemporales[x+y*lado];
                   i++;
            }
        }
        
    
    }
    
    //7
    private void rotarDerechaYInvertido(int[] pixelesTemporales){
           int i =0;  
        for(int x = lado ;x>= -1;x--){
            for(int y = lado -1; y> -1;y--){
                   pixeles[i] = pixelesTemporales[x+y*lado];
                   i++;
            }
        }
        
    }
    
}
