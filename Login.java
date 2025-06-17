package automationScenarios;

import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Browser; 
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;

public class Login{
	public static void main(String[] args) {
		Browser browser=Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page=browser.newPage();
		page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println(page.title());
		page.getByPlaceholder("Username").fill("Admim");
		page.getByPlaceholder("Password").fill("admin123");
		page.locator("xpath=//button[contains(@class,'login')]").click(); 
		System.out.println("Login successfully");
		page.close();
		browser.close();
	}
}