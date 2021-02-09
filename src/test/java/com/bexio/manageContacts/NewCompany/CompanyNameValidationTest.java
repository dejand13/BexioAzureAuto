package com.bexio.manageContacts.NewCompany;

import com.bexio.logIn.Methods_LogIn;
import com.bexio.manageContacts.NewPerson.LastNameValidationTest;
import org.testng.annotations.Test;

public class CompanyNameValidationTest extends Methods_LogIn {

    @Test
    public void companyNameValidation() throws InterruptedException {
        LastNameValidationTest validation = new LastNameValidationTest();
        validation.lastNameValidation(false);
    }
}
