package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CheckHeadersLinks {

    public static void Test(){

        ChromeDriver driver=new ChromeDriver();

//      Устанавливаем размер окна браузера
        Dimension size = new Dimension(1250, 800);
        driver.manage().window().setSize(size);

        driver.get("https://ols.am-soft.ua/");

//        close captcha pop-up

        WebElement element= driver.findElement(By.xpath("//*[@id=\"cookie\"]/div/div[3]/button"));
        element.click();

//      find and click Головна button
        element= driver.findElement(By.xpath("/html/body/header/div[2]/div[1]/ul/li[1]"));
        element.click();

        WebElement elementForCheck=driver.findElement(By.xpath("/html/body/header/div[1]/a"));
        element= driver.findElement(By.xpath("/html/body/header/div[1]/a"));

        if (!element.equals(elementForCheck)){
            System.out.println("CheckHeadersLinks is faild:\"Головна\" button ");
        }
        else {
            System.out.println("Page \"Головна\" - ok");
        }

//      find and click Акції button
        element= driver.findElement(By.xpath("/html/body/header/div[2]/div[1]/ul/li[2]"));
        element.click();

        elementForCheck=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[1]/div/table/thead/tr/th[2]"));
        element= driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[1]/div/table/thead/tr/th[2]"));

        if (!element.equals(elementForCheck)){
            System.out.println("CheckHeadersLinks is faild:\"Акції\" button ");
        }
        else {
            System.out.println("Page \"Акції\" - ok");
        }

//      find and click Про нас button
        element= driver.findElement(By.xpath("/html/body/header/div[2]/div[1]/ul/li[3]"));
        element.click();

        elementForCheck=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]"));
        element= driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]"));

        if (!element.equals(elementForCheck)){
            System.out.println("CheckHeadersLinks is faild:\"Про нас\" button ");
        }
        else {
            System.out.println("Page \"Про нас\" - ok");
        }


//      find and click Контакти button
        element= driver.findElement(By.xpath("/html/body/header/div[2]/div[1]/ul/li[4]"));
        element.click();

        elementForCheck=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[2]/div[2]"));
        element= driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[2]/div[2]"));

        if (!element.equals(elementForCheck)){
            System.out.println("CheckHeadersLinks is faild:\"Контакти\" button ");
        }
        else {
            System.out.println("Page \"Контакти\" - ok");
        }

//      find and click Партнерам button
        element= driver.findElement(By.xpath("/html/body/header/div[2]/div[1]/ul/li[5]"));
        element.click();


        ArrayList <String> list=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(list.get(1));

        elementForCheck=driver.findElement(By.xpath("/html/body/header/div[1]/div[1]"));
        element= driver.findElement(By.xpath("/html/body/header/div[1]/div[1]"));

        if (!element.equals(elementForCheck)){
            System.out.println("CheckHeadersLinks is faild:\"Партнерам\" button ");
        }
        else {
            System.out.println("Page \"Партнерам\" - ok");
//            driver.close();
        }

//      find and click API button
        driver.switchTo().window(list.get(0));

        element= driver.findElement(By.xpath("/html/body/header/div[2]/div[1]/ul/li[6]"));
        element.click();


        ArrayList<String> list2=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(list2.get(2));


//      on API page: select & set PIB fild
        element= driver.findElement(By.xpath("//*[@id=\"FullName\"]"));
        element.click();
        element.sendKeys("Тест Тест Тест");

//      on API page: select & set ORG_code fild
        element=driver.findElement(By.xpath("//*[@id=\"OrgCode\"]"));
        element.sendKeys("АА112233");

//      on API page: select & set phone number fild
        element=driver.findElement(By.xpath("//*[@id=\"Phone\"]"));
        element.click();
        element.sendKeys("0991234578");

//      on API page: select & set Email fild
        element=driver.findElement(By.xpath("//*[@id=\"Email\"]"));
        element.sendKeys("test@test.ua");


//      on API page: select & set MK Deal Number fild
        element=driver.findElement(By.xpath("//*[@id=\"DogovorNumber\"]"));
        element.sendKeys("testDeal");


//      on API page: select & set checkbox AgreeWith
        element=driver.findElement(By.xpath("//*[@id=\"agreement\"]"));
        element.click();

//      on API page: select & set captcha Value
        element= driver.findElement(By.xpath("//*[@id=\"captcha_TB_I\"]"));
        element.click();

        Scanner scanner2=new Scanner(System.in);
        System.out.println("Set captcha value on API page!");
        String temp2=scanner2.nextLine();

        element.sendKeys(temp2);

//      on APS page: click Next button
        element= driver.findElement(By.xpath("//*[@id=\"ApiRequestForm\"]/div[9]/input"));
        element.click();

        //  If wrong capture as wrought
            try {
                WebElement misstakeCaptcha =driver.findElement(By.xpath("//*[@id=\"captcha_TB_EC\"]"));
                while (misstakeCaptcha != null){
                    element=driver.findElement(By.xpath("//*[@id=\"agreement\"]"));
                    element.click();

                    element= driver.findElement(By.xpath("//*[@id=\"captcha_TB_I\"]"));
                    element.click();

                    Scanner scanner3=new Scanner(System.in);
                    System.out.println("Set captcha value on API page!");
                    String temp3=scanner3.nextLine();

                    element.sendKeys(temp3);

                    element= driver.findElement(By.xpath("//*[@id=\"ApiRequestForm\"]/div[9]/input"));
                    element.click();

                }
            } catch (NoSuchElementException e) {
                //      API page check resalt of the test
                String ApiTestResaltChec="Дані успішно надіслані. Найближчим часом наш спеціаліст зв'яжеться з Вами для уточнення деталей запиту. Дякуємо!";
                WebElement elementForCheckElement=driver.findElement(By.xpath("//*[@id=\"ApiRequestForm\"]/div/span"));
                String elementForCheckString=elementForCheckElement.getText();


                if(elementForCheckString.equals(ApiTestResaltChec)){
                    System.out.println("Page \"API\" - ok");
                    System.out.println(elementForCheckString);
                    element= driver.findElement(By.xpath("//*[@id=\"ApiRequestForm\"]/a"));
                    element.click();
                }
                else{
                    System.out.println("CheckHeadersLinks is faild:\"API\" button");
                }


            }


    }

}
