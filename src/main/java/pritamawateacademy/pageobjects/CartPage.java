package pritamawateacademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pritamawateacademy.AbstractComponents.AbstractComponent;

import java.util.List;

public class CartPage extends AbstractComponent {

    WebDriver driver;

    @FindBy(css = ".cartSection h3")
    private List<WebElement> cartProducts;

    @FindBy(css = ".totalRow button")
    WebElement checkoutEle;

    public CartPage(WebDriver driver) {

        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Boolean VerifyProductDisplay(String productName) {

        Boolean match = cartProducts.stream()
                .anyMatch(cartProduct ->
                        cartProduct.getText().equalsIgnoreCase(productName));
        return match;
    }

    public CheckoutPage GoToCheckout(){
        checkoutEle.click();
        return new CheckoutPage(driver);

    }


}
