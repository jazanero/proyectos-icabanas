package org.icabanas.springsecurity;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Contiene tests de aceptaci�n del requisito 5 para la aplicaci�n.
 * 
 * Concretamente tiene test que verifican el comportamiento del siguiente requisito:
 * 
 * Si un usuario no se autentica correctamente deber�a mostr�rsele la p�gina de login junto 
 * con el motivo del error en la autenticaci�n. Adem�s, el login del usuario deber�a permanecer en el formulario.
 *
 * @author icabanas.ext
 *
 */
public class CasoUso5Test extends BaseTest{
        
        
	@Test
	public void deberiaPermanecerEnLaPaginaLoginConUnMensajeInformativoSiElUsuarioSeAutenticaConUnaPasswordIncorrecta(){
		
		// autenticamos al usuario con una passwordIncorrecta
		autenticarUsuarioConPasswordIncorrecta();
				
		// verifico que estamos en la p�gina de login
		assertThat(driver.getTitle(), is("Login: Spring Security Web Application"));
		
		// verifico que se le presenta al usuario un mensaje informativo
		final WebElement mensajeInformativo = driver.findElement(By.id("infomessage"));
		assertThat(mensajeInformativo.getText(), containsString("Login fallido debido a: Bad credentials."));
	}
	
	@Test
	public void deberiaPermanecerEnLaPaginaLoginConUnMensajeInformativoSiElUsuarioSeAutenticaConUnUsernameIncorrecto(){
		
		// autenticamos al usuario con un username incorrecto
		autenticarUsuarioConUsuarioIncorrecto();
				
		// verifico que estamos en la p�gina de login
		assertThat(driver.getTitle(), is("Login: Spring Security Web Application"));
		
		// verifico que se le presenta al usuario un mensaje informativo
		final WebElement mensajeInformativo = driver.findElement(By.id("infomessage"));
		assertThat(mensajeInformativo.getText(), containsString("Login fallido debido a: Bad credentials."));
	}
	
	@Test
	public void deberiaPermanecerEnLaPaginaLoginConUnMensajeInformativoSiAutenticacionFallaPeroUsernameDebePermanecerEnFormulario(){
		
		// autenticamos al usuario con una passwordIncorrecta
		autenticarUsuarioConPasswordIncorrecta();
				
		// verifico que estamos en la p�gina de login
		assertThat(driver.getTitle(), is("Login: Spring Security Web Application"));
		
		// verifico que se le presenta al usuario un mensaje informativo
		final WebElement username = driver.findElement(By.name("j_username"));
		assertThat(username.getValue(), is("username"));
	}
}

