package ejercicio1;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Esta clase lee un fichero txt y muestra las palabras que empiezan 
 * o terminan por un letra en concreto.
 */
public class Ejercicio1 {
	
	/**
	 * Pre: ---
	 * Post: Este metodo lee un fichero txt y muestra las palabras que empiezan o terminan por 
	 * la letra t ademas de almacenarla en la base de datos.
	 */
	public static void main(String[] args) throws Exception {
		MySqlAcces base = new MySqlAcces();
		//ArrayList<Registro> registro = base.writeRegistro();
		String nombre = "C:\\Users\\Carlos\\Desktop\\HablanosDelDon.txt";
		File file = new File(nombre);
		try {
			Scanner f = new Scanner(file);
			String letra = "t";
			int lineaActual=0;
			System.out.println("Letra: " + letra);
			while (f.hasNextLine()) {
				String linea = f.nextLine();
				String[] lineaSeparada = linea.split(" ");
				lineaActual++;
				for (int i = 0; i < lineaSeparada.length; i++) {
					if (lineaSeparada[i].substring(0, 1).equalsIgnoreCase(letra)
							|| lineaSeparada[i].substring(lineaSeparada[i].length() - 1, lineaSeparada[i].length())
									.equalsIgnoreCase(letra)) {
						lineaSeparada [i]= lineaSeparada [i].replace(",", "");
						lineaSeparada [i]= lineaSeparada [i].replace(".", "");
						System.out.println("Palabra: " + lineaSeparada[i]);
						System.out.println("Linea: " + lineaActual);
						base.insertRegistro(letra, lineaSeparada[i], lineaActual);
						//registro = base.writeRegistro();
					}
				}
			}
			f.close();

		} catch (Exception e) {
			System.out.println("El fichero " + nombre + " no ha podido ser leido");
		}
	}
}
