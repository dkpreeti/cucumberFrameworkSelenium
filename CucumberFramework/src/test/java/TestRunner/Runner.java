package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
       (
    		   features={".//Features/LoginFeature.feature"},
    		   glue = "StepDefinition",
    		   dryRun =false,
    		   
    		   monochrome=true,
    		  // tags="@sanity",
    		   //@sanity,@regression, @ui, @smoke,@functional
    		   //tags ="@sanity or @regression" : run all whether it contains sanity or regression
    		  //tags ="@sanity and @regression" : only run if both included
    		  //tags ="@sanity and not @regression" : run only sanity
    		   plugin= {"pretty","html:target/report-html.html"}
    		       		       		   
	   )
public class Runner {

}
