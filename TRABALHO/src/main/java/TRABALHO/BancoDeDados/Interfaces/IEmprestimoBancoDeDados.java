public interface IEmprestimoBancoDeDados {
    List<Emprestimo> getEmprestimos(boolean apenasEmAberto, int codigoUsuario);
}
