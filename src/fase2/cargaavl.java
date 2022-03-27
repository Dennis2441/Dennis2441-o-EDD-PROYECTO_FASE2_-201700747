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

/**
 *
 * @author denni
 */
public class cargaavl {
    
    public void carga(String archivo,avl av) {
        
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(archivo));
            JSONArray array = (JSONArray) obj;
            
            for (Object o : array) {
                    JSONObject jsonObject = (JSONObject) o;
                    Comparable id = (Comparable) jsonObject.get("id");
                    JSONArray capas = (JSONArray) jsonObject.get("capas");
                    av.insert(id, capas);
                   
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
