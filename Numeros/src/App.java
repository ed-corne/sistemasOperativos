import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame implements ActionListener {
    JLabel lblNumero;
    JTextField txtNumero;
    JButton btnVer;

    public App(){
        this.setBounds(0, 0, 300, 500);
        this.setLayout(null);

        txtNumero = new JTextField();
        txtNumero.setBounds(10, 30, 150, 20);
        txtNumero.setName("txtNumero");
        txtNumero.setText(" ");
        txtNumero.setVisible(true);
        add(txtNumero);

        lblNumero = new JLabel();
        lblNumero.setBounds(10, 60, 150, 20);
        lblNumero.setName("lbNumero");
        lblNumero.setText("Ingrese Numero");
        lblNumero.setVisible(true);
        add(lblNumero);

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
        JOptionPane.showMessageDialog(this, "El numero ingresado es: " + txtNumero.getText());
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
