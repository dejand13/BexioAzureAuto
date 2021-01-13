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

    //Login selectors
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

    //Company choice screen selectors
    @AndroidFindBy(xpath = "//android.view.View[@text='You can only select one company.']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='would like to connect to one of your companies.']")
        public WebElement availabilityOfLogInCompanyNamesList;

    @AndroidFindBy(xpath = "//android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeLink")
        public List <WebElement> logInCompanyNamesList;

    @AndroidFindBy(xpath = "//android.view.View[@text='View & edit your contacts']")
//    @AndroidFindBy(xpath = "//android.view.View[@text='bexioGo requests access to Melon 3 and will be able to:']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='View & edit your contacts']")
        public WebElement requestAccessTo;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Reject']")
    @iOSXCUITFindBy(accessibility = "Reject")
        public WebElement rejectAccess;

    //Home screen selectors
    @AndroidFindBy(xpath = "//android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText")
        public WebElement homeScreenCompanyName;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Scan Documents']")
    @iOSXCUITFindBy(accessibility = "Scan Documents \uF065\"")
        public WebElement scanDocument;

//    @AndroidFindBy(xpath = "//android.view.View[@text='Remember my choice']")
//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Remember my choice']")
//        public WebElement rememberMyChoiseCheckBox;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Allow']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Allow']")
        public WebElement allowAccessToCompany;

    By scanSendToInbox = By.xpath("//android.widget.TextView[@index='1']");
    public WebElement getScanSendToInbox() {
        return driver.findElement(scanSendToInbox);
    }

    By permissionDialogMessageAfterDeny = By.id("com.android.permissioncontroller:id/permission_message");
    public WebElement getPermissionDialogMessageAfterDeny() {
        return driver.findElement(permissionDialogMessageAfterDeny);
    }

    //Forget password selectors
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

    //Scanner scene selectors
    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_message")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='“bexioGo” Would Like to Access the Camera']")
    public WebElement allowCameraPermissions;

}
