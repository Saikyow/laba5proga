package interfaces;

public interface Command {
    public String toString();
    default void executeCommand(String[] args) {}
//    public boolean checkArg(String[] arg);
}
