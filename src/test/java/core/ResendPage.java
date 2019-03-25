package core;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ResendPage extends HelperBase {
    public static final By SURVEY = By.xpath((".//*[@class= 'survey']"));
    public static final By ANS_ONE = By.xpath((".//*[.= 'Very interested']"));
    public static final By ANS_TWO = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Just looking'])[1]/following::button[1]");
    public static final By ANS_THREE = By.xpath((".//*[.= 'Yes']"));
    public static final By SUBMIT = By.xpath((".//*[.= 'Submit results']"));
    public static final By COMPLETE = By.xpath((".//*[.= 'Thanks for helping us out!']"));
    public static final By RESEND = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='contact us'])[2]/following::button[1]");
    public static final By CHECK_MESSAGE = By.xpath(".//*[contains(text(), 'again') and (@class = 'again')]");
    public static final By TWITTER_URL = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Follow us'])[1]/following::li[1]");
    public static final String URL_TWITTER_WRIKE = "https://twitter.com/wrike";
    public static final String STR_TWITTER = "twitter";
    public static final By IMG_TWITTER = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Follow us'])[1]/following::li[1]/child::a/child::*");

    public ResendPage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        Assert.assertTrue("Не дождались прогрузки страницы с опросом",
                explicitWait( ( ExpectedConditions.presenceOfAllElementsLocatedBy(SURVEY)),
                        15, 500) );
    }
     public void completingSurvey(){
        click(ANS_ONE);
        click(ANS_TWO);
        click(ANS_THREE);
        click(SUBMIT);
     }

     public void checkCompletedSurvey() {
         Assert.assertTrue("Не дождались прогрузки страницы завершенного опроса",
                 explicitWait( ( ExpectedConditions.presenceOfAllElementsLocatedBy(COMPLETE)),
                         15, 500) );
     }

     public void clickResentEmail () {
         Assert.assertTrue("Не найден элемент повторной оправки", isElementVisible(RESEND));
         click(RESEND);
     }
     public void checkResentEmail(){
         Assert.assertTrue("Не дождались отправки повторно",
                 explicitWait( ( ExpectedConditions.presenceOfAllElementsLocatedBy(CHECK_MESSAGE)),
                         15, 500));
     }

     public boolean isWrikeTwitterURL (String str){
        if (str.contains(URL_TWITTER_WRIKE)){
            return true;
        } else {
            return false;
        }
     }
    public boolean isWrikeTwitterIMG (String str){
        if (str.contains(STR_TWITTER)){
            return true;
        } else {
            return false;
        }
    }
     public void checkTwitterURL(){
         String url = driver.findElement(TWITTER_URL).getAttribute("innerHTML");
         Assert.assertTrue("Не верный URL", isWrikeTwitterURL(url));
     }
    public void checkTwitterIMG(){
        String img = driver.findElement(IMG_TWITTER).getAttribute("innerHTML");
        Assert.assertTrue("Не верное изображение", isWrikeTwitterIMG(img));
    }
}
