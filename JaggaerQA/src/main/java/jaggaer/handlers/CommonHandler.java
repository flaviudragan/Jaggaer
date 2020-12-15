package jaggaer.handlers;

import jaggaer.util.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class CommonHandler implements ICommonHandler{
    private static boolean setUpIsDone = false;

    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static Actions actions;

    public CommonHandler() throws IOException {

    }

    public static void initCommonHandler(){
        if (setUpIsDone==false){
            driver = DriverFactory.getDriver();
            wait = new WebDriverWait(Driver(), 30);
            actions = new Actions(Driver());
        }else{
            setUpIsDone = true;
        }
    }

    public static WebDriver Driver() {
        return driver;
    }

    public Actions Actions() { return actions; }

    public WebDriverWait Wait() {
        return wait;
    }

}
