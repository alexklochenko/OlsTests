package OLS;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChangeRole
{
    public static  void UseClientRole(WebDriver driver, WebDriverWait wait, int secondsToWait)
    {
        try
        {
            OlsSccMeths.WaitingElementToBeClickableByCss(wait, driver, OlsVarables.RoleDropDownList,secondsToWait);
        }
        catch(TimeoutException e)
        {
            System.out.println("Відсутній випадаючий список вибору ролі");
        }

        OlsSccMeths.FindByCssAndClick(OlsVarables.RoleDropDownList, driver);

        OlsSccMeths.FindByXpathAndClick(OlsVarables.ClientRoleFromDropDownList, driver);


    }
}
