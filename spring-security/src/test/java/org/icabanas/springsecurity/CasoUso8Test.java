package org.icabanas.springsecurity;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Contiene tests de aceptaci�n del requisito 8 para la aplicaci�n.
 *
 * Concretamente tiene test que verifican el comportamiento del siguiente requisito:
 *
 * Un usuario puede realizar logout de la parte segura
 * de la aplicaci�n y el sistema deber�a redirigirle a la p�gina de
 * login y mostrarle un mensaje informativo de que realiz� logout
 * correctamente.
 *
 * @author icabanas.ext
 *
 */
public class CasoUso8Test extends BaseTest{    

    @Test
    public void deberiaSerCapazDeRealizarLogoutDeLaAplicacionYVerMensajeQueConfirmeEsto(){        
        // el usuario accede a la home
        driver.get("http://localhost:9080/spring-security/home.htm");

        // como el usuario no est� autenticado, el sistema le redirige a la p�gina de login
        assertThat(driver.getTitle(), is("Login: Spring Security Web Application"));

        // el usuario se autentica correctamente
        autenticarUsuarioValido();

        // despu�s de autenticarse el usuario, el sistema le redirige a la p�gina que solicit�
        assertThat(driver.getTitle(), is("Home: Spring Security Web Application"));

        // el usuario pincha el enlace de logout
        final WebElement linkLogout = driver.findElement(By.linkText("Logout"));
        linkLogout.click();

        // verifico que el usuario es redirigido a la p�gina de login
        assertThat(driver.getTitle(), is("Login: Spring Security Web Application"));

        // verifico que se le presenta al usuario el mensaje informativo
        final WebElement mensajeInformativo = driver.findElement(By.id("infomessage"));
        assertThat(mensajeInformativo.getText(), containsString("Se ha desconectado del sistema correctamente."));
    }    

}