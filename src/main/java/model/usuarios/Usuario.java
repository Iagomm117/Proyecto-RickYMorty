package model.usuarios;

import java.io.Serializable;

/**
 *
 * @author dam2_alu08@inf.ald
 */
public class Usuario implements Serializable {
    private String usuario;
    private String contrasenha;

    public Usuario(String usuario, String contrasenha) {
        this.usuario = usuario;
        this.contrasenha = contrasenha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }
    
    
          
}
