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
    
    
     private nodob root;
 
    /* Constructor */
    public ArbolB() 
    {
        root = null;
    }
 
    /* Function to check if tree is empty */
    public boolean isEmpty() 
    {
        return root == null;
    }
 
    /* Functions to insert data */
    public void insert(long data,String pass,String nombre) 
    {
        root = insert(root, data,pass,nombre);
    }
 
    /* Function to insert data recursively */
    private nodob insert(nodob node, long data,String pass,String nombre) 
    {
        if (node == null)
            node = new nodob(data,pass,nombre);
        else 
        {
            if (data <= node.getData())
                node.left = insert(node.left, data,pass,nombre);
            else
                node.right = insert(node.right, data,pass,nombre);
        }
        return node;
    }
 
    /* Functions to delete data */
    public void delete(long k)
    {
        if (isEmpty())
            System.out.println("Tree Empty");
        else if (search(k) == false)
            System.out.println("Sorry " + k + " is not present");
        else 
        {
            root = delete(root, k);
            System.out.println(k + " deleted from the tree");
        }
    }
 
    private nodob delete(nodob root, long k) 
    {
        nodob p, p2, n;
        if (root.getData() == k) 
        {
            nodob lt, rt;
            lt = root.getLeft();
            rt = root.getRight();
            if (lt == null && rt == null)
                return null;
            else if (lt == null) 
            {
                p = rt;
                return p;
            }
            else if (rt == null) 
            {
                p = lt;
                return p;
            } 
            else 
            {
                p2 = rt;
                p = rt;
                while (p.getLeft() != null)
                    p = p.getLeft();
                p.setLeft(lt);
                return p2;
            }
        }
        if (k < root.getData()) 
        {
            n = delete(root.getLeft(), k);
            root.setLeft(n);
        }
        else 
        {
            n = delete(root.getRight(), k);
            root.setRight(n);
        }
        return root;
    }
 
    /* Functions to count number of nodes */
    public int countNodes() 
    {
        return countNodes(root);
    }
 
    /* Function to count number of nodes recursively */
    private int countNodes(nodob r) 
    {
        if (r == null)
            return 0;
        else 
        {
            int l = 1;
            l += countNodes(r.getLeft());
            l += countNodes(r.getRight());
            return l;
        }
    }
 
    
    
       
    /* Functions to search for an element */
    public boolean search(long val) 
    {
        return search(root, val);
    }
 
    /* Function to search for an element recursively */
    private boolean search(nodob r, long val) 
    {
        boolean found = false;
        while ((r != null) && !found) 
        {
            long rval = r.getData();
            if (val < rval)
                r = r.getLeft();
            else if (val > rval)
                r = r.getRight();
            else 
            {    System.out.println(r.data);
            System.out.println(r.nombre);
                found = true;
                break;
            }
            found = search(r, val);
        }
        return found;
    }
 
    /* Function for inorder traversal */
    
    
    
     public boolean search2(long val,String pass) 
    {
        return search2(root, val,pass);
    }
 
    /* Function to search for an element recursively */
    private boolean search2(nodob r, long val,String pass) 
    {
        boolean found = false;
        while ((r != null) && !found) 
        {
            long rval = r.getData();
            if (val < rval)
                r = r.getLeft();
            else if (val > rval)
                r = r.getRight();
            else if (val==rval && r.pass.equals(pass) )
            
            {    
                found = true;
                break;
            }else{
            break;
            
            }
            
            found = search2(r, val,pass);
        }
        return found;
    }
    public void inorder() 
    {
        inorder(root);
    }
 
    private void inorder(nodob r) 
    {
        if (r != null) 
        {
            inorder(r.getLeft());
            System.out.print(r.getData() + " ");
            inorder(r.getRight());
        }
    }
 
    /* Function for preorder traversal */
    public void preorder() 
    {
        preorder(root);
    }
 
    private void preorder(nodob r) 
    {
        if (r != null) 
        {
            System.out.print(r.getData() + " ");
            preorder(r.getLeft());
            preorder(r.getRight());
        }
    }
 
    /* Function for postorder traversal */
    public void postorder() 
    {
        postorder(root);
    }
 
    private void postorder(nodob r) 
    {
        if (r != null) 
        {
            postorder(r.getLeft());
            postorder(r.getRight());
            System.out.print(r.getData() + " ");
        }
    }
//    int orden_arbol = 5;
//   public RamaB raiz;
//
//    public ArbolB() {
//        this.raiz = null;
//    }
//    
//    public void insertar(long id,String nombre, String Password) {
//        nodob nodo = new nodob(id,nombre,Password);
//        if (raiz == null) {
//            raiz = new RamaB();
//            raiz.insertar(nodo);
//        } else {
//            nodob obj = insertar_en_rama(nodo, raiz);
//            if (obj != null) {
//                //si devuelve algo el metodo de insertar en rama quiere decir que creo una nueva rama, y se debe insertar en el arbol
//                raiz = new RamaB();
//                raiz.insertar(obj);
//                raiz.hoja = false;
//            }
//        }
//    }
//    
//    
//    private nodob insertar_en_rama(nodob nodo, RamaB rama) {
//        if (rama.hoja) {
//            rama.insertar(nodo);
//            if (rama.contador == orden_arbol) {
//                //si ya se insertaron todos los elementos posibles se debe dividir la rama
//                return dividir(rama);
//            } else {
//                return null;
//            }
//        } else {
//            nodob temp = rama.primero;
//            do {
//                if (nodo.id == temp.id) {
//                    return null;
//                } else if (nodo.id < temp.id) {
//                    nodob obj = insertar_en_rama(nodo,temp.izquierda );
//                    if (obj instanceof nodob) {
//                        rama.insertar((nodob) obj);
//                        if (rama.contador == orden_arbol) {
//                            return dividir(rama);
//                        }
//                    }
//                    return null;
//                } else if (temp.siguiente == null) {
//                    nodob obj = insertar_en_rama(nodo, temp.derecha);
//                    if (obj instanceof nodob) {
//                        rama.insertar((nodob) obj);
//                        if (rama.contador == orden_arbol) {
//                            return dividir(rama);
//                        }
//                    }
//                    return null;
//                }
//                temp = (nodob) temp.siguiente;
//            } while (temp != null);
//        }
//        return null;
//    }
//    
//    private nodob dividir(RamaB rama) {
//        long val = -999;
//        String nombre="";
//                String paa="";
//        nodob temp, Nuevito;
//        nodob aux = rama.primero;
//        RamaB rderecha = new RamaB();
//        RamaB rizquierda = new RamaB();
//
//        int cont = 0;
//        while (aux != null) {
//            cont++;
//            //implementacion para dividir unicamente ramas de 4 nodos
//            if (cont < 3) {
//                temp = new nodob(aux.id,aux.nombre,aux.Password);
//                temp.izquierda = aux.izquierda;
//                if (cont == 2) {
//                    temp.derecha = aux.siguiente.izquierda;
//                } else {
//                    temp.derecha = aux.derecha;
//                }
//                //si la rama posee ramas deja de ser hoja
//                if (temp.derecha != null && temp.izquierda != null) {
//                    rizquierda.hoja = false;
//                }
//
//                rizquierda.insertar(temp);
//
//            } else if (cont == 3) {
//                val = aux.id;
//                nombre=aux.nombre;
//                paa=aux.Password;
//                
//            } else {
//                temp = new nodob(aux.id,aux.Password,aux.Password);
//                temp.izquierda = aux.izquierda;
//                temp.derecha = aux.derecha;
//                //si la rama posee ramas deja de ser hoja
//                if (temp.derecha != null && temp.izquierda != null) {
//                    rderecha.hoja = false;
//                }
//                rderecha.insertar(temp);
//            }
//            aux = aux.siguiente;
//        }
//        Nuevito = new nodob(val,nombre,paa);
//        Nuevito.derecha = rderecha;
//        Nuevito.izquierda = rizquierda;
//        return Nuevito;
//    }
//    
//    
//    
//    public boolean buscar(long user, String pasa){
//        boolean existe=false;
//        nodob aux= raiz.primero ;
//        
//        while (aux!=null  && existe==false)  {            
//            if (aux.id==user && aux.Password==pasa) {
//                existe=true;
//                return existe;
//               
//            }
//            
//            aux= aux.siguiente;
//        }
//        
//    
//        return false;
//    
//    
//    }
    
}
