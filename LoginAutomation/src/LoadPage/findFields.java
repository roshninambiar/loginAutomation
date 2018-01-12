package LoadPage;

import LoadPage.loadPage;

import java.util.List;
import java.util.ListIterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class findFields {

		WebDriver driver;
		
		@BeforeTest
		public void openBrowser(){
			System.out.println("Before Test 2");
			loadPage l = new loadPage();
			String url = l.baseURL;
			
			System.setProperty("webdriver.gecko.driver", "/home/devteam/Documents/AllDrivers/geckodriver");
			driver = new FirefoxDriver();
			driver.get(url);
		}
		
		@Test(priority = 2)
		public void find(){
			int i=0;
			System.out.println("Test 2");
			
			/*List<WebElement> listOfWebElements = driver.findElements(By.cssSelector("input")); 
			ListIterator li = listOfWebElements.listIterator();
			while(li.hasNext() && i<3){
				//li.hasNext()
				i++;
				System.out.print(li.next()+ "     ");
			}
*/

			List<WebElement> el = driver.findElements(By.xpath("//*"));
            int count=0;
            for ( WebElement e : el ) {
             System.out.println( e.getTagName()+" : "+ e.getAttribute("name")+ " : "+e.getAttribute("id")+" : ");
             count++;
             
            }
            
            System.out.println(count );


		}
		
		@AfterTest
		public void confirmCompletion2(){
			/*List<WebElement> elements = driver.findElements(By.xpath("//div[@id='container']"));    
            System.out.println("Test7 number of elements: " + elements.size());

            for(WebElement ele : elements){
                //ele.sendKeys("hexbyes");
                System.out.println(ele.getText());
                //System.out.println(ele.getAttribute("id"));
                //System.out.println(ele.getTagName());
            } 
        }*/
		}
}
