import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


/**********************
 * 
 * Este es un ejemplo de Selenium usa google accounts (la web de logueo de google)
 * 
 * Con este pequeño script rellenaremos de forma automatica los campo de email y password
 * del formulario de logueo.
 * 
 * Este Script es un script modificado de un tutorial gratuito de Selenium que se puede encontrar en:
 * http://www.softwaretestinghelp.com/selenium-tutorial-1/
 * 
 * Usaremos Chrome como navegador para este script. 
 * Tambien deberemos tener descargado el ejecutable chromedriver.exe (se puede encontrar aqui: https://sites.google.com/a/chromium.org/chromedriver/downloads).
 * 
 *********************/
public class prueba { 
  public static void main(String[] args) { 
	  
	  // Esta primera linea sirve para que la clase ChromeDriver pueda encontrar el servidor chromedriver.exe, importante poner doble barra
	  // porque la barra sirve para escapar un caracter, asi que tenemos que escapar la propia barra para que la interprete como caracter y que funcione.
	  System.setProperty("webdriver.chrome.driver", "C:\\ruta\\DondeSeEncuentra\\ChromeDrive\\chromedrive.exe");
	  
	 // Inicializamos el objeto ChromeDriver como driver
	  WebDriver driver = new ChromeDriver();

	  // Guardamos en el string appUrl la direccion URL de accounts.google.com
	  String appUrl = "https://accounts.google.com";

	  // Lanzamos el navegador con la web guardada en appUrl
	  driver.get(appUrl);
	  
	  // Maximizamos la ventana del navegador
	  driver.manage().window().maximize();
	  
	  // Declaramos el titulo esperado de la pagina de Google Accounts esto es simplemente como ejemplo para ver la funcionalidad.
	  String expectedTitle = "Sign in - Google Accounts";
	  
	  // Guardamos el titulo de la web que nos da el navegador
	  String actualTitle = driver.getTitle();
	  
	  // Comparamos el titulo esperado con el titulo actual
	  if (expectedTitle.equals(actualTitle)) {
		  // Si el titulo es el mismo, imprimimos en consola un que ha sido un exito.
		  System.out.println("Verification Successful - The correct title is displayed on the web page.");
	  } else {
		// Si el titulo es distinto, imprimimos en consola un que ha fallado.
		  System.out.println("Verification Failed - An incorrect title is displayed on the web page.");
	  }
	  
	  // Guardamos en la variable username el elemento Web con la id "email" que en el HTML corresponde al input 
	  // del formulario donde introducimos nuestro email
	  WebElement username = driver.findElement(By.id("Email"));
	  
	  // Lo ponemos en blanco (para borrar por si hay algun placeholder por ejemplo)
	  username.clear();
	  
	  // Escribimos en el imput nuestro email
	  username.sendKeys("ejemplo@gmail.com");
	  
	  // Guardamos en la variable next el elemento Web con la id "next" que en el HTML corresponde al boton "siguiente"
	  // que sale al introducir el email
	  WebElement next = driver.findElement(By.id("next"));
	  
	  // Hacemos click en el boton
	  next.click();
	  
	  // Guardamos en la variable password el elemento Web con la id "Passwd" que en el HTML corresponde al input 
	  // del formulario donde introducimos nuestra contraseña
	  WebElement password = driver.findElement(By.id("Passwd"));
	  
	  // Lo ponemos en blanco (para borrar por si hay algun placeholder por ejemplo)
	  password.clear();
	  
	  // Escribimos nuestra contraseña
	  password.sendKeys("contraseñaejemplo");
	  
	  // Guardamos en la variable SignInButton el elemento Web con la id "signIn" que en el HTML corresponde al boton de logueo
	  WebElement SignInButton = driver.findElement(By.id("signIn"));
	  
	  // Hacemos click en el boton.
	  SignInButton.click();
	  
	  // Imprimimos por consola que el script ha sido terminado con exito
	  System.out.println("Test script executed successfully.");

	  // Dejamos el programa pausado 5 segundos.
	  try {
		  TimeUnit.SECONDS.sleep(5);
		  
	  } catch (InterruptedException e) {
		  // Como es una interrupcion manual, no hacemos nada
	  }
	  
	  // Despues de los 5 segundos cerramos el navegador
	  driver.close();
	  
	  // Terminamos el programa
	  System.exit(0);	  
  }
}

