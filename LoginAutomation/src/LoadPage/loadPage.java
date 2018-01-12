package LoadPage;

import org.testng.annotations.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class loadPage {
		
	
		public void loadPage(){
			
		}
		String baseURL = "http://demo.guru99.com/selenium/upload/";
		
		@Test(priority = 1)
		public void checkStatusCode() throws ClientProtocolException, IOException{
			
			System.out.println("Test 1");
			
			//Get status code
			HttpClient httpclient = new DefaultHttpClient();
			HttpGet httpget = new HttpGet(baseURL);
		    HttpResponse response = httpclient.execute(httpget);
			StatusLine sl = response.getStatusLine();
			int code = sl.getStatusCode();
						
			//Take success condition from excel 
			File f = new File("/home/devteam/Documents/ExcelFiles/testLogin.xls");
			FileInputStream fis = new FileInputStream(f);
			HSSFWorkbook wb = new HSSFWorkbook(fis);
			HSSFSheet sheet1 = wb.getSheetAt(0);
			int success = (int) Math.round(sheet1.getRow(2).getCell(7).getNumericCellValue());
			int failure = (int) Math.round(sheet1.getRow(2).getCell(8).getNumericCellValue());
			
			//check if status code is a success or failure condition
			if(code == success){
				System.out.println("Success");
			}
			else if(code == failure){
				System.out.println("Failure");
			}
			
		
		}
		
		@AfterTest
		public void confirmCompletion(){
			System.out.println("After Test 1");
		}
}
