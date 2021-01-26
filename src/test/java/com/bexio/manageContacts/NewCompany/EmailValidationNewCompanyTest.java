package com.bexio.manageContacts.NewCompany;

import com.bexio.logInHomeScreen.LoginTest;
import com.bexio.manageContacts.NewPerson.EmailValidationNewPersonTest;
import org.testng.annotations.Test;

public class EmailValidationNewCompanyTest extends LoginTest {
    @Test
    public void emailValidationNewCompany() throws Exception {
        EmailValidationNewPersonTest validation = new EmailValidationNewPersonTest();
        validation.emailValidation(false);
    }
}
