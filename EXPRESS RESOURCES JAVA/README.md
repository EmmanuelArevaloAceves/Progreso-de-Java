# 🛒 Proyecto Final - Sistema de Inventario en Java

Este proyecto es un sistema de gestión de productos hecho en **Java** con conexión a **MySQL**, que permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre una base de datos de productos.

## Funcionalidades

- Conexión a base de datos MySQL usando JDBC
- Insertar nuevos productos
- Listar todos los productos
- Buscar productos por nombre
- Actualizar productos
- Eliminar productos con confirmación
- Interfaz por consola con menú interactivo

## Estructura del proyecto

    📁 tu_proyecto
    ├── Main.java
    ├── Conexion.java
    ├── Producto.java
    ├── ProductoDAO.java
    └── Inventario.sql

## Requisitos

- Java JDK 8 o superior
- MySQL Server
- MySQL Workbench (opcional)
- Conector JDBC (`mysql-connector-java-X.X.X.jar`)
- VSCode o IntelliJ (opcional)

## Cómo usar

1. Asegúrate de tener creada la base de datos `inventario` y la tabla `productos` (usa el script `Inventario.sql`).
2. Coloca tu usuario y contraseña en la clase `Conexion.java`.
3. Asegúrate de tener el conector JDBC agregado al classpath.
4. Compila y ejecuta `Main.java`.

## Autor

Emmanuel Alejandro Arevalo Aceves  
- GitHub: @EmmanuelArevaloAceves
- LinkedIn:( https://www.linkedin.com/in/emmanuel-alejandro-arevalo-aceves/ )
- Correo electrónico: emmanuel.arevalo.trabajo@gmail.com
