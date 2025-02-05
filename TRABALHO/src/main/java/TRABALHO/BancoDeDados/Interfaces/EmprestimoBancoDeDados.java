public class EmprestimoBancoDeDados implements IEmprestimoBancoDeDados {
    private BancoDeDados bancoDeDados;

    public EmprestimoBancoDeDados(BancoDeDados bancoDeDados) {
        this.bancoDeDados = bancoDeDados;
    }

    @Override
    public List<Emprestimo> getEmprestimos(boolean apenasEmAberto, int codigoUsuario) {
        return this.bancoDeDados.getAll(Emprestimo.class)
                .stream()
                .filter(emprestimo -> emprestimo.getUsuario().getCodigo() == codigoUsuario)
                .filter(emprestimo -> !apenasEmAberto || !emprestimo.isDevolvido())
                .collect(Collectors.toList());
    }
}
