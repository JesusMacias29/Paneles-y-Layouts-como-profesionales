import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GestorUsuarios {
    private JFrame frame;
    private JTextField tfNombre, tfEmail;
    private JComboBox<String> cbRol;
    private JCheckBox chActivo;
    private JTextArea taNotas;
    private JButton btnGuardar;

    public GestorUsuarios() {
        // JFrame principal
        frame = new JFrame("Gestor de usuarios");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 600);
        frame.setLayout(new BorderLayout(5,5));

        // ------------------- Header -------------------
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblHeader = new JLabel("Gestor de usuarios");
        lblHeader.setFont(new Font("Arial", Font.BOLD, 18));
        headerPanel.add(lblHeader);
        frame.add(headerPanel, BorderLayout.NORTH);

        // ------------------- Navegación -------------------
        JPanel navPanel = new JPanel(new GridLayout(5,1,0,5));
        String[] botones = {"Dashboard", "Usuarios", "Informes", "Ajustes", "Ayuda"};
        for(String b : botones){
            JButton btn = new JButton(b);
            navPanel.add(btn);
        }
        frame.add(navPanel, BorderLayout.WEST);

        // ------------------- Formulario -------------------
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.anchor = GridBagConstraints.WEST;

        // Nombre
        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0; gbc.fill = GridBagConstraints.NONE;
        formPanel.add(new JLabel("Nombre:"), gbc);
        tfNombre = new JTextField(20);
        gbc.gridx = 1; gbc.weightx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(tfNombre, gbc);

        // Email
        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0; gbc.fill = GridBagConstraints.NONE;
        formPanel.add(new JLabel("Email:"), gbc);
        tfEmail = new JTextField(20);
        gbc.gridx = 1; gbc.weightx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(tfEmail, gbc);

        // Rol
        gbc.gridx = 0; gbc.gridy = 2; gbc.weightx = 0; gbc.fill = GridBagConstraints.NONE;
        formPanel.add(new JLabel("Rol:"), gbc);
        cbRol = new JComboBox<>(new String[]{"Admin","Editor","Invitado"});
        gbc.gridx = 1; gbc.weightx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(cbRol, gbc);

        // Activo
        gbc.gridx = 0; gbc.gridy = 3; gbc.weightx = 0; gbc.fill = GridBagConstraints.NONE;
        formPanel.add(new JLabel("Activo:"), gbc);
        chActivo = new JCheckBox();
        gbc.gridx = 1; gbc.weightx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(chActivo, gbc);

        // Notas
        gbc.gridx = 0; gbc.gridy = 4; gbc.weightx = 0; gbc.weighty = 0; gbc.fill = GridBagConstraints.NONE;
        formPanel.add(new JLabel("Notas:"), gbc);
        taNotas = new JTextArea(5,20);
        JScrollPane scrollNotas = new JScrollPane(taNotas);
        gbc.gridx = 1; gbc.weightx = 1; gbc.weighty = 1; gbc.fill = GridBagConstraints.BOTH;
        formPanel.add(scrollNotas, gbc);

        frame.add(formPanel, BorderLayout.CENTER);

        // ------------------- Previsualización -------------------
        JPanel previewPanel = new JPanel(new BorderLayout());
        previewPanel.setPreferredSize(new Dimension(260,0));
        JTabbedPane tabbedPane = new JTabbedPane();

        JTextArea taResumen = new JTextArea();
        taResumen.setEditable(false);
        tabbedPane.addTab("Resumen", new JScrollPane(taResumen));

        JTextArea taLogs = new JTextArea();
        taLogs.setEditable(false);
        tabbedPane.addTab("Logs", new JScrollPane(taLogs));

        previewPanel.add(tabbedPane, BorderLayout.CENTER);
        frame.add(previewPanel, BorderLayout.EAST);

        // ------------------- Botonera -------------------
        JPanel buttonBar = new JPanel(new FlowLayout(FlowLayout.RIGHT,5,5));
        JButton btnCancelar = new JButton("Cancelar");
        JButton btnLimpiar = new JButton("Limpiar");
        btnGuardar = new JButton("Guardar");

        buttonBar.add(btnCancelar);
        buttonBar.add(btnLimpiar);
        buttonBar.add(btnGuardar);
        frame.add(buttonBar, BorderLayout.SOUTH);

        // ------------------- Eventos -------------------
        btnGuardar.addActionListener(this::abrirDialogConfirmacion);
        btnLimpiar.addActionListener(e -> limpiarFormulario());
        btnCancelar.addActionListener(e -> frame.dispose());

        // Mostrar ventana
        frame.setVisible(true);
    }

    // Limpiar formulario
    private void limpiarFormulario() {
        tfNombre.setText("");
        tfEmail.setText("");
        cbRol.setSelectedIndex(0);
        chActivo.setSelected(false);
        taNotas.setText("");
    }

    // Diálogo modal de confirmación
    private void abrirDialogConfirmacion(ActionEvent e) {
        JDialog dialog = new JDialog(frame, "Confirmación", true);
        dialog.setLayout(new BorderLayout(10,10));
        JLabel lbl = new JLabel("¿Guardar cambios?");
        lbl.setBorder(BorderFactory.createEmptyBorder(10,10,0,10));
        dialog.add(lbl, BorderLayout.CENTER);

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton aceptar = new JButton("Aceptar");
        JButton cancelar = new JButton("Cancelar");
        buttons.add(aceptar);
        buttons.add(cancelar);
        dialog.add(buttons, BorderLayout.SOUTH);

        aceptar.addActionListener(ev -> {
            JOptionPane.showMessageDialog(frame,"Datos guardados (simulado).");
            dialog.dispose();
        });
        cancelar.addActionListener(ev -> dialog.dispose());

        dialog.pack();
        dialog.setLocationRelativeTo(frame);
        dialog.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GestorUsuarios::new);
    }
}

