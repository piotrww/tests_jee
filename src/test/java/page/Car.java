package page;

public class Car {
    public Car() {
        printInConstructor();

        Mono aa = new Mono();

    }

    public void printInConstructor() {
        System.out.println("Jestem w konstruktorze");

    }

    public void printOutsideConstructor() {
        System.out.println("Jestem poza konstruktorem");
    }

}
