package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightsListResult extends BookingHomePage  {

    public FlightsListResult(WebDriver driver) {
        super(driver);
    }


    @FindBy(css ="div.css-1wkbb1p-tab:nth-child(2)")
    private WebElement SortByPriceButton;

    @FindBy(xpath = "//div[@id='flightcard-0']//div[@class='Text-module__root--variant-headline_3___1j8Sc']")
    private WebElement firstPrice;


public FlightsListResult getCheapestFlights() throws InterruptedException {
    Thread.sleep(4000);
     JavascriptExecutor js = (JavascriptExecutor) driver;
     js.executeScript("window.scrollBy(0, 650)");

    SortByPriceButton.click();

    return this;

}

    public FlightsListResult getSmallestPrice() throws InterruptedException {
        Thread.sleep(4000);

        SortByPriceButton.click();

        return this;
        
        //.css-1niqckn > .css-yyi517 //All elements

    }

    public String getPriceValue() {
        String PriceValue = firstPrice.getText();
        System.out.println(PriceValue);

        return PriceValue;
    }





}
