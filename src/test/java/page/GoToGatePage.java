package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoToGatePage extends BasePage {

    //Elements


    @FindBy(css = "h1 span")
    private WebElement nextPageLink;





    public String flyAwayGetText() {

        return nextPageLink.getText();
    }



    public GoToGatePage(WebDriver driver) {
       super(driver);
    }

}
