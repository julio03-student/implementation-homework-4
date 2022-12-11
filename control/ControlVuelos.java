package control;

import java.util.ArrayList;
import java.util.List;

import entidad.Vuelo;

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

    public void crearVuelo(String origen, String destino){

    }

    public Vuelo buscarVuelo()

    
    
}
