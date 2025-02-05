public interface ILivroBancoDeDados {
    Livro getLivro(int codigoLivro);
    boolean livroExiste(int codigoLivro);
    List<Exemplar> getExemplares(int codigoLivro);
    List<Exemplar> getExemplaresDisponiveis(int codigoLivro);
    Exemplar getExemplar(int codigoExemplar, int codigoLivro);
    Exemplar getExemplarDisponivelPorCodigoLivro(int codigoLivro);
    Exemplar getExemplarEmprestado(int codigoLivro, int codigoUsuario);
    boolean temExemplarDisponivel(int codigoLivro);
}
