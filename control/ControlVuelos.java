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
    ControlRutas control = new ControlRutas();

    public ControlVuelos() {
        this.listaVuelos = new ArrayList<Vuelo>();
    }

    /**
     * Método en el cual retornará todos aquellos velos que 
     * cumplan con el origen y el destino ingresado
     * 
     * @param origen
     * @param destino
     * @return Lista de vuelos encontrados
     * @throws VueloException
     * 
     */

    public List<Vuelo> mostrarVuelosDisponibles(String origen, String destino) throws VueloException{
        if(origen == "" && destino == ""){
            throw new VueloException("Los datos ingresados no son válidos");
        }

        List<Vuelo> vuelosB = new ArrayList<Vuelo>();

        for (Vuelo vuelo : listaVuelos) {
            if(vuelo.getOrigen().equals(origen) && vuelo.getDestino().equals(destino)){
                vuelosB.add(vuelo);
            }
        }

        if(vuelosB.size() == 0){
            throw new VueloException("No se encontraron vuelos con estas características");
        }

        return vuelosB;
    }

    public void crearVuelos(String rutaArchivo) throws FileNotFoundException, ParseException, IOException{
        
        List<List<Ruta>> rutasVuelos = control.cargarDatosIniciales(rutaArchivo);

        String origen;
        String destino;
        double duracion;
        double precio;
        boolean conEscala;

        for (List<Ruta> rutas : rutasVuelos) {
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

    public Vuelo buscarVuelo(Vuelo vueloABuscar){
        for (Vuelo vuelo : listaVuelos) {
            if(vuelo.getOrigen().equals(vueloABuscar.getOrigen()) && vuelo.getDestino().equals(vueloABuscar.getDestino()) && vuelo.getDuracion() == vueloABuscar.getDuracion() && vuelo.getPrecio() == vueloABuscar.getPrecio() && vuelo.esConEscala() == vueloABuscar.esConEscala()){
                return vuelo;
            }
        }   
        return null;
    }

    public double calcularPrecioVuelo(List<Ruta> rutas){
        double precio = 0;
         for (Ruta ruta : rutas) {
            precio += ruta.getPrecio();
         }
         return precio;
    }

    public double calcularDuracionVuelo(List<Ruta> rutas){
        double duracion = 0;
         for (Ruta ruta : rutas) {
            duracion += ruta.getDuracion();
         }
         return duracion;
    }
    
    
}
