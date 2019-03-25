package tests;

import org.junit.Test;

import core.LoginMainPage;
import core.ResendPage;
import core.TestBase;

public class WrikeTest extends TestBase {
    @Test
    public void test(){
        ResendPage resendPage = new LoginMainPage(driver).doLogin();
        resendPage.completingSurvey();
        resendPage.checkCompletedSurvey();
        resendPage.clickResentEmail();
        resendPage.checkResentEmail();
        resendPage.checkTwitterURL();
        resendPage.checkTwitterIMG();
    }
}
