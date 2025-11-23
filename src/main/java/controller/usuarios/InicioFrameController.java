package controller.usuarios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Personajes;
import model.usuarios.Usuarios;
import view.usuarios.InicioFrame;
import view.usuarios.LoginFrame;
import view.usuarios.RegisterFrame;

/**
 *
 * @author dam2_alu08@inf.ald
 */
public class InicioFrameController {
    private final InicioFrame view;
    private final Personajes model;
    private final Usuarios users;

    public InicioFrameController(InicioFrame view, Personajes model, Usuarios users) {
        this.view = view;
        this.model = model;
        this.users = users;
        this.view.addLoginButtonActionListener(this.getLoginButtonActionListener());
        this.view.addRegisterButtonActionListener(this.getRegisterButtonActionListener());
    }
    
    private ActionListener getLoginButtonActionListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                LoginFrame lf = new LoginFrame();
                LoginFrameController lfc = new LoginFrameController(lf,model,users);
                view.setVisible(false);
                lf.setVisible(true);
            }
        };
        return al;
    }
    
    private ActionListener getRegisterButtonActionListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                RegisterFrame rf = new RegisterFrame();
                RegisterFrameController rfc = new RegisterFrameController(rf,model,users);
                view.setVisible(false);
                rf.setVisible(true);
                
            }
        };
        return al;
    }
    
}
