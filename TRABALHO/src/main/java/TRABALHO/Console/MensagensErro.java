package TRABALHO.Console;

import TRABALHO.Usuarios.IUsuario;
import TRABALHO.Livros.Livro.ILivro;

public class MensagensErro {
    private static String delimiter = "\n";
    private static String dash = "------------------------------------------------------------";

    public static void mensagemDeErro(String mensagem, String motivo, IUsuario usuario, ILivro livro) {
        String alert = String.join(delimiter,
                delimiter == "\n" ? dash : "",
                mensagem,
                "Motivo: " + motivo,
                "Usuário: " + (usuario != null ? usuario.getNome() : "N/A"),
                "Livro: " + (livro != null ? livro.getTitulo() : "N/A"),
                delimiter == "\n" ? dash : "");
        System.out.println(alert);
    }
}
