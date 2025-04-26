package com.newframework.saucelabsPomPage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.newframework.baseclass.newBaseclass;

public class saucelabscheckOutFlow extends newBaseclass{
	
	@FindBy(css = "#first-name")
	private WebElement firstName;
	
	public WebElement getFirstName() {
		return firstName;
	}
	
	@FindBy(css = "#last-name")
	private WebElement lastName;
	
	public WebElement getLastName() {
		return lastName;
	}
	
	@FindBy(css = "#postal-code")
	private WebElement zipCode;
	
	public WebElement getZipCode() {
		return zipCode;
	}
	
	
	@FindBy(css = "#cancel")
	private WebElement cancelOrder;
	
	public WebElement getCancelOrder() {
		return cancelOrder;
	}
	
	@FindBy(css = "#continue")
	private WebElement continueOrder;
	
	public WebElement getContinueOrder() {
		return continueOrder;
	}
	
	@FindBy(css = "h3[data-test='error']")
	private WebElement errorMssg;
	
	public WebElement getErrorMssg() {
		return errorMssg;
	}
	
	@FindBy(css = "div.summary_tax_label")
	private WebElement taxAmount;
	
	@FindBy(css = "div.summary_subtotal_label")
	private WebElement netPrice;
	
	@FindBy(css = "div.summary_total_label")
	private WebElement grossAmount;
	
	@FindBy(css = "button#finish")
	private WebElement finishButton;
	
	public WebElement getFinishButton() {
		return finishButton;
	}
	
	@FindBy(css = "h2.complete-header")
	private WebElement thankYou;
	
	public WebElement getThankYouNote() {
		return thankYou;
	}
	
	@FindBy(css = "button#back-to-products")
	private WebElement backToHome;
	
	public String zipCodErrorMssg = "Error: Postal Code is required";
	public String lastNameErrorMssg = "Error: Last Name is required";
	public String firstNameErrorMssg = "Error: First Name is required";
	
	//private List<WebElement> cartItems = driver.findElements(By.xpath("//div[@class=\"cart_list\"]/div/div/.."));
	private List<WebElement> items = driver.findElements(By.cssSelector(".cart_item .inventory_item_name"));

	public List<WebElement> cartList(){
		return items;
	}
	
	private String productPrice = ".//div[@class = 'inventory_item_price']";
	public WebElement productPrice(WebElement product) {
		return product.findElement(By.xpath(productPrice));
	}
	
	public List<Double> getProductPrice(){
		List<Double> prices = new ArrayList<>();
		
	for (WebElement price : cartList()) {
		String amt = productPrice(price).getText().replace("$", " ");
		prices.add(Double.parseDouble(amt));
	}
		return prices;
	}

	
	private String productName = ".//div[@class = 'inventory_item_name ']";
	public WebElement productName(WebElement product) {
		return product.findElement(By.xpath(productName));
	}
	
	public saucelabscheckOutFlow(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	

}
