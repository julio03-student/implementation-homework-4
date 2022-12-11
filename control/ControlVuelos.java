package control;

import java.util.ArrayList;
import java.util.List;

import entidad.Ruta;
import entidad.Vuelo;

import control.ControlRutas;

public class ControlVuelos {

    private List<Vuelo> vuelos;

    public ControlVuelos() {
        this.vuelos = new ArrayList<Vuelo>();
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

        for (Vuelo vuelo : vuelos) {
            if(vuelo.getOrigen().equals(origen) && vuelo.getDestino().equals(destino)){
                vuelosB.add(vuelo);
            }
        }

        if(vuelosB.size() == 0){
            throw new VueloException("No se encontraron vuelos con estas características");
        }

        return vuelosB;
    }

    public void crearVuelo(List<String> rutas){
        ControlRutas control = new ControlRutas();
        for(int i = 0; i < rutas.size(); i++){
            Ruta ruta = control.buscarRuta(rutas.get(i));
        }
    }

    public Vuelo buscarVuelo(Vuelo vueloABuscar){
        for (Vuelo vuelo : vuelos) {
            if(vuelo.getOrigen().equals(vueloABuscar.getOrigen()) && vuelo.getDestino().equals(vueloABuscar.getDestino()) && vuelo.getDuracion() == vueloABuscar.getDuracion() && vuelo.getPrecio() == vueloABuscar.getPrecio() && vuelo.esConEscala() == vueloABuscar.esConEscala()){
                return vuelo;
            }
        }   
        return null;
    }

    
    
}
