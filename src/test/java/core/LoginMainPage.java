package core;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginMainPage extends HelperBase {

    public static final By LOGIN = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Enter your business email'])[2]/following::button[1]");
    public static final By MAIN_MENU = By.xpath(".//*[@class='wg-header__sticky-mainmenu']");
    public static final By INPUT_EMAIL = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Enter your business email'])[4]/following::input[1]");
    public static final By CREATE = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Enter your business email'])[4]/following::button[1]");
    public static final String MASK = "+wpt@wriketask.qaa";
    private String email;

    public LoginMainPage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(MAIN_MENU));
    }
    public void generateEmail(){
        Random rn = new Random();
        int i = rn.nextInt();
        String email = String.valueOf(i);
        this.email = email + MASK;
    }

    public ResendPage doLogin() {
        generateEmail();
        click(LOGIN);
        type(email, INPUT_EMAIL);
        click(CREATE);
        return new ResendPage(driver);
    }
}