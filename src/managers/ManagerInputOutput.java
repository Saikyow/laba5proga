package managers;

import interfaces.InputOutput;

import java.util.Scanner;

public class ManagerInputOutput implements InputOutput {
    private static ManagerInputOutput managerInputOutput;
    private final Scanner in;

    private ManagerInputOutput() {this.in = new Scanner(System.in);
    }

    public static ManagerInputOutput getInstance() {
        if (managerInputOutput == null){
            managerInputOutput = new ManagerInputOutput();
        }
        return managerInputOutput;
    }

    public String readLineIO(){ return this.in.nextLine();}

    public boolean hasNextFloatIO() {return in.hasNextFloat();}

    public void writeLineIO(String message){ System.out.print(message);}

    public boolean hasNextIntIO(){return this.in.hasNextInt();}

    public int nextIntIo(){return this.in.nextInt();}

    public boolean hasNextDoubleIO() {return in.hasNextDouble();}

    public float nextFloatIO() {
        return in.nextFloat();
    }

    public Double nextDoubleIO() {
        return in.nextDouble();
    }

    public void CloseIO(){
        this.in.close();
        managerInputOutput.writeLineIO("Терминал закрыт");
    }

}
