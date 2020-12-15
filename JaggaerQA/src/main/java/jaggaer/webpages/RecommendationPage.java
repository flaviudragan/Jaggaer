package jaggaer.webpages;

import jaggaer.ui.RecommendationPageElements;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class RecommendationPage extends RecommendationPageElements {


    public RecommendationPage() throws IOException {
        PageFactory.initElements(Driver(), this);
    }

    public boolean switchToRecommendationPage() {
        waitForPageToLoad(10);
        switchToWindow();
        waitForPageToLoad(10);
        return true;
    }

    public boolean clickRecommendationRulesLink() {
        waitForPageToLoad(10);
        clickLink(getRecommendationRulesLink());
        return true;
    }
}
