package OLS;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CheckMainPage {


    public  void CheckSalePage(WebDriver driver, WebDriverWait wait)
    {
        driver.get(Credentials.Environment);
        System.out.println("Логування статусів проходження тесту на сторінці Акції:");

        try
        {
            OlsSccMeths.WaitingElementToBeClickableByCss(wait, driver,OlsVarFoeCryptoTest.CookysOkButton,10 );
            OlsSccMeths.FindByCssAndClick(OlsVarFoeCryptoTest.CookysOkButton, driver);
        }
        catch( TimeoutException e)
        {
            System.out.println(" - Погодження з використанням політики кукіс не потребувало");
        }

        OlsSccMeths.FindByCssAndClick(OlsVarMainPage.MainHeaderButton, driver);

        try
        {
            OlsSccMeths.WaitingElementToBePresentOnThePage(driver, OlsVarMainPage.CheckLogoOnMainPage, 10);
        }
        catch(TimeoutException e)
        {
            System.out.println("Очікуваний елемент не зявився на екрані");
        }

        OlsSccMeths.FindByCssAndClick(OlsVarMainPage.SaleButtonOnMain, driver);
        try
        {
            OlsSccMeths.WaitingElementToBePresentOnThePage(driver,OlsVarMainPage.SalePageTextSale, 5);
            try
            {
                OlsSccMeths.WaitingElementToBePresentOnThePage(driver, OlsVarMainPage.LicForFopBaseForOneYear, 5 );
                try
                {
                    String LoyaltyForTwoYears=OlsSccMeths.FindAndGetTextByCss(driver, OlsVarMainPage.LicForFopBaseForOneYearPriceForTwoYearsLoyalty);
                    String LoyaltyForFoгкYears=OlsSccMeths.FindAndGetTextByCss(driver, OlsVarMainPage.LicForFopBaseForOneYearPriceForFourYearsLoyalty);


                    if (LoyaltyForTwoYears.equals(OlsVarMainPage.StaticPriceForTwoYears) && LoyaltyForFoгкYears.equals(OlsVarMainPage.StaticPriceFourTwoYears))
                    {
                        System.out.println(" - Перевірка цін на сторінці Акції - відбулась успішно.");
                    }
                    else
                    {
                        if(LoyaltyForTwoYears.equals(OlsVarMainPage.StaticPriceForTwoYears) && !LoyaltyForFoгкYears.equals(OlsVarMainPage.StaticPriceFourTwoYears))
                        {
                            System.out.println("Вартість ліцензії з програмою лояльності на 4-ри роки не відповідає задекларованій");
                        }
                        if(!LoyaltyForTwoYears.equals(OlsVarMainPage.StaticPriceForTwoYears) && LoyaltyForFoгкYears.equals(OlsVarMainPage.StaticPriceFourTwoYears))
                        {
                            System.out.println("Вартість ліцензії з програмою лояльності на 2-ри роки не відповідає задекларованій");
                        }
                    }
                }
                catch(NotFoundException e)
                {
                    System.out.println("Ліцензія комп’ютерної програми «Арт-Звіт Pro» для ФОП «Індивідуальна – Базова» на 1 рік: відсутня інформація про ціни на дану ліцензію");
                }
            }
            catch(NotFoundException e)
            {
                System.out.println("Ліцензія комп’ютерної програми «Арт-Звіт Pro» для ФОП «Індивідуальна – Базова» на 1 рік: дані про ліцензію відсутні на сторінці Акції");
            }

        }
        catch(NotFoundException e)
        {
            System.out.println("Відсутній заголовок на сторінці Акція");
        }

    }

    public  void CheckAboutAsPage(WebDriver driver, WebDriverWait wait)
    {
        driver.get(Credentials.Environment);
        System.out.println("Логування статусів проходження тесту на сторінці Про нас:");

        try {
            OlsSccMeths.WaitingElementToBeClickableByCss(wait, driver, OlsVarFoeCryptoTest.CookysOkButton, 10);
            OlsSccMeths.FindByCssAndClick(OlsVarFoeCryptoTest.CookysOkButton, driver);
        } catch (TimeoutException e) {
            System.out.println(" - Погодження з використанням політики кукіс не потребувало");
        }

        OlsSccMeths.FindByCssAndClick(OlsVarMainPage.MainHeaderButton, driver);

        try {
            OlsSccMeths.WaitingElementToBePresentOnThePage(driver, OlsVarMainPage.CheckLogoOnMainPage, 10);
        } catch (TimeoutException e) {
            System.out.println("Очікуваний елемент не зявився на екрані");
        }
        OlsSccMeths.FindByCssAndClick(OlsVarMainPage.AboutAsButtonOnMain, driver);

        try
        {
            OlsSccMeths.WaitingElementToBePresentOnThePage(driver, OlsVarMainPage.TitleOnAboutAsPage, 10);
            try
            {
                OlsSccMeths.WaitingElementToBePresentOnThePage(driver, OlsVarMainPage.MkLogoOnAboutAsPage, 2 );
                OlsSccMeths.WaitingElementToBePresentOnThePage(driver, OlsVarMainPage.AoLogoOnAboutAsPage, 2 );
                OlsSccMeths.WaitingElementToBePresentOnThePage(driver, OlsVarMainPage.AzLogoOnAboutAsPage, 2 );
                OlsSccMeths.WaitingElementToBePresentOnThePage(driver, OlsVarMainPage.AzProLogoOnAboutAsPage, 2 );
            }
            catch(TimeoutException e)
            {
                System.out.println("Один або більше логотипів не відображається на сторінці Про нас");
            }
        }
        catch(TimeoutException e)
        {
            System.out.println("Заголовок сторінки - відсутній");
        }

        try
        {
            OlsSccMeths.WaitingElementToBePresentOnThePage(driver, OlsVarMainPage.FooterContactInfo, 3);
            System.out.println(" - Перевірка сторінки Про нас - відбулась успішно.");
        }
        catch(TimeoutException e)
        {
            System.out.println("Відсутня контактна інформація у футері");
        }

    }

    public void CheckContactsPage (WebDriver driver, WebDriverWait wait)
    {
        driver.get(Credentials.Environment);

        System.out.println("Логування статусів проходження тесту на сторінці Контакти:");

        try
        {
            OlsSccMeths.WaitingElementToBeClickableByCss(wait, driver,OlsVarFoeCryptoTest.CookysOkButton,10 );
            OlsSccMeths.FindByCssAndClick(OlsVarFoeCryptoTest.CookysOkButton, driver);
        }
        catch( TimeoutException e)
        {
            System.out.println(" - Погодження з використанням політики кукіс не потребувало");
        }

        OlsSccMeths.FindByCssAndClick(OlsVarMainPage.ContactsButtonOnMain, driver);

        if ((OlsSccMeths.FindAndGetTextByCss(driver, OlsVarMainPage.AdressOnContactPsge)).equals(OlsVarMainPage.DcncAdress))
        {
            System.out.println(" - Перевірка юридичної адреси відбулась успішно");
            System.out.println(OlsSccMeths.FindAndGetTextByCss(driver, OlsVarMainPage.AdressOnContactPsge));
        }
        else
        {
            System.out.println("УВАГА! Дані не відповідають дійсноті. Необхідновиконати ретест або перевірити інформацію на сайті");
        }

        if ((OlsSccMeths.FindAndGetTextByCss(driver, OlsVarMainPage.SchedulerOnContactPsge)).equals(OlsVarMainPage.WorkSchedule))
        {
            System.out.println(" - Перевірка графіку роботи  відбулась успішно");
            System.out.println(OlsSccMeths.FindAndGetTextByCss(driver, OlsVarMainPage.SchedulerOnContactPsge));
        }
        else
        {
            System.out.println("УВАГА! Дані не відповідають дійсноті. Необхідновиконати ретест або перевірити інформацію на сайті");
        }

        if (
                (OlsSccMeths.FindAndGetTextByCss(driver, OlsVarMainPage.VfNumberOnContactPsge)).equals(OlsVarMainPage.VfNumber) &&
                (OlsSccMeths.FindAndGetTextByCss(driver, OlsVarMainPage.KsNumberOnContactPsge)).equals(OlsVarMainPage.KsNumber) &&
                (OlsSccMeths.FindAndGetTextByCss(driver, OlsVarMainPage.LifeNumberOnContactPsge)).equals(OlsVarMainPage.LifeNumber) &&
                (OlsSccMeths.FindAndGetTextByCss(driver, OlsVarMainPage.CityNumberOnContactPsge)).equals(OlsVarMainPage.CityNumber)
           )
        {
            System.out.println(" - Перевірка контактних номерів телефону  відбулась успішно");
            System.out.println(OlsSccMeths.FindAndGetTextByCss(driver, OlsVarMainPage.VfNumberOnContactPsge));
            System.out.println(OlsSccMeths.FindAndGetTextByCss(driver, OlsVarMainPage.KsNumberOnContactPsge));
            System.out.println(OlsSccMeths.FindAndGetTextByCss(driver, OlsVarMainPage.LifeNumberOnContactPsge));
            System.out.println(OlsSccMeths.FindAndGetTextByCss(driver, OlsVarMainPage.CityNumberOnContactPsge));
        }
        else
        {
            System.out.println("УВАГА! Дані не відповідають дійсноті. Необхідновиконати ретест або перевірити інформацію на сайті");
        }


        if ((OlsSccMeths.FindAndGetTextByCss(driver, OlsVarMainPage.EmailOnContactPsge)).equals(OlsVarMainPage.Email))
        {
            System.out.println(" - Перевірка Email  відбулась успішно");
            System.out.println(OlsSccMeths.FindAndGetTextByCss(driver, OlsVarMainPage.EmailOnContactPsge));
        }
        else
        {
            System.out.println("УВАГА! Дані не відповідають дійсноті. Необхідновиконати ретест або перевірити інформацію на сайті");
        }

        if
        (
        (OlsSccMeths.FindAndGetValueOfAttributeByCss(driver, OlsVarMainPage.LinkToBuyOnLineOnCotactPage, "href")).equals(OlsVarMainPage.LinkToBuyOnLine) &&
        (OlsSccMeths.FindAndGetValueOfAttributeByCss(driver, OlsVarMainPage.LinkToSupportOnCotactPage, "href")).equals(OlsVarMainPage.LinkToSupport)
        )
        {
            System.out.println(" - Перевірка посилань на сторінці  відбулась успішно");
            System.out.println(OlsSccMeths.FindAndGetValueOfAttributeByCss(driver, OlsVarMainPage.LinkToBuyOnLineOnCotactPage, "href"));
            System.out.println(OlsSccMeths.FindAndGetValueOfAttributeByCss(driver, OlsVarMainPage.LinkToSupportOnCotactPage, "href"));
        }
        else
        {
            System.out.println("УВАГА! Дані не відповідають дійсноті. Необхідновиконати ретест або перевірити інформацію на сайті");
        }

        try
        {
            OlsSccMeths.WaitingElementToBePresentOnThePage(driver, OlsVarMainPage.FooterContactInfo, 3);
            System.out.println(" - Перевірка сторінки Контакти - відбулась успішно.");
        }
        catch(TimeoutException e)
        {
            System.out.println("Відсутня контактна інформація у футері");
        }
    }

    public void CheckPartnerPage (WebDriver driver, WebDriverWait wait)
    {
        driver.get(Credentials.Environment);


        System.out.println("Логування статусів проходження тесту на сторінці Партнери:");

        try
        {
            OlsSccMeths.WaitingElementToBeClickableByCss(wait, driver,OlsVarFoeCryptoTest.CookysOkButton,10 );
            OlsSccMeths.FindByCssAndClick(OlsVarFoeCryptoTest.CookysOkButton, driver);
        }
        catch( TimeoutException e)
        {
            System.out.println(" - Погодження з використанням політики кукіс не потребувало");
        }

        OlsSccMeths.FindByCssAndClick(OlsVarMainPage.PartnerButtonOnMain, driver);

        try
        {
            ArrayList<String> array=new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(array.get(array.size()-1));

            String CurrentUrl=driver.getCurrentUrl();
            System.out.println(CurrentUrl);

        }
        catch(NotFoundException e)
        {
            System.out.println("УВАГА! Виникла помилка при перевірці сторінки Партнери" );
        }






    }










//
//
//
//
////      Устанавливаем размер окна браузера
//        Dimension size = new Dimension(1250, 800);
//        driver.manage().window().setSize(size);
//
//        driver.get("https://ols.am-soft.ua/");
//
////        close captcha pop-up
//
//        WebElement element= driver.findElement(By.xpath("//*[@id=\"cookie\"]/div/div[3]/button"));
//        element.click();
//
////      find and click Головна button
//        element= driver.findElement(By.xpath("/html/body/header/div[2]/div[1]/ul/li[1]"));
//        element.click();
//
//        WebElement elementForCheck=driver.findElement(By.xpath("/html/body/header/div[1]/a"));
//        element= driver.findElement(By.xpath("/html/body/header/div[1]/a"));
//
//        if (!element.equals(elementForCheck)){
//            System.out.println("CheckHeadersLinks is faild:\"Головна\" button ");
//        }
//        else {
//            System.out.println("Page \"Головна\" - ok");
//        }
//
////      find and click Акції button
//        element= driver.findElement(By.xpath("/html/body/header/div[2]/div[1]/ul/li[2]"));
//        element.click();
//
//        elementForCheck=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[1]/div/table/thead/tr/th[2]"));
//        element= driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[1]/div/table/thead/tr/th[2]"));
//
//        if (!element.equals(elementForCheck)){
//            System.out.println("CheckHeadersLinks is faild:\"Акції\" button ");
//        }
//        else {
//            System.out.println("Page \"Акції\" - ok");
//        }
//
////      find and click Про нас button
//        element= driver.findElement(By.xpath("/html/body/header/div[2]/div[1]/ul/li[3]"));
//        element.click();
//
//        elementForCheck=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]"));
//        element= driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]"));
//
//        if (!element.equals(elementForCheck)){
//            System.out.println("CheckHeadersLinks is faild:\"Про нас\" button ");
//        }
//        else {
//            System.out.println("Page \"Про нас\" - ok");
//        }
//
//
////      find and click Контакти button
//        element= driver.findElement(By.xpath("/html/body/header/div[2]/div[1]/ul/li[4]"));
//        element.click();
//
//        elementForCheck=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[2]/div[2]"));
//        element= driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[2]/div[2]"));
//
//        if (!element.equals(elementForCheck)){
//            System.out.println("CheckHeadersLinks is faild:\"Контакти\" button ");
//        }
//        else {
//            System.out.println("Page \"Контакти\" - ok");
//        }
//
////      find and click Партнерам button
//        element= driver.findElement(By.xpath("/html/body/header/div[2]/div[1]/ul/li[5]"));
//        element.click();
//
//
//        ArrayList <String> list=new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(list.get(1));
//
//        elementForCheck=driver.findElement(By.xpath("/html/body/header/div[1]/div[1]"));
//        element= driver.findElement(By.xpath("/html/body/header/div[1]/div[1]"));
//
//        if (!element.equals(elementForCheck)){
//            System.out.println("CheckHeadersLinks is faild:\"Партнерам\" button ");
//        }
//        else {
//            System.out.println("Page \"Партнерам\" - ok");
////            driver.close();
//        }
//
////      find and click API button
//        driver.switchTo().window(list.get(0));
//
//        element= driver.findElement(By.xpath("/html/body/header/div[2]/div[1]/ul/li[6]"));
//        element.click();
//
//
//        ArrayList<String> list2=new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(list2.get(2));
//
//
////      on API page: select & set PIB fild
//        element= driver.findElement(By.xpath("//*[@id=\"FullName\"]"));
//        element.click();
//        element.sendKeys("Тест Тест Тест");
//
////      on API page: select & set ORG_code fild
//        element=driver.findElement(By.xpath("//*[@id=\"OrgCode\"]"));
//        element.sendKeys("АА112233");
//
////      on API page: select & set phone number fild
//        element=driver.findElement(By.xpath("//*[@id=\"Phone\"]"));
//        element.click();
//        element.sendKeys("0991234578");
//
////      on API page: select & set Email fild
//        element=driver.findElement(By.xpath("//*[@id=\"Email\"]"));
//        element.sendKeys("test@test.ua");
//
//
////      on API page: select & set MK Deal Number fild
//        element=driver.findElement(By.xpath("//*[@id=\"DogovorNumber\"]"));
//        element.sendKeys("testDeal");
//
//
////      on API page: select & set checkbox AgreeWith
//        element=driver.findElement(By.xpath("//*[@id=\"agreement\"]"));
//        element.click();
//
////      on API page: select & set captcha Value
//        element= driver.findElement(By.xpath("//*[@id=\"captcha_TB_I\"]"));
//        element.click();
//
//        Scanner scanner2=new Scanner(System.in);
//        System.out.println("Set captcha value on API page!");
//        String temp2=scanner2.nextLine();
//
//        element.sendKeys(temp2);
//
////      on APS page: click Next button
//        element= driver.findElement(By.xpath("//*[@id=\"ApiRequestForm\"]/div[9]/input"));
//        element.click();
//
//        //  If wrong capture as wrought
//            try {
//                WebElement misstakeCaptcha =driver.findElement(By.xpath("//*[@id=\"captcha_TB_EC\"]"));
//                while (misstakeCaptcha != null){
//                    element=driver.findElement(By.xpath("//*[@id=\"agreement\"]"));
//                    element.click();
//
//                    element= driver.findElement(By.xpath("//*[@id=\"captcha_TB_I\"]"));
//                    element.click();
//
//                    Scanner scanner3=new Scanner(System.in);
//                    System.out.println("Set captcha value on API page!");
//                    String temp3=scanner3.nextLine();
//
//                    element.sendKeys(temp3);
//
//                    element= driver.findElement(By.xpath("//*[@id=\"ApiRequestForm\"]/div[9]/input"));
//                    element.click();
//
//                }
//            } catch (NoSuchElementException e) {
//                //      API page check resalt of the test
//                String ApiTestResaltChec="Дані успішно надіслані. Найближчим часом наш спеціаліст зв'яжеться з Вами для уточнення деталей запиту. Дякуємо!";
//                WebElement elementForCheckElement=driver.findElement(By.xpath("//*[@id=\"ApiRequestForm\"]/div/span"));
//                String elementForCheckString=elementForCheckElement.getText();
//
//
//                if(elementForCheckString.equals(ApiTestResaltChec)){
//                    System.out.println("Page \"API\" - ok");
//                    System.out.println(elementForCheckString);
//                    element= driver.findElement(By.xpath("//*[@id=\"ApiRequestForm\"]/a"));
//                    element.click();
//                }
//                else{
//                    System.out.println("CheckHeadersLinks is faild:\"API\" button");
//                }
//
//
//            }





}
