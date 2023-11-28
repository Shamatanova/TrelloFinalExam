package test.cases.trello;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static pages.trello.Constants.*;

public class TrelloSeleniumTests extends BaseTest{
    @Test
    public void when_LoginWithValidUsernameAndValidPassword_expect_SuccessfullyLoginUser() {
        boardsPage.assertNavigated();
        boardsPage.assertWorkspacesTitleIsVisible();
    }
    @Test
    public void when_CreateNewBoardWithValidTitle_expect_SuccessfullyCreatedNewBoard() {
        boardsPage.createNewBoard(NEW_BOARD_TITLE);
        boardPage.assertBoardVisible();
        boardPage.assertCurrentTitleIsCreated(NEW_BOARD_TITLE);

        boardPage.deleteBoard(NEW_BOARD_TITLE);
    }

    @Test
    public void createNewCardInExistingBoardWhenCreateCardClicked() {
        // API: Create a board
        // API: Create a list

        // API: Delete board
    }

    @Test
    public void moveCardBetweenStatesWhenDragAndDropIsUsed() {
        // API: Create a board
        boardsPage.createNewBoard(NEW_BOARD_TITLE);
        // API: Create a list

        // API: Delete board
    }

    @Test
    public void deleteBoardWhenDeleteButtonIsClicked() {
        // API: Create a board
        boardsPage.createNewBoard(NEW_BOARD_TITLE);
        boardPage.deleteBoard(NEW_BOARD_TITLE);
        boardPage.assertBoardIsDeleted();
        boardPage.assertCloseMessage(NEW_BOARD_TITLE);
        // API: Delete board
    }
}
