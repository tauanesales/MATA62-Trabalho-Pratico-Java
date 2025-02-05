public class BancoDeDados implements IBancoDeDados {
    private static BancoDeDados instance;
    private HashMap<Class<? extends IEntidadeBiblioteca>, List<IEntidadeBiblioteca>> tables;

    private BancoDeDados() {
        initializeDatabase();
    }

    public static BancoDeDados getInstance() {
        if (instance == null) {
            instance = new BancoDeDados();
        }
        return instance;
    }

    @Override
    public void reset() {
        clearDatabase();
        System.gc();
        initializeDatabase();
    }

    private void clearDatabase() {
        tables = null;
    }

    private void initializeDatabase() {
        tables = new HashMap<Class<? extends IEntidadeBiblioteca>, List<IEntidadeBiblioteca>>();
    }

    @Override
    public boolean insert(IEntidadeBiblioteca object) {
        return tables
                .computeIfAbsent(object.getClass(), key -> new ArrayList<>())
                .add(object);
    }

    @Override
    public <T extends IEntidadeBiblioteca> List<T> getAll(Class<T> entityType) {
        return tables.keySet()
                .stream()
                .filter(key -> entityType.isAssignableFrom(key))
                .map(tables::get)
                .flatMap(List::stream)
                .map(entityType::cast)
                .collect(Collectors.toList());
    }

    @Override
    public <T extends IEntidadeBiblioteca> T getFirstById(Class<T> tabela, int id) {
        return this.getAll(tabela)
                .stream()
                .filter(entidade -> entidade.getCodigo() == id)
                .map(tabela::cast) // Cast the result to the specific type
                .findFirst()
                .orElse(null);
    }

    @Override
    public IEntidadeBiblioteca[] getAllById(Class<? extends IEntidadeBiblioteca> tabela, int id) {
        return this.getAll(tabela)
                .stream()
                .filter(entidade -> entidade.getCodigo() == id)
                .toArray(IEntidadeBiblioteca[]::new);
    }
}
