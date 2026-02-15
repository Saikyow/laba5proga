package User;

public class Location {
    private Double x;
    private int y;
    private  Double z;
    private String name;
    public Location(Double x, int y, Double z, String name) {
        if (x == null){ throw new IllegalArgumentException("Не может быть null");}
        if (z == null){ throw new IllegalArgumentException("Не может быть null");}
        if (name == null){ throw new IllegalArgumentException("Не может быть null");}
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }
    public Double getX() {return x;}
    public int getY() {return y;}
    public Double getZ() {return z;}
    public String getName() {return name;}
    @Override
    public String toString() {
        return "x=" + x + ", y=" + y + ", z=" + z + ", name=" + name;
    }

}
