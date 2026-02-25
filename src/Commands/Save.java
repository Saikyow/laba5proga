package Commands;

import User.Person;
import interfaces.Command;
import managers.CollectionManager;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import static Runner.Runner.managerInputOutput;

public class Save implements Command {
    private CollectionManager collectionManager;

    public Save(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }


    public void executeCommand(String[] args) {
        if (!checkArg(args)) {
            return;
        }

        String filename = "collection.csv";

        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
                writer.println("key;id;name;coordinates_x;coordinates_y;creationDate;height;weight;hairColor;nationality;" +
                        "location_x;location_y;location_z;location_name");
            var collections = collectionManager.getCollections();

            for (Map.Entry<Long, Person> entry : collections.entrySet()) {
                Long key = entry.getKey();
                Person person = entry.getValue();

                String csvLine = String.format("%d;%d;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s",
                        key,
                        person.getId(),
                        person.getName(),
                        person.getCoordinates().getX(),
                        person.getCoordinates().getY(),
                        person.getCrationDate().toString(),
                        person.getHeight() != null ? person.getHeight() : "",
                        person.getWeight() != null ? person.getWeight() : "",
                        person.getHairColor() != null ? person.getHairColor() : "",
                        person.getNationality(),
                        person.getLocation() != null ? person.getLocation().getX() : "",
                        person.getLocation() != null ? person.getLocation().getY() : "",
                        person.getLocation() != null ? person.getLocation().getZ() : "",
                        person.getLocation() != null ? person.getLocation().getName() : ""
                );
                writer.println(csvLine);



            }

            managerInputOutput.writeLineIO("Коллекция успешно сохранена в файл " + filename + "\n");




        }catch (IOException e){
            managerInputOutput.writeLineIO("Ошибка при сохранении " + e.getMessage());
        }

    }

    public boolean checkArg(String[] args) {
        if (args.length == 0 || args == null) {
            return true;
        } else {
            managerInputOutput.writeLineIO("Команда show не принимает аргументы \n");
            return false;

        }
    }

    @Override
    public String toString(){return "save - сохранить коллекцию в файл";}
}
