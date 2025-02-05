package TRABALHO.SistemaBiblioteca;

import TRABALHO.BancoDeDados.IBancoDeDados;
import TRABALHO.Livros.Livro.ILivroObservavel;
import TRABALHO.Usuarios.IUsuario;

public class GerenciadorDeExibicao {
    private IBancoDeDados db;

    public GerenciadorDeExibicao(IBancoDeDados db) {
        this.db = db;
    }

    public void mostrarTodosOsDadosDoBanco() {
        Mensagens.mostrarTodosOsDadosDoBanco(db);
    }
    
    public void mostrarDadosDoLivro(int codigoLivro) {
        Mensagens.mostrarDadosDoLivro(db.getLivro(codigoLivro), db);
    }

    public void mostrarDadosDoUsuario(int codigoUsuario) {
        Mensagens.mostrarDadosDoUsuario(db.getUsuario(codigoUsuario));
    }

    public void mostrarNotificacoesDoUsuario(int codigoUsuario) {
        Mensagens.mostrarNotificacoesDoUsuario(db.getUsuario(codigoUsuario));
    }
}
