package testcases;

import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import task.AppOperation;
import task.AppOrder;
import task.AppiumConf;

import static testcases.TestStudentClass.getDriver;

public class TestMyOrder {
    final  static Logger logger = LoggerFactory.getLogger(TestMyOrder.class);
    public  static AndroidDriver<WebElement> androidDriver ;
    AppOrder ao = new AppOrder();
    AppOperation ap= new AppOperation();
    AppiumConf ac = new AppiumConf();
    @BeforeMethod
    public void setUp() throws Exception {
        ac.setUp();
    }
    @Test(description = "查看订单详情")
    public void orderInf(){
       try{
           //选择年级
           ap.selectGrade();
           ap.login();
           //进入到我的页面
           ao.userButton();
           //查看订单详情页
           ao.myOrder();
       }catch (Exception e){
           getDriver();
           Assert.assertTrue(false);
           logger.info("未找到元素");
       }
    }
    @AfterMethod
    public void Logout()throws Exception{
        //退出
        ap.Logout();
    }
}
