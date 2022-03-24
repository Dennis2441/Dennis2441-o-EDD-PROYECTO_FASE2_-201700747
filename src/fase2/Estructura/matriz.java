///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
package fase2.Estructura;
class   nodoencabezado{
  int id;
  nodoencabezado siguiente,anterior;
  nodomatriz acceso;

        public nodoencabezado(int id) {
            this.id = id;
            this.siguiente = null;
            this.anterior = null;
            this.acceso = null;
        }
  
  
  }
class listaencabezado{
nodoencabezado primero;

        public listaencabezado() {
            this.primero = null;
        }

        
        public void  eliminar(){
        
        
        }
        
        public nodoencabezado getencabezador(int id){
        
       nodoencabezado actual=primero;
        while (actual !=null){
            if(actual.id==id){
                return actual;
            
            }
            actual=actual.siguiente;
        
        }
    return null;
        }
        
        
        public void setencabezador(nodoencabezado nuevo){
        
       
       
       
            if (primero==null) {
                primero=nuevo;
            }
            
            else if (nuevo.id<primero.id) {
                nuevo.siguiente=primero;
            primero.anterior=nuevo;
            primero=nuevo;
            }else{
            nodoencabezado actual=primero;
                while (actual.siguiente!=null) {                    
                    if (nuevo.id<primero.id) {
                        nuevo.siguiente=actual.siguiente;
                        actual.siguiente.anterior=nuevo;
                        nuevo.anterior=actual;
                        actual.siguiente=nuevo;
                        break;
                    }
                    actual=actual.siguiente;
                }
                if (actual.siguiente==null) {
                    actual.siguiente=nuevo;
                    nuevo.anterior=actual;
                }
            
            }

    
      
        }



}
    
class matriz {
    
     listaencabezado efilas,ecolumnas;

        public matriz() {
            this.efilas = new listaencabezado();
            this.ecolumnas = new listaencabezado();
        }
    
    public void insertar(int fila,int columna,String valor){
    
    nodomatriz nuevo= new nodomatriz(fila,columna,valor);
     
    nodoencabezado ecolumna= ecolumnas.getencabezador(columna);
        if (ecolumna==null) {
            nodoencabezado jo=new nodoencabezado(columna);
            ecolumna=jo;
            ecolumna.acceso=nuevo;
            ecolumnas.setencabezador(ecolumna);
            
        }else{
            if (nuevo.fila<ecolumna.acceso.fila) {
                
                nuevo.abajo=ecolumna.acceso;
                ecolumna.acceso.arriba=nuevo;
                ecolumna.acceso=nuevo;
            }else{
            
            nodomatriz actual= ecolumna.acceso;
            
                while (actual.abajo!=null) {                    
                    
                    if (nuevo.fila<actual.abajo.fila) {
                        nuevo.abajo=actual.abajo;
                        actual.abajo.arriba=nuevo;
                        nuevo.arriba=actual;
                        actual.abajo=nuevo;
                        break;
                    
                        
                       
                        
                }
                    
                     actual=actual.abajo;
            }
                
                if (actual.abajo==null) {
                    actual.abajo=nuevo;
                    nuevo.arriba=nuevo;
                }
        
        }
    }
        
        
        
    
    }
    
    
    public String buscar(int fila, int columna){
        nodoencabezado ecolumna=ecolumnas.primero;
        while (ecolumna!=null) {            
           nodomatriz actual= ecolumna.acceso;
            while (actual!=null) {                
                
                if (actual.fila==fila && actual.columna==columna) {
                    return actual.valor;
                }
                actual=actual.abajo;
            }
            
            ecolumna=ecolumna.siguiente;
            
        }
        
        
        return null;
        
        
        
    }
public void Imprimir(){

    
    String grap;
    grap="""
         digraph T{ node[shape=circle fontname="Arial" fillcolor="white" style=filled ]
                     root[label = "raiz"]
                     subgraph cluster_p{\n
         """;
    
    grap+="""
         
         \t\t\t\tlabel = "{}"
                         fontname="Arial Black"
                         fontsize="20pt"
         """;
    
    
    
}


}
