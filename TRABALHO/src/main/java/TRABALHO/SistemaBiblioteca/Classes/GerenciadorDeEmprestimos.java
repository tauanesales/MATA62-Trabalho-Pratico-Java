package TRABALHO.SistemaBiblioteca;

import TRABALHO.BancoDeDados.IBancoDeDados;
import TRABALHO.Emprestimo.Emprestimo;
import TRABALHO.Livros.Exemplar.Exemplar;
import TRABALHO.Livros.Exemplar.IExemplarEmprestavel;
import TRABALHO.Reserva.Reserva;
import TRABALHO.Usuarios.IUsuario;

public class GerenciadorDeEmprestimos {
    private IBancoDeDados db;

    public GerenciadorDeEmprestimos(IBancoDeDados db) {
        this.db = db;
    }

    public void realizarEmprestimo(int codigoUsuario, int codigoLivro) {
        try {
            ValidacaoEmprestimo.validarPodeEmprestarExemplarParaUsuario(codigoUsuario, codigoLivro, db);
        } catch (SistemaBibliotecaException e) {
            Mensagens.MensagemDeErro("Não foi possível realizar o empréstimo", e.getMessage(), db.getUsuario(codigoUsuario), db.getLivro(codigoLivro));
            return;
        }
        Exemplar exemplar = db.getExemplarDisponivelPorCodigoLivro(codigoLivro);
        exemplar.emprestar(codigoUsuario, db);

        Reserva reserva = db.getReservaAtiva(codigoLivro, codigoUsuario);
        if (reserva != null)
            reserva.removerReserva();

        Mensagens.MensagemSucessoBase("Empréstimo realizado com sucesso!", exemplar.getMutuario(), exemplar, exemplar.getEmprestimo());
    }

    public void realizarDevolucao(int codigoUsuario, int codigoLivro) {
        try {
            ValidacaoDevolucao.validarPodeDevolverExemplar(codigoUsuario, codigoLivro, db);
        } catch (ValidacaoBase.SistemaBibliotecaException e) {
            Mensagens.MensagemDeErro("Não foi possível realizar a devolução.", e.getMessage(), db.getUsuario(codigoUsuario), db.getLivro(codigoLivro));
            return;
        }

        IExemplarEmprestavel exemplar = db.getExemplarEmprestado(codigoLivro, codigoUsuario);

        Emprestimo emprestimo = exemplar.getEmprestimo();
        IUsuario usuario = exemplar.getMutuario();

        exemplar.devolver();

        Mensagens.MensagemSucessoBase("Devolução realizada com sucesso!", usuario, exemplar, emprestimo);
    }
}
