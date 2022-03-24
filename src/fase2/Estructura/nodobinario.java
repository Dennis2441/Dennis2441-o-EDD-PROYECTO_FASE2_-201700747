/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fase2.Estructura;

/**
 *
 * @author denni
 */

import org.json.simple.JSONArray;

import java.awt.*;
import java.io.*;
public class nodobinario {
    
    
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
