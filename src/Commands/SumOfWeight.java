package Commands;

import User.Person;
import interfaces.Command;
import managers.CollectionManager;

import static Runner.Runner.managerInputOutput;

public class SumOfWeight implements Command {

    private CollectionManager collectionManager;

    public SumOfWeight(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    public void executeCommand(String[] args) {
        if (!checkArg(args)){
            return;
        }



        var collections = collectionManager.getCollections();
        float totalWeight = 0;

        if (collections.isEmpty()){
            managerInputOutput.writeLineIO("Коллекция пустая \n");
            return;
        }


        for (Person person : collections.values()){
            Float weight = person.getWeight();
            if (weight != null){
                totalWeight += weight;
            }

        }

        managerInputOutput.writeLineIO("Общий вес всех героев коллекции = " + totalWeight + "\n");
    }

    private boolean checkArg(String[] args){
        if (args.length == 0 || args == null){
            return true;
        }
        managerInputOutput.writeLineIO("Ошибка! Команда sum_of_weight не принимает аргументы. \n");
        return false;
    }

    @Override
    public String toString(){return "sum_of_weight - выводит сумму значений поля weight для всех элементов коллекции";}
}
