package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import stepDefinitions.BaseClass;

import java.time.Duration;

public class OrlandoHealthPage extends BaseClass {

    public OrlandoHealthPage(){
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "/html/body/header/div[1]/div[2]/a[2]")
    @CacheLookup
    private  WebElement findDoctorTab;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[1]/form/div[1]/h1")
    @CacheLookup
    WebElement findADoctor;

    @FindBy(xpath = "/html/body/header/div[2]/div[3]/a[1]")
    @CacheLookup
    WebElement appointmentTab;

    @FindBy(xpath = "//h3[text() = 'Request a Call-Back' and @class ='tile-label white']")
    @CacheLookup
    WebElement requestCallBackLink;

    @FindBy(xpath = "//*[@id='FSGFRadioButton282__1']")
    @CacheLookup
    WebElement usPhNumRadioBtn;

    @FindBy(xpath = "//*[@id ='Case.API_First_Name__c']")
    @CacheLookup
    WebElement firstNameTxtField;

    @FindBy(xpath = "//*[@id ='Case.API_Last_Name__c']")
    @CacheLookup
    WebElement lastNameTxtField;

    @FindBy(xpath = "//*[@id ='Case.API_Email__c']")
    @CacheLookup
    WebElement emailTxtField;

    @FindBy(xpath = "//*[@id ='Case.API_Phone__c']")
    @CacheLookup
    WebElement phoneNumTxtField;

    @FindBy(xpath = "//*[@id ='Case.API_Birthdate__c']")
    @CacheLookup
    WebElement dateOfBirthTxtField;

    @FindBy(xpath = "//*[@id ='Case.API_Mailing_ZIP__c']")
    @CacheLookup
    WebElement zipCodeTxtField;

    @FindBy(xpath = "//*[@id ='Case.Services__c']")
    @CacheLookup
    WebElement selectDesiredService;

    @FindBy(xpath = "//*[@id='btnsubmit']")
    @CacheLookup
    WebElement submitBtn;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[1]/h1")
    @CacheLookup
    WebElement thankYouTxt;


    public void clickOnFindDoctorTab() {
        findDoctorTab.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(findADoctor));
    }

    public void doctorSearchOption() {
        String docSearchHeading = findADoctor.getText();
        Assert.assertEquals(docSearchHeading, "Find a Doctor at Orlando Health");
    }

    public void clickOnAppointmentTab(){
        appointmentTab.click();
    }

    public void clickOnReqCallBackLink(){
        requestCallBackLink.click();
    }

    public void selectUsPhNumberRadioBtn() throws InterruptedException {
        Thread.sleep(7000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)");
        usPhNumRadioBtn.click();
    }

    public void clickSubmitBtn() throws InterruptedException {
        Thread.sleep(5000);
        submitBtn.click();
        Thread.sleep(12000);
    }

    public void enterFirstName(String fName){
        firstNameTxtField.sendKeys(fName);
    }

    public void enterLastName(String lName){
        lastNameTxtField.sendKeys(lName);
    }

    public void enterEmailTxt(String email){
        emailTxtField.sendKeys(email);
    }

    public void enterPhoneNumber(String phone){
        phoneNumTxtField.sendKeys(phone);
    }

    public void enterDateOfBirth(String dob){
        dateOfBirthTxtField.sendKeys(dob);
    }

    public void enterZipCode(String zipcode){
        zipCodeTxtField.sendKeys(zipcode);
    }

    public void selectDesiredService(int index){
        Select select = new Select(selectDesiredService);
        select.selectByIndex(index);
    }

    public String getSuccessMessage(){
        String thnxTxt = thankYouTxt.getText();
        return thnxTxt;
    }

}
