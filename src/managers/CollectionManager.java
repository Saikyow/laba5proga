package managers;

import User.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import static Runner.Runner.managerInputOutput;
import static managers.ManagerGenerateId.generateId;

public class CollectionManager {
    private HashMap<Long, Person> collections = new HashMap<>();
    private java.time.ZonedDateTime lastInitTime;
    private static final String DEFAULT_CSV_FILE = "collection.csv";


    public CollectionManager() {
        this.lastInitTime = java.time.ZonedDateTime.now();
        loadCollectionFromFile();
    }

    public void loadCollectionFromFile() {
        HashMap<Long, Person> loaded = csvParserManager.LoadFromCSV(DEFAULT_CSV_FILE);
        if (!loaded.isEmpty()) {
            this.collections = loaded;
            managerInputOutput.writeLineIO("Коллекция загружена с размером " + collections.size() + "\n");
        }
    }
    public void Insert(Long key, Person person){
       this.collections.put(key, person);
    }

    public void remove(Long key){
        this.collections.remove(key);
    }

    public void clearCollections(){
        this.collections.clear();
    }

    public HashMap<Long, Person> getCollections() {
        return collections;
    }

}
