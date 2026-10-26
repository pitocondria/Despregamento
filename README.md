# Gestor de incidencias

Aplicación de consola para consultar incidencias de soporte de un centro educativo. Permite listar todas las incidencias o solo las abiertas, buscar por identificador o título y consultar el detalle de una incidencia.

## Requisitos

- Java 17 o posterior
- Maven (o el Maven Wrapper incluido en el proyecto)

## Funcionalidades

- Listar todas las incidencias.
- Listar únicamente las incidencias abiertas.
- Buscar por identificador o título, sin distinguir mayúsculas y minúsculas.
- Consultar una incidencia por su identificador.
- Usar el menú interactivo o ejecutar operaciones directamente desde la línea de comandos.

## Compilar y ejecutar

Desde el directorio del proyecto, compila y ejecuta el menú interactivo:

```powershell
.\mvnw.cmd clean compile exec:java
```

También puedes ejecutar una operación directamente:

```powershell
.\mvnw.cmd exec:java "-Dexec.args=ayuda"
.\mvnw.cmd exec:java "-Dexec.args=listar"
.\mvnw.cmd exec:java "-Dexec.args=abiertas"
.\mvnw.cmd exec:java "-Dexec.args=buscar impresora"
.\mvnw.cmd exec:java "-Dexec.args=detalle INC-001"
```

Para crear el JAR y generar el Javadoc en la misma compilación:

```powershell
.\mvnw.cmd clean package
```

El JAR ejecutable se crea en `target/gestor-incidencias-1.0.0.jar`.

## Javadoc

El Javadoc se genera automáticamente al ejecutar `package`. Para generarlo sin empaquetar el proyecto:

```powershell
.\mvnw.cmd javadoc:javadoc
```

Abre [la documentación Javadoc](docs/apidocs/index.html) en un navegador. Los archivos HTML generados se encuentran en `docs/apidocs/`. Para publicarlos mediante GitHub Pages, configura Pages para servir el directorio que contiene esos archivos; la URL pública estará disponible cuando se habilite la publicación en GitHub.

## Clases principales

| Clase | Responsabilidad |
| --- | --- |
| `App` | Punto de entrada; gestiona el menú y los argumentos de línea de comandos. |
| `GestorIncidencias` | Proporciona las operaciones de listado, búsqueda y consulta por identificador. |
| `Incidencia` | Representa una incidencia con identificador, título, prioridad y estado. |
| `IncidenciaNoEncontradaException` | Informa de que no existe una incidencia con el identificador solicitado. |

## Estructura del proyecto

```text
.
├── docs/
│   └── apidocs/          # Javadoc HTML generado
├── src/main/java/
│   └── es/centro/incidencias/
│       ├── App.java
│       ├── GestorIncidencias.java
│       ├── Incidencia.java
│       └── IncidenciaNoEncontradaException.java
├── pom.xml
└── README.md
```
