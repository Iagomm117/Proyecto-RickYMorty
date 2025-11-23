package controller.usuarios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.UtilidadesUsuarios;
import model.Personajes;
import model.usuarios.Usuario;
import model.usuarios.Usuarios;
import view.usuarios.LoginFrame;
import view.usuarios.RegisterFrame;

/**
 *
 * @author dam2_alu08@inf.ald
 */
public class RegisterFrameController {

    private final RegisterFrame view;
    private final Personajes model;
    private Usuarios users;

    public RegisterFrameController(RegisterFrame view, Personajes model, Usuarios users) {
        this.view = view;
        this.model = model;
        this.users = users;
        this.view.addLoginButtonActionListener(this.getLoginButtonActionListener());
        this.view.addRegisterButtonActionListener(this.getRegisterButtonActionListener());
    }

    private ActionListener getLoginButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                LoginFrame lf = new LoginFrame();
                LoginFrameController lfc = new LoginFrameController(lf, model, users);
                view.setVisible(false);
                lf.setVisible(true);
            }
        };
        try {
            users = UtilidadesUsuarios.existeArchivo();
        } catch (IOException ex) {
            Logger.getLogger(RegisterFrameController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegisterFrameController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return al;
    }

    private ActionListener getRegisterButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (users.getSize() > 0) {
                    try{
                        for (Usuario u : users.getUsuarios()) {
                        if (u.getUsuario().equals(view.getTextNombreTextField())) {
                            view.setTextMensajeLabel("El usuario ya existe");
                            break;
                        } else {
                            users.addUsuario(new Usuario(view.getTextNombreTextField(), view.getTextPasswordField()));
                            view.statusNombreTextField(false);
                            view.statusPasswordField(false);
                            view.setTextMensajeLabel("El usuario se creo correctamente");
                            try {
                                UtilidadesUsuarios.actualizarArchivo(users);
                            } catch (IOException | ClassNotFoundException ex) {
                                Logger.getLogger(RegisterFrameController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        }
                    }catch(Exception ex){
                            
                    } 
                } else {
                    users.addUsuario(new Usuario(view.getTextNombreTextField(), view.getTextPasswordField()));
                    view.statusNombreTextField(false);
                    view.statusPasswordField(false);
                    view.setTextMensajeLabel("El usuario se creo correctamente");
                    try {
                        UtilidadesUsuarios.actualizarArchivo(users);
                    } catch (IOException ex) {
                        Logger.getLogger(RegisterFrameController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(RegisterFrameController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        };

        return al;
    }

}
