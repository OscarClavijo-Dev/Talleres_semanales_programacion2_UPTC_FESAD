package co.edu.uptc.nomina.modelo;

import co.edu.uptc.nomina.modelo.enums.TipoDocEnum;

public class Persona {

	private long id;
	
	protected String primerNombre;
	protected String otrosoNombres;
	
	protected String primerApellido;
	protected String otrosApellidos;
	
	protected TipoDocEnum tipoDoc;
	
	public String getPrimerNombre() {
		return primerNombre;
	}
	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}
	public String getOtrosoNombres() {
		return otrosoNombres;
	}
	public void setOtrosoNombres(String otrosoNombres) {
		this.otrosoNombres = otrosoNombres;
	}
	public String getPrimerApellido() {
		return primerApellido;
	}
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}
	public String getOtrosApellidoa() {
		return otrosApellidos;
	}
	public void setOtrosApellidoa(String otrosApellidoa) {
		this.otrosApellidos = otrosApellidoa;
	}
	
	
	
	
	
	
}
