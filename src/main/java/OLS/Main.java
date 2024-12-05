package OLS;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args)
    {
        WebDriver driver=new ChromeDriver();
        Dimension size=new Dimension(1600,950);
        driver.manage().window().setSize(size);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        AuthFileKey afk=new AuthFileKey();
        ChangeRole chr=new ChangeRole();

        afk.AuthWithTestKndpKey(driver, wait,  Credentials.PassForTestKndpTov12Dir, Credentials.WayForKeyForTestKndpTov12Die) ;
        chr.UseClientRole(driver, wait, 30);
//        OpenGoogle.OpenSetClick();
//        OLSOpen.OLStest();
//        org.example.CheckHeadersLinks.Test();

//
//        AuthOLS.MkKey();
//        AuthOLS.DpsKey();
//        Сryptotest.Test();

    }
}