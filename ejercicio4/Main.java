package ejercicio4;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		//System.out.println("Introduzca un entero: ");
		//int num = entrada.nextInt();
		int contador = 0;
		int tabla []= new int[51];
		for(int i = 0; i<=100;i++) {
			if (i % 2 == 0) {
				tabla[contador]=i;
				contador++;
		    } else {
		    	
		    }
		}
		for(int j = 0; j<=tabla.length;j++) {
			System.out.println(tabla[j]);
		}
	}
}
