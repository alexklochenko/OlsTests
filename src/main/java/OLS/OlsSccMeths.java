package OLS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

    public class OlsSccMeths
{



//    Find and Click Css
    public static void FindByCssAndClick(String locator, WebDriver driver)
    {
        WebElement element=driver.findElement(By.cssSelector(locator));
        element.click();
    }

    //    Find and Set Css
    public static void FindByCssAndSet(String locator, WebDriver driver, String data)
    {
        WebElement element=driver.findElement(By.cssSelector(locator));
        element.sendKeys(data);
    }




    //    Wating Css
    public static void WaitingElementToBeClickableByCss(WebDriverWait wait, WebDriver driver, String locator, int seconds)
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locator)));
    }

    public static void WaitingTextToBePresentInElementLocated(WebDriverWait wait, WebDriver driver, String locator, int seconds, String text)
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(locator), text));
    }

    //  Choose filefrom PC
    public static void ChooseFileFromPC(String WayToPKey) throws AWTException
    {
        Robot robot = new Robot();
        robot.delay(2000);
        StringSelection stringSelection = new StringSelection(WayToPKey);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(2000);
    }





// Xpath
    public static void FindByXpathAndClick(String locator, WebDriver driver)
{
    WebElement element=driver.findElement(By.xpath(locator));
    element.click();
}

    //    Find and Set Css
    public static void FindByXpathAndSet(String locator, WebDriver driver, String data)
    {
        WebElement element=driver.findElement(By.xpath(locator));
        element.sendKeys(data);
    }






    //    Wating Xpath
    public static void WaitingElementToBeClickableByXpath(WebDriverWait wait, WebDriver driver, String locator, int seconds)
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    }

}
