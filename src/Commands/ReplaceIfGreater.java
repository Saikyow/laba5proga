package Commands;

import interfaces.Command;

public class ReplaceIfGreater implements Command {
    public ReplaceIfGreater(){}
    @Override
    public String toString(){return "replace_if_greater - заменяет значение по ключу, если новое значение больше старого";}
}
