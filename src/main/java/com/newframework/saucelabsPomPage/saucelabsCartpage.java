package com.newframework.saucelabsPomPage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.newframework.baseclass.newBaseclass;

public class saucelabsCartpage extends newBaseclass{
	
	@FindBy(className = "shopping_cart_link")
	private WebElement cartIcon;
	
	public WebElement cartIcon() {
		return cartIcon;
	}
	
	@FindBy(id = "remove-sauce-labs-backpack")
	private WebElement removeButton;
	
	public void clickonRemoveButton() {
		removeButton.click();
	}
	
	@FindBy(id = "checkout")
	private WebElement checkoutButton;
	
	public void clickonCheckoutButton() {
		checkoutButton.click();
	}
	
	@FindBy(id = "continue-shopping")
	private WebElement continueShoppingButton;
	
	public void clickonContinueShoppingBtn() {
		continueShoppingButton.click();
	}
	
	@FindBy(className = "shopping_cart_badge")
	private WebElement cartCount;
	
	public String getcartCount() {
		return cartCount.getText();
	}
	
	
	private List<WebElement> productsAddedtoCart = driver.findElements(By.xpath("//div[@class='cart_item']"));
	private String productNameAddedtoCart =".//div[@class = 'inventory_item_name']";
	private String produtPriceAddedtoCart =".//div[@class = 'inventory_item_price']";
	
	
	public List<WebElement> getProductsAddedtoCart(){
		return productsAddedtoCart;
	}
	
	public WebElement getProductName(WebElement product) {
		return product.findElement(By.xpath(productNameAddedtoCart));
	}
	
	public WebElement getProductPrice(WebElement product) {
		return product.findElement(By.xpath(productNameAddedtoCart));
	}

	public saucelabsCartpage(WebDriver drive) {
		PageFactory.initElements(driver, this);
	}
}
