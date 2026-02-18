package pritamawateacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pritamawateacademy.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
    WebDriver driver;


    public LandingPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "userPassword")
    WebElement passwordEle;

    @FindBy(id = "login")
    WebElement submit;

    @FindBy(css = "[class*='flyInOut']")
    WebElement errorMessage;

    public ProductCatalogue loginApplication(String email, String password)
    {
        userEmail.sendKeys(email);
       passwordEle.sendKeys(password);
        submit.click();
        ProductCatalogue productCatalogue = new ProductCatalogue(driver);
        return productCatalogue;
   }

    //chatgpt changes added this method my commenting uppear method
//    public ProductCatalogue loginApplication(String email, String password)
//    {
//        userEmail.clear();
//        userEmail.sendKeys(email);
//
//        passwordEle.clear();
//        passwordEle.sendKeys(password);
//
//        // Wait for any animation overlay to disappear
//        waitForOverlayToDisappear(By.cssSelector(".ng-animating"));
//
//        waitForElementToBeClickable(submit);
//
//        // Scroll into view before click
//        jsClick(submit);
//
//        return new ProductCatalogue(driver);
//    }




    public void goTo()
    {
        driver.get("https://rahulshettyacademy.com/client");

    }

    public String getErrorMessage()
    {
        waitForWebElementToAppear(errorMessage);
       return errorMessage.getText();

    }

}
