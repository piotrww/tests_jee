package geometry_playground;

public class Triangle implements Figures {
    private final double base;
    private final double height;
    private final String color;


    public Triangle(double base, double height, String color) {
        this.base = base;
        this.height = height;
        this.color = color;
    }


    @Override
    public double calculateArea() {
        return (base * height) * 0.5;
    }

}
