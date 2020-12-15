package jaggaer.webpages;

import jaggaer.ui.LoginPageElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginPage extends LoginPageElements {
    WebDriver driver;

    public LoginPage() throws IOException {
        PageFactory.initElements(Driver(), this);
    }

    public boolean login(String userName, String pwd) {
        waitForPageToLoad(10);
        moveToElement(getUsername());
        getUsername().sendKeys(userName);

        moveToElement(getPassword());
        getPassword().sendKeys(pwd);

        clickOnElement(getLogin());
        return true;
    }
}
