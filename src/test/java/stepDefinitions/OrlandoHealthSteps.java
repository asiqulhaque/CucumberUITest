package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.OrlandoHealthPage;

public class OrlandoHealthSteps {

    OrlandoHealthPage orlandoHealthPage = new OrlandoHealthPage();

    @Given("User Launches Chrome Browser")
    public void user_launches_chrome_browser() {
    // initialization();
    }

    @When("user visit Orlando Hospital and click on Find a Doctor")
    public void user_visit_OrlandoHospital() {
      //  orlandoHealthPage = new OrlandoHealthPage();
        orlandoHealthPage.clickOnFindDoctorTab();

    }

    @When("User will be able to land Doctor Search page")
    public void doctorSearch() {
        orlandoHealthPage.doctorSearchOption();
    }

    @When("User click Appointment Tab")
    public void user_click_appointment_tab() {
        orlandoHealthPage.clickOnAppointmentTab();

    }

    @When("User click Request a Call back")
    public void user_click_request_a_call_back() {
        orlandoHealthPage.clickOnReqCallBackLink();

    }

    @When("User Fill required info and click submit")
    public void user_fill_required_info_and_click_submit() throws InterruptedException {
        orlandoHealthPage.selectUsPhNumberRadioBtn();
        orlandoHealthPage.enterFirstName("myname");
        orlandoHealthPage.enterLastName("mylastname");
        orlandoHealthPage.enterEmailTxt("abc@gmail.com");
        orlandoHealthPage.enterDateOfBirth("01/01/1998");
        orlandoHealthPage.enterPhoneNumber("3472178890");
        orlandoHealthPage.enterZipCode("70816");
        orlandoHealthPage.selectDesiredService(2);
        orlandoHealthPage.clickSubmitBtn();
    }

    @Then("User will get a success Message for an appointment")
    public void user_will_get_a_success_message_for_an_appointment() {
       String thanyouMsg = orlandoHealthPage.getSuccessMessage();
        Assert.assertEquals(thanyouMsg, "Thank You!");
    }





}
