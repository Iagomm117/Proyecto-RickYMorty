package main;

import controller.usuarios.InicioFrameController;
import java.io.IOException;
import model.Personajes;
import model.usuarios.Usuarios;
import view.usuarios.InicioFrame;

/**
 *
 * @author dam2_alu06@inf.ald
 */
public class ProyectoRickAndMorty {
    private static Personajes model;
    private static Usuarios users;
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        UtilidadesAPI.MostrarAPI();
        model = UtilidadesAPI.existeArchivo();
        users = UtilidadesUsuarios.existeArchivo();
        
        InicioFrame start = new InicioFrame();
        InicioFrameController controller = new InicioFrameController(start,model,users);
        start.setVisible(true);
    }
}