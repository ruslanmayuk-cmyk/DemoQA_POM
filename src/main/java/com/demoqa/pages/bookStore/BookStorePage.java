package com.demoqa.pages.bookStore;

import com.demoqa.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class BookStorePage extends BasePage {

    public BookStorePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "searchBox")
    WebElement searchBox;

    public BookStorePage enterBookName(String text) {
        type(searchBox,text);
        return this;
    }


    @FindBy(css = ".mr-2 a")
    WebElement name0fBook;

    public BookStorePage verifyBookName(String text) {
        Assertions. assertTrue(shouldHaveText(name0fBook, text,10));
        return this;
    }


}
