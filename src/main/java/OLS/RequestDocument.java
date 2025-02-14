package OLS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RequestDocument
{
    public static String CheckZayavaHeeder(WebDriver driver, String locator, String IdRequest, String OrgEdrpoInRequwst)
    {
        WebElement element=driver.findElement(By.xpath(locator));
        String TextFromElement=element.getText();
        String TestFromRequest="ЗАЯВА-ПРИЄДНАННЯ № "+IdRequest+"/"+OrgEdrpoInRequwst;

        if (TextFromElement.equals(TestFromRequest))
        {
            System.out.println("Перевірено заголовок на бланку Заява приєднання. Номер замовлення та ЕДРПОУ орг - відповідає значенням вказаним на кроці 2");
        }
        else
        {
            System.out.println("Увага!!! Перевірку заголовка на бланку Заява приєднання - НЕ ПРОЙДЕНО");
        }
        return TestFromRequest;
    }


    public static String CheckZayavaNomCount (WebDriver driver, String locator, String CountAtStep11)
    {
        WebElement element=driver.findElement(By.xpath(locator));
        String CountFromElement=element.getText();
        String CountFromRequest=CountAtStep11;

        if (CountFromElement.equals(CountFromRequest))
        {
            System.out.println("Перевірено кількості транзакцій в замовленні  - відповідає значенням вказаним на кроці 1");
        }
        else
        {
            System.out.println("Увага!!! Перевірку кількості транзакцій в замовленні - НЕ ПРОЙДЕНО");
        }
        return CountFromElement;
    }




}
