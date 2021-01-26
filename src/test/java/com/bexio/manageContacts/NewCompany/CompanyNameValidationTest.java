package com.bexio.manageContacts.NewCompany;

import com.bexio.logInHomeScreen.LoginTest;
import com.bexio.manageContacts.NewPerson.LastNameValidationTest;
import org.testng.annotations.Test;

public class CompanyNameValidationTest extends LoginTest {

    @Test
    public void companyNameValidation() throws InterruptedException {
        LastNameValidationTest validation = new LastNameValidationTest();
        validation.lastNameValidation(false);
    }
}
