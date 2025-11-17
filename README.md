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
poder exportar los personajes en un archivo (INIDICAR EXTENSIÓN DEL ARCHIVO)

---

##  Postman
Lo primero de todo, hemos utilizado la página de Postman, en la que
revisamos a fondo el contenido de la API, en el que podmeos ver, como
bien muestra imágen, que cada personaje tiene su ID identificativo, un nombre, su género, etc.

![Alt](mediaReadme/Ver_api_en_postman.png)

Al mirar la API a fondo, nos damos cuenta que la escogida proporcionada de la página web dada
por el profesor, solo nos muestra los 20 personajes, esto pasa porque tiene más de 40 páginas
llenas de personajes de la serie, en la que nosotros escogemos las 5 primeras páginas, que continenen 100,
para que la aplicación sea completa y a su vez no tenga problemas de sobrecarga.

La siguiente imágen mustra como la API contiene las páginas dichas anteriormente, en info, la propiedad "next",
indica la siguiente página y "prev" indica la página anterior. En la imágen de la izquierda podemos ver que
en info, la propiedad next, indica la segunda página con prev en null ya que es la primera página,y no existe
una anterior, cosa que pasaría lo contrario en la imágen de la derecha.
