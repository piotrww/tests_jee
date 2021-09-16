package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;




public class FlyPageList extends BookingHomePage {

    @FindBy(xpath = "//ul/li[2]//div[2]/div")
    private WebElement radioOneWay;


    @FindBy(css = "div.css-k008qs")
    private WebElement inputDepartureButton;


    @FindBy(css = "div.css-1eii3rq")
    private WebElement defaultDepartureAirportClose;

    @FindBy(css = "input.css-156s1eu")
    private WebElement inputDepartureCity;

    @FindBy(css = ".css-1tli02a-autocompleteResults")
    private WebElement headerOfFlightsPage;

    @FindBy(css = ".css-156s1eu")
    private WebElement inputDestinationCity;

    @FindBy(css = ".css-qqvbcw:first-child div.css-2r1cd1")
    private WebElement checkDestinationCity;

    @FindBy(xpath = "//div[2]/table/tbody/tr[1]/td[7]")
    private WebElement calendarFlyDate;

    @FindBy(css = ".css-ya5gr9")
    private WebElement findButton;



    public FlyPageList clickRadioOneWay() {
        radioOneWay.click();
        return this;
    }
    public FlyPageList clickInputDeparture() {
        inputDepartureButton.click();
        return this;
    }

    public FlyPageList closeDefaultDeparture() {
        defaultDepartureAirportClose.click();
        return this;
    }

    public FlyPageList inputDepartureCity() throws InterruptedException {
        inputDepartureCity.sendKeys("OPO");
        Thread.sleep(4000);
        headerOfFlightsPage.click();

        return this;
    }


    public FlyPageList inputDestinationCity() throws InterruptedException {
        inputDestinationCity.click();
        Thread.sleep(3000);
        inputDestinationCity.sendKeys("POD");
        checkDestinationCity.click();

        return this;

    }
    public FlyPageList selectFlightsDate() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 400)");

        calendarFlyDate.click();

        return this;

    }




    public FlightsListResult clickFind() {
        findButton.click();
        return new FlightsListResult(driver);


    }





    public FlyPageList(WebDriver driver) {
        super(driver);
    }

    //defaultDepartureAirportClose.click();



}
