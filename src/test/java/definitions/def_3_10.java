package definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;

public class def_3_10 {
    @Given("^I navigate to \"([^\"]*)\" page$")
    public void iNavigateToPage(String page) throws Throwable {
        if (page.equalsIgnoreCase("login")) {
            getDriver().get("http://ask-stage.portnov.com/#/login");
        } else if (page.equalsIgnoreCase("registration")) {
            getDriver().get("http://ask-stage.portnov.com/#/registration");
        } else {
            throw new RuntimeException("Not supported " + page);
        }
    }

    @When("^I type email \"([^\"]*)\" on \"([^\"]*)\" page$")
    public void iTypeEmailOnPage(String email, String page) throws Throwable {
        if (page.equalsIgnoreCase("login")) {
            getDriver().findElement(By.xpath("//input[@placeholder='Email *']")).sendKeys(email);
        } else if (page.equalsIgnoreCase("registration")) {
            getDriver().findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(email);
        } else {
            throw new RuntimeException("Not supported " + page);
        }
    }

    @And("^I type password \"([^\"]*)\" on \"([^\"]*)\" page$")
    public void iTypePasswordOnPage(String pass, String page) throws Throwable {
        if (page.equalsIgnoreCase("login")) {
            getDriver().findElement(By.xpath("//input[@placeholder='Password *']")).sendKeys(pass);
        } else if (page.equalsIgnoreCase("registration")) {
            getDriver().findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(pass);
        } else {
            throw new RuntimeException("Not supported " + page);
        }
    }

    @And("^I click Sign in button$")
    public void iClickSignInButton() throws Throwable {
        getDriver().findElement(By.xpath("//*[contains(text(),'Sign In')]")).click();
        Thread.sleep(1000);
    }
}