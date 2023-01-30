package pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.base.BasePage;

public class StorePage extends BasePage {
    private final By searchField = By.xpath("//input[@id='woocommerce-product-search-field-0']");
    private final By searchButton = By.xpath("//button[normalize-space()='Search']");
    private final By title = By.xpath("//h1[contains(text(),'Blue')]");
    private final By viewCartButton = By.xpath("//a[@title='View cart']");

    public StorePage(WebDriver driver) {
        super(driver);
    }

    private StorePage enterTextInSearchField(String text) {
        driver.findElement(searchField).sendKeys(text);
        return this;
    }

    private StorePage clickSearchButton() {
        driver.findElement(searchButton).click();
        return this;
    }

    public void search(String text) {
        enterTextInSearchField(text).clickSearchButton();
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }

    private By getToCartButtonElement(String productName) {
        return By.xpath("//a[@aria-label='Add “" + productName + "” to your cart']");
    }

    public StorePage clickAddToCartButton(String productName) {
        By addToCArtButton = getToCartButtonElement(productName);
        driver.findElement(addToCArtButton).click();
        return this;
    }
}
