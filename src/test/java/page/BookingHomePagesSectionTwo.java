package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

public class BookingHomePagesSectionTwo extends BasePage {

    @FindBy(css = "h1")
    private WebElement greyText;

    @FindBy(xpath = "//span[@class='bui-alert__title js-coronavirus-banner-collapse-button']")
    private WebElement beltToClick;

    @FindBy(xpath = "//span[@class='bui-alert__title js-coronavirus-banner-collapse-button']/parent::div")
    private WebElement beltToClickParent;

    @FindBy(xpath = "//*[@id='b2indexPage']/header/nav[2]/ul/li[2]/a/span[2]")
    private WebElement flyAwayButton;

    @FindBy(css = ".uwtTrustUsp:first-child")
    private WebElement nextPageLink;

    @FindBy(xpath = "//*[@class='bui-avatar__image']")
    private WebElement flagImgButton;

    @FindBy(xpath = "//h2[@class='bui-modal__title']")
    private WebElement headerFlagsPupup;

    @FindBy(xpath = "//span[@class='bui-button__icon']")
    private WebElement questionMarkIcon;

    @FindBy(xpath = "//div[@class='xp__dates-inner xp__dates__checkin']")
    private WebElement calendarCheckIn;


    @FindBy(xpath = "//div[@class='bui-inline-container__main'][1]")
    private WebElement firstFlag;

    @FindBy(xpath = "//button[@id='windowButton']")
    private WebElement DemoQaButtonNewWindow;



    public String greyTimeBelt() {
        System.out.println("Test");
        System.out.println(greyText.getText());
        return greyText.getText();
    }

    public String greyTimeBeltH1Size() {
        System.out.println("Test");
        System.out.println(greyText.getCssValue("font-size"));
        return greyText.getCssValue("font-size");
    }


    public String beltAlertContent() {
        beltToClick.click();
        return beltToClickParent.getAttribute("class"); //dłuższa wersja poniżej.
    }

    public String beltNoClickAlertContent() {

        return beltToClickParent.getAttribute("class"); //dłuższa wersja poniżej.
    }

    public String beltNoClickAlertContent2(boolean shouldClick) {

        if (shouldClick) {
            beltToClick.click();
        }
        return beltToClickParent.getAttribute("class");

    }

    public GoToGatePage goToFlyAway() { //Typ zwracany = klasa.


        flyAwayButton.click();

        return new GoToGatePage(driver); //Nowa instancja gotogate.

    }





    public String clickAndCheckFlag() {


        String mainHandle = driver.getWindowHandle(); // Jestem na głownej stronie. Pobieram string/id okna, w któym jestem.
        System.out.println("mainHandle: " + mainHandle);

       // JavascriptExecutor js = (JavascriptExecutor) driver;
       // js.executeScript("window.scrollBy(0, 250)");

        DemoQaButtonNewWindow.click(); //Klikam i przechodzę na nowe okno.
      //  flyAwayButton.click();
 //      flagImgButton.click();
//        questionMarkIcon.click();
      //  calendarCheckIn.click();
//        System.out.println("Header of flags: " + headerFlagsPupup.getText());

     //   System.out.println("First flag country: " + firstFlag.getText());

        Set<String> allHandles = driver.getWindowHandles(); // Lista bez duplikatów.
        driver.switchTo().window(new ArrayList<>(allHandles).get(1));  //  zamiast fora. Działa, gdy wiem, że jestem na tym 2. oknie.


        System.out.println(("Main Window ID: " + mainHandle));
        System.out.println("Moje strony: " + allHandles.size());


        for(String windowUnitHandle : allHandles) {

            if  (mainHandle.equals(windowUnitHandle)) {
                System.out.println("1:   " + windowUnitHandle + driver.getCurrentUrl() + driver.getTitle());
            } else {
                driver.switchTo().window(windowUnitHandle);
                System.out.println("2:   " + windowUnitHandle + driver.getCurrentUrl() + driver.getTitle());
            }
        }



         return headerFlagsPupup.getText();


    }


//    public String find3cheapHotels() {
//
//
//    }






//    public String beltAlertContent() {
//        beltToClick.click();
//        String attribute = beltToClickParent.getAttribute("class");
//        System.out.println(attribute);
//
//        return attribute;
//    }













    public BookingHomePagesSectionTwo(WebDriver driver) {
        super(driver);
    }
}
