package com.bexio.init;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class Selectors {
    public AppiumDriver driver;

    public Selectors(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    //    Login selectors
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert")
    public MobileElement allowNotificationDialog;


    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='j_username']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Login | bexio\"]/XCUIElementTypeTextField")
    public MobileElement username;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='j_password']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField")
    public MobileElement password;

    @AndroidFindBy(className = "android.widget.Button")
    @iOSXCUITFindBy(accessibility = "Login")
    public MobileElement logginButton;

    //    Company choice screen selectors
    @AndroidFindBy(xpath = "//android.view.View[@text='You can only select one company.']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='would like to connect to one of your companies.']")
    public MobileElement availabilityOfLogInCompanyNamesList;

    @AndroidFindBy(xpath = "//android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeLink")
    public List<MobileElement> logInCompanyNamesList;

    @AndroidFindBy(xpath = "//android.view.View[@text='Remember my choice']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Remember my choice']")
    public MobileElement rememberMyChoiseCheckBox;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Reject']")
    @iOSXCUITFindBy(accessibility = "Reject")
    public MobileElement rejectAccess;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Allow']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Allow']")
    public MobileElement allowAccessToCompany;

    @AndroidFindBy(xpath = "//android.view.View[@text='View & edit your contacts']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='View & edit your contacts']")
    public MobileElement viewEditContacts;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Select a different company.']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Select a different company.']")
    public MobileElement selectDiffCompany;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Company already added.']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Company already added.']")
    public MobileElement companyAddedToastMessage;

    //    Home screen selectors
    @AndroidFindBy(xpath = "//android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText")
    public MobileElement homeScreenCompanyName;

    @AndroidFindBy(xpath = "//android.widget.TextView[@index='1']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText")
    public MobileElement switchCompanyNames;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Manage Contacts']")
    @iOSXCUITFindBy(accessibility = "Manage Contacts \uF0C0")
    public MobileElement manageContacts;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Scan Documents']")
    @iOSXCUITFindBy(accessibility = "Scan Documents \uF065")
    public MobileElement scanDocuments;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Track Time']")
    @iOSXCUITFindBy(accessibility = "Track Time")
    public MobileElement trackTime;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='My bexio Accounts']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@label='My bexio Accounts \uF013']")
    public MobileElement myBexioAccounts;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Send feedback']")
    @iOSXCUITFindBy(accessibility = "\uF075 Send feedback")
    public MobileElement sendFeedback;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Recommend']")
    @iOSXCUITFindBy(accessibility = "\uF4C4 Recommend")
    public MobileElement recommendBexio;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='\uF053']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='\uF053']")
    public MobileElement switchCompanyLeftArrow;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='\uF054']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='\uF054']")
    public MobileElement switchCompanyRightArrow;

    //    Forget password selectors
    @AndroidFindBy(xpath = "//android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Forgot password?']")
    public MobileElement forgotPassLogInLink;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='recover_password_form_email']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    public MobileElement enterEmailForgotPass;

    @AndroidFindBy(xpath = "//android.view.View[@text='This value is not a valid email address.']")
    @iOSXCUITFindBy(accessibility = "This value is not a valid email address.")
    public MobileElement notValidEmailAssert;

    @AndroidFindBy(xpath = "//android.view.View[@text='A message containing a link has been sent to your email address.']")
    @iOSXCUITFindBy(accessibility = "A message containing a link has been sent to your email address.")
    public MobileElement linkSuccessfullySentAssert;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Back to login']")
    @iOSXCUITFindBy(accessibility = "Back to login")
    public MobileElement backToLogInForgotPass;

    @AndroidFindBy(xpath = "//android.widget.Button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton")
    public MobileElement requestNewPassButton;

    //    Recommend bexio
    @AndroidFindBy(xpath = "//android.widget.EditText")
    public MobileElement recommendEmailAddress;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Send']")
    public MobileElement recommendSendButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Close']")
    public MobileElement recommendCloseButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='\uF00D']")
    public MobileElement recommendXbutton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Thank you!']")
    public MobileElement recommendThankYou;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='This is not a valid email address.']")
    public MobileElement invalidEmailToastMessage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='An email to this address has already been sent.']")
    public MobileElement recommentAlreadySentToastMessage;

    //    Manage Contacts
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='\uF015']")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"\uF015\"])[2]")
    public MobileElement homeButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='\uF067']")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"\uF067\"])[2]")
    public MobileElement addContactButton;

    @AndroidFindBy(xpath = "//android.widget.EditText")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"\uF002\"])[2]/XCUIElementTypeOther[2]/XCUIElementTypeTextField")
    public MobileElement searchBar;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Automation, Auto']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='\uF007 Automation, Auto emailAddress@gmail.com']")
    public MobileElement searchAutomationContact;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='emailAddress@gmail.com']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='emailAddress@gmail.com']")
    public MobileElement emailAddressAutomationContact;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='LastName, FirstName']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='\uF007 LastName, FirstName Email@email.com']")
    public MobileElement searchContactResultName;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Company name Name suffix']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='\uF1AD Company name Name suffix EmailComVer@email.com']")
    public MobileElement searchCompanyResultName;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='EmailPersonVer@email.com']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='\uF007 LastName, FirstName EmailPersonVer@email.com']")
    public MobileElement searchContactResultEmail;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='EmailComVer@email.com']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='\uF1AD Company name Name suffix EmailComVer@email.com']")
//    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"\uF1AD Company name Name suffix EmailComVer@email.com\"])[3]")
    public MobileElement searchCompanyResultEmail;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='No contacts found']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='No contacts found']")
    public MobileElement noContactsFound;

//    Add Contact

    //For iOS we are not able to select the element(selectors from BG element are given)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='New person']")
    public MobileElement newPerson;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='\uF007']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='\uF007 LastName, FirstName Email@email.com']")
    public MobileElement personAvatar;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='\uF1AD']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='\uF1AD Company name Name suffix EmailComVer@email.com']")
//    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"\uF1AD Company name Name suffix EmailComVer@email.com\"])[3]")
    public MobileElement companyAvatar;

    //For iOS we are not able to select the element(selectors from BG element are given)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='New company']")
    public MobileElement newCompany;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Company name']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Company name\"]/XCUIElementTypeTextField")
    public MobileElement companyName;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Name suffix']")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Name suffix\"])[2]/XCUIElementTypeTextField")
    public MobileElement nameSuffix;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText)[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='Last name']")
    public MobileElement lastName;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup/android.view.ViewGroup[@index='1']/android.widget.EditText)[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='First name']")
    public MobileElement firstName;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='2']/android.view.ViewGroup/android.widget.TextView[@text=Choose]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther)[1]")
    public MobileElement formOfAddress;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Mr.']")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Mr.\"])[2]")
    public MobileElement formOfAddressMr;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='3']/android.view.ViewGroup/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Choose \uF0D7\"])[2]")
    public MobileElement title;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Dr.']")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Dr.\"])[2]")
    public MobileElement titleDr;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='4']/android.view.ViewGroup/android.widget.TextView")
//    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Choose \uF0D7\"])[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Language of correspondence Choose \uF0D7\"]/XCUIElementTypeOther[@name='Choose \uF0D7']")
    public MobileElement languageOfCorrespondence;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Italian']")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Italian\"])[2]")
    public MobileElement languageOfCorrItalian;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='2']/android.view.ViewGroup/android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"E-Mail\"]/XCUIElementTypeOther/XCUIElementTypeTextField")
    public MobileElement email;

    //Same selector used as for email for GP
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='2']/android.view.ViewGroup/android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"E-Mail This email address is not valid.\"]/XCUIElementTypeOther/XCUIElementTypeTextField")
    public MobileElement invalidEmailTextBox;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@index='2']/android.view.ViewGroup/android.widget.EditText)[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"E-Mail 2\"]/XCUIElementTypeOther/XCUIElementTypeTextField")
    public MobileElement email2;

    //Same selector used as for email2 for GP
    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@index='2']/android.view.ViewGroup/android.widget.EditText)[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"E-Mail 2 This email address is not valid.\"]/XCUIElementTypeOther/XCUIElementTypeTextField")
    public MobileElement invalidEmail2TextBox;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@index='2']/android.view.ViewGroup/android.widget.EditText)[3]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Phone\"]/XCUIElementTypeOther/XCUIElementTypeTextField")
    public MobileElement phone;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@index='2']/android.view.ViewGroup/android.widget.EditText)[4]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Phone 2\"]/XCUIElementTypeOther/XCUIElementTypeTextField")
    public MobileElement phone2;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@index='2']/android.view.ViewGroup/android.widget.EditText)[5]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Mobile\"]/XCUIElementTypeOther/XCUIElementTypeTextField")
    public MobileElement mobile;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@index='2']/android.view.ViewGroup/android.widget.EditText)[6]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Website\"]/XCUIElementTypeOther/XCUIElementTypeTextField")
    public MobileElement website;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@index='4']/android.view.ViewGroup/android.widget.EditText)[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Street\"]/XCUIElementTypeTextField")
    public MobileElement address;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@index='4']/android.view.ViewGroup/android.widget.EditText)[2]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Postcode\"])[3]/XCUIElementTypeTextField")
    public MobileElement postcode;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@index='4']/android.view.ViewGroup/android.widget.EditText)[3]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"City\"])[4]/XCUIElementTypeTextField")
    public MobileElement city;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@index='4']/android.view.ViewGroup[@index='3']/android.view.ViewGroup/android.widget.TextView)")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Switzerland \uF0D7\"])[2]")
    public MobileElement country;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Switzerland']")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Switzerland \uF0D7\"])[2]")
    public MobileElement defaultCountrySwiss;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='7']/android.view.ViewGroup/android.widget.TextView[@text='Bulgaria']")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Bulgaria\"])[2]")
    public MobileElement countryBulgaria;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Finland']")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Finland\"])[2]")
    public MobileElement countryFinland;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@index='5']/android.view.ViewGroup/android.widget.EditText)[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Remarks\"]/XCUIElementTypeOther/XCUIElementTypeTextView")
    public MobileElement remarks;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@index='5']/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView)")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Choose \uF0D7\"])[3]")
    public MobileElement category;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='QA!']")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='\uF0C8 QA!'])[2]")
    public MobileElement categoryQA;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@index='5']/android.view.ViewGroup[@index='2']/android.view.ViewGroup/android.widget.TextView)")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Choose \uF0D7\"])[4]")
    public MobileElement sectors;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sector 1B']")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='\uF0C8 Sector 1B'])[2]")
    public MobileElement sector1B;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Save']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Save\"]")
    public MobileElement checkboxSaveButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Please provide a name']")
    @iOSXCUITFindBy(accessibility = "Please provide a name")
    public MobileElement lastNameValidation;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='This email address is not valid.']")
    @iOSXCUITFindBy(accessibility = "This email address is not valid.")
    public MobileElement emailAddressValidation;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='\uF067']")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"\uF00C\"])[2]")
    public MobileElement addContactSaveButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='\uF015']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='\uF053']")
    public MobileElement backButtonContactDetailView;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Contact list empty.']")
    @iOSXCUITFindBy(accessibility = "Contact list empty.")
    public MobileElement contactListEmpty;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='\uF015']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='\uF00D']")
    public MobileElement manageContactsXButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Edit Contact, Edit Contact First Name']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='\uF007 Edit Contact, Edit Contact First Name EditContact@edit.com']")
    public MobileElement noConnToastMessageContact;

    //    Edit Contact
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='\uF067']")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"\uF304\"])[2]")
    public MobileElement editButton;

    // Added Contact - Detailed view
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Switzerland']")
    @iOSXCUITFindBy(accessibility = "Switzerland")
    public MobileElement countryDetailedView;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='\uF0E0']")
    @iOSXCUITFindBy(accessibility = "\uF0E0")
    public MobileElement emailIcon;

    @AndroidFindBy(accessibility = "//android.widget.ImageView[@text='Attach File']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Mail.ccBccMultiField']")
    public MobileElement tapMailSymbol;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='\uF095']")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"\uF095\"])[1]")
    public MobileElement phoneIcon;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='WXYZ']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText")
    public MobileElement callNumber;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
    public MobileElement cancelCallNumber;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='\uF095'])[2]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"\uF095\"])[2]")
    public MobileElement mobilePhoneIcon;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='\uF086']")
    @iOSXCUITFindBy(accessibility = "\uF086")
    public MobileElement mobileMessageIcon;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Text copied to clipboard.']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Text copied to clipboard.']")
    public MobileElement copiedToClipboard;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='EmailComVer@email.com']")
    @iOSXCUITFindBy(accessibility = "EmailComVer@email.com")
    public MobileElement copiedToClipboardEmail;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Email2ComVer@email.com']")
    @iOSXCUITFindBy(accessibility = "Email2ComVer@email.com")
    public MobileElement copiedToClipboardEmail2;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='0002444555']")
    @iOSXCUITFindBy(accessibility = "0002444555")
    public MobileElement copiedToClipboardPhone;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='0038979333444']")
    @iOSXCUITFindBy(accessibility = "0038979333444")
    public MobileElement copiedToClipboardMobile;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Switzerland']")
    @iOSXCUITFindBy(accessibility = "Switzerland")
    public MobileElement copiedToClipboardSwitzerland;

    @AndroidFindBy(accessibility = "Navigate up")
    @iOSXCUITFindBy(accessibility = "+389 79333444, +38979333444")
    public MobileElement tapMessageChatSymbol;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='\uF3C5']")
    @iOSXCUITFindBy(accessibility = "\uF3C5")
    public MobileElement locationIcon;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Directions']")
    @iOSXCUITFindBy(accessibility = "Tracking")
    public MobileElement tapLocationSymbol;

    //    My bexio Accounts
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='\uF067']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='\uF067']")
    public MobileElement myBexioAccAddCompany;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Remove']")
    @iOSXCUITFindBy(accessibility = "Remove")
    public MobileElement myBexioRemove;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='REMOVE']")
    @iOSXCUITFindBy(accessibility = "Remove")
    public MobileElement removeButtonDialog;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='No internet connection found! Newly created data can be uploaded at a later time. Some functions of the app may only be used to a limited extent.']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='No internet connection found! Newly created data can be uploaded at a later time. Some functions of the app may only be used to a limited extent.']")
    public MobileElement myBexioNoInternetToastMessage;

    @iOSXCUITFindBy(accessibility = "airplane-mode-button")
    public MobileElement airplaneModeButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='No SIM Card Installed']")
    public MobileElement noSimCardInstalled;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='OK']")
    public MobileElement noSimCardInstalledClose;

    //    Scanner scene selectors
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Scan and send to inbox']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='\uF574 Scan and send to inbox \uF054']")
    public MobileElement scanSendToInbox;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_message")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='“bexioGo” Would Like to Access the Camera']")
    public MobileElement allowCameraPermissions;

    //    Track Time
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Stopwatch']")
    @iOSXCUITFindBy(accessibility = "Stopwatch, tab, 1 of 3")
    public MobileElement stopwatch;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Add description']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='Add description']")
    public MobileElement addDescriptionTrackTime;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='More']")
    @iOSXCUITFindBy(xpath ="(//XCUIElementTypeOther[@name='More \uF0D7'])[2]")
    public MobileElement moreTrackTime;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Less']")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='Less \uF0D8'])[2]")
    public MobileElement lessTrackTime;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='4']/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Entry can be invoiced']/XCUIElementTypeOther")
    public MobileElement toggleButtonTrueTrackTime;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Choose']")
    @iOSXCUITFindBy(accessibility = "Contact Choose \uF0D7")
    public MobileElement contactTrackTime;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Search contacts']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='Search contacts']")
    public MobileElement searchContactMoreDialogTrackTime;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='LastName, FirstName']")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='\uF007 LastName, FirstName EmailPersonVer@email.com'])[3]")
    public MobileElement tapOnLastNameContactTrackTime;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='General']")
    @iOSXCUITFindBy(accessibility = "General \uF0D7")
    public MobileElement activityTrackTime;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Administration']")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='Administration'])[2]")
    public MobileElement tapOnAdministrationActivityTrackTime;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='Choose'])")
    @iOSXCUITFindBy(accessibility = "Project Choose \uF0D7")
    public MobileElement projectTrackTime;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Project']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Project \uF002']")
    public MobileElement projectSearchBarTrackTime;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Melon Test Automation Project']")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='Melon Test Automation Project'])[2]")
    public MobileElement melonTestAutomationProjectTrackTime;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='Choose'])")
    @iOSXCUITFindBy(accessibility = "Work package Choose \uF0D7")
    public MobileElement workPackageTrackTime;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Work package']")
    @iOSXCUITFindBy(xpath ="//XCUIElementTypeOther[@name='Work package']/XCUIElementTypeTextField")
    public MobileElement workPackageSearchBarTrackTime;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Melon Test Automation Work Package']")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='Melon Test Automation Work Package'])[2]")
    public MobileElement melonTestAutomationWorkPackageTrackTime;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Log time']")
    @iOSXCUITFindBy(accessibility = "Log time, tab, 2 of 3")
    public MobileElement logTime;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Duration']")
    @iOSXCUITFindBy(accessibility = "Duration")
    public MobileElement durationLogTime;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='From-To']")
    @iOSXCUITFindBy(accessibility = "From-To")
    public MobileElement fromToLogTime;

    //using coordinates for iOS
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='\uF04B']")
    public MobileElement playButtonTackTime;

    //using coordinates for iOS
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='\uF04C']")
    public MobileElement pauseButtonTrackTime;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Save']")
    @iOSXCUITFindBy(accessibility = "Save")
    public MobileElement saveButtonTrackTime;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Clear']")
    @iOSXCUITFindBy(accessibility = "Clear")
    public MobileElement clearButtonTrackTime;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Cancel']")
    @iOSXCUITFindBy(accessibility = "Cancel")
    public MobileElement cancelWheelPicker;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='\uF1F8']")
    @iOSXCUITFindBy(accessibility = "Remove")
    public MobileElement removeOverviewTrackTime;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Overview']")
    @iOSXCUITFindBy(accessibility = "Overview, tab, 3 of 3")
    public MobileElement overview;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='00:00 saved but not uploaded to bexio yet. Please check your internet connection and try to upload in the Overview again.']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='00:00 saved but not uploaded to bexio yet. Please check your internet connection and try to upload in the Overview again.']")
    public MobileElement noConnToastMessageTrackTime;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='End time']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='End time \uF017']")
    public MobileElement endTimeRangeTrackTime;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Date']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Date \uF073']")
    public MobileElement endDateRangeTrackTime;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypePickerWheel")
    public MobileElement dateOrHourWheelPicker;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypePickerWheel)[2]")
    public MobileElement monthOrMinuteWheelPicker;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypePickerWheel)[3]")
    public MobileElement yearWheelPicker;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='\uF12A']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='\uF12A']")
    public MobileElement savedNotUploadedExplanationMark;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='\uF00C']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='\uF00C']")
    public MobileElement savedSymbolTrackTime;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='View']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='View']")
    public MobileElement viewTimeTrackToastMessage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Today']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Today']")
    public MobileElement todayCreatedTrackingOverview;

    //    Send Feedback
    @AndroidFindBy(xpath = "//android.widget.ProgressBar")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Your opinion is important to us!']")
    public MobileElement sendFeedbackWeb;

}