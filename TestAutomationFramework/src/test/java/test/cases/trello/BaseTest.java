package test.cases.trello;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import pages.trello.LoginPage;

import com.telerikacademy.testframework.UserActions;

public class BaseTest {

    UserActions actions = new UserActions();

    @BeforeAll
    public static void setUp() {

        UserActions.loadBrowser("trello.homePage");
    }

    @AfterAll
    public static void tearDown() {

        UserActions.quitDriver();
    }

    public void login() {

        LoginPage loginPage = new LoginPage(actions.getDriver());
        loginPage.loginUser("user");
    }
}