package OLS;

import dev.failsafe.TimeoutExceededException;
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

//        Start Step1

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

        OlsSccMeths.WaitingElementToBeClickableByCss(wait, driver, OlsVarables.Step21EdrpouCode, 10 );
        OlsSccMeths.FindByCssAndCheckText(driver, OlsVarables.Step21EdrpouCode, OlsVarables.CodeEdrpouForYOV12);

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

        try
        {
            OlsSccMeths.WaitingElementToBeClickableByCss(wait, driver, OlsVarables.Step32CheckText,60);
            OlsSccMeths.FindByCssAndCheckText(driver, OlsVarables.Step32CheckText, OlsVarables.Step32CheckTextValidResalt);
        }
        catch(TimeoutException e)
        {
            System.out.println("Перехід на крок 32 відбувся невдало по Таймауту");
        }
        catch(NoSuchElementException e)
        {
            System.out.println("Перехід на крок 32 відбувся невдало по Елементу");
        }

















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
