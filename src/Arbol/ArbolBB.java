package Arbol;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class ArbolBB {

    private Pagina root;
    private String doti = "";//esta variable solo es para graficar el arbol.

    public ArbolBB() {
        this.root = null;
    }

    //GRAFICOS
    private void recursive_Preorder(Pagina current) {

        if (current.getHijos()[0] != null) {

            doti += "\"" + current.getHijos()[0].toString() + "\"" + "[label = \"<P0>";

            for (int i = 0; i < current.getHijos()[0].getOcupados(); i++) {
                String hola;
                doti += "|" + current.getHijos()[0].getDatos()[i] +" |"+  current.getHijos()[0].getNombre()[i]+" |" +  current.getHijos()[0].getPass()[i]+ "<P" + (i + 1) + ">";
            }
            doti += "\"];\n\n";

            doti += "\"" + current.toString() + "\"" + ":" + "P0" + "->" + "\"" + current.getHijos()[0].toString() + "\"";

            doti += ";\n\n";

        }
        if (current.getHijos()[1] != null) {

            doti += "\"" + current.getHijos()[1].toString() + "\"" + "[label = \"<P0>";

            for (int i = 0; i < current.getHijos()[1].getOcupados(); i++) {
                doti += "|" + current.getHijos()[1].getDatos()[i] +" |"+  current.getHijos()[1].getNombre()[i]+ "|" +  current.getHijos()[1].getPass()[i]+ "<P" + (i + 1) + ">";
            }
            doti += "\"];\n\n";

            doti += "\"" + current.toString() + "\"" + ":" + "P1" + "->" + "\"" + current.getHijos()[1].toString() + "\"";

            doti += ";\n\n";

        }
        if (current.getHijos()[2] != null) {

            doti += "\"" + current.getHijos()[2].toString() + "\"" + "[label = \"<P0>";

            for (int i = 0; i < current.getHijos()[2].getOcupados(); i++) {
                doti += "|" + current.getHijos()[2].getDatos()[i] +" |"+  current.getHijos()[2].getNombre()[i]+ "|" +  current.getHijos()[2].getPass()[i]+ "<P" + (i + 1) + ">";
            }
            doti += "\"];\n\n";

            doti += "\"" + current.toString() + "\"" + ":" + "P2" + "->" + "\"" + current.getHijos()[2].toString() + "\"";

            doti += ";\n\n";

        }
        if (current.getHijos()[3] != null) {

            doti += "\"" + current.getHijos()[3].toString() + "\"" + "[label = \"<P0>";

            for (int i = 0; i < current.getHijos()[3].getOcupados(); i++) {
                doti += "|" + current.getHijos()[3].getDatos()[i] +" |"+  current.getHijos()[3].getNombre()[i]+ "|" +  current.getHijos()[3].getPass()[i]+ "<P" + (i + 1) + ">";
            }
            doti += "\"];\n\n";

            doti += "\"" + current.toString() + "\"" + ":" + "P3" + "->" + "\"" + current.getHijos()[3].toString() + "\"";

            doti += ";\n\n";

        }
        if (current.getHijos()[4] != null) {

            doti += "\"" + current.getHijos()[4].toString() + "\"" + "[label = \"<P0>";

            for (int i = 0; i < current.getHijos()[4].getOcupados(); i++) {
                doti += "|" + current.getHijos()[4].getDatos()[i] +" |"+  current.getHijos()[4].getNombre()[i]+ "|" +  current.getHijos()[4].getPass()[i]+ "<P" + (i + 1) + ">";
            }
            doti += "\"];\n\n";

            doti += "\"" + current.toString() + "\"" + ":" + "P4" + "->" + "\"" + current.getHijos()[4].toString() + "\"";

            doti += ";\n\n";

        }

        if (current.getHijos()[0] != null) {
            recursive_Preorder(current.getHijos()[0]);
        }
        if (current.getHijos()[1] != null) {
            recursive_Preorder(current.getHijos()[1]);
        }
        if (current.getHijos()[2] != null) {
            recursive_Preorder(current.getHijos()[2]);
        }
        if (current.getHijos()[3] != null) {
            recursive_Preorder(current.getHijos()[3]);
        }
        if (current.getHijos()[4] != null) {
            recursive_Preorder(current.getHijos()[4]);
        }

    }

    public void graphAllTreeB() {

        if (root != null) {

            doti = "";
            String dot = "digraph D {\n";
            dot += "node[shape= record];\n\n";

            dot += "\"" + root.toString() + "\"" + "[label = \"<P0>";

            for (int i = 0; i < root.getOcupados(); i++) {
                dot += "|" + root.getDatos()[i] +" " +root.getNombre()[i]+"|" + "<P" + (i + 1) + ">";
            }

            dot += "\"];\n\n";

            recursive_Preorder(root);

            dot += doti;
            dot += "\n}";

            generarArchivosAux(dot, "Arbol-B");

        } else {
            JOptionPane.showMessageDialog(null, "No se puede generar el grafo del arbol porque esta vacio");
        }

    }

    private void generarArchivosAux(String dot, String nombreArchivo) {

        
                
                
        try {
            File archivo = new File("C:\\Users\\denni\\Documents\\NetBeansProjects\\fase2\\src\\Imagenes\\Arbol-B.txt");
                 FileWriter escritor;
            escritor = new FileWriter(archivo);
            
             BufferedWriter escritor2 = new BufferedWriter(escritor);
            
            escritor2.write(dot.toString());
            escritor2.close();
        } catch (IOException ex) {
            Logger.getLogger(ArbolBB.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        

        try {

           String[] c = {"dot", "-Tpng", "C:\\Users\\denni\\Documents\\NetBeansProjects\\fase2\\src\\Imagenes\\Arbol-B.txt", "-o", "C:\\Users\\denni\\Documents\\NetBeansProjects\\fase2\\src\\Imagenes\\Arbol-B.png"};
        Process p = new ProcessBuilder(c).start();
        int err = p.waitFor(); 
         } catch (Exception e) {
         

        }
    }

    //INSERTAR CLAVE O DATO (TIPO INT)
    private void insertarDatosOrdenado(Pagina current, Pagina nvoHijo, long nvoDato,String nombre, String pass) {

        long aux;
        Pagina temp;

        for (int i = 0; i < current.getDatos().length; i++) {

            if (nvoDato < current.getDatos()[i]) {

                aux = current.getDatos()[i];
                current.getDatos()[i] = nvoDato;
                current.getNombre()[i]=nombre;
                current.getPass()[i]=pass;
                nvoDato = aux;

                if (nvoHijo != null) {
                    temp = current.getHijos()[i + 1];
                    current.getHijos()[i + 1] = nvoHijo;
                    nvoHijo.setPadre(current);
                    nvoHijo = temp;
                }

            } else if (current.getDatos()[i] == 0) {

                current.getDatos()[i] = nvoDato;
                current.getNombre()[i]=nombre;
                current.getPass()[i]=pass;
                current.setOcupados(current.getOcupados() + 1);

                if (nvoHijo != null) {
                    current.getHijos()[i + 1] = nvoHijo;
                    nvoHijo.setPadre(current);
                }

                break;

            } else if (current.getDatos()[i] == nvoDato) {
                JOptionPane.showMessageDialog(null, "Error: No se agrego el dato " + nvoDato + " porque ya existe en el arbol");
                break;
            }

        }

    }

    private void dividirPagina(Pagina current) {

        //Creo nueva Pagina 
        Pagina nvoHijo = new Pagina();

//NOTA: LA RAZON POR LA CUAL SE CODIFICA PRIMERO EL ANALISIS SIN HIJOS ES PORQUE ASI SE VA FORMANDO EL ARBOL.
        if (current == root) {//DIVISION DE UNA PAGINA HACIA UNA NUEVA RAIZ

            //Se crea un nuevo root 
            root = new Pagina();

            //Le agrego el dato medio del actual a la nueva raiz
            insertarDatosOrdenado(root, null, current.getDatos()[2],current.getNombre()[2],current.getPass()[2]);
            current.getDatos()[2] = 0;

            //Le digo al nuevo root al papa quienes son sus hijos y a sus hijos quien es su papa.
            root.getHijos()[0] = current;
            root.getHijos()[1] = nvoHijo;
            current.setPadre(root);
            nvoHijo.setPadre(root);

        } else {//DIVISION DE UNA PAGINA HACIA UNA RAIZ EXISTENTE

            //Agrego el dato medio al padre(se ingresa de forma ordenada)
            insertarDatosOrdenado(current.getPadre(), nvoHijo, current.getDatos()[2],current.getNombre()[2],current.getPass()[2]);
            current.getDatos()[2] = 0;

        }

        if (current.getHijos()[0] != null) {//INTERCAMBIO DE DATOS E HIJOS ALA NUEVO HIJO, SI LA PAGINA ACTUAL LOS TUVIERA 

            //Se asigna el hijo[3)de] actual ala hijo[0] del nuevo hijo
            nvoHijo.getHijos()[0] = current.getHijos()[3];
            current.getHijos()[3].setPadre(nvoHijo);

            //Se asignan tantos los datos como los hijos a su nuevo padre que es el nvo nodo
            insertarDatosOrdenado(nvoHijo, current.getHijos()[4], current.getDatos()[3],current.getNombre()[3],current.getPass()[3]);
            insertarDatosOrdenado(nvoHijo, current.getHijos()[5], current.getDatos()[4],current.getNombre()[4],current.getPass()[4]);

        } else {//YA QUE LA PAGINA QUE SE DIVIDE NO TIENE HIJOS SOLO SE INTERCAMBIAN SUS DATOS AL NUEVO HIJO

            insertarDatosOrdenado(nvoHijo, null, current.getDatos()[3],current.getNombre()[3],current.getPass()[3]);
            insertarDatosOrdenado(nvoHijo, null, current.getDatos()[4],current.getNombre()[4],current.getPass()[4]);
        }

        //SE MODIFICA LA PAGINA QUE SE DIVIDIO
        current.getDatos()[3] = 0;
        current.getDatos()[4] = 0;
        current.getNombre()[3]="";
        current.getNombre()[4]="";
        current.getPass()[3]="";
        current.getPass()[4]="";
        current.getHijos()[3] = null;
        current.getHijos()[4] = null;
        current.getHijos()[5] = null;
        current.setOcupados(2);

    }

    private void recursive_insertarDato(Pagina current, long nvoDato,String nombre, String pass) {

        if (nvoDato > current.getDatos()[current.getOcupados() - 1]) {//VERIFICA SI EL DATO ES MAYOR AL ULTIMO DATO

            if (current.getHijos()[current.getOcupados()] != null) {//Ya que el nvoDato es mayor al mas grande, verifica si tiene hijo por la derecha
                recursive_insertarDato(current.getHijos()[current.getOcupados()], nvoDato,nombre,pass);
            } else {
                insertarDatosOrdenado(current, null, nvoDato,nombre,pass);//Ya que la pagina no tinene hijos se inserta en esa pagina.
            }

        } else {

            for (int i = 0; i < current.getOcupados(); i++) {//RECORRE LAS POSICIONES OCUPADAS DE LA PAGINA ACTUAL

                if (nvoDato < current.getDatos()[i]) {//VERIFICA SI EL DATO SEA MENOR ALA POSCISION EN I.

                    if (current.getHijos()[i] != null) {//Ya que el dato es menor, verifica si tiene hijo por la izquierda
                        recursive_insertarDato(current.getHijos()[i], nvoDato,nombre,pass);
                    } else {
                        insertarDatosOrdenado(current, null, nvoDato,nombre,pass);//Ya que la pagina no tinene hijos se inserta en esa pagina.
                    }
                    break;

                }

            }

        }
        //ACA REVISA SI LA PAGINA YA EXCEDE EL LIMITE DE DATOS PARA HACER LA DIVISION DE PAGINA.
        if (current.getOcupados() == 5) {
            dividirPagina(current);
        }

    }

    public void insertarDato(long nvoDato,String nombre, String pass) {

        if (root != null) { //Revisa si la raiz esta vacia

            recursive_insertarDato(root, nvoDato,nombre,pass);

        } else {//Sie esta Vacia

            root = new Pagina();//Se crea una nueva pagina
            root.getDatos()[0] = nvoDato;//Se Inserta el nuevo dato en la primer posicion de la pagina nueva
            root.getNombre()[0]=nombre;
            root.getPass()[0]=pass;
            root.setOcupados(root.getOcupados() + 1);// y se aumenta en uno a ocupados
        }

    }

    //ELIMINAR CLAVE O DATO (TIPO INT)    
    private void actualizarDatos(Pagina pagina) {

        for (int i = 1; i < pagina.getDatos().length; i++) {

            if (pagina.getDatos()[i - 1] == 0 & pagina.getDatos()[i] != 0) {
                pagina.getDatos()[i - 1] = pagina.getDatos()[i];
                pagina.getNombre()[i-1]=pagina.getNombre()[i];
                pagina.getPass()[i-1]=pagina.getPass()[i];
                
                pagina.getDatos()[i] = 0;
                pagina.getNombre()[i]="";
                pagina.getPass()[i]="";
                
            }

        }

    }

    private void actualizarHijos(Pagina pagina) {

        for (int i = 1; i < pagina.getHijos().length; i++) {

            if (pagina.getHijos()[i - 1] == null & pagina.getHijos()[i] != null) {
                pagina.getHijos()[i - 1] = pagina.getHijos()[i];
                pagina.getHijos()[i] = null;
            }

        }

    }

    private boolean prestoDato(Pagina current) {

        Pagina padre = current.getPadre();

        if (padre.getHijos()[0] == current) {//si es Primer Hijo

            Pagina hermanoDer = padre.getHijos()[1];

            if (hermanoDer.getOcupados() > 2) {// prestamo a la derecha

                current.getDatos()[current.getOcupados()] = padre.getDatos()[0];
                current.getNombre()[current.getOcupados()] = padre.getNombre()[0];
                current.getPass()[current.getOcupados()] = padre.getPass()[0];
                current.setOcupados(current.getOcupados() + 1);

                padre.getDatos()[0] = hermanoDer.getDatos()[0];
                padre.getNombre()[0] = hermanoDer.getNombre()[0];
                padre.getPass()[0] = hermanoDer.getPass()[0];
                hermanoDer.getDatos()[0] = 0;
                hermanoDer.getNombre()[0] = "";
                hermanoDer.getPass()[0] = "";
                hermanoDer.setOcupados(hermanoDer.getOcupados() - 1);

                if (hermanoDer.getHijos()[0] != null) {

                    current.getHijos()[current.getOcupados()] = hermanoDer.getHijos()[0];
                    hermanoDer.getHijos()[0].setPadre(current);
                    hermanoDer.getHijos()[0] = null;
                }

                actualizarDatos(hermanoDer);
                actualizarHijos(hermanoDer);
                return true;

            }

        } else if (padre.getHijos()[padre.getOcupados()] == current) {//si es Ultimo hijo

            Pagina hermanoIzq = padre.getHijos()[padre.getOcupados() - 1];

            if (hermanoIzq.getOcupados() > 2) {//prestame a la Izquierdo

                //Correr los datos e hijos de actual para que el dato de padre entre
                current.getDatos()[1] = current.getDatos()[0];
                current.getDatos()[0] = 0;
                current.getHijos()[2] = current.getHijos()[1];
                current.getHijos()[1] = current.getHijos()[0];
                current.getHijos()[0] = null;

                //hacer el prestamo
                current.getDatos()[0] = padre.getDatos()[padre.getOcupados() - 1];
                current.setOcupados(current.getOcupados() + 1);

                padre.getDatos()[padre.getOcupados() - 1] = hermanoIzq.getDatos()[hermanoIzq.getOcupados() - 1];
                hermanoIzq.getDatos()[hermanoIzq.getOcupados() - 1] = 0;

                if (hermanoIzq.getHijos()[0] != null) {

                    current.getHijos()[0] = hermanoIzq.getHijos()[hermanoIzq.getOcupados()];
                    hermanoIzq.getHijos()[hermanoIzq.getOcupados()].setPadre(current);
                    hermanoIzq.getHijos()[hermanoIzq.getOcupados()] = null;
                }

                hermanoIzq.setOcupados(hermanoIzq.getOcupados() - 1);
                return true;
            }

        } else {//sino es ni el primero ni el ultimo son los de enmiedio

            for (int i = 1; i < padre.getOcupados() - 1; i++) {

                if (padre.getHijos()[i] == current) {

                    if (padre.getHijos()[i - 1].getOcupados() > 2) {//prestame a la Izquierdo

                        Pagina hermanoIzq = padre.getHijos()[i - 1];

                        //Correr los datos de actual
                        current.getDatos()[1] = current.getDatos()[0];
                        current.getDatos()[0] = 0;
                        current.getHijos()[2] = current.getHijos()[1];
                        current.getHijos()[1] = current.getHijos()[0];
                        current.getHijos()[0] = null;

                        //hacer el prestamo
                        current.getDatos()[0] = padre.getDatos()[i - 1];
                        current.setOcupados(current.getOcupados() + 1);

                        padre.getDatos()[i - 1] = hermanoIzq.getDatos()[hermanoIzq.getOcupados() - 1];
                        hermanoIzq.getDatos()[hermanoIzq.getOcupados() - 1] = 0;

                        if (hermanoIzq.getHijos()[0] != null) {

                            current.getHijos()[0] = hermanoIzq.getHijos()[hermanoIzq.getOcupados()];
                            hermanoIzq.getHijos()[hermanoIzq.getOcupados()].setPadre(current);
                            hermanoIzq.getHijos()[hermanoIzq.getOcupados()] = null;
                        }

                        hermanoIzq.setOcupados(hermanoIzq.getOcupados() - 1);
                        return true;

                    } else if (padre.getHijos()[i + 1].getOcupados() > 2) {// prestamo a la derecha

                        Pagina hermanoDer = padre.getHijos()[i + 1];

                        current.getDatos()[current.getOcupados()] = padre.getDatos()[i];
                        current.setOcupados(current.getOcupados() + 1);

                        padre.getDatos()[i] = hermanoDer.getDatos()[0];
                        hermanoDer.getDatos()[0] = 0;
                        hermanoDer.setOcupados(hermanoDer.getOcupados() - 1);

                        if (hermanoDer.getHijos()[0] != null) {

                            current.getHijos()[current.getOcupados()] = hermanoDer.getHijos()[0];
                            hermanoDer.getHijos()[0].setPadre(current);
                            hermanoDer.getHijos()[0] = null;
                        }

                        actualizarDatos(hermanoDer);
                        actualizarHijos(hermanoDer);
                        return true;

                    }

                }

            }

        }

        return false;

    }

    private void fusionPaginas(Pagina current) {//Si nunguno de sus hermanos puede prestar se fusiona la 

        Pagina padre = current.getPadre();

        if (padre.getHijos()[0] == current) {//Si actual es primer hijo se fusiona con el hermano derecho 

            Pagina hermanoDer = padre.getHijos()[1];

            current.getDatos()[current.getOcupados()] = padre.getDatos()[0];
            current.getNombre()[current.getOcupados()] = padre.getNombre()[0];
            current.getPass()[current.getOcupados()] = padre.getPass()[0];
            current.setOcupados(current.getOcupados() + 1);
            padre.getDatos()[0] = 0;
            padre.getNombre()[0]="";
            padre.getPass()[0]="";
            padre.setOcupados(padre.getOcupados() - 1);

            current.getDatos()[current.getOcupados()] = hermanoDer.getDatos()[0];
            current.getNombre()[current.getOcupados()] =  hermanoDer.getNombre()[0];
            current.getPass()[current.getOcupados()] =  hermanoDer.getPass()[0];
            current.setOcupados(current.getOcupados() + 1);
            hermanoDer.getDatos()[0] = 0;
            hermanoDer.getNombre()[0]="";
            hermanoDer.getPass()[0]="";
            current.getDatos()[current.getOcupados()] = hermanoDer.getDatos()[1];
            current.getNombre()[current.getOcupados()] =  hermanoDer.getNombre()[1];
            current.getPass()[current.getOcupados()] =  hermanoDer.getPass()[1];
            current.setOcupados(current.getOcupados() + 1);
            hermanoDer.getDatos()[1] = 0;
            hermanoDer.getNombre()[1]="";
            hermanoDer.getPass()[1]="";
            hermanoDer.setOcupados(0);

            if (hermanoDer.getHijos()[0] != null) {

                current.getHijos()[2] = hermanoDer.getHijos()[0];
                hermanoDer.getHijos()[0].setPadre(current);
                hermanoDer.getHijos()[0] = null;
                current.getHijos()[3] = hermanoDer.getHijos()[1];
                hermanoDer.getHijos()[1].setPadre(current);
                hermanoDer.getHijos()[0] = null;
                current.getHijos()[4] = hermanoDer.getHijos()[2];
                hermanoDer.getHijos()[2].setPadre(current);
                hermanoDer.getHijos()[0] = null;
            }

            padre.getHijos()[1] = null;
            actualizarDatos(padre);
            actualizarHijos(padre);

        } else {// Ya que no es el primer hijo busca a su hermano izquierdo y se fusiona 

            for (int i = 1; i <= padre.getOcupados(); i++) {

                if (padre.getHijos()[i] == current) {

                    Pagina hermanoIzq = padre.getHijos()[i - 1];

                    hermanoIzq.getDatos()[hermanoIzq.getOcupados()] = padre.getDatos()[i - 1];
                     hermanoIzq.getNombre()[hermanoIzq.getOcupados()] = padre.getNombre()[i - 1];
                      hermanoIzq.getPass()[hermanoIzq.getOcupados()] = padre.getPass()[i - 1];
                    hermanoIzq.setOcupados(hermanoIzq.getOcupados() + 1);

                    padre.getDatos()[i - 1] = 0;
                    padre.getNombre()[i-1]="";
                    padre.getPass()[i-1]="";
                    padre.setOcupados(padre.getOcupados() - 1);

                    hermanoIzq.getDatos()[hermanoIzq.getOcupados()] = current.getDatos()[0];
                    hermanoIzq.getNombre()[hermanoIzq.getOcupados()] = current.getNombre()[0];
                      hermanoIzq.getPass()[hermanoIzq.getOcupados()] = current.getPass()[0];
                    hermanoIzq.setOcupados(hermanoIzq.getOcupados() + 1);

                    if (current.getHijos()[0] != null) {

                        hermanoIzq.getHijos()[3] = current.getHijos()[0];
                        hermanoIzq.getHijos()[4] = current.getHijos()[1];

                    }

                    padre.getHijos()[i] = null;
                    actualizarDatos(padre);
                    actualizarHijos(padre);

                }

            }

        }

        if (padre == root && padre.getOcupados() == 0) {
            root = current;
            padre.getHijos()[0] = null;
        }

    }

    private void recursive_RemoverPadre(Pagina padre, int posiPadre, Pagina current) {

        if (current.getHijos()[current.getOcupados()] != null) {
            recursive_RemoverPadre(padre, posiPadre, current.getHijos()[current.getOcupados()]);
        }

        if (padre.getDatos()[posiPadre] == 0) {
            padre.getDatos()[posiPadre] = current.getDatos()[current.getOcupados() - 1];
            current.getDatos()[current.getOcupados() - 1] = 0;
            current.getNombre()[current.getOcupados() - 1] = "";
            current.getPass()[current.getOcupados() - 1] = "";
            current.setOcupados(current.getOcupados() - 1);

        }

        if (current.getOcupados() == 1) {

            if (!prestoDato(current)) {

                fusionPaginas(current);
            }
        }

    }

    private long removerDato(Pagina current, long dato,String nombre,String pass) {

        long datoRemv = -1;

        for (int i = 0; i < current.getOcupados(); i++) {

            if (current.getDatos()[i] == dato) {

                datoRemv = current.getDatos()[i];
                current.getDatos()[i] = 0;
                current.getNombre()[i]="";
                current.getPass()[i]="";

                actualizarDatos(current);
                current.setOcupados(current.getOcupados() - 1);

            }

        }

        return datoRemv;

    }

    private void recursive_EliminarDato(Pagina current, int dato,String nombre,String pass) {

        for (int i = 0; i < current.getOcupados(); i++) {//RECORRE LAS POSICIONES OCUPADAS DE LA PAGINA ACTUAL

            if (dato < current.getDatos()[i]) {//VERIFICA SI EL DATO SEA MENOR ALA POSCISION EN I.

                if (current.getHijos()[i] != null) {//Ya que el dato es menor, verifica si tiene hijo por la izquierda
                    recursive_insertarDato(current.getHijos()[i], dato,nombre,pass);
                } else {
                    JOptionPane.showMessageDialog(null, "ERROR: El dato \"" + dato + "\" no se ha podido eliminar porque no se encuentra almacenado en el Arbol B");
                }
                break;

            } else if (dato > current.getDatos()[current.getOcupados() - 1]) {//VERIFICA SI EL DATO ES MAYOR AL ULTIMO DATO

                if (current.getHijos()[current.getOcupados()] != null) {//Ya que el nvoDato es mayor al mas grande, verifica si tiene hijo por la derecha
                    recursive_insertarDato(current.getHijos()[current.getOcupados()], dato,nombre,pass);
                } else {
                    JOptionPane.showMessageDialog(null, "ERROR: El dato \"" + dato + "\" no se ha podido eliminar porque no se encuentra almacenado en el Arbol B");
                }

            } else if (dato == current.getDatos()[i]) {

                if (current.getHijos()[0] == null) {

                    removerDato(current, dato,nombre,pass);

                } else {

                    current.getDatos()[i] = 0;
                    recursive_RemoverPadre(current, i, current.getHijos()[i]);

                }

            }

        }

        if (current.getOcupados() == 1) {

            if (current != root) {

                if (!prestoDato(current)) {
                    fusionPaginas(current);

                }
            }

        }

    }

    public void eliminarDato(int dato,String  nombre, String pass) {

        if (root != null) {
            recursive_EliminarDato(root, dato,nombre,pass);
        } else {
            JOptionPane.showMessageDialog(null, "Error: No puedes eliminar el dato porque el Arbo B esta vacio");
        }

    }

}
