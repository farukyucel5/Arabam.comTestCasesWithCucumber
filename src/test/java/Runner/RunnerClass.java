package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

public class RunnerClass {
    @CucumberOptions(

            features = {"src/test/java"}, //it will run all test case features but the code lines below run specific features
            //features={"src/test/java/Features/SearchTest.feature"},

            glue = {"Steps"},

            plugin = { "pretty",
                    "html:target/site/cucumber-pretty",
                    "json:target/cucumber.json","html:target/cucumber-html-report","usage:target/cucumber-usage.json","" +
                    "junit:target/cucumber-results.xml" },
            dryRun = false
    )



    public static class RunnerGenel extends AbstractTestNGCucumberTests {

    }

}
