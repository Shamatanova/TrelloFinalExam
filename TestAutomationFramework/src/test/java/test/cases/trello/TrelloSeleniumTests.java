package test.cases.trello;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static pages.trello.Constants.*;

public class TrelloSeleniumTests extends BaseTest {
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
    public void when_CreateNewListIntoTheBoardWithValidTitle_expect_SuccessfullyCreatedNewList() {
        boardsPage.createNewBoard(NEW_BOARD_TITLE);
        boardPage.createNewList(NEW_LIST_TITLE);

        boardPage.assertListIsVisible(NEW_LIST_TITLE, ALL_LISTS);
        boardPage.deleteBoard(NEW_BOARD_TITLE);
    }

    @Test
    public void when_CreateNewCardIntoTheListWithValidTitle_expect_SuccessfullyCreatedNewList() {
        boardsPage.createNewBoard(NEW_BOARD_TITLE);
        boardPage.createNewList(NEW_LIST_TITLE);
        boardPage.createNewCard(NEW_CARD_TITLE);
    }

    @Test
    public void moveCardBetweenStatesWhenDragAndDropIsUsed() {
        // API: Create a board
        boardsPage.createNewBoard(NEW_BOARD_TITLE);
        // API: Create a list

        // API: Delete board
    }

    @Disabled
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
