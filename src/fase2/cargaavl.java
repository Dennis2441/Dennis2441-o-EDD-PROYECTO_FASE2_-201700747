/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fase2;

import fase2.Estructura.avl;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
        import fase2.Estructura.prueba;

/**
 *
 * @author denni
 */
public class cargaavl {
    int capas[];
    int h=0;
    int co=0;
    public void carga(String archivo,prueba.avl av) {
        
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(archivo));
            JSONArray array = (JSONArray) obj;
            
            for (Object o : array) {
                h=0;
                co=0;
                    JSONObject jsonObject = (JSONObject) o;
                    Comparable id = (Comparable) jsonObject.get("id");
                    String idf=  String.valueOf(id);
                    int id2=Integer.parseInt(idf);
                 System.out.println(idf);
                     String caa = (String) String.valueOf(jsonObject.get("capas"));
                    caa=caa.replace("[", "");
                    caa=caa.replace("]", "");
                    String[] ca=caa.split(",");
                    for (String a : ca) {
                         h=h+1;
                         
                }
                    capas=new int[h];
                    for (String a : ca) {
                        
                         capas[co]=Integer.parseInt(a);
                         co=co+1;
                         
                }
                    av.insert(id, id2,capas);
                   
                    /*for (Object capa : capas) {
                        System.out.println(capa);
                    }*/
                       
                }JOptionPane.showMessageDialog(null,"Carga Completa");
                //JOptionPane.showMessageDialog(null, "Carga masiva de imagenes exitosa");
            } catch (FileNotFoundException ex) { 
            Logger.getLogger(cargaavl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(cargaavl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(cargaavl.class.getName()).log(Level.SEVERE, null, ex);
        } 
    
    }
        
        
    
}