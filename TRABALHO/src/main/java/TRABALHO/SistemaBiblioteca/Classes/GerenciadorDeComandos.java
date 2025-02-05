package TRABALHO.SistemaBiblioteca;

import java.util.HashMap;
import TRABALHO.Commands.ICommand;

public class GerenciadorDeComandos {
    private HashMap<String, ICommand> commands;

    public GerenciadorDeComandos() {
        this.commands = new HashMap<String, ICommand>();
    }

    public void addCommand(String commandStr, ICommand commandCls) {
        commands.put(commandStr, commandCls);
    }

    public void executeCommand(String command, String... args) {
        try {
            ICommand concreteCommand = commands.get(command);
            ValidacaoCommand.validarCommand(concreteCommand);
            concreteCommand.execute(args);
        } catch (CommandException e) {
            Mensagens.MensagemDeErro("Não foi possível processar seu pedido.", "Comando \"" + command + "\" inválido.", null, null);
        } catch (NumberFormatException e) {
            Mensagens.MensagemDeErro("Não foi possível processar seu pedido.", "Esperava números como argumentos.", null, null);
        } catch (InvalidNumberOfArgsException e) {
            Mensagens.MensagemDeErro("Não foi possível processar seu pedido.", e.getMessage(), null, null);
        }
    }
}
