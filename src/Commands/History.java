package Commands;

import interfaces.Command;
import managers.ManagerParserCommand;

import java.util.List;

import static Runner.Runner.managerInputOutput;
import static Runner.Runner.personAsker;

public class History implements Command {

    private ManagerParserCommand managerParserCommand;

    public History(ManagerParserCommand managerParserCommand){
        this.managerParserCommand = managerParserCommand;
    }

    public void executeCommand(String[] args){
        if (!checkArg(args)){
            return;
        }

        List<String> history = managerParserCommand.getHistoryCommands();

        if (history.isEmpty()){
            return;
        }
        managerInputOutput.writeLineIO("Последние команды:\n");
        managerInputOutput.writeLineIO("------------------------------------------------------\n");
        for (int i = 0; i<history.size(); i++){
            managerInputOutput.writeLineIO((i+1) + ". " + history.get(i) + "\n");
        }
        managerInputOutput.writeLineIO("------------------------------------------------------\n");




    }



    private boolean checkArg(String[] args){
        if (args.length == 0 || args == null){
            return true;

        }
        managerInputOutput.writeLineIO("Ошибка! Команда history не принимает аргументы. \n");
        return false;
    }
    @Override
    public String toString(){return "history - выводит последние 14 команд без их аргументов";}
}
