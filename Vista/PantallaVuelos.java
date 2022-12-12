package Vista;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.parser.ParseException;

import control.ControlVuelos;


public class PantallaVuelos {

    public static void main(String [] args)
	{
        inicio();
	}

    public static void inicio(){
        String rutaArchivo = "Datos/Vuelos.json";
        ControlVuelos controlVuelos = new ControlVuelos();

		try{
            
            controlVuelos.crearVuelos(rutaArchivo);
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
