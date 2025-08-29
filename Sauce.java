package PracticeAutomation;

		import java.util.List;

		import org.openqa.selenium.By;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.WebElement;
		import org.openqa.selenium.chrome.ChromeDriver;
		import org.openqa.selenium.chrome.ChromeOptions;

		public class Sauce {
			public static void main(String[] args) throws InterruptedException {
				//Step 1 : Launch Chrome Browser in guest mode
				ChromeOptions opt = new ChromeOptions();
				
				//To avoid pop-up use guest mode
				opt.addArguments("guest");
				
				//Create a object for chrome driver
				ChromeDriver driver = new ChromeDriver(opt);
				
				//Maximize the window
				driver.manage().window().maximize();
				
				//Step 2 : Navigate to https://saucedemo.com/v1
				driver.get("https://saucedemo.com/v1");
				
				//Step 3 : Enter Username and Enter Password
				driver.findElement(By.id("user-name")).sendKeys("standard_user");
				driver.findElement(By.id("password")).sendKeys("secret_sauce");
				
				//Step 4 : Click Login Button
				driver.findElement(By.id("login-button")).click();
				
				//Step 5 :Capture and Print the first Product Name
			    WebElement productname = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
			    System.out.println(productname.getText());
			    
			    //Step 6 : Capture and Print the First Product Price
			    WebElement Price = driver.findElement(By.xpath("//div[text()='29.99']"));
			    System.out.println(Price.getText());
			    
			    //Step 7: Click AddTOCart for the First Product
			    driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
			    
			    //Step 8 : Click the cart icon
			    driver.findElement(By.xpath("//span[@class='fa-layers-counter shopping_cart_badge']")).click();
			    
			    //Step 9 : Verify the Cart Price matches the Inventory Price
			    WebElement inventory_Price = driver.findElement(By.xpath("//div[text()='29.99']"));
			    
			    if (inventory_Price.equals(Price)) {
			    	System.out.println("Cart Price and Product Price are Same");
			    }
			    
			    //Step 10:Click on CheckOut
			    driver.findElement(By.xpath("//a[@class='btn_action checkout_button']")).click();
			    
			    //Step 11:Enter FirstName and LastName and Postal code
			    driver.findElement(By.id("first-name")).sendKeys("Jayapriya");
			    driver.findElement(By.id("last-name")).sendKeys("E");
			    driver.findElement(By.id("postal-code")).sendKeys("608401");
			    
			    //Step 12:CLick Continue
			    driver.findElement(By.xpath("//input[@class='btn_primary cart_button']")).click();
			    
			    //Step 13:Collect All Product Prices on checkout overview Page
			    WebElement Prices = driver.findElement(By.xpath("//div[class='']")) ;
			    
			    Thread.sleep(8000);
			    
			    //Step 14:click Finish
			    driver.findElement(By.xpath("//a[text()='FINISH']")).click();
			}}
