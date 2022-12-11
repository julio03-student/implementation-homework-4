//

// import java.util.List;

// import control.CargarDatos;

// public class PantallaVuelos {
//     public static void main(String[] args) {
//         CargarDatos cargador = new CargarDatos();

//         List<String[]> datos = cargador.cargarDatos("Vuelos.json");
//     }
// }

package Vista;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import org.json.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class PantallaVuelos {
	public static void main(String [] args)
	{
		JSONParser parser = new JSONParser();
		FileReader fileReader;
		try {
			File file = new File("Vuelos.json");
			fileReader = new FileReader(file);
			// Parser returns an object, we need an explicit cast to covert it into a JSONArray
			JSONArray array = (JSONArray) parser.parse(fileReader);

			//Traverse the list
			for(int i=0;i<array.size();i++)
			{
                String llave = String.valueOf(i+1);
				JSONObject obj =  (JSONObject)array.get(i);
				JSONArray vuelo1 = (JSONArray)obj.get(llave);
                for(int j = 0; j < vuelo1.size(); j++){
                    System.out.println(vuelo1.get(j));
                } 
			}

		}

		catch(FileNotFoundException e)
		{
			System.out.println(e.getStackTrace()+ " :File Not Found");
		}
		catch(ParseException e)
		{
			System.out.println(e.getStackTrace()+ " :Could not parse");
		}
		catch(IOException e)
		{
			System.out.println(e.getStackTrace()+ " :IOException");
		}
	}
}
