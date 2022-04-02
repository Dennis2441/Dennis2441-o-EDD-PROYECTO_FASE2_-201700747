package Arbol;

public class Pagina {

    private long[] datos;
    private Pagina[] hijos;
    private int ocupados;
    private Pagina padre;
    String[] nombre;
    String[] pass;
       

    public Pagina() {

        this.datos = new long[5];
         nombre= new String[5];
     pass= new String[5];
        this.hijos = new Pagina[6];
        this.ocupados = 0;
        this.padre = null;

    }

    public void setNombre(String[] nombre) {
        this.nombre = nombre;
    }

    public void setPass(String[] pass) {
        this.pass = pass;
    }

    public String[] getNombre() {
        return nombre;
    }

    public String[] getPass() {
        return pass;
    }

    public long[] getDatos() {
        return datos;
    }

    public void setDatos(long[] datos) {
        this.datos = datos;
    }

    public Pagina[] getHijos() {
        return hijos;
    }

    public void setHijos(Pagina[] hijos) {
        this.hijos = hijos;
    }

    public int getOcupados() {
        return ocupados;
    }

    public void setOcupados(int ocupados) {
        this.ocupados = ocupados;
    }

    public Pagina getPadre() {
        return padre;
    }

    public void setPadre(Pagina padre) {
        this.padre = padre;
    }

}
