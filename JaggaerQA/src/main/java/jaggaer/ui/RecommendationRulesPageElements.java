package jaggaer.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;

public class RecommendationRulesPageElements extends BasePageElements {
    @FindBy(className = "p4t-text-truncation header-text")
    private WebElement title;

    public RecommendationRulesPageElements() throws IOException {
    }

    public WebElement getTitle() {
        return wait.until(ExpectedConditions.visibilityOf(title));
    }
}
