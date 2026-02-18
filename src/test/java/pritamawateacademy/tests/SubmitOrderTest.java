package pritamawateacademy.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pritamawateacademy.TestComponents.BaseTest;
import pritamawateacademy.pageobjects.*;

public class SubmitOrderTest extends BaseTest {

    //String productName = "ZARA COAT 3";

    @Test(dataProvider  = "getData", groups = "Purchase")
    public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException {
        // TODO Auto-generated method stub
        ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));

        List<WebElement> products = productCatalogue.getProductList();

        productCatalogue.addProductToCart(input.get("product"));
        CartPage cartPage = productCatalogue.goToCartPage();

        Boolean match = cartPage.VerifyProductDisplay(input.get("product"));
        Assert.assertTrue(match);
        CheckoutPage checkoutPage = cartPage.GoToCheckout();
        checkoutPage.SelectCountry("India");
        ConfirmationPage confirmationPage = checkoutPage.submitOrder();

        String confirmMessage = confirmationPage.getConfirmationMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

    }

    @Test(dependsOnMethods = {"submitOrder()"})
    public void OrderHistoryTest() {

        String productName = "ZARA COAT 3";

        ProductCatalogue productCatalogue = landingPage.loginApplication("pritam.awate1412@gmail.com", "Pritam@99");
        OrderPage orderPage = productCatalogue.goToOrdersPage();
        Assert.assertTrue(orderPage.VerifyOrderDisplay(productName));
    }


    @DataProvider
    public Object[][] getData() throws IOException
    {
        List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")
                + "/src/test/java/pritamawateacademy/data/PurchaseOrder.json");
        return new Object[][]  {{data.get(0)},{data.get(1)}};
    }



    //insted of giving all the details seperatly, we kept it in hash map
    //    @DataProvider
    //    public Object [][] getData()
    //    {
    //      return new Object[][] {{"pritam.awate1412@gmail.com","Pritam@99","ZARA COAT 3"}, {"pritam.awate99@gmail.com","Shubham@99","ADIDAS ORIGINAL"}};
    //    }

    //        HashMap<String,String> map = new HashMap<String,String>();
//        map.put("email","pritam.awate1412@gmail.com");
//        map.put("password","Pritam@99");
//        map.put("product","ZARA COAT 3");
//
//        HashMap<String,String> map1= new HashMap<String,String>();
//        map1.put("email","pritam.awate99@gmail.com");
//        map1.put("password","Shubham@99");
//        map1.put("product","ADIDAS ORIGINAL");
}
