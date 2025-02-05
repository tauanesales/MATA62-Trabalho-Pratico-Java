package TRABALHO.SistemaBiblioteca;

import TRABALHO.BancoDeDados.IBancoDeDados;
import TRABALHO.Livros.Livro.ILivroObservavel;
import TRABALHO.Reserva.Reserva;
import TRABALHO.Usuarios.IUsuario;

public class GerenciadorDeReservas {
    private IBancoDeDados db;

    public GerenciadorDeReservas(IBancoDeDados db) {
        this.db = db;
    }

    public void realizarReserva(int codigoUsuario, int codigoLivro) {
        try {
            ValidacaoReservas.validarPodeReservarExemplar(codigoUsuario, codigoLivro, db);
        } catch (SistemaBibliotecaException e) {
            Mensagens.MensagemDeErro("Não foi possível realizar a reserva.", e.getMessage(), db.getUsuario(codigoUsuario), db.getLivro(codigoLivro));
            return;
        }

        IUsuario usuario = db.getUsuario(codigoUsuario);
        ILivroObservavel livro = db.getLivro(codigoLivro);

        Reserva reserva = new Reserva(usuario, livro);
        db.insert(reserva);

        Mensagens.MensagemSucessoBase("Reserva realizada com sucesso!", usuario, livro);
    }

    public void observarReservasDeLivro(int codigoLivro, int codigoObservador) {
        try {
            ValidacaoObserver.validarPodeSeTornarObservador(codigoObservador, codigoLivro, db);
        } catch (SistemaBibliotecaException e) {
            Mensagens.MensagemDeErro("Não é possível se tornar observador.", e.getMessage(), db.getUsuario(codigoObservador), db.getLivro(codigoLivro));
            return;
        }

        IUsuario usuario = db.getUsuario(codigoObservador);
        ILivroObservavel livro = db.getLivro(codigoLivro);

        livro.adicionarObservador(usuario);

        Mensagens.MensagemSucessoBase("Sucesso: usuário se tornou observador.", usuario, livro);
    }
}
