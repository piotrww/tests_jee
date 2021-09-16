package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Integer.parseInt;

public class BookingHomePage extends BasePage {


    @FindBy(css = ".bui-alert__title")
    private WebElement loginButtonBooking; //deklaracja zmiennej, ale skoro jest jest FindBy, to jest inicjalizacja. To jest to samo, co "WebElement loginButtonBooking = driver.findElement(By.css(".bui-alert__title"))


 //    private WebElement mojElement =  driver.findElement(By.cssSelector(".bui-alert__title")); // odpowiednik wiersza 17, 18.

    @FindBy(css = ".bui-avatar-block")
    private WebElement userButton;

    @FindBy(css = ".bui-dropdown-menu__text")
    List<WebElement> userMenuTexts;

    @FindBy(css = ".bui-alert")
    private WebElement divBelt;

    @FindBy(css = "div.bui-alert p.bui-alert__text:nth-child(2)")
    private WebElement divExtraAlertContent;

    @FindBy(css = "div.bui-alert p.bui-alert__text:nth-child(2)")
    private WebElement divExtraAlertLinkToMore;

    @FindBy(css = " p:nth-child(3) > a")
    private WebElement extraAlertLinkMore;

    @FindBy(css ="span.bui-alert__title")
    private WebElement divAlert;

    @FindBy(css =".unified-postcard__header > p")
    private List<WebElement> propertiesInCities;

    @FindBy(css = "li.bui-tab__item:nth-child(3)")
    private WebElement carHireLink;

    @FindBy(id = "ss") //zamiast xpath i css
    private WebElement inputHotelLocation;

    @FindBy(css = ".sb-searchbox__button")
    private WebElement findButton;

    @FindBy(xpath = "//*[@id='b2indexPage']/header/nav[2]/ul/li[2]")
    private WebElement flightsButton;




//
//    @FindBy(xpath = "//button[@class='sb-searchbox__button '")
//    WebElement findStaysInSelectedDays;





    @FindBy(css = ".roomPrice .bui-price-display__value")
    List<WebElement> allPricesSortAsc;





//private String x;


    public BookingHomePage(WebDriver driver) {
        super(driver);
    }


    public void getNumberOfProperties() {

        for (WebElement eachProp :   propertiesInCities) {
            System.out.println(eachProp.getText());
            String eachPropText = eachProp.getText();

            String eachPropTextToCut = eachPropText;
            String eachPropTextToCutNoSpace = eachPropTextToCut.replaceAll("\\D+", "");
            System.out.println(eachPropTextToCutNoSpace);

            //    int indexOfFirstLetter = eachPropText.indexOf('o');

            int stringToInt = parseInt(eachPropTextToCutNoSpace);
            System.out.println(stringToInt);

            if (stringToInt > 100000 || stringToInt < 1) {

                System.out.println("value " + stringToInt + " is inproper");
            //    return false;
            } else {
                System.out.println("value " + stringToInt + " is proper");

             //   return true;

            }

//            int i = Integer.parseInt(s);
            //   System.out.println(stringToInt);


            //     System.out.println("number:-->" + numberInInt +"each " + eachPropText);


            //      System.out.println(indexOfFirstLetter);


        }


    }


        public String getBarText() {
        System.out.println("Funkcja w klasie: " + loginButtonBooking.getText());
        // System.out.println("Zmienna: " + BarText);
        return loginButtonBooking.getText();
    }

    public String getColorCode() {

        System.out.println("Colour CSS: " + divBelt.getCssValue("color"));
        return divBelt.getCssValue("color");

    }

    public int getNumberOfCharactersInAlert() {
        loginButtonBooking.click();
        String textOfExtraDiv = divExtraAlertContent.getText();
        System.out.println("Taken content: " + textOfExtraDiv);
//To LoginTest
        int numberOfCharacters = textOfExtraDiv.length();
        System.out.println("Liczba znaków: " + numberOfCharacters);

        if (numberOfCharacters > 20 && numberOfCharacters < 320) {
            System.out.println("Number of characters: " + numberOfCharacters + " is correct, in proper scope");
        } else {
            System.out.println("Number of characters: " + numberOfCharacters + " is incorrect");
        }


        return numberOfCharacters;


    }

    public int checkSizeofAlertDiv() {

        int x = divAlert.getSize().getHeight();
        System.out.println(x);
        divAlert.click();
        int y = divAlert.getSize().getHeight();
        divAlert.click();
        int z = divAlert.getSize().getHeight();

        System.out.println("x " + x + "y " + y + "z " + z);

         return x;
     //   return divAlert.getSize();


    };

public HotelLocationResultPage enterHotelLocationRepaired() {
    inputHotelLocation.sendKeys("Sopot");
    findButton.click();
    return new HotelLocationResultPage(driver);


}

    public FlyPageList goToFlightsPage() {

        flightsButton.click();

        return new FlyPageList(driver);


    }








        public String getMoreText() {


           System.out.println(extraAlertLinkMore.getAttribute("href"));


           return extraAlertLinkMore.getAttribute("href");

        }







//!!!        Do rozpisania sprawdzenie, czy link jest aktywny.
//        Cos z tego: https://stackoverflow.com/questions/6509628/how-to-get-http-response-code-using-selenium-webdriver
      //  divExtraAlertLinkToMore.getSize();

     //   System.out.println(divExtraAlertLinkToMore.getAttribute("class").contains("active"));
     //   System.out.println(divExtraAlertLinkToMore.getAttribute("href"));










          //  return TextOfExtraDiv;
        //    System.out.println("Colour CSS: " + divBelt.getCssValue("color"));
        //   return divBelt.getCssValue("color");








    public void ClickAndGetUserDock() {
        userButton.click();

        for (WebElement userMenuUnitText : userMenuTexts ) {
            System.out.println(userMenuUnitText.getText());
        }



    }

    public CarHirePage goToCarHirePage() { //Typ zwracany = klasa.

        carHireLink.click();

        return new CarHirePage(driver); //Nowa instancja klasy CarHirePage.

    }

    public FlyPageList clickFlightButton() throws InterruptedException {
        flightsButton.click();
        return new FlyPageList(driver);


    }






}


    //button_zaloguj

  //  logo_booking





