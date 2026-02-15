package Commands;

import interfaces.Command;

public class Info implements Command {
    public Info(){

    }
    @Override
    public String toString() {return "info - выводит информацию о коллекции в стандартный поток вывода";}
}
