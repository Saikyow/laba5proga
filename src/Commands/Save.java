package Commands;

import interfaces.Command;

public class Save implements Command {
    public Save(){}
    @Override
    public String toString(){return "save - сохранить коллекцию в файл";}
}
