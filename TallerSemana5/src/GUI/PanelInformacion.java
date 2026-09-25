package GUI;

import negocio.Persona;
import javax.swing.*;
import java.awt.*;

public class PanelInformacion extends JPanel {
    
    // ATRIBUTOS (según diagrama UML del PDF)
    private JLabel labelNombres;
    private JLabel labelApellidos;
    private JLabel labelDocumento;
    private JLabel labelCodigo;
    private JTextField textNombres;
    private JTextField textApellidos;
    private JTextField textDocumento;  // Este campo contiene el código
    private JLabel numeroUsuarios;

    // CONSTRUCTOR
    public PanelInformacion() {
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        setLayout(null);
        setBorder(BorderFactory.createTitledBorder("Información de la Persona"));
        setPreferredSize(new Dimension(400, 200));

        // Labels
        labelNombres = new JLabel("Nombres:");
        labelNombres.setBounds(20, 30, 80, 25);
        
        labelApellidos = new JLabel("Apellidos:");
        labelApellidos.setBounds(20, 65, 80, 25);
        
        labelDocumento = new JLabel("Documento:");
        labelDocumento.setBounds(20, 100, 80, 25);
        
        labelCodigo = new JLabel("Código:");
        labelCodigo.setBounds(20, 135, 80, 25);

        // TextFields
        textNombres = new JTextField();
        textNombres.setBounds(110, 30, 200, 25);
        
        textApellidos = new JTextField();
        textApellidos.setBounds(110, 65, 200, 25);
        
        textDocumento = new JTextField();
        textDocumento.setBounds(110, 100, 200, 25);

        // Label número de usuarios
        numeroUsuarios = new JLabel("Usuarios: 0");
        numeroUsuarios.setBounds(250, 170, 150, 25);

        // Agregar componentes al panel
        add(labelNombres);
        add(textNombres);
        add(labelApellidos);
        add(textApellidos);
        add(labelDocumento);
        add(textDocumento);
        add(labelCodigo);
        add(numeroUsuarios);
    }

    /**
     * Recolecciona la información de la persona.
     * @return Una persona con los datos de la GUI.
     * @throws Exception arroja una excepción si se incumple con algunos de los atributos
     */
    public Persona getPersona() throws Exception {
        Persona nuevaPersona = new Persona();
        nuevaPersona.setNombres(textNombres.getText());
        nuevaPersona.setApellidos(textApellidos.getText());
        nuevaPersona.setCodigo(Integer.parseInt(textDocumento.getText()));
        
        return nuevaPersona;
    }

    /**
     * @param persona
     * @param tamanoVector
     */
    public void setPersona(Persona persona, int tamanoVector) {
        if (persona != null) {
            textNombres.setText(persona.getNombres());
            textApellidos.setText(persona.getApellidos());
            textDocumento.setText(String.valueOf(persona.getCodigo()));
        } else {
            limpiarCampos();
        }
        numeroUsuarios.setText("Usuarios: " + tamanoVector);
    }

    public void limpiarCampos() {
        textNombres.setText("");
        textApellidos.setText("");
        textDocumento.setText("");
    }

    // GETTERS
    public String getNombres() {
        return textNombres.getText();
    }

    public String getApellidos() {
        return textApellidos.getText();
    }

    public String getDocumento() {
        return textDocumento.getText();
    }

    // SETTERS
    public void setNombres(String nombres) {
        textNombres.setText(nombres);
    }

    public void setApellidos(String apellidos) {
        textApellidos.setText(apellidos);
    }

    public void setDocumento(String documento) {
        textDocumento.setText(documento);
    }

    public void setNumeroUsuarios(int numero) {
        numeroUsuarios.setText("Usuarios: " + numero);
    }
}