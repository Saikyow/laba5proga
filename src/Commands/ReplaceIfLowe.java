package Commands;

import User.Person;
import User.PersonAsker;
import interfaces.Command;
import managers.CollectionManager;

import static Runner.Runner.managerInputOutput;

public class ReplaceIfLowe implements Command {
    private PersonAsker personAsker;
    private CollectionManager collectionManager;
    public ReplaceIfLowe(CollectionManager collectionManager, PersonAsker personAsker){
        this.collectionManager = collectionManager;
        this.personAsker = personAsker;
    }

    public boolean checkArg(String[] args) {
        if (args == null || args.length == 0 || args[0].isEmpty()) {
            managerInputOutput.writeLineIO("Не указан ключ \n");
            return false;
        }
        try {
            Long.parseLong(args[0]);
            return true;
        } catch (NumberFormatException e) {
            managerInputOutput.writeLineIO("Ключ должен быть целым числом. Вы ввели: " + args[0]);
            return false;
        }
    }

    public void executeCommand(String[] args){
        if(!checkArg(args)){
            return;
        }

        try{
            Long key = Long.parseLong(args[0]);
            if (!collectionManager.getCollections().containsKey(key)){
                managerInputOutput.writeLineIO("Нету элемента с таким ключём \n");
                return;
            }
            Person oldPerson = collectionManager.getCollections().get(key);
            managerInputOutput.writeLineIO("Текущий элемент коллекции с ключём " + key + "\n");
            managerInputOutput.writeLineIO("Ключ: " + key + " name: "+ oldPerson.getName() +
                    " Вес: " + oldPerson.getWeight() +  " id: " + oldPerson.getId() + " " + oldPerson.getCrationDate() + "\n");

            Person newPerson = personAsker.createPerson();

            if (comparePerson(newPerson, oldPerson)){
                collectionManager.Insert(key, newPerson);
                managerInputOutput.writeLineIO("Новый элемент меньше старого => производится замена. \n");
            } else {
                managerInputOutput.writeLineIO("Новый элемент больше старого => замена не производится. \n");
            }



        }catch (NumberFormatException e){
            managerInputOutput.writeLineIO("Ошибка при обработке ключа " + e.getMessage());
        }
    }


    private boolean comparePerson(Person newPerson, Person oldPerson){
        if (newPerson.getWeight() != null && oldPerson.getWeight() != null){
            return newPerson.getWeight() < oldPerson.getWeight();
        }else{
            return false;
        }
    }

    @Override
    public String toString(){return "replace_if_lowe - заменяет значение по ключу, если новое значение меньше старого";}
}
