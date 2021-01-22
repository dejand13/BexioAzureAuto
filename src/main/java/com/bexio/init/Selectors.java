package com.bexio.init;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class Selectors {
    public AppiumDriver driver;

    public Selectors(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    //    Login selectors
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert")
    public WebElement allowNotificationDialog;


    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='j_username']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Login | bexio\"]/XCUIElementTypeTextField")
    public WebElement username;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='j_password']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField")
    public WebElement password;

    @AndroidFindBy(className = "android.widget.Button")
    @iOSXCUITFindBy(accessibility = "Login")
    public WebElement logginButton;

    //    Company choice screen selectors
    @AndroidFindBy(xpath = "//android.view.View[@text='You can only select one company.']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='would like to connect to one of your companies.']")
    public WebElement availabilityOfLogInCompanyNamesList;

    @AndroidFindBy(xpath = "//android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeLink")
    public List<WebElement> logInCompanyNamesList;

    @AndroidFindBy(xpath = "//android.view.View[@text='Remember my choice']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Remember my choice']")
    public WebElement rememberMyChoiseCheckBox;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Reject']")
    @iOSXCUITFindBy(accessibility = "Reject")
    public WebElement rejectAccess;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Allow']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Allow']")
    public WebElement allowAccessToCompany;

    @AndroidFindBy(xpath = "//android.view.View[@text='View & edit your contacts']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='View & edit your contacts']")
    public WebElement viewEditContacts;

    //    Home screen selectors
    @AndroidFindBy(xpath = "//android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText")
    public WebElement homeScreenCompanyName;

    @AndroidFindBy(xpath = "//android.widget.TextView[@index='1']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText")
    public WebElement switchCompanyNames;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Manage Contacts']")
    @iOSXCUITFindBy(accessibility = "Manage Contacts \uF0C0")
    public WebElement manageContacts;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Scan Documents']")
    @iOSXCUITFindBy(accessibility = "Scan Documents \uF065")
    public WebElement scanDocuments;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Track Time']")
    @iOSXCUITFindBy(accessibility = "Track Time")
    public WebElement trackTime;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='My bexio Accounts']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@label='My bexio Accounts \uF013']")
    public WebElement myBexioAccounts;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Send feedback']")
    @iOSXCUITFindBy(accessibility = "\uF075 Send feedback")
    public WebElement sendFeedback;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Recommend']")
    @iOSXCUITFindBy(accessibility = "\uF4C4 Recommend")
    public WebElement recommendBexio;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='\uF053']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='\uF053']")
    public WebElement switchCompanyLeftArrow;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='\uF054']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='\uF054']")
    public WebElement switchCompanyRightArrow;

    //    Forget password selectors
    @AndroidFindBy(xpath = "//android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Forgot password?']")
    public WebElement forgotPassLogInLink;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='recover_password_form_email']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    public WebElement enterEmailForgotPass;

    @AndroidFindBy(xpath = "//android.view.View[@text='This value is not a valid email address.']")
    @iOSXCUITFindBy(accessibility = "This value is not a valid email address.")
    public WebElement notValidEmailAssert;

    @AndroidFindBy(xpath = "//android.view.View[@text='A message containing a link has been sent to your email address.']")
    @iOSXCUITFindBy(accessibility = "A message containing a link has been sent to your email address.")
    public WebElement linkSuccessfullySentAssert;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Back to login']")
    @iOSXCUITFindBy(accessibility = "Back to login")
    public WebElement backToLogInForgotPass;

    @AndroidFindBy(xpath = "//android.widget.Button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton")
    public WebElement requestNewPassButton;

    //    Recommend bexio
    @AndroidFindBy(xpath = "//android.widget.EditText")
    public WebElement recommendEmailAddress;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Send']")
    public WebElement recommendSendButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Close']")
    public WebElement recommendCloseButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='\uF00D']")
    public WebElement recommendXbutton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Thank you!']")
    public WebElement recommendThankYou;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='This is not a valid email address.']")
    public WebElement invalidEmailToastMessage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='An email to this address has already been sent.']")
    public WebElement recommentAlreadySentToastMessage;

    //    Manage Contacts
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='\uF015']")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"\uF015\"])[2]")
    public WebElement homeButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='\uF067']")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"\uF067\"])[2]")
    public WebElement addContactButton;

    @AndroidFindBy(xpath = "//android.widget.EditText")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"\uF002\"])[2]/XCUIElementTypeOther[2]/XCUIElementTypeTextField")
    public WebElement searchBar;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Automation, Auto']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='\uF007 Automation, Auto emailAddress@gmail.com']")
    public WebElement searchAutomationContact;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='emailAddress@gmail.com']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='emailAddress@gmail.com']")
    public WebElement emailAddressAutomationContact;

//    Add Contact

    //For iOS we are not able to select the element(selectors from BG element are given)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='New person']")
    public WebElement newPerson;

    //For iOS we are not able to select the element(selectors from BG element are given)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='New company']")
    public WebElement newCompany;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText)[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='Last name']")
    public WebElement lastName;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup/android.view.ViewGroup[@index='1']/android.widget.EditText)[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='First name']")
    public WebElement firstName;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='2']/android.view.ViewGroup/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther)[1]")
    public WebElement formOfAddress;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Mr.']")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Mr.\"])[2]")
    public WebElement formOfAddressMr;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='3']/android.view.ViewGroup/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther[@name='Choose \uF0D7']")
    public WebElement title;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Dr.']")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Dr.\"])[2]")
    public WebElement titleDr;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='4']/android.view.ViewGroup/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther)[3]")
    public WebElement languageOfCorrespondence;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Italian']")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Italian\"])[2]")
    public WebElement languageOfCorrItalian;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='2']/android.view.ViewGroup/android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"E-Mail\"]/XCUIElementTypeOther/XCUIElementTypeTextField")
    public WebElement email;

    //Same selector used as for email for GP
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='2']/android.view.ViewGroup/android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"E-Mail This email address is not valid.\"]/XCUIElementTypeOther/XCUIElementTypeTextField")
    public WebElement invalidEmailTextBox;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@index='2']/android.view.ViewGroup/android.widget.EditText)[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"E-Mail 2\"]/XCUIElementTypeOther/XCUIElementTypeTextField")
    public WebElement email2;

    //Same selector used as for email2 for GP
    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@index='2']/android.view.ViewGroup/android.widget.EditText)[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"E-Mail 2 This email address is not valid.\"]/XCUIElementTypeOther/XCUIElementTypeTextField")
    public WebElement invalidEmail2TextBox;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@index='2']/android.view.ViewGroup/android.widget.EditText)[3]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Phone\"]/XCUIElementTypeOther/XCUIElementTypeTextField")
    public WebElement phone;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@index='2']/android.view.ViewGroup/android.widget.EditText)[4]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Phone 2\"]/XCUIElementTypeOther/XCUIElementTypeTextField")
    public WebElement phone2;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@index='2']/android.view.ViewGroup/android.widget.EditText)[5]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Mobile\"]/XCUIElementTypeOther/XCUIElementTypeTextField")
    public WebElement mobile;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@index='2']/android.view.ViewGroup/android.widget.EditText)[6]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Website\"]/XCUIElementTypeOther/XCUIElementTypeTextField")
    public WebElement website;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@index='4']/android.view.ViewGroup/android.widget.EditText)[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Street\"]/XCUIElementTypeTextField")
    public WebElement address;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@index='4']/android.view.ViewGroup/android.widget.EditText)[2]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Postcode\"])[3]/XCUIElementTypeTextField")
    public WebElement postcode;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@index='4']/android.view.ViewGroup/android.widget.EditText)[3]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"City\"])[4]/XCUIElementTypeTextField")
    public WebElement city;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@index='4']/android.view.ViewGroup[@index='3']/android.view.ViewGroup/android.widget.TextView)")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Switzerland \uF0D7\"])[2]")
    public WebElement country;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='7']/android.view.ViewGroup/android.widget.TextView[@text='Bulgaria']")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Bulgaria\"])[2]")
    public WebElement countryBulgaria;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Finland']")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Finland\"])[2]")
    public WebElement countryFinland;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@index='5']/android.view.ViewGroup/android.widget.EditText)[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Remarks\"]/XCUIElementTypeOther/XCUIElementTypeTextView")
    public WebElement remarks;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@index='5']/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView)")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Choose \uF0D7\"])[3]")
    public WebElement category;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='QA!']")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"\uF0C8 QA!\"])[2]")
    public WebElement categoryQA;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@index='5']/android.view.ViewGroup[@index='2']/android.view.ViewGroup/android.widget.TextView)")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Choose \uF0D7\"])[4]")
    public WebElement sectors;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sector 1B']")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"\uF0C8 Sector 1B\"])[2]")
    public WebElement sector1B;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Save']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Save\"]")
    public WebElement checkboxSaveButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Please provide a name']")
    @iOSXCUITFindBy(accessibility = "Please provide a name")
    public WebElement lastNameValidation;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='This email address is not valid.']")
    @iOSXCUITFindBy(accessibility = "This email address is not valid.")
    public WebElement emailAddressValidation;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='\uF067']")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"\uF00C\"])[2]")
    public WebElement addContactSaveButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='\uF015']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='\uF053']")
    public WebElement backButtonContactDetailView;

    //    Edit Contact
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='\uF067']")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"\uF304\"])[2]")
    public WebElement editButton;

    //    My bexio Accounts
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='\uF067']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='\uF067']")
    public WebElement myBexioAccAddCompany;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Remove']")
    @iOSXCUITFindBy(accessibility = "Remove")
    public WebElement myBexioRemove;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='REMOVE']")
    @iOSXCUITFindBy(accessibility = "Remove")
    public WebElement removeButtonDialog;

    //    Scanner scene selectors
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Scan and send to inbox']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='\uF574 Scan and send to inbox \uF054']")
    public WebElement scanSendToInbox;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_message")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='“bexioGo” Would Like to Access the Camera']")
    public WebElement allowCameraPermissions;

    //    Track Time
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Stopwatch']")
    @iOSXCUITFindBy(accessibility = "Stopwatch, tab, 1 of 3")
    public WebElement stopwatch;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='Add description']")
    public WebElement addDescriptionTrackTime;

    @iOSXCUITFindBy(accessibility ="More \uF0D7")
    public WebElement moreTrackTime;

    @iOSXCUITFindBy(accessibility = "Less \uF0D8")
    public WebElement lessTrackTime;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Entry can be invoiced']/XCUIElementTypeOther")
    public WebElement toggleButtonTrueTrackTime;

//    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='Contact Choose \uF0D7']/XCUIElementTypeOther)")
    @iOSXCUITFindBy(accessibility = "Contact Choose \uF0D7")
    public WebElement contactTrackTime;

//    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='Activity * Administration \uF0D7']/XCUIElementTypeOther)")
    @iOSXCUITFindBy(accessibility = "Activity * Administration \uF0D7")
    public WebElement activityTrackTime;

//    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='Project Choose \uF0D7']]/XCUIElementTypeOther)")
    @iOSXCUITFindBy(accessibility = "Project Choose \uF0D7")
    public WebElement projectTrackTime;

//    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='Work package Choose \uF0D7']/XCUIElementTypeOther)")
    @iOSXCUITFindBy(accessibility = "Work package Choose \uF0D7")
    public WebElement workPackageTrackTime;

    @iOSXCUITFindBy(accessibility = "Log time, tab, 2 of 3")
    public WebElement logTime;

    @iOSXCUITFindBy(accessibility = "Duration")
    public WebElement durationLogTime;

    @iOSXCUITFindBy(accessibility = "From-To")
    public WebElement FromToLogTime;

    @iOSXCUITFindBy(accessibility = "Save")
    public WebElement saveButtonTrackTime;

    @iOSXCUITFindBy(accessibility = "Clear")
    public WebElement clearButtonTrackTime;

    @iOSXCUITFindBy(accessibility = "Cancel")
    public WebElement cancelWheelPicker;

    @iOSXCUITFindBy(accessibility = "Remove")
    public WebElement removeOverviewTrackTime;


    @iOSXCUITFindBy(accessibility = "Overview, tab, 3 of 3")
    public WebElement overview;

    //    Send Feedback
    @AndroidFindBy(xpath = "//android.widget.ProgressBar")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Your opinion is important to us!']")
    public WebElement sendFeedbackWeb;

}