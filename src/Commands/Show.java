package Commands;

import interfaces.Command;

public class Show implements Command {
    public Show(){}
    @Override
    public String toString(){return "show - выводит в стандартный поток вывода все элементы коллекции в строковом представлении";}
}
