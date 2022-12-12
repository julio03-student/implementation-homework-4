package entidad;

import java.util.ArrayList;
import java.util.List;

public class Vuelo{
    private String origen;
    private String destino;
    private double precio;
    private double duracion;
    private boolean conEscala;
    private List<Ruta> listaRutas;
    
    public Vuelo(String origen, String destino, double precio, double duracion, boolean conEscala) {
        this.origen = origen;
        this.destino = destino;
        this.precio = precio;
        this.duracion = duracion;
        this.conEscala = conEscala;
        this.listaRutas = new ArrayList<Ruta>(); 
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public double getPrecio() {
        return precio;
    }

    public double getDuracion() {
        return duracion;
    }

    public boolean esConEscala() {
        return conEscala;
    }

    /**
     * Permite agregar la rutas para el vuelo referenciado
     * 
     * @param rutas
     */

    public void agregarRutas(List<Ruta> rutas){
        for (Ruta ruta : rutas) {
            listaRutas.add(ruta);
        }
    }

    @Override
    public String toString() {
        return "Vuelo [origen=" + origen + ", destino=" + destino + ", precio=" + precio + ", duracion=" + duracion
                + ", conEscala=" + conEscala + "]";
    }

}