package vista;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import org.json.simple.parser.ParseException;

import control.ControlVuelos;
import control.VueloException;
import entidad.Vuelo;


public class PantallaVuelos {
    static Scanner in = new Scanner(System.in);
    public static void main(String [] args)
	{
        inicio();
	}
	
	/**
	 * Metodo de inicialización de carga de Rutas y Vuelos respectivamente.
	 */

    public static void inicio(){
        String rutaArchivo = "datos/vuelos.json";
        ControlVuelos controlVuelos = new ControlVuelos();

        System.out.println("Bienvenido a Randy's Airlines Colombia SA");
        System.out.println("\n");

        System.out.println("Ingrese la ciudad de origen: ");
        String origen = in.next();
        System.out.println("\n");

        System.out.println("Ingrese la ciudad de destino: ");
        String destino = in.next();
        System.out.println("\n");
        
        System.out.println("Vuelos posibles: ");
		try{
            controlVuelos.crearVuelos(rutaArchivo);
            for (Vuelo vuelo : controlVuelos.mostrarVuelosPosibles(origen, destino)) {
                System.out.println(vuelo);
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
        
		catch(VueloException e)
		{
			System.out.println(e.getMessage());
		}
    }
    
}
