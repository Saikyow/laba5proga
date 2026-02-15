package Commands;

import interfaces.Command;

public class ExecuteScript implements Command {
    public ExecuteScript(){}
    @Override
    public String toString(){return "execute_script - считывает и исполняет скрипт из указанного файла.";}
}
