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

import br.com.rsinet.hub_tdd.actions.DriverFactory;
import br.com.rsinet.hub_tdd.actions.HomePage;
import br.com.rsinet.hub_tdd.actions.Screenshot;

public class testConsulta {

	static WebDriver driver;
	ExtentReports extent;
    ExtentTest logger;
    private String testing;

	@BeforeMethod
	public void consulta() throws Exception {
		driver = DriverFactory.inicializarChromeProdutos();
	}

	@Test
	public void Teste_Busca() throws Exception {

		HomePage.mouse(driver);

		HomePage.mouse_azul(driver);
		ExtentHtmlReporter report = new ExtentHtmlReporter("./Report/buscaPagina.html");
        extent = new ExtentReports();
        extent.attachReporter(report);
        logger = extent.createTest("Busca Realizado!");
           testing = new Throwable().getStackTrace()[0].getMethodName();

	}
	@Test
	public void Teste_Busca_Negativo() throws Exception {
		
		HomePage.outros_produtos(driver);
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
