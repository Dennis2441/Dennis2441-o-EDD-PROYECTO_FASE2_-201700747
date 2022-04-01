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
    public String nam;
    public String contra;
    public String dpi;
    public String combo;
  private int T;

  // Node creation
  public class Node {
     int n;
      long key[] = new long[2 * T - 1];
    String nombre[]= new String[2* T - 1];
    String pass[]= new String[2* T - 1];
    Node child[] = new Node[2 * T];
    boolean leaf = true;

    public int Find(long k) {
      for (int i = 0; i < this.n; i++) {
        if (this.key[i] == k ) {
          return i;
        }
      }
      return -1;
    };
  }

  public ArbolB(int t) {
    T = t;
    root = new Node();
    root.n = 0;
    root.leaf = true;
  }

  public Node root;

  // Search key
  private Node Search(Node x, long key) {
    int i = 0;
    if (x == null)
      return x;
    for (i = 0; i < x.n; i++) {
      if (key < x.key[i]) {
        break;
      }
      if (key == x.key[i]) {
          contra=x.pass[i];
        return x;
      }
    }
    if (x.leaf) {
      return null;
    } else {
      return Search(x.child[i], key);
    }
  }

  
private void Remove(Node x, long key) {
    int pos = x.Find(key);
    if (pos != -1) {
      if (x.leaf) {
        int i = 0;
        for (i = 0; i < x.n && x.key[i] != key; i++) {
        }
        ;
        for (; i < x.n; i++) {
          if (i != 2 * T - 2) {
            x.key[i] = x.key[i + 1];
           
        x.nombre[i]=x.nombre[i+1];
      x.pass[i]=x.pass[i+1];
          }
        }
        x.n--;
        return;
      }
      int k=0;
      if (!x.leaf) {

        Node pred = x.child[pos];
        long predKey = 0;
        if (pred.n >= T) {
          for (;;) {
            if (pred.leaf) {
              System.out.println(pred.n);
              predKey = pred.key[pred.n - 1];
              k=pred.n=1;
              break;
            } else {
              pred = pred.child[pred.n];
            }
          }
          Remove(pred, predKey);
          x.key[pos] = predKey;
          x.nombre[pos]=pred.nombre[k];
           x.pass[pos]=pred.pass[k];
          return;
        }

        Node nextNode = x.child[pos + 1];
        if (nextNode.n >= T) {
          long nextKey = nextNode.key[0];
          if (!nextNode.leaf) {
            nextNode = nextNode.child[0];
            for (;;) {
              if (nextNode.leaf) {
                nextKey = nextNode.key[nextNode.n - 1];
                k=nextNode.n - 1;
                break;
              } else {
                nextNode = nextNode.child[nextNode.n];
              }
            }
          }
          Remove(nextNode, nextKey);
          x.key[pos] = nextKey;
          x.nombre[pos]=pred.nombre[k];
           x.pass[pos]=pred.pass[k];
          return;
        }

        int temp = pred.n + 1;
        pred.key[pred.n++] = x.key[pos];
        pred.nombre[pred.n++]=x.nombre[pos];
         pred.pass[pred.n++]=x.pass[pos];
        for (int i = 0, j = pred.n; i < nextNode.n; i++) {
          pred.key[j++] = nextNode.key[i];
          pred.nombre[j++]=x.nombre[i];
         pred.pass[j++]=x.pass[i];
          pred.n++;
        }
        for (int i = 0; i < nextNode.n + 1; i++) {
          pred.child[temp++] = nextNode.child[i];
        }

        x.child[pos] = pred;
        for (int i = pos; i < x.n; i++) {
          if (i != 2 * T - 2) {
            x.key[i] = x.key[i + 1];
             x.nombre[i]=x.nombre[i+1];
      x.pass[i]=x.pass[i+1];
          }
        }
        for (int i = pos + 1; i < x.n + 1; i++) {
          if (i != 2 * T - 1) {
            x.child[i] = x.child[i + 1];
          }
        }
        x.n--;
        if (x.n == 0) {
          if (x == root) {
            root = x.child[0];
          }
          x = x.child[0];
        }
        Remove(pred, key);
        return;
      }
    } else {
      for (pos = 0; pos < x.n; pos++) {
        if (x.key[pos] > key) {
          break;
        }
      }
      Node tmp = x.child[pos];
      if (tmp.n >= T) {
        Remove(tmp, key);
        return;
      }
      if (true) {
        Node nb = null;
        long devider = -1;

        if (pos != x.n && x.child[pos + 1].n >= T) {
          devider = x.key[pos];
          nb = x.child[pos + 1];
          x.key[pos] = nb.key[0];
           x.nombre[pos]=nb.nombre[0];
      x.pass[pos]=nb.pass[0];
          tmp.key[tmp.n++] = devider;
          tmp.child[tmp.n] = nb.child[0];
          for (int i = 1; i < nb.n; i++) {
            nb.key[i - 1] = nb.key[i];
            nb.nombre[i-1]=nb.nombre[i];
      nb.pass[i-1]=nb.pass[i];
          }
          for (int i = 1; i <= nb.n; i++) {
            nb.child[i - 1] = nb.child[i];
          }
          nb.n--;
          Remove(tmp, key);
          return;
        } else if (pos != 0 && x.child[pos - 1].n >= T) {
            int k=0;
          devider = x.key[pos - 1];
          k=pos - 1;
          nb = x.child[pos - 1];
          x.key[pos - 1] = nb.key[nb.n - 1];
           x.pass[pos - 1] = nb.pass[nb.n - 1];
            x.nombre[pos-1]=nb.nombre[nb.n - 1];
          Node child = nb.child[nb.n];
          nb.n--;

          for (int i = tmp.n; i > 0; i--) {
            tmp.key[i] = tmp.key[i - 1];
            tmp.pass[i] = nb.pass[i- 1];
            tmp.nombre[i]=nb.nombre[i- 1];
          }
          tmp.key[0] = devider;
          tmp.nombre[0]=tmp.nombre[k];
          tmp.pass[0]=tmp.pass[k];
          for (int i = tmp.n + 1; i > 0; i--) {
            tmp.child[i] = tmp.child[i - 1];
          }
          tmp.child[0] = child;
          tmp.n++;
          Remove(tmp, key);
          return;
        } else {
          Node lt = null;
          Node rt = null;
          boolean last = false;
          int k=0;
          if (pos != x.n) {
            devider = x.key[pos];
            k=pos;
            lt = x.child[pos];
            rt = x.child[pos + 1];
          } else {
            devider = x.key[pos - 1];
            k=pos-1;
            rt = x.child[pos];
            lt = x.child[pos - 1];
            last = true;
            pos--;
          }
          for (int i = pos; i < x.n - 1; i++) {
            x.key[i] = x.key[i + 1];
            x.pass[i] = nb.pass[i+ 1];
            x.nombre[i]=nb.nombre[i+ 1];
          }
          for (int i = pos + 1; i < x.n; i++) {
            x.child[i] = x.child[i + 1];
          }
          x.n--;
          lt.key[lt.n++] = devider;
          lt.nombre[lt.n++]=lt.nombre[k];
lt.pass[lt.n++]=lt.pass[k];
          for (int i = 0, j = lt.n; i < rt.n + 1; i++, j++) {
            if (i < rt.n) {
              lt.key[j] = rt.key[i];
              lt.pass[j] = rt.pass[i];
            lt.nombre[j]=rt.nombre[i];
            }
            lt.child[j] = rt.child[i];
          }
          lt.n += rt.n;
          if (x.n == 0) {
            if (x == root) {
              root = x.child[0];
            }
            x = x.child[0];
          }
          Remove(lt, key);
          return;
        }
      }
    }
  }

  public void Remove(long key) {
    Node x = Search(root, key);
    if (x == null) {
      return;
    }
    Remove(root, key);
  }
  
 
  private void Split(Node x, int pos, Node y) {
    Node z = new Node();
    z.leaf = y.leaf;
    z.n = T - 1;
    for (int j = 0; j < T - 1; j++) {
      z.key[j] = y.key[j + T];
    }
    if (!y.leaf) {
      for (int j = 0; j < T; j++) {
        z.child[j] = y.child[j + T];
      }
    }
    y.n = T - 1;
    for (int j = x.n; j >= pos + 1; j--) {
      x.child[j + 1] = x.child[j];
    }
    x.child[pos + 1] = z;

    for (int j = x.n - 1; j >= pos; j--) {
      x.key[j + 1] = x.key[j];
    }
    x.key[pos] = y.key[T - 1];
    x.n = x.n + 1;
  }

  // Inserting a value
  public void Insert(final long key, String pass,String nombre) {
    Node r = root;
    if (r.n == 2 * T - 1) {
      Node s = new Node();
      root = s;
      s.leaf = false;
      s.n = 0;
      s.child[0] = r;
      Split(s, 0, r);
      insertValue(s, key,pass,nombre);
    } else {
      insertValue(r, key,pass,nombre);
    }
  }


  final private void insertValue(Node x, long k,String pass,String nombre) {
      
    if (x.leaf) {
        System.out.println(k);
        System.out.println(pass);
        System.out.println(nombre);
      int i = 0;
      for (i = x.n - 1; i >= 0 && k < x.key[i]; i--) {
        x.key[i + 1] = x.key[i];
        x.nombre[i+1]=x.nombre[i];
      x.pass[i+1]=x.pass[i];
      }
      x.key[i + 1] = k;
      x.nombre[i+1]=nombre;
      x.pass[i+1]=pass;
      x.n = x.n + 1;
    } else {
      int i = 0;
      for (i = x.n - 1; i >= 0 && k < x.key[i]; i--) {
      }
      ;
      i++;
      Node tmp = x.child[i];
      if (tmp.n == 2 * T - 1) {
        Split(x, i, tmp);
        if (k > x.key[i]) {
          i++;
        }
      }
      insertValue(x.child[i], k,pass,nombre);
    }

  }

  public void Show() {
    Show(root);
  }

  // Display
  private void Show(Node x) {
      combo="";
    assert (x == null);
    for (int i = 0; i < x.n; i++) {
      System.out.print(x.key[i] + " ");
       if (combo=="") {
              combo=x.nombre[i]+"-"+String.valueOf(x.key[i]);
          } else {
              
              combo=combo+","+x.nombre[i]+"-"+String.valueOf(x.key[i]);
          }
    }
    if (!x.leaf) {
      for (int i = 0; i < x.n + 1; i++) {
        Show(x.child[i]);
      }
    }
  }

  // Check if present
  public boolean Contain(long k) {
    if (this.Search(root, k) != null) {
      return true;
    } else {
      return false;
    }
  }
  
  public boolean buscar(long k,String pass) {
    if (this.buscar(root, k,pass) != null) {
      return true;
    } else {
      return false;
    }
  }
  
  
   private Node buscar(Node x, long key,String pass) {
    int i = 0;
    if (x == null){
      return x;}
    for (i = 0; i < x.n; i++) {
        System.out.println(String.valueOf(x.key[i]));
        System.out.println(String.valueOf(x.pass[i]));
      if (key < x.key[i]) {
        break;
      }
        
      if (key == x.key[i] && pass.equals(x.pass[i]) ) {
        return x;
      }
    }
    if (x.leaf) {
      return null;
    } else {
      return buscar(x.child[i], key,pass);
    }
  }
//---------------------
  
    public boolean buscar2(long k,long cambio,String pass,String nombre) {
    if (this.buscar2(root, k,cambio,pass,nombre) != null) {
      return true;
    } else {
      return false;
    }
  }
  
  
   private Node buscar2(Node x, long key,long cambio,String pass,String nombre) {
    int i = 0;
    if (x == null){
      return x;}
    for (i = 0; i < x.n; i++) {
        System.out.println(String.valueOf(x.key[i]));
        System.out.println(String.valueOf(x.pass[i]));
      if (key < x.key[i]) {
        break;
      }
        
      if (key == x.key[i] && pass.equals(x.pass[i]) ) {
          if (Contain(cambio)) {
              JOptionPane.showMessageDialog(null,"DPI Ya ingresado");
          } else {
              
              x.key[i]=cambio;
              x.nombre[i]=nombre;
              x.pass[i]=pass;
              System.out.println(x.key[i]+" "+x.nombre[i]+" "+x.pass[i]);
              JOptionPane.showMessageDialog(null,"Modificacion Hecha\n"+
                      "DPI:"+cambio+
                      "\n Nombre:"+nombre+
                      "\n Pass:"+pass);
          }
        return x;
      }
    }
    if (x.leaf) {
      return null;
    } else {
      return buscar(x.child[i], key,pass);
    }
  }
   
  }
//    
//     private nodob root;
// 
//    /* Constructor */
//    public ArbolB() 
//    {
//        root = null;
//    }
// 
//   
//    public boolean isEmpty() 
//    {
//        return root == null;
//    }
// 
//    public void insert(long data,String pass,String nombre) 
//    {
//        root = insert(root, data,pass,nombre);
//    }
// 
//    /* Function to insert data recursively */
//    private nodob insert(nodob node, long data,String pass,String nombre) 
//    {
//        if (node == null)
//            node = new nodob(data,pass,nombre);
//        else 
//        {
//            if (data <= node.getData())
//                node.left = insert(node.left, data,pass,nombre);
//            else
//                node.right = insert(node.right, data,pass,nombre);
//        }
//        return node;
//    }
// 
//    /* Functions to delete data */
//    public void delete(long k)
//    {
//        if (isEmpty())
//            System.out.println("Tree Empty");
//        else if (search(k) == false)
//            System.out.println("Sorry " + k + " is not present");
//        else 
//        {
//            root = delete(root, k);
//            System.out.println(k + " deleted from the tree");
//        }
//    }
// 
//    private nodob delete(nodob root, long k) 
//    {
//        nodob p, p2, n;
//        if (root.getData() == k) 
//        {
//            nodob lt, rt;
//            lt = root.getLeft();
//            rt = root.getRight();
//            if (lt == null && rt == null)
//                return null;
//            else if (lt == null) 
//            {
//                p = rt;
//                return p;
//            }
//            else if (rt == null) 
//            {
//                p = lt;
//                return p;
//            } 
//            else 
//            {
//                p2 = rt;
//                p = rt;
//                while (p.getLeft() != null)
//                    p = p.getLeft();
//                p.setLeft(lt);
//                return p2;
//            }
//        }
//        if (k < root.getData()) 
//        {
//            n = delete(root.getLeft(), k);
//            root.setLeft(n);
//        }
//        else 
//        {
//            n = delete(root.getRight(), k);
//            root.setRight(n);
//        }
//        return root;
//    }
// 
//    /* Functions to count number of nodes */
//    public int countNodes() 
//    {
//        return countNodes(root);
//    }
// 
//    /* Function to count number of nodes recursively */
//    private int countNodes(nodob r) 
//    {
//        if (r == null)
//            return 0;
//        else 
//        {
//            int l = 1;
//            l += countNodes(r.getLeft());
//            l += countNodes(r.getRight());
//            return l;
//        }
//    }
// 
//    
//    
//       
//    /* Functions to search for an element */
//    public boolean search(long val) 
//    {
//        return search(root, val);
//    }
// 
//    /* Function to search for an element recursively */
//    private boolean search(nodob r, long val) 
//    {
//        boolean found = false;
//        while ((r != null) && !found) 
//        {
//            long rval = r.getData();
//            if (val < rval)
//                r = r.getLeft();
//            else if (val > rval)
//                r = r.getRight();
//            else 
//            {    System.out.println(r.data);
//            System.out.println(r.nombre);
//                found = true;
//                break;
//            }
//            found = search(r, val);
//        }
//        return found;
//    }
// 
//    /* Function for inorder traversal */
//    
//    
//    
//     public boolean search2(long val,String pass) 
//    {
//        return search2(root, val,pass);
//    }
// 
//    /* Function to search for an element recursively */
//    private boolean search2(nodob r, long val,String pass) 
//    {
//        boolean found = false;
//        while ((r != null) && !found) 
//        {
//            long rval = r.getData();
//            if (val < rval)
//                r = r.getLeft();
//            else if (val > rval)
//                r = r.getRight();
//            else if (val==rval && r.pass.equalsIgnoreCase(pass) )
//            
//            {    
//                found = true;
//                break;
//            }else{
//            break;
//            
//            }
//            
//            found = search2(r, val,pass);
//        }
//        return found;
//    }
//    public void inorder() 
//    {
//        inorder(root);
//    }
// 
//    private void inorder(nodob r) 
//    {
//        if (r != null) 
//        {
//            inorder(r.getLeft());
//            System.out.print(r.getData() + " ");
//            inorder(r.getRight());
//        }
//    }
// 
//    /* Function for preorder traversal */
//    public void preorder() 
//    {
//        preorder(root);
//    }
// 
//    private void preorder(nodob r) 
//    {
//        if (r != null) 
//        {
//            System.out.print(r.getData() + " ");
//            preorder(r.getLeft());
//            preorder(r.getRight());
//        }
//    }
// 
//    /* Function for postorder traversal */
//    public void postorder() 
//    {
//        postorder(root);
//    }
// 
//    private void postorder(nodob r) 
//    {
//        if (r != null) 
//        {
//            postorder(r.getLeft());
//            postorder(r.getRight());
//            System.out.print(r.getData() + " ");
//        }
//    }
////    int orden_arbol = 5;
////   public RamaB raiz;
////
////    public ArbolB() {
////        this.raiz = null;
////    }
////    
////    public void insertar(long id,String nombre, String Password) {
////        nodob nodo = new nodob(id,nombre,Password);
////        if (raiz == null) {
////            raiz = new RamaB();
////            raiz.insertar(nodo);
////        } else {
////            nodob obj = insertar_en_rama(nodo, raiz);
////            if (obj != null) {
////                //si devuelve algo el metodo de insertar en rama quiere decir que creo una nueva rama, y se debe insertar en el arbol
////                raiz = new RamaB();
////                raiz.insertar(obj);
////                raiz.hoja = false;
////            }
////        }
////    }
////    
////    
////    private nodob insertar_en_rama(nodob nodo, RamaB rama) {
////        if (rama.hoja) {
////            rama.insertar(nodo);
////            if (rama.contador == orden_arbol) {
////                //si ya se insertaron todos los elementos posibles se debe dividir la rama
////                return dividir(rama);
////            } else {
////                return null;
////            }
////        } else {
////            nodob temp = rama.primero;
////            do {
////                if (nodo.id == temp.id) {
////                    return null;
////                } else if (nodo.id < temp.id) {
////                    nodob obj = insertar_en_rama(nodo,temp.izquierda );
////                    if (obj instanceof nodob) {
////                        rama.insertar((nodob) obj);
////                        if (rama.contador == orden_arbol) {
////                            return dividir(rama);
////                        }
////                    }
////                    return null;
////                } else if (temp.siguiente == null) {
////                    nodob obj = insertar_en_rama(nodo, temp.derecha);
////                    if (obj instanceof nodob) {
////                        rama.insertar((nodob) obj);
////                        if (rama.contador == orden_arbol) {
////                            return dividir(rama);
////                        }
////                    }
////                    return null;
////                }
////                temp = (nodob) temp.siguiente;
////            } while (temp != null);
////        }
////        return null;
////    }
////    
////    private nodob dividir(RamaB rama) {
////        long val = -999;
////        String nombre="";
////                String paa="";
////        nodob temp, Nuevito;
////        nodob aux = rama.primero;
////        RamaB rderecha = new RamaB();
////        RamaB rizquierda = new RamaB();
////
////        int cont = 0;
////        while (aux != null) {
////            cont++;
////            //implementacion para dividir unicamente ramas de 4 nodos
////            if (cont < 3) {
////                temp = new nodob(aux.id,aux.nombre,aux.Password);
////                temp.izquierda = aux.izquierda;
////                if (cont == 2) {
////                    temp.derecha = aux.siguiente.izquierda;
////                } else {
////                    temp.derecha = aux.derecha;
////                }
////                //si la rama posee ramas deja de ser hoja
////                if (temp.derecha != null && temp.izquierda != null) {
////                    rizquierda.hoja = false;
////                }
////
////                rizquierda.insertar(temp);
////
////            } else if (cont == 3) {
////                val = aux.id;
////                nombre=aux.nombre;
////                paa=aux.Password;
////                
////            } else {
////                temp = new nodob(aux.id,aux.Password,aux.Password);
////                temp.izquierda = aux.izquierda;
////                temp.derecha = aux.derecha;
////                //si la rama posee ramas deja de ser hoja
////                if (temp.derecha != null && temp.izquierda != null) {
////                    rderecha.hoja = false;
////                }
////                rderecha.insertar(temp);
////            }
////            aux = aux.siguiente;
////        }
////        Nuevito = new nodob(val,nombre,paa);
////        Nuevito.derecha = rderecha;
////        Nuevito.izquierda = rizquierda;
////        return Nuevito;
////    }
////    
////    
////    
////    public boolean buscar(long user, String pasa){
////        boolean existe=false;
////        nodob aux= raiz.primero ;
////        
////        while (aux!=null  && existe==false)  {            
////            if (aux.id==user && aux.Password==pasa) {
////                existe=true;
////                return existe;
////               
////            }
////            
////            aux= aux.siguiente;
////        }
////        
////    
////        return false;
////    
////    
////    }
//    
//}
