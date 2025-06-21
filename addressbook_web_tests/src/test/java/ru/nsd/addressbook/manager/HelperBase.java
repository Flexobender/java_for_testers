package ru.nsd.addressbook.manager;

import org.openqa.selenium.By;

public class HelperBase {
    protected final ApplicationManager manager;

    public HelperBase(ApplicationManager manager) {
        this.manager = manager;
    }

    protected void click(String target) {
        manager.driver.findElement(By.name(target)).click();
    }

    protected void clickLink(String target) {
        manager.driver.findElement(By.linkText(target)).click();
    }

    protected void fillIn(String text, String target) {
        manager.driver.findElement(By.name(target)).sendKeys(text);
    }

    protected void clickXpath(String xpath) {
        manager.driver.findElement(By.xpath(xpath)).click();
    }
    protected void clickCssSelector(String cssSelector) {
        manager.driver.findElement(By.cssSelector(cssSelector)).click();
    }
}
