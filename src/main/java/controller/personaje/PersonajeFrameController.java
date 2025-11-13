package controller.personaje;

import java.io.IOException;
import model.Personajes;
import view.personaje.PersonajeDialog;

/**
 *
 * @author dam2_alu08@inf.ald
 */
public class PersonajeFrameController {
    private final PersonajeDialog view;
    private final Personajes model;

    public PersonajeFrameController(PersonajeDialog view, Personajes model) throws IOException {
        this.view = view;
        this.model = model;
        this.initItemsComboBox();
        
    }
    
    private void initItemsComboBox() throws IOException{
        System.out.println(model.getSize());
        for (int i = 0; i < model.getSize(); i++) {
            view.addItemIdComboBox(Integer.toString(model.getPersonaje(i).getId()));
            mostrarDatos();
        }
    }
    
    private void mostrarDatos() throws IOException{
        int id = Integer.parseInt(view.getItemIdComboBox()) -1;
        this.view.setIconImageLabel(model.getPersonaje(id).getImage());
        this.view.setTextNameLabel(model.getPersonaje(id).getName());
        this.view.setTextStatusLabel(model.getPersonaje(id).getStatus());
        
        
    }
    
    
    
}
