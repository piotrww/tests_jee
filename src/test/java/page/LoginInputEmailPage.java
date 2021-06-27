package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginInputEmailPage extends BasePage{


    @FindBy(xpath = "//input[@type='email']")
    private WebElement inputEmail;


    @FindBy(xpath = "//input[@value='Dalej']")
    private WebElement goButton;

    public LoginInputEmailPage(WebDriver driver) {
        super(driver);
    }

    public void fillInputEmail(String myEmailToLogin){
        inputEmail.sendKeys(myEmailToLogin);
    }

    public void clickGoButton() {
        goButton.click();
    }


}
