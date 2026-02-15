package Commands;

import interfaces.Command;

public class SumOfWeight implements Command {
    public SumOfWeight(){}
    @Override
    public String toString(){return "sum_of_weight - выводит сумму значений поля weight для всех элементов коллекции";}
}
