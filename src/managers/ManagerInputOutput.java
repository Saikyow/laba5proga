package managers;

import interfaces.InputOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

/**
 * Обеспечивает ввод-вывод данных, поддерживает интерактивный и скриптовый режимы.
 * Реализует паттерн Singleton.
 */
public class ManagerInputOutput implements InputOutput {
    private static ManagerInputOutput managerInputOutput;
    private Scanner in;
    private Stack<BufferedReader> readerStack;
    private boolean executeScript = false;

    private ManagerInputOutput() {
        this.in = new Scanner(System.in);
        this.readerStack = new Stack<>();
    }

    /**
     * Возвращает единственный экземпляр класса.
     *
     * @return экземпляр ManagerInputOutput
     */
    public static ManagerInputOutput getInstance() {
        if (managerInputOutput == null) {
            managerInputOutput = new ManagerInputOutput();
        }
        return managerInputOutput;
    }

    /**
     * Добавляет BufferedReader для выполнения скрипта в стек.
     *
     * @param reader BufferedReader для чтения скрипта
     */
    public void pushFileExecute(BufferedReader reader) {
        this.readerStack.push(reader);
        this.executeScript = true;
    }

    /**
     * Удаляет текущий BufferedReader из стека и закрывает его.
     */
    public void popFileExecute() {
        if (!readerStack.isEmpty()) {
            try {
                BufferedReader currentReader = readerStack.peek();
                if (currentReader != null) {
                    currentReader.close();
                }
            } catch (IOException e) {
                System.out.println("Ошибка при закрытии ридера: " + e.getMessage());
            } finally {
                readerStack.pop();
                if (readerStack.isEmpty()) {
                    this.executeScript = false;
                }
            }
        }
    }

    /**
     * Проверяет, выполняется ли в данный момент скрипт.
     *
     * @return true, если активен скриптовый режим
     */
    public boolean isScriptMode() {
        return this.executeScript || !readerStack.isEmpty();
    }

    /**
     * Проверяет, является ли переданный ридер текущим активным.
     *
     * @param reader ридер для проверки
     * @return true, если это текущий ридер
     */
    public boolean isCurrentReader(BufferedReader reader) {
        return !readerStack.isEmpty() && readerStack.peek() == reader;
    }

    /**
     * Читает строку ввода. В скриптовом режиме читает из файла, иначе — с консоли.
     *
     * @return прочитанная строка
     */
    public String readLineIO() {
        while (!readerStack.isEmpty()) {
            BufferedReader currentReader = readerStack.peek();
            try {
                String line = currentReader.readLine();
                if (line != null) {
                    System.out.println("[Значение из скрипта] " + line);
                    return line;
                } else {
                    popFileExecute();
                    return null;
                }
            } catch (IOException e) {
                popFileExecute();
                return null;
            }
        }
        return this.in.nextLine();
    }

    /**
     * Выводит сообщение в стандартный поток вывода.
     *
     * @param message сообщение для вывода
     */
    public void writeLineIO(String message) {
        System.out.print(message);
    }

    /**
     * Проверяет наличие следующего целого числа во вводе.
     *
     * @return true, если доступно целое число
     */
    public boolean hasNextIntIO() {
        if (isScriptMode()) return true;
        return this.in.hasNextInt();
    }

    /**
     * Считывает следующее целое число из ввода.
     *
     * @return целое число
     */
    public int nextIntIO() {
        if (isScriptMode()) {
            String line = readLineIO();
            if (line != null) {
                return Integer.parseInt(line.trim());
            }
        }
        return this.in.nextInt();
    }

    /**
     * Закрывает все открытые ресурсы ввода-вывода.
     */
    public void closeIO() {
        this.in.close();

        while (!readerStack.isEmpty()) {
            try {
                BufferedReader reader = readerStack.pop();
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("Ошибка при закрытии ридера: " + e.getMessage());
            }
        }

        writeLineIO("IO закрыт\n");
    }
}