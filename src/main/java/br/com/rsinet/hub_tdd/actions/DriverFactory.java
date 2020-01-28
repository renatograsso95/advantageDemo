package br.com.rsinet.hub_tdd.actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.rsinet.hub_tdd.Utility.ExcelUtils;
import br.com.rsinet.hub_tdd.Utility.Paths;

public class DriverFactory {

	static WebDriver driver;

	public static WebDriver inicializarChromeCadastro() throws Exception {
		WebDriver driver = new ChromeDriver();
		ExcelUtils.setExcelFile(Paths.Path_cadastro + Paths.File_cadastro, "planilha1");
		driver.get("https://www.advantageonlineshopping.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", HomePage.novaconta(driver));

		{
			return driver;

		}

	}

	public static WebDriver inicializarChromeProdutos() throws Exception {
		WebDriver driver = new ChromeDriver();
		ExcelUtils.setExcelFile(Paths.Path_cadastro + Paths.File_cadastro, "planilha2");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.advantageonlineshopping.com/");
		driver.manage().window().maximize();

		{
			return driver;

		}

	}
}