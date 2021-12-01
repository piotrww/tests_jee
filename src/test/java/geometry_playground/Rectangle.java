package geometry_playground;

public class Rectangle implements Figures {
    private final int sideA;
    private final int sideB;



    //Tworzymy konstruktor

    public Rectangle(int sideA, int sideB) {
     this.sideA = sideA;
     this.sideB = sideB;
    }

    @Override
    public double calculateArea() {
        return sideA * sideB;
    }
}
