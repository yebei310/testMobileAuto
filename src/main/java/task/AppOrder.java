package task;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static testcases.TestStudentClass.androidDriver;

public class AppOrder {
    WebElement we;
    final  static Logger logger = LoggerFactory.getLogger(AppOrder.class);
    public void userButton(){
        androidDriver.findElementByXPath("//android.widget.RadioButton[@resource-id='com.pxwx.student:id/main_tab_user']").click();
        we= androidDriver.findElementByXPath("//android.widget.TextView[@resource-id='com.pxwx.student:id/tv_card']");
        String inf= we.getText();
        if (inf.contains("我的订单")){
            System.out.println("进入到【我的】页面");
        }else {
            System.out.println("【我的】页面异常,没有找到【我的订单】模块");
            Assert.assertTrue(false);
        }
    }
    public void myOrder(){
        //进入我的订单页面
        androidDriver.tap(1,we,500);
        logger.info("进入到我的订单页面");
        System.out.print("进入到我的订单页面");
       WebElement wb1= androidDriver.findElementByXPath("//android.widget.TextView[@resource-id='com.pxwx.student:id/toolbar_right_txt']");
       String title =wb1.getText();
       if (title.contains("申请开票")){
           System.out.println("进入到我的订单列表页");
       }else {
           System.out.println("我的订单列表页异常,");
           Assert.assertTrue(false);
       }
       androidDriver.findElementByXPath("//android.support.v7.widget.RecyclerView[@resource-id='com.pxwx.student:id/recyclerView']/android.widget.LinearLayout[1]").click();
       WebElement wb2= androidDriver.findElementByXPath("//android.widget.TextView[@text='课程信息']");
       String orderInf = wb2.getText();
        if (orderInf.contains("课程信息")){
            System.out.println("进入到订单详情页");
        }else {
            System.out.println("订单详情页异常,");
            Assert.assertTrue(false);
        }




    }
}
