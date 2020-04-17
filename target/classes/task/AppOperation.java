package task;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.sql.Connection;
import java.util.concurrent.TimeUnit;
import static io.appium.java_client.android.AndroidKeyCode.KEYCODE_BACK;
import static testcases.TestStudentClass.androidDriver;
import io.appium.java_client.AppiumDriver;
import org.slf4j.LoggerFactory;
import testcases.TestStudentClass;

public  class AppOperation {
    private Logger log = Logger.getLogger(AppOperation.class);
    // 打开app弹框选择年级
    public   void selectGrade() throws Exception{
        try {
            Thread.sleep(3000);
            WebElement wb =androidDriver.findElementByXPath("//android.support.v7.widget.RecyclerView[@resource-id='com.pxwx.student:id/rv_grade']/android.widget.LinearLayout[9]");
            androidDriver.tap(1, wb, 500);
            log.info("选择年级suceess");
            androidDriver.findElementByXPath("//android.widget.TextView[@resource-id='com.pxwx.student:id/btn_right']").click();
            Thread.sleep(3000);
        }catch (Exception e){
            getDriver();
            e.printStackTrace();
            System.out.println("没有定位到年级12system"+e.getMessage());
            log.info("没有定位到年级22log"+e.getMessage());
            Assert.assertTrue(false);
        }

    }
    public  void  login()throws Exception {
        try {
            //跳转密码登录页面
            androidDriver.findElementByXPath("//android.widget.RadioButton[@resource-id='com.pxwx.student:id/main_tab_user']").click();
            Thread.sleep(2000);
            androidDriver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.pxwx.student:id/loginfragment_password_login_view']")).click();
            Thread.sleep(2000);
            androidDriver.findElementByXPath("//android.widget.EditText[@resource-id='com.pxwx.student:id/loginfragment_phone_num_view']").click();
            //输入账号密码
            androidDriver.pressKeyCode(AndroidKeyCode.KEYCODE_1);
            androidDriver.pressKeyCode(AndroidKeyCode.KEYCODE_3);
            androidDriver.pressKeyCode(AndroidKeyCode.KEYCODE_7);
            androidDriver.pressKeyCode(AndroidKeyCode.KEYCODE_1);
            androidDriver.pressKeyCode(AndroidKeyCode.KEYCODE_8);
            androidDriver.pressKeyCode(AndroidKeyCode.KEYCODE_2);
            androidDriver.pressKeyCode(AndroidKeyCode.KEYCODE_4);
            androidDriver.pressKeyCode(AndroidKeyCode.KEYCODE_2);
            androidDriver.pressKeyCode(AndroidKeyCode.KEYCODE_4);
            androidDriver.pressKeyCode(AndroidKeyCode.KEYCODE_5);
            androidDriver.pressKeyCode(AndroidKeyCode.KEYCODE_3);
            androidDriver.findElementByXPath("//android.widget.EditText[@resource-id='com.pxwx.student:id/loginfragment_password_view']").click();
            androidDriver.pressKeyCode(AndroidKeyCode.KEYCODE_2);
            androidDriver.pressKeyCode(AndroidKeyCode.KEYCODE_4);
            androidDriver.pressKeyCode(AndroidKeyCode.KEYCODE_2);
            androidDriver.pressKeyCode(AndroidKeyCode.KEYCODE_4);
            androidDriver.pressKeyCode(AndroidKeyCode.KEYCODE_5);
            androidDriver.pressKeyCode(AndroidKeyCode.KEYCODE_3);
            androidDriver.pressKeyCode(KEYCODE_BACK);
            androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            androidDriver.findElementByXPath("//android.widget.Button[@resource-id='com.pxwx.student:id/loginfragment_login_view']").click();

            Thread.sleep(3000);
            String title = androidDriver.findElementByXPath("//android.widget.TextView[@resource-id='com.pxwx.student:id/toolbar_title']").getText();
            if (!title.isEmpty()) {
                if (title.contains("我的课程")) {
//                System.out.printf("进入学习模块，获取到title：" + title);
                    log.info("进入学习模块，获取到title：" + title);
                    log.info("进入学习模块，获取到title：" + title);
                    Assert.assertTrue(true);
                } else {
                    System.out.printf("学习模块异常，请查看" + title);
                    Assert.assertTrue(false);
                }
            }

        }catch (Exception e){
            getDriver();
            e.printStackTrace();
            Assert.assertTrue(false);
        }
    }
    //学生端上课模块
    public  void gotoClass() {
        try {
            androidDriver.findElementByXPath("//android.widget.TextView[@resource-id='com.pxwx.student:id/live_status' and @text='去上课']").click();
            Thread.sleep(10000);
            getTap(androidDriver, 1500, 1000);
            getTap(androidDriver, 1200, 1000);
            getTap(androidDriver, 1500, 1150);
            androidDriver.findElementByXPath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[2]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[2]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.ImageView[1]").click();
            Thread.sleep(40000);
            androidDriver.findElementByXPath("//android.widget.TextView[@text='老师棒棒哒']").click();
            Thread.sleep(3000);
            String as = androidDriver.findElementByXPath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[2]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[2]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]").getText();
            System.out.printf(as);
            if (!as.isEmpty()) {
                if (as.contains("我：老师棒棒哒")) {
                    System.out.printf("快捷发布成功");
                    Assert.assertTrue(true);
                } else {
                    System.out.printf("快捷发布失败");
                    Assert.assertTrue(false);
                }
            }
            androidDriver.pressKeyCode(AndroidKeyCode.KEYCODE_BACK);
            androidDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            androidDriver.findElementByXPath("//android.widget.TextView[@resource-id='com.pxwx.student:id/md_buttonDefaultPositive' and @text='退出']").click();
        }catch (Exception e){
            getDriver();
            e.printStackTrace();
            Assert.assertTrue(false);
        }
    }

    //坐标位置
    public  void getTap(AndroidDriver<WebElement> driver,int x,int y)throws Exception{
        try {
            int width = driver.manage().window().getSize().width;
            int height = driver.manage().window().getSize().height;
            driver.tap(1, x, y, 0);
            Thread.sleep(5000);
        }catch (Exception e){
            System.out.printf("查找引导语坐标位置异常"+e.getMessage());
        }

    }
    public  void  Logout() throws Exception {
        androidDriver.quit();
    }

    public static AppiumDriver getDriver()
    {
        return androidDriver;
    }

}
