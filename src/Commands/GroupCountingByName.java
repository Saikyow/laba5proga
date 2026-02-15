package Commands;

import interfaces.Command;

public class GroupCountingByName implements Command {
    public GroupCountingByName(){}
    @Override
    public String toString(){return "group_counting_by_name - группирует элементы коллекции по значению поля name, выводит количество элементов в каждой группе";}
}
