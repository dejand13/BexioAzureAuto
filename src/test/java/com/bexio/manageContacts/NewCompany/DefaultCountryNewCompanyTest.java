package com.bexio.manageContacts.NewCompany;

import com.bexio.logIn.Methods_LogIn;
import com.bexio.manageContacts.NewPerson.DefaultCountryNewPersonTest;
import org.testng.annotations.Test;

public class DefaultCountryNewCompanyTest extends Methods_LogIn {
    @Test
    public void defaultCountryNewCompany() {
        DefaultCountryNewPersonTest defaultValidation = new DefaultCountryNewPersonTest();
        defaultValidation.defaultCountry(false);
    }
}
