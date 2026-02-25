package Commands;

import interfaces.Command;
import managers.CollectionManager;

import static Runner.Runner.managerInputOutput;

public class Info implements Command {
    private CollectionManager collectionManager;

    public Info(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }



    private boolean checkArg(String[] args){
        if (args.length == 0 || args == null){
            return true;

        }
        managerInputOutput.writeLineIO("Ошибка! Команда Help не принимает аргументы. \n");
        return false;
    }

    public void executeCommand(String[] args){
        if (!checkArg(args)){
            return;
        }


        var collections = collectionManager.getCollections();


        managerInputOutput.writeLineIO("Информация о коллекции: \n");
        if (collections.isEmpty()){
            managerInputOutput.writeLineIO("Коллекция пустая\n");
        }else{
            managerInputOutput.writeLineIO("В коллекции есть элементы.\n");
        }
        managerInputOutput.writeLineIO("------------------------------------------------------\n");

        managerInputOutput.writeLineIO("Тип коллекции: " + collections.getClass().getName() + "\n");
        managerInputOutput.writeLineIO("Количество элементов: " + collections.size() + "\n");

        managerInputOutput.writeLineIO("------------------------------------------------------\n");
    }


    @Override
    public String toString() {return "info - выводит информацию о коллекции в стандартный поток вывода";}
}
