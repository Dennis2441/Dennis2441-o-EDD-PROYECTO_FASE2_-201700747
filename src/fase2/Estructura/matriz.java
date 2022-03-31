///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
package fase2.Estructura;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

    
public class matriz {
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