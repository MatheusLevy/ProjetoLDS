package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.ControleLaboratório;

public class TelaCoordenador extends JFrame {

	private JPanel contentPane;
	private JTextField NumeroLaboratorioField;
	private JTable JTableLaboratorios;
	private JLabel LaboratoriosLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCoordenador frame = new TelaCoordenador();
					frame.setVisible(true);
					frame.setExtendedState(MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCoordenador() {
		ControleLaboratório controleLaboratorios = new ControleLaboratório();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1336, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBuscar = new JLabel("Buscar:");
		lblBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBuscar.setBounds(248, 44, 46, 14);
		contentPane.add(lblBuscar);
		
		NumeroLaboratorioField = new JTextField();
		NumeroLaboratorioField.setBounds(312, 43, 162, 20);
		contentPane.add(NumeroLaboratorioField);
		NumeroLaboratorioField.setColumns(10);
		
		JButton BuscarLaboratorioBtn = new JButton("Buscar");
		BuscarLaboratorioBtn.setBounds(497, 42, 89, 23);
		contentPane.add(BuscarLaboratorioBtn);
		
		JTableLaboratorios = new JTable();
		JTableLaboratorios.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "N\u00FAmero", "Nome"
			}
		));
		JTableLaboratorios.setBounds(31, 137, 565, 561);
		contentPane.add(JTableLaboratorios);
		JTableLaboratorios.setVisible(true);
		
		JScrollPane scroller = new JScrollPane(JTableLaboratorios);
		scroller.setVisible(true);
		scroller.setBounds(252, 129, 813, 561);
		this.getContentPane().add(scroller);
		
		controleLaboratorios.readJtableLaboratório(JTableLaboratorios);
		
		LaboratoriosLabel = new JLabel("Laborat\u00F3rios:");
		LaboratoriosLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		LaboratoriosLabel.setBounds(252, 94, 105, 14);
		contentPane.add(LaboratoriosLabel);
	}
}
