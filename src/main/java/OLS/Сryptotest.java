package OLS;

import com.sun.security.jgss.GSSUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLOutput;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Scanner;

public class Сryptotest {
    public  void СryptotestWithFileKey(WebDriver driver, WebDriverWait wait){

        driver.get(Credentials.Environment);

        try
        {
            OlsSccMeths.WaitingElementToBeClickableByCss(wait, driver,OlsVarFoeCryptoTest.CookysOkButton,10 );
            OlsSccMeths.FindByCssAndClick(OlsVarFoeCryptoTest.CookysOkButton, driver);
        }
        catch( TimeoutException e)
        {
            System.out.println("Погодження з використанням політики кукіс не потребувало");
        }

        OlsSccMeths.FindByCssAndClick(OlsVarMainPage.EnterButtonOnMainPage, driver);

        OlsSccMeths.WaitingElementToBePresentOnThePage(driver, OlsVarMainPage.EnterWithFileKeyOnMainPage, 5);
        OlsSccMeths.FindByCssAndClick(OlsVarMainPage.EnterWithFileKeyOnMainPage, driver);

        OlsSccMeths.WaitingElementToBeClickableByCss(wait, driver, OlsVarables.EnterButtonAuthPage, 60);
        OlsSccMeths.FindByCssAndClick(OlsVarFoeCryptoTest.CheckButtonOnAuthPage, driver);

        ArrayList <String> list=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(list.get(list.size()-1));


        OlsSccMeths.WaitingElementToBeClickableByCss(wait, driver,OlsVarFoeCryptoTest.InputFildForTestData, 60);

        OlsSccMeths.WaitingElementToBeClickableByCss(wait, driver, OlsVarFoeCryptoTest.CheckTxtOnCryptoPage ,20);

        String JsLibVersion=OlsSccMeths.FindAndGetTextByCss(driver, OlsVarFoeCryptoTest.JsCryptoVersionArheader );

        System.out.println("===================");
        System.out.println("Версія клієнтської бібліотеки що використовується - "+JsLibVersion);

        OlsSccMeths.FindByCssAndClick(OlsVarFoeCryptoTest.SelectFileTypeOfKeyCheck, driver);


        boolean checkCaptcha=true;
        do
        {
            OlsSccMeths.WaitingElementToBeClickableByCss(wait, driver, OlsVarFoeCryptoTest.ChooseKeyFromFolderButton, 10 );
            OlsSccMeths.FindByCssAndSendKeys(OlsVarFoeCryptoTest.ChooseKeyFromFolderButton, driver, Credentials.WayForOwnKey);

            OlsSccMeths.WaitingElementToBeClickableByCss(wait, driver, OlsVarFoeCryptoTest.InputFildForTestData, 5);

            OlsSccMeths.FindByCssAndSendKeys(OlsVarFoeCryptoTest.SendPass, driver, Credentials.PassForOwnKey);

            OlsSccMeths.WaitingElementToBeClickableByCss(wait, driver, OlsVarFoeCryptoTest.ClickToReadButton, 5);
            OlsSccMeths.FindByCssAndClick(OlsVarFoeCryptoTest.ClickToReadButton, driver);

            try
            {
                OlsSccMeths.WaitingElementToBeClickableByCss(wait, driver, OlsVarFoeCryptoTest.CheckCertInfoForKeyFile, 10);
                String FioFromCert=OlsSccMeths.FindAndGetTextByCss(driver, OlsVarFoeCryptoTest.CheckCertInfoForKeyFile);
                System.out.println("ПІБ з сертифікату - "+FioFromCert);
            }
            catch(TimeoutException e)
            {
                System.out.println("За визначений час, ПІБ з сертифікату - не з'явилося на користувацькому інтерфейсі");
                return;
            }
            catch(NotFoundException r)
            {
                System.out.println("Ключ користувача не зчитано.");
                return;
            }

            OlsSccMeths.WaitingElementToBeClickableByCss(wait, driver, OlsVarFoeCryptoTest.ClickToSignButton, 5);
            OlsSccMeths.FindByCssAndClick(OlsVarFoeCryptoTest.ClickToSignButton, driver);

            OlsSccMeths.FindByCssAndSet(OlsVarFoeCryptoTest.InputFildForPib, driver,OlsVarFoeCryptoTest.DataForPibFild);

            OlsSccMeths.FindByCssAndSet(OlsVarFoeCryptoTest.InputFildForEmail, driver,OlsVarFoeCryptoTest.DataForEmailFild);

            OlsSccMeths.FindByCssAndSet(OlsVarFoeCryptoTest.InputFildForPhoneNumber, driver,OlsVarFoeCryptoTest.DataForPhoneNumberFild);

            OlsSccMeths.FindByCssAndSet(OlsVarFoeCryptoTest.InputFildForCmmentr, driver,OlsVarFoeCryptoTest.DataForCommentFild);

            OlsSccMeths.FindByCssAndClick(OlsVarFoeCryptoTest.CheckBoxArgeement, driver);

            Scanner scanner=new Scanner(System.in);
            System.out.println("Введіть значення капчі для продовження тесту та натисніть Ентр:");
            String captcha=scanner.nextLine();

            OlsSccMeths.FindByCssAndSendKeys(OlsVarFoeCryptoTest.InputForCaptcha, driver, captcha);

            OlsSccMeths.FindByCssAndClick(OlsVarFoeCryptoTest.ButtonSendToBot, driver);

            try
            {
                OlsSccMeths.WaitingElementToBeClickableByCss(wait, driver, OlsVarFoeCryptoTest.ErrorCaptcha, 5);
                checkCaptcha=false;
            }
            catch(TimeoutException e)
            {
                checkCaptcha=true;
            }

        }
        while (checkCaptcha==false);


        OlsSccMeths.WaitingElementToBeClickableByCss(wait, driver,OlsVarFoeCryptoTest.CheckResaltProtocolNumber, 30);
        System.out.println(OlsSccMeths.FindAndGetTextByCss(driver, OlsVarFoeCryptoTest.CheckResaltProtocolNumber));

        OlsSccMeths.FindByCssAndClick(OlsVarFoeCryptoTest.BackToMainpageButton,driver);

        try
        {
            OlsSccMeths.WaitingElementToBeClickableByCss(wait, driver, OlsVarFoeCryptoTest.CheckLogoOnMailPage,30);
            System.out.println("Тест виконано успішно. Потокол надіслано в Jira");
        }
        catch(TimeoutException e)
        {
            System.out.println("Тест виконано безуспішно. Необхідно перевірити логи та виконати реран");
        }

    }
}
