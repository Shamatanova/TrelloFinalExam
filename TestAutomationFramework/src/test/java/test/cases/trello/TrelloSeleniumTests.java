package test.cases.trello;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static pages.trello.Constants.*;

public class TrelloSeleniumTests extends BaseTest{

    @Test
    public void when_LoginWithValidUsernameAndValidPassword_expect_SuccessfullyLoginUser() {
        unauthenticatedPage.clickLogInButton();
        loginPage.loginUser(USERNAME, PASSWORD);

        boardsPage.assertNavigated();
    }
    @Test
    public void createBoardWhenCreateBoardClicked() {
        unauthenticatedPage.clickLogInButton();
        loginPage.loginUser(USERNAME, PASSWORD);
    }

    @Test
    public void createNewCardInExistingBoardWhenCreateCardClicked() {
        // API: Create a board
        // API: Create a list

        // API: Delete board
    }

    @Disabled
    @Test
    public void moveCardBetweenStatesWhenDragAndDropIsUsed() {
        // API: Create a board
        // API: Create a list

        // API: Delete board
    }

    @Disabled
    @Test
    public void deleteBoardWhenDeleteButtonIsClicked() {
        // API: Create a board

        // API: Delete board
    }
}
