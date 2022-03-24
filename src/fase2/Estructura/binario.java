/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fase2.Estructura;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;

/**
 *
 * @author denni
 */
public class binario {
    
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
