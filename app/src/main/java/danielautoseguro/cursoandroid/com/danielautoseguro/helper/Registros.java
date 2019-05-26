package danielautoseguro.cursoandroid.com.danielautoseguro.helper;

import java.util.ArrayList;
import java.util.List;

import danielautoseguro.cursoandroid.com.danielautoseguro.data.Usuario;

public class Registros {

    private static List<Usuario> usuarios = new ArrayList();

    public static void cadastrarUsuario(Usuario novoUsuario) {
        usuarios.add(novoUsuario);
    }

    public static boolean verificarUsuario(String email, String senha) {
        for(int i = 0; i < usuarios.size(); i++) {
            Usuario usuario = usuarios.get(i);
            if(usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)){
                return true;
            }
        }
        return false;
    }

}
