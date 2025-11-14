package model.usuarios;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author dam2_alu08@inf.ald
 */
public class Usuarios implements Serializable{
    private List<Usuario> usuarios;

    public Usuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
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
    
     public Usuario getPersonaje(int n) {
        return (Usuario) this.usuarios.get(n);
    }
}
