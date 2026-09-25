package co.edu.uptc.nomina.gui;

import co.edu.uptc.negocio.dto.CredencialDto;
import javax.swing.*;
import java.awt.*;

public class PanelLogin extends JPanel {
    private JPasswordField pContrasena;
    private JTextField tUsuario;
    private JButton btnIngresar;
    private JButton btnCancelar;
    private Evento evento;

    public PanelLogin() {
        this.evento = evento;
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        // Layout más compacto
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createTitledBorder("Login"));
        setPreferredSize(new Dimension(350, 200));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Título
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JLabel lblTitulo = new JLabel("Sistema de Nómina - UPTC", JLabel.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 14));
        add(lblTitulo, gbc);

        // Usuario
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(new JLabel("Usuario:"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        tUsuario = new JTextField(15);
        add(tUsuario, gbc);

        // Contraseña
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        add(new JLabel("Contraseña:"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        pContrasena = new JPasswordField(15);
        add(pContrasena, gbc);

        // Panel de botones
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;

        JPanel panelBotones = new JPanel();
        btnIngresar = new JButton("Ingresar");
        btnCancelar = new JButton("Cancelar");

        btnIngresar.setActionCommand(Evento.LOGIN);
        btnCancelar.setActionCommand(Evento.CANCELAR);

        btnIngresar.addActionListener(evento);
        btnCancelar.addActionListener(evento);

        panelBotones.add(btnIngresar);
        panelBotones.add(btnCancelar);
        add(panelBotones, gbc);
    }

    public CredencialDto getCredencialesUsuario() {
        String usuario = tUsuario.getText().trim();
        char[] password = pContrasena.getPassword();

        if (usuario.isEmpty() || password.length == 0) {
            return null;
        }

        CredencialDto credencial = new CredencialDto();
        credencial.setUsuario(usuario);
        credencial.setPassword(String.valueOf(password).getBytes());
        return credencial;
    }

    public void limpiarCampos() {
        tUsuario.setText("");
        pContrasena.setText("");
        tUsuario.requestFocus();
    }

    // Getters
    public JTextField gettUsuario() {
        return tUsuario;
    }

    public JPasswordField getpContrasena() {
        return pContrasena;
    }
}