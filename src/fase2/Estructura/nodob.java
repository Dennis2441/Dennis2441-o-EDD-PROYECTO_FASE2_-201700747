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
  public  long id;//sera el dpi
  public  String nombre,Password;
    
    //Apuntadores
 public   nodob siguiente;
   public nodob anterior;
 public   RamaB derecha;
  public  RamaB izquierda;

    public nodob(long id,String nombre,String Password) {
        this.id = id;
        this.nombre=nombre;
        this.Password=Password;
        this.anterior = null;
        this.siguiente = null;
        this.derecha = null;
        this.izquierda = null;
    }
    
    
}
