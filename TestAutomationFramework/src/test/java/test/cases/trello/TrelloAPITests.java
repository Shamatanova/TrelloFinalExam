package test.cases.trello;

import api.BaseTrelloSetup;
import api.trello.models.BoardModel;
import api.trello.models.CardModel;
import api.trello.models.ListModel;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static api.trello.utils.Constants.*;

public class TrelloAPITests {

    private final BaseTrelloSetup trelloApi = new BaseTrelloSetup();
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
    public void when_CreateNewBoardInExistingBoardWitValidListName_expect_SuccessfullyCreatedList() {
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
    @Test
    public void when_CreatedNewCardIntoTheListWithValidCardName_expect_SuccessfullyCreatedCard() {
        var newBoardModel = createdBoard.as(BoardModel.class);
        NEW_BOARD_ID = newBoardModel.id;

        var newList = trelloApi.createList(NEW_BOARD_ID, FIRST_LIST_NAME);
        var newListModel = newList.as(ListModel.class);
        FIRST_LIST_ID = newListModel.id;
        var card = trelloApi.createCard(FIRST_LIST_ID,CARD_NAME);
        var cardModel = card.as(CardModel.class);

        trelloApi.assertStatusCode200(card.statusCode());
        trelloApi.assertElementsAreEquals(CARD_NAME, cardModel.name);
        trelloApi.assertElementsAreEquals(cardModel.idList, FIRST_LIST_ID);
    }

    @Test
    public void when_moveCardBetweenTwoLists_expect_SuccessfullyChangedListId() {
        var newBoardModel = createdBoard.as(BoardModel.class);
        NEW_BOARD_ID = newBoardModel.id;

        var firstList = trelloApi.createList(NEW_BOARD_ID, FIRST_LIST_NAME);
        var firstListModel = firstList.as(ListModel.class);
        FIRST_LIST_ID = firstListModel.id;
        var secondList = trelloApi.createList(NEW_BOARD_ID, SECOND_LIST_NAME);
        var secondListModel = secondList.as(ListModel.class);
        SECOND_LIST_ID = secondListModel.id;
        var card = trelloApi.createCard(FIRST_LIST_ID,CARD_NAME);
        var cardModel = card.as(CardModel.class);

        var updateCard = trelloApi.moveCardBetweenTwoLists(cardModel.id, SECOND_LIST_ID);
        var updateCardModel = updateCard.as(CardModel.class);

        trelloApi.assertStatusCode200(updateCard.statusCode());
        trelloApi.assertElementsAreEquals(secondListModel.id, updateCardModel.idList);
    }
}
