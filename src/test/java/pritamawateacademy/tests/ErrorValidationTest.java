package pritamawateacademy.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pritamawateacademy.TestComponents.BaseTest;
import pritamawateacademy.TestComponents.Retry;
import pritamawateacademy.pageobjects.CartPage;
import pritamawateacademy.pageobjects.ProductCatalogue;

import java.io.IOException;
import java.util.List;

public class ErrorValidationTest extends BaseTest {

    @Test(groups = {"ErrorHandling"},retryAnalyzer = Retry.class)
    public void LoginErrorValidation() throws IOException, InterruptedException {
        // TODO Auto-generated method stub
        String productName = "ZARA COAT 3";
        landingPage.loginApplication("pritam.awate1412@gmail.com", "Pritam@");
        Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
    }


    @Test
    public void ProductErrorValidation() throws IOException, InterruptedException
    {
        // TODO Auto-generated method stub
        String productName = "ZARA COAT 3";
        ProductCatalogue productCatalogue =landingPage.loginApplication("pritam.awate99@gmail.com","Shubham@99");

        List<WebElement> products = productCatalogue.getProductList();

        productCatalogue.addProductToCart(productName);
        CartPage cartPage=productCatalogue.goToCartPage();

        Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 33");
        Assert.assertFalse(match);
}
}
