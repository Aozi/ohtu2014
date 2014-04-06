package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Tester {
    public static void main(String[] args) {
        WebDriver driver = new HtmlUnitDriver();

        driver.get("http://localhost:8090");
        System.out.println( driver.getPageSource() );
        
        
        System.out.println("Succesfull login:");
        simulateSuccesfullLogin(driver);
        System.out.println("===================================================");
        System.out.println("Wrong password");
        simulateWrongPassword(driver);
        System.out.println("===================================================");
        System.out.println("Wrong ID");
        simulateWrongID(driver);
        System.out.println("===================================================");
        System.out.println("Create new USer");
        createNewUser(driver);
        System.out.println("===================================================");
        System.out.println("Log out afdter creating new user");
        logOutAfterUserCreation(driver);
    }

    public static void simulateWrongPassword(WebDriver driver) {
        
        driver.get("http://localhost:8090");
        
        System.out.println( driver.getPageSource() );
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click();  
        
        System.out.println("==");
        
        System.out.println( driver.getPageSource() );
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("keppa");
        element = driver.findElement(By.name("login"));
        element.submit();
        
        System.out.println("==");
        System.out.println( driver.getPageSource() );        
    } 
    
    
    public static void simulateWrongID(WebDriver driver) {
        
        driver.get("http://localhost:8090");
        
        System.out.println( driver.getPageSource() );
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click();         

        System.out.println( driver.getPageSource() );
        element = driver.findElement(By.name("username"));
        element.sendKeys("aaaaaaaaaa");
        element = driver.findElement(By.name("password"));
        element.sendKeys("bbbbbbbbbbb");
        element = driver.findElement(By.name("login"));
        element.submit();
        
        System.out.println("==");
        System.out.println( driver.getPageSource() ); 
        
        
    }
    
    public static void simulateSuccesfullLogin(WebDriver driver) {
        
        driver.get("http://localhost:8090");
        
        System.out.println( driver.getPageSource() );
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click(); 
        
        System.out.println("==");
        
        System.out.println( driver.getPageSource() );
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        element.submit();
        
        System.out.println("==");
        System.out.println( driver.getPageSource() );       
    }
    
    public static void createNewUser(WebDriver driver) {
        
        driver.get("http://localhost:8090");

        System.out.println( driver.getPageSource() );
        WebElement element = driver.findElement(By.linkText("register new user"));       
        element.click();
        
        System.out.println("==");
        
        System.out.println( driver.getPageSource() );        

        element = driver.findElement(By.name("username"));
        element.sendKeys("Jarmo");
        element = driver.findElement(By.name("password"));
        element.sendKeys("armo");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("armo");

        element = driver.findElement(By.name("add"));
        element.submit();
        System.out.println("==");
        
        System.out.println( driver.getPageSource() ); 
        
        
        
    }
    
        public static void logOutAfterUserCreation(WebDriver driver) {

        driver.get("http://localhost:8090/newUser");
        
        System.out.println( driver.getPageSource() );  
        System.out.println("==");
        WebElement element = driver.findElement(By.linkText("continue to application mainpage"));       
        element.click();
        System.out.println("==");
        System.out.println( driver.getPageSource() );          
        element = driver.findElement(By.linkText("logout")); 
        element.click();
        System.out.println("==");
        System.out.println( driver.getPageSource() );  
        
            
            
            
        }
    
}
