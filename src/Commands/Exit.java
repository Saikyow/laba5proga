package Commands;

import interfaces.Command;

import static Runner.Runner.managerInputOutput;

public class Exit implements Command {
    public void executeCommand(String[] args){
        if (checkArg(args)) {
            managerInputOutput.CloseIO();
            System.exit(0);
        }
        else {
            managerInputOutput.writeLineIO("Неверное количество аргументов\n");
        }
    }
    public boolean checkArg(String[] args){
        if (args.length == 0){
            return true;
        }
        return false;
    }
    @Override
    public String toString(){return "exit - завершает программу без сохранения в файл";}
}
