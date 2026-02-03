package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.bookStore.BookStorePage;
import com.demoqa.pages.bookStore.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookStoreTest extends TestBase {

    @BeforeEach
    public void precondition(){
        new HomePage(driver).getBookStore();
    }

    @Test
    public void loginPositiveTest() {
        new SidePanel(driver).getLogin();
        new LoginPage(driver).enterUserData("User1","qqqqWWWW$1")
                .clickOnLoginButton()
                .verifyUserName ("User1");
    }

    @Test
    public void searchBookPositiveTest() {
        new BookStorePage(driver).enterBookName("Git")
                .verifyBookName("Git");

    }
}
