package jaggaer.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;

public class LoginPageElements extends BasePageElements {
    @FindBy(id="login")
    private WebElement username;

    @FindBy(id="password")
    private WebElement password;

    @FindBy(className="buttonDuplo")
    private WebElement login;

    public LoginPageElements() throws IOException {
    }


    public WebElement getLogin() {
        return wait.until(ExpectedConditions.visibilityOf(login));
    }

    public WebElement getPassword() {
        return wait.until(ExpectedConditions.visibilityOf(password));
    }

    public WebElement getUsername() {
        return wait.until(ExpectedConditions.elementToBeClickable(username));
    }
}
