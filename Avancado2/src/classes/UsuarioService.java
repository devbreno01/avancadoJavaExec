package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

public class UsuarioService {
    private List<Usuario> usuarios = new ArrayList<>();

    public void adicionarUsuario(Usuario usuario) throws IllegalArgumentException {
        validarUsuario(usuario);
        usuarios.add(usuario);
    }

    public List<Usuario> buscarUsuariosPorNome(String regex) {
        List<Usuario> resultados = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        for (Usuario usuario : usuarios) {
            if (pattern.matcher(usuario.getNome()).find()) {
                resultados.add(usuario);
            }
        }
        return resultados;
    }

    public Optional<Usuario> buscarUsuarioPorEmail(String email) {
        return usuarios.stream()
                .filter(usuario -> usuario.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }

    private void validarUsuario(Usuario usuario) {
        if (usuario.getNome() == null || usuario.getNome().isEmpty()) {
            throw new IllegalArgumentException("Nome inválido!");
        }
        if (!usuario.getEmail().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            throw new IllegalArgumentException("Email inválido!");
        }
        if (usuario.getIdade() <= 0) {
            throw new IllegalArgumentException("Idade inválida!");
        }
    }
}
