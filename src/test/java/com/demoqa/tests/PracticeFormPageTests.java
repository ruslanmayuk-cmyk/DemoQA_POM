package com.demoqa.tests;
import com.demoqa.core.TestBase;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.forms.PracticeFormPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class PracticeFormPageTests extends TestBase {

    PracticeFormPage practiceForm;

    @BeforeEach
    public void precondition() {
        practiceForm = new PracticeFormPage(driver);
        new HomePage(driver).getForms();
        new SidePanel(driver).getPracticeForm();
    }

    // -------------PositiveTest--------------------------
    @Test
    public void createAccountPositiveTest() {
        practiceForm.enterPersonalData("Emily","Armstrong","linkinpark@gmail.com","1234567890")
                  .selectGender("Female")
                  .typeOfDate("6 May 1986")
                  .addSubject(new String[]{"Computer Science","English"})
                  .selectHobbies(new String[]{"Sports","Music"})
                  .uploadFile("C:\\Tools\\Emily.jpg")
                  .inputState("NCR")
                  .inputCity("Delhi")
                  .submit()
                  .verifySuccessRegistration("Thanks for submitting the form")
        ;
    }

    // -------------NegativeTest--------------------------

    @RepeatedTest(value = 3,name = "{displayName}{currentRepetition}/{totalRepetitions}")
    // запускаем повторяющийся тест (3 раза)

    @DisplayName("Verify phone validation and try to get error ")
    public void createAccountWithInvalidPhoneNegativeTest() {
        practiceForm.enterPersonalData("Emily","Armstrong","linkinpark@gmail.com","1234")
                .selectGender("Male")
                .selectDate("May","1986","6")
                .addSubject(new String[]{"Computer Science","English"})
                .selectHobbies(new String[]{"Sports","Music"})
                .uploadFile("C:\\Tools\\Emily.jpg")
                .inputState("NCR")
                .inputCity("Delhi")
                .submit()
                //.verifyRedBorderColor("rgba(207, 196, 203, 1)")
                .verifyFormTitle("Student Registration Form")
        ;
    }




}
