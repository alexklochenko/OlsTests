package OLS;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

    public static void FindByCssAndClickWithAction(String locator, WebDriver driver)
    {

        WebElement element=driver.findElement(By.cssSelector(locator));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }

//    Find and Set Css
    public static void FindByCssAndSet(String locator, WebDriver driver, String data)
    {
        WebElement element=driver.findElement(By.cssSelector(locator));
        element.sendKeys(data);
    }

//    Find and Clear
    public static void FindByCssAndClear(WebDriver driver, String locator)
    {
        WebElement element=driver.findElement(By.cssSelector(locator));
        element.clear();

    }

    //    Find and CheckText
    public static void FindByCssAndCheckText(WebDriver driver, String locator, String CheckText)
    {
        WebElement element=driver.findElement(By.cssSelector(locator));
        String textFromElement=element.getText();

        if(textFromElement.equals(CheckText))
        {
            System.out.println("Перевірка відбулась успішно. Дані що відображаються на екрані - " + CheckText);
        }
        else
        {
            System.out.println("Перевірка " + CheckText + " відбулась Помилково.");
        }


    }


    public static String FindByCssAndCheckTextReturnText(WebDriver driver, String locator, String CheckText)
    {
        WebElement element=driver.findElement(By.cssSelector(locator));
        String textFronElement=element.getText();

        if(textFronElement.equals(CheckText))
        {
            System.out.println("Перевірка відбулась успішно. Дані що відображаються на екрані - " + CheckText);
        }
        else
        {
            System.out.println("Перевірка " + CheckText + " відбулась Помилково.");
        }

        return textFronElement;

    }

//    FindAndGetText
    public static String FindAndGetTextByCss(WebDriver driver, String locator)
    {
        WebElement element=driver.findElement(By.cssSelector(locator));
        return element.getText();
    }

    public static String FindAndGetTextByXpath(WebDriver driver, String locator)
    {
        WebElement element = driver.findElement(By.xpath(""));
        return element.getText();
    }




//  Find Element and return value of fixed attribute
    public static String FindAndGetValueOfAttributeByCss(WebDriver driver, String locator, String attribute )
    {
        WebElement element=driver.findElement(By.cssSelector(locator));
        String AttribiteOfElement=element.getDomAttribute(attribute);
        return AttribiteOfElement;
    }


    public static void FindByCssAndSendKeys(String locator, WebDriver driver, String Keys)
    {
        WebElement element=driver.findElement(By.cssSelector(locator));
        element.sendKeys(Keys);
    }










//    Wating
    public static void WaitingElementToBeClickableByCss(WebDriverWait wait, WebDriver driver, String locator, int seconds)
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locator)));
    }


    public static void WaitingElementToBeClickableByXpath(WebDriverWait wait, WebDriver driver, String locator, int seconds)
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    }


    public static void WaitingElementToBeInvisibilityByCss(WebDriverWait wait, WebDriver driver, String locator, int seconds)
    {
        wait=new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(locator)));
    }

    public static void WaitingTextToBePresentInElementLocated(WebDriverWait wait, WebDriver driver, String locator, int seconds, String text)
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(locator), text));
    }

    public  static void WaitingElementToBePresentOnThePage(WebDriver driver, String locator, int time)
    {
            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
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



}
