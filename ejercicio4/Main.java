package ejercicio4;

import java.util.Scanner;

/**
 * Esta clase multiplica un numero que pasa el usuario por los numeros 
 * pares entre 0 y 100 ambos incluidos.
 */
public class Main {
	
	/**
	 * Pre: ---
	 * Post: Este metodo mira a ver si el contador es par y lo multiplica por
	 * el numero se repite esta accion restando 1 al contador hasta que llega a 0.
	 */
	public static void multiplicar(int num, int contador) {
		if (contador > 1) {
			multiplicar(num, contador - 1);
			if (contador % 2 == 0) {
				System.out.println(num + " x " + contador + " = " + (num * contador));
			}
		}
	}
	
	/**
	 * Pre: ---
	 * Post: Este metodo manda un entero y el numero 100 al metodo
	 * multiplicar.
	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduzca un entero: ");
		int num = entrada.nextInt();
		int contador = 100;
		multiplicar(num,contador);
	}
}
