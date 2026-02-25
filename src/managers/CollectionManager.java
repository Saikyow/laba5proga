package managers;

import User.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import static managers.ManagerGenerateId.generateId;

public class CollectionManager {
    private HashMap<Long, Person> collections = new HashMap<>();
    private java.time.ZonedDateTime lastInitTime;


    public CollectionManager() {
        this.lastInitTime = java.time.ZonedDateTime.now();
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
