package jaggaer.webpages;

import jaggaer.ui.RecommendationRulesPageElements;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class RecommendationRulesPage extends RecommendationRulesPageElements {


    public RecommendationRulesPage() throws IOException {
        PageFactory.initElements(Driver(), this);
    }

    public boolean getPageTitle() {
        waitForPageToLoad(10);
        moveToElement(getTitle());
        return true;
    }

}
