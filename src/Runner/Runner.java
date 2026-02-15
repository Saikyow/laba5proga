package Runner;

import managers.CollectionManager;
import managers.ManagerInputOutput;
import managers.ManagerParserCommand;

public class Runner {
    public static ManagerParserCommand managerParserCommand = new ManagerParserCommand();
    public static ManagerInputOutput managerInputOutput = ManagerInputOutput.getInstance();
    public static CollectionManager collectionManager = new CollectionManager();

    public Runner(){
        managerInputOutput = ManagerInputOutput.getInstance();
    }
    public void run(){
        while (true){
            managerInputOutput.writeLineIO("Введите команду : ");
            String command = managerInputOutput.readLineIO();
            boolean flag = managerParserCommand.parserCommand(command);
            if (!flag){
                managerInputOutput.writeLineIO("Неизвестная команда\n");
            }
        }
    }

}
