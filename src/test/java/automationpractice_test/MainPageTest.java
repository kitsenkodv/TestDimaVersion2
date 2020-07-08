package automationpractice_test;


import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class MainPageTest extends BaseTest {

    @Test
    public void CheckAddToCart () {
        mainPage.goTo()
                .selectProduct();
        assertTrue(mainPage.getPrevCart().isDisplayed());
        Assert.assertEquals( mainPage.getProductNameCart() , mainPage.getProductName());
        Assert.assertEquals(mainPage.getProductCartImg() , mainPage.getProductImg());
        Assert.assertEquals(mainPage.getSmgSuccessfully() , "Product successfully added to your shopping cart");
    }

}