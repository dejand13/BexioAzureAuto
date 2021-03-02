package com.bexio.trackTime;

import com.bexio.logIn.LogIn_Selectors;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class Selectors_TrackTime extends LogIn_Selectors {
    public AppiumDriver driver;

    public Selectors_TrackTime(AppiumDriver driver) {
        super(driver);
    }
//    public Selectors_TrackTime(AppiumDriver driver) {
//        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
//    }

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

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Stopwatch track time']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='\uF2F2 LastName, FirstName Stopwatch track time 00:00']")
    public MobileElement verifyStopwatchTrackTimeEntryCreatedInOverview;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Log Time - Duration track time']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='\uF2F2 LastName, FirstName Log Time - Duration track time 02:02']")
    public MobileElement verifyDurationTrackTimeEntryCreatedInOverview;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Log Time - From-To track time']")
    @iOSXCUITFindBy(xpath = ("//XCUIElementTypeOther[contains(@name,'\uF07E LastName, FirstName Log Time - From-To track time')]"))
    public MobileElement verifyFromToTrackTimeEntryCreatedInOverview;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='\uF017']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='00:00 \uF017']")
    public MobileElement openDurationTimeWheelPicker;

    //Using coordinates for iOS
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='\uF073']")
    public MobileElement openDurationDateWheelPicker;

    //Using coordinates for iOS
    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='\uF073'])[2]")
    public MobileElement openFromToDateWheelPicker;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Upload failed']")
//    @iOSXCUITFindBy(xpath = ("//XCUIElementTypeOther[contains(@name,'Upload failed \uF12A')]"))
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='\uF2F2 Add description Upload failed \uF12A'])[3]")
    public MobileElement uploadFailedTrackTimeRecord;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='\uF2F2']")
    @iOSXCUITFindBy(xpath = ("//XCUIElementTypeOther[contains(@name,'\uF2F2')]"))
    public MobileElement stopwatchSymbolOverview;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='\uF0EE']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='\uF0EE']")
    public MobileElement uploadSymbolOverview;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='\uF1F8']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='\uF1F8']")
    public MobileElement deleteSymbolOverview;
}
