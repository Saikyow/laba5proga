package User;

import enums.Color;
import enums.Country;
import managers.ManagerGenerateId;

import java.time.ZonedDateTime;

public class Person implements Comparable<Person>{
    private static long nextId = 1;
    private long id; // Значение > 0, Значение уникальное, генерируется автоматически
    private String name; // !null, строка не должна быть пустой.
    private Coordinates coordinates; //не может быть null
    private java.time.ZonedDateTime crationDate; // Поле не null
    private Float height;// поле может быть null, значение > 0
    private Float weight; // поле может быть null, значение > 0
    private Color hairColor; // может быть null
    private Country nationality; // не может быть null
    private Location location; // может быть null

    public Person(String name, Coordinates coordinates, Float height, Float weight, Color hairColor,
                  Country nationality, Location location ){
        this(ManagerGenerateId.generateId(),
                name,
                coordinates,
                java.time.ZonedDateTime.now(),
                height, weight, hairColor, nationality, location);
    }

    public Person(long id, String name, Coordinates coordinates, ZonedDateTime crationDate, Float height, Float weight, Color hairColor,
                  Country nationality, Location location ) {
        if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("Имя не может быть пустым");
        if (coordinates == null) throw new IllegalArgumentException("Координаты не могут быть null");
        if (nationality == null) throw new IllegalArgumentException("Национальность не может быть null");
        if (height != null && height <= 0) throw new IllegalArgumentException("Рост должен быть > 0");
        if (weight != null && weight <= 0) throw new IllegalArgumentException("Вес должен быть > 0");

        this.id = id;
        this.crationDate = crationDate;
        this.name = name;
        this.coordinates = coordinates;
        this.height = height;
        this.weight = weight;
        this.hairColor = hairColor;
        this.nationality = nationality;
        this.location = location;
    }
    @Override
    public int compareTo(Person other) {
        return Long.compare(this.id, other.id);
    }
    public long getId() {return id;}
    public String getName() {return name;}
    public Coordinates getCoordinates() {return coordinates;}
    public java.time.ZonedDateTime getCrationDate() {return crationDate;}
    public Float getHeight() {return height;}
    public Float getWeight() {return weight;}
    public Color getHairColor() {return hairColor;}
    public Country getNationality() {return nationality;}
    public Location getLocation() {return location;}
    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", Height=" + height + ", Weight=" + weight + ", HairColor=" + hairColor
                + ", nationality=" + nationality + "]";
    }


}
