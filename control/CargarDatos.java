package control;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import lector.LectorArchivo;

public class CargarDatos {

    private LectorArchivo lectorArchivo;

    public CargarDatos(String nombreArchivo) {
        this.lectorArchivo = new LectorArchivo(nombreArchivo);
    }

    /**
     * Este método se encarga de realizar del procesamiento de las rutas, guardando en una sublista 
     * la o las rutas que corresponden a cada Vuelo.
     * 
     * @return Lista de listas de arreglos de String (List<List<String[]>>)
     * @throws FileNotFoundException
     * @throws ParseException
     * @throws IOException
     */
    
    public List<List<String[]>> cargarDatos() throws FileNotFoundException, ParseException, IOException{
        
        
        JSONArray array = lectorArchivo.obtenerDatos();

        List<List<String[]>> rutas = new ArrayList<List<String[]>>();
        
        for(int i=0;i<array.size();i++)
        {
            String llave = String.valueOf(i+1);
            JSONObject obj =  (JSONObject)array.get(i);
            JSONArray vuelos = (JSONArray)obj.get(llave);

            List<String[]> rutaB = new ArrayList<String[]>();
            
            for(int j = 0; j < vuelos.size(); j++){
                JSONObject ruta  = (JSONObject)vuelos.get(j);
                String origen = (String)ruta.get("origen");
                String destino = (String)ruta.get("destino");
                String precio = String.valueOf(ruta.get("precio"));
                String duracion = String.valueOf(ruta.get("duracion"));
                String [] rutaC = {origen, destino, precio, duracion};
                rutaB.add(j, rutaC);
            }
            
            rutas.add(i,rutaB);
            
        }

        return rutas;
    }

}