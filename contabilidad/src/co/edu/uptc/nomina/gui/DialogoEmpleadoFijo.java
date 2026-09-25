package co.edu.uptc.nomina.gui;

import co.edu.uptc.nomina.modelo.EmpleadoTerminoFijo;
import co.edu.uptc.nomina.modelo.enums.TipoDocEnum;
import co.edu.uptc.nomina.negocio.NominaConfig;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class DialogoEmpleadoFijo extends DialogoCentralPersona {
    private JTextField txtId;
    private JTextField txtSalarioBase;
    private JTextField txtDiasTrabajados;
    private JTextField txtFechaTerminacion;
    private NominaConfig config;
    private Evento evento;
    private EmpleadoTerminoFijo empleado;

    public DialogoEmpleadoFijo(Frame owner, Evento evento, String titulo, boolean modal) {
        super(owner, evento, titulo, modal);
        this.evento = evento;
        this.config = ((VentanaPrincipal) owner).getConfig();
        inicializarComponentesEspecificas();
    }

    private void inicializarComponentesEspecificas() {
        setSize(600, 500);
        
        JPanel panelFormulario = (JPanel) getContentPane();
        panelFormulario.removeAll();
        panelFormulario.setLayout(new GridLayout(9, 2, 10, 10));

        panelFormulario.add(new JLabel("ID:"));
        txtId = new JTextField();
        panelFormulario.add(txtId);

        panelFormulario.add(new JLabel("Tipo Documento:"));
        cbxTipoDoc = new JComboBox<>(TipoDocEnum.values());
        panelFormulario.add(cbxTipoDoc);

        panelFormulario.add(new JLabel("Primer Nombre:"));
        txtPrimerNombre = new JTextField();
        panelFormulario.add(txtPrimerNombre);

        panelFormulario.add(new JLabel("Salario Base:"));
        txtSalarioBase = new JTextField();
        panelFormulario.add(txtSalarioBase);

        panelFormulario.add(new JLabel("Días Trabajados:"));
        txtDiasTrabajados = new JTextField();
        panelFormulario.add(txtDiasTrabajados);

        panelFormulario.add(new JLabel("Fecha Terminación (YYYY-MM-DD):"));
        txtFechaTerminacion = new JTextField();
        panelFormulario.add(txtFechaTerminacion);

        JPanel panelBotones = new JPanel();
        btnGuardar = new JButton(Evento.GUARDAR);
        btnCerrar = new JButton(Evento.CANCELAR);

        panelBotones.add(btnGuardar);
        panelBotones.add(btnCerrar);

        panelFormulario.add(panelBotones);
    }

    @Override
    protected void asignarComandoBotones() {
        btnGuardar.setActionCommand(Evento.GUARDAR_EF);
        btnCerrar.setActionCommand(Evento.CANCELAR_EF);

        btnGuardar.addActionListener(evento);
        btnCerrar.addActionListener(evento);
    }

    public EmpleadoTerminoFijo capturarDatos() {
        try {
            long id = Long.parseLong(txtId.getText().trim());
            String primerNombre = txtPrimerNombre.getText().trim();
            TipoDocEnum tipoDoc = (TipoDocEnum) cbxTipoDoc.getSelectedItem();
            double salarioBase = Double.parseDouble(txtSalarioBase.getText().trim());
            double diasTrabajados = Double.parseDouble(txtDiasTrabajados.getText().trim());
            LocalDate fechaTerminacion = LocalDate.parse(txtFechaTerminacion.getText().trim());

            empleado = new EmpleadoTerminoFijo();
            empleado.setId(id);
            empleado.setPrimerNombre(primerNombre);
            empleado.setTipoDoc(tipoDoc);
            empleado.setSalarioBase(salarioBase);
            empleado.setDiasTrabajados(diasTrabajados);
            empleado.setFechaTerminacionContrato(fechaTerminacion);

            return empleado;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Error en los datos: " + e.getMessage(),
                "Error de validación",
                JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public void cargarEmpleado(EmpleadoTerminoFijo emp) {
        this.empleado = emp;
        txtId.setText(String.valueOf(emp.getId()));
        txtPrimerNombre.setText(emp.getPrimerNombre());
        cbxTipoDoc.setSelectedItem(emp.getTipoDoc());
        txtSalarioBase.setText(String.valueOf(emp.getSalarioBase()));
        txtDiasTrabajados.setText(String.valueOf(emp.getDiasTrabajados()));
        if (emp.getFechaTerminacionContrato() != null) {
            txtFechaTerminacion.setText(emp.getFechaTerminacionContrato().toString());
        }
    }

    public void limpiarCampos() {
        txtId.setText("");
        txtPrimerNombre.setText("");
        cbxTipoDoc.setSelectedIndex(0);
        txtSalarioBase.setText("");
        txtDiasTrabajados.setText("");
        txtFechaTerminacion.setText("");
    }
}