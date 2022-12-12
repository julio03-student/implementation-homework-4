package lector;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LectorArchivo {

    private String nombreArchivo;

    public LectorArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    /**
     * Método que se encarga de convertir el archivo .json en una lista de objetos
     * 
     * @return JSONArray del procesamiento del archivo
     * @throws FileNotFoundException
     * @throws ParseException
     * @throws IOException
     */

    public JSONArray obtenerDatos() throws FileNotFoundException, ParseException, IOException{

        JSONParser parser = new JSONParser();
		FileReader fileReader;
        File file = new File(nombreArchivo);
        fileReader = new FileReader(file);
        
        JSONArray array = (JSONArray) parser.parse(fileReader);

        if(fileReader.read() == 0){
            throw new IOException("El archivo está vacío");
        }

        if(array.isEmpty()){
            throw new ParseException(202, "El formato del archivo es inválido");
        }

        if(!file.exists()){
            throw new FileNotFoundException("No se encontró el archivo");
        }

        return array;
    }

}
