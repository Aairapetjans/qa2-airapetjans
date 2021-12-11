package homework1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class TvNetHM1 {

    private WebDriver driver;
    private WebDriverWait wait;
    private final String WEB_PAGE = "https://www.tvnet.lv/";
    private final By COOKIES_CLOSE_BUTTON = By.className("css-47sehv");
    private final By ARTICLE = By.xpath(".//article[@data-premium='0' and @class='list-article']");
    private final By ARTICLE_NAME_HOME_PAGE = By.xpath(".//span[@class='list-article__headline']");
    private final By COMMENT_COUNT_HOME_PAGE = By.xpath(".//span[@class='list-article__comment section-font-color']");
    private final By ARTICLE_TITLE_INNER_PAGES = By.tagName("h1");
    private final By COMMENT_COUNT_ARTICLE_PAGE = By.xpath(".//span[@class='article-share__item--count']");

    @BeforeEach
    public void openDriver() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get(WEB_PAGE);

        wait.until(presenceOfElementLocated(COOKIES_CLOSE_BUTTON));
        WebElement cookieCloseButton = driver.findElement(COOKIES_CLOSE_BUTTON);
        cookieCloseButton.click();
    }

    @Test
    public void tvNetHeaderTest() throws InterruptedException {
        List<WebElement> articles = driver.findElements(ARTICLE);
        WebElement homePageArticle = articles.get(1);
        String homePageArticleTitleFull = homePageArticle.findElement(ARTICLE_NAME_HOME_PAGE).getText();
        String homePageArticleTitle;

        int homePageCommentCount = 0;
        if (homePageArticleTitleFull.endsWith(")")) {
            homePageArticleTitle = homePageArticleTitleFull.substring(0, homePageArticleTitleFull.lastIndexOf(' '));
            String comments = homePageArticle.findElement(COMMENT_COUNT_HOME_PAGE).getText();
            homePageCommentCount = Integer.parseInt(comments.substring(1, comments.length() - 1));
        } else {
            homePageArticleTitle = homePageArticleTitleFull.trim();
        }

        homePageArticle.click();
        wait.until(presenceOfElementLocated(COOKIES_CLOSE_BUTTON));
        WebElement cookieCloseButton = driver.findElement(COOKIES_CLOSE_BUTTON);
        cookieCloseButton.click();

        String articlePageTitle = driver.findElement(ARTICLE_TITLE_INNER_PAGES).getText();
        int articlePageCommentCount = 0;
        try {
            articlePageCommentCount = Integer.parseInt(driver.findElement(COMMENT_COUNT_ARTICLE_PAGE).getText());
        } catch (Exception ignored) {
        }

        Assertions.assertEquals(homePageArticleTitle, articlePageTitle, "Titles are not the same!");
        Assertions.assertEquals(homePageCommentCount, articlePageCommentCount, "Comment count is not the same!");
    }

    @AfterEach
    public void closeDriver() {
        driver.quit();
    }
}
