package clases;

/**
 * @author Didier Recalde
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringJoiner;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class RecursosHumanos {

    String codigoRecursoHumano;
    String nombreRecursoHumano;
    String tipoRecursoHumano;

    public String getCodigoRecursoHumano() {
        return codigoRecursoHumano;
    }

    public void setCodigoRecursoHumano(String codigoRecursoHumano) {
        this.codigoRecursoHumano = codigoRecursoHumano;
    }

    public String getNombreRecursoHumano() {
        return nombreRecursoHumano;
    }

    public void setNombreRecursoHumano(String nombreRecursoHumano) {
        this.nombreRecursoHumano = nombreRecursoHumano;
    }

    public String getTipoRecursoHumano() {
        return tipoRecursoHumano;
    }

    public void setTipoRecursoHumano(String tipoRecursoHumano) {
        this.tipoRecursoHumano = tipoRecursoHumano;
    }

    public void crearArchivoRecursosHumanos() {
        try {
            File objetoArchivo = new File("RecursosHumanos.txt");
            if (objetoArchivo.createNewFile()) {
                JOptionPane.showMessageDialog(null, "Se ha creado correctamente el archivo: " + objetoArchivo.getName());
            } else {
                JOptionPane.showMessageDialog(null, "El archivo ya existe");
            }

        } catch (Exception e) {
            System.out.println("Ocurrió un error al crear el archivo");

        }
    }

    public void agregarRegistrosRecursosHumanos() {
        try {
            FileWriter fw = new FileWriter("RecursosHumanos.txt", true);

            fw.write(getCodigoRecursoHumano());
            fw.write(",");
            fw.write(getNombreRecursoHumano());
            fw.write(",");
            fw.write(getTipoRecursoHumano());
            fw.write("\n");
            fw.close();

            JOptionPane.showMessageDialog(null, "Se registró correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al registrar" + e.toString());
        }
    }

    public void MostrarTotalRecursosHumanos(JTable tablaTotalRecursosHumanos) {

        String nombreArchivo = "RecursosHumanos.txt";

        File file = new File(nombreArchivo);

        try {

            BufferedReader br = new BufferedReader(new FileReader(file));

            String primeraLinea = br.readLine().trim();

            DefaultTableModel model = new DefaultTableModel();

            model.addColumn("Codigo");
            model.addColumn("NombreRecursoHumano");
            model.addColumn("TipoRecursoHumano");

            tablaTotalRecursosHumanos.setModel(model);

            Object[] tableLines = br.lines().toArray();

            for (int i = 0; i < tableLines.length; i++) {

                String line = tableLines[i].toString().trim();
                String[] datarow = line.split(",");
                model.addRow(datarow);
                tablaTotalRecursosHumanos.setModel(model);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error" + e.toString());

        }
    }

    public void seleccionarRecursosHumanos(JTable tablaRecursosHumanos) {

        try {

            int fila = tablaRecursosHumanos.getSelectedRow();

            if (fila >= 0) {

                setCodigoRecursoHumano(tablaRecursosHumanos.getValueAt(fila, 0).toString());
                setNombreRecursoHumano(tablaRecursosHumanos.getValueAt(fila, 1).toString());
                setTipoRecursoHumano(tablaRecursosHumanos.getValueAt(fila, 2).toString());
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error" + e.toString());
        }

    }

    public void EliminarRecursosHumanos(JTable tablaRecursosHumanos, JTextField codigoRecursoHumano) {

        // Eliminación visual de la tabla
        DefaultTableModel model = (DefaultTableModel) tablaRecursosHumanos.getModel();

        for (int i = 0; i < model.getRowCount(); i++) {

            if (((String) model.getValueAt(i, 0)).equals(codigoRecursoHumano.getText())) {
                model.removeRow(i);
                break;

            }
        }
        // Limpieza del archivo .txt

        try {
            PrintWriter writer = new PrintWriter("RecursosHumanos.txt");
            writer.print("");
            writer.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un problema" + e.toString());
        }

        // Creación de los nuevos registros luego de la eliminación

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("RecursosHumanos.txt")))) {
            StringJoiner joiner = new StringJoiner(",");

            for (int col = 0; col < tablaRecursosHumanos.getColumnCount(); col++) {
                joiner.add(tablaRecursosHumanos.getColumnName(col));
            }

            System.out.println(joiner.toString());
            bw.write(joiner.toString());
            bw.newLine();

            for (int row = 0; row < tablaRecursosHumanos.getRowCount(); row++) {
                joiner = new StringJoiner(",");
                for (int col = 0; col < tablaRecursosHumanos.getColumnCount(); col++) {

                    Object obj = tablaRecursosHumanos.getValueAt(row, col);
                    String value = obj == null ? "null" : obj.toString();
                    joiner.add(value);

                }

                bw.write(joiner.toString());
                bw.newLine();
                JOptionPane.showMessageDialog(null, "Se eliminó correctamente");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error");
        }

    }

    public void EditarRecursosHumanos(JTable tablaRecursosHumanos) {

        // Limpieza del archivo .txt

        try {
            PrintWriter writer = new PrintWriter("RecursosHumanos.txt");
            writer.print("");
            writer.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un problema" + e.toString());
        }

        // Creación de los nuevos registros luego de la eliminación

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("RecursosHumanos.txt")))) {
            StringJoiner joiner = new StringJoiner(",");
            for (int col = 0; col < tablaRecursosHumanos.getColumnCount(); col++) {
                joiner.add(tablaRecursosHumanos.getColumnName(col));
            }

            System.out.println(joiner.toString());
            bw.write(joiner.toString());
            bw.newLine();

            for (int row = 0; row < tablaRecursosHumanos.getRowCount(); row++) {
                joiner = new StringJoiner(",");
                for (int col = 0; col < tablaRecursosHumanos.getColumnCount(); col++) {

                    Object obj = tablaRecursosHumanos.getValueAt(row, col);
                    String value = obj == null ? "null" : obj.toString();
                    joiner.add(value);

                }

                System.out.println(joiner.toString());
                bw.write(joiner.toString());
                bw.newLine();
                // JOptionPane.showMessageDialog(null, "Se modificó correctamente");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error");
        }

    }
}
