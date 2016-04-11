import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;


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
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\j.fernandez.romero\\Downloads\\chromedriver_win32\\chromedriver.exe");

		// Inicializamos el objeto ChromeDriver como driver
		WebDriver driver = new ChromeDriver();
		
		// Guardamos en el string appUrl la direccion URL de accounts.google.com
		String appUrl = "file:///C:/Users/j.fernandez.romero/Downloads/html/index.html";
		
		// Lanzamos el navegador con la web guardada en appUrl
		driver.get(appUrl);
		
		// Maximizamos la ventana del navegador
		driver.manage().window().maximize();
	  
		// Declaramos el titulo esperado de la pagina de Google Accounts esto es simplemente como ejemplo para ver la funcionalidad.
		String expectedTitle = "Pruebas";

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
		
		/***************************************************************
		 *  PRUEBA 1
		 *  
		 *  En esta prueba buscaremos los campos del formulario email y 
		 *  contraseña para rellenarlos con los datos especificados en 
		 *  las variables "email" y "password". En la web podremos ver
		 *  si coincide lo introducido.
		 *  
		 ***************************************************************/
		
		// Variables con el email y la password
		String email = "prueba@mail.com";
		String password = "123456";
		
		// Buscamos el elemento web con ID email y lo guardamos en la variable user
		WebElement user = driver.findElement(By.id("email"));
		
		// Limpiamos el campo (por si tiene algun placeholder o algo)
		user.clear();
		
		// Escribimos en el campo el email
		user.sendKeys(email);
		
		// Buscamos el elemento web con ID password y lo guardamos en la variable pwd
		WebElement pwd = driver.findElement(By.id("password"));

		// Limpiamos el campo 
		pwd.clear();
		
		// Escribimos en el campo la contraseña
		pwd.sendKeys(password);
		
		// Buscamos el elemento web submit con id submit y lo guardamos en la variable submit
		WebElement submit = driver.findElement(By.id("submit"));
		
		// Hacemos click en submit
		submit.click();
		
		/*********************
		 *   FIN PRUEBA 1    *
		 ********************/
		
		/***************************************************************
		 *  PRUEBA 2
		 *  
		 *  Para esta prueba habra un cuadrado que, conforme mas tiempo
		 *  este pulsado, mas grande se hace. En esta prueba clickearemos
		 *  en el cuadrado y lo dejaremos pulsado hasta que alcance 
		 *  cierto tamaño deseado.  
		 *  
		 *  Para recoger el tamaño se puede hacer de dos maneras: 
		 *  - La primera usando getCssValue("width")
		 *  - La segunda importando la libreria Dimension y usando la clase
		 *    Dimension
		 *    
		 *    Lo hare de la segunda manera y pondre un ejemplo de la primera
		 *    
		 *    Tambien, como haremos un click and Hold deberemos importar la
		 *    libreria Actions que nos permitira crear combinaciones complejas
		 *    de acciones
		 *  
		 ***************************************************************/
		
		// Guardamos en la variable cuadrado el elemento web con ID Tamaño
		WebElement cuadrado = driver.findElement(By.id("tamaño"));
		
		// Creamos la variable dimensiones y guardamos en ella el tamaño de cuadrado
		Dimension dimensiones = cuadrado.getSize();
		
		// Creamos la accion 
		Actions accion = new Actions(driver);
		
		// Le damos a la accion el click and hold en cuadrado y la realizamos
		accion.clickAndHold(cuadrado).perform();
		
		// Mientras el ancho del cuadrado sea menos a 300px el programa quedara atrapado en este bucle
		while(dimensiones.width < 300) {
			dimensiones = cuadrado.getSize();
		}
		
		// Imprimimos en consola el ancho del cuadrado recogido por dimensiones
		System.out.println(dimensiones.width);
		
		// Imprimimos en consola el ancho del cuadrado recogido por getCssValue
		System.out.println(cuadrado.getCssValue("width"));
		
		// Ralizamos la accion de soltar el click para que el cuadrado deje de crecer.
		accion.release().perform();
		
		/*********************
		 *   FIN PRUEBA 2    *
		 ********************/
		
		
		/***************************************************************
		 *  PRUEBA 3
		 *  
		 *  En esta prueba tendremos un boton que cambiara de color cada 
		 *  vez que clickeamos en el, el objetivo de esta prueba es ir 
		 *  clickeando en el boton hasta que se ponga en rojo y entonces
		 *  dejar de clickear en el.
		 *  
		 *  Se puede hacer de varias maneras: 
		 *  
		 *  - Recogiendo el nombre del atributo clase 
		 *  - Recogiendo el valor background-color de CSS
		 *  
		 *  La hare de la primera manera y pondre un ejemplo de la segunda
		 *  
		 ***************************************************************/
		
		// Guardamos en la variable cuadrado el elemento web con ID Tamaño
		WebElement boton = driver.findElement(By.id("cambiaColor"));

		// Guardamos en la variable String clase el nombre de la clase del elemento
		String clase = boton.getAttribute("class");

		// Mientras la clase no sea rojo, quedaremos en este bucle
		while (!clase.equals("rojo")) {

			// Hacemos click al boton
			boton.click();
			// Recogemos el atributo clase
			clase = boton.getAttribute("class");
			// Esperamos 500 milisegundos (nota: La funcion espera esta al final del codigo)
			espera(500);
 
		}
		
		// Imprimimos por consola el valor de la clase del elemento boton
		System.out.println(boton.getAttribute("class"));
		// Imprimimos por consola el valor CSS de background-color
		System.out.println(boton.getCssValue("background-color"));
		
		/*********************
		 *   FIN PRUEBA 3    *
		 ********************/
		
		/***************************************************************
		 *  PRUEBA 4
		 *  
		 *  En esta prueba tendremos un div que se despliega y que al 
		 *  desplegarse o plegarse cambia el contenido. 
		 *  
		 ***************************************************************/
		
		// Guardamos en la variable divDesplegable el elemento web con ID desplegable
		WebElement divDesplegable = driver.findElement(By.id("desplegable"));
		
		// Guardamos en la variable contenido el elemento web con ID contenido
		WebElement contenido = driver.findElement(By.id("contenido"));
		
		// Guardamos en la variable tipo String el contenido html
		String textoContenido = contenido.getAttribute("innerHTML");
		
		// Imprimimos en consola el contenido (para verificar)
		System.out.println(textoContenido);
		
		// Si el contenido html es "Estoy cerrado" 
		if (textoContenido.equals("¡Estoy Cerrado!")) {
			// Hacemos click en el div desplegable
			divDesplegable.click();
		}
		
		/***************************************************************
		 *  PRUEBA 5
		 *  
		 *  En esta prueba clickearemos en un enlace, que nos llevara a otra
		 *  pestaña, en esa pestaña realizaremos la prueba 1, luego cerraremos
		 *  la pestaña y volveremos a la primera
		 *  
		 *  Para implementar el manejo de pestañas podremos usar un array normal
		 *  o un ArrayList, he preferido el uso del arraylist porque a mi juicio
		 *  es mas facil de usar e inicializar.
		 *  
		 *  Recordar que ArrayList necesita que se importe la libreria java.util.ArrayList
		 *  y que tiene sus propios metodos para su manejo.
		 *  
		 ***************************************************************/
		
		// Esperamos 2 segundos (nota: La funcion espera esta al final del codigo)
		espera(2000);
		
		// Guardamos en la variable enlace el elemento web enlace
		WebElement enlace = driver.findElement(By.id("enlace"));
		
		// Hacemos click en el enlace
		enlace.click();
		
		// Creamos un ArrayList que contendra las pestañas
		ArrayList<String> pestañas = new ArrayList<String> (driver.getWindowHandles());
		
		// Cambiamos a la pestaña nueva que se ha abierto
		driver.switchTo().window(pestañas.get(1));
		
		// Volvemos a buscar los elementos para user, pwd y submit
		user = driver.findElement(By.id("email"));
		pwd = driver.findElement(By.id("password"));
		submit = driver.findElement(By.id("submit"));
		
		// Limpiamos el campo email 
		user.clear();
		// Escribimos en el campo el email
		user.sendKeys(email);

		// Limpiamos el campo 
		pwd.clear();
		// Escribimos en el campo la contraseña
		pwd.sendKeys(password);

		// Hacemos click en submit
		submit.click();
		
		// Esperamos 2 segundos
		espera(2000);
		
		// Cerramos la pestaña
		driver.close();
		
		// Volvemos a la primera pestaña
	    driver.switchTo().window(pestañas.get(0));
		
	    // Esperamos otros 2 segundos
	    espera(2000);
	    
	    // Cerramos el navegador
	    driver.close();
		
		
	}
	
	public static void espera (int miliseconds) {
		try {
			// Esperamos 3 segundos antes de volver a clickar
			Thread.sleep(miliseconds);
		} catch (InterruptedException e) {
		
		}
		
	}
	
}


  