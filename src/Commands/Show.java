package Commands;

import User.Person;
import interfaces.Command;
import managers.CollectionManager;

import java.util.Map;

import static Runner.Runner.managerInputOutput;

public class Show implements Command {
    private CollectionManager collectionManager;
    public Show(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }
    public boolean checkArg(String[] args) {
        if (args.length == 0 || args == null) {
            return true;
        } else {
            managerInputOutput.writeLineIO("Команда show не принимает аргументы \n");
            return false;

        }
    }

    public void executeCommand(String[] args) {
        if (!checkArg(args)) {
            return;
        }

        Map<Long, Person> collections = collectionManager.getCollections();
        if (collections.isEmpty()){
            managerInputOutput.writeLineIO("Коллекция пустая \n");
        return;
        }
        for (Map.Entry<Long, Person> entry : collections.entrySet()){
            Long key = entry.getKey();
            Person person = entry.getValue();
            managerInputOutput.writeLineIO("Ключ: " + key + " name: "+ person.getName() + " Вес: " + person.getWeight() +  " id: " + person.getId() + " Время создания " + person.getCrationDate() + "\n");
        }





    }

    @Override
    public String toString(){return "show - выводит в стандартный поток вывода все элементы коллекции в строковом представлении";}
}
