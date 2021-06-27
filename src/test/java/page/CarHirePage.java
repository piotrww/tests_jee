package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CarHirePage extends BasePage {

    @FindBy(css = "li.bui-tab__item:nth-child(3)")
    private WebElement carHireLink;

    @FindBy(css = "h1 > span")
    private WebElement carHireHeader;


    public String getTextOfCarHireButton() {

        return carHireHeader.getText();
    }







//Konstruktor --->
    public CarHirePage(WebDriver driver) {
        super(driver);
    }
}
