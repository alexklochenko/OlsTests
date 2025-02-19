package OLS;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.PrintStream;
import java.time.Duration;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.OutputStream;
import java.util.HashMap;


public class Main
{
    @FunctionalInterface
    public interface Cases
    {
        void TestCase(WebDriver driver, WebDriverWait wait);
    }

    private static void executeWithNewDriver(Cases NewCase)
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        HashMap<String, Object> prefs=new HashMap<>();
        prefs.put("download_restrictions",0);
        prefs.put("profile.default_content_setting_values.automatic_downloads", 1);
        prefs.put("profile.default_content_setting_values.notifications", 2);
        prefs.put("download.default_directory", Credentials.DirectForSavingFiles);
        prefs.put("download.prompt_for_download", false);
        prefs.put("download.directory_upgrade", true);
        prefs.put("download.default_directory", Credentials.DirectForSavingFiles);
        // Отключить системные уведомления браузера
        prefs.put("profile.default_content_setting_values.popups", 0); // Блокировать всплывающие окна
        prefs.put("profile.managed_default_content_settings.popups", 0); // Заблокировать их через управляемый профиль


        options.setExperimentalOption("prefs", prefs);

        options.addArguments("--disable-notifications"); // Отключить уведомления браузера
        options.addArguments("--disable-popup-blocking"); // Блокировать все всплывающие окна


        WebDriver driver = new ChromeDriver(options);
        Dimension size = new Dimension(1600, 950);
        driver.manage().window().setSize(size);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        NewCase.TestCase(driver, wait);
//        driver.quit();
    }

    // Метод для добавления кнопок
    private static void addButton(JPanel panel, String buttonText, Runnable action) {
        JButton button = new JButton(buttonText);
        button.addActionListener(e -> {
            System.out.println("=== Виконується: " + buttonText + " ===");
            action.run();
            System.out.println("=== Завершено: " + buttonText + " ===");
        });
        panel.add(button);
    }

    static class TextAreaOutputStream extends OutputStream
    {
        private final JTextArea textArea;

        public TextAreaOutputStream(JTextArea textArea)
        {
            this.textArea = textArea;
        }

        @Override
        public void write(int b) {
            SwingUtilities.invokeLater(() -> {
                textArea.append(String.valueOf((char) b));
                textArea.setCaretPosition(textArea.getDocument().getLength());
            });
        }

        @Override
        public void write(byte[] b, int off, int len) {
            String text = new String(b, off, len);
            SwingUtilities.invokeLater(() -> {
                textArea.append(text);
                textArea.setCaretPosition(textArea.getDocument().getLength());
            });
        }
    }



    public static void main(String[] args)
    {
        // Создаем основное окно
        JFrame frame = new JFrame("Автотести для проекту ОЛС");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);
        frame.setLayout(new BorderLayout());
//
//        // Левая панель с кнопками
//        JPanel buttonPanel = new JPanel();
//        buttonPanel.setLayout(new GridLayout(0, 1));
//        frame.add(buttonPanel, BorderLayout.WEST);
//
//        // Правая панель с текстовым окном (консоль)
//        JTextArea consoleTextArea = new JTextArea();
//        consoleTextArea.setEditable(false); // Консоль только для чтения
//        consoleTextArea.setFont(new Font("Arial", Font.PLAIN, 12)); // Установка шрифта с поддержкой кириллицы
//        consoleTextArea.setLineWrap(true); // Включаем перенос строк
//        consoleTextArea.setWrapStyleWord(true); // Перенос по словам
//        JScrollPane scrollPane = new JScrollPane(consoleTextArea);
//        frame.add(scrollPane, BorderLayout.CENTER);
//
//        // Перенаправляем System.out и System.err в JTextArea
//        PrintStream printStream = new PrintStream(new TextAreaOutputStream(consoleTextArea), true);
//        System.setOut(printStream);
//        System.setErr(printStream);
//
//        // Экземпляры ваших классов
//        CheckMainPage cmp = new CheckMainPage();
//        Сryptotest crt = new Сryptotest();
//        ClientCabinet bnl=new ClientCabinet();
//
//        // Добавляем кнопки с обработчиками
//        addButton(buttonPanel, "Перевірка сторінки Акції", () -> executeWithNewDriver((driver, wait) -> cmp.CheckSalePage(driver, wait)));
//        addButton(buttonPanel, "Перевірка сторінки Про нас", () -> executeWithNewDriver((driver, wait) -> cmp.CheckAboutAsPage(driver, wait)));
//        addButton(buttonPanel, "Перевірка сторінки Контакти", () -> executeWithNewDriver((driver, wait) -> cmp.CheckContactsPage(driver, wait)));
//        addButton(buttonPanel, "Перевірка сторінки Партнери", () -> executeWithNewDriver((driver, wait) -> cmp.CheckPartnerPage(driver, wait)));
//        addButton(buttonPanel, "Перевірка сторінки АПІ", () -> executeWithNewDriver((driver, wait) -> cmp.CheckApiPage(driver, wait, frame)));
//        addButton(buttonPanel, "Перевірка сторінки Криптотест (файловий ключ)", () -> executeWithNewDriver((driver, wait) -> crt.СryptoTestWithFileKey(driver, wait, frame)));
//        addButton(buttonPanel, "Перевірка сторінки Користувачі", () -> executeWithNewDriver((driver, wait) -> cmp.CheckCustomerPage(driver, wait)));
//        addButton(buttonPanel, "Створення замовлення на Ліцензію (МАО транзакції)", () -> executeWithNewDriver((driver, wait) -> bnl.BuyMaoTransactions(driver, wait)));


//        ClientCabinet bnl=new ClientCabinet();
//        executeWithNewDriver((driver, wait) -> bnl.BuyMaoTransactions(driver, wait, frame));

        Test tet=new Test();
        executeWithNewDriver((driver, wait) -> tet.Test1(driver, wait, frame));

//        CheckMainPage cmp = new CheckMainPage();
//        executeWithNewDriver((driver, wait) -> cmp.CheckCustomerPage(driver, wait));



//          Форма остается открытой
//        frame.setVisible(true);








    }


//        CheckMainPage cmp=new CheckMainPage();
//        Сryptotest crt=new Сryptotest();
//        executeWithNewDriver( (driver,wait)-> cmp.CheckSalePage(driver, wait));
//        executeWithNewDriver( (driver,wait)-> cmp.CheckAboutAsPage(driver, wait));
//        executeWithNewDriver( (driver,wait)-> cmp.CheckContactsPage(driver, wait));
//        executeWithNewDriver( (driver,wait)-> cmp.CheckPartnerPage(driver, wait));
//        executeWithNewDriver( (driver,wait)-> cmp.CheckApiPage(driver, wait));
//        executeWithNewDriver((driver, wait)-> crt.СryptoTestWithFileKey(driver, wait));

//        AuthFileKey afk=new AuthFileKey();
//        afk.AuthWithTestKndpKey(driver, wait,  Credentials.PassForTestKndpTov12Dir, Credentials.WayForKeyForTestKndpTov12Die) ;
//        ChangeRole chr=new ChangeRole();
//        chr.UseClientRole(driver, wait, 30);

//        bnl.SignMyDocs(driver, wait);


}
