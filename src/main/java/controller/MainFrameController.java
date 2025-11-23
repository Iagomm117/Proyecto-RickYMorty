/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.ModificarPersonaje.ModificacionPersonajeController;
import controller.personaje.PersonajeFrameController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.swing.JOptionPane;
import model.Personaje;
import model.Personajes;
import model.usuarios.Usuario;
import view.MainFrame;
import view.personaje.PersonajeDialog;

/**
 *
 * @author dam2_alu08@inf.ald
 */
public class MainFrameController {

    private final MainFrame view;
    private final Personajes model;
    private final Usuario user;

    public MainFrameController(MainFrame view, Personajes model, Usuario user) {
        this.view = view;
        this.model = model;
        this.user = user;
        this.view.addPersonajeButtonActionListener(this.getPersonajeButtonActionListener());
        this.view.addMisPersonajesListener(this.addMisPersonajesActionListener());
    }

    private ActionListener getPersonajeButtonActionListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    PersonajeDialog pd = new PersonajeDialog(view, true);
                    pd.statusDeletePersonajeButton(false);
                    pd.statusModifyPersonajeButton(false);
                    pd.statusIdEliminar(false);
                    pd.statusIdModificar(false);
                    pd.statusAddPersonajeButton(true);
                    PersonajeFrameController pc = new PersonajeFrameController(pd, model, user);
                    pd.setVisible(true);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(view, "Error al abrir el diálogo");
                }
            }
        };
    }

    private ActionListener addMisPersonajesActionListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    File file = new File("Personajes/MisPersonajes_" + user.getUsuario() + ".dat");
                    if (!file.exists()) {
                        JOptionPane.showMessageDialog(view, "No existe el archivo");
                    } else {
                        PersonajeDialog pd = new PersonajeDialog(view, true);
                        Personajes lista = leerArchivo();
                        pd.statusDeletePersonajeButton(true);
                        pd.statusModifyPersonajeButton(true);
                        pd.statusIdEliminar(true);
                        pd.statusIdModificar(true);
                        pd.statusAddPersonajeButton(false);

                        pd.addModifyPersonajeButtonListener(e -> {
                            String id = pd.getIdModificar();
                            if (id.isEmpty()) {
                                JOptionPane.showMessageDialog(pd, "Introduce un ID");
                                return;
                            }
                            int id2;
                            try {
                                id2 = Integer.parseInt(id);
                            } catch (NumberFormatException ex) {
                                JOptionPane.showMessageDialog(pd, "ID inválido");
                                return;
                            }
                           ModificacionPersonajeController mpc = new ModificacionPersonajeController(pd, model,user); 
                            
                        });
                        PersonajeFrameController pc = new PersonajeFrameController(pd, lista, user);
                        pd.setVisible(true);

                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(view, "Error al leer el archivo");
                }
            }
        };
    }

    public Personajes leerArchivo() {
        Personajes lista = null;
        File file = new File("Personajes/MisPersonajes_" + user.getUsuario() + ".dat");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            lista = (Personajes) ois.readObject();
            for (Personaje p : lista.getPersonajes()) {
                System.out.println(p);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}
