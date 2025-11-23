package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import model.usuarios.Usuario;
import model.usuarios.Usuarios;

/**
 *
 * @author dam2_alu08@inf.ald
 */
public class UtilidadesUsuarios {

    private static final Usuarios usuarios = new Usuarios();

    public static void generarArchivo(Usuarios usuarios) throws IOException {
        FileOutputStream arquivo = new FileOutputStream("usuarios.dat");
        ObjectOutputStream saida = new ObjectOutputStream(arquivo);
        saida.writeObject(usuarios);

    }

    public static void leerArchivo() throws IOException, ClassNotFoundException {
        FileInputStream arquivo = new FileInputStream("usuarios.dat");
        ObjectInputStream entrada = new ObjectInputStream(arquivo);
        Usuarios usuario = (Usuarios) entrada.readObject();
        for(Usuario u : usuario.getUsuarios()){
            usuarios.addUsuario(u);
            System.out.println(u.getUsuario());
        }
    }

    public static void actualizarArchivo(Usuarios usuarios) throws IOException, ClassNotFoundException {
        File file = new File("usuarios.dat");
        if(!file.exists()){
            generarArchivo(usuarios);
        }else{
            file.delete();
           generarArchivo(usuarios); 
        }

    }
    
    public static Usuarios existeArchivo() throws IOException, ClassNotFoundException {
        File file = new File("usuarios.dat");
        if(file.exists()) {
            leerArchivo();
            System.out.println(usuarios.getSize());
            return usuarios;
        } else {
            System.out.println("Se requiere crear un usuario");
        }
        return usuarios;
    }

}
