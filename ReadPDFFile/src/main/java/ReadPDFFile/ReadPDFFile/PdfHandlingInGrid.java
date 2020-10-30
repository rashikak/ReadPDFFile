package ReadPDFFile.ReadPDFFile;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PdfHandlingInGrid {

	
    String username = "Your username";		//Enter your username 
    String accesskey = "Your access Key";		//Enter your accesskey
    static RemoteWebDriver driver = null;
    String gridURL = "@hub.lambdatest.com/wd/hub";
    
    boolean status = false;
   
    @BeforeTest
	public void setUp()throws MalformedURLException  
	{			
		
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome"); 	  //To specify the browser
        capabilities.setCapability("version", "70.0");			  //To specify the browser version
        capabilities.setCapability("platform", "win10"); 		  // To specify the OS
        capabilities.setCapability("build", "PdfTestLambdaTest"); //To identify the test 
        capabilities.setCapability("name", "PDFHandling");
        capabilities.setCapability("network", true); 		//To enable network logs
        capabilities.setCapability("visual", true);                   // To enable step by step screenshot
        capabilities.setCapability("video", true);			// To enable video recording
        capabilities.setCapability("console", true); 			// To capture console logs
        try {
            driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
        } catch (MalformedURLException e) {
            System.out.println("Invalid grid URL");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
		
}


        @Test
        public void pdfHandle() {
    		String url ="http://www.pdf995.com/samples/pdf.pdf";
    		driver.get(url);
    		try {
    			String pdfContent = readPdfContent(url);
    			System.out.println(pdfContent);
    			Assert.assertTrue(pdfContent.contains("Introduction"));
    		} catch (MalformedURLException e) {
    			e.printStackTrace();
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
        }
        
     @AfterTest
     public void tearDown() {
    	driver.quit();
}    
     
     public static  String readPdfContent(String url) throws IOException {
    		
    	 URL pdfUrl = new URL(url);
 		InputStream in = pdfUrl.openStream();
 		BufferedInputStream bf = new BufferedInputStream(in);
 		PDDocument doc = PDDocument.load(bf);
 		PDFTextStripper pdfStrip = new PDFTextStripper();
 		pdfStrip.setStartPage(2);
 		pdfStrip.setEndPage(2);
 		
 		String content = pdfStrip.getText(doc);
 		doc.close();
		return content;
	}
	
	public static int getPageCount(PDDocument doc) {
		int pageCount = doc.getNumberOfPages();
		return pageCount;
		
	}
}