package co.edu.uptc.nomina.gui;

import co.edu.uptc.negocio.dto.CredencialDto;
import co.edu.uptc.nomina.negocio.GestionSeguridad;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Evento  implements ActionListener {
    // Constantes de comandos
	public static final String CANCELAR = "Cancelar";
	public static final String LOGIN = "Login";
	public static final String ELIMINAR = "Eliminar";
	public static final String VER = "Ver";
    public static final String ACTUALIZAR = "Actualizar";
    public static final String CREAR = "Crear";
    public static final String BUSCAR = "Buscar";   
    public static final String LIMPIAR = "Limpiar";
    
    public static final String ELIMINAR_EF = "Eliminar_EF";
    public static final String VER_EF = "Ver_EF";
    public static final String ACTUALIZAR_EF = "Actualizar_EF";
    public static final String CREAR_EF = "Crear_EF";
    public static final String BUSCAR_EF = "Buscar_EF";
    public static final String LIMPIAR_EF = "Limpiar_EF";
    
    public static final String ELIMINAR_TI = "Eliminar_TI";
    public static final String VER_TI = "Ver_TI";
    public static final String ACTUALIZAR_TI = "Actualizar_TI";
    public static final String CREAR_TI = "Crear_TI";
    public static final String BUSCAR_TI = "Buscar_TI";
    public static final String LIMPIAR_TI = "Limpiar_TI";
    
    public static final String GUARDAR = "Guardar";
    public static final String EDITAR = "Editar";
    
    public static final String GUARDAR_EF = "Guardar_EF";
    public static final String EDITAR_EF = "Editar_EF";
    public static final String CANCELAR_EF = "Cancelar_EF";
    
   

    private VentanaPrincipal ventana;


    public Evento(VentanaPrincipal v) {
       ventana = v;
  
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	//Todo Auto-generated method stub
        String evento = e.getActionCommand();

        if (evento.equals(CANCELAR)) {
        	JOptionPane.showMessageDialog(null, "hOLA mUNDO");
        } else if (evento.equals(LOGIN)) {
        	ventana.loguear();
        } else if (evento.equals(CREAR_EF)) {
        	ventana.lanzarDialogoEmpleadoFijo();
        }else if (evento.equals(CANCELAR_EF)) {
        	ventana.cerrarDialogEmpFijo();;
        }
        
     }
    }

 