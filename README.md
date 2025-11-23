# RICK AND MORTY APP
---
## Índice
(contenido)
(contenido)
(contenido)
(contenido)
(contenido)
(contenido)

## Introducción
Esta es una aplicación que gestiona los 100 personajes más
relevantes de la serie Rick And Morty sacado de [RICK AND MORTY API](https://www.freepublicapis.com/rick-and-morty-api "API_Rick_And_Morty").

Lo que hará el programa será registrarse en la aplicación con
un nombre de usuario y una contraseña, si el usuario está registrado
y al intentar iniciar sesión, alguno de estos campos son incorrectos,
lanzará un error para que el usuario cubra bien dichos campos.

Una vez dentro de la aplicación, el programa hará una busqúeda por
ID del personaje, mostrando campos como su nombre, género, especie,
una imágen del propio personaje, etc. Permitiendo en la propia ventana
poder exportar los personajes en un archivo .dat

---

## 1. Postman
Lo primero de todo, hemos utilizado la página de Postman, en la que
revisamos a fondo el contenido de la API, en el que podemos ver, como
bien muestra imágen, que cada personaje tiene su ID identificativo, un nombre, su género, etc.

![Alt](mediaReadme/Ver_api_en_postman.png)

## Páginas:
Al mirar la API a fondo, nos damos cuenta que la escogida proporcionada de la página web dada
por el profesor, solo nos muestra los 20 personajes, esto pasa porque tiene más de 40 páginas
llenas de personajes de la serie, en la que nosotros escogemos las 5 primeras páginas, que continenen 100,
para que la aplicación sea completa y a su vez no tenga problemas de sobrecarga.

La siguiente imágen mustra como la API contiene las páginas dichas anteriormente, en info, la propiedad "next",
indica la siguiente página y "prev" indica la página anterior. En la primera imágen podemos ver que
en info, la propiedad next, indica la segunda página con prev en null ya que es la primera página,y no existe
una anterior, cosa que pasaría lo contrario en la segunda imágen.

## Imágen 1
![Alt](mediaReadme/PaginaANull1.png)
## Imágen 2
![Alt](mediaReadme/PaginaANull2.png)

## Contenido:
El contenido de cada personaje que queremos usar en la apilcación son:
1. **Nombre** -> El nombre del personaje de la serie
2. **Género** -> El género que se considera dicho personaje, habiendo género desconocido
3. **Tipo** -> El tipo de personaje que es, como por ejemplo "Superhumano"
4. **Localización** -> Donde se encutra en la serie
5. **Especie** -> Si es humano, Alien, etc.
6. **Estado** -> Si está vivo, muerto o si es desconocido
7. **Origien** -> El lugar de donde viene el personaje
>Existen personajes que no tienen un tipo específico en el que la API los muestra como " ". En nuestra aplicación aparecerá vacío en muchos de los casos

---

## 2. Manual técnico para desarrolladores
* **Versión utilizada**: La aplicación se desarrollo en Java 17, en la que  nos damos cuenta de que necesitarmeos una versión igual o superior para poder ejecutar el proyecto
* **Interfaz Gráfica**:  La aplicación contiene una interfaz gráfica realizada con Swing
* **Proyecto**: El proyecto se realizó con Maven, por lo que una vez más, para ejecutar el proyecto, se necesitará tener Maven instalado
* **IDE**: Para la creación del proyecto se usó el IDE NetBeans en el que se desarralló la aplicación

## Estructura de paquetes
![Alt](mediaReadme/EstructuraPaquetes.png)

## Ejecución del proyecto
**Desde cualquier IDE**:
1. Importar el proyecto como un proyecto Maven
2. Revisar dependencias
3. Ejecutar la clase **main** para poder iniciar el proyecto

---

## 3. Manual de usuario

## Iniciar Sesión / Registrarse
Al iniciar la aplicación, nos aparece una ventana, en la que, tendremos que iniciar sesión si ya tenemos una cuenta, o registrarse si por lo contrario somos nuevos usuarios
![Alt](IniciarSesion-Registrarse/EstructuraPaquetes.png)

Si ya tenemos una cuenta, indicaremos nuestro nombre de **usuario** y la **contraseña** en la que no estará visible para  proteger nuestra privacidad, y pincharemos en la opción aceptar para acceder a la aplicación

Si de  
## Reparto de la tareas
Iago -> Sistemas de gestion de usuarios, Interfaz gráfica (Swing), correcion de codigo mal ejecutado por el compañero / HORAS EXTRAS -> 10H
Ivan -> conexion a la api, Procesamiento y almacenamiento de datos, funcionalidades CRUD, README / HORAS EXTRAS -> 7H
