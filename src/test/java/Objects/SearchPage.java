package Objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {

	WebDriver driver;
	public SearchPage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public void Search(String input)   {
		WebElement searchBox=driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
		searchBox.sendKeys(input);
		WebElement submitSearch=driver.findElement(By.xpath("//*[@id=\"nav-search-bar-form\"]/div[4]"));
		try {
		submitSearch.click();
		Thread.sleep(3000);
		}
		catch(Exception e){
			System.out.println("Exceptions caught"+e.getMessage());
		}
	}
	
	public void Sorting() {
		WebElement select=driver.findElement(By.xpath("//*[@id=\"a-autoid-0\"]"));
		try {
		select.click();
		Thread.sleep(5000);
		}
		catch(Exception e){
			System.out.println("Exceptions caught"+e.getMessage());
		}
		WebElement option=driver.findElement(By.xpath("//*[@id=\"s-result-sort-select\"]/option[2]"));
		option.click();	
	}
	
	public void Add() {
		List<WebElement> prices = driver.findElements(By.cssSelector("[class='a-price-whole']"));	
		WebElement addToCartButton = driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]"));
		Map<WebElement,Integer> map = new HashMap<WebElement, Integer>();
		for(int i=0;i<prices.size();i++){
			if(prices.get(i).getText() !="") {
				map.put(prices.get(i),Integer.parseInt(prices.get(i).getText().replaceAll("[^0-9]", "")));	
			}
			
		}
		for(Entry m :map.entrySet()) {
			System.out.println(m.getKey()+ " "+m.getValue());
		}
	List<Entry<WebElement,Integer>> es = new ArrayList<Map.Entry<WebElement,Integer>>(map.entrySet());
	
	es.sort(Entry.comparingByValue());
	
	for(Entry m :es) {
		System.out.println(m.getKey()+ " "+m.getValue());
	}
	try {
	es.get(0).getKey().click();
	Thread.sleep(5000);
	}
	catch(Exception e){
		System.out.println("Exceptions caught"+e.getMessage());
	}
    addToCartButton.click();
	}
	
}
