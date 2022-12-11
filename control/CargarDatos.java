package control;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class CargarDatos {

    public CargarDatos() {
    }
    
    public List<String[]> cargarDatos(String ruta){
        List<String[]> archivo = new ArrayList<String[]>();

        String json = "";
        JsonParser parser = new JsonParser();
        JsonArray array = parser.parse(ruta).getAsJsonArray();

        for (JsonElement jsonElement : array) {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
        }
        return archivo;
    }

}