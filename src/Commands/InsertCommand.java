package Commands;

import User.Person;
import User.PersonAsker;
import interfaces.Command;
import managers.CollectionManager;

import static Runner.Runner.managerInputOutput;

public class InsertCommand implements Command {
    private CollectionManager collectionManager;
    private PersonAsker personAsker;

    public InsertCommand(CollectionManager collectionManager, PersonAsker personAsker) {
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
        if (!checkArg(args)){
            return;
        }
        try{
            Long key = Long.parseLong(args[0]);

            if (collectionManager.getCollections().containsKey(key)){
                managerInputOutput.writeLineIO("Такой ключ уже занят, используйте команду update для изменения\n");
                return;
            }
            Person newperson = personAsker.createPerson();
            collectionManager.Insert(key, newperson);

        managerInputOutput.writeLineIO("Создан новый Person с ключем " + key + "\n");
        }catch (NumberFormatException e){
            managerInputOutput.writeLineIO("Ошибка при создании ключа " + e.getMessage() + "\n");
        }


    }
    @Override
    public String toString(){return "insert - добавляет новый элемент с заданным ключом";}
}
