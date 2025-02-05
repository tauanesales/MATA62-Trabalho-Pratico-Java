package TRABALHO.Console;

public class MensagensAjuda {
    private static String dash = "------------------------------------------------------------";

    public static void mensagemAjuda() {
        String alert = String.join("\n",
                dash,
                "Comandos disponíveis:",
                "emp <codigoUsuario> <codigoLivro> - Realiza um empréstimo",
                "dev <codigoUsuario> <codigoLivro> - Realiza uma devolução",
                "res <codigoUsuario> <codigoLivro> - Realiza uma reserva",
                "obs <codigoUsuario> <codigoLivro> - Observa as reservas de um livro",
                "usu <codigoUsuario> - Mostra os dados de um usuário",
                "liv <codigoLivro> - Mostra os dados de um livro",
                "ntf <codigoUsuario> - Mostra as notificações de um usuário",
                "all - Mostra todos os dados do banco de dados",
                "sai - Encerra o programa",
                dash);
        System.out.println(alert);
    }
}
