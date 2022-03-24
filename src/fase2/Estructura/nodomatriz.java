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
int fila,columna;
String valor;
nodomatriz derecha,izquierda,abajo,arriba;

    public nodomatriz(int fila, int columna, String valor) {
        this.fila = fila;
        this.columna = columna;
        this.valor = valor;
        this.derecha = null;
        this.izquierda = null;
        this.abajo = null;
        this.arriba = null;
    }}
