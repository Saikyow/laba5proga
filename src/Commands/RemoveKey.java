package Commands;

import interfaces.Command;
import managers.CollectionManager;

import static Runner.Runner.managerInputOutput;

public class RemoveKey implements Command {
    private CollectionManager collectionManager;

    public RemoveKey(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }


    public boolean checkArg(String[] args) {
        if (args == null || args.length == 0 || args[0].isEmpty()) {
            managerInputOutput.writeLineIO("Не указан ключ \n");
            return false;
        }
        if (args.length > 1){
            managerInputOutput.writeLineIO("Ошибка! Команда remove_key принимает только 1 ключ. \n");
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
            Long key = Long.parseLong(args[0]);
        if (!collectionManager.getCollections().containsKey(key)) {
            managerInputOutput.writeLineIO("Ошибка! элемент с ключем " + key + " не найден\n");
            return;
        }String personname = collectionManager.getCollections().get(key).getName();
        collectionManager.getCollections().remove(key);
        managerInputOutput.writeLineIO("Коллекция с ключём " + key + " (имя: " + personname + ")" + " успешно удалена. \n");
        }catch (NumberFormatException e){
            managerInputOutput.writeLineIO("Ошибка при обработке ключа " + e.getMessage() + "\n");
        }
    }
    @Override
    public String toString(){return "remove_key - удаляет элемент из коллекции по его ключу";}
}
