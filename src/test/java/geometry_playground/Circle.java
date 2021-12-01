package geometry_playground;

public class Circle implements Figures {
    private final int radius;




    public Circle(int radius) {
        this.radius = radius;
    }


    @Override
    public double calculateArea() {

        System.out.println(Math.PI);
        return Math.PI*(radius*radius);
    }

    public double calculateArea2() {

        System.out.println(Math.PI);
        return Math.PI*(radius*radius);
    }




}
