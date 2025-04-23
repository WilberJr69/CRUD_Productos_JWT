# 🛒 CRUD_Productos_JWT

Este proyecto es una API REST desarrollada en Java con Spring Boot que permite realizar un CRUD 
(Crear, Leer, Actualizar, Eliminar) de productos. 

🗝️ Implementa autenticación y autorización mediante **JSON Web Tokens (JWT)** 
para gestionar el acceso según el rol del usuario (admin o usuario normal).

En la clase DataInitializer.java, inicialicé de manera directa y predeterminada ROLE_USER y ROLE_ADMIN,
al igual que dos tipos de productos. Para asi solo centrarme en la configurción de los endpoints del crud

---

## 🚀 Tecnologías utilizadas

- Java jdk 21
- Spring Boot
- Spring Security
- JWT (JSON Web Token)
- MySQL
- Docker
- Gradle

---

## 🔐 Autenticación y autorización

La seguridad de esta API está basada en **JWT** y maneja dos tipos de roles de usuario:

- `ROLE_ADMIN`: puede **crear, actualizar y eliminar productos**.
- `ROLE_USER`: solo puede **ver productos** y **autenticarse**.

### Flujo de autenticación:
1. El usuario se autentica con su correo y contraseña.
2. Si las credenciales son correctas, se genera un token JWT. -> /auth/generateToken
3. El token debe ser enviado en cada petición protegida en la cabecera:  
