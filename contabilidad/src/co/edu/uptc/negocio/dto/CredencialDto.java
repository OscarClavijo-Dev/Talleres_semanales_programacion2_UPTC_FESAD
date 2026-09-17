package co.edu.uptc.negocio.dto;

import java.util.Arrays;

public class CredencialDto {

	private String usuario;
	private byte[] pasword;
	
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public byte[] getPasword() {
		return pasword;
	}
	public void setPasword(byte[] pasword) {
		this.pasword = pasword;
	}
	@Override
	public String toString() {
		return "CredencialDto [usuario=" + usuario + ", pasword=" + Arrays.toString(pasword) + "]";
	}
	
	
}
