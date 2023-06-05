package LoginFeature;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginOperation extends BaseDriver {


    @Test
    @Parameters({"usernm","pssword"})
    void loginTeacherOperation(String usernm,String pssword){

        WebElement inputEmail=driver.findElement(By.id("mat-input-0"));
        inputEmail.sendKeys(usernm);

        WebElement password=driver.findElement(By.id("mat-input-1"));
        password.sendKeys(pssword);

        WebElement loginBtn=driver.findElement(By.xpath("//span[@class='mat-button-wrapper']"));
        loginBtn.click();

        WebElement assertText=driver.findElement(By.xpath("//span[text()='Staj 2023']"));
        wait.until(ExpectedConditions.visibilityOf(assertText));

        Assert.assertTrue(assertText.getText().contains("Staj 2023"));
        //Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Techno Study Intern School']")).getText().equals("Techno Study Intern School"));
    }
}
