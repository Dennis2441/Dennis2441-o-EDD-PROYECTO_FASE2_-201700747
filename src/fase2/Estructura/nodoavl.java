/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fase2.Estructura;

import org.json.simple.JSONArray;

/**
 *
 * @author denni
 */
public class nodoavl {
    
   
  int[] capa;
   
    
    
    int id;
     public Comparable dato;      	 // el dato del nodo
    public nodoavl izquierdo;            // hijo izquierdo
    public nodoavl derecho;              // hijo derecho
    public int height;                   // altura

    // Constructors
    
    public nodoavl(Comparable d,int id,int[] capa ) {
        this.dato=d;
        this.capa=capa;
        this.id=id;
        this.izquierdo=null;
        this.derecho=null;
        
    }

    public nodoavl( Comparable dato,int id,int[] capa, nodoavl izq, nodoavl der ){
        this.dato = dato;
        this.capa=capa;
        this.id=id;
        this.izquierdo = izq;
        this.derecho = der;
        height   = 0;               // altura predeterminada
    }
    
    
}
