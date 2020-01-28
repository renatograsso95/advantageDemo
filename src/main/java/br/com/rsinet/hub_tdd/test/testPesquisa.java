package br.com.rsinet.hub_tdd.test;


import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import br.com.rsinet.hub_tdd.actions.BuscaProduto;
import br.com.rsinet.hub_tdd.actions.DriverFactory;
import br.com.rsinet.hub_tdd.actions.Screenshot;

public class testPesquisa {

	static WebDriver driver;
	ExtentReports extent;
    ExtentTest logger;
    private String testing;

	@BeforeMethod
	public void busca() throws Exception {
		driver = DriverFactory.inicializarChromeProdutos();

	}

	@Test
	public void Teste_Pesquisa() throws Exception {
		BuscaProduto.buscaPositiva(driver);
		ExtentHtmlReporter report = new ExtentHtmlReporter("./Report/buscaProduto.html");
        extent = new ExtentReports();
        extent.attachReporter(report);
        logger = extent.createTest("Busca Realizada!");
           testing = new Throwable().getStackTrace()[0].getMethodName();

	}

	@Test
	public void Teste_Pesquisa_Negativo() throws Exception {
		BuscaProduto.buscaNegativa(driver);
		testing = new Throwable().getStackTrace()[0].getMethodName();
	}

	@AfterMethod
	public void finalizaTeste(ITestResult resultado) throws Exception {
		 if (resultado.getStatus() == ITestResult.FAILURE) {
	            String tempo = Screenshot.getScreenshot(driver, testing );
	            logger.fail(resultado.getThrowable().getMessage(),
	                    MediaEntityBuilder.createScreenCaptureFromPath(tempo).build());
	        } else if (resultado.getStatus() == ITestResult.SUCCESS) {
	            String tempo = Screenshot.getScreenshot(driver, testing);
	            logger.pass(testing, MediaEntityBuilder.createScreenCaptureFromPath(tempo).build());
	        }
	        extent.flush();

		driver.quit();
	}
}