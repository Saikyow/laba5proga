package Commands;

import User.Person;
import User.PersonAsker;
import interfaces.Command;
import managers.CollectionManager;

import java.util.HashMap;
import java.util.Map;

import static Runner.Runner.managerInputOutput;

public class GroupCountingByName implements Command {
    private CollectionManager collectionManager;

    public GroupCountingByName(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    public void executeCommand(String[] args){
        if (!checkArg(args)){
            return;
        }
        Map<Long, Person> collections = collectionManager.getCollections();

        if (collections.isEmpty()){
            managerInputOutput.writeLineIO("Коллекция пустая. \n");
            return;
        }


        Map<String, Integer> groups = new HashMap<>();

        for (Person person : collections.values()){
            String name =  person.getName();
            groups.put(name, groups.getOrDefault(name, 0) + 1);
        }

        groups.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    String name = entry.getKey();
                    int count = entry.getValue();

                    managerInputOutput.writeLineIO("Имя: " + name + " | Количество: " + count + "\n");
                });
    }

    private boolean checkArg(String[] args){
        if (args.length == 0 || args == null){
            return true;

        }
        managerInputOutput.writeLineIO("Ошибка! Команда clear не принимает аргументы. \n");
        return false;
    }
    @Override
    public String toString(){return "group_counting_by_name - группирует элементы коллекции по значению поля name, выводит количество элементов в каждой группе";}
}
