package ventanas;
/**
 * @author Didier Recalde
 */

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogGestionRecursosHumanos extends JDialog {
    private JTextField txtCodigoRecursosHumanos;
    private JTextField txtNombreRecursoHumano;
    private JTextField txtTipoRecursoHumano;
    private JTable tbListaRecursosHumanos;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            DialogGestionRecursosHumanos dialog = new DialogGestionRecursosHumanos();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public DialogGestionRecursosHumanos() {
        setTitle("GESTION DE RECURSOS HUMANOS");
        setBounds(100, 100, 633, 313);
        getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "Datos de Recursos Humanos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setBounds(10, 55, 239, 214);
        getContentPane().add(panel);
        panel.setLayout(null);

        txtCodigoRecursosHumanos = new JTextField();
        txtCodigoRecursosHumanos.setBounds(132, 24, 86, 20);
        panel.add(txtCodigoRecursosHumanos);
        txtCodigoRecursosHumanos.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("Codigo");
        lblNewLabel_3.setBounds(10, 27, 46, 14);
        panel.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("Nombre y Apellido");
        lblNewLabel_4.setBounds(10, 68, 112, 14);
        panel.add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("Cargo ");
        lblNewLabel_5.setBounds(10, 106, 112, 14);
        panel.add(lblNewLabel_5);
        
         JLabel lblNewLabel_6 = new JLabel("Especialidad ");
        lblNewLabel_6.setBounds(10, 130, 112, 14);
        panel.add(lblNewLabel_6);

        txtNombreRecursoHumano = new JTextField();
        txtNombreRecursoHumano.setBounds(132, 65, 86, 20);
        panel.add(txtNombreRecursoHumano);
        txtNombreRecursoHumano.setColumns(10);

        txtTipoRecursoHumano = new JTextField();
        txtTipoRecursoHumano.setBounds(132, 103, 86, 20);
        panel.add(txtTipoRecursoHumano);
        txtTipoRecursoHumano.setColumns(10);
        
          txtTipoRecursoHumano = new JTextField();
        txtTipoRecursoHumano.setBounds(132, 130, 86, 20);
        panel.add(txtTipoRecursoHumano);
        txtTipoRecursoHumano.setColumns(10);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clases.RecursosHumanos objetoRecursosHumanos = new clases.RecursosHumanos();
                objetoRecursosHumanos.setCodigoRecursoHumano(txtCodigoRecursosHumanos.getText());
                objetoRecursosHumanos.setNombreRecursoHumano(txtNombreRecursoHumano.getText());
                objetoRecursosHumanos.setTipoRecursoHumano(txtTipoRecursoHumano.getText());
                objetoRecursosHumanos.agregarRegistrosRecursosHumanos();
            }
        });
        btnGuardar.setBounds(10, 155, 99, 23);
        panel.add(btnGuardar);

        JButton btnEditar = new JButton("Editar");
        btnEditar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clases.RecursosHumanos objetoRecursosHumanos = new clases.RecursosHumanos();
                objetoRecursosHumanos.EditarRecursosHumanos(tbListaRecursosHumanos);
            }
        });
        btnEditar.setBounds(109, 155, 112, 23);
        panel.add(btnEditar);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clases.RecursosHumanos objetoRecursosHumanos = new clases.RecursosHumanos();
                objetoRecursosHumanos.EliminarRecursosHumanos(tbListaRecursosHumanos, txtCodigoRecursosHumanos);
            }
        });
        btnEliminar.setBounds(10, 180, 208, 29);
        panel.add(btnEliminar);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(null, "Lista de Recursos Humanos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_1.setBounds(275, 54, 338, 177);
        getContentPane().add(panel_1);
        panel_1.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 30, 318, 136);
        panel_1.add(scrollPane);

        tbListaRecursosHumanos = new JTable();
        scrollPane.setViewportView(tbListaRecursosHumanos);

        JButton btnCrearArchivoRecursosHumanos = new JButton("Crear Archivo RRHH");
        btnCrearArchivoRecursosHumanos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clases.RecursosHumanos objetoRecursosHumanos = new clases.RecursosHumanos();
                objetoRecursosHumanos.crearArchivoRecursosHumanos();
            }
        });
        btnCrearArchivoRecursosHumanos.setBounds(10, 21, 239, 23);
        getContentPane().add(btnCrearArchivoRecursosHumanos);

        JButton btnMostrarRecursosHumanos = new JButton("Mostras Lista Recursos Humanos");
        btnMostrarRecursosHumanos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clases.RecursosHumanos objetoRecursosHumanos = new clases.RecursosHumanos();
                objetoRecursosHumanos.MostrarTotalRecursosHumanos(tbListaRecursosHumanos);
            }
        });
        btnMostrarRecursosHumanos.setBounds(275, 21, 158, 23);
        getContentPane().add(btnMostrarRecursosHumanos);

        JButton btnSeleccionar = new JButton("Seleccionar Recurso Humano");
        btnSeleccionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clases.RecursosHumanos objetoRecursosHumanos = new clases.RecursosHumanos();

                objetoRecursosHumanos.seleccionarRecursosHumanos(tbListaRecursosHumanos);
                txtCodigoRecursosHumanos.setText(objetoRecursosHumanos.getCodigoRecursoHumano());
                txtNombreRecursoHumano.setText(objetoRecursosHumanos.getNombreRecursoHumano());
                txtTipoRecursoHumano.setText(objetoRecursosHumanos.getTipoRecursoHumano());
            }
        });
        btnSeleccionar.setBounds(443, 20, 164, 23);
        getContentPane().add(btnSeleccionar);
    }
}
