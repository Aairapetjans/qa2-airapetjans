package pageobject;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pageobject.core.BaseFunc;
import pageobject.pages.HomePage;

public class TvNetArticleTests {
    private final String HOME_PAGE_URL = "http://tvnet.lv";
    private BaseFunc baseFunc;

    @BeforeEach
    public void openDriver() {
        BaseFunc baseFunc = new BaseFunc();
    }

    @Test
    public void titleAndCommentsCountCheck() {

        baseFunc.openUrl(HOME_PAGE_URL);
        HomePage homePage = new HomePage(baseFunc);
        //Accept cookies
        homePage.acceptCookies();
        //Get 3rd article title
        homePage.getArticleById(3);
        //Get 3rd article comments count

        //Open 3rd article

        //Get title

        //Get comments count

        //Compare titles

        //Compare comments counts

        //...


    }

    @AfterEach
    public void closeDriver() {
        baseFunc.closeDriver();
    }
}
