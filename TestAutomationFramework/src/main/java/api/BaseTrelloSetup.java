package api;

import com.telerikacademy.testframework.PropertiesManager;

import static api.trello.utils.Endpoints.*;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class BaseTrelloSetup {



    private RequestSpecification getRestAssured() {
        return given()
                .contentType(ContentType.JSON)
                .log().all()
                .baseUri(PropertiesManager.PropertiesManagerEnum.INSTANCE.getConfigProperties()
                        .getProperty(BASE_URL))
                .queryParam("key", PropertiesManager.PropertiesManagerEnum.INSTANCE.getConfigProperties()
                        .getProperty(KEY))
                .queryParam("token", PropertiesManager.PropertiesManagerEnum.INSTANCE.getConfigProperties()
                        .getProperty(TOKEN));
    }

    // Authenticate
    public List<String> getUserBoards() {
        return getRestAssured()
                .get("/members/me")
                .thenReturn()
                .jsonPath()
                .get("idBoards");
    }

    // API: Create a board
    public Response createBoard(String name, String description) {
        return getRestAssured()
                .queryParam("name", name)
                .queryParam("desc", description)
                .when()
                .post(BOARDS_ENDPOINT)
                .then()
                .extract()
                .response();
    }

    public void deleteBoard(String boardId) {
        getRestAssured()
                .when()
                .delete(BOARDS_ENDPOINT + boardId)
                .then()
                .extract()
                .response();
    }

    public Response createList(String boardId, String name) {
        return getRestAssured()
                .when()
                .queryParam("name", name)
                .queryParam("idBoard", boardId)
                .post(LISTS_ENDPOINT)
                .then()
                .extract()
                .response();
    }

    public Response createCard(String listId, String name) {
        return getRestAssured()
                .when()
                .queryParam("name", name)
                .queryParam("idList", listId)
                .post("/cards")
                .then()
                .extract()
                .response();
    }

    // API: Create 2 lists

//    public List<Response> listOfBoards(int numberOfBoards){
//
//    }
    // API: Create a card

    //################## Assertions #######################

    public void assertStatusCode200(int statusCode) {
        Assertions.assertEquals(SC_OK, statusCode, "Status code is different. Expected 200.");
        System.out.println("Status code is 200.");
    }

    public void assertElementsAreEquals(String expectedName, String actualName) {
        Assertions.assertEquals(expectedName, actualName, "Expected board name is different.");
    }

    public void assertBoardDescription(String boardDescription, String actualDescription) {
        Assertions.assertEquals(boardDescription, actualDescription,
                "Expected board description is different than actual.");
    }
}