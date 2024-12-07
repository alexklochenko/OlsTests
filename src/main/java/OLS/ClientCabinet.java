package OLS;

import dev.failsafe.TimeoutExceededException;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClientCabinet
{

    public void BuyMaoTransactions(WebDriver driver, WebDriverWait wait)
    {
        try
        {
            OlsSccMeths.WaitingElementToBeClickableByCss(wait, driver, OlsVarables.SineActModalWind,20);
            OlsSccMeths.FindByCssAndClick(OlsVarables.SineActModalWindDisagreeButton,driver);
            System.out.println("try bloch pass");
        }
        catch(TimeoutException e)
        {
            System.out.println("У Вас в системі відсутні Акти або Заяви приєднання що вимагають підписання");
        }

        OlsSccMeths.FindByXpathAndClick(OlsVarables.ArtOfficeLicemseBlock, driver);

        try
        {
            OlsSccMeths.WaitingElementToBeClickableByCss(wait, driver, OlsVarables.addButton, 10);
        }
        catch(TimeoutExceededException e)
        {
            System.out.println("Елемент коризна не знайдено");
        }
        OlsSccMeths.FindByCssAndClick(OlsVarables.addButton, driver);

















    }

    public void SignMyDocs(WebDriver driver, WebDriverWait wait)
    {
        try
        {
            OlsSccMeths.WaitingElementToBeClickableByCss(wait, driver, OlsVarables.SineActModalWind,10);
            OlsSccMeths.FindByCssAndClick(OlsVarables.SineActModalWindDisagreeButton,driver);
            System.out.println("try bloch pass");
        }
        catch(TimeoutException e)
        {
            System.out.println("У Вас в системі відсутні Акти або Заяви приєднання що вимагають підписання");
        }

        OlsSccMeths.FindByCssAndClick(OlsVarables.MyDocsButtonAtFiltr, driver);

        try
        {
            OlsSccMeths.WaitingElementToBeClickableByCss(wait, driver, OlsVarables.MyDocsListFirstDocCheck, 10);

        }
        catch(TimeoutException e)
        {
            System.out.println("Елемент не знайдено. Ймовірно у Вас відсутні документи що мають бути підписані");
            return;
        }
        OlsSccMeths.FindByCssAndClick(OlsVarables.MyDocsListFirstDocSignButton, driver);

        OlsSccMeths.WaitingElementToBeClickableByCss(wait, driver,OlsVarables.MyDocsListFirstDocSignButtonOnModalView, 10);
        System.out.println("everything is ok");
        OlsSccMeths.WaitingElementToBeClickableByCss(wait, driver,OlsVarables.MyDocsListFirstDocSignButtonOnModalView, 10);
        System.out.println("everything is ok");
        OlsSccMeths.WaitingElementToBeClickableByCss(wait, driver,OlsVarables.MyDocsListFirstDocSignButtonOnModalView, 10);
        System.out.println("everything is ok");

        OlsSccMeths.FindByCssAndClick(OlsVarables.MyDocsListFirstDocSignButtonOnModalView, driver);



    }


}
