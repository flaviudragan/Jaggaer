package jaggaer.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;

public class DashboardPageElements extends BasePageElements {
    @FindBy(partialLinkText = "Recommendation Rules (SSO)")
    private WebElement ssoLink;

    @FindBy(className = "cls-1")
    private WebElement profileButton;

    @FindBy(partialLinkText = "Logout")
    private WebElement logoutButton;

    public DashboardPageElements() throws IOException {
    }

    public WebElement getSSOLink() {
        return wait.until(ExpectedConditions.visibilityOf(ssoLink));
    }


}
