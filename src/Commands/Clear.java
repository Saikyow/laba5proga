package Commands;

import interfaces.Command;

import static Runner.Runner.collectionManager;
import static Runner.Runner.managerInputOutput;

public class Clear implements Command {
    public void execute(String[] args){
        if (checkArg(args)){
            collectionManager.clearCollections();
        }
        else {
            managerInputOutput.writeLineIO("Неверное количество аргументов\n");
        }

    }

    private boolean checkArg(String[] args){
        if (args.length == 0){
            return true;

        }
        return false;
    }
    @Override
    public String toString(){return "clear - очистить коллекцию";}
}
