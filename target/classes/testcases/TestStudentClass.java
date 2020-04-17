package testcases;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import task.AppOperation;
import task.AppiumConf;
import util.TestNGListener;

public class TestStudentClass {
    private Logger log = Logger.getLogger(TestStudentClass.class);//输出Log日
    public  static AndroidDriver androidDriver;
    AppOperation  ap= new AppOperation();
    AppiumConf ac = new AppiumConf();
    @BeforeMethod
    public  void setUp() throws Exception {
        ac.setUp();
    }
    @Test(description = "学生上课")
    public void testStudentClass()throws Exception{
        try {
            //选择年级
            ap.selectGrade();
            //登录
            ap.login();
            //去上课模块
            ap.gotoClass();
        }catch (Exception e){
            getDriver();
            Assert.assertTrue(false);
        }
    }
    @AfterMethod
    public void Logout()throws Exception{
        //退出
        ap.Logout();
    }

    public static AppiumDriver getDriver()
    {
        return androidDriver;
    }





}
