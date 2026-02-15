package Commands;

import interfaces.Command;

public class Insert implements Command {
    public Insert(){}
    @Override
    public String toString(){return "insert - добавляет новый элемент с заданным ключом";}
}
