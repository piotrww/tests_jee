package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import page.BookingHomePage;
import page.BookingHomePagesSectionTwo;
import page.GoToGatePage;
import page.PageObjectManager;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Login2test {

    private WebDriver driver; //deklaracja zmiennej

    private PageObjectManager pageObjectManager;



    @Before // one
    public void setUp() {

        System.setProperty("webdriver.gecko.driver", "C:\\Piotr_\\automation_tests\\firefox\\geckodriver.exe"); //Zmienna środowiskowa, tu jest driver
        driver = new FirefoxDriver(); //Zaimportowana klasa FirefoxDriver, stworzenie obiektu, otwarcie przeglądarki.

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //Dwa rodzaje waitów: impicitlyWait oraz expliticWait.
        driver.manage().window().maximize();
        driver.get("https://booking.com/");
        // driver.get("https://demoqa.com/browser-windows");

        pageObjectManager = new PageObjectManager(driver);
    }


    @Test

    public void checkTextOfTheBar() {
        assertEquals(pageObjectManager.getBookingHomePage().getBarText(), "Koronawirus (COVID-19) – wsparcie"); //obiekt, stworzony w 39 wierszu
    }

    @Test
    public void checkColorOfBackground() {
        String colorCode = pageObjectManager.getBookingHomePage().getColorCode();
        System.out.println("Kolor div pobrany w metodzie (teście LoginTest): " + colorCode);
        assertEquals(colorCode, "rgb(51, 51, 51)");
    }

    @Test
    public void getTextOfExtraAlert() {

//        BookingHomePage bookingHomePage = new BookingHomePage(driver);
//        bookingHomePage.getNumberOfCharactersInAlert();
        //  System.out.println("Extra text: " + " " + bookingHomePage.clickAndGetExtraAlertText());

//        if (numberOfCharacters > 20 && numberOfCharacters < 320) {
//            System.out.println("Number of characters is correct");
//        }

        System.out.println(pageObjectManager.getBookingHomePage().getNumberOfCharactersInAlert() > 20 ? "Number of characters is correct" : "Incorrect");
    }

    @Test
    public void checkIfMoreIsLink() {

        assertTrue(pageObjectManager.getBookingHomePage().getMoreText().contains("booking.com/"));



//        BookingHomePage bookingHomePage = new BookingHomePage(driver);
//        bookingHomePage.getMoreText();
//        //  System.out.println("Extra text: " + " " + bookingHomePage.clickAndGetExtraAlertText());
//
//        assertTrue(bookingHomePage.getMoreText().contains("booking.com/"));


    }

    @Test
    public void checkSizeofAlertDiv() {
       int x =  pageObjectManager.getBookingHomePage().checkSizeofAlertDiv();
      //       BookingHomePage bookingHomePage = new BookingHomePage(driver);
     //     bookingHomePage.checkSizeofAlertDiv();

        if(x>5 && x<15) {
            System.out.println("Size of font is correct");
        } else {
            Assert.fail();
        }

    }

    @Test
    public void checkIfIfGreyBeltCalendar() {
        BookingHomePagesSectionTwo bookingHomePagesSectionTwo = new BookingHomePagesSectionTwo(driver);

        String greyh1 = bookingHomePagesSectionTwo.greyTimeBelt();
        assertTrue(greyh1.contains("wielu innych obiektów"));

    }

    @Test
    public void clickAndCheckText() {

        assertEquals("bui-alert__description js-coronavirus-banner", new BookingHomePagesSectionTwo(driver).beltAlertContent());

//Najlepsza, ale można jak w wierszach 88-89.
    }

    @Test
    public void noClickAndCheckText() {
        assertEquals("bui-alert__description js-coronavirus-banner is-collapsed", new BookingHomePagesSectionTwo(driver).beltNoClickAlertContent());
    }

    @Test
    public void checkAndClick() {
        assertEquals("bui-alert__description js-coronavirus-banner", new BookingHomePagesSectionTwo(driver).beltNoClickAlertContent2(true));
    }

    @Test
    public void checkAndClick2() {
        assertEquals("bui-alert__description js-coronavirus-banner", new BookingHomePagesSectionTwo(driver).beltNoClickAlertContent2(false));
    }


    @Test
    public void checkIfGreyBeltCalendarSize() {
        BookingHomePagesSectionTwo bookingHomePagesSectionTwo = new BookingHomePagesSectionTwo(driver);
        String greyh1Size = bookingHomePagesSectionTwo.greyTimeBeltH1Size();
        System.out.println(greyh1Size);
        assertEquals("24px", greyh1Size);

    }

    @Test
    public void flyAway() { //Z chainingiem
        BookingHomePagesSectionTwo bookingHomePagesSectionTwo = new BookingHomePagesSectionTwo(driver);
        String textNextPage = bookingHomePagesSectionTwo.goToFlyAway().flyAwayGetText(); //Metody void (nie zmieniają stanu page np. kliknij i rozwiń listę, zaznacz checkbox). Chaining porządkuje kod.
        //metoda gotoFlyAway() wywołujemy, potem wywołuje się kolejna
        System.out.println(textNextPage);
        Assert.assertEquals("Porównaj loty 650 linii lotniczych", textNextPage);

    }

    @Test
    public void flyAway2() { //Bez chainingu
        BookingHomePagesSectionTwo bookingHomePagesSectionTwo = new BookingHomePagesSectionTwo(driver);
        GoToGatePage goToGatePage = new GoToGatePage(driver); // to samo co w goToFlyAway() w 129 linii

        bookingHomePagesSectionTwo.goToFlyAway();
        String textNextPage = goToGatePage.flyAwayGetText();

        System.out.println(textNextPage);
        Assert.assertEquals("Porównaj loty 650 linii lotniczych", textNextPage);

    }


    @Test
    public void clickAndCheckFlagPopup() {
        BookingHomePagesSectionTwo bookingHomePagesSectionTwo = new BookingHomePagesSectionTwo(driver);
        String headerFLags = bookingHomePagesSectionTwo.clickAndCheckFlag();
        //  System.out.println(headerFLags);
        //    Assert.assertEquals("fdss", headerFLags);


    }

    @Test
    public void checkNumberOfPropertiesInCity() {
        pageObjectManager.getBookingHomePage().getNumberOfProperties();

     //   BookingHomePage bookingHomePage = new BookingHomePage(driver);
    //    bookingHomePage.getNumberOfProperties();
    }



    @Test
    public void gotoCarHireWithChaining() {
        String textOfCarHirePageHeader = pageObjectManager.getBookingHomePage().goToCarHirePage().getTextOfCarHireButton();
        
       // String textOfCarHirePageHeader = bookingHomePage.goToCarHirePage().getTextOfCarHireButton();
        System.out.println(textOfCarHirePageHeader);
        Assert.assertEquals("Wynajem samochodu na każdy rodzaj podróży", textOfCarHirePageHeader);

    }




    @Test
    public void find3CheapOffers() {


    }


}



//    @Test
//    public void checkIfGreyBeltCalendarMonth() {
//        BookingHomePagesSectionTwo bookingHomePagesSectionTwo = new BookingHomePagesSectionTwo(driver);
//        System.out.println(bookingHomePagesSectionTwo.greyTimeBeltH1Calendar(
//
//
//    }





//////////////////////////

// String myEmail = "piotr.warsza@kantar.com";

//    HomePage homePage = new HomePage(driver); //Nowy obiekt typu homepage, konstruktor ma jeden argument: driver. Typ (klasa) HomePage.
//   homePage.clickLoginButton();

//   System.out.println(homePage);

//     LoginInputEmailPage loginInputEmailPage = new LoginInputEmailPage(driver);
//   loginInputEmailPage.fillInputEmail(myEmail);

//   loginInputEmailPage.clickGoButton();


// Można też prościej, szybciej: new HomePage(driver).clickLoginButton();




//   @Test
//    public void carTest() {
//   //     new Car().printOutsideConstructor();
//
//       Car myCar = new Car();
//      myCar.printOutsideConstructor();
//   }










