package Runner;

import User.PersonAsker;
import managers.CollectionManager;
import managers.ManagerInputOutput;
import managers.ManagerParserCommand;

import java.util.NoSuchElementException;

/**
 * Главный класс приложения, отвечающий за запуск и выполнение основного цикла команд.
 */
public class Runner {
    public static ManagerParserCommand managerParserCommand;
    public static ManagerInputOutput managerInputOutput;
    public static CollectionManager collectionManager;
    public static PersonAsker personAsker;

    /**
     * Конструктор, инициализирующий все необходимые менеджеры и утилиты.
     */
    public Runner() {
        managerInputOutput = ManagerInputOutput.getInstance();
        collectionManager = new CollectionManager();
        personAsker = new PersonAsker();
        managerParserCommand = new ManagerParserCommand(collectionManager, personAsker);
    }

    /**
     * Запускает основной цикл обработки команд пользователя.
     * Читает команды из ввода, передает их парсеру и обрабатывает возможное исключение.
     */
    public void run() {
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