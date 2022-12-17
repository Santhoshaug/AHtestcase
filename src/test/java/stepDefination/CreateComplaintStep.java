package stepDefination;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateComplaintStep {
public WebDriver driver;

	@Given("^setBrowser$")
	public void setBrowser() throws Throwable {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize(); 
	}

	@And("^Enter the AH URL \"([^\"]*)\"$")
	public void enter_the_AH_URL(String arg1) throws Throwable {
		driver.get("https://address-health-revamp-git-dev-v2-zysktech.vercel.app/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
	}

	@When("^I enter Username and Password AH$")
	public void i_enter_username_and_password_AH(DataTable table) {
		List<List<String>> data = table.cells();
		driver.findElement(By.id("phone_number")).sendKeys(data.get(0).get(0));
		driver.findElement(By.id("password")).sendKeys(data.get(0).get(1));  
	}

	@And("^Click on login button AH$")
	public void click_on_login_button_AH() throws Throwable {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
	}

	@Then("^User must successfully login to the web page AH$")
	public void user_must_successfully_login_to_the_web_page_AH() throws Throwable {
		if(driver.getCurrentUrl().equalsIgnoreCase(
			      "https://address-health-revamp-git-feat-address-zysktech.vercel.app/")){
			         System.out.println("Test Pass"); 
			      } else { 
			         System.out.println("Test Failed"); 
			      } 
		System.out.println("Data table");
		System.out.println("testcase1");
		//driver.quit();
	}
	@Then("complaint page AH")
	public void complaint_page_ah() throws InterruptedException {
		driver.findElement(By.xpath("//span[.='New Complaint']")).click();
		Thread.sleep(5000);
	    
	}

	@And("selecting student")
	public void selecting_student() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@placeholder='Search Name or AH Id']")).sendKeys("MONISHA AGARWAL" +Keys.ENTER);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='md:basis-1/2 pb-2 px-5 md:px-0']/ul/li/div/p[1]")).click();
		Thread.sleep(5000);
		//driver.findElement(By.id("timeIn")).click();
	}

	@And("selcting complaint dropdown")
	public void selcting_complaint_dropdown() throws InterruptedException {
        driver.findElement(By.xpath("//label[.='Complaint']/following-sibling::select")).click();
		
		List<WebElement> lists = driver.findElements(By.xpath("//label[.='Complaint']/following-sibling::select/option"));
		for(WebElement e:lists) {
			
			if(e.getAttribute("value").equals("1,Fever")) {
				e.click();
			}
		}
		Thread.sleep(5000);
	}

	@Then("selecting other complaints")
	public void selecting_other_complaints() throws InterruptedException {
		Thread.sleep(5000);
		Actions action = new Actions(driver);
		WebElement element1 = driver.findElement(By.xpath("(//div[@class='my-5'])[1]/div[2]/input"));
		action.moveToElement(element1).click().perform();
		
	   
	   Thread.sleep(5000);
	}

	@Then("selecting outcome")
	public void selecting_outcome() throws InterruptedException {
		Actions action = new Actions(driver);
		WebElement element1 = driver.findElement(By.xpath("(//div[@class='my-5'])[2]/div[2]/input"));
		action.moveToElement(element1).click().perform();
		
		Thread.sleep(5000);
	}
	
	@And("^click on treatment$")
	public void click_on_treatment() throws InterruptedException {
		driver.findElement(By.xpath("(//div[@class='mt-2'])[1]/div[1]/input")).click();	
		Thread.sleep(5000);
		
	//	driver.findElement(By.xpath("(//div[@class='mt-2'])[2]/div[1]/input")).click();	
		//Thread.sleep(5000);
	}

	@Then("selecting ct referral")
	public void selecting_ct_referral() throws InterruptedException {
		driver.findElement(By.xpath("(//div[@class='mt-2'])[1]/div[1]/input")).click();	
		Thread.sleep(5000);
	}

	@Then("selecting advice")
	public void selecting_advice() throws InterruptedException {
		Actions action = new Actions(driver);
		WebElement element1 = driver.findElement(By.xpath("(//div[@class='my-5'])[2]/div[2]/input"));
		action.moveToElement(element1).click().perform();
		
		Thread.sleep(5000);
	}

	@Then("selecting permission")
	public void selecting_permission() throws InterruptedException {
		driver.findElement(By.xpath("(//div[@class='mt-2'])[1]/div[1]/input")).click();	
		Thread.sleep(5000);
	}

	@Then("entering duration")
	public void entering_duration() throws InterruptedException {
	    driver.findElement(By.xpath("//div[@class='items-center my-3']/div/div/input")).click();
	    Thread.sleep(5000);
	}
	
	@And("entering notes in the notes field")
	public void entering_notes_in_the_notes_field() throws InterruptedException {
		
	    driver.findElement(By.xpath("//textarea[@id='notes']")).sendKeys("Hello welcome to Address Health");
	    Thread.sleep(5000);
	    System.out.println("notes---------");
	}

	@Then("click on save and monitor")
	public void click_on_save_and_monitor() {
	    driver.findElement(By.xpath("//button[.='Save and Monitor' and @type='submit']")).click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@And("clicking other complaints and outcome")
	public void clicking_other_complaints_and_outcome() throws InterruptedException {
		
		driver.findElement(By.xpath("(//div[@class='my-5'])[1]/div[2]/input")).click();
		driver.findElement(By.xpath("(//div[@class='my-5'])[1]/div[3]/input")).click();
		Thread.sleep(5000);
		System.out.println("11111111111");
		
		driver.findElement(By.xpath("(//div[@class='my-5'])[2]/div[2]/input")).click();
		driver.findElement(By.xpath("(//div[@class='my-5'])[2]/div[3]/input")).click();
		Thread.sleep(5000);
		System.out.println("2222222");
	}
	

	/*
	 * @When("selecting examination finding") public void
	 * selecting_examination_finding() throws InterruptedException {
	 * driver.findElement(By.xpath("(//div[@class=' css-ackcql'])[1]")).sendKeys(
	 * "BP" +Keys.ENTER);
	 * driver.findElement(By.xpath("(//input[@class='mt-2 w-full'])[1]")).sendKeys(
	 * "120/80"); Thread.sleep(5000); System.out.println("2222223"); }
	 */

	@And("click on Advice and Permission")
	public void click_on_advice_and_permission() throws InterruptedException {
		
		driver.findElement(By.xpath("(//div[@class='my-5'])[3]/div[2]/input")).click();
		driver.findElement(By.xpath("(//div[@class='my-5'])[3]/div[3]/input")).click();
		System.out.println("2222224");
		
		Thread.sleep(5000);
		
		driver.findElement(By.id("parents")).click();
		System.out.println("2222225");
	   
	}

	/*
	 * @And("selecting the medicine") public void selecting_the_medicine() throws
	 * InterruptedException {
	 * driver.findElement(By.xpath("(//div[@class=' css-ackcql'])[2]")).sendKeys(
	 * "Betadin" +Keys.ENTER);
	 * driver.findElement(By.xpath("(//input[@class='mt-2 w-full'])[2]")).sendKeys(
	 * "120/80"); Thread.sleep(5000); System.out.println("2222226"); }
	 */

	@And("selcting Description check list group")
	public void selcting_description_check_list_group() throws InterruptedException {
		driver.findElement(By.xpath("(//div[@class='my-5'])[4]/div[2]")).click();
		driver.findElement(By.xpath("(//div[@class='my-5'])[4]/div[3]")).click();
		Thread.sleep(5000);
		System.out.println("2222227");
	}

	@Then("click on create button")
	public void click_on_create_button() throws InterruptedException {
		driver.findElement(By.name("duration.days")).sendKeys("2");
		Thread.sleep(5000);
		System.out.println("2222228");
		
		driver.findElement(By.xpath("//button[.='Save and Monitor']")).submit();
		Thread.sleep(15000);
	    
	}

}
