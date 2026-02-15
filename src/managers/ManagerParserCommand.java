package managers;

import Commands.*;
import interfaces.Command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;

public class ManagerParserCommand{
	private final HashMap<String, Command> commands;
	private final List<String> historyCommands;
	private static final int MAX_HISTORY_SIZE = 14;

    public ManagerParserCommand() {
        this.commands = new HashMap<String, Command>();
        this.historyCommands = new ArrayList<>(MAX_HISTORY_SIZE);

        this.commands.put("help", new Help());
        this.commands.put("info", new Info());
        this.commands.put("show", new Show());
        this.commands.put("insert", new Insert());
        this.commands.put("update_id", new UpdateID());
        this.commands.put("remove_key", new RemoveKey());
        this.commands.put("clear", new Clear());
        this.commands.put("save", new Save());
        this.commands.put("execute_script", new ExecuteScript());
        this.commands.put("exit", new Exit());
        this.commands.put("history", new History());
        this.commands.put("replace_if_greater", new ReplaceIfGreater());
        this.commands.put("replace_if_lowe", new ReplaceIfLowe());
        this.commands.put("sum_of_weight", new SumOfWeight());
        this.commands.put("group_counting_by_name", new GroupCountingByName());
        this.commands.put("print_ascending", new PrintAscending());


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
