import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class Selectors {
    public AppiumDriver driver;
    public Selectors(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

//    Login selectors
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert")
        public WebElement allowNotificationDialog;

    @AndroidFindBy(xpath="//android.widget.EditText[@resource-id='j_username']")
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
        public List <WebElement> logInCompanyNamesList;

    @AndroidFindBy(xpath = "//android.view.View[@text='Remember my choice']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Remember my choice']")
    public WebElement rememberMyChoiseCheckBox;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Reject']")
    @iOSXCUITFindBy(accessibility = "Reject")
        public WebElement rejectAccess;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Allow']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Allow']")
    public WebElement allowAccessToCompany;

//    Home screen selectors
    @AndroidFindBy(xpath = "//android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText")
        public WebElement homeScreenCompanyName;

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

//    Manage Contacts
    //@AndroidFindBy
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"\uF015\"])[2]")
        public WebElement homeButton;

    //@AndroidFindBy
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"\uF067\"])[2]")
        public WebElement addContactButton;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"\uF002\"])[2]/XCUIElementTypeOther[2]/XCUIElementTypeTextField")
//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther")
        public WebElement searchBar;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='\uF007 Automation, Auto emailAddress@gmail.com']")
//    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"\uF007 Automation, Auto emailAddress@gmail.com\"])[3]")
        public WebElement searchAutomationContact;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='emailAddress@gmail.com']")
        public WebElement emailAddressAutomationContact;

//    Add Contact

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='Last name']")
        public WebElement lastName;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='First name']")
        public WebElement firstName;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther)[1]")
        public WebElement formOfAddress;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Mr.\"])[2]")
        public WebElement formOfAddressMr;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Choose \uF0D7\"])[2]")
//    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther)[2]")
        public WebElement title;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Dr.\"])[2]")
        public WebElement titleDr;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther)[3]")
        public WebElement languageOfCorrespondence;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Italian\"])[2]")
        public WebElement languageOfCorrItalian;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"E-Mail\"]/XCUIElementTypeOther/XCUIElementTypeTextField")
        public WebElement email;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"E-Mail This email address is not valid.\"]/XCUIElementTypeOther/XCUIElementTypeTextField")
        public WebElement invalidEmailTextBox;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"E-Mail 2\"]/XCUIElementTypeOther/XCUIElementTypeTextField")
        public WebElement email2;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"E-Mail 2 This email address is not valid.\"]/XCUIElementTypeOther/XCUIElementTypeTextField")
        public WebElement invalidEmail2TextBox;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Phone\"]/XCUIElementTypeOther/XCUIElementTypeTextField")
        public WebElement phone;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Phone 2\"]/XCUIElementTypeOther/XCUIElementTypeTextField")
        public WebElement phone2;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Mobile\"]/XCUIElementTypeOther/XCUIElementTypeTextField")
        public WebElement mobile;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Website\"]/XCUIElementTypeOther/XCUIElementTypeTextField")
        public WebElement website;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Street\"]/XCUIElementTypeTextField")
        public WebElement address;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Postcode\"])[3]/XCUIElementTypeTextField")
        public WebElement postcode;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"City\"])[4]/XCUIElementTypeTextField")
        public WebElement city;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Switzerland \uF0D7\"])[2]")
        public WebElement country;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Bulgaria\"])[2]")
        public WebElement countryBulgaria;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Finland\"])[2]")
        public WebElement countryFinland;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Remarks\"]/XCUIElementTypeOther/XCUIElementTypeTextView")
        public WebElement remarks;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Choose \uF0D7\"])[3]")
        public WebElement category;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"\uF0C8 QA!\"])[2]")
        public WebElement categoryQA;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Choose \uF0D7\"])[4]")
        public WebElement sectors;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"\uF0C8 Sector 1B\"])[2]")
        public WebElement sector1B;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Save\"]")
        public WebElement checkboxSaveButton;

    @iOSXCUITFindBy(accessibility = "Please provide a name")
        public WebElement lastNameValidation;

    @iOSXCUITFindBy(accessibility = "This email address is not valid.")
//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='This email address is not valid.']")
        public WebElement emailAddressValidation;

//    Edit Contact

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"\uF304\"])[2]")
        public WebElement editButton;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"\uF00C\"])[2]")
        public WebElement addContactSaveButton;



    //Scanner scene selectors
    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_message")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='“bexioGo” Would Like to Access the Camera']")
    public WebElement allowCameraPermissions;

}
