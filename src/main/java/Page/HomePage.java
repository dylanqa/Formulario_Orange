package Page;

import Locators.Locators;;
import base.Base;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Locale;
import java.util.Map;

public class HomePage extends Base {

    public void ingresoFormulario() throws Exception {
        this.click(Locators.btnModulo);
        this.wait(2);
        this.click(Locators.btnAñadir);
        this.wait(2);
    }

    public void formulario(DataTable dataTable) throws Exception {
        Map<String, String>
                datos = dataTable.asMap(String.class, String.class);
        this.type(Locators.txName, datos.get("name"));
        this.type(Locators.txSegundoNombre, datos.get("middleName"));
        this.type(Locators.txApellido, datos.get("lastName"));
        this.wait(2);
        this.selectOptionFromDropdown(Locators.selVacannte,datos.get("vacant"));
        this.type(Locators.txCorreo, datos.get("email"));
        this.type(Locators.txNumero, datos.get("number"));
        if (datos.get("archive").contains("Si")) {
            /**En el feature en el dato archive ponga el dato en Si para que cargue su
             * Archivo si no dejelo en NO**/
            /***Cambie la ruta del archivo si quiere utlizar el cargue**/
            String ruta = "C:\\Users\\Treinta\\IdeaProjects\\PRODUCTS_STORE\\Products_Store\\src\\test\\resources\\HU01 - Proceso de Contratación en OrangeHRM.pdf";
            this.click(Locators.btnCargueArchivo);
            this.wait(1);
            this.uploadFile(ruta);
            System.out.println("Proceso Archivo");
        }
        this.type(Locators.txHabilidades, datos.get("habilitates"));
        this.type(Locators.txNotas, datos.get("notes"));
        this.wait(2);
        this.click(Locators.btnSave);
        this.wait(2);
        int cont=0;
        do {
            this.wait(2);
            cont++;
        }while (!this.isElementPresent(Locators.validacion) || cont>=2);
        if (!this.isElementPresent(Locators.validacion)) {
            throw new IllegalStateException( "No se envio el formulario correctamente. Terminando el step.");
        }
        System.out.println("Se envio el formulario correctamente");

    }

    public void validacionRegistro(DataTable dataTable) throws Exception{
        Map<String, String>
                datos = dataTable.asMap(String.class, String.class);
        this.click(Locators.btnModulo);
        this.wait(5);
        String nombre =datos.get("name")+" "+datos.get("middleName")+" "+datos.get("lastName");
       int filas= this.getNumfilas(By.xpath("//*[@role='table']//div[@role='row']"));
        boolean resultado=false;
       for (int fila=2;fila<filas;fila++) {
           /**EN EL FEATURE EN EL PASO DE AND PUEDE MODIFICAR EL ESTADO CON EL QUE DESEA COMPARAR EL REGISTRO*/
            resultado = verificarValoresEnFila(fila, datos.get("vacant"), nombre, datos.get("status"));
            if (resultado) {
                System.out.println("Los valores coinciden en la fila especificada.");
                break;
            }
        }
       if (!resultado){
           throw new IllegalStateException("Los valores no coinciden revise si el estado es el indicado.");
       }
       this.wait(3);

    }



    public boolean verificarValoresEnFila( int numeroFila, String valor1, String valor2, String valor3) {
        // Localizamos las tres celdas específicas en la fila indicada
        WebElement celda1 = getDriver().findElement(By.xpath("(//*[@role='table']//div[@role='row'])[" + numeroFila + "]//div[@role='cell'][2]"));
        WebElement celda2 = getDriver().findElement(By.xpath("(//*[@role='table']//div[@role='row'])[" + numeroFila + "]//div[@role='cell'][3]"));
        WebElement celda3 = getDriver().findElement(By.xpath("(//*[@role='table']//div[@role='row'])[" + numeroFila + "]//div[@role='cell'][6]"));
        WebElement check1 = getDriver().findElement(By.xpath("(//*[@role='table']//div[@role='row'])[" + numeroFila + "]//div[@role='cell'][1]"));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,100);");
        // Obtenemos el texto de cada celda
        String valorCelda1 = celda1.getText();
        String valorCelda2 = celda2.getText();
        String valorCelda3 = celda3.getText();

        // Comparamos los valores de las celdas con los valores esperados
        if (valor1.contains(valorCelda1)&&valor2.contains(valorCelda2)&&valor3.contains(valorCelda3)){
            this.click(check1);
            return true;
        }
        return valorCelda1.contains(valor1) && valorCelda2.contains(valor2) && valorCelda3.contains(valor3);
    }


}

