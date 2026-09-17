package co.edu.uptc.nomina.negocio;

import co.edu.uptc.negocio.dto.CredencialDto;

public class GestionSeguridad {

	public boolean validarLogueo(CredencialDto credencial) throws Exception{
		if(credencial!=null) {
			//TODO realizar logica de negocio de validaciones 
			System.out.println(credencial);
			return true;
		}else {
			throw new Exception(" No se tiene información de las credenciales del usuario");
		}
		
		
	}
}
