package co.edu.uptc.nomina.negocio;

import co.edu.uptc.negocio.dto.CredencialDto;

public class GestionSeguridad {
    
    public boolean validarLogueo(CredencialDto credencial) {
        // Validación simple - usuario: admin, contraseña: 1234
        return "admin".equals(credencial.getUsuario()) && 
               "1234".equals(new String(credencial.getPassword()));
    }
}