public class LivroBancoDeDados implements ILivroBancoDeDados {
    private BancoDeDados bancoDeDados;

    public LivroBancoDeDados(BancoDeDados bancoDeDados) {
        this.bancoDeDados = bancoDeDados;
    }

    @Override
    public Livro getLivro(int codigoLivro) {
        return this.bancoDeDados.getFirstById(Livro.class, codigoLivro);
    }

    @Override
    public boolean livroExiste(int codigoLivro) {
        return this.bancoDeDados.getAll(Livro.class)
                .stream()
                .filter(livro -> livro.getCodigo() == codigoLivro)
                .findFirst()
                .isPresent();
    }

    @Override
    public List<Exemplar> getExemplares(int codigoLivro) {
        return this.bancoDeDados.getAll(Exemplar.class)
                .stream()
                .filter(exemplar -> exemplar.getCodigoLivro() == codigoLivro)
                .collect(Collectors.toList());
    }

    @Override
    public List<Exemplar> getExemplaresDisponiveis(int codigoLivro) {
        return this.getExemplares(codigoLivro)
                .stream()
                .filter(exemplar -> exemplar.isDisponivel())
                .collect(Collectors.toList());
    }

    @Override
    public Exemplar getExemplar(int codigoExemplar, int codigoLivro) {
        return this.bancoDeDados.getAll(Exemplar.class)
                .stream()
                .filter(exemplar -> exemplar.getCodigoLivro() == codigoLivro)
                .filter(exemplar -> exemplar.getCodigo() == codigoExemplar)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Exemplar getExemplarDisponivelPorCodigoLivro(int codigoLivro) {
        return this.bancoDeDados.getAll(Exemplar.class)
                .stream()
                .filter(exemplar -> exemplar.getCodigoLivro() == codigoLivro)
                .filter(exemplar -> exemplar.isDisponivel())
                .findFirst()
                .orElse(null);
    }

    @Override
    public Exemplar getExemplarEmprestado(int codigoLivro, int codigoUsuario) {
        return this.bancoDeDados.getAll(Exemplar.class)
                .stream()
                .filter(exemplar -> exemplar.getCodigoLivro() == codigoLivro)
                .filter(exemplar -> !exemplar.isDisponivel())
                .filter(exemplar -> exemplar.getMutuario().getCodigo() == codigoUsuario)
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean temExemplarDisponivel(int codigoLivro) {
        return this.bancoDeDados.getAll(Exemplar.class)
                .stream()
                .anyMatch(exemplar -> exemplar.getCodigoLivro() == codigoLivro &&
                        exemplar.isDisponivel());
    }
}
