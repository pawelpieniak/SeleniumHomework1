import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class Exercise2 extends TestBase {

    @Test
    public void Test1(){
        driver.get("http://146.59.32.4/index.php");

        WebElement signInButton = driver.findElement(By.xpath("//div[@id='_desktop_user_info']"));
        signInButton.click();

        WebElement noAccountButton = driver.findElement(By.xpath("//a[@data-link-action='display-register-form']"));
        noAccountButton.click();

        WebElement firstNameInput = driver.findElement(By.xpath("//form[@id='customer-form']//input[@name='firstname']"));
        WebElement lastNameInput = driver.findElement(By.xpath("//form[@id='customer-form']//input[@name='lastname']"));
        WebElement emailInput = driver.findElement(By.xpath("//form[@id='customer-form']//input[@name='email']"));
        WebElement passwordInput = driver.findElement(By.xpath("//form[@id='customer-form']//input[@name='password']"));
        WebElement customer_privacyInput = driver.findElement(By.xpath("//form[@id='customer-form']//input[@name='customer_privacy']"));
        WebElement psgdprInput = driver.findElement(By.xpath("//form[@id='customer-form']//input[@name='psgdpr']"));
        WebElement saveButton = driver.findElement(By.xpath("//button[@data-link-action='save-customer']"));

        String firstName = "Staś";
        String lastName = "Gniazdowski";
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        emailInput.sendKeys(getEmail(5));
        passwordInput.sendKeys("InneH");
        customer_privacyInput.click();
        psgdprInput.click();
        saveButton.click();

        WebElement nameInfo = driver.findElement(By.xpath("//div[@id='_desktop_user_info']//a[@class='account']/span"));

        String name = firstName + " " + lastName;
        Assert.assertEquals(nameInfo.getText(), name);

    }

    String getEmail(int quantity){
        char[] signs = {'A', 'B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','0','1','2','3','4','5','6','7','8','9'};
        Random rnd = new Random();
        String email = "";
        for(int i=0; i<quantity; i++) {
            email = email + signs[rnd.nextInt(signs.length)];
        }
        email = email + "@inny.com";
        return email;
    }

}
