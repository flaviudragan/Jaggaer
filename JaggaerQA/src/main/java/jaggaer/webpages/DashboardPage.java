package jaggaer.webpages;

import jaggaer.ui.DashboardPageElements;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class DashboardPage extends DashboardPageElements {


    public DashboardPage() throws IOException {
        PageFactory.initElements(Driver(), this);
    }

    public boolean clickSSOLinkOnDashboard() {
        waitForPageToLoad(10);
        scrollDownTheCurrentPage(String.valueOf(1000));
        clickLink(getSSOLink());

        return true;
    }
}
