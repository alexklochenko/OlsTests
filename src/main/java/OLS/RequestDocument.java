package OLS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RequestDocument
{
    public static void CheckHeeder(WebDriver driver, String locator, String IdRequest, String OrgEdrpoInRequwst)
    {
        WebElement element=driver.findElement(By.xpath(locator));
        String TextFromElement=element.getText();
        String TestFromRequest="ЗАЯВА-ПРИЄДНАННЯ № "+IdRequest+"/"+OrgEdrpoInRequwst;

        if (TextFromElement.equals(TestFromRequest))
        {
            System.out.println(" - Перевірено заголовок на бланку Заява приєднання. Номер замовлення та ЕДРПОУ орг - відповідає значенням вказаним на кроці 2");
        }
        else
        {
            System.out.println(" - Увага!!! Перевірку заголовка на бланку Заява приєднання - НЕ ПРОЙДЕНО");
        }



    }


}
