package automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import java.time.Duration;
import java.util.NoSuchElementException;


public class MainPage {
    private WebDriver driver;

    private int indexProduct = 3;
    private String smgSuccessfully = "Product successfully added to your shopping cart";
    private By addToCart_btn = By.xpath(".//a[@title = 'Add to cart']");
    private By productContainer = By.xpath("//ul[@id='homefeatured']/li["+ indexProduct +"]");
    private By nameProduct = By.xpath(".//h5/a[contains(text(),'Printed Dress')]");
    private By imgProduct = By.xpath(".//a/img[@class ='replace-2x img-responsive']");
    private By imgProductCart = By.xpath("//div[@id='layer_cart']//img");



    public MainPage(WebDriver driver) {
        this.driver = driver;
    }


    public void testExpectedConditions(){
        Wait fluentWait = new FluentWait(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='layer_cart']")));
    }

    public MainPage selectProduct() {
        Actions builder = new Actions(driver);
        WebElement addToCartContainer_btn = driver.findElement(productContainer).findElement(addToCart_btn);
        builder.moveToElement(driver.findElement(productContainer)).click(addToCartContainer_btn).build().perform();
        return this;
    }

    public String getProductImg () {
        WebElement productImg = driver.findElement(productContainer).findElement(imgProduct);
        return productImg.getAttribute("src");

    }

    public String getProductCartImg () {
        WebElement productImgCart = driver.findElement(imgProductCart);
        return productImgCart.getAttribute("src");
    }

    public String getProductName () {
        WebElement productContainerWebElement = driver.findElement(productContainer);
        return productContainerWebElement.findElement(nameProduct).getText();
    }

    public String getProductNameCart () {
        return driver.findElement(By.xpath("//*[@id='layer_cart_product_title']")).getText();
    }

    public String addSuccessfully () {
        return driver.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[1]/h2")).getText();
    }

    public MainPage AssertProductCart () {
        String productImgSrc = getProductImg();
        String productImgCartSrc = getProductCartImg();

        String productName = getProductName();
        String productNameCart = getProductNameCart();

        String smgSuccessfullyCart = addSuccessfully();
        System.out.println("Печать " + smgSuccessfullyCart);

        Assert.assertEquals(productName, productNameCart);
        Assert.assertEquals(productImgSrc, productImgCartSrc);
        Assert.assertEquals(smgSuccessfully, smgSuccessfullyCart);
        return this;
    }

}
