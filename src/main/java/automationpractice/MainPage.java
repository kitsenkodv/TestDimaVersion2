package automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class MainPage extends BasePage {
    String SITE_URL = "http://automationpractice.com/index.php";

    private int indexProduct = 3;
    private By addToCart_btn = By.xpath("//*[@id='homefeatured']//li["+ indexProduct +"]//a[@title = 'Add to cart']");
    private By productContainer = By.xpath("//ul[@id='homefeatured']/li["+ indexProduct +"]");
    private By nameProduct = By.xpath("//ul[@id='homefeatured']/li["+ indexProduct +"]//h5/a[contains(text(),'Printed Dress')]");
    private By nameProductCart = By.xpath("//*[@id='layer_cart_product_title']");
    private By imgProduct = By.xpath("//ul[@id='homefeatured']/li["+ indexProduct +"]//a/img[@class ='replace-2x img-responsive']");
    private By imgProductCart = By.xpath("//div[@id='layer_cart']//img");
    private By PrevCart = By.xpath("//*[@id='layer_cart']");
    private By smgSuccessfully = By.xpath("//*[@id='layer_cart']//span[@class = 'cross']/following-sibling::h2");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage goTo () {
        driver.get(SITE_URL);
        return this;
    }

    public MainPage selectProduct() {
        Actions builder = new Actions(driver);
        builder
                .moveToElement(driver.findElement(productContainer))
                .click(driver.findElement(addToCart_btn))
                .build()
                .perform();
        return this;
    }

    public String getProductImg () {
        return getAttributeElement(imgProduct, "src");
    }

    public String getProductCartImg () {
        return getAttributeElement(imgProductCart, "src");
    }

    public String getProductName () {
        return getText(nameProduct);
    }

    public String getProductNameCart () {
        return getText(nameProductCart);
    }

    public WebElement getPrevCart () {
        return getWebElement(PrevCart);
    }

    public String getSmgSuccessfully () {
        return getText(smgSuccessfully);
    }

}
