public class UsuarioBancoDeDados implements IUsuarioBancoDeDados {
    private BancoDeDados bancoDeDados;

    public UsuarioBancoDeDados(BancoDeDados bancoDeDados) {
        this.bancoDeDados = bancoDeDados;
    }

    @Override
    public IUsuario getUsuario(int codigoUsuario) {
        return this.bancoDeDados.getFirstById(IUsuario.class, codigoUsuario);
    }
}
