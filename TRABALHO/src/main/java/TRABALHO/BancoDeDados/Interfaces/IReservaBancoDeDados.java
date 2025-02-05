public interface IReservaBancoDeDados {
    List<Reserva> getReservasPorCodigoUsuario(boolean b, int codigoUsuario);
    Reserva getReservaAtiva(int codigoLivro, int codigoUsuario);
    List<Reserva> getReservasPorCodigoLivro(boolean reservaAtiva, int codigoLivro);
}
