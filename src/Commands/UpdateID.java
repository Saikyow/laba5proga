package Commands;

import interfaces.Command;

public class UpdateID implements Command {
    public UpdateID(){}
    @Override
    public String toString(){return "update_id - обновляет значение элемента коллекции, id которого равен заданному";}

}
