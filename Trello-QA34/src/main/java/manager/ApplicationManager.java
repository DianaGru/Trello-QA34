package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ApplicationManager {

    WebDriver wd;

    UserHelper user;
    BoardHelper board;


    public void init() {
        wd = new ChromeDriver();
        wd.navigate().to("https://trello.com/");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        user = new UserHelper(wd);
        board = new BoardHelper(wd);
        user.login("dianchik2004@gmail.com","Celev1981");
    }

    public void stop() {
        wd.close();
        wd.quit();
    }

    public UserHelper getUser() {
        return user;
    }

    public BoardHelper getBoard() {
        return board;
    }
}
