package OLS;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BuyingNewLicense
{

    public void BuyMaoTransactions(WebDriver driver, WebDriverWait wait)
    {
        try
        {
            OlsSccMeths.WaitingElementToBeClickableByCss(wait, driver, OlsVarables.SineActModalWind,10);
            OlsSccMeths.FindByCssAndClick(OlsVarables.SineActModalWindDisagreeButton,driver);
        }
        catch(TimeoutException e)
        {
            System.out.println("У Вас в системі відсутні Акти або Заяви приєднання що вимагають підписання");
        }

        OlsSccMeths.FindByXpathAndClick(OlsVarables.ArtOfficeLicemseBlock, driver);
















    }



}
