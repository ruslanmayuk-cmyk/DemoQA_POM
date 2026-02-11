package com.demoqa.pages.elements;

import com.demoqa.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class UploadPage extends BasePage {

    Robot robot;

    public UploadPage(WebDriver driver) {
        super(driver);
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }


    @FindBy(id = "uploadFile")
    WebElement uploadFile;

    public UploadPage performKeyEvent() {
        scrollWithJS(0, 300, 500);
        clickWithRectangle(uploadFile);

        pause(1000);
        //press SHIFT key
        robot.keyPress(KeyEvent.VK_SHIFT);
        pause(1000);
        robot.keyPress(KeyEvent.VK_D);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_1);
        robot.keyPress(KeyEvent.VK_PERIOD);
        robot.keyPress(KeyEvent.VK_T);
        robot.keyPress(KeyEvent.VK_X);
        robot.keyPress(KeyEvent.VK_T);
        pause(1000);
        robot.keyPress(KeyEvent.VK_ENTER);

        pause(1000);
        return this;
    }

    @FindBy(id = "uploadedFilePath")
    WebElement uploadedFilePath;

    public UploadPage verifyFilePath(String path) {
        Assertions.assertTrue(containsText(path,uploadedFilePath));
        //System.out.println(uploadedFilePath.getText());
        return this;
    }

    public UploadPage performMouseEvent() {
        scrollWithJS(0, 300, 500);
        clickWithRectangle(uploadFile);

        pause(1000);
//        PointerInfo pointerInfo = MouseInfo.getPointerInfo();
//        Point location = pointerInfo.getLocation();
//        int x = (int) location.getX();
//        int y = (int) location.getY();
//        System.out.println(x + "***" + y);
//        pause(2000);


        // 1536 x 864

        robot.mouseMove(1250,240);
        pause(2000);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.keyPress(KeyEvent.VK_ENTER);
        pause(1000);


        return this;
    }
}
