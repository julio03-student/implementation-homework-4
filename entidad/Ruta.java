package entidad;

public class Ruta {
    private String origen;
    private String destino;
    private double precio;
    private double duracion;

    public Ruta(String origen, String destino, double precio, double duracion) {
        this.origen = origen;
        this.destino = destino;
        this.precio = precio;
        this.duracion = duracion;
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
}
