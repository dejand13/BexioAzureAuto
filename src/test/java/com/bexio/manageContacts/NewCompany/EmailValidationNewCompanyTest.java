package com.bexio.manageContacts.NewCompany;

import com.bexio.logIn.Methods_LogIn;
import com.bexio.manageContacts.NewPerson.EmailValidationNewPersonTest;
import org.testng.annotations.Test;

public class EmailValidationNewCompanyTest extends Methods_LogIn {
    @Test
    public void emailValidationNewCompany() throws Exception {
        EmailValidationNewPersonTest validation = new EmailValidationNewPersonTest();
        validation.emailValidation(false);
    }
}
