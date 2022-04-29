package org.robot.fan.test.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.robot.fan.mock.MockFan;
import org.testng.Assert;

public class StepDefinitions {

  private String comparator;

  @Given("the temperature is at {int}")
  public void the_temperature_is_at(Integer int1) {
    MockFan.setMaxGivenTemp(int1);
  }

  @When("the temperature is lessThan {int}")
  public void the_temperature_is_less_than(Integer int1) {
    comparator = "lessThan";
    MockFan.setThresholdTemp(int1);
  }

  @When("the temperature is equalsTo {int}")
  public void the_temperature_is_equals_to(Integer int1) {
    comparator = "equalsTo";
    MockFan.setThresholdTemp(int1);
  }

  @When("the temperature is greaterThan {int}")
  public void the_temperature_is_greater_than(Integer int1) {
    comparator = "greaterThan";
    MockFan.setThresholdTemp(int1);
  }

  @Then("Fan should run at {int}%")
  public void fan_should_run_at(Integer int1) {
    switch (comparator) {
      case "lessThan":
        Assert.assertTrue(MockFan.getDutyCycle() < int1);
        break;
      case "equalsTo":
        Assert.assertEquals(MockFan.getDutyCycle(), int1);
        break;
      case "greaterThan":
        Assert.assertTrue(MockFan.getDutyCycle() > int1);
        break;
    }
  }
}
