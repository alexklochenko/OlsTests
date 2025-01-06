package OLS;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Main {

    @FunctionalInterface
    public interface Cases
    {
        public void TestCase(WebDriver driver, WebDriverWait wait);
    }

    private static void executeWithNewDriver (Cases NewCase)
    {
        WebDriver driver=new ChromeDriver();
        Dimension size=new Dimension(1600,950);
        driver.manage().window().setSize(size);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        NewCase.TestCase(driver, wait);
        driver.quit();
    }

    public static void main(String[] args)
    {

        CheckMainPage cmp=new CheckMainPage();
//        executeWithNewDriver( (driver,wait)-> cmp.CheckSalePage(driver, wait));
//        executeWithNewDriver( (driver,wait)-> cmp.CheckAboutAsPage(driver, wait));
//        executeWithNewDriver( (driver,wait)-> cmp.CheckContactsPage(driver, wait));
        executeWithNewDriver( (driver,wait)-> cmp.CheckPartnerPage(driver, wait));

//        Сryptotest crt=new Сryptotest();
//        executeWithNewDriver((driver, wait)->crt.СryptotestWithFileKey(driver, wait));

//        AuthFileKey afk=new AuthFileKey();
//        afk.AuthWithTestKndpKey(driver, wait,  Credentials.PassForTestKndpTov12Dir, Credentials.WayForKeyForTestKndpTov12Die) ;
//        ChangeRole chr=new ChangeRole();
//        chr.UseClientRole(driver, wait, 30);
//        ClientCabinet bnl=new ClientCabinet();
//        bnl.BuyMaoTransactions(driver, wait);
//        bnl.SignMyDocs(driver, wait);


    }
}