package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

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
    List<WebElement> propertiesInCities;

    @FindBy(css = "li.bui-tab__item:nth-child(3)")
    private WebElement carHireLink;



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

            int stringToInt = Integer.parseInt(eachPropTextToCutNoSpace);
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

    public String clickAndGetExtraAlertText() {
        loginButtonBooking.click();
        String TextOfExtraDiv = divExtraAlertContent.getText();
        System.out.println("Taken content: " + TextOfExtraDiv);
//To LoginTest
        int numberOfCharacters = TextOfExtraDiv.length();
        System.out.println("Liczba znaków: " + numberOfCharacters);

        if (numberOfCharacters > 20 && numberOfCharacters < 320) {
            System.out.println("Number of characters: " + numberOfCharacters + " is correct, in proper scope");
        } else {
            System.out.println("Number of characters: " + numberOfCharacters + " is incorrect");
        }


        return TextOfExtraDiv;


    }

    public Integer checkSizeofAlertDiv() {

       Integer x = divAlert.getSize().getHeight();
        System.out.println(x);
        divAlert.click();
        Integer y = divAlert.getSize().getHeight();
        divAlert.click();
        Integer z = divAlert.getSize().getHeight();

        System.out.println("x " + x + "y " + y + "z " + z);

         return x;
     //   return divAlert.getSize();


    };





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






}


    //button_zaloguj

  //  logo_booking





