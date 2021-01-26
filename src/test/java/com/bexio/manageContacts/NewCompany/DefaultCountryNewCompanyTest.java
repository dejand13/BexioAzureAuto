package com.bexio.manageContacts.NewCompany;

import com.bexio.logInHomeScreen.LoginTest;
import com.bexio.manageContacts.NewPerson.DefaultCountryNewPersonTest;
import org.testng.annotations.Test;

public class DefaultCountryNewCompanyTest extends LoginTest {
    @Test
    public void defaultCountryNewCompany() {
        DefaultCountryNewPersonTest defaultValidation = new DefaultCountryNewPersonTest();
        defaultValidation.defaultCountry(false);
    }
}
