package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginInputPasswordPage extends BasePage{


    @FindBy(name = "passwd")
    private WebElement passwordText;

    public LoginInputPasswordPage(WebDriver driver) {
        super(driver);
    }



}
