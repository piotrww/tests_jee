package page;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;


public class HotelLocationResultPage extends BookingHomePage {


    @FindBy(xpath = "//div[2]/table/tbody/tr[1]/td[7]") //tak skonstuować element, aby wpisać data-data
    private WebElement calendarStayDateStart;

    @FindBy(css = "button#onetrust-accept-btn-handler")
    private WebElement policyWarningButtonToClose;

    @FindBy(css = ".sb-searchbox__button ")
    private WebElement searchButton;

    @FindBy(css = ".bui-calendar__content")
    private WebElement calendarTitleWithStayingDays;

    @FindBy(xpath = "//a[@data-type='price']")
    private WebElement buttonSortByPrice;

    @FindBy(css = "div.sr_item")
    private List<WebElement> NumberOfHotelsDivs;

    @FindBy(css = ".c-sr_alternative_dates__item__price")
    private WebElement priceInBox;

    @FindBy(xpath = "//*[@id='right']//div[2]/div/span/div[2])")
    private WebElement BoxTextPriceFrom;


    private final WebDriverWait wait = new WebDriverWait(driver, 10); //private final


    public HotelLocationResultPage(WebDriver driver) {
        super(driver);
    }


    public HotelLocationResultPage chooseStayDateCheckIn() {
        policyWarningButtonToClose.click(); //CTRL ALT arrow-up/down
        System.out.println("warning clicked"); //JAK ZADZIAla - wywal!!
        wait.until(ExpectedConditions.visibilityOf(calendarStayDateStart));

        calendarStayDateStart.click();
        System.out.println("start date selected");

        searchButton.click();
        System.out.println("hotel loca");
        return this; //ten obiekt zwracam
    }

    public List<Integer> sortByPrice() { //ALT + ENTER to remove

        buttonSortByPrice.click(); //porządkowanie CTRL ALT L
        System.out.println("sorted");
        buttonSortByPrice.click();
        System.out.println("clicked again"); // otherwise first brick were selected

        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(By.xpath("//a[@data-testid='list-item'][1]"), "")));
        List<Integer> top10CheapOffers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            System.out.println(allPricesSortAsc.get(i).getText());

            int locationOfSpaceInPrice = allPricesSortAsc.get(i).getText().indexOf(" ");

            int priceCutFromString = parseInt(allPricesSortAsc.get(i).getText().substring(0, locationOfSpaceInPrice));
            System.out.println(priceCutFromString);
            top10CheapOffers.add(priceCutFromString);
            System.out.println(top10CheapOffers);
        }
        return top10CheapOffers;
    }
}