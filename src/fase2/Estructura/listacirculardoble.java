/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fase2.Estructura;

/**
 *
 * @author denni
 */
import fase2.Visualizar;
public class listacirculardoble {
    nodocircular raiz;
    
    
    public void insertarInicio(String d,int[] hol){
         nodocircular nuevo=new nodocircular(d,hol);
         if(raiz==null)
                   raiz=nuevo;
         else{
                   nodocircular aux=raiz;
                   while(aux.siguiente!=raiz)
                            aux=aux.siguiente;
                   aux.siguiente=nuevo;
                   nuevo.anterior=aux;
                   nuevo.siguiente=raiz;
                   raiz.anterior=nuevo;
                   raiz=nuevo;
                  
         }
       }
    

    public boolean mostrarimagen(String d){
         nodocircular aux=raiz;
         String ver="";
         while((aux.siguiente!=raiz) && aux.dato!=d){
                   aux=aux.siguiente;}
         
         if (aux.dato==d) {
             for (int i = 0; i < aux.hol.length; i++) {
                 ver=String.valueOf(aux.hol[i]);
                 Visualizar.ima.addItem(ver);
                 
             }
             return true;
        }
        return false;
          
       }
    
    
    public nodocircular nullo(){
    return raiz;
    
    }
    
    public boolean mostraralbum(){
         nodocircular aux=raiz;
         String ver="";
         if (raiz==null) {
            
        } else {
             
             while(aux.siguiente!=raiz){
                   aux=aux.siguiente;
         Visualizar.ima.addItem(ver);
         return true;
         }
        }
        return false;
         
         
         
        
          
       }
    
}
