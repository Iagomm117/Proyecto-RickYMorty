package main;

import controller.MainFrameController;
import java.io.IOException;
import model.Personajes;
import view.MainFrame;
import view.usuarios.InicioFrame;

/**
 *
 * @author dam2_alu06@inf.ald
 */
public class ProyectoRickAndMorty {
    private static Personajes model;
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        UtilidadesAPI.MostrarAPI();
        model = UtilidadesAPI.existeArchivo();
        
        MainFrame view = new MainFrame();
        InicioFrame start = new InicioFrame();
        //start.setVisible(true);
        MainFrameController controller = new MainFrameController(view,model);
        view.setVisible(true);
    }
}