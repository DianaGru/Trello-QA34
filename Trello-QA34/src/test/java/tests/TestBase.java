package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {

    WebDriver wd;

    @BeforeMethod
    public void setUp(){

        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();

        wd = new ChromeDriver();
        wd.navigate().to("https://trello.com/");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterMethod
    public void postConditions(){

        //wd.close();
        //wd.quit();
    }

    public void initLogin() {
        click(By.cssSelector("[href='/login']"));
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void logOut() {
        click(By.cssSelector("[data-test-id = 'header-member-menu-button']"));
        click(By.cssSelector("[data-test-id = 'header-member-menu-logout']"));
        click(By.cssSelector("[data-testid='logout-button']"));
    }

    public boolean isLogged() {
        return wd.findElements(By.cssSelector("[data-test-id = 'header-member-menu-button']")).size()>0;
    }

    public class TestBase {
        WebDriver wd;

        @BeforeMethod
        public void setUp(){
            wd = new ChromeDriver();
            wd.navigate().to("https://trello.com/");
            wd.manage().window().maximize();
            wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }




        @AfterMethod
        public void postConditions(){
            wd.close();
            wd.quit();
        }


        public void initLogin() {
            click(By.cssSelector("[href='/login']"));
        }

        public void click(By locator) {
            wd.findElement(locator).click();
        }

        public void fillInLoginForm() {
            type(By.cssSelector("#user"), "juliakliot.jk@gmail.com");
            click(By.cssSelector("#login"));
            type(By.cssSelector("#password"),"misha240613");
        }

        public void type(By locator, String text) {
            click(locator);
            wd.findElement(locator).clear();
            wd.findElement(locator).sendKeys(text);
        }

        public void submitLogin() {
            click(By.cssSelector("#login-submit"));
        }
    }

}
