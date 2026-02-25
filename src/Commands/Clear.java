package Commands;

import interfaces.Command;
import managers.CollectionManager;

import static Runner.Runner.collectionManager;
import static Runner.Runner.managerInputOutput;

public class Clear implements Command {
    private CollectionManager collectionManager;

    public Clear(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    public void executeCommand(String[] args){
        if (!checkArg(args)){
            return;
        }
        if (collectionManager == null){
            managerInputOutput.writeLineIO("Ошибка! collectionManager не иницилизирован.\n");
        return;
        }
        collectionManager.clearCollections();

        managerInputOutput.writeLineIO("Коллекция успешно удалена. \n");

    }

    private boolean checkArg(String[] args){
        if (args.length == 0 || args == null){
            return true;

        }
        managerInputOutput.writeLineIO("Ошибка! Команда clear не принимает аргументы. \n");
        return false;
    }
    @Override
    public String toString(){return "clear - очистить коллекцию";}
}
