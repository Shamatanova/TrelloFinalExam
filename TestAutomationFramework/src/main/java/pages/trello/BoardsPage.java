package pages.trello;

import com.telerikacademy.testframework.pages.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import static com.telerikacademy.testframework.Utils.getConfigPropertyByKey;
import static com.telerikacademy.testframework.Utils.getUIMappingByKey;
import static pages.trello.Constants.*;

public class BoardsPage extends BasePage {
    public BoardsPage(WebDriver driver) {
        super(driver, BOARDS_PAGE);
    }

    public void clickCreateBoardButton(String boardTitle) {
        actions.waitForElementClickable(CREATE_NEW_BOARD_BUTTON);
        actions.clickElement(CREATE_NEW_BOARD_BUTTON);
        actions.waitForElementVisible(CREATE_NEW_BOARD_POPUP);
        actions.waitForElementClickable(CREATE_BOARD_BUTTON);
        actions.clickElement(CREATE_BOARD_BUTTON);

        actions.waitForElementClickable(INPUT_BOARD_TITLE);
        actions.typeValueInField(boardTitle, getConfigPropertyByKey(INPUT_BOARD_TITLE));
        actions.waitForElementClickable(CREATE_BUTTON);
        actions.clickElement(CREATE_BUTTON);
    }

    public void assertNavigated() {
        var pageUrl = getConfigPropertyByKey(BASE_URL) + String.format(getConfigPropertyByKey(BOARDS_PAGE), getConfigPropertyByKey(USER_NAME));
        actions.waitForElementClickable(ACCOUNT_BUTTON);
        actions.assertUrlsAreEquals(pageUrl, driver.getCurrentUrl());
    }

    public void assertWorkspacesTitleIsVisible() {
        actions.waitForElementVisible(WORKSPACES_TITLE);
        actions.assertElementPresent(WORKSPACES_TITLE);
    }
}
