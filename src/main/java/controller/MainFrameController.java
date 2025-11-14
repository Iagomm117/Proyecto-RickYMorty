/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.personaje.PersonajeFrameController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import model.Personajes;
import view.MainFrame;
import view.personaje.PersonajeDialog;

/**
 *
 * @author dam2_alu08@inf.ald
 */
public class MainFrameController {

    private final MainFrame view;
    private final Personajes model;

    public MainFrameController(MainFrame view, Personajes model) {
        this.view = view;
        this.model = model;
        this.view.addPersonajeButtonActionListener(this.getPersonajeButtonActionListener());
    }

    private ActionListener getPersonajeButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    PersonajeDialog pd = new PersonajeDialog(view, true);
                    PersonajeFrameController pc = new PersonajeFrameController(pd, model);
                    
                    pd.setVisible(true);
                } catch (IOException ex) {
                }
            }
        };
        return al;
    }
}
