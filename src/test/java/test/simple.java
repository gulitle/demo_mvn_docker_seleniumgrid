package test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import tiki.vn.qc.Config;
import tiki.vn.qc.Page;

public class simple {
	
	private Page page= null;

	@BeforeSuite
	public void setup(ITestContext ctx)
	{
		System.out.print(ctx.getSuite().getName());
		String strSuiteName = ctx.getSuite().getName();
		Config.getConfig();
		this.page = new Page(strSuiteName);
	}
	@Test
	public void doLogin()
	{
		this.page.openLink("https://tala.xyz");
		//this.page.openLink("https://tiki.vn");
		this.page.clickByAction(By.xpath("//small[text()='Tài khoản']"));
		this.page.click(By.cssSelector("a.user-name-login"));
		this.page.writeText(By.xpath("//input[@id='popup-login-email']"), "lit.le@tiki.vn"); // input username
		//this.page.writeText(By.xpath("//input[@id='popup-login-email']"), "legulit2806@gmail.com"); // input username
		this.page.writeText(By.xpath("//input[@id='login_password']"), "123456789"); //input password
		this.page.click(By.xpath("//button[@id='login_popup_submit']"));
		
	}
	
	//@Test
	public void order(){
		this.doLogin();
		//choose list book
        this.page.waiting_clickable_element(By.xpath("//a[contains(@href,'https://tala.xyz/nha-sach-tiki')]"));
        this.page.click(By.xpath("//a[contains(@href,'https://tala.xyz/nha-sach-tiki')]"));
        
        // order book
        this.page.waiting_clickable_element(By.xpath("//div[@data-title='Mình Sinh Ra Đâu Phải Để Buồn']"));
        this.page.click(By.xpath("//div[@data-title='Mình Sinh Ra Đâu Phải Để Buồn']"));
        
        //go to order management
        this.page.click(By.cssSelector("button.add-to-cart.pre-order.js-add-to-cart.is-css"));
        
        
        //execute order
        this.page.waiting_clickable_element(By.cssSelector("div.add-to-cart-success button"));
        this.page.click(By.cssSelector("div.add-to-cart-success button"));
        
        if(this.page.existsElement(By.cssSelector("div#tftRenewal.modal.fade.in"))) // popup case
        {
        	this.page.click(By.xpath("//button[text()='Nhắc tôi sau']")); //ignore tiki now
        }
        
        this.page.click(By.xpath("//button[text()='Tiến hành đặt hàng']")); //order
        
        this.page.click(By.cssSelector("button.btn.btn-default.btn-custom1.saving-address")); // confirm addrress
        
        
        //WebElement element = this.page.getElementHexColor(elementLocation)
        //this.page.clickByAction(By.xpath("//button[text()='ĐẶT MUA']"));
        this.page.waiting_clickable_element(By.xpath("//button[text()='ĐẶT MUA']"));
        this.page.scroll_into_element(By.xpath("//button[text()='ĐẶT MUA']"));
        this.page.click(By.xpath("//button[text()='ĐẶT MUA']"));
        
	
	 }
	
	@AfterSuite
	public void Teardown()
	{
		//to be implement
	}
	
}
