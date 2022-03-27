/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fase2.Estructura;

/**
 *
 * @author denni
 */
public class nodocircular {
      String dato;
     int[] hol;
        nodocircular anterior;
        nodocircular siguiente;

    public nodocircular(String dato, int[] hol) {
        this.dato = dato;
        this.hol = hol;
        this.anterior = null;
        this.siguiente = null;
    }
       
       
       
}
