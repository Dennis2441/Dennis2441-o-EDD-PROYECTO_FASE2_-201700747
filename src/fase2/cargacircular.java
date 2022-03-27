/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fase2;

/**
 *
 * @author denni
 */

import fase2.Estructura.avl;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import fase2.Estructura.listacirculardoble;
import javax.swing.JOptionPane;
public class cargacircular {
     public void carga(String archivo,listacirculardoble li) {
        int h=0;
        int co=0;
        int[] capas;
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(archivo));
            JSONArray array = (JSONArray) obj;
            
            for (Object o : array) {
                    JSONObject jsonObject = (JSONObject) o;
                    String id = (String) jsonObject.get("nombre_album");
                    String caa = (String) jsonObject.get("imgs");
                    caa=caa.replace("[", "");
                    caa=caa.replace("]", "");
                    String[] ca=caa.split(",");
                    for (String a : ca) {
                         h=h+1;
                         
                }
                    capas=new int[h];
                    for (String a : ca) {
                        
                         capas[co]=Integer.parseInt(a);
                         
                }
                  
                    
                    li.insertarInicio(id, capas);
                   
                    /*for (Object capa : capas) {
                        System.out.println(capa);
                    }*/
                    JOptionPane.showMessageDialog(null,"Carga Completa");
                }
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
