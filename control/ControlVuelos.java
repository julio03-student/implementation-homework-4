package control;

import java.util.ArrayList;
import java.util.List;

import entidad.Ruta;
import entidad.Vuelo;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.parser.ParseException;

public class ControlVuelos {

    private List<Vuelo> listaVuelos;
    ControlRutas control;

    public ControlVuelos() {
        this.listaVuelos = new ArrayList<Vuelo>();
        this.control = new ControlRutas();
    }

    /**
     * Método en el cual se retornarán todos aquellos Vuelos que 
     * cumplan con el origen y el destino ingresado.
     * 
     * @param origen, ciduad de Origen del Vuelo
     * @param destino, ciduad de Destino del Vuelo
     * @return Lista de vuelos encontrados
     * @throws VueloException
     * 
     */

    public List<Vuelo> mostrarVuelosPosibles(String origen, String destino) throws VueloException{
        if(origen == "" && destino == ""){
            throw new VueloException("Los datos ingresados no son válidos");
        }

        List<Vuelo> vuelosPosibles = buscarVuelos(origen,destino);

        if(vuelosPosibles.size() == 0){
            throw new VueloException("No se encontraron vuelos con estas características");
        }

        return vuelosPosibles;
    }

    public List<Vuelo> buscarVuelos(String origen, String destino){
        List<Vuelo> vuelos = new ArrayList<Vuelo>();

        for (Vuelo vuelo : listaVuelos) {
            if(vuelo.getOrigen().equals(origen) && vuelo.getDestino().equals(destino)){
                vuelos.add(vuelo);
            }
        }

        return vuelos;
    }

    /**
     * Después de le lectura del archivo, se procederá a la creación de cada Vuelo, con sus respectivas Rutas.
     * 
     * @param rutaArchivo ruta del archivo donde se tiene las Rutas a cargar
     * @throws FileNotFoundException
     * @throws ParseException
     * @throws IOException
     */

    public void crearVuelos(String rutaArchivo) throws FileNotFoundException, ParseException, IOException, VueloException{
        if(rutaArchivo == ""){
            throw new FileNotFoundException("Por favor ingrese una ruta válida");
        }
        List<List<Ruta>> rutasVuelos = control.cargarDatosIniciales(rutaArchivo);

        String origen;
        String destino;
        double duracion;
        double precio;
        boolean conEscala;

        for (List<Ruta> rutas : rutasVuelos) {
            if(rutas.size()>2){
                throw new VueloException("Se ha excedido el número de escalas permitidas");
            }
            duracion = calcularDuracionVuelo(rutas);
            precio = calcularPrecioVuelo(rutas);
            if(rutas.size() == 2){
                origen = rutas.get(0).getOrigen();
                destino = rutas.get(1).getDestino();
                conEscala = true;
            }else{
                origen = rutas.get(0).getOrigen();
                destino = rutas.get(0).getDestino();
                conEscala = false;
            }
            Vuelo vuelo = new Vuelo(origen,destino,precio,duracion,conEscala);

            vuelo.agregarRutas(rutas);

            listaVuelos.add(vuelo);
        }
    }

    /**
     * Dada una lista de rutas, se procederá a retornar el precio total del Vuelo (sea con escala o sin escala).
     * 
     * @param List<Ruta> rutas, lista de rutas del Vuelo referenciado
     * @return precio total del Vuelo
     */

    public double calcularPrecioVuelo(List<Ruta> rutas){
        double precio = 0;
         for (Ruta ruta : rutas) {
            precio += ruta.getPrecio();
         }
         return precio;
    }

    public int totalVuelos(){
        return listaVuelos.size();
    }

    /**
     * Dada una lista de rutas, se procederá a retornar el duración total del Vuelo (sea con escala o sin escala).
     * 
     * @param List<Ruta> rutas, lista de rutas del Vuelo referenciado
     * @return duración total del Vuelo
     */

    public double calcularDuracionVuelo(List<Ruta> rutas){
        double duracion = 0;
         for (Ruta ruta : rutas) {
            duracion += ruta.getDuracion();
         }
         return duracion;
    }
    
    
}
