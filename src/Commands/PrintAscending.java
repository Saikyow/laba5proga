package Commands;

import interfaces.Command;

public class PrintAscending implements Command {
    public PrintAscending(){}
    @Override
    public String toString(){return "print_ascending - выводит элементы коллекции в порядке возрастания";}
}
