package pages.trello;

import com.telerikacademy.testframework.pages.BasePage;
import org.openqa.selenium.WebDriver;

import static pages.trello.Constants.*;

public class UnauthenticatedPage extends BasePage {
    public UnauthenticatedPage(WebDriver driver) {
        super(driver, HOME_PAGE);
    }

    public void clickLogInButton(){
        actions.waitForElementClickable(LOGIN_BUTTON_HOME_PAGE);
        actions.clickElement(LOGIN_BUTTON_HOME_PAGE);
    }

}
