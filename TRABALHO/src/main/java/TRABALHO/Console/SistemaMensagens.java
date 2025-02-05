package TRABALHO.Console;

import TRABALHO.BancoDeDados.IBancoDeDados;
import TRABALHO.Emprestimo.Emprestimo;
import TRABALHO.Livros.Livro.ILivro;
import TRABALHO.Livros.Livro.Livro;
import TRABALHO.Usuarios.IUsuario;

public class Mensagens {

    public static void mensagemAjuda() {
        MensagensAjuda.mensagemAjuda();
    }

    public static void mensagemDeErro(String mensagem, String motivo, IUsuario usuario, ILivro livro) {
        MensagensErro.mensagemDeErro(mensagem, motivo, usuario, livro);
    }

    public static void mensagemSucessoBase(String mensagem, IUsuario usuario, ILivro livro) {
        MensagensSucesso.mensagemSucessoBase(mensagem, usuario, livro);
    }

    public static void mensagemSucessoBase(String mensagem, IUsuario usuario, ILivro livro, Emprestimo emprestimo) {
        MensagensSucesso.mensagemSucessoBase(mensagem, usuario, livro, emprestimo);
    }

    public static void limparTela() {
        LimpezaTela.limparTela();
    }

    public static void mostrarTodosOsDadosDoBanco(IBancoDeDados db) {
        ExibicaoDados.mostrarTodosOsDadosDoBanco(db);
    }

    public static void mostrarNotificacoesDoUsuario(IUsuario usuario) {
        ExibicaoDados.mostrarNotificacoesDoUsuario(usuario);
    }

    public static void mostrarDadosDoUsuario(IUsuario usuario) {
        ExibicaoDados.mostrarDadosDoUsuario(usuario);
    }

    public static void mostrarDadosDoLivro(Livro livro, IBancoDeDados db) {
        ExibicaoDados.mostrarDadosDoLivro(livro, db);
    }
}
