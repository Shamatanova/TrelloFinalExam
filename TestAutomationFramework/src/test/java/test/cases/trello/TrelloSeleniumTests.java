package test.cases.trello;

import api.BaseTrelloSetup;
import io.restassured.response.Response;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pages.trello.BoardPage;
import pages.trello.BoardsPage;

public class TrelloSeleniumTests extends BaseTest{
    private BaseTrelloSetup trelloApi = new BaseTrelloSetup();
    private Response createdBoard;

//    @BeforeEach
//    public void beforeTest(){
//        createdBoard = trelloApi.createBoard("Board Name from API", "Description");
//    }
//
//    @AfterEach
//    public void afterTest(){
//        var deletionResponse = trelloApi.deleteBoard(String.valueOf(createdBoard));
//    }

    @Test
    public void createBoardWhenCreateBoardClicked() {
        login();

        BoardsPage boardsPage = new BoardsPage(actions.getDriver());
        boardsPage.createBoard();


        BoardPage boardPage = new BoardPage(actions.getDriver());
        boardPage.assertAddListExists();

        // API: Delete board
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
