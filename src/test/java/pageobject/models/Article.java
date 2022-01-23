package pageobject.models;

import org.openqa.selenium.WebElement;

public class Article {
    private String title;
    private int commentsCount;
    private String imgUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(int commentsCount) {
        this.commentsCount = commentsCount;
    }

    public void setCommentsCount(WebElement commentsCount){
        String commentsToParse = commentsCount.getText(); // -> (36) :: String
        String parsedComments = commentsToParse.substring(1,commentsToParse.length() - 1); // -> 36 :: String
        this.commentsCount = Integer.parseInt(parsedComments); // 36 :: int
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
