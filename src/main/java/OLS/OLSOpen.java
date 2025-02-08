//package OLS;
//
//import org.openqa.selenium.Dimension;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.io.PrintStream;
//import java.time.Duration;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//
//public class Main
//{
//    @FunctionalInterface
//    public interface Cases
//    {
//        void TestCase(WebDriver driver, WebDriverWait wait);
//    }
//
//    private static void executeWithNewDriver(Cases NewCase)
//    {
//        WebDriver driver = new ChromeDriver();
//        Dimension size = new Dimension(1600, 950);
//        driver.manage().window().setSize(size);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        NewCase.TestCase(driver, wait);
//        driver.quit();
//    }
//
//    private static void addButton(JPanel panel, String buttonText, Runnable action)
//    {
//        JButton button = new JButton(buttonText);
//        button.addActionListener(e -> {
//            System.out.println("=== Выполняется: " + buttonText + " ===");
//            action.run();
//            System.out.println("=== Завершено: " + buttonText + " ===");
//        });
//        panel.add(button);
//    }
//
//    static class TextAreaOutputStream extends java.io.OutputStream
//    {
//        private final JTextArea textArea;
//
//        public TextAreaOutputStream(JTextArea textArea)
//        {
//            this.textArea = textArea;
//        }
//
//        @Override
//        public void write(int b)
//        {
//            SwingUtilities.invokeLater
//                    (
//                            () ->
//                            {
//                                textArea.append(String.valueOf((char) b));
//                                textArea.setCaretPosition(textArea.getDocument().getLength());
//                            }
//                    );
//        }
//    }
//
//
//
//    public static void main(String[] args) {
//        JFrame frame = new JFrame("UI Test Form");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(800, 400);
//        frame.setLayout(new BorderLayout());
//
//        JPanel buttonPanel = new JPanel();
//        buttonPanel.setLayout(new GridLayout(0, 1));
//        frame.add(buttonPanel, BorderLayout.WEST);
//
//        JTextArea consoleTextArea = new JTextArea();
//        consoleTextArea.setEditable(false); // Консоль только для чтения
//        consoleTextArea.setFont(new Font("Arial", Font.PLAIN, 12)); // Установка шрифта с поддержкой кириллицы
//        consoleTextArea.setLineWrap(true); // Включаем перенос строк
//        consoleTextArea.setWrapStyleWord(true); // Перенос по словам
//        JScrollPane scrollPane = new JScrollPane(consoleTextArea);
//        frame.add(scrollPane, BorderLayout.CENTER);
//
//        PrintStream printStream = new PrintStream(new Main.TextAreaOutputStream(consoleTextArea));
//        System.setOut(printStream);
//        System.setErr(printStream);
//
//        CheckMainPage cmp = new CheckMainPage();
//        Сryptotest crt = new Сryptotest();
//
//        addButton(buttonPanel, "Check Sale Page", () -> executeWithNewDriver((driver, wait) -> cmp.CheckSalePage(driver, wait)));
//        addButton(buttonPanel, "Check About Us Page", () -> executeWithNewDriver((driver, wait) -> cmp.CheckAboutAsPage(driver, wait)));
//        addButton(buttonPanel, "Check Contacts Page", () -> executeWithNewDriver((driver, wait) -> cmp.CheckContactsPage(driver, wait)));
//        addButton(buttonPanel, "Check Partner Page", () -> executeWithNewDriver((driver, wait) -> cmp.CheckPartnerPage(driver, wait)));
//        addButton(buttonPanel, "Check API Page", () -> executeWithNewDriver((driver, wait) -> cmp.CheckApiPage(driver, wait)));
//        addButton(buttonPanel, "Crypto Test", () -> executeWithNewDriver((driver, wait) -> crt.СryptoTestWithFileKey(driver, wait)));
//
//        frame.setVisible(true);
//    }
//
//
////        CheckMainPage cmp=new CheckMainPage();
////        Сryptotest crt=new Сryptotest();
////        executeWithNewDriver( (driver,wait)-> cmp.CheckSalePage(driver, wait));
////        executeWithNewDriver( (driver,wait)-> cmp.CheckAboutAsPage(driver, wait));
////        executeWithNewDriver( (driver,wait)-> cmp.CheckContactsPage(driver, wait));
////        executeWithNewDriver( (driver,wait)-> cmp.CheckPartnerPage(driver, wait));
////        executeWithNewDriver( (driver,wait)-> cmp.CheckApiPage(driver, wait));
////        executeWithNewDriver((driver, wait)-> crt.СryptoTestWithFileKey(driver, wait));
//
////        AuthFileKey afk=new AuthFileKey();
////        afk.AuthWithTestKndpKey(driver, wait,  Credentials.PassForTestKndpTov12Dir, Credentials.WayForKeyForTestKndpTov12Die) ;
////        ChangeRole chr=new ChangeRole();
////        chr.UseClientRole(driver, wait, 30);
////        ClientCabinet bnl=new ClientCabinet();
////        bnl.BuyMaoTransactions(driver, wait);
////        bnl.SignMyDocs(driver, wait);
//
//
//}
