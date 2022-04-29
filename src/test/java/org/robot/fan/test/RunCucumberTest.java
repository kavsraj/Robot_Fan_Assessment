package org.robot.fan.test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;

@CucumberOptions(
    plugin = {
      "pretty",
      "summary",
      "rerun:target/rerun1.txt",
      "org.robot.fan.report.ReportListener"
    },
    glue = {"org.robot.fan.test.steps", "org.robot.fan.report"},
    monochrome = true,
     dryRun = true,
    features = {"src/test/resources/tests"})
public class RunCucumberTest extends AbstractTestNGCucumberTests {
  @DataProvider()
  @Override
  public Object[][] scenarios() {
    return super.scenarios();
  }

  @AfterClass
  public void afterEverything() {}
}
