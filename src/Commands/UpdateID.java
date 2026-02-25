package Commands;

import User.Person;
import User.PersonAsker;
import interfaces.Command;
import managers.CollectionManager;

import java.util.Map;

import static Runner.Runner.managerInputOutput;

public class UpdateID implements Command {
    private CollectionManager collectionManager;
    private PersonAsker personAsker;

    public UpdateID(CollectionManager collectionManager, PersonAsker personAsker){
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

        try {
            long targetId = Long.parseLong(args[0]);

            Map<Long, Person> collections = collectionManager.getCollections();
            Long targetkey = null;
            Person oldPerson = null;

            for(Map.Entry<Long, Person> entry : collections.entrySet()){
                if(entry.getValue().getId() == targetId){
                    targetkey = entry.getKey();
                    oldPerson = entry.getValue();
                    break;
                }
            }

            if (targetkey == null){
                managerInputOutput.writeLineIO("Ошибка элемент с id: " + targetId + " не найден. \n");
                return;
            }
            managerInputOutput.writeLineIO("Старый элемент: \n");
            managerInputOutput.writeLineIO("Ключ: " + targetkey + " name: "+ oldPerson.getName() + " Вес: " + oldPerson.getWeight() +
                    " id: " + oldPerson.getId() + oldPerson.getCrationDate() + "\n");

            managerInputOutput.writeLineIO("Создание нового Person. \n");

            Person newPerson = personAsker.createPerson();

            Person updatePerson = createPersonwithsameId(newPerson, targetId);

            collectionManager.Insert(targetkey, updatePerson);

            managerInputOutput.writeLineIO("Элемент с ID = " + targetId + " успешно обновлен. \n");

        }catch (NumberFormatException e){

            managerInputOutput.writeLineIO("Ошибка при обработке ID " + e.getMessage());
        }
    }

    private Person createPersonwithsameId(Person person, long id){
        return new Person(
                id,
                person.getName(),
                person.getCoordinates(),
                person.getCrationDate(),
                person.getHeight(),
                person.getWeight(),
                person.getHairColor(),
                person.getNationality(),
                person.getLocation()
        );
    }


    @Override
    public String toString(){return "update_id - обновляет значение элемента коллекции, id которого равен заданному";}

}
