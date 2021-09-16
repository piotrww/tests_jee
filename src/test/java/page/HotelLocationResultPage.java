package page;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;

import static java.lang.Integer.parseInt;


public class HotelLocationResultPage extends BookingHomePage{


    @FindBy(xpath = "//div[2]/table/tbody/tr[1]/td[7]") //tak skonstuować element, aby wpisać data-data
    private WebElement calendarStayDateStart;

    @FindBy(css = "button#onetrust-accept-btn-handler")
    private WebElement policyWarningButtonToClose;

    @FindBy(css = "button.sb-searchbox__button ")
    private WebElement findStaysInSelectedDays;

    @FindBy(css = "a .sr-hotel__name")
    private List<WebElement> NamesofThreeCheapestStays;

    @FindBy(xpath = "//a[@data-type='price']")
    private WebElement buttonSortByPrice;





    public HotelLocationResultPage(WebDriver driver) {
        super(driver);
    }


    public HotelLocationResultPage chooseStayDateCheckIn() {


        // System.out.println(calendarStayDateStart.getText());

        calendarStayDateStart.click();

        policyWarningButtonToClose.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(550,550)"); //Scroll down to find calendar

        findStaysInSelectedDays.click();

        return this; //ten obiekt zwracam
    }

    public HotelLocationResultPage sortByPrice() {
        buttonSortByPrice.click();
        return this;
    }



    public List<Integer> getSortedPrice() {

        WebDriverWait wait = new WebDriverWait(driver, 10);
                wait.until(ExpectedConditions.attributeToBe());
        


        List<Integer> top10CheapOffers = new ArrayList<>();
        for (int i=0; i<10; i++)      {
//            System.out.println(allPricesSortAsc.get(i).getText());

            int locationOfSpaceInPrice = allPricesSortAsc.get(i).getText().indexOf(" ");

            int priceCutFromString = parseInt(allPricesSortAsc.get(i).getText().substring(0,locationOfSpaceInPrice));
            System.out.println(priceCutFromString);
            top10CheapOffers.add(priceCutFromString);
        }

        System.out.println(top10CheapOffers);

        return top10CheapOffers;


    }

    public List<String> getNamesOfThreeCheapest() throws InterruptedException { //Próbowałem dodać to, ale nie wiem, czy to w ramach tego samego testu?
        Thread.sleep(4000);
        List<String> NamesofThreeCheapestStaysToList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            System.out.println(NamesofThreeCheapestStays.get(i).getText());
            NamesofThreeCheapestStaysToList.add(NamesofThreeCheapestStays.get(i).getText());
        }
        System.out.println(NamesofThreeCheapestStaysToList);

        for (int i = 0; i < 3; i++) {

            System.out.println(NamesofThreeCheapestStaysToList.get(i));
        }

        return NamesofThreeCheapestStaysToList;
    }





}