package controller.usuarios;

import controller.MainFrameController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Personajes;
import model.usuarios.Usuario;
import model.usuarios.Usuarios;
import view.MainFrame;
import view.usuarios.LoginFrame;
import view.usuarios.RegisterFrame;

/**
 *
 * @author dam2_alu08@inf.ald
 */
public class LoginFrameController {

    private final LoginFrame view;
    private final Personajes model;
    private final Usuarios users;

    public LoginFrameController(LoginFrame view, Personajes model, Usuarios users) {
        this.view = view;
        this.model = model;
        this.users = users;
        this.view.addRegisterButtonActionListener(this.getRegisterButtonActionListener());
        this.view.addLoginButtonActionListener(this.getLoginButtonActionListener());
    }

    private ActionListener getRegisterButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                RegisterFrame rf = new RegisterFrame();
                RegisterFrameController rfc = new RegisterFrameController(rf, model, users);
                view.setVisible(false);
                rf.setVisible(true);
            }
        };
        return al;
    }

    private ActionListener getLoginButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (users.getSize() > 0) {
                    for (Usuario u : users.getUsuarios()) {
                        if (u.getUsuario().trim().equals(view.getTextNombreTextField().trim()) && u.getContrasenha().trim().equals(view.getTextPasswordField())) {
                            MainFrame mf = new MainFrame();
                            MainFrameController mfc = new MainFrameController(mf, model,u);
                            view.setVisible(false);
                            mf.setVisible(true);
                        } else {
                            view.setTextMensajeLabel("Contrasenha o usuario incorrecto");
                        }
                    }
                }
            }
        };
        return al;
    }
}
