package pages.trello;

import com.telerikacademy.testframework.pages.BasePage;
import org.openqa.selenium.WebDriver;

import static com.telerikacademy.testframework.Utils.getConfigPropertyByKey;
import static com.telerikacademy.testframework.Utils.getUIMappingByKey;
import static pages.trello.Constants.*;

public class BoardsPage extends BasePage {
    public BoardsPage(WebDriver driver) {
        super(driver, BOARDS_PAGE);
    }

    public void assertNavigated(){
        var pageUrl = getConfigPropertyByKey(BASE_URL) + String.format(getConfigPropertyByKey(BOARDS_PAGE), getConfigPropertyByKey(USER_NAME));
        actions.waitForElementClickable(ACCOUNT_BUTTON);
        actions.assertUrlsAreEquals(pageUrl, driver.getCurrentUrl());
    }
}
