package ejercicio1;

public class Registro {
	private int id_registro;
	private String letra;
	private String palabra;
	private int linea;
	
	public Registro(int id_registro, String letra, String palabra, int linea) {
		super();
		this.id_registro = id_registro;
		this.letra = letra;
		this.palabra = palabra;
		this.linea = linea;
	}
	
	public Registro() {
		super();
	}

	public int getId_registro() {
		return id_registro;
	}
	
	public void setId_registro(int id_registro) {
		this.id_registro = id_registro;
	}
	
	public String getLetra() {
		return letra;
	}
	
	public void setLetra(String letra) {
		this.letra = letra;
	}
	
	public String getPalabra() {
		return palabra;
	}
	
	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}
	
	public int getLinea() {
		return linea;
	}
	
	public void setLinea(int linea) {
		this.linea = linea;
	}

	@Override
	public String toString() {
		return "Registro [id_registro=" + id_registro + ", letra=" + letra + ", palabra=" + palabra + ", linea=" + linea
				+ "]";
	}
}
