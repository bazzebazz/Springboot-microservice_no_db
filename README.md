En nuestro archivo applicacion.yml hemos hecho una configuracion para exponer datos de nuestra aplicacion, sin embargo esto es peligroso
podria llegar a pasar que mediante estos datos puedan por malicia o negligencia
modificar nuestra bases de la aplicacion provocando un caos...
De momento esto meramente explicativo para entender que hace y como se configura ademas de la informacion que podemos recopilar
1. `PORT + api/beans podemos averiguar algun comportamiento no deseado`
2. `PORT + api/health vemos las metricas del estado de nuestra aplicacion`
3. `PORT + api/info vemos la informacion de nuestra aplicacion base` 
4. `PORT + api/metrics vemos las metricas expuestas de nuestra aplicacion`
5. `PORT + api/metrics/"Metrica seleccionada" podemos recolectar datos, se podria implementar un logger para recopilar los datos necesarios y guardarlos.`