package control;

import java.util.ArrayList;
import java.util.List;

import entidad.Ruta;

public class ControlRutas {

    List<Ruta> rutas;

    public ControlRutas() {
        this.rutas = new ArrayList<Ruta>();
    }

    public Ruta buscarRuta(Ruta rutaABuscar){
        for (Ruta ruta : rutas) {
            if(ruta.getOrigen().equals(rutaABuscar.getOrigen()) && ruta.getDestino().equals(rutaABuscar.getDestino()) && ruta.getDuracion() == rutaABuscar.getDuracion() && ruta.getPrecio() == rutaABuscar.getPrecio()){
                return ruta;
            }
        }
        return null;
    }



    
}
