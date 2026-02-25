package Commands;

import User.Person;
import interfaces.Command;
import managers.CollectionManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static Runner.Runner.managerInputOutput;

public class PrintAscending implements Command {
    private CollectionManager collectionManager;

    public PrintAscending(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }


    public void executeCommand(String[] args){
        if (!checkArg(args)){
            return;
        }
        Map<Long, Person> collections = collectionManager.getCollections();


        if (collections.isEmpty()){
            managerInputOutput.writeLineIO("Коллекция пустая \n");
            return;
        }

        List<Map.Entry<Long, Person>> entryList = new ArrayList<>(collections.entrySet());

        entryList.sort((entry1, entry2) ->
                Long.compare(entry1.getValue().getId(), entry2.getValue().getId()));

        managerInputOutput.writeLineIO("------------------------------------------------------\n");

        for (Map.Entry<Long, Person> entry : entryList) {
            Long key = entry.getKey();
            Person person = entry.getValue();
            managerInputOutput.writeLineIO("id: " + person.getId() + " key: " + key +  " name: " + person.getName() +
                    " Вес: " + person.getWeight() + " " + person.getCrationDate() + "\n");
        }
        managerInputOutput.writeLineIO("------------------------------------------------------\n");






    }

    private boolean checkArg(String[] args){
        if (args.length == 0 || args == null){
            return true;

        }
        managerInputOutput.writeLineIO("Ошибка! Команда print_ascending не принимает аргументы. \n");
        return false;
    }

    @Override
    public String toString(){return "print_ascending - выводит элементы коллекции в порядке возрастания";}
}
