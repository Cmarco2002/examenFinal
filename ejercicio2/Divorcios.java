package ejercicio2;

/**
 * Esta clase se ha creado con el objetivo de almacenar las localidades y 
 * la cantidad de divorcios por localidad.
 */
public class Divorcios {
	private String localidad;
	private int cuenta;
	
	public Divorcios(String localidad, int cuenta) {
		super();
		this.localidad = localidad;
		this.cuenta = cuenta;
	}

	public Divorcios() {
		super();
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public int getCuenta() {
		return cuenta;
	}

	public void setCuenta(int cuenta) {
		this.cuenta = cuenta;
	}

	@Override
	public String toString() {
		return "Divorcios [localidad=" + localidad + ", cuenta=" + cuenta + "]";
	}
}
