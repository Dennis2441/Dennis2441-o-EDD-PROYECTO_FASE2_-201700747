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
import fase2.Estructura.binario;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
public class CargaBinaria {
    public void carga(String archivo, binario ab) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(archivo));
            JSONArray array = (JSONArray) obj;
            
            for (Object o : array) {
                    JSONObject jsonObject = (JSONObject) o;
                    String id = (String) jsonObject.get("id_capa");
                   
                   JSONArray pixel=(JSONArray) jsonObject.get("pixeles");
                    
                   long idd=Long.parseLong(id);
                    ab.insertar(idd, pixel);
                    /*for (Object capa : capas) {
                        System.out.println(capa);
                    }*/
                    
                }JOptionPane.showMessageDialog(null,"Carga Completa");
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
