package managers;

import User.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class CollectionManager {
    private HashMap<Long, Person> collections = new HashMap<>();
    private java.time.ZonedDateTime lastInitTime;

    public CollectionManager() {
        this.lastInitTime = java.time.ZonedDateTime.now();
    }

    public void clearCollections(){
        this.collections.clear();
    }

}
