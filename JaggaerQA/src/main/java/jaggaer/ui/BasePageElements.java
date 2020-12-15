package jaggaer.ui;

import jaggaer.handlers.CommonHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BasePageElements extends CommonHandler {
    public BasePageElements() throws IOException {
    }

    public static void clickLink(WebElement link) {
        wait.until(ExpectedConditions.visibilityOf(link));
        actions.moveToElement(link).build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(link));
        actions.click().build().perform();
    }

    public static void setSelectOption(WebElement dropdown, String option) {
        Select selectObj = new Select(dropdown);
        selectObj.selectByVisibleText(option);
    }

    public static List<String> getElementsText(By locator){

        List<WebElement> elems = driver.findElements(locator);
        List<String> elemTexts = new ArrayList<>();

        for(WebElement el : elems) {
            if(!el.getText().isEmpty()) {
                elemTexts.add(el.getText());
            }
        }
        return elemTexts;
    }

    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(driver, timeToWaitInSec);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForVisibilityExplicit(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForClickablility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            System.out.println("Waiting for page to load...");
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
            wait.until(expectation);
        } catch (Throwable error) {
            System.out.println(
                    "Timeout waiting for Page Load Request to complete after " + timeOutInSeconds + " seconds");
        }
    }

    public static void waitFor(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void switchToWindow() {
        String origin = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        driver.switchTo().window(origin);
    }

    public static List<String> listMaker(List<WebElement> list){
        List<String> ls=new ArrayList<>();
        for (WebElement element : list) {
            if(!element.getText().isEmpty()){
                ls.add(element.getText());
            }
        }
        return ls;
    }
    //select by desired option
    public static String dropDownSelect(WebElement element, String choosen){

        Select slc= new Select(element);
        List<String> ls= listMaker(slc.getOptions());
        slc.selectByVisibleText(choosen);

        return slc.getFirstSelectedOption().getText();
    }

    public static String dateModifier(LocalDateTime date , String format){
        DateTimeFormatter formatter= DateTimeFormatter.ofPattern ( format);
        return date.format(formatter);
    }

    public static void clickOnElement(WebElement webElement) {
        webElement.click();
    }

    public static void moveToElement(WebElement webElement) {
        actions.moveToElement(webElement).perform();
    }

    public static void selectWebElementByVisibleText(WebElement webElement, String visibleText) {
        Select selectWebElement = new Select(webElement);
        selectWebElement.selectByVisibleText(visibleText);
    }

    public static void freeze(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void scrollDownTheCurrentPage(String pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, "+ pixels +");");
    }

}
