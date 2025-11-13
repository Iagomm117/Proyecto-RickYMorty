package main;

import java.io.IOException;
import model.Personajes;

/**
 *
 * @author dam2_alu06@inf.ald
 */
public class ProyectoRickAndMorty {
    private static final Personajes model = new Personajes();
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        UtilidadesAPI.existeArchivo();
    }
}