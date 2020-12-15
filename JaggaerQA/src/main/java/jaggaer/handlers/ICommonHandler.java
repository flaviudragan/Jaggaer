package jaggaer.handlers;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public interface ICommonHandler {
    static void Driver(){
        return;
    };

    Actions Actions();

    WebDriverWait Wait();

}
