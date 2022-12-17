package stepDefination;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateGiddinessComplaint {
	
	
	public static void main(String[] args) {
		InfirmaryStep is=new InfirmaryStep();
		WebDriver d = is.driver;
	}
	
	
	@Given("Navigate to complaint page")
	public void navigate_to_complaint_page() {
	   
	}

	@And("capture date and time")
	public void capture_date_and_time() {
	    
	}

	@When("select Giddiness complaint from complaint dropdown")
	public void select_giddiness_complaint_from_complaint_dropdown() {
	   
	}

	@And("write notes")
	public void write_notes() {
	   
	}

	@And("Select outcome checkbox")
	public void select_outcome_checkbox() {
	   
	}

	@And("Select treatment")
	public void select_treatment() {
	    
	}

	@When("select examination findings")
	public void select_examination_findings() {
	   
	}

	@And("click on advice")
	public void click_on_advice() {
	    
	}

	@And("get permission")
	public void get_permission() {
	    
	}

	@And("select medicines")
	public void select_medicines() {
	   
	}

	@When("click on Description")
	public void click_on_description() {
	   
	}

	@Then("select student from searchable dropdown")
	public void select_student_from_searchable_dropdown() {
	   
	}

	@And("click on create")
	public void click_on_create() {
	   
	}


}
