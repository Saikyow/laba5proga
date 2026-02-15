package Commands;

import interfaces.Command;

public class ReplaceIfLowe implements Command {
    public ReplaceIfLowe(){}
    @Override
    public String toString(){return "replace_if_lowe - заменяет значение по ключу, если новое значение меньше старого";}
}
