package QSP;


import org.openqa.selenium.firefox.FirefoxDriver;

public class demo1 {

	public static void main(String[] args) throws InterruptedException
	{
	String key = "webdriver.gecko.driver";
	String Value = "./Drivers/geckodriver.exe";
	System.setProperty(key,Value);
	FirefoxDriver f = new FirefoxDriver();
	Thread.sleep(5000);
	f.close();
	

	}

}
