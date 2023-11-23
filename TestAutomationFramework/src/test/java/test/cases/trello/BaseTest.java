package test.cases.trello;

import pages.trello.BoardsPage;
import pages.trello.LoginPage;
import pages.trello.UnauthenticatedPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;

import com.telerikacademy.testframework.UserActions;

import static pages.trello.Constants.*;

public class BaseTest {

    UserActions actions;
    BoardsPage boardsPage;
   // BoardPage boardPage;
    LoginPage loginPage;
    UnauthenticatedPage unauthenticatedPage;

    @BeforeEach
    public void setUp() {
        actions = new UserActions();

        boardsPage = new BoardsPage(actions.getDriver());
       // boardPage = new BoardPage(actions.getDriver());
        loginPage = new LoginPage(actions.getDriver());
        unauthenticatedPage = new UnauthenticatedPage(actions.getDriver());

        UserActions.loadBrowser(BASE_URL);
    }

    @AfterAll
    public static void tearDown() {
        UserActions.quitDriver();
    }


    //public void login() {

   // }
}