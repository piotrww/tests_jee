package geometry_playground;


import org.junit.Test;

public class GeometricTestPrint {

    @Test
    public void printValueOfGeometric() {

        Rectangle myRectangle = new Rectangle(2, 3);


        double areaRectangle = myRectangle.calculateArea();
        System.out.println(areaRectangle);


        Circle myCirle = new Circle(3);
        double areaMyCirce = myCirle.calculateArea();
        System.out.println(areaMyCirce);

//        Triangle myTriangle = new Triangle(5.5, 1);
//        double areaMyTriangle = myTriangle.calculateArea();
//        System.out.println(areaMyTriangle);

    }


}
