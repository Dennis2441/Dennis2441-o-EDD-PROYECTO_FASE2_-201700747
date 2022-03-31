/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fase2.Estructura;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author denni
 */

    
    import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class prueba {

public static class nodoavl {
    
   
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

public static class avl {
    
  private nodoavl root;
 public int[] capav;
    public void insert( Comparable x,int id,int[] capa ){
        root = this.insert(x, id,capa, root);
    }

    /*
     * x es una instancia de una clase que implementa Comparable
    */
    private nodoavl insert( Comparable x,int id,int[] capa ,nodoavl t ){
        if( t == null )
            t = new nodoavl( x, id,capa ,null, null );
        else if( x.compareTo( t.dato ) < 0 ) {
            t.izquierdo = insert( x, id,capa,t.izquierdo );
            if( height( t.izquierdo ) - height( t.derecho ) == 2 )
                if( x.compareTo( t.izquierdo.dato ) < 0 )
                    t = rotateWithLeftChild( t ); /* Caso 1 */
                else
                    t = doubleWithLeftChild( t ); /* Caso 2 */
        }
        else if( x.compareTo( t.dato ) > 0 ) {
            t.derecho = insert( x, id,capa,t.derecho );
            if( height( t.derecho ) - height( t.izquierdo ) == 2 )
                if( x.compareTo( t.derecho.dato ) > 0 )
                    t = rotateWithRightChild( t ); /* Caso 4 */
                else
                    t = doubleWithRightChild( t ); /* Caso 3 */
        }
        else
            ; // Duplicado; no hago nada
        t.height = max( height( t.izquierdo ), height( t.derecho ) ) + 1;
        return t;
    }


    private static int max( int lhs, int rhs ){
        return lhs > rhs ? lhs : rhs;
    }


    private static nodoavl rotateWithLeftChild( nodoavl k2 ){
        nodoavl k1 = k2.izquierdo;
        k2.izquierdo = k1.derecho;
        k1.derecho = k2;
        k2.height = max( height(k2.izquierdo), height(k2.derecho)) + 1;
        k1.height = max( height( k1.izquierdo ), k2.height ) + 1;
        return k1;
    }


    private static nodoavl rotateWithRightChild( nodoavl k1 ){
        nodoavl k2 = k1.derecho;
        k1.derecho = k2.izquierdo;
        k2.izquierdo = k1;
        k1.height = max( height(k1.izquierdo), height(k1.derecho) ) + 1;
        k2.height = max( height( k2.derecho ), k1.height ) + 1;
        return k2;
    }


    private static nodoavl doubleWithLeftChild( nodoavl k3 ){
        k3.izquierdo = rotateWithRightChild( k3.izquierdo );
        return rotateWithLeftChild( k3 );
    }


    private static nodoavl doubleWithRightChild( nodoavl k1 ){
        k1.derecho = rotateWithLeftChild( k1.derecho );
        return rotateWithRightChild( k1 );
    }


    private static int height( nodoavl t ){
        return t == null ? -1 : t.height;
    }

    /*
     * Imprime el arbol con el recorrido InOrden
     */
    public void imprimir(){
        imprimir(root);
    }

    public boolean search(int id){
            nodoavl aux = root;  
    return search(root, id);
        
    }
    
    
    public  boolean search(nodoavl nodo, int id){
    
    boolean check = false; 

    int cont=0;
    while ((root != null) && !check)  
        {  cont=0;
            
          //  int com=Integer.parseInt((String) root.dato);
            if (nodo.id==id) {
                check = true;  
                for (Object object : nodo.capa) {
                    cont=cont+1;
                    
                }
                
                
                capav= new int[cont];
                cont=0;
                for (int object : nodo.capa) {
                    System.out.println(object);
                    capav[cont]=object;
                    cont=cont+1;
                    
                }
                break;  
            } else if ( nodo.id>id)  {
                nodo = nodo.izquierdo;  
            
            } 
            else if ( nodo.id<id)  {                      
                nodo = nodo.derecho;  }
            else  
            {  
                check = true;  
                for (Object object : nodo.capa) {
                    cont=cont+1;
                    
                }
                
                
                capav= new int[cont];
                cont=0;
                for (int object : nodo.capa) {
                    
                    capav[cont]=object;
                    cont=cont+1;
                    
                }
                break;  
            }  
            check = search(nodo, id);  
        }  
        return check;  
    
    
    }
    private void imprimir(nodoavl nodo){
        if ( nodo != null ){
            imprimir(nodo.derecho);
            System.out.println("["+ nodo.dato + "]");
            System.out.println("["+ nodo.capa + "]");
            imprimir(nodo.izquierdo);
        }
    }

    public void imprimirXaltura(){
        imprimirXaltura ( root );
    }

    /*
     * Imprime cada nodo linea por linea. Recorriendo el arbol desde
     * el Nodo más a la derecha hasta el nodo más a la izquierda,
     * y dejando una identacion de varios espacios en blanco segun su
     * altura en el arbol
     */
    private void imprimirXaltura(nodoavl nodo){
        if ( nodo != null ){
            imprimirXaltura(nodo.derecho);
            System.out.println( replicate(" ",height(root) - height(nodo)) +"["+ nodo.dato + "]");
            imprimirXaltura(nodo.izquierdo);
        }
    }

    /*
     * Metodo estatico auxiliar que dada una cadena a y un enterto cnt
     * replica o concatena esa cadena a, cnt veces
     */
    private static String replicate (String a, int cnt){
        String x = new String("");

        for ( int i = 0; i < cnt; i++ )
            x = x + a;
        return x;
    }

    /*
    * Obtiene la altura del arbol AVL
    */
    public int calcularAltura(){
        return calcularAltura(root);
    }

    private int calcularAltura(nodoavl actual ){
       if (actual == null)
            return -1;
       else
            return 1 + Math.max(calcularAltura(actual.izquierdo), calcularAltura(actual.derecho));
    }

    // Imprime el arbol por niveles. Comienza por la raiz.
    public void imprimirPorNiveles(){
        imprimirPorNiveles(root);
    }

    // Imprime el arbol por niveles.
    private void imprimirPorNiveles(nodoavl nodo){
        // Mediante la altura calcula el total de nodos posibles del árbol
        // Y crea una array cola con ese tamaño
        int max = 0;
        int nivel = calcularAltura();

        for ( ; nivel >= 0; nivel--)
            max += Math.pow(2, nivel);
        max++;      // Suma 1 para no utilizar la posicion 0 del array

        nodoavl cola[] = new nodoavl[ max ];

        // Carga en la pos 1 el nodo raiz
        cola[1] = nodo;
        int x = 1;

        // Carga los demas elementos del arbol,
        // Carga null en izq y der si el nodo es null
        // i aumenta de a 2 por q carga en izq y der los hijos
        // x aumenta 1, que son los nodos raiz - padre
        for (int i = 2; i < max; i += 2, x++){
            if (cola[x] == null){
                cola[i] = null;
                cola[i + 1] = null;
            }
            else{
                cola[i]   = cola[x].izquierdo;
                cola[i + 1] = cola[x].derecho;
            }
        }
        nivel = 0;
        int cont = 0;                       // contador para cada nivel
        int cantidad = 1;                   // cantidad de nodos por nivel
        int ultimaPosicion = 1;             // ultimaPosicion del nodo en la cola de cada nivel

        // Cuando i es = a 2^nivel hay cambio de nivel
        // 2 ^ 0 = 1 que es el nodo raiz
        for (int i = 1; i < max; i++){
            if(i == Math.pow(2, nivel)){
            	// Nodo raiz tiene nivel 1, por eso (nivel + 1)
            	System.out.print("\n Nivel " + (nivel) + ": ");
                nivel++;
            }
            if( cola[i] != null ){
                System.out.print("[" + cola[i].dato + "]");
                cont++;
            }
            if(ultimaPosicion == i  && cantidad == Math.pow(2, --nivel)){
                if(cantidad == 1)
                    System.out.print(" Cantidad de nodos: " + cont + " (raiz)");
                else
                    System.out.print(" Cantidad de nodos: " +  cont);
                cont = 0;
                cantidad *= 2;
                ultimaPosicion += (int)Math.pow(2, ++nivel);
            }
        }
    }
}
public static class nodomatriz{
    String dato;
    int i;
    int j;
    nodomatriz abajo;
    nodomatriz arriba;
    nodomatriz siguiente;
    nodomatriz anterior;

    
    public nodomatriz(int i, int j, String dato) {
        this.i = i;
        this.j = j;
        this.dato = dato;
        this.arriba = null;
        this.abajo = null;
        this.siguiente = null;
        this.anterior = null;

    }

    public String toString() {
        return "(" + i + " ," + j + ")    dato:  " + dato;
    }}

public static class matriz {
    nodomatriz raiz;
public int ro=0;
    public int coll=0;
    public matriz() {
        raiz = new nodomatriz(-1, -1, "Raiz");
    }

    public nodomatriz insertar_en_fila(nodomatriz nuevo, nodomatriz cabeceraFila) {
        nodomatriz actual = cabeceraFila;
        boolean mayorEncontrado = false;
        while (true) {
            if (actual.i > nuevo.i) {
                mayorEncontrado = true;
                break;
            } else if (actual.siguiente != null) {
                actual = actual.siguiente;
            } else {
                break;
            }
        }//end of while
        if (mayorEncontrado) {
            nuevo.siguiente = actual;
            nuevo.anterior = actual.anterior;
            actual.anterior.siguiente = nuevo;
            actual.anterior = nuevo;
        } else {
            actual.siguiente = nuevo;
            nuevo.anterior = actual;
        }
        return nuevo;
    }

    public nodomatriz insertar_en_columna(nodomatriz nuevo, nodomatriz cabeceraColumna) {
        nodomatriz actual = cabeceraColumna;
        boolean mayorEncontrado = false;
        while (true) {
            if (actual.j > nuevo.j) {
                mayorEncontrado = true;
                break;
            } else if (actual.abajo != null) {
                actual = actual.abajo;
            } else {
                break;
            }
        }//end of while
        if (mayorEncontrado) {
            nuevo.abajo = actual;
            nuevo.arriba = actual.arriba;
            actual.arriba.abajo = nuevo;
            actual.arriba = nuevo;
        } else {
            actual.abajo = nuevo;
            nuevo.arriba = actual;
        }
        return nuevo;
    }

    public nodomatriz buscar_columna(int i) {
        nodomatriz actual = raiz;
        while (actual != null) {
            if (actual.i == i) {
                break;
            }
            actual = actual.siguiente;
        }
        return actual;
    }

    public nodomatriz buscar_fila(int j) {
        nodomatriz actual = raiz;
        while (actual != null) {
            if (actual.j == j) {
                break;
            }
            actual = actual.siguiente;
        }
        return actual;
    }

    public nodomatriz crearColumna(int i) {
        return insertar_en_fila(new nodomatriz(i, -1, "Column"), raiz);
    }

    public nodomatriz crearFila(int j) {
        return insertar_en_columna(new nodomatriz(-1, j, "Row"), raiz);
    }

    public String bucar(int i, int j){
    nodomatriz aux=raiz;
    
    
        while (aux!=null) {            
            nodomatriz actual= aux;
            while (actual!=null) {                
                if (actual.i==i && actual.j==j) {
                    return actual.dato;
                }
                actual=actual.abajo;
            }
            
            aux=aux.siguiente;
        }
        return null;
    
    
    }
    public void insertar(int i, int j, String dato) {
        nodomatriz nuevo = new nodomatriz(i, j, dato);
        nodomatriz columna = buscar_columna(i);
        nodomatriz fila = buscar_fila(j);
        
        if (columna == null && fila == null) {
            //La fila y la columna no existen
            columna = crearColumna(i);
            fila = crearFila(j);
            nuevo = insertar_en_fila(nuevo, fila);
            nuevo = insertar_en_columna(nuevo, columna);

        } else if (columna != null && fila == null) {
            //La columna existe pero la fila no
            fila = crearFila(j);
            nuevo = insertar_en_fila(nuevo, fila);
            nuevo = insertar_en_columna(nuevo, columna);

        } else if (columna == null) {
            //La columna no existe pero la fila si
            columna = crearColumna(i);
            nuevo = insertar_en_fila(nuevo, fila);
            nuevo = insertar_en_columna(nuevo, columna);
        } else {
            //La fila y la columna existen
            nuevo = insertar_en_fila(nuevo, fila);
            nuevo = insertar_en_columna(nuevo, columna);
        }
        
        if (ro<i) {
            ro=i;
        }
        
        if (coll<j) {
            coll=j;
        }
    }

    public void imprimir_fila() {
        System.out.println("Imprimir en fila");
        nodomatriz actual = raiz;
        while (actual != null) {
            System.out.println(actual);
            actual = actual.siguiente;
        }
    }

    public void imprimir_columna() {
        System.out.println("Imprimir en columna");
        nodomatriz actual = raiz;
        while (actual != null) {
            System.out.println(actual);
            actual = actual.abajo;
        }
    }
    
    public int ifi() {
        System.out.println("Imprimir en columna");
        nodomatriz actual = raiz;
        int h=0;
        while (actual != null) {
            System.out.println(actual);
            h=actual.i;
            actual = actual.abajo;
            
        }
        return h;
    }
    public int ic() {
        System.out.println("Imprimir en columna");
        nodomatriz actual = raiz;
        int h=0;
        while (actual != null) {
            System.out.println(actual);
            h=actual.j;
            actual = actual.abajo;
            
        }
        return h;
    }

    
    
    public void graficar(){
        int j=coll;
        int i=ro;
        i=i+1;
        j=j+1;
        String valor;
    StringBuilder dot = new StringBuilder();
     dot.append("""
                digraph G {
                node [shape=plaintext];
                label="Imagen Completa";
                some_node [
                label=<
                <table border="0" cellborder="0" cellspacing="0" width="100%" height="100%">
                """);
        //dot.append("node[shape=box, style=\"filled\", color = red]\n");
        
        
         

        for (int k = 0; k < i; k++) {
            
            dot.append("<tr>\n");
            for (int l = 0; l < j; l++) {
                valor=this.bucar(k, l);
                if (valor==null) {
                    dot.append("<td bgcolor=\"white\" width=\"1\" height=\"1\"></td>\n");
                }
                
                else {
                    
                    dot.append("<td bgcolor=\""+valor+"\" width=\"1\" height=\"1\"></td>\n");
                }
                
            }dot.append("</tr>\n");
            
            
        }
        
        dot.append("""
                   </table>>
                   ];
                   }
                   """);
       
        
        
             try {
             File archivo = new File("C:\\Users\\denni\\Desktop\\circular.txt");
                 FileWriter escritor = new FileWriter(archivo);
            BufferedWriter escritor2 = new BufferedWriter(escritor);
            
            escritor2.write(dot.toString());
            escritor2.close();
            
            
            String[] c = {"dot", "-Tpng", "C:\\Users\\denni\\Desktop\\circular.txt", "-o", "C:\\Users\\denni\\Desktop\\circular.png"};
        Process p = new ProcessBuilder(c).start();
        int err = p.waitFor(); 
         } catch (Exception e) {
         }
    
    
    }

   
    
    
//    public void recorrer(nodobinario aux){
//        System.out.println("raiz"+aux.id);
//
//
//        n += "\n Nodo" + aux.hashCode() + "\n[label= \" <f0> " +
//                "   Id:    "+aux.id+
//                " | Capas:  " + aux.pixeles.size()+" \"" +
//                " \n shape=\"record\"];\n";
//        if (aux.hijoIzquierdo!=null){
//            System.out.println("hijo izquierdo"+aux.hijoIzquierdo.id);
//            n += String.format("Nodo%d -> Nodo%d;\n", aux.hashCode(), aux.hijoIzquierdo.hashCode());
//            recorrer(aux.hijoIzquierdo);
//        }
//        if (aux.hijoDerecho!=null){
//            System.out.println("hijo derecho"+aux.hijoDerecho.id);
//            n += String.format("Nodo%d -> Nodo%d;\n", aux.hashCode(), aux.hijoDerecho.hashCode());
//            recorrer(aux.hijoDerecho);
//        }
//    }
}
 public static class nodobinario {
    
    
    long id;
    JSONArray pixeles;
    nodobinario hijoIzquierdo, hijoDerecho;

    public nodobinario(long id, JSONArray pixeles) {
        this.id = id;
        this.pixeles = pixeles;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }

    public String toString() {
        return id + " sus pixeles son: " + pixeles.toJSONString() + "\n";
    }
}

 public static class binario {
    
    public String n="";
    public String pr="";
    public String in="";
    public String ps="";
    nodobinario raiz;

    public binario() {
        this.raiz = null;
    }
    
   
    public void insertar(long id, JSONArray capas) {
        nodobinario nuevo = new nodobinario(id, capas);
        if (raiz == null) {
            raiz = nuevo;
        } else {
            nodobinario auxiliar = raiz;
            nodobinario padre;
            while (true) {
                padre = auxiliar;
                if (id < auxiliar.id) {
                    auxiliar = auxiliar.hijoIzquierdo;
                    if (auxiliar == null) {
                        padre.hijoIzquierdo = nuevo;
                        return;
                    }
                } else {
                    auxiliar = auxiliar.hijoDerecho;
                    if (auxiliar == null) {
                        padre.hijoDerecho = nuevo;
                        return;
                    }
                }
            }
        }
    }
    
    
    public void inOrden(nodobinario r) {
        if (r != null) {
            inOrden(r.hijoIzquierdo);
            in+=r.id+",";
            System.out.print(r.id + "   ");
            inOrden(r.hijoDerecho);

        }
    }
     public void preOrden(nodobinario r) {
        if (r != null) {
            System.out.print(r.id + "   ");
            pr+=r.id+",";
            preOrden(r.hijoIzquierdo);
            preOrden(r.hijoDerecho);
        }
    }
     
     
     public void postOrden(nodobinario r) {
        if (r != null) {
            postOrden(r.hijoIzquierdo);
            postOrden(r.hijoDerecho);
            ps+=r.id+",";
            System.out.print(r.id + "   ");
        }
    }

     
     public nodobinario buscar(long id) {
        nodobinario aux = raiz;
        while (aux.id != id) {
            if (id < aux.id) {
                aux = aux.hijoIzquierdo;
            } else {
                aux = aux.hijoDerecho;
            }
            if (aux == null) {
                return null;
            }
        }
        return aux;
    }

     
     
      public boolean insertarmatrix(long id ,matriz ma){
      
    nodobinario aux = raiz;
    String cambio="";
        while (aux.id != id) {
            if (id < aux.id) {
                aux = aux.hijoIzquierdo;
            } else {
                aux = aux.hijoDerecho;
            }
            if (aux == null) {
                return false;
            }
        }
        
          for (Object pixele : aux.pixeles) {
              
                    JSONObject   jsonObject = (JSONObject) pixele;
                      System.out.println(pixele);
                      long co=(long) jsonObject.get("columna");
                   long fi=(long) jsonObject.get("fila");
                      
                      cambio= String.valueOf(fi);
                      int fil= Integer.parseInt(cambio);
                      
                      cambio=String.valueOf(co);
                      int col= Integer.parseInt(cambio);
                      String color=(String) jsonObject.get("color");
                      
                      System.out.println(col+" "+fil);
                      
                      ma.insertar(fil, col, color);
                      
                
          }
        return true;
    
    }
       public boolean eliminar(long id) {
        nodobinario aux = raiz;
        nodobinario padre = raiz;
        boolean hijoI = true;
        while (aux.id != id) {
            padre = aux;
            if (id < aux.id) {
                hijoI = true;
                aux = aux.hijoIzquierdo;
            } else {
                hijoI = false;
                aux = aux.hijoDerecho;
            }
            if (aux == null) {
                return false;
            }
        }//fin del while
        if (aux.hijoIzquierdo == null && aux.hijoDerecho == null) {
            if (aux == raiz) {
                raiz = null;
            } else if (hijoI) {
                padre.hijoIzquierdo = null;
            } else {
                padre.hijoDerecho = null;
            }
        } else if (aux.hijoDerecho == null) {
            if (aux == raiz) {
                raiz = aux.hijoIzquierdo;
            } else if (hijoI) {
                padre.hijoIzquierdo = aux.hijoIzquierdo;
            } else {
                padre.hijoDerecho = aux.hijoIzquierdo;
            }
        } else if (aux.hijoIzquierdo == null) {
            if (aux == raiz) {
                raiz = aux.hijoDerecho;
            } else if (hijoI) {
                padre.hijoIzquierdo = aux.hijoDerecho;
            } else {
                padre.hijoDerecho = aux.hijoIzquierdo;
            }
        } else {
            nodobinario reemplazo = reemplazar(aux);
            if (aux == raiz) {
                raiz = reemplazo;
            } else if (hijoI) {
                padre.hijoIzquierdo = reemplazo;
            } else {
                padre.hijoDerecho = reemplazo;
            }
            reemplazo.hijoIzquierdo = aux.hijoIzquierdo;
        }
        return true;
    }
    
       
        public nodobinario reemplazar(nodobinario reemp) {
        nodobinario reempPadre = reemp;
        nodobinario reemplazo = reemp;
        nodobinario aux = reemp.hijoDerecho;
        while (aux != null) {
            reempPadre = reemplazo;
            reemplazo = aux;
            aux = aux.hijoDerecho;
        }
        if (reemplazo != reemp.hijoDerecho) {
            reempPadre.hijoIzquierdo = reemplazo.hijoDerecho;
            reemplazo.hijoDerecho = reemp.hijoDerecho;
        }
        System.out.println("el nodo reemplazo es " + reemplazo);
        return reemplazo;
    }

    public void recorrer(nodobinario aux){
        System.out.println("raiz"+aux.id);


        n += "\n Nodo" + aux.hashCode() + "\n[label= \" <f0> " +
                "   Id:    "+aux.id+
                " | Capas:  " + aux.pixeles.size()+" \"" +
                " \n shape=\"record\"];\n";
        if (aux.hijoIzquierdo!=null){
            System.out.println("hijo izquierdo"+aux.hijoIzquierdo.id);
            n += String.format("Nodo%d -> Nodo%d;\n", aux.hashCode(), aux.hijoIzquierdo.hashCode());
            recorrer(aux.hijoIzquierdo);
        }
        if (aux.hijoDerecho!=null){
            System.out.println("hijo derecho"+aux.hijoDerecho.id);
            n += String.format("Nodo%d -> Nodo%d;\n", aux.hashCode(), aux.hijoDerecho.hashCode());
            recorrer(aux.hijoDerecho);
        }
    }


    public String generar_dot() {
        StringBuilder dot = new StringBuilder();
        dot.append("digraph G{\n");
        //dot.append("node[shape=box, style=\"filled\", color = red]\n");
        dot.append("label=\"ABB de capas" +
                "\n PreOrden:     "+pr+"" +
                "\n  InOrden:     "+in+"" +
                "\nPostOrden:     "+ps+"\"\n" +
                "fontsize=\"22\";\n" +
                "labelloc=top;\n" +
                "labeljust=left;");


        dot.append("node [\n" +
                "fontsize = \"16\"\n" +
                "shape = \"ellipse\"\n" +
                "];\n");
        recorrer(raiz);
        dot.append(n);
        dot.append("}");
        return dot.toString();
    }

    public void grafico() throws IOException {
        try {
            System.out.println("recorrido preOrden");
            preOrden(raiz);
            System.out.println("\nrecorrido inOrden");
            inOrden(raiz);
            System.out.println("\nrecorrido postOrden");
            postOrden(raiz);
            File file = new File("C:\\Users\\denni\\Desktop\\cliente.dot");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(this.generar_dot());
            bw.close();

            ProcessBuilder pbuilderca;

            pbuilderca = new ProcessBuilder("dot", "-Tsvg", "-o",
                    "C:\\Users\\denni\\Desktop\\cliente.svg",
                    "C:\\Users\\denni\\Desktop\\cliente.dot");
            pbuilderca.redirectErrorStream(true);
            //Ejecuta el proceso
            pbuilderca.start();

            File f = new File("" +
                    "C:\\Users\\denni\\Desktop\\cliente.svg");
            if (!f.exists()) {
                f.createNewFile();
            }
            Desktop.getDesktop().open(f);

        } catch (FileNotFoundException e) {
            System.out.println("error");
        } catch (IOException E) {
            System.out.println("error");
        }
    }
       
    //----
    
}

public static class CargaBinaria {
    public void carga(String archivo, binario ab) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(archivo));
            JSONArray array = (JSONArray) obj;
            
            for (Object o : array) {
                    JSONObject jsonObject = (JSONObject) o;
                    long id = (long) jsonObject.get("id_capa");
                   
                 
                   JSONArray pixel=(JSONArray) jsonObject.get("pixeles");
                    
                  for (Object object : pixel) {
                       jsonObject = (JSONObject) object;
                      System.out.println(object);
                      long col=(long) jsonObject.get("fila");
                      System.out.println(col);
                }
                    ab.insertar(id, pixel);
                    /*for (Object capa : capas) {
                        System.out.println(capa);
                    }*/
                    
                }JOptionPane.showMessageDialog(null,"Carga Completa");
            //cargajndsnjds
                //JOptionPane.showMessageDialog(null, "Carga masiva de imagenes exitosa");
            } catch (FileNotFoundException ex) { 
            Logger.getLogger(CargaBinaria.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CargaBinaria.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(CargaBinaria.class.getName()).log(Level.SEVERE, null, ex);
        } 
    
    
    
}
}

 public static class cargaavl {
    int capas[];
    int h=0;
    int co=0;
    public void carga(String archivo,avl av) {
        
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(archivo));
            JSONArray array = (JSONArray) obj;
            
            for (Object o : array) {
                h=0;
                co=0;
                    JSONObject jsonObject = (JSONObject) o;
                    Comparable id = (Comparable) jsonObject.get("id");
                    String idf=  String.valueOf(id);
                    int id2=Integer.parseInt(idf);
                 System.out.println(idf);
                     String caa = (String) String.valueOf(jsonObject.get("capas"));
                    caa=caa.replace("[", "");
                    caa=caa.replace("]", "");
                    String[] ca=caa.split(",");
                    for (String a : ca) {
                         h=h+1;
                         
                }
                    capas=new int[h];
                    for (String a : ca) {
                        
                         capas[co]=Integer.parseInt(a);
                         co=co+1;
                         
                }
                    av.insert(id, id2,capas);
                   
                    /*for (Object capa : capas) {
                        System.out.println(capa);
                    }*/
                       
                }JOptionPane.showMessageDialog(null,"Carga Completa");
                //JOptionPane.showMessageDialog(null, "Carga masiva de imagenes exitosa");
            } catch (FileNotFoundException ex) { 
            Logger.getLogger(cargaavl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(cargaavl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(cargaavl.class.getName()).log(Level.SEVERE, null, ex);
        } 
    
    }
        
        
    
}

    
    
    
}
