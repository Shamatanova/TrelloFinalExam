package pages.trello;

import com.telerikacademy.testframework.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.telerikacademy.testframework.Utils.getConfigPropertyByKey;
import static com.telerikacademy.testframework.Utils.getUIMappingByKey;
import static pages.trello.Constants.*;

public class BoardPage extends BasePage {
    public BoardPage(WebDriver driver) {
        super(driver, BOARD_PAGE);
    }

    public void createNewList(String listTitle) {
        //   actions.waitForElementVisible(YOUR_BOARDS_LIST);
        actions.waitForElementPresent(YOUR_BOARDS_LIST);
        var boardList = actions.getElement(YOUR_BOARDS_LIST);
        var boards = boardList.findElements(By.xpath("//ul/div[2]/li"));

        if (boards.size() == 0) {
            actions.waitForElementClickable(ADD_ANOTHER_LIST_BUTTON_NEW);
            actions.clickElement(ADD_ANOTHER_LIST_BUTTON_NEW);
            actions.typeValueInField(listTitle, getConfigPropertyByKey(LAST_TITLE_LIST_FIELD));
            actions.clickElement(ADD_LIST_BUTTON);
        } else {
            actions.waitForElementClickable(ADD_ANOTHER_LIST_BUTTON);
            actions.clickElement(ADD_ANOTHER_LIST_BUTTON);
            actions.typeValueInField(listTitle, getConfigPropertyByKey(LAST_TITLE_LIST_FIELD));
            actions.clickElement(ADD_LIST_BUTTON);
        }
    }

    public void deleteBoard(String boardTitle) {
        actions.clickElement(CURRENT_BOARD_TITLE, boardTitle);
        actions.waitForElementClickable(BOARD_MENU_OPTIONS_BUTTON);
        actions.clickElement(BOARD_MENU_OPTIONS_BUTTON);
        actions.waitForElementClickable(BOARD_MENU_CLOSE_BOARD_BUTTON);
        actions.clickElement(BOARD_MENU_CLOSE_BOARD_BUTTON);
        actions.waitForElementClickable(BOARD_CLOSE_BUTTON);
        actions.clickElement(BOARD_CLOSE_BUTTON);
    }

    public void assertCurrentTitleIsCreated(String boardTitle) {
        actions.waitForElementVisible(ALL_BOARDS_TITLES);
        actions.assertElementPresent(ALL_BOARDS_TITLES);

        actions.clickElement(CURRENT_BOARD_TITLE, boardTitle);
        actions.assertElementPresent(CURRENT_BOARD_TITLE, boardTitle);
    }

    public void assertBoardVisible() {
        actions.waitForElementVisible(ALL_BOARDS_TITLES);
        actions.assertElementPresent(ALL_BOARDS_TITLES);
    }

    public void assertBoardIsDeleted() {
        actions.waitForElementVisible(REOPEN_BOARD_BUTTON);
        actions.assertElementPresent(REOPEN_BOARD_BUTTON);
        actions.assertElementPresent(CLOSE_BOARD_MESSAGE);
    }

    public void assertCloseMessage(String boardName) {
        var actualMessage = actions.getText(CLOSE_BOARD_MESSAGE);
        var expectedMessage = boardName + CLOSED_MESSAGE;
        actions.assertEquals(expectedMessage, actualMessage);
    }

    public void assertListIsVisible(String listName, String locator) {
        actions.getElements(locator);
    }
}
