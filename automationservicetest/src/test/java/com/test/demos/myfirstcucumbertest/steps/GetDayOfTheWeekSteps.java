package com.test.demos.myfirstcucumbertest.steps;

import com.test.demos.myfirstcucumbertest.Application;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import static org.junit.Assert.*;


@SpringBootTest(classes = Application.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration()
public class GetDayOfTheWeekSteps {
    @Autowired
    protected TestRestTemplate template;

    private ResponseEntity<String> response;
    private int month, day, year;

    @Given("^the month as (\\d+)")
    public void the_month_as(int month) {
        this.month = month;
    }

    @And("^the day as (\\d+)")
    public void the_day_as(int day) {
        this.day = day;
    }

    @And("^the year as (\\d+)")
    public void the_year_as(int year) {
        this.year = year;

    }

    @When("^the client calls /dayOfTheWeek$")
    public void the_client_calls_daysOfTheWeek() throws Throwable {
               response = template.getForEntity("/dayOfTheWeek/" + month+ "/" + day + "/" + year, String.class);
    }

    @Then("^the client receives a valid response$")
    public void the_client_receives_a_valid_response() {
        assertNotNull(response);

    }

    @And("^the response has the status code (\\d+)$")
    public void the_response_has_status_code(int statusCode) throws Throwable{
        HttpStatus currentStatusCode = response.getStatusCode();
        assertEquals(currentStatusCode.value(), statusCode);

    }

    @And("^the response contains day of the week as (.+)$")
    public void the_response_contains_day_of_the_week_as_WEDNESDAY(String day) throws Throwable{
        assertEquals(day, response.getBody());
    }

}
