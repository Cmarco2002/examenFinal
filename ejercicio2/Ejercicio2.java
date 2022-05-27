package ejercicio2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Esta clase lee un fichero csv y muestra las parejas por localidad
 * divorciadas con y sin sin separacion previa.
 */
public class Ejercicio2 {
	
	/**
	 * Pre: ---
	 * Post: Este metodo lee un fichero csv y muestra las parejas que se han divorciado con
	 * y sin separacion previa y la localidad con mayor numero de divorcios.
	 */
	public static void leerFichero(String nombre, ArrayList<Divorcios> divorcios) {
		File file = new File(nombre);
		int separacionPrevia=0;
		int sinSeparacionPrevia=0;
		String localidad = "";
		int cuenta = 0;
		int contador = 0;
		boolean encontrado = false;
		String mayor = localidad;
		int cuentaMayor = cuenta;
		try {
			Scanner f = new Scanner(file);
			//Vamos linea por linea
			while (f.hasNextLine()) {
				String linea = f.nextLine();
				//Spliteamos los datos separados por comas
				String[] lineaSeparada = linea.split(";");
				//Contamos el numero de parejas con y sin separacion previa
				if (lineaSeparada[1].equalsIgnoreCase("si")) {
					separacionPrevia++;
				}else if(lineaSeparada[1].equalsIgnoreCase("no")) {
					sinSeparacionPrevia++;
				}
				localidad = lineaSeparada[0];
				lineaSeparada [3]= lineaSeparada [3].replace(".", "");
				//cuenta = Integer.parseInt(lineaSeparada[3]);
				for (int i=0; i<divorcios.size(); i++) {
					if (localidad.equals(divorcios.get(i).getLocalidad())) {
						encontrado = true;
						contador = i;
						break;
					}
				}
				if (encontrado==true) {
					divorcios.get(contador).setCuenta(divorcios.get(contador).getCuenta()+cuenta);
				} else {
					Divorcios x = new Divorcios(localidad, cuenta);
					divorcios.add(x);
				}
			}
			System.out.println("El numero de parejas con separacion previa es: "+ separacionPrevia);
			System.out.println("El numero de parejas sin separacion previa es: "+ sinSeparacionPrevia);
			for (int i=0; i<divorcios.size(); i++) {
				for (int j=0; j<divorcios.size(); j++) {
					if (divorcios.get(i).getCuenta()<divorcios.get(j).getCuenta()) {
						mayor=divorcios.get(j).getLocalidad();					
					}
				}
			}
			System.out.println("La localidad con mayor numero de divorcios es: "+ mayor + " con " + cuentaMayor + " divorcios");
			f.close();
		} catch (FileNotFoundException e) {
			System.out.println("El fichero " + nombre + " no ha podido ser abierto.");
		}
	}
	
	/**
	 * Pre: ---
	 * Post: Este metodo manda un arraylist de divorcios
	 * y la ruta donde esta almacenado el fichero para leerlo.
	 */
	public static void main(String[] args) {
		String nombre = "C:\\Users\\Carlos\\Desktop\\Divorcios.csv";
		ArrayList<Divorcios> divorcios = new ArrayList<Divorcios>();
		leerFichero(nombre, divorcios);
	}
}
