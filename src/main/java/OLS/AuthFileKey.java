package OLS;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthFileKey
{

    public void AuthWithTestKndpKey (WebDriver driver, WebDriverWait wait, String PasswordForKey, String WayToKey) {
        driver.get("https://ols-test.am-soft.ua/ols.test");

//        Close Ми використовуємо Сookie
        try {
            OlsSccMeths.FindByCssAndClick(OlsVarables.ClosePopupButton, driver);
        } catch (NoSuchElementException e) {
            System.out.println("Ми використовуємо \"Сookie\" - does not need to conferm");
        }

//        find and click Enter Button
        OlsSccMeths.FindByCssAndClick(OlsVarables.EnterButtonMain, driver);

//        find and click  FileKey Type of Auth
        OlsSccMeths.FindByCssAndClick(OlsVarables.DropDownAuthWithFileTypeOfKeyMain, driver);

//        Check that initialization is complete
        try {
            OlsSccMeths.WaitingElementToBeClickableByCss(wait, driver, OlsVarables.PasswordInputFild, 30);
        } catch (ElementClickInterceptedException e) {
            System.out.println("initialization was not complete in 30 seconds");
        }

//        Choose KNDP DropDownList
        try {
            OlsSccMeths.WaitingElementToBeClickableByCss(wait, driver,OlsVarables.KNDPDropDownList, 10);
        } catch (TimeoutException e) {
            System.out.println("не нашло випадающий список");
        }
        OlsSccMeths.FindByCssAndClick(OlsVarables.KNDPDropDownList, driver);

//        Choose type of KNDP
        OlsSccMeths.FindByCssAndClick(OlsVarables.KNDPDropDownListTestKNDP, driver);

//        Set pass
        OlsSccMeths.FindByCssAndSet(OlsVarables.PasswordInputFild, driver, PasswordForKey);

//        CheckboxRememberPasswordForSession
        OlsSccMeths.FindByCssAndClick(OlsVarables.CheckboxRememberPasswordForSession, driver);

//        Get key
        OlsSccMeths.FindByCssAndClick(OlsVarables.ChooseFileFromPc, driver);
        try {
            OlsSccMeths.ChooseFileFromPC(WayToKey);
        } catch (AWTException e) {
            System.out.println("Problem with export key-6.dat");
        }
//
        OlsSccMeths.FindByCssAndClick(OlsVarables.EnterButtonAuthPage, driver);

        try
        {
            OlsSccMeths.WaitingTextToBePresentInElementLocated(wait, driver, OlsVarables.CheckInfoFromCert,60,OlsVarables.OrgNameFromCert);
            System.out.println("Дані з сертифікату в кабінеті користувача відповідают очікуваному результату");
        }
        catch(NoSuchElementException e)
        {
            System.out.println("Помилка при перевірці успіху авторизації у кабінет");
        }





//        public static void DpsKey () throws AWTException {
//            ChromeDriver driver3 = new ChromeDriver();
//            WebDriverWait wait = new WebDriverWait(driver3, Duration.ofSeconds(1000));
//
//            driver3.get("https://ols.am-soft.ua/account/authjs");
//
////        find and close cooky pop-up
//            WebElement element = driver3.findElement(By.xpath("//*[@id=\"cookie\"]/div/div[3]/button"));
//            element.click();
//
//
////        element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"fgPKeyFileName\"]/div/div/span[2]")));
//
//
////        rundom click
//
//            for (int i = 0; i < 20; i++) {
//                element = driver3.findElement(By.xpath("//*[@id=\"MainFormId\"]/div[2]/div[1]"));
//                element.click();
//            }
//
//
////        find and choose KNDP
//            element = driver3.findElement(By.xpath("//*[@id=\"CAsServersSelect\"]/option[2]"));
//            element.click();
//
////        find and set Pass
//            element = driver3.findElement(By.xpath("//*[@id=\"PKeyPassword\"]"));
//            element.sendKeys("11223377");
//
////        find and click choose Key
//            element = driver3.findElement(By.xpath("//*[@id=\"fgPKeyFileName\"]/div/div/span[2]"));
//            element.click();
//
//
////       work with Window
//            Robot robot = new Robot();
//            robot.delay(2000);
//            StringSelection stringSelection = new StringSelection("C:\\Users\\oleks\\OneDrive\\Документи\\not for all\\Key\\ДПС_после_08_03\\Key-6.dat");
//            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
//
//////        // Нажимаем комбинацию клавиш для вставки пути к файлу в окно
//            robot.keyPress(KeyEvent.VK_CONTROL);
//            robot.keyPress(KeyEvent.VK_V);
//            robot.keyRelease(KeyEvent.VK_V);
//            robot.keyRelease(KeyEvent.VK_CONTROL);
//
//////        // Нажимаем клавишу Enter для выбора файла
//            robot.keyPress(KeyEvent.VK_ENTER);
//            robot.keyRelease(KeyEvent.VK_ENTER);
//
//
////        find and enter checkBox Save Pass
//            element = driver3.findElement(By.xpath("//*[@id=\"MainFormId\"]/div[2]/div[2]/div[18]/div/div/label"));
//            element.click();
//
//
////        find and enter VHID
//            element = driver3.findElement(By.xpath("//*[@id=\"btnLogon\"]"));
//            element.click();
//
//
////        check resalt of the TestCase
//            element = driver3.findElement(By.xpath("//*[@id=\"ols-brand\"]"));
//
//            if (element != null) {
//                System.out.println("AuthOLS with Dps Key is OK");
//            } else {
//                System.out.println("AuthOLS with Dps Key is faild");
//            }
//
////       close browser
//            driver3.quit();
//
//
//        }
    }
}
