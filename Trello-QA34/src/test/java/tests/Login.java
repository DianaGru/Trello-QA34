package tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login extends TestBase{

    @BeforeMethod

    public void preCondition(){
        if (isLogged()) {
            logOut();
        }
    }

    @Test
    public void login1() {
        initLogin();
        fillInLoginForm();
        submitLogin();

    }

    public void submitLogin() {
        click(By.cssSelector("#login-submit"));
    }

    public void fillInLoginForm() {
        type(By.cssSelector("#user"));
        click(By.cssSelector("#login"));
        type(By.cssSelector("#password"));
    }

    public void type(By locator) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys("dianchik2004@gmail.com");
    }

}