/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fase2.Estructura;

/**
 *
 * @author denni
 */
public class RamaB {
     boolean hoja;//identificar si es una hoja
    int contador;//identificar la cantidad de elementos que tiene la rama
public    nodob primero;

    public RamaB() {
        this.primero = null;
        this.hoja = true;
        this.contador = 0;
    }
     public void insertar(nodob nuevo) {
        if (primero == null) {
            //primero en la lista
            primero = nuevo;
            contador++;
        } else {
            //recorrer e insertar
            nodob aux = primero;
            while (aux != null) {
                if (aux.id == nuevo.id) {//ya existe en el arbol
                    System.out.println("El ID " + nuevo.id + " ya existe");
                    break;
                } else {
                    if (aux.id > nuevo.id) {
                        if (aux == primero) {//insertar al inicio
                            aux.anterior = nuevo;
                            nuevo.siguiente = aux;
                            //ramas del nodo
                            aux.izquierda = nuevo.derecha;
                            nuevo.derecha = null;

                            primero = nuevo;
                            contador++;
                            break;
                        } else {//------------->insertar en medio;
                            nuevo.siguiente = aux;
                            //ramas del nodo
                            aux.izquierda = nuevo.derecha;
                            nuevo.derecha = null;

                            nuevo.anterior = aux.anterior;
                            aux.anterior.siguiente = nuevo;
                            aux.anterior = nuevo;
                            contador++;
                            break;
                        }
                    } else if (aux.siguiente == null) {//------------->insertar al final
                        aux.siguiente = nuevo;
                        nuevo.anterior = aux;
                        contador++;
                        break;
                    }
                }
                aux = aux.siguiente;
            }

        }
    }

    
    
    
}
