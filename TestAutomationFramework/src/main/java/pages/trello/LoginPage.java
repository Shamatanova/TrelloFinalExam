package pages.trello;

import com.telerikacademy.testframework.pages.BasePage;
import org.openqa.selenium.WebDriver;

import static com.telerikacademy.testframework.Utils.getConfigPropertyByKey;
import static pages.trello.Constants.*;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver, LOGIN_PAGE);
    }

    public void loginUser(String username, String password) {

        actions.waitForElementClickable(USERNAME_FIELD);
        actions.clearValueInField(USERNAME_FIELD);
        actions.typeValueInField(getConfigPropertyByKey(username), USERNAME_FIELD);
        actions.waitForElementClickable(SUBMIT_BUTTON);
        actions.clickElement(SUBMIT_BUTTON);

        actions.waitForElementClickable(PASSWORD_FIELD);
        actions.clearValueInField(PASSWORD_FIELD);
        actions.typeValueInField(getConfigPropertyByKey(password), PASSWORD_FIELD);
        actions.waitForElementClickable(LOGIN_BUTTON_LOGIN_PAGE);
        actions.clickElement(LOGIN_BUTTON_LOGIN_PAGE);
    }
}
