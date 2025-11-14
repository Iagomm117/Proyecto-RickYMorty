package controller.personaje;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        this.view.addIdComboBoxActionListener(this.getIdComboBoxActionListener());
        
    }
    
    private void initItemsComboBox() throws IOException{
        System.out.println(model.getSize());
        for (int i = 0; i < model.getSize(); i++) {
            view.addItemIdComboBox(Integer.toString(model.getPersonaje(i).getId()));
            mostrarDatos();
        }
    }
    
    private void mostrarDatos() throws IOException{
        int id = Integer.parseInt(view.getItemIdComboBox()) -1 ;
        this.view.setIconImageLabel(model.getPersonaje(id).getImage());
        this.view.setTextNameLabel(model.getPersonaje(id).getName());
        this.view.setTextStatusLabel(model.getPersonaje(id).getStatus());
        this.view.setTextSpeciesLabel(model.getPersonaje(id).getSpecie());
        this.view.setTextTypeLabel(model.getPersonaje(id).getType());
        this.view.setTextGenderLabel(model.getPersonaje(id).getGender());
        this.view.setTextOriginLabel(model.getPersonaje(id).getOrigin().getName());
        this.view.setTextLocationLabel(model.getPersonaje(id).getLocation().getName());
        
        
    }
    
    private ActionListener getIdComboBoxActionListener(){
       ActionListener al = new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent ae) {
               int id = Integer.parseInt(view.getItemIdComboBox());
               for (int i = 0; i < model.getSize(); i++) {
                    if( id == model.getPersonaje(i).getId()) {
                        try {
                            mostrarDatos();
                        } catch (IOException ex) {
                            
                        }
                    }
               }
           }
       };
       return al;
    }
    
    
    
}
