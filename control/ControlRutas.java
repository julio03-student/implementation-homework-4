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
     * Realiza la carga inicial de las rutas y retorna una lista de listas de rutas para cada vuelo.
     * 
     * @param ruta
     * @return Lista de listas de rutas. List<List<Ruta>>
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
