# RestAssured API Testing Framework

Framework de automatización de pruebas para **APIs REST** utilizando **Java + RestAssured**, con una arquitectura modular y escalable.

---

## Arquitectura del Framework

El proyecto sigue una arquitectura en capas que permite separar responsabilidades y facilitar el mantenimiento del código.

```
restassured-api-testing
├── src
│ └── test/java/api
|     ├── client
|     ├── models
│     ├── tests
│     ├── utils
├── resources
├── gitignore
├── pom.xml 
└── README.md
```

### Descripción de capas

- **client**  
  Contiene la lógica para interactuar con los endpoints (GET, POST, PUT, DELETE), desacoplando las llamadas HTTP de los tests.

- **models**  
  Incluye los **POJOs** utilizados para construir bodies dinámicos y mapear responses JSON.

- **tests**  
  Casos de prueba que validan el comportamiento de las APIs, usando los clientes y modelos definidos.

- **utils**  
  Clases reutilizables como:
  - `BaseTest`
  - `Config`
  - `ExtentManager` (Configuración de reportes)

Esta arquitectura permite:
- Escalabilidad
- Código limpio y reutilizable
- Fácil mantenimiento del framework
---

## Librerías Utilizadas

| Librería | Descripción |
|--------|------------|
| **RestAssured** | Librería principal para pruebas de APIs REST |
| **JUnit 5** | Framework de ejecución de pruebas |
| **Hamcrest** | Validaciones y matchers para assertions |
| **Maven** | Gestión de dependencias y ciclo de vida del proyecto |
| **ExtentReports** | Generación de reportes HTML de ejecución |

### ¿Por qué estas librerías?

- **RestAssured** permite construir requests y validar responses de forma sencilla.
- **Hamcrest** facilita validaciones legibles y expresivas sobre los responses (status, headers, body).
- **JUnit** permite organizar y ejecutar los casos de prueba.
- **ExtentReports** genera evidencias visuales de las ejecuciones.
- **Maven** simplifica la gestión de dependencias y ejecución del proyecto.

---

## Ejecución de Módulos

```
Ejecutar todas las pruebas:
`mvn clean test`

Ejecutar una clase específica:
`mvn test -Dtest=NombreDeLaClaseTest`

Los reportes y resultados se generan en:

target/
├── surefire-reports
└── extentReport.html
```

Evidencias
<img width="1921" height="958" alt="image" src="https://github.com/user-attachments/assets/48ff9d0a-5a25-49f1-8181-34dde6bc23be" />
<img width="1920" height="957" alt="image" src="https://github.com/user-attachments/assets/d4c047de-66ec-4cea-a609-2225b51467f3" />



