package TRABALHO.Usuarios;

import TRABALHO.BancoDeDados.IBancoDeDados;

public class Professor extends Usuario {
    public Professor(int codigoUsuario, String nome, IBancoDeDados db) {
        super(codigoUsuario, nome, db);
    }

   // Não é necessário pois o professor
   // não tem limte de empréstimos public int maxEmprestimos() {
   //     return Integer.MAX_VALUE;
   // }

    public long tempoDeEmprestimoMaximo() {
        return 8 * 24 * 60 * 60 * 1000; // 8 dias em milissegundos;
    }

    public Boolean podeSerObservador() {
        return true;
    }

    public Boolean podeIgnorarListaDeReservas() {
        return true;
    }
}
