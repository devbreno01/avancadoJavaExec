import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import classes.UsuarioService;
import classes.Usuario;
public class Main {
    public static void main(String[] args) {
        UsuarioService usuarioService = new UsuarioService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Cadastrar usuário");
            System.out.println("2. Buscar usuário por nome");
            System.out.println("3. Buscar usuário por email");
            System.out.println("4. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                System.out.println("Digite o ID:");
                int id = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Digite o nome:");
                String nome = scanner.nextLine();

                System.out.println("Digite o email:");
                String email = scanner.nextLine();

                System.out.println("Digite a idade:");
                int idade = scanner.nextInt();

                Usuario usuario = new Usuario(id, nome, email, idade);
                try {
                    usuarioService.adicionarUsuario(usuario);
                    System.out.println("Usuário adicionado com sucesso!");
                } catch (IllegalArgumentException e) {
                    System.out.println("Erro: " + e.getMessage());
                }

            } else if (opcao == 2) {
                System.out.println("Digite o padrão de nome (regex):");
                String regex = scanner.nextLine();
                List<Usuario> resultados = usuarioService.buscarUsuariosPorNome(regex);

                if (resultados.isEmpty()) {
                    System.out.println("Nenhum usuário encontrado.");
                } else {
                    for (Usuario usuario : resultados) {
                        System.out.println(usuario);
                    }
                }

            } else if (opcao == 3) {
                System.out.println("Digite o email:");
                String email = scanner.nextLine();
                Optional<Usuario> usuario = usuarioService.buscarUsuarioPorEmail(email);

                usuario.ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Usuário não encontrado.")
                );

            } else if (opcao == 4) {
                break;
            }


            class MenuExit {
                public void sair() {
                    System.out.println("Sistema finalizado.");
                    System.exit(0);
                }
            }

            MenuExit menuExit = new MenuExit();
            if (opcao == 4) {
                menuExit.sair();
            }
        }

        
        Runnable action = new Runnable() {
            @Override
            public void run() {
                System.out.println("Ação extra sendo executada...");
            }
        };
        action.run();
    }
}
