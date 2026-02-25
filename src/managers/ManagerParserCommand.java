package managers;

import Commands.*;
import User.Person;
import User.PersonAsker;
import interfaces.Command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;

import static Runner.Runner.collectionManager;
import static Runner.Runner.managerParserCommand;

public class ManagerParserCommand{
	private final HashMap<String, Command> commands;
	private final List<String> historyCommands;
	private static final int MAX_HISTORY_SIZE = 14;

    public ManagerParserCommand(CollectionManager collectionManager, PersonAsker personAsker) {
        this.commands = new HashMap<String, Command>();
        this.historyCommands = new ArrayList<>(MAX_HISTORY_SIZE);

        this.commands.put("help", new Help());
        this.commands.put("info", new Info(collectionManager));
        this.commands.put("show", new Show(collectionManager));
        this.commands.put("insert", new InsertCommand(collectionManager, personAsker));
        this.commands.put("update_id", new UpdateID(collectionManager, personAsker));
        this.commands.put("remove_key", new RemoveKey(collectionManager));
        this.commands.put("clear", new Clear(collectionManager));
        this.commands.put("save", new Save(collectionManager));
        this.commands.put("execute_script", new ExecuteScript(this));
        this.commands.put("exit", new Exit());
        this.commands.put("history", new History(this));
        this.commands.put("replace_if_greater", new ReplaceIfGreater(collectionManager, personAsker));
        this.commands.put("replace_if_lowe", new ReplaceIfLowe(collectionManager,personAsker));
        this.commands.put("sum_of_weight", new SumOfWeight(collectionManager));
        this.commands.put("group_counting_by_name", new GroupCountingByName(collectionManager));
        this.commands.put("print_ascending", new PrintAscending(collectionManager));


    }
    public boolean parserCommand(String s) {
        String[] command = s.trim().replaceAll("\\s+", " ").split(" ");

        if (this.commands.containsKey(command[0])) {
            System.out.println(command[0]);
            Command cmd = this.commands.get(command[0]);
            cmd.executeCommand(Arrays.copyOfRange(command, 1, command.length));

            if (this.historyCommands.size() >= MAX_HISTORY_SIZE) {
                this.historyCommands.remove(0);
            }
            this.historyCommands.add(s);
            return true;
        }
        return false;
    }

    public List<Command> getCommand(){
        List<Command> commandList = new ArrayList<>();
        commandList.addAll(this.commands.values());
        return commandList;
    }
    public List<String> getHistoryCommands(){return historyCommands;}



}
