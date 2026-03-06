# DigitalBank
## 💻 Configuracion Git
### Para configurar tu nombre y email en Git, ejecuta estos comandos en tu terminal:
Configuración global (aplica a todos tus repositorios):
```
git config --global user.name "Tu Nombre"
git config --global user.email "tu@email.com"
```
Configuración local (solo para el repositorio actual):
```
git config user.name "Tu Nombre"
git config user.email "tu@email.com"
```
Después de configurarlo, vuelve a intentar tu commit y debería funcionar sin problemas.
Para verificar que quedó guardado correctamente:
```
git config --list
```
---
---

## 🏛️Plan: Hacer Funcionar el Sistema Bancario Digital

### Tecnologías
- **Java 17** | **Spring Boot 3.5.7** | **PostgreSQL** | **Maven**

---

### Prerequisitos

Verificar que tengas instalado:

| Herramienta | Versión mínima | Comando de verificación |
|-------------|----------------|------------------------|
| Java JDK    | 17+            | `java -version`        |
| Maven       | 3.8+           | `mvn -version`         |
| PostgreSQL  | 12+            | `psql --version`       |
| Docker      | Cualquiera     | `docker --version`     |

---

### 📦 Paso 1 — Levantar la Base de Datos

El proyecto espera **PostgreSQL en el puerto 8181** (no estándar).

#### Opción A — Docker (recomendado)

```bash
docker run --name banco-db \
  -e POSTGRES_USER=postgres \
  -e POSTGRES_PASSWORD=balbuena022000 \
  -e POSTGRES_DB=banco_db \
  -p 8181:5432 \
  -d postgres:15
```

#### Opción B — PostgreSQL nativo

1. Instalar PostgreSQL desde https://www.postgresql.org/download/
2. Cambiar el puerto a `8181` en `postgresql.conf`
3. Crear la base de datos:

```sql
CREATE DATABASE banco_db;
```
> Se mantiene el puerto default: **5432**
---

### ⚙️ Paso 2 — Verificar Configuración

Archivo: `src/main/resources/application.properties`

```properties
spring.datasource.url=jdbc:postgresql://localhost:8181/banco_db
spring.datasource.username=postgres
spring.datasource.password=balbuena022000
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
```

> Hibernate crea las tablas automáticamente al primer arranque.
> No hay scripts SQL que ejecutar manualmente.

---

### 🚀 Paso 3 — Compilar y Ejecutar

```bash
# Desde la raíz del proyecto (donde está el pom.xml)
mvn clean compile

# Arrancar la aplicación
mvn spring-boot:run -DskipTests
```

La aplicación estará disponible en: **http://localhost:8080**

---

### 📝 Paso 4 — Verificar que Funciona

#### Crear un cliente (POST)

```bash
curl -X POST http://localhost:8080/api/clientes \
  -H "Content-Type: application/json" \
  -d '{"nombre": "Juan Pérez", "email": "juan@test.com"}'
```

#### Consultar un cliente (GET)

```bash
curl http://localhost:8080/api/clientes/{clienteId}
```

---
### 🔗 Endpoints Disponibles

#### Clientes — `/api/clientes`

| Método   | Ruta                  | Descripción          |
|----------|-----------------------|----------------------|
| `POST`   | `/api/clientes`       | Crear cliente        |
| `GET`    | `/api/clientes/{id}`  | Obtener cliente      |
| `PUT`    | `/api/clientes/{id}`  | Actualizar cliente   |
| `DELETE` | `/api/clientes/{id}`  | Desactivar cliente   |

#### Cuentas — `/api/cuentas`

| Método   | Ruta                       | Descripción      |
|----------|----------------------------|------------------|
| `POST`   | `/api/cuentas`             | Abrir cuenta     |
| `GET`    | `/api/cuentas/{id}/saldo`  | Consultar saldo  |
| `DELETE` | `/api/cuentas/{id}`        | Cerrar cuenta    |

#### Transacciones — `/api/transacciones`

| Método | Ruta                                | Descripción     |
|--------|-------------------------------------|-----------------|
| `POST` | `/api/transacciones/transferencia`  | Transferencia   |
| `POST` | `/api/transacciones/deposito`       | Depósito        |
| `POST` | `/api/transacciones/retiro`         | Retiro          |
| `GET`  | `/api/transacciones/{cuentaId}`     | Ver movimientos |

---

### ✅ Paso 5 — (Opcional) Ejecutar Tests

Los tests de dominio usan **H2 en memoria**, no necesitan PostgreSQL.

```bash
mvn test
```

---

### 🛠️Correcciones Aplicadas al Código

| Archivo | Línea | Error original | Corrección |
|---------|-------|----------------|------------|
| `Cliente.java` | 67 | `email == ""` (comparación de referencia) | `email.isEmpty()` |

---

### 🔄 Problemas Conocidos

| Prioridad | Problema | Impacto |
|-----------|---------|---------|
| 🔴 ALTA   | Credenciales en texto plano en `application.properties` | Seguridad |
| 🔴 ALTA   | Sin manejo global de excepciones (`@ControllerAdvice`) | Errores inconsistentes |
| 🟡 MEDIA  | `System.out.println` en lugar de logger SLF4J | Dificulta diagnóstico |
| 🟢 BAJA   | Sin Spring Security | Endpoints públicos sin autenticación |

---

### 🎯 Checklist de Verificación Final

- [ ] PostgreSQL corriendo en `localhost:8181`
- [ ] Base de datos `banco_db` creada
- [ ] `mvn spring-boot:run -DskipTests` arranca sin errores
- [ ] `POST /api/clientes` responde con `200` o `201`
- [ ] Las tablas se crearon automáticamente en la BD

---
### 📋 Documentacion APIs
La URL de Swagger UI con SpringDoc es:
`http://localhost:8080/swagger-ui/index.html`

Y el JSON de la especificación OpenAPI en:
`http://localhost:8080/v3/api-docs`

No hay `server.port` configurado, así que usa el puerto por defecto **8080**. Una vez ejecutado el proyecto, accedes en:
`http://localhost:8080/swagger-ui/index.html`

Ahí verás los 3 grupos de endpoints documentados con las anotaciones `@Tag` y `@Operation` que ya tienes en los controllers:

- Clientes — `api/clientes`
- Cuentas — `api/cuentas`
- Transacciones — `api/transacciones`

---
---
### 🛠️ ANEXOS

Listas: 🧩✅⚠️❌❗📌🔹🔄🛠️→🛑

Gov: 🏗🏷🧭🔤🧠📛💵🏛️📐⚙️🔧

Documentos: 📋📄🧾📝📘📁

Seguridad: 👤🔒🔐🛡️👥

Aplicaciones: 💻🚀🌐📦🧭🔗

Infra: 🧱☁️🧮

Varios: 🧼📧📊📈📥🧪💾🎯

---
