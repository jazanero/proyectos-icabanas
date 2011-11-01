package org.icabanas.springsecurity;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Contiene tests de aceptaci�n del requisito 6 para la aplicaci�n.
 *
 * Concretamente tiene test que verifican el comportamiento del siguiente requisito:
 *
 * Cuando un usuario intenta acceder a un recurso seguro y no est� aunteticado,
 * cuando �ste se valide correctamente ser� redirigido autom�ticamente al recurso que solicit�.
 *
 * @author icabanas.ext
 *
 */
public class CasoUso6Test extends BaseTest{    

    @Test
    public void deberiaRedirigirALaPaginaQueUsuarioIntentoAccederDespuesDeAutenticarse(){        
        // el usuario intenta acceder a un recurso seguro
        driver.get("http://localhost:9080/spring-security/admin.htm");

        // como el usuario no est� autenticado, el sistema le redirige a la p�gina de login
        assertThat(driver.getTitle(), is("Login: Spring Security Web Application"));

        // el usuario se autentica correctamente
        autenticarUsuarioValido();

        // verifico que no estamos en la p�gina home
        assertThat(driver.getTitle(), is(not("Home: Spring Security Web Application")));

        // verifico que estamos en la p�gina que usuario quiso acceder
        assertThat(driver.getTitle(), is("Admin: Spring Security Web Application"));        
    }

}
