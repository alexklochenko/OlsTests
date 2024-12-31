package OLS;

import dev.failsafe.TimeoutExceededException;
import dev.failsafe.internal.TimeoutExecutor;
import org.junit.platform.commons.function.Try;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ClientCabinet
{

    public void BuyMaoTransactions(WebDriver driver, WebDriverWait wait)
    {
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

//        Start Step1
        System.out.println("----Start Step 11----");

        OlsSccMeths.WaitingElementToBeClickableByCss(wait, driver, OlsVarables.TrinsactionMaoCountOfDocsToBy, 10);

        OlsSccMeths.FindByCssAndClick(OlsVarables.TrinsactionMaoCountOfDocsToBy, driver);

        OlsSccMeths.FindByCssAndSet(OlsVarables.TrinsactionMaoCountOfDocsToBy, driver, OlsVarables.CountOfDocsInTransactionReqest);

        for(int i=0; i<=5; i++)
        {
            OlsSccMeths.FindByCssAndClick(OlsVarables.AddTrinsactionMaoCountOfDocsToBy, driver);
        }

        OlsSccMeths.FindByCssAndClick(OlsVarables.MinusTrinsactionMaoCountOfDocsToBy, driver);

        OlsSccMeths.FindByCssAndClear(driver, OlsVarables.Step11ogrNameInput);

        OlsSccMeths.FindByCssAndSet(OlsVarables.Step11ogrNameInput, driver,OlsVarables.Step1OrgName);

        OlsSccMeths.FindByCssAndClick(OlsVarables.Step11ButtonNextStep, driver);

//      Start Step 2
        System.out.println("----Start Step 21----");

        System.out.println("- Перевірка коду ЕДРПОУ, що було введено на попередньому кроці:");
        OlsSccMeths.WaitingElementToBeClickableByCss(wait, driver, OlsVarables.Step21EdrpouCode, 10 );
        OlsSccMeths.FindByCssAndCheckText(driver, OlsVarables.Step21EdrpouCode, OlsVarables.CodeEdrpouForYOV12);

        System.out.println("- Перевірка назви підприємства, що було введено на попередньому кроці:");
        OlsSccMeths.FindByCssAndCheckText(driver, OlsVarables.Step21OrgName, OlsVarables.OrgNameFromStep21);

//        OlsSccMeths.FindByCssAndClick(OlsVarables.Step21OccupType, driver);
//
//        OlsSccMeths.FindByCssAndClick(OlsVarables.Step21OccupTypeVidocremleniyPidrozdil, driver);

        OlsSccMeths.FindByCssAndClick(OlsVarables.Step21PhoneNumberInputField, driver);

        OlsSccMeths.FindByCssAndSet(OlsVarables.Step21PhoneNumberInputField, driver, OlsVarables.Step21PhoneNumber);

        OlsSccMeths.FindByCssAndClear(driver, OlsVarables.Step21EmailMainInputField);

        OlsSccMeths.FindByCssAndSet(OlsVarables.Step21EmailMainInputField, driver, OlsVarables.Step21EmailMain);

        OlsSccMeths.FindByCssAndClick(OlsVarables.Step21YoAdressChange, driver);

        OlsSccMeths.WaitingElementToBeClickableByCss(wait,driver,OlsVarables.Step21YoAdressSetModalSaveButton,10 );

        OlsSccMeths.FindByCssAndSet(OlsVarables.Step21YoAdressSetModalIndexField, driver, OlsVarables.Step21YoAdressSetModalIndex);

        OlsSccMeths.FindByCssAndClick(OlsVarables.Step21YoAdressSetModalIndexFieldFindeButton, driver );

        OlsSccMeths.FindByCssAndClick(OlsVarables.Step21YoAdressSetModalSaveButton, driver);

        OlsSccMeths.WaitingElementToBeInvisibilityByCss(wait, driver, OlsVarables.Step21YoAdressSetModalSaveButton, 10);

        OlsSccMeths.WaitingElementToBeClickableByCss(wait, driver, OlsVarables.Step21CopyYoAdressToPostAdressButton,10);
        OlsSccMeths.FindByCssAndClick(OlsVarables.Step21CopyYoAdressToPostAdressButton, driver);

        OlsSccMeths.WaitingElementToBeClickableByCss(wait, driver, OlsVarables.Step21PostAdressChange, 10);
        OlsSccMeths.FindByCssAndClick(OlsVarables.Step21PostAdressChange, driver);

        System.out.println("- Перевірка назви міста, що було введено попередньо:");
        OlsSccMeths.WaitingElementToBeClickableByCss(wait, driver, OlsVarables.Step21YoAdressSetModalRegionValue, 10);
        OlsSccMeths.FindByCssAndCheckText(driver, OlsVarables.Step21YoAdressSetModalRegionValue,OlsVarables.Step21PostAdresssSetModalRegion );

        OlsSccMeths.FindByCssAndClear(driver,OlsVarables.Step21YoAdressSetModalIndexField);

        OlsSccMeths.FindByCssAndSet(OlsVarables.Step21YoAdressSetModalIndexField, driver, OlsVarables.Step21PostAdresssSetModalIndex);

        OlsSccMeths.FindByCssAndClick(OlsVarables.Step21YoAdressSetModalIndexFieldFindeButton, driver );

        OlsSccMeths.FindByCssAndClick(OlsVarables.Step21YoAdressSetModalSaveButton, driver);

        OlsSccMeths.WaitingElementToBeInvisibilityByCss(wait, driver,OlsVarables.Step21YoAdressSetModalSaveButton, 10);

        OlsSccMeths.FindByCssAndClick(OlsVarables.TaxSystemDropDownList, driver);

        OlsSccMeths.FindByCssAndClick(OlsVarables.TaxSystemDropDownGetValueWithIndex1, driver);

        OlsSccMeths.FindByCssAndClear(driver, OlsVarables.IPNNumberInputField);
        OlsSccMeths.FindByCssAndSet(OlsVarables.IPNNumberInputField, driver, OlsVarables.IPNNumberForTov12);

        OlsSccMeths.FindByCssAndClear(driver, OlsVarables.NumberOfPdvPayerInputField);
        OlsSccMeths.FindByCssAndSet(OlsVarables.NumberOfPdvPayerInputField, driver, OlsVarables.NumberOfPdvPayerForTov12);

        OlsSccMeths.FindByCssAndClear(driver, OlsVarables.NumberOfStpPayerInputField);
        OlsSccMeths.FindByCssAndSet(OlsVarables.NumberOfStpPayerInputField, driver, OlsVarables.NumberOfStpPayerForTov12);

        OlsSccMeths.FindByCssAndClear(driver, OlsVarables.ChiefPosition);
        OlsSccMeths.FindByCssAndSet(OlsVarables.ChiefPosition, driver, OlsVarables.ChiefPositionForTov12);

        OlsSccMeths.FindByCssAndClear(driver, OlsVarables.ChiefDrfo);
        OlsSccMeths.FindByCssAndSet(OlsVarables.ChiefDrfo, driver, OlsVarables.ChiefDrfoForTov12);

        OlsSccMeths.FindByCssAndClear(driver, OlsVarables.ChiefPib);
        OlsSccMeths.FindByCssAndSet(OlsVarables.ChiefPib, driver, OlsVarables.ChiefPibForTov12);

        OlsSccMeths.FindByCssAndClear(driver, OlsVarables.Iban);
        OlsSccMeths.FindByCssAndSet(OlsVarables.Iban, driver, OlsVarables.IbanForTov12);

        OlsSccMeths.FindByCssAndClick(OlsVarables.Step21GetNextStep, driver);

//      Start Step 3
        System.out.println("----Start Step 32----");

        try
        {
            OlsSccMeths.WaitingElementToBeClickableByCss(wait, driver, OlsVarables.Step32CheckText,60);
            String resalt=OlsSccMeths.FindByCssAndCheckTextReturnText(driver, OlsVarables.Step32CheckText, OlsVarables.Step32CheckTextValidResalt);
            System.out.println("Text on display - "+resalt);
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

//      Start Step 3
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
                WebElement modalWindow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal-dialog")));
                WebElement frameElement = modalWindow.findElement(By.tagName("iframe"));
                driver.switchTo().frame(frameElement);
                OlsSccMeths.WaitingElementToBeClickableByCss(wait, driver, OlsVarables.Step33ViewModalCheckClientTextZayavaPriednannyaApper, 60);
                System.out.println("- Бланк заяви приєднання відображається успішно.");

                System.out.println("- Перевірка заголовка друкованої форми ");
                OlsSccMeths.WaitingElementToBeClickableByCss(wait, driver, OlsVarables.Step33CheckTextZayavaPriednannya, 60);
                OlsSccMeths.FindByCssAndCheckText(driver, OlsVarables.Step33CheckTextZayavaPriednannya, "ЗАЯВА-ПРИЄДНАННЯ");







                driver.switchTo().defaultContent();
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

        OlsSccMeths.WaitingElementToBePresentOnThePage(driver, OlsVarables.Step33ViewModalViewDocCloseButton, 30  );




        System.out.println("мы добрались сюда)))");















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
