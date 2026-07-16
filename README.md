# INTRODUCCIÓN A LA PROGRAMACIÓN PARA TESTERS: UN ENFOQUE PRACTICO
## Tarea VC 1 - Exploración y creación de proyecto

Análisis del sitio web http://cestore.ces.com.uy/adminces/.

La contraseña y detalles están en la tarea https://capacitacion.ces.com.uy/mod/assign/view.php?id=55953.

<br>

* ###  Funcionalidades principales

  - Sin loguearse:
    - Iniciar sesión (Unicamente a cuentas admin) <br>
         **Datos:** email y contraseña
    - Registrarse (Crear cuenta admin) <br>
         **Datos:** Nombre, apellido, email, contraseña, repetir contraseña.
    - Reiniciar contraseña <br>
         **Datos:** email, contraseña (nueva contraseña), repetir contraseña (nueva).
  - Logueado con rol admin:
      - Cerrar sesión

      - Ver y editar datos de perfil <br>
        **Datos:** Nombre, Apellido, Email, País, Rol (no editable)

      - Reiniciar contraseña (unicamente para rol admin)

      - Crear un nuevo usuario (con rol tester)<br>
        **Datos:** Nombre, Apellido, Email, País de nacimiento, Contraseña por defecto y Perfil

      - Ver usuarios: <br>
          - Acción eliminar usuario (sólo usuarios con rol Tester)

(!) No existe posibilidad de realizar login con rol tester 

## Tarea Final 

* ###  Cómo ejecutarlo

- Abrir el código en en un editor de código compatible con JAVA
- Ejecutar la clase "Main"
- Existen 2 usuarios de prueba:
  - Admin (sil@ces.uy / 1234)
  - Tester (pau@ces.uy / 1234)

* ###  UML
