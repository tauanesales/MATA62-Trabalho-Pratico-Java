package TRABALHO.Console;

import java.text.SimpleDateFormat;
import java.util.Date;
import TRABALHO.Emprestimo.Emprestimo;
import TRABALHO.Livros.Livro.ILivro;
import TRABALHO.Usuarios.IUsuario;

public class MensagensSucesso {
    private static String delimiter = "\n";
    private static String dash = "------------------------------------------------------------";

    public static void mensagemSucessoBase(String mensagem, IUsuario usuario, ILivro livro) {
        String alert = String.join(delimiter,
                delimiter == "\n" ? dash : "",
                mensagem,
                "Usuário: " + (usuario != null ? usuario.getNome() : "N/A"),
                "Livro: " + (livro != null ? livro.getTitulo() : "N/A"),
                delimiter == "\n" ? dash : "");
        System.out.println(alert);
    }

    public static void mensagemSucessoBase(String mensagem, IUsuario usuario, ILivro livro, Emprestimo emprestimo) {
        String alert = String.join(delimiter,
                delimiter == "\n" ? dash : "",
                mensagem,
                "Usuário: " + (usuario != null ? usuario.getNome() : "N/A"),
                "Livro: " + (livro != null ? livro.getTitulo() : "N/A"),
                "Devolução até: " + (new SimpleDateFormat("dd/MM/yyyy")).format(emprestimo.getDataDevolucao()));

        if (emprestimo.isDevolvido()) {
            alert += delimiter + "Devolvido em: " + (new SimpleDateFormat("dd/MM/yyyy")).format(new Date());
        }
        alert += delimiter + (delimiter == "\n" ? dash : "");
        System.out.println(alert);
    }
}
