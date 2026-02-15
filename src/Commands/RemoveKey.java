package Commands;

import interfaces.Command;

public class RemoveKey implements Command {
    public RemoveKey(){}
    @Override
    public String toString(){return "remove_key - удаляет элемент из коллекции по его ключу";}
}
