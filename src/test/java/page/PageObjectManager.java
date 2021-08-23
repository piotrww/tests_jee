package page;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    private WebDriver driver;
    private BookingHomePage bookingHomePage;


    public PageObjectManager(WebDriver driver) { //konstruktor
        this.driver = driver;
    }

    public BookingHomePage getBookingHomePage() {

            return (bookingHomePage == null) ? bookingHomePage = new BookingHomePage(driver) : bookingHomePage; //Zamiast if.

        // to samo co wyżej
  //      if
  //      (bookingHomePage == null) {
   //        return bookingHomePage = new BookingHomePage(driver);
   //     } else {
   //         return bookingHomePage;
   //     }


    }
}
                //ternary operator
                ;

//porządkowanie: CTRL ALT L