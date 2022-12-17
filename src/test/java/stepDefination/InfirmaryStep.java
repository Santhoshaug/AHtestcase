package stepDefination;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class InfirmaryStep {
	public static WebDriver driver;
	@Given("^set browser$")
	public void set_browser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://address-health-revamp-git-dev-v2-zysktech.vercel.app/login");
	}
	
	@Given("^I enter the Username and Password$")
	public void i_enter_the_username_and_password(DataTable table) throws InterruptedException {
		List<List<String>> data = table.cells();
		driver.findElement(By.id("phone_number")).sendKeys(data.get(0).get(0));
		driver.findElement(By.id("password")).sendKeys(data.get(0).get(1)); 
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
	}
	@And("Nurse name")
	public void nurse_name() {
	    if(driver.getPageSource().contains("Hi Santhosha")) {
	    	System.out.println("Valid");
	    }
	    else {
	    	System.out.println("Invalid");
	    }
	}
	
	@Then("Select Mysore infirmary")
	public void select_mysore_infirmary() throws InterruptedException {
	    WebElement ele = driver.findElement(By.xpath("//select[@name='infirmary']"));
	    Select select=new Select(ele);
	    select.selectByIndex(1);
	    Thread.sleep(5000);
	}

	@When("complaint count")
	public void complaint_count() {
	    String ComplaintCount = driver.findElement(By.xpath("//p[@class='text-sm text-gray-400']")).getText();
	    System.out.println("Complaint count "+ComplaintCount);
	}

	@And("Minimum stocks")
	public void minimum_stocks() {
		String minimumStock = driver.findElement(By.xpath("//div[@class='text-sm text-gray-400 flex']/p[3]")).getText();
		System.out.println("Minimum stocks 2 "+minimumStock);
	}

	@Then("complaint created")
	public void complaint_created() {
		String complaintCreated = driver.findElement(By.xpath("(//div[@class='min-h-96 px-3'])[1]/div/dd/p")).getText();
	    System.out.println("Complaint created "+complaintCreated);
	}
	@And("Complaint completed")
	public void complaint_completed() {
		String complaintCompleted = driver.findElement(By.xpath("(//div[@class='min-h-96 px-3'])[2]/div/dd/p")).getText();
	    System.out.println("Complaint completed "+complaintCompleted);
	}

	@And("CT referrals")
	public void ct_referrals() throws InterruptedException {
		String CTreferrals = driver.findElement(By.xpath("(//div[@class='min-h-96 px-3'])[3]/div/dd/p")).getText();
	    System.out.println("CT referals "+CTreferrals);
	    Thread.sleep(5000);
	}
	@Then("In_progress complaints")
	public void in_progress_complaints() {
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		for(WebElement link:allLinks){
			 System.out.println(link.getText() + " - " + link.getAttribute("href"));
			 }
		System.out.println("In progerss");
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='grid lg:grid-cols-4 md:grid-cols-3 md:gap-4 my-5']/div/div/div/p"));
	   
	   for(WebElement e:list) {
		
		   System.out.println(e.getText() + " - " + e.getAttribute("class"));
	   }
	   
	}
	@Then("CT_referrals complaints")
	public void ct_referrals_complaints() throws InterruptedException {
		Thread.sleep(5000);
	   driver.findElement(By.xpath("(//div[@class='pr-1 pb-1.5 pt-0.5'])[2]/following-sibling::div")).click();
	   Thread.sleep(5000);
	   System.out.println("CT referrals");
	   List<WebElement> list = driver.findElements(By.xpath("//div[@class='grid lg:grid-cols-4 md:grid-cols-3 md:gap-4 my-5']/div/div/div/p"));
 
	   for(WebElement e:list) {
		
		   System.out.println(e.getText() + " - " + e.getAttribute("class"));
	   }
	}
	@Then("Expiring stocks")
	public void expiring_stocks() {
		System.out.println("expiring stocks");
	    List<WebElement> list = driver.findElements(By.xpath("//p[@class='basis-2/4 text-sm font-medium text-indigo-600 truncate capitalize']"));
	    for(WebElement e1:list) {
	    	System.out.println(e1.getText()+ " - " );
	    }
	}
	@Then("Expired stocks")
	public void expired_stocks() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//p[.='Expired']")).click();
		 System.out.println("expired stocks");
		Thread.sleep(5000);
		List<WebElement> list = driver.findElements(By.xpath("//p[@class='basis-2/4 text-sm font-medium text-indigo-600 truncate capitalize']"));
	    for(WebElement e1:list) {
	    	System.out.println(e1.getText()+ " - " );
	    }
	}
	@Then("Minimum supply stock")
	public void minimum_supply_stock() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//p[.='Minimum stock']")).click();
		System.out.println("minimum supply stocks");
		Thread.sleep(5000);
		List<WebElement> list = driver.findElements(By.xpath("//p[@class='basis-2/4 text-sm font-medium text-indigo-600 truncate capitalize']"));
	    for(WebElement e1:list) {
	    	System.out.println(e1.getText()+ " - " );
	    }
	}

	@Then("Important contacts1")
	public void important_contacts1() {
		System.out.println("contact 1");
		String designation1 = driver.findElement(By.xpath("//h2[.='Important Contacts']/parent::div/div/div[1]/h3")).getText();
		String email1 = driver.findElement(By.xpath("//h2[.='Important Contacts']/parent::div/div/div[1]/dl/div/dd")).getText();
		String phone1 = driver.findElement(By.xpath("//h2[.='Important Contacts']/parent::div/div/div[1]/dl/div[2]/dd")).getText();
	    System.out.println(designation1);
	    System.out.println(email1);
	    System.out.println(phone1);		
	}
	@Then("Important contacts2")
	public void important_contacts2() throws InterruptedException {
		 System.out.println("Contact 2");
		 String designation2 = driver.findElement(By.xpath("//h2[.='Important Contacts']/parent::div/div/div[2]/h3")).getText();
		 String email2 = driver.findElement(By.xpath("//h2[.='Important Contacts']/parent::div/div/div[2]/dl/div[1]/dd")).getText();
		 String phone2 = driver.findElement(By.xpath("//h2[.='Important Contacts']/parent::div/div/div[2]/dl/div[2]/dd")).getText();
		 System.out.println(designation2);
		 System.out.println(email2);
		 System.out.println(phone2);
		 
		 driver.findElement(By.xpath("(//a[text()='View all'])[1]")).click();
		 Thread.sleep(5000);
	}
	@Then("tear down browser")
	public void tear_down_browser() {
		driver.close();
	}
}