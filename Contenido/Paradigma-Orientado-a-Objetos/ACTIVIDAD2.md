Actividad [1](ACTIVIDAD1.md) | 2 | 3 | 4 | 5 | 6
# Actividad 2
A partir de la clase definida en el ejemplo anterior, cree una nueva clase CuentaSueldo, que 
herede de Cuenta y posea los siguientes atributos propios: legajo (entero), institución 
(string), beneficios (string), CBU (entero largo de 18 dígitos), tope (double). Además debe 
poseer los siguientes métodos:
* Constructor por defecto y constructor con CBU (el cual es un número de 18 dígitos) y 
tope fijado en 15.000
* Sobrescribir el método retirar (double), para que además de permitir sacar una cantidad 
de la cuenta (si hay saldo), no permita extracciones superiores al tope.
* transferir (monto, CBU): este método simulará una transferencia a otra cuenta por el 
monto ingresado (siempre y cuando haya saldo) y decrementará el saldo de la cuenta. 
Para la “transferencia”, muestre el saldo final de la cuenta.
* Sobrecargue el método transferir (monto, Alias) de la clase CuentaSueldo para que acepte 
un alias alfanumérico.
* [CuentaSueldo](TP1-POO/src/main/java/actividad2/CuentaSueldo.java) (codigo)
* [Demo](TP1-POO/src/main/java/actividad2/Demo.java) (codigo)
