package test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.DroppablePage;
import pages.MainPage;

import java.util.concurrent.TimeUnit;

public class Test {

    public static WebDriver driver;
    public static MainPage mainPage;
    public static DroppablePage droppablePage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", ".//src/libs/chromedriver.exe");
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        droppablePage = new DroppablePage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.get("http://way2automation.com/way2auto_jquery");
    }

    @org.junit.Test
    public void testAuthorization() throws InterruptedException {
        mainPage.clickSignInButton();
        mainPage.inputLogin("simtest");
        mainPage.inputPassword("12345678");
        mainPage.clickSubmit();
        Thread.sleep(3000);
        mainPage.clickItemMenu("Interaction", "Droppable");
        Thread.sleep(3000);
        droppablePage.dragAndDrop();
    }

    @After
    public void afterTest(){
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
