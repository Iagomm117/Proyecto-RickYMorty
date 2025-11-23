package controller.personaje;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;
import model.Personaje;
import model.Personajes;
import model.usuarios.Usuario;
import view.personaje.PersonajeDialog;

/**
 *
 * @author dam2_alu08@inf.ald
 */
public class PersonajeFrameController {

    private final PersonajeDialog view;
    private static Personajes model;
    private static Usuario user;

    public PersonajeFrameController(PersonajeDialog view, Personajes model, Usuario user) throws IOException {
        this.view = view;
        this.model = model;
        this.user = user;
        this.initItemsComboBox();
        this.view.addIdComboBoxActionListener(this.getIdComboBoxActionListener());
        this.view.addPersonajesListener(this.getAddPersonajesActionListene());
        //this.view.addDeletePersonajeButtonListener(this.getEliminarPersonajeActionListener()); No funciona como corresponde
    }

    private void initItemsComboBox() throws IOException {
        System.out.println(model.getSize());
        for (int i = 0; i < model.getSize(); i++) {
            view.addItemIdComboBox(Integer.toString(model.getPersonaje(i).getId()));
            mostrarDatos();
        }
    }

    private void mostrarDatos() throws IOException {
        int id = Integer.parseInt(view.getItemIdComboBox()) - 1;
        this.view.setIconImageLabel(model.getPersonaje(id).getImage());
        this.view.setTextNameLabel(model.getPersonaje(id).getName());
        this.view.setTextStatusLabel(model.getPersonaje(id).getStatus());
        this.view.setTextSpeciesLabel(model.getPersonaje(id).getSpecie());
        this.view.setTextTypeLabel(model.getPersonaje(id).getType());
        this.view.setTextGenderLabel(model.getPersonaje(id).getGender());
        this.view.setTextOriginLabel(model.getPersonaje(id).getOrigin().getName());
        this.view.setTextLocationLabel(model.getPersonaje(id).getLocation().getName());
    }

    private ActionListener getIdComboBoxActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int id = Integer.parseInt(view.getItemIdComboBox());
                for (int i = 0; i < model.getSize(); i++) {
                    if (id == model.getPersonaje(i).getId()) {
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

    private ActionListener getAddPersonajesActionListene() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    anhadirPersonajeArchivo();
                } catch (IOException ex) {
                }
            }
        };
        return al;
    }

    private Personaje personajeActual() {
        int id = Integer.parseInt(view.getItemIdComboBox()) - 1;
        return model.getPersonaje(id);
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

    private void guardarPersonajes(Personajes lista) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Personajes/MisPersonajes_" + user.getUsuario() + ".dat"))) {
            oos.writeObject(lista);
        }
    }

    private void anhadirPersonajeArchivo() throws IOException {
        Personajes lista = leerPersonaje();
        Personaje personaje = personajeActual();
        personaje.setId(lista.getSize() + 1);
        boolean existe = false;
        for (int i = 0; i < lista.getSize(); i++) {
            if (personaje.getId() == i) {
                existe = true;
            }
        }
        if (existe) {
            JOptionPane.showMessageDialog(null, "Este personaje ya lo tienes añadido", "Duplicado", JOptionPane.WARNING_MESSAGE);
            return;
        }
        lista.addPersonaje(personaje);
        guardarPersonajes(lista);
        JOptionPane.showMessageDialog(null, "Personaje añadido correctamente");
    }
    /*
    private void eliminarPersonajeArchivo(int idAEliminar) throws IOException {
        Personajes lista = leerPersonaje();
        boolean buscarId = false;
        Personajes nuevaLista = new Personajes();
        for (Personaje personaje : lista.getPersonajes()) {
            if (personaje.getId() == idAEliminar) {
                buscarId = true;
            } else {
                nuevaLista.addPersonaje(personaje);
            }
        }
        if (!buscarId) {
            JOptionPane.showMessageDialog(null, "No tienes ese personaje en el archivo", "No encontrado", JOptionPane.WARNING_MESSAGE);
            return;
        }
        guardarPersonajes(nuevaLista);
        JOptionPane.showMessageDialog(null, "Personaje eliminado correctamente");
    }
    
    

    private ActionListener getEliminarPersonajeActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int idEliminar = Integer.parseInt(view.getIdEliminar());
                    eliminarPersonajeArchivo(idEliminar);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID inválido", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error al eliminar", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        };
        return al;
    } Funcionalidad sin acabar de implementra */
}
