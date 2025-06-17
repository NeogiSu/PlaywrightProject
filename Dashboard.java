package automationScenarios;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Dashboard {
	public static void main(String[] args) {
		Browser browser=Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page=browser.newPage();
		page.navigate("https://www.saucedemo.com/");
		page.getByPlaceholder("Username").fill("standard_user");
		page.getByPlaceholder("Password").fill("secret_sauce");
		Locator loginBtn=page.locator("//*[contains(@id,'login')]");
		int count=loginBtn.count();
		System.out.println(count);
		loginBtn.nth(1).click();
		Locator title=page.locator("xpath=//div[@class='app_logo']");
		System.out.println(title.textContent());
		page.close();
		browser.close();
	}
}
