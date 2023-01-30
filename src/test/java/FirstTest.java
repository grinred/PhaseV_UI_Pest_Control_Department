import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.base.BaseTest;
import pom.pages.HomePage;
import pom.pages.StorePage;

public class FirstTest extends BaseTest {


    @Test
    public void dummyTest() throws InterruptedException {


        HomePage homePage = new HomePage(driver);
        StorePage storePage = homePage.clickStoreMenuLink();
        storePage.search("Blue");
        Assert.assertEquals(storePage.getTitle(), "Search results: “Blue”");
        storePage.clickAddToCartButton("Blue Shoes");

        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@title='View cart']")).click();
        Assert.assertEquals(
                driver.findElement(By.cssSelector("td[class='product-name'] a")).getText(), "Blue Shoes");

        driver.findElement(By.cssSelector(".checkout-button")).click();
        driver.findElement(By.id("billing_first_name")).sendKeys("demo");
        driver.findElement(By.id("billing_last_name")).sendKeys("user");
        driver.findElement(By.id("billing_address_1")).sendKeys("San Francisco");
        driver.findElement(By.id("billing_city")).sendKeys("San Francisco");
        driver.findElement(By.id("billing_postcode")).sendKeys("94188");
        driver.findElement(By.id("billing_email")).sendKeys("grinred@gmail.com");
        driver.findElement(By.id("place_order")).click();

        Thread.sleep(1000);

        Assert.assertEquals(driver.findElement(By.cssSelector(".woocommerce-notice")).getText(),

                "Thank you. Your order has been received.");
    }

    @Test
    public void loginAndCheckout() throws InterruptedException {

        driver.get("https://askomdch.com");
        driver.findElement(By.xpath("//li[@id='menu-item-1227']//a[@class='menu-link'][normalize-space()='Store']")).click();
        driver.findElement(By.xpath("//input[@id='woocommerce-product-search-field-0']")).sendKeys("Blue");
        driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//h1[contains(text(),'Blue')]")).getText(), "Search results: “Blue”");
        driver.findElement(By.xpath("//a[@aria-label='Add “Blue Shoes” to your cart']")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//a[@title='View cart']")).click();
        Assert.assertEquals(
                driver.findElement(By.cssSelector("td[class='product-name'] a")).getText(), "Blue Shoes");

        driver.findElement(By.cssSelector(".checkout-button")).click();

        driver.findElement(By.cssSelector(".showlogin")).click();

        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#username")).sendKeys("grinred");
        driver.findElement(By.cssSelector("#password")).sendKeys("23112010");
        driver.findElement(By.name("login")).click();

        driver.findElement(By.id("billing_first_name")).sendKeys("demo");
        driver.findElement(By.id("billing_last_name")).sendKeys("user");
        driver.findElement(By.id("billing_address_1")).sendKeys("San Francisco");
        driver.findElement(By.id("billing_city")).sendKeys("San Francisco");
        driver.findElement(By.id("billing_postcode")).sendKeys("94188");
        driver.findElement(By.id("billing_email")).sendKeys("grinred@gmail.com");
        driver.findElement(By.id("place_order")).click();

        Thread.sleep(1000);

        Assert.assertEquals(driver.findElement(By.cssSelector(".woocommerce-notice")).getText(),

                "Thank you. Your order has been received.");
    }
}
