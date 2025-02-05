package TRABALHO.Console;

import TRABALHO.BancoDeDados.IBancoDeDados;
import TRABALHO.Livros.Livro.Livro;
import TRABALHO.Usuarios.IUsuario;

public class ExibicaoDados {
    private static String dash = "------------------------------------------------------------";

    public static void mostrarTodosOsDadosDoBanco(IBancoDeDados db) {
        db.getTables().forEach((key, values) -> {
            System.out.println(dash);
            System.out.println("Classe: " + key.getSimpleName());

            if (values != null) {
                values.forEach(value -> System.out.println(value.toString()));
            }
            System.out.println(dash);
        });
    }

    public static void mostrarNotificacoesDoUsuario(IUsuario usuario) {
        System.out.println(dash);
        System.out.println(usuario);
        System.out.println(dash);
    }

    public static void mostrarDadosDoUsuario(IUsuario usuario) {
        System.out.println(dash);
        System.out.println(usuario.getNome() + "\n");

        System.out.println("Emprestimos:");
        usuario.obterEmprestimos(false).forEach(emprestimo -> {
            System.out.println("  - " + emprestimo);
        });

        System.out.println("Reservas:");
        usuario.obterReservas(false).forEach(reserva -> {
            System.out.println("  - " + reserva);
        });
        System.out.println(dash);
    }

    public static void mostrarDadosDoLivro(Livro livro, IBancoDeDados db) {
        System.out.println(dash);
        System.out.println(livro.getTitulo() + ": " + livro.getQuantidadeDeReservas() + " reservas");

        if (livro.getQuantidadeDeReservas() > 0) {
            System.out.println("Reservas:");
            db.getReservasPorCodigoLivro(false, livro.getCodigo()).forEach(reserva -> {
                System.out.println("  - " + reserva.getUsuario().getNome());
            });
        }

        System.out.println("Exemplares:");
        db.getExemplares(livro.getCodigo()).forEach(exemplar -> {
            String tmp = "  - " + exemplar.getTitulo() + " | " + exemplar.getEstadoDescricao() + " | " + "Código exemplar: "
                    + exemplar.getCodigo();
            if (exemplar.getMutuario() != null) {
                tmp += " | " + exemplar.getMutuario().getNome() + " | " + "Solicitação: "
                        + App.df.format(exemplar.getEmprestimo().getDataSolicitacao()) + " | " + "Devolução: "
                        + App.df.format(exemplar.getEmprestimo().getDataDevolucao());
            }
            System.out.println(tmp);
        });
        System.out.println(dash);
    }
}
