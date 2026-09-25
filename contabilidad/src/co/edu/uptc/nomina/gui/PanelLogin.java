package co.edu.uptc.nomina.gui;

import co.edu.uptc.negocio.dto.CredencialDto;
import javax.swing.*;
import java.awt.*;

public class PanelLogin extends JPanel {
    private JPasswordField pContrasena;
    private JTextField tUsuario;

    public PanelLogin() {
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        setLayout(new GridLayout(3, 2, 10, 10));
        setBorder(BorderFactory.createTitledBorder("Login"));

        add(new JLabel("Usuario:"));
        tUsuario = new JTextField();
        add(tUsuario);

        add(new JLabel("Contraseña:"));
        pContrasena = new JPasswordField();
        add(pContrasena);

        add(new JLabel()); // Espacio vacío
    }

    public CredencialDto getCredencialesUsuario() {
        String usuario = tUsuario.getText().trim();
        char[] password = pContrasena.getPassword();
        
        if (usuario.isEmpty() || password.length == 0) {
            return null;
        }

        CredencialDto credencial = new CredencialDto();
        credencial.setUsuario(usuario);
        credencial.setPassword(password);
        return credencial;
    }

    public void limpiarCampos() {
        tUsuario.setText("");
        pContrasena.setText("");
    }
}