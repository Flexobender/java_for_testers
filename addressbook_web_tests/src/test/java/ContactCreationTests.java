import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


class ContactCreationTests extends TestBase {

    @Test
    public void canCreateContact() {

        openContactPage();
        driver.findElement(By.name("firstname")).click();
        driver.findElement(By.name("firstname")).sendKeys("alex");
        driver.findElement(By.name("address")).click();
        driver.findElement(By.name("address")).sendKeys("tver");
        driver.findElement(By.name("mobile")).click();
        driver.findElement(By.name("mobile")).sendKeys("915 789 65 83");
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys("alex@tver.ru");
        driver.findElement(By.xpath("(//input[@name=\'submit\'])[2]")).click();
        driver.findElement(By.linkText("home page")).click();
        driver.findElement(By.linkText("Logout")).click();
    }
}
