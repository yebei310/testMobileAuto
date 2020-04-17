package util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import task.AppOperation;
import testcases.TestStudentClass;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestNGListener extends TestListenerAdapter{

    @Override
    public void onTestFailure(ITestResult tr){
        try {
            super.onTestFailure(tr);
            //调用屏幕截图方法
            captureScreenShot(tr,tr.getMethod().getMethodName());
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public void captureScreenShot(ITestResult result,String name) {
        AppiumDriver driver = TestStudentClass.getDriver();
        File srcFile = driver.getScreenshotAs(OutputType.FILE);
        String filepath = System.getProperty("user.dir")+"\\img";
        if(!(new File(filepath).isDirectory())){
            new File(filepath).mkdir();
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss sss");
        try {
            String fileName=new File(filepath + File.separator +name+"-"+ dateFormat.format(new Date()) + ".png").getName();
            FileUtils.copyFile(srcFile, new File(filepath + File.separator +name+"-"+ dateFormat.format(new Date()) + ".png"));
            System.out.printf("失败截图成功,截图name：----------------- "+fileName+"-----------------");
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

}