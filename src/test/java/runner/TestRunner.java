package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;


@RunWith(CucumberWithSerenity.class)
//@CucumberOptions(features ="src/test/resources/features/Login.feature",glue = "stepDefination",tags= "@Test1")
//@CucumberOptions(features ="src/test/resources/features/Login.feature",glue = "stepDefination",tags= "@Test2")
//@CucumberOptions(features ="src/test/resources/features/Login.feature",glue = "stepDefination",tags="@Test1,@Test2")
//@CucumberOptions(features ="src/test/resources/features/Login.feature",glue = "stepDefination")
@CucumberOptions(features ="src/test/resources/features/Login.feature",glue = "stepDefination",tags= "@Test3")

public class TestRunner {
	

}
