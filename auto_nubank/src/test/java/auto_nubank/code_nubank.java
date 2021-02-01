package auto_nubank;

import org.openqa.selenium.Keys;
import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class code_nubank {
	
	private WebDriver driver;


	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\QATools\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@After
	public void tearDown(){
		driver.quit(); //fecha o browser
	}

	@Test
	public void test() throws InterruptedException {
		
		//acessa a p�gina da uber
		driver.get("https://nubank.com.br/");
		//pass("Passou");
		//fail("Not yet implemented");
		//insere CPF
		WebElement cpf = driver.findElement(By.cssSelector("#field-cpf"));
		cpf.sendKeys("03760933238");
		Thread.sleep(1000);
		
		//pressiona em continuar
		WebElement continuar = driver.findElement(By.cssSelector("#short-form > button > span"));
		continuar.click();
		Thread.sleep(1000);
		
		//insere nome
		WebElement nome = driver.findElement(By.cssSelector("#label-name"));
		nome.sendKeys("Assiria Souza Menezes");
		
		//insere um e-mail
		WebElement email = driver.findElement(By.cssSelector("#field-email"));
		email.sendKeys("assiriasmenezes@gmail.com");
		
		//confirma e-mail
		WebElement confirmaemail = driver.findElement(By.cssSelector("#field-emailConfirmation"));
		confirmaemail.sendKeys("assiriasmenezes@gmail.com");
		Thread.sleep(1000);

		//confirma termos
		WebElement termos = driver.findElement(By.xpath("//*[@id=\"label-accepted\"]"));
		termos.click();
		
		//envia dados
		WebElement enviar = driver.findElement(By.xpath("//*[@id=\"complete-form-drawer\"]/div/div/div[2]/form/div/div[2]/div/button/span"));
		enviar.click();
		Thread.sleep(2000);
		
		//Valida a mensagem final
		String actualString = driver.findElement(By.cssSelector("#complete-form-drawer > div > div > div.FormWrapper-sc-1r3xsxy-0.dKHNgp > div > p")).getText();
		assertTrue(actualString.contains("Seu pedido será analisado e, se estiver tudo certo, uma resposta vai ser enviada para o seu e-mail cadastrado assiriasmenezes@gmail.com"));
		Thread.sleep(2000);
	}

}
