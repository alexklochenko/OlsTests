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


//        AuthFileKey afk=new AuthFileKey();
//        afk.AuthWithTestKndpKey(driver, wait,  Credentials.PassForTestKndpTov12Dir, Credentials.WayForKeyForTestKndpTov12Die) ;
//        ChangeRole chr=new ChangeRole();
//        chr.UseClientRole(driver, wait, 30);
//        ClientCabinet bnl=new ClientCabinet();
//        bnl.BuyMaoTransactions(driver, wait);

//        bnl.SignMyDocs(driver, wait);



        CheckMainPage cmp=new CheckMainPage();
        cmp.CheckSalePage(driver, wait);
        cmp.CheckAboutAsPage(driver, wait);

//        Сryptotest crt=new Сryptotest();
//        crt.СryptotestWithFileKey(driver, wait);

    }
}