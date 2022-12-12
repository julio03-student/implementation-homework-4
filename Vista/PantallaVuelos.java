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
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import control.ControlVuelos;
import entidad.Ruta;


public class PantallaVuelos {
	public static void main(String [] args)
	{
		try{
            
            System.out.println("Hola");
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
