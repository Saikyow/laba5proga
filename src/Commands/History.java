package Commands;

import interfaces.Command;

public class History implements Command {
    public History(){}
    @Override
    public String toString(){return "history - выводит последние 14 команд без их аргументов";}
}
