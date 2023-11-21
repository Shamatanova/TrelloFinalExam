package test.cases.bing;

import com.telerikacademy.testframework.UserActions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    UserActions actions = new UserActions();

    @BeforeAll
    public static void setUp() {
        UserActions.loadBrowser("bing.homePage");
    }

    @AfterAll
    public static void tearDown() {
        UserActions.quitDriver();
    }
}
