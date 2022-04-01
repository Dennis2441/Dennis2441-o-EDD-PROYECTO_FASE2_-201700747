/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fase2;

/**
 *
 * @author denni
 */


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import fase2.Estructura.ArbolB;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;

public class Carga {
    int cont=0;
        String junto="";
        public  String[] names;
    public void carga(String archivo,ArbolB ab) {
        JSONParser parser = new JSONParser();
        
        try {
            Object obj = parser.parse(new FileReader(archivo));
            JSONArray array = (JSONArray) obj;
            
            for (Object o : array) {
                cont=cont+1;
                    JSONObject jsonObject = (JSONObject) o;
                    String id = (String) jsonObject.get("dpi");
                   String nombre=(String) jsonObject.get("nombre_cliente");
                   String pass=(String) jsonObject.get("password");
                    
                   long idd=Long.parseLong(id);
                   System.out.println(id+" "+ nombre+" "+pass);
                   if (junto=="") {
                    junto=String.valueOf(id);
                } else {
                       
                       junto=junto+","+String.valueOf(id);
                }
                   if (ab.Contain(idd)) {
                    
                } else {
                       
                       ab.Insert(idd, pass, nombre);
                }
                    
                    /*for (Object capa : capas) {
                        System.out.println(capa);
                    }*/
                   
                }
            names=junto.split(",");
            JOptionPane.showMessageDialog(null,"Carga Completa");
            //cargajndsnjds
                //JOptionPane.showMessageDialog(null, "Carga masiva de imagenes exitosa");
            } catch (FileNotFoundException ex) { 
            Logger.getLogger(Carga.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Carga.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Carga.class.getName()).log(Level.SEVERE, null, ex);
        } 
    
    
    
}
}