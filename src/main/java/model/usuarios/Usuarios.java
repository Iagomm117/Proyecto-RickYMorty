package model.usuarios;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dam2_alu08@inf.ald
 */
public class Usuarios implements Serializable{
    private List<Usuario> usuarios;

    public Usuarios() {
        this.usuarios = new ArrayList();
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
        
    }
    
    public void addUsuario(Usuario usuario){
        this.usuarios.add(usuario);
    }
    
    public int getSize() {
        return this.usuarios.size();
    }
    
     public Usuario getUsuario(int n) {
        return (Usuario) this.usuarios.get(n);
    }
     
}
