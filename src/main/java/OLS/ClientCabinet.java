package OLS;

import dev.failsafe.TimeoutExceededException;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.tracing.opentelemetry.SeleniumSpanExporter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.ArrayList;

public class ClientCabinet
{
    public void BuyMaoTransactions(WebDriver driver, WebDriverWait wait, JFrame frame)
    {
        driver.get(Credentials.Environment);
        AuthFileKey.AuthWithTestKndpKey(driver, wait, Credentials.PassToKeyForTestOrg, Credentials.WayToKeyForTestOrg);
        ChangeRole.UseClientRole(driver, wait, 10);
        String IdRequest;
        String TransactionCount;

        try
        {
            OlsSccMeths.WaitingElementToBeClickableByCss(wait, driver, OlsVarables.SineActModalWind,20);
            OlsSccMeths.FindByCssAndClick(OlsVarables.SineActModalWindDisagreeButton,driver);
        }
        catch(TimeoutException e)
        {
            System.out.println("У Вас в системі відсутні Акти або Заяви приєднання що вимагають підписання");
        }

        OlsSccMeths.FindByCssAndClick(OlsVarables.ArtOfficeLicenseBlockCss, driver);

        try
        {
            OlsSccMeths.WaitingElementToBeClickableByCss(wait, driver, OlsVarables.addButton, 10);
        }
        catch(TimeoutExceededException e)
        {
            System.out.println("Елемент коризна не знайдено");
        }
        OlsSccMeths.FindByCssAndClick(OlsVarables.addButton, driver);

//      Start Step1
        System.out.println("----Start Step 11----");

        OlsSccMeths.WaitingElementToBeClickableByCss(wait, driver, OlsVarables.TrinsactionMaoCountOfDocsToBy, 10);

        OlsSccMeths.FindByCssAndClick(OlsVarables.TrinsactionMaoCountOfDocsToBy, driver);

        OlsSccMeths.FindByCssAndSet(OlsVarables.TrinsactionMaoCountOfDocsToBy, driver, Credentials.CountOfDocsInTransactionReqest);

        for(int i=0; i<=5; i++)
        {
            OlsSccMeths.FindByCssAndClick(OlsVarables.AddTrinsactionMaoCountOfDocsToBy, driver);
        }

        OlsSccMeths.FindByCssAndClick(OlsVarables.MinusTrinsactionMaoCountOfDocsToBy, driver);

        OlsSccMeths.FindByCssAndClear(driver, OlsVarables.Step11ogrNameInput);

        OlsSccMeths.FindByCssAndSet(OlsVarables.Step11ogrNameInput, driver,Credentials.Step1OrgName);

        IdRequest=OlsSccMeths.FindAndGetTextByCss(driver, OlsVarables.Step11IdReuqest);


        System.out.println(" - Замовлення № - "+IdRequest);
        System.out.println(" - Перший крок успішно пройдено");

        OlsSccMeths.FindByCssAndClick(OlsVarables.Step11ButtonNextStep, driver);

        OlsSccMeths.WaitingElementToBeClickableByCss(wait, driver, OlsVarables.Step21ButtonBackStep, 10);
        OlsSccMeths.FindByCssAndClick(OlsVarables.Step21ButtonBackStep, driver);

        OlsSccMeths.WaitingElementToBeClickableByCss(wait, driver, OlsVarables.Step11TotalDocCount, 10);
        TransactionCount=OlsSccMeths.FindAndGetTextByCss(driver, OlsVarables.Step11TotalDocCount);
        System.out.println(" - Кількість транзакцій в замовленні - "+TransactionCount);

        OlsSccMeths.FindByCssAndClick(OlsVarables.Step11ButtonNextStep, driver);

//      Start Step 2
        System.out.println("----Start Step 21----");

        System.out.println("- Перевірка коду ЕДРПОУ, що було введено на попередньому кроці:");
        OlsSccMeths.WaitingElementToBeClickableByCss(wait, driver, OlsVarables.Step21EdrpouCode, 10 );
        OlsSccMeths.FindByCssAndCheckText(driver, OlsVarables.Step21EdrpouCode, Credentials.CodeEdrpouForYOV12);

        System.out.println("- Перевірка назви підприємства, що було введено на попередньому кроці:");
        OlsSccMeths.FindByCssAndCheckText(driver, OlsVarables.Step21OrgName, Credentials.OrgNameFromStep21);

//        OlsSccMeths.FindByCssAndClick(OlsVarables.Step21OccupType, driver);
//
//        OlsSccMeths.FindByCssAndClick(OlsVarables.Step21OccupTypeVidocremleniyPidrozdil, driver);

        OlsSccMeths.FindByCssAndClick(OlsVarables.Step21PhoneNumberInputField, driver);

        OlsSccMeths.FindByCssAndSet(OlsVarables.Step21PhoneNumberInputField, driver, Credentials.Step21PhoneNumber);

        OlsSccMeths.FindByCssAndClear(driver, OlsVarables.Step21EmailMainInputField);

        OlsSccMeths.FindByCssAndSet(OlsVarables.Step21EmailMainInputField, driver, Credentials.Step21EmailMain);

        OlsSccMeths.FindByCssAndClick(OlsVarables.Step21YoAdressChange, driver);

        OlsSccMeths.WaitingElementToBeClickableByCss(wait,driver,OlsVarables.Step21YoAdressSetModalSaveButton,10 );

        OlsSccMeths.FindByCssAndSet(OlsVarables.Step21YoAdressSetModalIndexField, driver, Credentials.Step21YoAdressSetModalIndex);

        OlsSccMeths.FindByCssAndClick(OlsVarables.Step21YoAdressSetModalIndexFieldFindeButton, driver );

        OlsSccMeths.FindByCssAndClick(OlsVarables.Step21YoAdressSetModalSaveButton, driver);

        OlsSccMeths.WaitingElementToBeInvisibilityByCss(wait, driver, OlsVarables.Step21YoAdressSetModalSaveButton, 10);

        OlsSccMeths.WaitingElementToBeClickableByCss(wait, driver, OlsVarables.Step21CopyYoAdressToPostAdressButton,10);
        OlsSccMeths.FindByCssAndClick(OlsVarables.Step21CopyYoAdressToPostAdressButton, driver);

        OlsSccMeths.WaitingElementToBeClickableByCss(wait, driver, OlsVarables.Step21PostAdressChange, 10);
        OlsSccMeths.FindByCssAndClick(OlsVarables.Step21PostAdressChange, driver);

        System.out.println("- Перевірка назви міста, що було введено попередньо:");
        OlsSccMeths.WaitingElementToBeClickableByCss(wait, driver, OlsVarables.Step21YoAdressSetModalRegionValue, 10);
        OlsSccMeths.FindByCssAndCheckText(driver, OlsVarables.Step21YoAdressSetModalRegionValue,Credentials.Step21PostAdresssSetModalRegion );

        OlsSccMeths.FindByCssAndClear(driver,OlsVarables.Step21YoAdressSetModalIndexField);

        OlsSccMeths.FindByCssAndSet(OlsVarables.Step21YoAdressSetModalIndexField, driver, Credentials.Step21PostAdresssSetModalIndex);

        OlsSccMeths.FindByCssAndClick(OlsVarables.Step21YoAdressSetModalIndexFieldFindeButton, driver );

        OlsSccMeths.FindByCssAndClick(OlsVarables.Step21YoAdressSetModalSaveButton, driver);

        OlsSccMeths.WaitingElementToBeInvisibilityByCss(wait, driver,OlsVarables.Step21YoAdressSetModalSaveButton, 10);

        OlsSccMeths.FindByCssAndClick(OlsVarables.TaxSystemDropDownList, driver);

        OlsSccMeths.FindByCssAndClick(OlsVarables.TaxSystemDropDownGetValueWithIndex1, driver);

        OlsSccMeths.FindByCssAndClear(driver, OlsVarables.IPNNumberInputField);
        OlsSccMeths.FindByCssAndSet(OlsVarables.IPNNumberInputField, driver, Credentials.IPNNumberForTov12);

        OlsSccMeths.FindByCssAndClear(driver, OlsVarables.NumberOfPdvPayerInputField);
        OlsSccMeths.FindByCssAndSet(OlsVarables.NumberOfPdvPayerInputField, driver, Credentials.NumberOfPdvPayerForTov12);

        OlsSccMeths.FindByCssAndClear(driver, OlsVarables.NumberOfStpPayerInputField);
        OlsSccMeths.FindByCssAndSet(OlsVarables.NumberOfStpPayerInputField, driver, Credentials.NumberOfStpPayerForTov12);

        OlsSccMeths.FindByCssAndClear(driver, OlsVarables.ChiefPosition);
        OlsSccMeths.FindByCssAndSet(OlsVarables.ChiefPosition, driver, Credentials.ChiefPositionForTov12);

        OlsSccMeths.FindByCssAndClear(driver, OlsVarables.ChiefDrfo);
        OlsSccMeths.FindByCssAndSet(OlsVarables.ChiefDrfo, driver, Credentials.ChiefDrfoForTov12);

        OlsSccMeths.FindByCssAndClear(driver, OlsVarables.ChiefPib);
        OlsSccMeths.FindByCssAndSet(OlsVarables.ChiefPib, driver, Credentials.ChiefPibForTov12);

        OlsSccMeths.FindByCssAndClear(driver, OlsVarables.Iban);
        OlsSccMeths.FindByCssAndSet(OlsVarables.Iban, driver, Credentials.IbanForTov12);

        OlsSccMeths.FindByCssAndClick(OlsVarables.Step21GetNextStep, driver);

//      Start Step 32
        System.out.println("----Start Step 32----");

        try
        {
            OlsSccMeths.WaitingElementToBeClickableByCss(wait, driver, OlsVarables.Step32CheckText,60);
            String resalt=OlsSccMeths.FindByCssAndCheckTextReturnText(driver, OlsVarables.Step32CheckText, OlsVarables.Step32CheckTextValidResalt);
            System.out.println("На екрані відображається  - "+resalt);
            if (resalt.equals("Крок 3: Завантажте необхідні документи"))
            {
                OlsSccMeths.WaitingElementToBeClickableByCss(wait, driver, OlsVarables.Step32CheckTextDiscription, 60);
                System.out.println("- Замовлення знаходиться на кроці Формування документів. Інформатиноий тест про необхідність очікування на формування документів відображається валідно.");
            }
        }
        catch(TimeoutException e)
        {
            System.out.println("Перехід на крок 32 відбувся невдало по Таймауту");
        }
        catch(NoSuchElementException e)
        {
            System.out.println("Перехід на крок 32 відбувся невдало по Елементу");
        }

// check the formation of documents

        try
        {
            OlsSccMeths.WaitingElementToBeClickableByCss(wait, driver, OlsVarables.Step33ModalWarningForPayment, 600);
        }
        catch(TimeoutException tout)
        {
            try
            {
                OlsSccMeths.WaitingElementToBeClickableByCss(wait, driver, OlsVarables.Step32Limit20MinutesAppeared, 600);
            }
            catch (TimeoutException e)
            {
                System.out.println("Замовлення не перейшло на крок 33. Текст про необхідність звернутись на техпідтримку - НЕ відображається");
                System.out.println("Критична помилка. Подальша обробка замовлення - НЕ можлива. ");
                return;
            }
            System.out.println("Формування документы НЕ відбулось в автоматичному режимі. Інформація про необхідність звернутись у техпідтримку - відображається валідно");
            return;
        }

//      Start Step 33
        System.out.println("----Start Step 33----");

        OlsSccMeths.FindByCssAndClick(OlsVarables.Step33ModalWarningForPaymentOkButton, driver);

        OlsSccMeths.WaitingElementToBeInvisibilityByCss(wait, driver, OlsVarables.Step33ModalWarningForPayment, 10);
        OlsSccMeths.WaitingElementToBeClickableByCss(wait, driver, OlsVarables.Step33ViewDocButton, 30);
        OlsSccMeths.FindByCssAndClick(OlsVarables.Step33ViewDocButton, driver);

        try
        {
            OlsSccMeths.WaitingElementToBeClickableByCss(wait, driver, OlsVarables.Step33ViewModalCheckClientSlotAppear, 60);
            try
            {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal-dialog")));
                WebElement frameElement = driver.findElement(By.cssSelector(OlsVarables.Step33ViewModalFrame));
                driver.switchTo().frame(frameElement);
                OlsSccMeths.WaitingElementToBeClickableByCss(wait, driver, OlsVarables.Step33ViewModalCheckClientTextZayavaPriednannyaApper, 60);
                System.out.println("- Початок перевірки бланку друкованої форми документа");

                //  Перевірка заголовку бланка
                System.out.println(" - Перевірка заголовку бланка");
                OlsSccMeths.WaitingElementToBeClickableByXpath(wait, driver, OlsVarables.Step33ViewModalFrameHeaderXpath, 60);
                String resultHeader=RequestDocument.CheckZayavaHeeder(driver, OlsVarables.Step33ViewModalFrameHeaderXpath,IdRequest, Credentials.CodeEdrpouForYOV12);
                System.out.println("Заголовок: "+resultHeader);

                // Перевірка клількісті транзакцій у бланку
                System.out.println(" - Перевірка клількісті транзакцій у бланку");
                OlsSccMeths.WaitingElementToBeClickableByCss(wait, driver, OlsVarables.Step33ViewModalFrameNomCount, 10);
                RequestDocument.CheckZayavaNomCountCss(driver, OlsVarables.Step33ViewModalFrameNomCount,TransactionCount);

                // Перевірка назви підприємства на бланку
                System.out.println(" - Перевірка назви підприємства на бланку");
                OlsSccMeths.WaitingElementToBeClickableByCss(wait, driver, OlsVarables.Step33ViewModalFrameOrgName, 10);
                RequestDocument.CheckZayavaNomCountCss(driver, OlsVarables.Step33ViewModalFrameOrgName,Credentials.OrgNameFromStep21);

                // Перевірка кода ЕДРПОУ підприємства на бланку
                System.out.println(" - Перевірка кода ЕДРПОУ підприємства на бланку");
                OlsSccMeths.WaitingElementToBeClickableByCss(wait, driver, OlsVarables.Step33ViewModalFrameOrgEdrpou, 10);
                RequestDocument.CheckZayavaNomCountCss(driver, OlsVarables.Step33ViewModalFrameOrgEdrpou,Credentials.CodeEdrpouForYOV12);

                // Перевірка кода ІПН  підприємства на бланку
                System.out.println(" - Перевірка кода ІПН  підприємства на бланку");
                OlsSccMeths.WaitingElementToBeClickableByCss(wait, driver, OlsVarables.Step33ViewModalFrameOrgIpn, 10);
                RequestDocument.CheckZayavaNomCountCss(driver, OlsVarables.Step33ViewModalFrameOrgIpn,Credentials.IPNNumberForTov12);

                // Перевірка номера телефону на бланку
                System.out.println(" - Перевірка номера телефону на бланку");
                OlsSccMeths.WaitingElementToBeClickableByCss(wait, driver, OlsVarables.Step33ViewModalFrameRequestPhone, 10);
                RequestDocument.CheckZayavaNomCountCss(driver, OlsVarables.Step33ViewModalFrameRequestPhone,"+380"+Credentials.Step21PhoneNumber);

                // Перевірка email на бланку
                System.out.println(" - Перевірка email на бланку");
                OlsSccMeths.WaitingElementToBeClickableByCss(wait, driver, OlsVarables.Step33ViewModalFrameRequestEmail, 10);
                RequestDocument.CheckZayavaNomCountCss(driver, OlsVarables.Step33ViewModalFrameRequestEmail,Credentials.Step21EmailMain);

                // Перевірка редіректу на МАО у футорі
                System.out.println(" - Перевірка редіректу на МАО у футорі на бланку");
                OlsSccMeths.WaitingElementToBeClickableByCss(wait, driver, OlsVarables.Step33ViewModalFrameRediectMaoMainPage, 10);
                String MaoUrl=OlsSccMeths.FindAndGetValueOfAttributeByCss(driver, OlsVarables.Step33ViewModalFrameRediectMaoMainPage, "href");
                System.out.println("URL посилання для редіректу - "+MaoUrl);

                System.out.println(" - Перевірка валідності виконання редіректу");
                try
                {
                    OlsSccMeths.FindByCssAndClick(OlsVarables.Step33ViewModalFrameRediectMaoMainPage, driver);
                    System.out.println("тест-1");
                    ArrayList <String> arr1=new ArrayList<>(driver.getWindowHandles());
                    driver.switchTo().window(arr1.get(arr1.size()-1));
                    String ResaltUrl=driver.getCurrentUrl();

                    if(ResaltUrl.equals("https://my.art-office.com.ua/"))
                    {
                        System.out.println("Редірект відбувся успішно");
                    }
                    else
                    {
                        throw new Exception ("УВАГА !!! Редірект відбувся БЕЗУСПІШНО");
                    }
                }
                catch(Exception  e)
                {
                    e.printStackTrace();
                }
            }
            catch(TimeoutException t)
            {
                System.out.println("Не валідне відображення документа. Заява приєднання при перегляді відображається не коректно");
            }
        }
        catch(TimeoutException e)
        {
            System.out.println("При перешляді заяви приєднання, модальне вікно перегляду не відобажається");
        }

        driver.switchTo().defaultContent();

        OlsSccMeths.WaitingElementToBePresentOnThePage(driver, OlsVarables.Step33ViewModalViewDocCloseButton, 30  );
        OlsSccMeths.FindByCssAndClick(OlsVarables.Step33ViewModalViewDocCloseButton,driver);

        OlsSccMeths.FindByCssAndClick(OlsVarables.Step33DownloadButton, driver);

        if (WindowsHelper.isFileDownloaded(Credentials.DirectForSavingFiles, "Agreement.pdf",Credentials.WaitTimeToDownloadFile))
        {
            System.out.println("PDF файл бланку Заяви приєднання успішно завантажено");
        } else
        {
            System.out.println("!!! УВАГА. PDF файл бланку Заяви приєднання - НЕ ЗАВАНТАЖЕНО");
        }

        String[] options = {"Точково", "Массово"};

        int UserChoice = JOptionPane.showOptionDialog
                (
                frame,
                "Виберіть режим тестування:",
                "Підписання",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0] // Выбор по умолчанию
                );

        switch (UserChoice)
        {
            case 0:
                System.out.println(" - Обрано Точковий кейс для підписання документів");
                break;
            case 1:
                System.out.println(" - Обрано Масовий кейс для підписання документів");
                break;
            default:
                System.out.println(" - Користувач выдмынив процес пыдписання");
                return;
        }

        System.out.println("мы добрались сюда)))1");
















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
