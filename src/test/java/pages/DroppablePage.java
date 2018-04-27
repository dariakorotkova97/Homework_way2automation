package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DroppablePage {

    public DroppablePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public WebDriver driver;
    public static Actions action;

    @FindBy (xpath = "//div[@id='draggable']")
    private WebElement draggable;

    @FindBy (xpath = "//div[@id='droppable']")
    private WebElement droppable;

    public void dragAndDrop() {
        driver.switchTo().frame(0);
        action = new Actions(driver);
        action.dragAndDrop(draggable, droppable).perform();
    }
}
