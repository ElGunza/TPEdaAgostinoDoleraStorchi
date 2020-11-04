package TPIntegradorDSA;

public class Cliente extends Persona implements Comparable<Cliente>{
	String localidad;
	String tipo;
	String user;
	String password;
	int servicioAux;
	int servicioGrua;
	int servicioCer;
	int deuda;
	int cantkm;
	
	public Cliente(String nombre, String apellido, String localidad, String tipo, String user,
			String password, int servicioAux, int servicioGrua, int servicioCer, int deuda, int cantkm) {
		super(nombre, apellido);
		this.localidad = localidad;
		this.tipo = tipo;
		this.user = user;
		this.password = password;
		this.servicioAux = servicioAux;
		this.servicioGrua = servicioGrua;
		this.servicioCer = servicioCer;
		this.deuda = deuda;
		this.cantkm = cantkm;
	}
	
	public int getCantkm() {
		return cantkm;
	}
	public void setCantkm(int cantkm) {
		this.cantkm = cantkm;
	}
	public int getDeuda() {
		return deuda;
	}
	public void setDeuda(int deuda) {
		this.deuda = deuda;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getServicioAux() {
		return servicioAux;
	}
	public void setServicioAux(int servicioAux) {
		this.servicioAux = servicioAux;
	}
	public int getServicioGrua() {
		return servicioGrua;
	}
	public void setServicioGrua(int servicioGrua) {
		this.servicioGrua = servicioGrua;
	}
	public int getServicioCer() {
		return servicioCer;
	}
	public void setServicioCer(int servicioCer) {
		this.servicioCer = servicioCer;
	}

	@Override
	public int compareTo(Cliente C1) {
		if (deuda < C1.deuda) {
			return -1;
		}
		if (deuda > C1.deuda) {
			return 1;
		}
		return 0;
	}
	
	
}
