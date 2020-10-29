package stepdefinitions;


import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features={
				"C:\\Git_Project\\CucumberParallelScenarios\\src\\main\\java\\Features\\ScenariosOutlineExample.feature","C:\\Git_Project\\CucumberParallelScenarios\\src\\main\\java\\Features\\ScenariosExample.feature"},//path of feature files
		glue={"stepdefinitions"})//path os step definitions)
		/*monochrome=true,//display console output in proper readable format
		dryRun=false, //to check the mapping of feaatures and SD
		//format={"pretty","html:test-output"}
		strict=true //to check if any step is not defined in step definition
		//tags={"~@SmokeTest","@RegresssionTest"}
		)*/
public class RunParallel extends AbstractTestNGCucumberTests {
	
	@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
          return super.scenarios();
    }
}
