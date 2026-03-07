import Runner.Runner;

/**
 * Главный класс приложения, точка входа.
 */
public class Main {

    /**
     * Точка входа в программу.
     * Создает и запускает основной цикл обработки команд.
     *
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        Runner run = new Runner();
        run.run();
    }
}