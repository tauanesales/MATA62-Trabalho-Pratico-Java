public class ReservaBancoDeDados implements IReservaBancoDeDados {
    private BancoDeDados bancoDeDados;

    public ReservaBancoDeDados(BancoDeDados bancoDeDados) {
        this.bancoDeDados = bancoDeDados;
    }

    @Override
    public List<Reserva> getReservasPorCodigoUsuario(boolean b, int codigoUsuario) {
        return this.bancoDeDados.getAll(Reserva.class)
                .stream()
                .filter(reserva -> reserva.getUsuario().getCodigo() == codigoUsuario)
                .filter(reserva -> !b || reserva.reservaEstaAtiva())
                .collect(Collectors.toList());
    }

    @Override
    public Reserva getReservaAtiva(int codigoLivro, int codigoUsuario) {
        return this.bancoDeDados.getAll(Reserva.class)
                .stream()
                .filter(reserva -> reserva.getUsuario().getCodigo() == codigoUsuario)
                .filter(reserva -> reserva.getLivro().getCodigo() == codigoLivro)
                .filter(reserva -> reserva.reservaEstaAtiva())
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Reserva> getReservasPorCodigoLivro(boolean reservaAtiva, int codigoLivro) {
        return this.bancoDeDados.getAll(Reserva.class)
                .stream()
                .filter(reserva -> reserva.getLivro().getCodigo() == codigoLivro)
                .filter(reserva -> !reservaAtiva || reserva.reservaEstaAtiva())
                .collect(Collectors.toList());
          }
