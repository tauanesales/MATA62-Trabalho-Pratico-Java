public interface IBancoDeDados {
    void reset();
    boolean insert(IEntidadeBiblioteca object);
    <T extends IEntidadeBiblioteca> List<T> getAll(Class<T> entityType);
    <T extends IEntidadeBiblioteca> T getFirstById(Class<T> tabela, int id);
    IEntidadeBiblioteca[] getAllById(Class<? extends IEntidadeBiblioteca> tabela, int id);
}
