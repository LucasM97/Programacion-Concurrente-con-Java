[IC](INTRODUCCION-CONCURRENCIA.md) Actividad [1](ACTIVIDAD1.md) | [2](ACTIVIDAD2.md) | [3](ACTIVIDAD3.md) | [4](ACTIVIDAD4.md) | [5](ACTIVIDAD5.md) | [6](ACTIVIDAD6.md) | 7 | [8](ACTIVIDAD8.md)
# Actividad 7
Considere los siguiente hilos<br>
![A2](img/T2A7.png)<br>
Empleando semáforos, se debe asegurar que el resultado final de la impresión sea “R I O OK
OK OK”.
## Desarrollo
### Código
``` 
    semaforo s1 = 1
    semaforo s2 = 0
    semaforo s3 = 0
    semaforo s4 = 0
    semaforo s5 = 0

    thread {
        wait(s1);
        print("R");
        signal(s2);
        wait(s4);
        print("OK");
    }

    thread {
        wait(s2);
        print("I");
        signal(s3);
        wait(s5);
        print("OK");
    }

    thread {
        wait(s3);
        print("O");
        print("OK");
        signal(s4);
        signal(s5);
        signal(s1);
    }
```
