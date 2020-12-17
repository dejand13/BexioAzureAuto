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

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert")
        public WebElement allowNotificationDialog;

    @AndroidFindBy(xpath="//android.widget.EditText[@resource-id='j_username']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Login | bexio\"]/XCUIElementTypeTextField")
        public WebElement username;

//    By username = By.xpath("//android.widget.EditText[@resource-id='j_username']");
//    public WebElement getUsername(){
//        return driver.findElement(username);
//    }
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='j_password']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField")
        public WebElement password;

//    By password = By.xpath("//android.widget.EditText[@resource-id='j_password']");
//    public WebElement getPassword(){
//        return driver.findElement(password);
//    }

    @AndroidFindBy(className = "android.widget.Button")
    @iOSXCUITFindBy(accessibility = "Login")
        public WebElement logginButton;

//    By loginButton = By.className("android.widget.Button");
//    public WebElement getLoginButton() {
//        return driver.findElement(loginButton);
//    }
//    @iOSXCUITFindBy(accessibility = "would like to connect to one of your companies.")
//        public WebElement availabilityOfLogInCompanyNamesList;
    // handle it like allowCameraPermissions
    //By availabilityOfLogInCompanyNamesList = By.xpath("//XCUIElementTypeStaticText[@name='would like to connect to one of your companies.']");
    //@AndroidFindBy(xpath = "//android.view.View[@text='bexioGo would like to connect to one of your companies.Please select one.']")
    @AndroidFindBy(xpath = "//android.view.View[@text='You can only select one company.']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='would like to connect to one of your companies.']")
        public WebElement availabilityOfLogInCompanyNamesList;

    @AndroidFindBy(xpath = "//android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeLink")
        public List <WebElement> logInCompanyNamesList;

//    By logInCompanyNamesList = By.xpath("//android.widget.TextView");
//    public List<WebElement> getLogInCompanyNamesList() {
//        return driver.findElements(logInCompanyNamesList);
//    }

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='View & edit your contacts']")
        public WebElement requestAccessTo;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_message")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='“bexioGo” Would Like to Access the Camera']")
        public WebElement allowCameraPermissions;

    @AndroidFindBy(xpath = "//android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText")
        public WebElement homeScreenCompanyName;

//    By homeScreenCompanyName = By.xpath("//android.widget.TextView");
//    public WebElement getHomeScreenCompanyName() {
//        return driver.findElement(homeScreenCompanyName);
//    }
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Scan Documents']")
    @iOSXCUITFindBy(accessibility = "Scan Documents \uF065\"")
        public WebElement scanDocument;

//    By scanDocument = By.xpath("//android.widget.TextView[@text='Scan Documents']");
//    public WebElement getScanDocument() {
//        return driver.findElement(scanDocument);
//    }

    @AndroidFindBy(xpath = "//android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Forgot password?']")
        public WebElement forgotPassLogInLink;

//    By forgotPassLogInLink = By.xpath("//android.widget.TextView");
//    public WebElement getForgotPassLogInLink() {
//        return driver.findElement(forgotPassLogInLink);
//    }

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Remember my choice']")
        public WebElement rememberMyChoiseCheckBox;

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

    By enterEmailForgotPass = By.xpath("//android.widget.EditText[@resource-id='recover_password_form_email']");
    public WebElement getEnterEmailForgotPass() {
        return driver.findElement(enterEmailForgotPass);
    }
}
