/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fase2.Estructura;

import javax.swing.JOptionPane;

/**
 *
 * @author denni
 */
public class ArbolB {
    int orden_arbol = 5;
   public RamaB raiz;

    public ArbolB() {
        this.raiz = null;
    }
    
    public void insertar(long id,String nombre, String Password) {
        nodob nodo = new nodob(id,nombre,Password);
        if (raiz == null) {
            raiz = new RamaB();
            raiz.insertar(nodo);
        } else {
            nodob obj = insertar_en_rama(nodo, raiz);
            if (obj != null) {
                //si devuelve algo el metodo de insertar en rama quiere decir que creo una nueva rama, y se debe insertar en el arbol
                raiz = new RamaB();
                raiz.insertar(obj);
                raiz.hoja = false;
            }
        }
    }
    
    
    private nodob insertar_en_rama(nodob nodo, RamaB rama) {
        if (rama.hoja) {
            rama.insertar(nodo);
            if (rama.contador == orden_arbol) {
                //si ya se insertaron todos los elementos posibles se debe dividir la rama
                return dividir(rama);
            } else {
                return null;
            }
        } else {
            nodob temp = rama.primero;
            do {
                if (nodo.id == temp.id) {
                    return null;
                } else if (nodo.id < temp.id) {
                    nodob obj = insertar_en_rama(nodo,temp.izquierda );
                    if (obj instanceof nodob) {
                        rama.insertar((nodob) obj);
                        if (rama.contador == orden_arbol) {
                            return dividir(rama);
                        }
                    }
                    return null;
                } else if (temp.siguiente == null) {
                    nodob obj = insertar_en_rama(nodo, temp.derecha);
                    if (obj instanceof nodob) {
                        rama.insertar((nodob) obj);
                        if (rama.contador == orden_arbol) {
                            return dividir(rama);
                        }
                    }
                    return null;
                }
                temp = (nodob) temp.siguiente;
            } while (temp != null);
        }
        return null;
    }
    
    private nodob dividir(RamaB rama) {
        long val = -999;
        String nombre="";
                String paa="";
        nodob temp, Nuevito;
        nodob aux = rama.primero;
        RamaB rderecha = new RamaB();
        RamaB rizquierda = new RamaB();

        int cont = 0;
        while (aux != null) {
            cont++;
            //implementacion para dividir unicamente ramas de 4 nodos
            if (cont < 3) {
                temp = new nodob(aux.id,aux.nombre,aux.Password);
                temp.izquierda = aux.izquierda;
                if (cont == 2) {
                    temp.derecha = aux.siguiente.izquierda;
                } else {
                    temp.derecha = aux.derecha;
                }
                //si la rama posee ramas deja de ser hoja
                if (temp.derecha != null && temp.izquierda != null) {
                    rizquierda.hoja = false;
                }

                rizquierda.insertar(temp);

            } else if (cont == 3) {
                val = aux.id;
                nombre=aux.nombre;
                paa=aux.Password;
                
            } else {
                temp = new nodob(aux.id,aux.Password,aux.Password);
                temp.izquierda = aux.izquierda;
                temp.derecha = aux.derecha;
                //si la rama posee ramas deja de ser hoja
                if (temp.derecha != null && temp.izquierda != null) {
                    rderecha.hoja = false;
                }
                rderecha.insertar(temp);
            }
            aux = aux.siguiente;
        }
        Nuevito = new nodob(val,nombre,paa);
        Nuevito.derecha = rderecha;
        Nuevito.izquierda = rizquierda;
        return Nuevito;
    }
    
    
    
    public boolean buscar(long user, String pasa){
        boolean existe=false;
        nodob aux= raiz.primero ;
        
        while (aux!=null  && existe==false)  {            
            if (aux.id==user && aux.Password==pasa) {
                existe=true;
                return existe;
               
            }
            
            aux= aux.siguiente;
        }
        
    
        return false;
    
    
    }
    
}
