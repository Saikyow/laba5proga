package Commands;

import interfaces.Command;

import static Runner.Runner.managerInputOutput;
import static Runner.Runner.managerParserCommand;

public class Help implements Command {
    public void executeCommand(String[] args) {
        if (checkArg(args)) {
            managerInputOutput.writeLineIO("Справка по командам:\n");
            managerInputOutput.writeLineIO("------------------------------------------------------\n");
            for (Command cmd : managerParserCommand.getCommand()) {
                managerInputOutput.writeLineIO(cmd + "\n");
            }
            managerInputOutput.writeLineIO("------------------------------------------------------\n");
        } else {
            managerInputOutput.writeLineIO("Неверное количество аргументов\n");
        }
    }


    private boolean checkArg(String[] args){
        if (args.length == 0 || args == null){
            return true;

        }
        managerInputOutput.writeLineIO("Ошибка! Команда Help не принимает аргументы. \n");
        return false;
    }

    @Override
    public String toString() { return "help - выводит справку по каждой программе";}
}
