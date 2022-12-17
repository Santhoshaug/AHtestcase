package stepDefination;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginStep {
	
public WebDriver driver;
	
	@Given("^I am on the AH website$")
	public void AHopen_the_browser() throws Throwable {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize(); 
	}

	@When("^AHEnter the URL \"([^\"]*)\"$")
	public void AHenter_the_URL(String arg1) throws Throwable {
		driver.get("https://address-health-revamp-git-dev-v2-zysktech.vercel.app/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
	}

	@When("^AHI enter Username and Password$")
	public void AHi_enter_username_and_password(DataTable table) {
		List<List<String>> data = table.cells();
		driver.findElement(By.id("phone_number")).sendKeys(data.get(0).get(0));
		driver.findElement(By.id("password")).sendKeys(data.get(0).get(1));  
	}

	@And("^AHClick on login button$")
	public void AHclick_on_login_button() throws Throwable {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
	}

	@And("^AHUser must successfully login to the web page$")
	public void AHuser_must_successfully_login_to_the_web_page() throws Throwable {
		if(driver.getCurrentUrl().equalsIgnoreCase(
			      "https://address-health-revamp-git-dev-v2-zysktech.vercel.app/")){
			         System.out.println("Test case Pass"); 
			      } else { 
			         System.out.println("Test case Failed"); 
			      } 
		
	}
	@And("AHNurse name")
	public void AHnurse_name() {
	    if(driver.getPageSource().contains("Hi Santhosha")) {
	    	System.out.println("Valid");
	    }
	    else {
	    	System.out.println("Invalid");
	    }
	}
	
	@Then("AHSelect Mysore infirmary")
	public void AHselect_mysore_infirmary() throws InterruptedException {
	    WebElement ele = driver.findElement(By.xpath("//select[@name='infirmary']"));
	    Select select=new Select(ele);
	    select.selectByIndex(1);
	    Thread.sleep(5000);
	}

	@When("AHcomplaint count")
	public void AHcomplaint_count() {
	    String ComplaintCount = driver.findElement(By.xpath("//p[@class='text-sm text-gray-400']")).getText();
	    System.out.println("Complaint count "+ComplaintCount);
	}

	@And("AHMinimum stocks")
	public void AHminimum_stocks() {
		String minimumStock = driver.findElement(By.xpath("//div[@class='text-sm text-gray-400 flex']/p[3]")).getText();
		System.out.println("Minimum stocks 2 "+minimumStock);
	}

	@Then("AHcomplaint created")
	public void AHcomplaint_created() {
		String complaintCreated = driver.findElement(By.xpath("(//div[@class='min-h-96 px-3'])[1]/div/dd/p")).getText();
	    System.out.println("Complaint created "+complaintCreated);
	}
	@And("AHComplaint completed")
	public void AHcomplaint_completed() {
		String complaintCompleted = driver.findElement(By.xpath("(//div[@class='min-h-96 px-3'])[2]/div/dd/p")).getText();
	    System.out.println("Complaint completed "+complaintCompleted);
	}

	@And("AHCT referrals")
	public void AHct_referrals() throws InterruptedException {
		String CTreferrals = driver.findElement(By.xpath("(//div[@class='min-h-96 px-3'])[3]/div/dd/p")).getText();
	    System.out.println("CT referals "+CTreferrals);
	    Thread.sleep(5000);
	}
	@Then("AHIn_progress complaints")
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
	@Then("AHCT_referrals complaints")
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
	@Then("AHExpiring stocks")
	public void expiring_stocks() {
		System.out.println("expiring stocks");
	    List<WebElement> list = driver.findElements(By.xpath("//p[@class='basis-2/4 text-sm font-medium text-indigo-600 truncate capitalize']"));
	    for(WebElement e1:list) {
	    	System.out.println(e1.getText()+ " - " );
	    }
	}
	@Then("AHExpired stocks")
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
	@Then("AHMinimum supply stock")
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

	@Then("AHImportant contacts1")
	public void important_contacts1() {
		System.out.println("contact 1");
		String designation1 = driver.findElement(By.xpath("//h2[.='Important Contacts']/parent::div/div/div[1]/h3")).getText();
		String email1 = driver.findElement(By.xpath("//h2[.='Important Contacts']/parent::div/div/div[1]/dl/div/dd")).getText();
		String phone1 = driver.findElement(By.xpath("//h2[.='Important Contacts']/parent::div/div/div[1]/dl/div[2]/dd")).getText();
	    System.out.println(designation1);
	    System.out.println(email1);
	    System.out.println(phone1);		
	}
	@Then("AHImportant contacts2")
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
	@Then("AHtear down browser")
	public void tear_down_browser() {
		driver.close();
	}
	
	/***********************Page element identifiers******************************/
	
	private By viewAll=By.xpath("(//a[text()='View all'])[1]");
	private  By complaints=By.xpath("//a[.='Complaints'])[2]");
	private By completedTab=By.xpath("(//div[.='Completed'])[1]");
	private By complaintName= By.xpath("//div[@class='flex flex-col bg-gray-100 justify-between rounded-lg']/div/div/p");
	private By studentName= By.xpath("//div[@class='flex flex-col bg-gray-100 justify-between rounded-lg']/div/div[2]/div[1]/p[1]");
	private By CTreferral=By.xpath("//div[@class='flex flex-col bg-gray-100 justify-between rounded-lg']/div/div[2]/div/p[2]");
	private By time=By.xpath("//div[@class='flex flex-col bg-gray-100 justify-between rounded-lg']/div/div[2]/div[2]/p[1]/time");
	private By status=By.xpath("//div[@class='flex flex-col bg-gray-100 justify-between rounded-lg']/div/div[1]/div/p");
	private By nextpage=By.xpath("//a[@aria-label='Next page']");
	private By pagenumber=By.xpath("(//a[@class='page-link'])[last()]");
	
	@And("navigate to complaint page")
	public void navigate_to_complaint_page() throws InterruptedException {
	 Thread.sleep(5000);
	 driver.findElement(viewAll).click();
	 Thread.sleep(5000);
//	 try {
//		driver.findElement(By.xpath("//a[.='Complaints'])[2]")).click();
//		 Thread.sleep(5000);
//	} catch (InterruptedException e) {
//		System.out.println(e.getMessage());
//	}
		
	}
	@Then("click on completed complaint")
	public void click_on_completed_complaint() throws InterruptedException {
		Thread.sleep(5000);
	    driver.findElement(completedTab).click();
	    Thread.sleep(5000);
		
	}
	@And("fetch all complaint")
	public void fetch_all_complaint() throws InterruptedException {
		
		
		List<WebElement> sname = driver.findElements(studentName);
		List<WebElement> cname = driver.findElements(complaintName);
		List<WebElement> ctreferal = driver.findElements(CTreferral);
		List<WebElement> Time = driver.findElements(time);
		List<WebElement> Status = driver.findElements(status);
		WebElement ele=driver.findElement(nextpage);
		String ele2 = driver.findElement(pagenumber).getText();
		int ele3 = Integer.parseInt(ele2);
		   
		
		for(int i=1;i<=ele3;i++) {
		    	for(WebElement e:sname) {
					System.out.println(e.getText());
				}
				for(WebElement e:cname) {
					System.out.println(e.getText());
				}
				for(WebElement e:ctreferal) {
					System.out.println(e.getText());
				}
				for(WebElement e:Time) {
					System.out.println(e.getText());
				}
				for(WebElement e:Status) {
					System.out.println(e.getText());
				}  
				
				if(ele.isDisplayed()) {
					ele.click();
				}
				else {
					System.out.println("lastpage");
				}
				Thread.sleep(5000);
		}
		
		
		
//		
//		for(WebElement e:sname) {
//			System.out.println(e.getText());
//		}
//		for(WebElement e:cname) {
//			System.out.println(e.getText());
//		}
//		for(WebElement e:ctreferal) {
//			System.out.println(e.getText());
//		}
//		for(WebElement e:Time) {
//			System.out.println(e.getText());
//		}
//		for(WebElement e:Status) {
//			System.out.println(e.getText());
//		}
//		
//		Thread.sleep(5000);
//		driver.findElement(nextpage).click();
//		System.out.println("next page");
//		Thread.sleep(5000);
//		
//		for(WebElement e:sname) {
//			System.out.println(e.getText());
//		}
//		for(WebElement e:cname) {
//			System.out.println(e.getText());
//		}
//		for(WebElement e:ctreferal) {
//			System.out.println(e.getText());
//		}
//		for(WebElement e:Time) {
//			System.out.println(e.getText());
//		}
//		for(WebElement e:Status) {
//			System.out.println(e.getText());
//		}
		
		
		
		
		
//		Thread.sleep(5000);
//		for(int i=1;i<=8;i++) {
//			//complaint name
//			System.out.println(driver.findElement(complaintName).getText());
//			
//			//student name
//			System.out.println(driver.findElement(studentName).getText());
//			
//			//CT referral
//			System.out.println(driver.findElement(CTreferral));
//			
//			//time
//			System.out.println(driver.findElement(time));
//			
//			//status
//			System.out.println(driver.findElement(status));
//			
			
//		}
		System.out.println("tear down");
	    
		
	}

	

}
