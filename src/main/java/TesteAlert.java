import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteAlert {
	@Test
	public void deveInteragirComAlertSimples() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		driver.findElement(By.id("alert")).click();
		Alert alert = driver.switchTo().alert();
		String texto = alert.getText(); // pegou o texto armazenou em uma variavel
		Assert.assertEquals("Alert Simples", texto);
		alert.accept(); // aceitar o alerta na tela clicando no OK

		driver.findElement(By.id("elementosForm:nome")).sendKeys(texto); // pegar o text do alert e inserir no campo
																			// nome
	}

	@Test
	public void deveInteragirComAlertConfirm() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		driver.findElement(By.id("confirm")).click();
		Alert alerta = driver.switchTo().alert();
		Assert.assertEquals("Confirm Simples", alerta.getText());
		alerta.accept(); // Fechar alerta da tela
		Assert.assertEquals("Confirmado", alerta.getText());
		alerta.accept(); // Fechar alerta da tela
		
		driver.findElement(By.id("confirm")).click();
		alerta = driver.switchTo().alert();
		Assert.assertEquals("Confirm Simples", alerta.getText());
		alerta.dismiss();
		Assert.assertEquals("Negado", alerta.getText());
		alerta.dismiss(); 
		
		driver.close();
	}
}
