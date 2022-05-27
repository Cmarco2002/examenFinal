package ejercicio1;

import java.io.File;
import java.util.Scanner;

public class Ejercicio1 {
	public static void main(String[] args) {
		String nombre = "C:\\Users\\Carlos\\Desktop\\HablanosDelDon.txt";
		File file = new File(nombre);
		try {
			Scanner f = new Scanner(file);
			String letra = "t";
			System.out.println("Letra: " + letra);
			while (f.hasNextLine()) {
				String linea = f.nextLine();
				String[] lineaSeparada = linea.split(" ");
				int lineaActual=0;
				lineaActual++;
				for (int i = 0; i < lineaSeparada.length; i++) {
					if (lineaSeparada[i].substring(0, 1).equalsIgnoreCase(letra)
							|| lineaSeparada[i].substring(lineaSeparada[i].length() - 1, lineaSeparada[i].length())
									.equalsIgnoreCase(letra)) {
						System.out.println("Palabra: " + lineaSeparada[i]);
						System.out.println("Linea: " + lineaActual);
					}
				}
			}
			f.close();

		} catch (Exception e) {
			System.out.println("El fichero " + nombre + " no ha podido ser leido");
		}
	}
}
