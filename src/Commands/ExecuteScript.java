package Commands;

import interfaces.Command;
import managers.ManagerParserCommand;

import java.io.*;

import static Runner.Runner.managerInputOutput;

public class ExecuteScript implements Command {
    private ManagerParserCommand parserCommand;

    public ExecuteScript(ManagerParserCommand parserCommand){
        this.parserCommand = parserCommand;
    }



    public boolean checkArg(String[] args) {
        if (args == null || args.length == 0 || args[0].isEmpty()) {
            managerInputOutput.writeLineIO("Не указан путь скрипта \n");
            return false;
        }
        return true;

    }

    public void executeCommand(String[] args){
        if (!checkArg(args)){
            return;
        }

        String filename = args[0];

        File file = new File(filename);

        if (!file.exists()){
            managerInputOutput.writeLineIO("Файл не найден. \n");
            return;
        }
        if (!file.canRead()){
            managerInputOutput.writeLineIO("Недостаточно прав для чтения файла. \n");
            return;
        }

        try {InputStreamReader reader = new InputStreamReader(new FileInputStream(file), "UTF-8");

            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;
            int lineNumber = 0;
            boolean hasErrors = false;

            while ((line = bufferedReader.readLine()) != null ){
                lineNumber++;
                line = line.trim();

                if (line.isEmpty() || line.startsWith("#")){continue;}

                String[] parts = line.split("\\s+", 2);
                String commandName = parts[0].toLowerCase();
                String[] commandArgs = parts.length > 1 ? new String[]{parts[1]} : new String[0];

                if (isInteractiveCommand(commandName)) {
                    managerInputOutput.writeLineIO("Команда '" + commandName + "' требует ввода и пропущена в скрипте.\n");
                    hasErrors = true;
                    continue;
                }

                boolean success = parserCommand.parserCommand(line);
                if (!success) {
                    managerInputOutput.writeLineIO("Ошибка выполнения команды: " + commandName + "\n");
                    hasErrors = true;
                }
                if (hasErrors)
                    managerInputOutput.writeLineIO("Скрипт выполнен с ошибками/пропусками. \n");
                else
                    managerInputOutput.writeLineIO("Скрипт успешно выполнен. \n");


            }

            }catch (FileNotFoundException e){
            managerInputOutput.writeLineIO("Файл не найден " + e.getMessage() + "\n");

        }   catch (IOException e){
            managerInputOutput.writeLineIO("Ошибка ввода - вывода. " +  e.getMessage() + "\n");
        }



    }


    private boolean isInteractiveCommand(String cmd) {
        return cmd.equals("insert") || cmd.equals("update_id") ||
                cmd.equals("replace_if_greater") || cmd.equals("replace_if_lowe");
    }

    @Override
    public String toString(){return "execute_script - считывает и исполняет скрипт из указанного файла.";}
}
