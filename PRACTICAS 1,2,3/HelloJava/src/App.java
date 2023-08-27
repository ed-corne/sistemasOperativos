import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame implements ActionListener {
    JLabel lbNombre;
    JTextField txtNombre;
    JButton btnVer;

    public App() {
        this.setBounds(0, 0, 300, 300);
        this.setLayout(null);
        lbNombre = new JLabel();
        lbNombre.setBounds(10, 10, 150, 20);
        lbNombre.setName("lbNombre");
        lbNombre.setText("Ingrese Nombre");
        lbNombre.setVisible(true);
        add(lbNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(10, 30, 150, 20);
        txtNombre.setName("txtNombre");
        txtNombre.setText(" ");
        txtNombre.setVisible(true);
        add(txtNombre);

        btnVer = new JButton();
        btnVer.setBounds(10, 80, 100, 20);
        btnVer.setName("btnVer");
        btnVer.setText("Ver Mensage");
        btnVer.setVisible(true);
        btnVer.addActionListener(this);
        add(btnVer);
        this.setVisible(true);

    }

    public void Mensage() {
        JOptionPane.showMessageDialog(this, "Hola: " + txtNombre.getText());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnVer) {
            // Handle button click event here
            Mensage();
        }
    }

    public static void main(String[] args) {
        new App();
    }
}
