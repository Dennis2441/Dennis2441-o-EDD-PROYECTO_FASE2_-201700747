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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;


public class listacirculardoble {
    nodocircular raiz,ultimo;
   public String[] veral;
   public int[] verhol;
    public listacirculardoble() {
        this.raiz = null;
        this.ultimo = null;
    }
    
    
    public void insertarInicio(String d,int[] hol){
         nodocircular nuevo=new nodocircular(d,hol);
         if(raiz==null){
            raiz=nuevo;
          raiz.siguiente=raiz;
          nuevo.anterior=ultimo;
          ultimo=nuevo;
         }
         else{
                   nodocircular aux=raiz;
                   
                 ultimo.siguiente = nuevo;
            nuevo.siguiente = raiz;
            nuevo.anterior = ultimo;
            ultimo = nuevo;
            raiz.anterior = ultimo;
                  
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
     public void imprimir( ){
         nodocircular temp=raiz;
         StringBuilder dot = new StringBuilder();
         String actual="";
         String sig="";
         String[] ver;
         int con=0;
         dot.append("""
                    digraph G {
                    rankdir=TB;
                    node [shape=circle];
                    """);
         
         
         do {             
             con=con+1;
             temp=temp.siguiente;
         } while (temp!=raiz);
         nodocircular aux=raiz;
         
      //  ver= new String[con];
      String rank="";
      con=1;
       int  con0=0;
         do {    
             dot.append(" p"+con+"[label=\""+ aux.dato+"\"];\n");
         //     ver[con0]=aux.dato;
               rank=rank+" p"+con;
              con=con+1;
              
              con0=con0+1;
              if (actual=="") {
                 actual="p1";
             }
              aux=aux.siguiente;
             
         } while (aux!=raiz);
              
              
                  
         
         
         
         temp=raiz;
         con=1;
         int con2=1;
         
         do {       if (temp.siguiente==raiz) {
                    if (con2==2) {
                        
                 
             } else {
                        dot.append("p"+con+":s -> p1"+"\n");
                 dot.append("p1 -> p"+con+"\n");
             }
                 
                 dot.append("{rank = same"+rank+"}\n");
                 dot.append("}");
                 break;
             }      
             dot.append("p"+con+" -> p"+(con+1)+"\n");
             dot.append("p"+(con+1)+" -> p"+con+"\n");
             
             
             
             con=con+1;
             con2=con2+1;
             temp=temp.siguiente;
         } while (temp!=raiz);
           
             
             
             
             
             
         
         
         
         System.out.println(dot.toString());
         
         
          try {
             File archivo = new File("C:\\Users\\denni\\Documents\\NetBeansProjects\\fase2\\src\\Imagenes\\circular.txt");
                 FileWriter escritor = new FileWriter(archivo);
            BufferedWriter escritor2 = new BufferedWriter(escritor);
            
            escritor2.write(dot.toString());
            escritor2.close();
            
            
            String[] c = {"dot", "-Tpng", "C:\\Users\\denni\\Documents\\NetBeansProjects\\fase2\\src\\Imagenes\\circular.txt", "-o", "C:\\Users\\denni\\Documents\\NetBeansProjects\\fase2\\src\\Imagenes\\circular.png"};
        Process p = new ProcessBuilder(c).start();
        int err = p.waitFor(); 
         } catch (Exception e) {
         }
         
//         for (String a : ver) {
//             
//             
//             
//             
//             
//         }
         //actual=temp.dato;
     
     
     
     
     }
     
     public boolean buscar(String compara){
     nodocircular aux=raiz;
         
         int cont=0;
         int cont2=0;
         if (raiz==null) {
             
         } else {
         
         do {        
             
             
             if (compara==aux.dato) {
                 for (int i : aux.hol) {
                     cont=cont+1;
                 }
             
             }
                 aux=aux.siguiente;
             
             aux=aux.siguiente;
         } while (aux!=raiz);
     
         verhol= new int[cont];
         
         do {          if (compara==aux.dato) {
                 for (int i : aux.hol) {
                 
                     verhol[cont2]=i;
                     cont2=cont2+1;
             }
             
             
             }
   
             
             
             aux=aux.siguiente;
         } while (aux!=raiz);
         return true;
     }
        return false;
     
     }
    public boolean mostraralbum(){
         nodocircular aux=raiz;
         String ver="";
         int cont=0;
         int cont2=0;
         if (raiz==null) {
            
        } else {
             
             do {         
                 cont=cont+1;
                 aux=aux.siguiente;
             } while (aux!=raiz);
             
             veral= new String[cont];
             
             
             
             do {              veral[cont2]=aux.dato;
             cont2=cont2+1;
                   
                   
         
         aux=aux.siguiente;
              
                 
             } while (aux!=raiz);
             
             return true;
        }
        return false;
         
         
         
        
          
       }
    
}
