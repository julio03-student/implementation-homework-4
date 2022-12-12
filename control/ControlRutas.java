package control;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import java.util.ArrayList;
import java.util.List;

import entidad.Ruta;

public class ControlRutas {

    List<Ruta> listaRutas;

    public ControlRutas() {
        this.listaRutas = new ArrayList<Ruta>();
    }

    /**
     * Realiza la carga inicial de las rutas haciendo la creación de Vuelos y Rutas que corresponden a los mimsmos.
     * 
     * @param ruta
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ParseException
     */

    public List<List<Ruta>> cargarDatosIniciales(String ruta) throws FileNotFoundException, IOException, ParseException{

        CargarDatos datos = new CargarDatos(ruta);
        List<List<String[]>> rutasCargadas = datos.cargarDatos();
        List<List<Ruta>> rutasVuelos = new ArrayList<List<Ruta>>();
        
        for (List<String[]> rutas : rutasCargadas) {
            List<Ruta> rutasVuelo = new ArrayList<Ruta>();
            for (String[] rutaACargar : rutas) {
                Ruta rutaNueva = new Ruta(rutaACargar[0], rutaACargar[1], Double.parseDouble(rutaACargar[2]), Double.parseDouble(rutaACargar[3]));
                listaRutas.add(rutaNueva);
                rutasVuelo.add(rutaNueva);
            }
            rutasVuelos.add(rutasVuelo);
        }

        return rutasVuelos;
    }
   
}
