import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class App extends JFrame implements ActionListener {
    JLabel lblDisplay, lblDisplay2;
    JTextField txtDisplay, txtDisplay2;
    JButton btnDec_Bin, btnBin_Dec;

    // Crear nuevos componentes para octal
    JLabel lblDisplayOctal, lblDisplayOctal2;
    JTextField txtDisplayOctal, txtDisplayOctal2;
    JButton btnDec_Oct, btnOct_Dec;

    // Crear nuevos componentes para hexadecimal
    JLabel lblDisplayHex, lblDisplayHex2;
    JTextField txtDisplayHex, txtDisplayHex2;
    JButton btnDec_Hex, btnHex_Dec;

    public App() {
        this.setBounds(0, 0, 500, 500);
        this.setLayout(null);

        lblDisplay = new JLabel();
        lblDisplay.setBounds(10, 30, 150, 20);
        lblDisplay.setName("lbNumero");
        lblDisplay.setText("Ingrese Numero Decimal");
        lblDisplay.setVisible(true);
        add(lblDisplay);

        txtDisplay = new JTextField();
        txtDisplay.setBounds(10, 60, 150, 20);
        txtDisplay.setName("txtDisplay");
        txtDisplay.setText(" ");
        txtDisplay.setVisible(true);
        add(txtDisplay);

        btnDec_Bin = new JButton();
        btnDec_Bin.setBounds(10, 90, 100, 20);
        btnDec_Bin.setName("btnDec_Bin");
        btnDec_Bin.setText("DEC-BIN");
        btnDec_Bin.setVisible(true);
        btnDec_Bin.addActionListener(this);
        add(btnDec_Bin);
        this.setVisible(true);

        // bin to dec

        lblDisplay2 = new JLabel();
        lblDisplay2.setBounds(250, 30, 150, 20);
        lblDisplay2.setName("lblNumero2");
        lblDisplay2.setText("Ingrese Numero Binario");
        lblDisplay2.setVisible(true);
        add(lblDisplay2);

        txtDisplay2 = new JTextField();
        txtDisplay2.setBounds(250, 60, 150, 20);
        txtDisplay2.setName("txtDisplay2");
        txtDisplay2.setText("");
        txtDisplay2.setVisible(true);
        add(txtDisplay2);

        btnBin_Dec = new JButton();
        btnBin_Dec.setBounds(250, 90, 100, 20);
        btnBin_Dec.setName("btnBin_Dec");
        btnBin_Dec.setText("BIN-DEC");
        btnBin_Dec.setVisible(true);
        btnBin_Dec.addActionListener(this);
        add(btnBin_Dec);
        this.setVisible(true);

        // Crear componentes para octal
        lblDisplayOctal = new JLabel();
        lblDisplayOctal.setBounds(10, 120, 150, 20);
        lblDisplayOctal.setName("lblNumeroOctal");
        lblDisplayOctal.setText("Ingrese Número Decimal");
        lblDisplayOctal.setVisible(true);
        add(lblDisplayOctal);

        txtDisplayOctal = new JTextField();
        txtDisplayOctal.setBounds(10, 150, 150, 20);
        txtDisplayOctal.setName("txtDisplayOctal");
        txtDisplayOctal.setText("");
        txtDisplayOctal.setVisible(true);
        add(txtDisplayOctal);

        btnDec_Oct = new JButton();
        btnDec_Oct.setBounds(10, 180, 100, 20);
        btnDec_Oct.setName("btnDec_Oct");
        btnDec_Oct.setText("DEC-OCT");
        btnDec_Oct.setVisible(true);
        btnDec_Oct.addActionListener(this);
        add(btnDec_Oct);

        lblDisplayOctal2 = new JLabel();
        lblDisplayOctal2.setBounds(250, 120, 150, 20);
        lblDisplayOctal2.setName("lblNumeroOctal2");
        lblDisplayOctal2.setText("Ingrese Número Octal");
        lblDisplayOctal2.setVisible(true);
        add(lblDisplayOctal2);

        txtDisplayOctal2 = new JTextField();
        txtDisplayOctal2.setBounds(250, 150, 150, 20);
        txtDisplayOctal2.setName("txtDisplayOctal2");
        txtDisplayOctal2.setText("");
        txtDisplayOctal2.setVisible(true);
        add(txtDisplayOctal2);

        btnOct_Dec = new JButton();
        btnOct_Dec.setBounds(250, 180, 100, 20);
        btnOct_Dec.setName("btnOct_Dec");
        btnOct_Dec.setText("OCT-DEC");
        btnOct_Dec.setVisible(true);
        btnOct_Dec.addActionListener(this);
        add(btnOct_Dec);

        // Crear componentes para hexadecimal
        lblDisplayHex = new JLabel();
        lblDisplayHex.setBounds(10, 210, 150, 20);
        lblDisplayHex.setName("lblNumeroHex");
        lblDisplayHex.setText("Ingrese Número Decimal");
        lblDisplayHex.setVisible(true);
        add(lblDisplayHex);

        txtDisplayHex = new JTextField();
        txtDisplayHex.setBounds(10, 240, 150, 20);
        txtDisplayHex.setName("txtDisplayHex");
        txtDisplayHex.setText("");
        txtDisplayHex.setVisible(true);
        add(txtDisplayHex);

        btnDec_Hex = new JButton();
        btnDec_Hex.setBounds(10, 270, 100, 20);
        btnDec_Hex.setName("btnDec_Hex");
        btnDec_Hex.setText("DEC-HEX");
        btnDec_Hex.setVisible(true);
        btnDec_Hex.addActionListener(this);
        add(btnDec_Hex);

        lblDisplayHex2 = new JLabel();
        lblDisplayHex2.setBounds(250, 210, 150, 20);
        lblDisplayHex2.setName("lblNumeroHex2");
        lblDisplayHex2.setText("Ingrese Número Hexadecimal");
        lblDisplayHex2.setVisible(true);
        add(lblDisplayHex2);

        txtDisplayHex2 = new JTextField();
        txtDisplayHex2.setBounds(250, 240, 150, 20);
        txtDisplayHex2.setName("txtDisplayHex2");
        txtDisplayHex2.setText("");
        txtDisplayHex2.setVisible(true);
        add(txtDisplayHex2);

        btnHex_Dec = new JButton();
        btnHex_Dec.setBounds(250, 270, 100, 20);
        btnHex_Dec.setName("btnHex_Dec");
        btnHex_Dec.setText("HEX-DEC");
        btnHex_Dec.setVisible(true);
        btnHex_Dec.addActionListener(this);
        add(btnHex_Dec);

    }

    public String Dec_Bin(double numero) {
        String binario = "";
        int cociente = 0, residuo = 0;

        while (numero / 2 >= 1) {
            cociente = (int) numero / 2;
            residuo = (int) numero % 2;
            numero = cociente;
            binario = residuo + binario;
        }
        binario = cociente + binario;
        return binario;
    }

    public double Bin_Dec(String binario) {
        int longitud = binario.length();
        double decimal = 0;

        for (int i = 0; i < longitud; i++) {
            char digito = binario.charAt(i);

            // Verificamos si el dígito es '0' o '1'
            if (digito == '0') {
                // Si es '0', no hacemos nada, ya que su contribución al decimal es 0.
            } else if (digito == '1') {
                // Si es '1', agregamos 2^posición al decimal, donde posición es la posición del
                // dígito desde la derecha.
                decimal += Math.pow(2, longitud - 1 - i);
            } else {
                // Si el dígito no es '0' ni '1', la cadena no es un número binario válido.
                throw new IllegalArgumentException("La cadena no es un número binario válido.");
            }
        }

        return decimal;
    }

    // Función para convertir de decimal a octal
    public String Dec_Oct(double numero) {
        // Utiliza la función toOctalString de Java para la conversión
        return Integer.toOctalString((int) numero);
    }

    // Función para convertir de octal a decimal
    public double Oct_Dec(String octal) {
        // Utiliza la función parseInt de Java con base 8 para la conversión
        return Integer.parseInt(octal, 8);
    }

    // Función para convertir de decimal a hexadecimal
    public String Dec_Hex(double numero) {
        // Usamos BigDecimal para obtener una representación hexadecimal legible
        BigDecimal bd = new BigDecimal(numero);
        return bd.toBigInteger().toString(16);
    }

    // Función para convertir de hexadecimal a decimal
    public double Hex_Dec(String hexadecimal) {
        // Usamos BigDecimal para realizar la conversión
        BigDecimal bd = new BigDecimal(new java.math.BigInteger(hexadecimal, 16));
        return bd.doubleValue();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnDec_Bin) {
            // Handle button click event here
            lblDisplay.setText(Dec_Bin(Double.parseDouble(txtDisplay.getText())));
        }

        if (e.getSource() == btnBin_Dec) {
            // Handle button click event here
            lblDisplay2.setText(String.valueOf(Bin_Dec(txtDisplay2.getText())));

        }

        if (e.getSource() == btnDec_Oct) {
            lblDisplayOctal.setText(Dec_Oct(Double.parseDouble(txtDisplayOctal.getText())));
        }

        if (e.getSource() == btnOct_Dec) {
            lblDisplayOctal2.setText(String.valueOf(Oct_Dec(txtDisplayOctal2.getText())));
        }

        if (e.getSource() == btnDec_Hex) {
            lblDisplayHex.setText(Dec_Hex(Double.parseDouble(txtDisplayHex.getText())));
        }

        if (e.getSource() == btnHex_Dec) {
            lblDisplayHex2.setText(String.valueOf(Hex_Dec(txtDisplayHex2.getText())));
        }
    }

    public static void main(String[] args) throws Exception {
        new App();
    }
}
