package OLS;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class WindowsHelper
{
    public static boolean isFileDownloaded(String dirPath, String fileName, int SleepTime)
    {
        try
        {
            Thread.sleep(SleepTime);

            File folder = new File(dirPath);
            File[] files = folder.listFiles();

            if (files != null)
            {
                for (File file : files)
                {
                    if (file.getName().contains(fileName))
                    {
                        return true;
                    }
                }
                return false;
            }

            return false;


        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
            return false;
        }
        catch(NullPointerException e)
        {
            e.printStackTrace();
            return false;
        }

    }


    //  Choose filefrom PC
    public static void ChooseFileFromPC(String WayToPKey) throws AWTException
    {
        Robot robot = new Robot();
        robot.delay(2000);
        StringSelection stringSelection = new StringSelection(WayToPKey);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(2000);
    }




}
