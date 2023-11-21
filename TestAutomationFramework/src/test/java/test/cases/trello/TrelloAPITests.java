package test.cases.trello;

import api.BaseTrelloSetup;
import api.trello.models.BoardModel;
import api.trello.models.ListModel;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static api.trello.utils.Constants.*;

public class TrelloAPITests {

    private BaseTrelloSetup trelloApi = new BaseTrelloSetup();
    private Response createdBoard;

    @BeforeEach
    public void beforeTest(){
        createdBoard = trelloApi.createBoard(BOARD_NAME, BOARD_DESCRIPTION);
    }

    @AfterEach
    public void afterTest(){
        trelloApi.deleteBoard(NEW_BOARD_ID);
    }

    @Test
    public void when_CreateBoardWithValidNameAndDescription_expect_SuccessfullyCreatedBoard() {
        int statusCode = createdBoard.statusCode();
        var newBoardModel = createdBoard.as(BoardModel.class);
        NEW_BOARD_ID = newBoardModel.id;

        trelloApi.assertStatusCode200(statusCode);
        trelloApi.assertElementsAreEquals(BOARD_NAME, newBoardModel.name);
        trelloApi.assertBoardDescription(BOARD_DESCRIPTION, newBoardModel.desc);
    }

    @Test
    public void when_CreateNewCardInExistingBoardWitValidListName_expect_SuccessfullyCreatedList() {
        var newBoardModel = createdBoard.as(BoardModel.class);
        NEW_BOARD_ID = newBoardModel.id;

        var newList = trelloApi.createList(NEW_BOARD_ID, FIRST_LIST_NAME);
        int statusCode = newList.statusCode();
        var newListModel = newList.as(ListModel.class);
        FIRST_LIST_ID = newListModel.id;

        trelloApi.assertStatusCode200(statusCode);
        trelloApi.assertElementsAreEquals(FIRST_LIST_NAME, newListModel.name);
        trelloApi.assertElementsAreEquals(NEW_BOARD_ID, newListModel.idBoard);
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
