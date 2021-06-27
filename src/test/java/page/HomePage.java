package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//button[contains(text(),'Login')]")
    private WebElement loginButton;




    public HomePage(WebDriver driver) {
        super(driver);
    } //Po stworzeniu obiektu HomePage to inicjalizował webdrive i przekazuje do BasePage(rodzic)

    public void clickLoginButton() {
        loginButton.click();
    }



}
