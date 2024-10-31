Feature: Realizar proceso de contratación de una persona
  Scenario: Verificacion de la creacion de la persona a reclutar
    Given El usuario debe ingresar a la pagina Orange HRM
    When El usuario realizara el Login con los datos correspondientes "Admin" "admin123"
    Then Cuando el usuario este en el Home debe darle click al modulo de Recruitment y al boton Add
    When El usuario le da click al boton de Add debera llenar el formulario con la siguiente informacion
      | name            | Martinssz              |
      | middleName      | Camilossz              |
      | lastName        | Suarezssz              |
      | vacant          | test                  |
      | email           | Ultimate@gmail.com    |
      | number          | 3165986363            |
      | archive         | No                    |
      | habilitates     | sql,java,python       |
      | notes           | Holaaaaaaaaass        |
    And despues el usuario va al modulo nuevamente y verifica que si este el registro y verifica que los datos sean correctos
      | name            | Martinssz              |
      | middleName      | Camilossz              |
      | lastName        | Suarezssz              |
      | vacant          | test                  |
      | status          | Application Initiated |
