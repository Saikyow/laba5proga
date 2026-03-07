package Runner;

import User.PersonAsker;
import managers.CollectionManager;
import managers.ManagerInputOutput;
import managers.ManagerParserCommand;

import java.util.NoSuchElementException;

public class Runner {
    public static ManagerParserCommand managerParserCommand;
    public static ManagerInputOutput managerInputOutput;
    public static CollectionManager collectionManager;
    public static PersonAsker personAsker;



    public Runner(){
        managerInputOutput = ManagerInputOutput.getInstance();
        collectionManager = new CollectionManager();
        personAsker = new PersonAsker();
        managerParserCommand = new ManagerParserCommand(collectionManager, personAsker);
    }
    public void run(){
        try {
            while (true) {
                managerInputOutput.writeLineIO("Введите команду : ");
                String command = managerInputOutput.readLineIO();
                boolean flag = managerParserCommand.parserCommand(command);
                if (!flag) {
                    managerInputOutput.writeLineIO("Неизвестная команда\n");
                }
            }
        } catch (NoSuchElementException e) {
            managerInputOutput.writeLineIO("...\n");
        }
    }

}
