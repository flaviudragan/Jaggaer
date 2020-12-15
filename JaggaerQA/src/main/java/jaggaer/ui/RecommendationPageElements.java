package jaggaer.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;

public class RecommendationPageElements extends BasePageElements {
    /*@FindBy(className = "full-header-titel")
    private WebElement title;*/

    @FindBy(partialLinkText = "Recommendation Rules")
    private WebElement recommendationRulesLink;

    public RecommendationPageElements() throws IOException {
    }

    /*public WebElement getTitle() {
        return wait.until(ExpectedConditions.visibilityOf(title.findElement(By.id("header-title-truncation"))));
    }*/

    public WebElement getRecommendationRulesLink() {
        return wait.until(ExpectedConditions.visibilityOf(recommendationRulesLink.findElement(By.cssSelector("nth-child(2)"))));
    }

}
