package page;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    private WebDriver driver;
    private BookingHomePage bookingHomePage;



    public PageObjectManager(WebDriver driver) { //konstruktor
        this.driver = driver;
    }

    public BookingHomePage getBookingHomePage() {

        return(bookingHomePage == null) ? bookingHomePage = new BookingHomePage(driver) : bookingHomePage; //Zamiast if.



        //ternary operator
    };
}
//porządkowanie: CTRL ALT L