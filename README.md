README 

CONEXION A LA BASE DE DATOS

spring.datasource.url = jdbc:mysql://localhost:3306/db_company?useSSL=false&serverTimezone=UTC&useLegacyDateTimeCode=false

# nombre de usuario y contraseña
spring.datasource.username = root
spring.datasource.password = 12345678

# mostrar sentencias SQL en la consola
spring.jpa.show-sql = true

# actualizar base de datos y crear entidades
spring.jpa.hibernate.ddl-auto = update

server.port=8084
