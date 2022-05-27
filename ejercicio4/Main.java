package ejercicio4;

import java.util.Scanner;

public class Main {
	public static void multiplicar(int num, int contador) {
		if (contador % 2 == 0) {
			System.out.println(num + " x "+ contador + " = "+  num*contador);
			multiplicar(num, contador-1);
		} else if(contador == 101) {
		} else {
			multiplicar(num, contador + 1);
		}
	}

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduzca un entero: ");
		int num = entrada.nextInt();
		int contador = 0;
		multiplicar(num,contador);
	}
}
