package TRABALHO.SistemaBiblioteca;

import TRABALHO.BancoDeDados.IBancoDeDados;
import TRABALHO.Commands.*;

public class SistemaBiblioteca {
    private static SistemaBiblioteca instance;
    private IBancoDeDados db;
    private GerenciadorDeComandos gerenciadorDeComandos;
    private GerenciadorDeEmprestimos gerenciadorDeEmprestimos;
    private GerenciadorDeReservas gerenciadorDeReservas;
    private GerenciadorDeExibicao gerenciadorDeExibicao;

    private SistemaBiblioteca(IBancoDeDados db) {
        this.db = db;
        this.gerenciadorDeComandos = new GerenciadorDeComandos();
        this.gerenciadorDeEmprestimos = new GerenciadorDeEmprestimos(db);
        this.gerenciadorDeReservas = new GerenciadorDeReservas(db);
        this.gerenciadorDeExibicao = new GerenciadorDeExibicao(db);
        addCommands();
    }

    public static SistemaBiblioteca getInstance(IBancoDeDados db) {
        if (instance == null) {
            instance = new SistemaBiblioteca(db);
        }
        return instance;
    }

    private void addCommands() {
        gerenciadorDeComandos.addCommand("emp", new EmprestimoCommand(this));
        gerenciadorDeComandos.addCommand("dev", new DevolucaoCommand(this));
        gerenciadorDeComandos.addCommand("res", new ReservarCommand(this));
        gerenciadorDeComandos.addCommand("obs", new ObservarLivroCommand(this));
        gerenciadorDeComandos.addCommand("usu", new VerUsuarioCommand(this));
        gerenciadorDeComandos.addCommand("liv", new VerLivroCommand(this));
        gerenciadorDeComandos.addCommand("ntf", new VerNotificacoesCommand(this));
        gerenciadorDeComandos.addCommand("all", new VerBancoDeDadosCommand(this));
        gerenciadorDeComandos.addCommand("sai", new SaiCommand());
    }

    public void executeCommand(String command, String... args) {
        gerenciadorDeComandos.executeCommand(command, args);
    }

    public void realizarEmprestimo(int codigoUsuario, int codigoLivro) {
        gerenciadorDeEmprestimos.realizarEmprestimo(codigoUsuario, codigoLivro);
    }

    public void realizarDevolucao(int codigoUsuario, int codigoLivro) {
        gerenciadorDeEmprestimos.realizarDevolucao(codigoUsuario, codigoLivro);
    }
