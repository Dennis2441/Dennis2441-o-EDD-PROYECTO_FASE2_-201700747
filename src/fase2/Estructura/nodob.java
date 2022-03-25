/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fase2.Estructura;

/**
 *
 * @author denni
 */
public class nodob {
    
    
     public  long id;
nodob left, right;
 public   long data;//sera el dpi
 public   String pass;
  public  String nombre;

    public nodob() {
        this.left=null;
        this.right=null;
        data=0;
        pass="";
        nombre="";
        
        
    }
     public nodob(long n,String pass,String nombre) 
    {
        left = null;
        right = null;
        data = n;
        this.nombre=nombre;
        this.pass=pass;
    }

    public long getData() {
        return data;
    }

    public nodob getLeft() {
        return left;
    }

    public String getPass() {
        return pass;
    }

    public nodob getRight() {
        return right;
    }

    public void setLeft(nodob left) {
        this.left = left;
    }

    public String getNombre() {
        return nombre;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setRight(nodob right) {
        this.right = right;
    }

    
 // public  long id;//sera el dpi
//  public  String nombre,Password;
//    
//    //Apuntadores
// public   nodob siguiente;
//   public nodob anterior;
// public   RamaB derecha;
//  public  RamaB izquierda;
//
//    public nodob(long id,String nombre,String Password) {
//        this.id = id;
//        this.nombre=nombre;
//        this.Password=Password;
//        this.anterior = null;
//        this.siguiente = null;
//        this.derecha = null;
//        this.izquierda = null;
//    }
    
    
}
