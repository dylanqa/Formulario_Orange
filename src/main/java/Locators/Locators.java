package Locators;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class Locators extends PageObject {
    /*****Login***/
    public static final By txUsername = By.name("username");
    public static final By txPassword = By.name("password");
    public static final By btnIngresar = By.xpath("//button[@type='submit']");
    public static final By msgAlert = By.xpath("//p[text()='Invalid credentials']");
    /***HOME**/
    public static final By btnModulo = By.xpath("//ul/li/a/span[text()='Recruitment']");
    public static final By btnAñadir = By.xpath("(//*[@id='app']//button)[7]");
    public static final By txName = By.name("firstName");
    public static final By txSegundoNombre = By.name("middleName");
    public static final By txApellido = By.name("lastName");
    public static final By txCorreo = By.xpath("(//*[@id='app']//form//div[3]//input)[2]");
    public static final By txNumero = By.xpath("(//*[@id='app']//form//div[3]//input)[3]");
    public static final By btnCargueArchivo = By.xpath("//*[@id='app']//form//div[4]//div[contains(@class, 'oxd-file-button')]");
    public static final By txHabilidades = By.xpath("(//*[@id='app']//form//div[5]//input)[1]");
    public static final By txNotas = By.xpath("//form//div[6]//textarea");
    public static final By selVacannte = By.cssSelector(".oxd-select-text");
    public static final By btnSave = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");
    public static final By validacion = By.xpath("//p[@class='oxd-text oxd-text--p']");
    public static final By titulo = By.xpath("//div[@id='app']//div[contains(@class, 'orangehrm-horizontal-padding orangehrm-vertical-padding')]//span");
}
