package com.newframework.saucelabsPomPage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.newframework.baseclass.newBaseclass;

public class saucelabsInventorypage extends newBaseclass{
	
	private List<WebElement> productList = driver.findElements(By.xpath("//div[@class = 'inventory_item']"));
	
	private String productName = ".//div[@class = 'inventory_item_name ']";
	
	private String productImage = ".//img[@class='inventory_item_img']";
	
	private String productPrice = ".//div[@class = 'inventory_item_price']";
	
	private String AtoZ = "Name (A to Z)";
	
	private String ZtoA = "Name (Z to A)";
	
	private String lohi = "Price (low to high)";
	
	private String hilo = "Price (high to low)";
	
	private String addCart = ".//button[text()='Add to cart']";
	
	private String remove = ".//button[text()='Remove']";
	
	@FindBy(className = "product_sort_container")
	private WebElement getSelectDropdown;
	
	@FindBy(className = "shopping_cart_badge")
	private WebElement cartCount;
	
	public WebElement getselectDropdown() {
		return getSelectDropdown;
	}
	
	
	public saucelabsInventorypage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public List<WebElement> productList(){
		return productList;
	}
	
	public WebElement productName(WebElement product) {
		return product.findElement(By.xpath(productName));
	}
	
	public WebElement productImage(WebElement product) {
		return product.findElement(By.xpath(productImage));
	}
	
	public WebElement productPrice(WebElement product) {
		return product.findElement(By.xpath(productPrice));
	}
	
	public WebElement addtoCart(WebElement product) {
		return product.findElement(By.xpath(addCart));
	}
	
	public String getcartCount() {
		return cartCount.getText();
	}
	
	public WebElement getremoveButton(WebElement product) {
		return product.findElement(By.xpath(remove));
	}
	public int productListCount() {
		return productList.size();
	}
	
	public String getAtoZ() {
		return AtoZ;
	}
	
	public String getZtoA() {
		return ZtoA;
	}
	
	public String getlohi() {
		return lohi;
	}
	
	public String gethilo() {
		return hilo;
	}
	
	
	//fetching names of the products
	public List<String> getProductName() {
	List<String> names = new ArrayList<>();
	for(WebElement name : productList()) {
		names.add(productName(name).getText());
	}
	return names;
	}
	
	//fetching price of the products
	public List<Double> getProductPrice(){
		List<Double> prices = new ArrayList<>();
		
	for (WebElement price : productList()) {
		String amt = productPrice(price).getText().replace("$", " ");
		prices.add(Double.parseDouble(amt));
	}
		return prices;
	}

}
