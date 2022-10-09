# Proyecto prueba matrices

Este es un proyecto desarrollado bajo el framework de spring el cual tiene un unico endpoint con el verbo post el cual sirve para rotar una matriz NxN que se ingresa como parámetro 90 grados. La lógica fue desarrollada usando TDD para facilitarla y luego se hizo refactorización del código usando programacion funcional. El endpoint es el siguiente:

```
localhost:8080/api/rotarMatriz
```
se le tiene que enviar en el cuerpo de la petición la matriz NxN como se muestra a continuación, en caso de no se una matriz de ese tipo el programa va a botar una excepcion especifica:

```
[
    [1,2,3],
    [4,5,6],
    [7,8,9]
]
```
La aplicación tiene el archivo Dockerfile con el cual se puede generar la imagen, este archivo por defecto te genera la compilación sin necesidad de generar manualmente el .jar nuevamente, también se optimiza la rapidez de la creación de la imagen haciendo que no se vuelvan a descargar las mismas dependencias y se optimiza el tamaño usando multi-stages.