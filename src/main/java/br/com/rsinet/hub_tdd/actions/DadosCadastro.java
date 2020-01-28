package br.com.rsinet.hub_tdd.actions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_tdd.Utility.RegisterPage;
import br.com.rsinet.hub_tdd.Utility.ExcelUtils;

public class DadosCadastro {

	public static void dados_positivos(WebDriver driver) throws Exception {
	
		String usuario = ExcelUtils.getCellData(1, 0);
		String email = ExcelUtils.getCellData(1, 1);
		String senha = ExcelUtils.getCellData(1, 2);
		String confirmasenha = ExcelUtils.getCellData(1, 3);
		String primeironome = ExcelUtils.getCellData(1, 4);
		String ultimonome = ExcelUtils.getCellData(1, 5);
		String telefone = ExcelUtils.getCellData(1, 6);
		String cidade = ExcelUtils.getCellData(1, 8);
		String endereco = ExcelUtils.getCellData(1, 9);
		String estado = ExcelUtils.getCellData(1, 10);
		String codigopostal = ExcelUtils.getCellData(1, 11);
		
		RegisterPage.usuario(driver).sendKeys(usuario);
		RegisterPage.email(driver).sendKeys(email);
		RegisterPage.senha(driver).sendKeys(senha);
		RegisterPage.confirmasenha(driver).sendKeys(confirmasenha);
		RegisterPage.primeironome(driver).sendKeys(primeironome);
		RegisterPage.ultimonome(driver).sendKeys(ultimonome);
		RegisterPage.telefone(driver).sendKeys(telefone);
		RegisterPage.cidade(driver).sendKeys(cidade);
		RegisterPage.pais(driver);
		RegisterPage.endereco(driver).sendKeys(endereco);
		RegisterPage.estado(driver).sendKeys(estado);
		RegisterPage.codigopostal(driver).sendKeys(codigopostal);
		RegisterPage.aceite(driver).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("div#formCover > sec-view > div > input")).isSelected());
		RegisterPage.cadastra(driver).click();	
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"menuUserLink\"]/span[1]")));
			}
	
	public static void dados_negativos(WebDriver driver) throws Exception {
		
		String usuario = ExcelUtils.getCellData(1, 0);
		String email = ExcelUtils.getCellData(1, 1);
		String senhaerrada = ExcelUtils.getCellData(2, 2);
		String senhaErrada = ExcelUtils.getCellData(2, 3);
		String primeironome = ExcelUtils.getCellData(1, 4);
		String ultimonome = ExcelUtils.getCellData(1, 5);
		String telefone = ExcelUtils.getCellData(1, 6);
		String cidade = ExcelUtils.getCellData(1, 8);
		String endereco = ExcelUtils.getCellData(1, 9);
		String estado = ExcelUtils.getCellData(1, 10);
		String codigopostal = ExcelUtils.getCellData(1, 11);
		
		RegisterPage.usuario(driver).sendKeys(usuario);
		RegisterPage.email(driver).sendKeys(email);
		RegisterPage.senha(driver).sendKeys(senhaerrada);
		RegisterPage.confirmasenha(driver).sendKeys(senhaErrada);
		RegisterPage.primeironome(driver).sendKeys(primeironome);
		RegisterPage.ultimonome(driver).sendKeys(ultimonome);
		RegisterPage.telefone(driver).sendKeys(telefone);
		RegisterPage.cidade(driver).sendKeys(cidade);
		RegisterPage.pais(driver);
		RegisterPage.endereco(driver).sendKeys(endereco);
		RegisterPage.estado(driver).sendKeys(estado);
		RegisterPage.codigopostal(driver).sendKeys(codigopostal);
		RegisterPage.aceite(driver).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("div#formCover > sec-view > div > input")).isSelected());
		RegisterPage.cadastra(driver).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"registerPage\"]/article/sec-form/div[2]/label[2]/a")));
	}
}
