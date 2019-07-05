package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {
    public static final String XPATH_SELECT_DAY = "//span[contains(@class, \"_5k_4\")]/span/select[1]";
    public static final String XPATH_SELECT_MONTH = "//span[contains(@class, \"_5k_4\")]/span/select[2]";
    public static final String XPATH_SELECT_YEAR = "//span[contains(@class, \"_5k_4\")]/span/select[3]";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com/");

        WebElement selectDay = driver.findElement(By.xpath(XPATH_SELECT_DAY));
        Select day = new Select(selectDay);
        day.selectByValue("2");

        WebElement selectMonth = driver.findElement(By.xpath(XPATH_SELECT_MONTH));
        Select month = new Select(selectMonth);
        month.selectByIndex(11);

        WebElement selectYear = driver.findElement(By.xpath(XPATH_SELECT_YEAR));
        Select year = new Select(selectYear);
        year.selectByValue("1999");
    }
}
