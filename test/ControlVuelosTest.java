package test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import control.ControlVuelos;
import control.VueloException;

public class ControlVuelosTest {
    ControlVuelos controlVuelos = new ControlVuelos();
    @Test
    void testCrearVuelosRutaValida() throws FileNotFoundException, ParseException, IOException, VueloException {
        controlVuelos.crearVuelos("C:/Archivos/U de Caldas files/Ingeniería_de_Software 1/Tareas/implementation-homework-4/datos/vuelos.json");
        int vuelosEsperados = 10;
        int vuelosCargados = controlVuelos.totalVuelos();
        assertEquals(vuelosEsperados, vuelosCargados);
    }

    @Test
    void testCrearVuelosRutaInvalida(){
        assertThrows(FileNotFoundException.class, () -> controlVuelos.crearVuelos(""));
    }
}
