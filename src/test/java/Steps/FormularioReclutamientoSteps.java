package Steps;

import Page.HomePage;
import Page.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import static com.ibm.icu.impl.SimpleFormatterImpl.IterInternal.step;

public class FormularioReclutamientoSteps extends hooks {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Given("El usuario debe ingresar a la pagina Orange HRM")
    public void el_usuario_debe_ingresar_a_la_pagina_orange_hrm() {
        String titulo =loginPage.VerificacionPagina();
        if(!titulo.equalsIgnoreCase("ORANGEHRM")){
            Assert.fail("El titulo no coincide");
        }

    }
    @When("El usuario realizara el Login con los datos correspondientes {string} {string}")
    public void el_usuario_realizara_el_login_con_los_datos_correspondientes(String username, String password) throws Exception {
    loginPage.Login (username, password);
    }

    @Then ("Cuando el usuario este en el Home debe darle click al modulo de Recruitment y al boton Add")
    public void Cuando_el_usuario_este_en_el_Home_debe_darle_click_al_modulo_de_Recruitment_y_al_boton_Add() throws Exception {
        this.homePage.ingresoFormulario();
    }

    @When("El usuario le da click al boton de Add llenara el Formulario de Datos del reclutado")
    public void el_usuario_le_da_click_al_boton_de_add() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("El usuario le da click al boton de Add debera llenar el formulario con la siguiente informacion")
    public void elUsuarioLeDaClickAlBotonDeAddDeberaLlenarElFormularioConLaSiguienteInformacion(DataTable dataTable) throws Exception {
        homePage.formulario(dataTable);
    }

    @And("despues el usuario va al modulo nuevamente y verifica que si este el registro y verifica que los datos sean correctos")
    public void despuesElUsuarioVaAlModuloNuevamenteYVerificaQueSiEsteElRegistroYVerificaQueLosDatosSeanCorrectos(DataTable dataTable) throws Exception {
        homePage.validacionRegistro(dataTable);
    }
}
