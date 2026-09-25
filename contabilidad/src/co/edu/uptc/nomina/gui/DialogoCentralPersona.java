package co.edu.uptc.nomina.gui;

import co.edu.uptc.nomina.modelo.enums.TipoDocEnum;
import javax.swing.*;
import java.awt.*;

public abstract class DialogoCentralPersona extends JDialog {
    protected JButton btnCerrar;
    protected JButton btnGuardar;
    protected JComboBox<TipoDocEnum> cbxTipoDoc;
    protected boolean isCrear;
    protected String tituloDialogo;
    protected JTextField txtPrimerNombre;

    public DialogoCentralPersona(Frame owner, String titulo, boolean modal) {
        super(owner, titulo, modal);
        this.isCrear = true;
        this.tituloDialogo = titulo;
        inicializarComponentes();
        asignarComandoBotones();
    }

    public DialogoCentralPersona(Frame owner, Evento evento, String titulo, boolean modal) {
        this(owner, titulo, modal);
    }

    protected void inicializarComponentes() {
        setTitle(tituloDialogo);
        setSize(500, 400);
        setLocationRelativeTo(getOwner());
        setLayout(new BorderLayout());

        JPanel panelFormulario = new JPanel();
        panelFormulario.setLayout(new GridLayout(6, 2, 10, 10));
        panelFormulario.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panelFormulario.add(new JLabel("Tipo Documento:"));
        cbxTipoDoc = new JComboBox<>(TipoDocEnum.values());
        panelFormulario.add(cbxTipoDoc);

        panelFormulario.add(new JLabel("Primer Nombre:"));
        txtPrimerNombre = new JTextField();
        panelFormulario.add(txtPrimerNombre);

        JPanel panelBotones = new JPanel();
        btnGuardar = new JButton("Guardar");
        btnCerrar = new JButton("Cerrar");

        panelBotones.add(btnGuardar);
        panelBotones.add(btnCerrar);

        add(panelFormulario, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }

    protected abstract void asignarComandoBotones();
}