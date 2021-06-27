package page;

public class Car {
    public Car() {
        printInConstructor();

    }

    public void printInConstructor() {
        System.out.println("Jestem w konstruktorze");

    }

    public void printOutsideConstructor() {
        System.out.println("Jestem poza konstruktorem");
    }

}
