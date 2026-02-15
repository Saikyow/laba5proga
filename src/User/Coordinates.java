package User;

public class Coordinates {
    private Double x;
    private Long y;
    public Coordinates(Double x, Long y) {
        if (x == null) {throw new IllegalArgumentException("Не может быть null");}
        if (y == null || y < -322) {throw new IllegalArgumentException("Y не может быть меньше -322");}
        this.x = x;
        this.y = y;
    }
    public Double getX() {return x;}
    public Long getY() {return y;}
    @Override
    public String toString() {
        return "x=" + x + ", y=" + y;
    }
}
