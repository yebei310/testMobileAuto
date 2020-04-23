package util;

import com.google.common.io.Files;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import task.AppOperation;
import testcases.TestStudentClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static testcases.TestStudentClass.getDriver;

public class TestNGListener extends TestListenerAdapter{
//    public class TestNGListener extends TestListenerAdapter implements IHookable {



    File srcFile;


    AppiumDriver driver;
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
//        FileInputStream fis;
         driver = TestStudentClass.getDriver();
         srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String filepath = System.getProperty("user.dir")+"\\img";
        if(!(new File(filepath).isDirectory())){
            new File(filepath).mkdir();
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss sss");
        try {
            String fileName=new File(filepath + File.separator +name+"-"+ dateFormat.format(new Date()) + ".png").getName();
            FileUtils.copyFile(srcFile, new File(filepath + File.separator +name+"-"+ dateFormat.format(new Date()) + ".png"));
            System.out.printf("失败截图成功,截图name：----------------- "+fileName+"-----------------");

//            fis=new FileInputStream(srcFile);
//            byte[] read =new byte[1024*1024];
//            fis.read(read);
//            this.saveScreenshot(read);
//            fis.close();
            takeScreenShot(name);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
//    @Attachment(value = "截图",type = "image/png")
//    public byte[] saveScreenshot(){
//
//        byte[] screenshotAs = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
//        return screenshotAs;
//    }



//
//    public void run(IHookCallBack callBack, ITestResult testResult) {
//        callBack.runTestMethod(testResult);
//        if (testResult.getThrowable() != null) {
//            try {
//                takeScreenShot(testResult.getMethod().getMethodName());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }

    @Attachment(value = "Failure in method {0}", type = "image/png")
    private byte[] takeScreenShot(String methodName) throws IOException {
//        File screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);


        return Files.toByteArray(srcFile);
    }

//    @Attachment(value = "Failure in method {0}", type = "image/png")
//    private byte[] takeScreenShot(String methodName) throws IOException {
//        return  ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
////        return ((TakesScreenshot)WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
//    }

}