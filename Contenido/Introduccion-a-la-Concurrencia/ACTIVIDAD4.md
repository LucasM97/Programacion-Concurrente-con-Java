[IC](INTRODUCCION-CONCURRENCIA.md) Actividad [1](ACTIVIDAD1.md) | [2](ACTIVIDAD2.md) | [3](ACTIVIDAD3.md) | 4 | [5](ACTIVIDAD5.md) | [6](ACTIVIDAD6.md) | [7](ACTIVIDAD7.md) | [8](ACTIVIDAD8.md)
# Actividad 4
Investigue como y mediante qué mecanismos se implementa concurrencia en los siguientes 
lenguajes de programación: Java, C# y Python. Indique además los nombres de las librerías 
para cada lenguaje.
## Desarrollo
## Java
* Hilos (Threads): Java proporciona la clase Thread para crear y gestionar hilos. Un hilo es la unidad básica de ejecución en un programa Java.
* Concurrencia a nivel de lenguaje: Java integra la concurrencia directamente en el lenguaje, lo que permite un manejo más natural de los hilos.
* Librerías:
  + java.lang.Thread: Clase base para crear hilos.
  + java.util.concurrent: Paquete que contiene clases e interfaces para la programación concurrente avanzada, como ExecutorService, Future, BlockingQueue, etc.
  + java.util.concurrent.atomic: Paquete que proporciona clases para operaciones atómicas sobre variables, evitando la necesidad de sincronización explícita en muchos casos.
## C#
* Hilos (Threads): Al igual que Java, C# utiliza la clase Thread para crear y gestionar hilos.
* Tareas (Tasks): C# introduce el concepto de tarea, que representa una unidad de trabajo asíncrono. Las tareas ofrecen una forma más moderna y flexible de manejar la concurrencia.
* Librerías:
  + System.Threading: Espacio de nombres que contiene clases para la programación concurrente básica, como Thread, ThreadPool, etc.
  + System.Threading.Tasks: Espacio de nombres que proporciona clases y tipos para la programación asíncrona y basada en tareas, como Task, Parallel, etc.
  + System.Collections.Concurrent: Espacio de nombres que contiene colecciones concurrentes seguras para el acceso multihilo.
## Python
* Hilos (Threads): Python tiene el módulo threading para trabajar con hilos. Sin embargo, debido al Global Interpreter Lock (GIL), los hilos de Python no pueden ejecutar código de Python en paralelo en un solo intérprete, limitando su utilidad para tareas intensivas en CPU.
* Procesos (Processes): Para aprovechar múltiples núcleos de CPU, Python ofrece el módulo multiprocessing para crear procesos. Los procesos son completamente independientes y no comparten el mismo espacio de memoria.
* Corrutinas (Coroutines): Python 3.4 introdujo las corrutinas con la palabra clave async/await, proporcionando una forma eficiente de escribir código concurrente sin bloquear el hilo principal.
* Librerías:
  + threading: Módulo para trabajar con hilos.
  + multiprocessing: Módulo para crear procesos.
  + asyncio: Módulo para programación asíncrona basada en corrutinas.
