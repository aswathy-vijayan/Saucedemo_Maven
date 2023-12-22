package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver d) {
		this.driver = d;
	}

	public void setUsername(String name) {
		WebElement uname = driver.findElement(By.id("user-name"));
		uname.sendKeys(name);
	}

	public void setPassword(String password) {
		WebElement passwd = driver.findElement(By.id("password"));
		passwd.sendKeys(password);
	}
	
	public void clickLogin() {
		WebElement btn = driver.findElement(By.id("login-button"));
		btn.click();

	}

	public String checkLoginStatus() {
		return driver.findElement(By.xpath("//h3[@data-test=\"error\"]")).getText();
	}
}
