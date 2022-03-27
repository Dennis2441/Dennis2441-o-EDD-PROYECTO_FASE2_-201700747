/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fase2.Estructura;

/**
 *
 * @author denni
 */
public class nodomatriz{
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
