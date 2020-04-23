package task;

import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import util.TestBase;

import static testcases.TestStudentClass.androidDriver;
import java.net.URL;

public class AppiumConf extends TestBase {
    private Logger log = Logger.getLogger(AppiumConf.class);
    TestBase testBase=new TestBase();
    String deviceName = prop.getProperty("deviceName");
    String platformName = prop.getProperty("platformName");
    String platformVersion = prop.getProperty("platformVersion");
    String appPackage = prop.getProperty("appPackage");
    String appActivity = prop.getProperty("appActivity");
    String automationName = prop.getProperty("automationName");
    public  void setUp() throws Exception {


        //1.添加配置，创建DesiredCapabilities对象
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        //指定测试设备的名称
        desiredCapabilities.setCapability("deviceName", deviceName);
        //添加操作系统配置
        desiredCapabilities.setCapability("platformName", platformName);
        //添加操作系统版本设置
        desiredCapabilities.setCapability("platformVersion", platformVersion);
        //指定想要测试应用的包名
        desiredCapabilities.setCapability("appPackage", appPackage);
        //指定想要测试应用的入口activity
        desiredCapabilities.setCapability("appActivity", appActivity);
        desiredCapabilities.setCapability("automationName", automationName);
        //2.创建驱动...URL是appium的固定地址；指定appium通讯的地址，将相对应的配置传入到驱动里边
        androidDriver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);
        log.info("log 初始化app配置");
        System.out.printf("初始化app配置");
    }
}
