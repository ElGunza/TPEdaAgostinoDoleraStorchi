package TPIntegradorDSA;

public class Cliente extends Persona{
	String localidad;
	int servicio;
	String tipo;
	String user;
	String password;
	int servicioAux;
	int servicioGrua;
	int servicioCer;
	public Cliente(String nombre, String apellido, String localidad, int servicio, String tipo, String user,
			String password, int servicioAux, int servicioGrua, int servicioCer) {
		super(nombre, apellido);
		this.localidad = localidad;
		this.servicio = servicio;
		this.tipo = tipo;
		this.user = user;
		this.password = password;
		this.servicioAux = servicioAux;
		this.servicioGrua = servicioGrua;
		this.servicioCer = servicioCer;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public int getServicio() {
		return servicio;
	}
	public void setServicio(int servicio) {
		this.servicio = servicio;
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
	
	
}
