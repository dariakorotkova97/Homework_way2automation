package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    WebElement inputVariable;
    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public WebDriver driver;
    public static Actions action;

    @FindBy(xpath = "//a[text()='Signin']")
    private WebElement signInButton;

    public void clickSignInButton(){
        signInButton.click();
    }

    public void inputLogin(String login){
        inputVariable = (WebElement)((JavascriptExecutor) driver).executeScript("return this.$(\"input:visible\").get(0)");
        inputVariable.sendKeys(login);
    }

    public void inputPassword(String password){
        inputVariable= (WebElement)((JavascriptExecutor) driver).executeScript("return this.$(\"input:visible\").get(1)");
        inputVariable.sendKeys(password);
    }


    public void clickSubmit(){
        inputVariable = (WebElement)((JavascriptExecutor) driver).executeScript("return this.$(\"input:visible\").get(2)");
        inputVariable.click();
    }

   public void clickItemMenu(String itemMenu, String value) {
       action = new Actions(driver);
       WebElement buttonMenu = driver.findElement(By.xpath("//a[text()='"+itemMenu+"']"));
       action.moveToElement(buttonMenu).pause(500).click(driver.findElement(By.xpath("//a[text()='"+value+"']"))).build().perform();
    }

}
