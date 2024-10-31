Nombre del proyecto: Formulario_OrangeHRM
Descripcion: Este Script realiza el diligencimiento del formulario de reclutamiento de la pagina:
https://opensource-demo.orangehrmlive.com/web/index.php/auth/login

Requisitos del sistema:
JDK: Version 11
Maven: Version 3.9.9
Google Chrome: Actualizado a la ultima version.

Instrucciones:
- ajustar los parametros (Datos de prueba) a gusto del usuario en el file "login.feature" en la siguiente dirección: (SE PUEDE OMITIR ESTE PASO)
    Producs_Store/src/test/resources/login.feature
    Aqui podras ajustar los siguientes campos:
  name
  middleName
  lastName
  vacant
  email
  number
  archive
  habilitates
  notes
  status

- Una vez ajustados los parametros a gusto (NO ES OBLIGATORIO) ejecutar la clase "RunnerReclutamientoPersonal" que se encuentra en la siguiente ruta del proyecto:
    Formulario_OrangeHRM/src/test/java/Runner/RunnerReclutamientoPersonal
    Esta clase ejecutara el Script

- Una vez ejecutado el Script visualizar el reporte generado:
    Ingresar a la carpeta (File Explore) donde se descargo el repositorio de GitHub
    En la parte superior en el campo buscador directorio ingresar la palabra "cmd" y oprimir la tecla "Enter".
    se abre el cmd y escribir "mvn clean verify " y oprimir la tecla "Enter"
    Se debe regresar al "File Explore" e ingresar a la carpeta donde se descargo el proyecto de GitHub y buscar el archivo index en la siguiente ubicacion
    Formulario_OrangeHRM\target\site\serenity\index

    Se podrá ver correctamente el reporte de la prueba
