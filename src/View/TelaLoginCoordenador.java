package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Controller.ControleCoordenador;
import Controller.ControlerAdministrador;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
/*
 * @author Matheus Levy
 * @GitHub github.com/MatheusLevy
 */

public class TelaLoginCoordenador extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField SenhaField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLoginCoordenador frame = new TelaLoginCoordenador();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaLoginCoordenador() {
		ControlerAdministrador controleAdministrador = ControlerAdministrador.getInstance();
		ControleCoordenador controleCoordenador = ControleCoordenador.getInstance();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel UsuarioLabel = new JLabel("Usu\u00E1rio :");
		UsuarioLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		UsuarioLabel.setBounds(43, 71, 71, 27);
		contentPane.add(UsuarioLabel);
		
		JLabel SenhaLabel = new JLabel("Senha :");
		SenhaLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		SenhaLabel.setBounds(43, 122, 58, 14);
		contentPane.add(SenhaLabel);
		
		JFormattedTextField UsuarioTextField = new JFormattedTextField();
		UsuarioTextField.setBounds(128, 76, 208, 27);
		contentPane.add(UsuarioTextField);
		
		SenhaField = new JPasswordField();
		SenhaField.setBounds(128, 118, 208, 27);
		contentPane.add(SenhaField);
		
		JCheckBox CheckBoxAdministrador = new JCheckBox("Administrador");
		CheckBoxAdministrador.setBounds(56, 28, 123, 23);
		contentPane.add(CheckBoxAdministrador);
		
		//BOT�O LOGIN
		JButton LoginBtn = new JButton("Login");
		LoginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			if(CheckBoxAdministrador.isSelected()) {
				String senha = new String(SenhaField.getPassword());
				if(controleAdministrador.autenticar(UsuarioTextField.getText(), senha))
					dispose();
				}else {
					String senha = new String(SenhaField.getPassword());
					if(controleCoordenador.autenticar(UsuarioTextField.getText(), senha)) {
						dispose();
				}
			}
		}
		});
		
		LoginBtn.setBounds(161, 170, 109, 33);
		contentPane.add(LoginBtn);
		
	}
}
