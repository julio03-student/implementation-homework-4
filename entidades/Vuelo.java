import java.util.ArrayList;
import java.util.List;

public class Vuelo{
    private String origen;
    private String destino;
    private double precio;
    private double duracion;
    private boolean conEscala;
    private List<Ruta> rutas;
    
    public Vuelo(String origen, String destino, double precio, double duracion, boolean conEscala) {
        this.origen = origen;
        this.destino = destino;
        this.precio = precio;
        this.duracion = duracion;
        this.conEscala = conEscala;
        this.rutas = new ArrayList<Ruta>(); 
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

    public List<Ruta> getRutas() {
        return rutas;
    }

    public void agregarRuta(Ruta ruta){
        rutas.add(ruta);
    }

}