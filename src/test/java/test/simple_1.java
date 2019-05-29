package test;

import org.openqa.selenium.By;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import tiki.vn.qc.Config;
import tiki.vn.qc.Page;

public class simple_1 {
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
	public void search(){
		
       this.page.openLink("https://tala.xyz");
	   //this.page.openLink("https://tiki.vn");
       //if(this.page.existsElement(By.xpath("//button[text()='Để sau']")))
       //{
       //this.page.click(By.xpath("//button[text()='Để sau']"));
       //}
       this.page.waiting_clickable_element(By.xpath("//input[@name='q']"));
       this.page.writeText(By.xpath("//input[@name='q']"),"Mình Sinh Ra Đâu Phải Để Buồn");
       this.page.click(By.xpath("//div[@class='search-wrap']//button[@type='submit']"));
       this.page.waiting_visibility_element(By.xpath("//div[@class='product-box-list']/div[@data-title='Mình Sinh Ra Đâu Phải Để Buồn']"));
       //this.page.getAttribute(elementLocation, "data", value)
	   //capabilities.setPlatform(Platform.WINDOWS);
       //WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4445/wd/hub"),capabilities);
	 }
	
	@AfterSuite
	public void Teardown()
	{
		//this.page.closeBrowse();
	}

}
