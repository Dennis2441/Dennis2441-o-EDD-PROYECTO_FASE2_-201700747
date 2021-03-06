/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fase2.Estructura;

/**
 *
 * @author denni
 */
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
public class avl {
    
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
            if (id< root.id)  {
                root = root.izquierdo;  
            
            }
            else if (id> root.id)  {                      
                root = root.izquierdo;  }
            else  
            {  
                check = true;  
                for (Object object : root.capa) {
                    cont=cont+1;
                    
                }
                
                
                capav= new int[cont];
                cont=0;
                for (int object : root.capa) {
                    
                    capav[cont]=object;
                    cont=cont+1;
                    
                }
                break;  
            }  
            check = search(root, id);  
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
     * el Nodo m??s a la derecha hasta el nodo m??s a la izquierda,
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
        // Mediante la altura calcula el total de nodos posibles del ??rbol
        // Y crea una array cola con ese tama??o
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