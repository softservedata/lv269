package home.test;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WishListModules {
	private boolean isLoggedIn;
	private WebDriver driver;

	public WishListModules(WebDriver driver) {
		this.driver = driver;
		this.isLoggedIn = false;
	}

	public void logIn() {
		driver.findElement(By.cssSelector(".caret")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys("mfj14401@sqoai.com");
		driver.findElement(By.id("input-password")).clear();
		driver.findElement(By.id("input-password")).sendKeys("qwerty123456");
		driver.findElement(By.cssSelector(".btn.btn-primary:not(a)")).click();

		this.isLoggedIn = true;
	}

	public void logOut() {
		driver.findElement(By.cssSelector(".fa.fa-user")).click();
		driver.findElement(By.xpath(
				".//ul[@class='dropdown-menu dropdown-menu-right']/li/a[@href='http://server7.pp.ua/index.php?route=account/account']"))
				.click();
		driver
				.findElement(By.xpath(
						".//a[@class='list-group-item'][@href='http://server7.pp.ua/index.php?route=account/logout']"))
				.click();

		this.isLoggedIn = false;
	}

	public void openWishList() {
		driver.findElement(By.id("wishlist-total")).click();
	}

	public void addItem(int id) {
		driver.get("http://server7.pp.ua/index.php?route=product/product&product_id=" + id);
		driver.findElement(By.xpath(".//button[@class='btn btn-default']/i[@class='fa fa-heart']"))
				.click();
	}

	public void deleteItem() {
		driver.findElement(By.cssSelector(".btn.btn-danger")).click();
	}

	public boolean isWishListOpened() {
		if (driver.getCurrentUrl().contains("/wishlist")) {
			return true;
		}

		return false;
	}

	public boolean isLoggedIn() {
		return this.isLoggedIn;
	}

	public boolean isWishListEmpty() {
		return getWishListItemsCount() == 0 ? true : false;
	}

	public void doWishListEmpty() {
		if (isWishListEmpty() || !isWishListOpened()) {
			return;
		}
		
		int itemsCount = getWishListItemsCount();
		for (int i = 1; i <= itemsCount; i++) {
			deleteItem();
		}
	}

	public int getWishListItemsCount() {
		String str = driver.findElement(By.id("wishlist-total")).getAttribute("title").replaceAll("\\D", "");
		return Integer.parseInt(str);
	}
	
	public List<Integer> getItemsFromWishList() {
		List<Integer> list = new ArrayList<>();
		if (!isLoggedIn() || isWishListEmpty() || !isWishListOpened()) {
			return list;
		}
		List<WebElement> items = driver.findElements(By.xpath("//tbody/tr/td['.text-left'][2]/a[@href]"));
		int size = items.get(0).getAttribute("href").split("=").length;
		for (WebElement item : items) {
			list.add(Integer.parseInt(item.getAttribute("href").split("=")[size - 1]));
		}

		return list;
	}
}