# Cloud Sql Demo

Este proyecto está enfocado en demostrar la conexion con CloudSql mediante una ip publica

## Prerequisitos

What things you need to install the software and how to install them
* Java 8
* [Gradle](https://gradle.org//) - Dependency Management
* [Lombok](https://projectlombok.org/setup/overview) - Java library

```
spring.datasource.url=jdbc:postgresql://${IP_CLOUDSQL}:${PORT_CLOUDSQL}/postgres?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&zeroDateTimeBehavior=convertToNull&verifyServerCertificate=false&useSSL=false&requireSSL=false
spring.datasource.username=${USER_CLOUDSQL}
spring.datasource.password=${PASS_CLOUDSQL}
```

## Compilar y ejecutar este proyecto

Recuerda usar java 8 o mayor y ejecutar los siguientes comandos:

```
./gradlew clean build
```

Finalmente ejecuta el siguiente comando en la consola de su sistema operativo para ejecutar la aplicación:
## consola postgres desde docker
docker exec -it postgres psql -U postgres

```
export IP_CLOUDSQL={la ip de cloud sql}                             
export PASS_CLOUDSQL={la clave de la base de datos}
export PORT_CLOUDSQL=5432
export USER_CLOUDSQL={el usuario de la base de datos, por defecto es postgres}

./gradlew bootRun --args='--spring.profiles.active=local'
```

### API DOCS
* [Accessing local] TODO


## Autores

* **Jorge Leiva** - *Initial work* - jorgeleiva.17@gmail.com
