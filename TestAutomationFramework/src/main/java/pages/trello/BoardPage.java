package pages.trello;

import com.telerikacademy.testframework.pages.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import static pages.trello.Constants.*;

public class BoardPage extends BasePage {
    public BoardPage(WebDriver driver) {
        super(driver, BOARD_PAGE);
    }

    public void assertCurrentTitleIsCreated(String boardTitle){
        actions.waitForElementVisible(ALL_BOARDS_TITLES);
        actions.assertElementPresent(ALL_BOARDS_TITLES);

        actions.clickElement(CURRENT_BOARD_TITLE, boardTitle);
        actions.assertElementPresent(CURRENT_BOARD_TITLE, boardTitle);
    }

    public void assertBoardVisible() {
        actions.waitForElementVisible(ALL_BOARDS_TITLES);
        actions.assertElementPresent(ALL_BOARDS_TITLES);
    }
}
