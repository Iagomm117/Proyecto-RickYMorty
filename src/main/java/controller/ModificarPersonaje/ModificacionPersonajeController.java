/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.ModificarPersonaje;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.Personaje;
import model.Personajes;
import model.usuarios.Usuario;
import view.ModificarPersonaje.ModificacionPersonajeDialog;
import view.personaje.PersonajeDialog;

/**
 *
 * @author duroi
 */
public class ModificacionPersonajeController {

    private final PersonajeDialog mainView;
    private final Personajes model;
    private static Usuario user;

    public ModificacionPersonajeController(PersonajeDialog mainView, Personajes model, Usuario user) {
        this.mainView = mainView;
        this.model = model;
        this.user = user;
        configurarBotones();
    }

    private void configurarBotones() {
        mainView.addModifyPersonajeButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!mainView.getIdModificar().isEmpty()) {
                    abrirDialogo();
                } else {
                    JOptionPane.showMessageDialog(mainView, "Introduce un ID válido para modificar");
                }
            }
        });
    }

    private void abrirDialogo() {
        int id;
        try {
            id = Integer.parseInt(mainView.getIdModificar());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(mainView, "ID inválido");
            return;
        }
        Personajes personajes = leerPersonaje();
        Personaje p = null;
      
        for (int i = 0; i < personajes.getSize(); i++) {
            if (personajes.getPersonaje(i).getId() == id) {
                p = personajes.getPersonaje(i);
                break;
            }
        }

        if (p == null) {
            JOptionPane.showMessageDialog(mainView, "No existe ese personaje");
            return;
        }

        final Personaje pFinal = p;
        

        ModificacionPersonajeDialog dialog = new ModificacionPersonajeDialog(null, true);

        dialog.setPersonajeData(String.valueOf(p.getId()),p.getName(),p.getStatus(),p.getSpecie(),p.getType(),p.getGender(), p.getOrigin().getName(), p.getLocation().getName());

        dialog.addModifyPersonajeAcceptButtonListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ev) {
            JTextField[] fields = dialog.getTextFieldsArray();
            pFinal.setName(fields[0].getText());
            pFinal.setStatus(fields[1].getText());
            pFinal.setSpecie(fields[2].getText());
            pFinal.setType(fields[3].getText());
            pFinal.setGender(fields[4].getText());
            pFinal.getOrigin().setName(fields[5].getText());
            pFinal.getLocation().setName(fields[6].getText());
            personajes.addPersonaje(pFinal);
            try {
                actualizarArchivo(personajes);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(dialog, "Error al guardar cambios");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ModificacionPersonajeController.class.getName()).log(Level.SEVERE, null, ex);
            }

            dialog.dispose();
            JOptionPane.showMessageDialog(mainView, "Personaje modificado correctamente");
        }
    });
    dialog.setVisible(true);
    }

    private void guardarPersonajes(Personajes model) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Personajes/MisPersonajes_" + user.getUsuario() + ".dat"))) {
            oos.writeObject(model.getPersonajes());
        }
    }
    
    public void actualizarArchivo(Personajes model) throws IOException, ClassNotFoundException {
        File file = new File("Personajes/MisPersonajes_" + user.getUsuario() + ".dat");
        if(!file.exists()){
            guardarPersonajes(model);
        }else{
            file.delete();
           guardarPersonajes(model); 
        }

    }
    
    private Personajes leerPersonaje() {
        String fichero = "Personajes/MisPersonajes_" + user.getUsuario() + ".dat";
        File file = new File(fichero);

        if (!file.exists()) {
            return new Personajes();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (Personajes) ois.readObject();
        } catch (Exception ex) {
            return new Personajes();
        }
    }
}