package br.com.rsinet.hub_tdd.Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {

	public static WebElement element = null;
	
	
	public static WebElement usuario(WebDriver driver) {
		element = driver.findElement(By.name("usernameRegisterPage"));
		 

		return element;
	}

	public static WebElement email(WebDriver driver) {
		element = driver.findElement(By.name("emailRegisterPage"));

		return element;
	}

	public static WebElement senha(WebDriver driver) {
		element = driver.findElement(By.name("passwordRegisterPage"));

		return element;
	}

	public static WebElement confirmasenha(WebDriver driver) {
		element = driver.findElement(By.name("confirm_passwordRegisterPage"));

		return element;
	}

	public static WebElement primeironome(WebDriver driver) {
		element = driver.findElement(By.name("first_nameRegisterPage"));

		return element;
	}

	public static WebElement ultimonome(WebDriver driver) {
		element = driver.findElement(By.name("last_nameRegisterPage"));

		return element;
	}

	public static WebElement telefone(WebDriver driver) {
		element = driver.findElement(By.name("phone_numberRegisterPage"));

		return element;
	}

	public static WebElement pais(WebDriver driver) {
		Select oSelect = new Select(driver.findElement(By.name("countryListboxRegisterPage")));
		oSelect.selectByVisibleText("Brazil");
		return element;
	}

	public static WebElement cidade(WebDriver driver) {
		element = driver.findElement(By.name("cityRegisterPage"));

		return element;
	}

	public static WebElement endereco(WebDriver driver) {
		element = driver.findElement(By.name("addressRegisterPage"));

		return element;
	}

	public static WebElement estado(WebDriver driver) {
		element = driver.findElement(By.name("state_/_province_/_regionRegisterPage"));

		return element;
	}

	public static WebElement codigopostal(WebDriver driver) {
		element = driver.findElement(By.name("postal_codeRegisterPage"));

		return element;
	}

	public static WebElement aceite(WebDriver driver) {
		element = driver.findElement(By.cssSelector("div#formCover > sec-view > div > input"));

		return element;
	}

	public static WebElement cadastra(WebDriver driver) {
		element = driver.findElement(By.id("register_btnundefined"));

		return element;
	}

//	public static String capturarTexto(WebDriver driver) throws Exception {
//        //Thread.sleep(500);
//        WebElement textoCapture = driver.findElement(By.xpath("//*[@id=\\\"menuUserLink\\\"]/span"));
//        String textoUsuarioLogado = textoCapture.getText();
//        return textoUsuarioLogado;
//	}
}
