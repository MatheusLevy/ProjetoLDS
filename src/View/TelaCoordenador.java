package View;

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
import javax.swing.table.TableModel;

import Controller.ControleCoordenador;
import Controller.ControleHorario;
import Controller.ControleLaboratório;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/*
 * @author Matheus Levy
 * @GitHub github.com/MatheusLevy
 */

public class TelaCoordenador extends JFrame {

	private static final long serialVersionUID = 1L;
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
		ControleLaboratório controleLaboratorios = ControleLaboratório.getInstance();
		ControleHorario controleHorario = ControleHorario.getInstance();
		
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
		NumeroLaboratorioField.setBounds(312, 43, 162, 23);
		contentPane.add(NumeroLaboratorioField);
		NumeroLaboratorioField.setColumns(10);
		
		JButton BuscarLaboratorioBtn = new JButton("Buscar");
		BuscarLaboratorioBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int NumeroLaboratorio = Integer.parseInt(NumeroLaboratorioField.getText());
				controleLaboratorios.BuscarLaboratório(NumeroLaboratorio, JTableLaboratorios);
			}
		});
		BuscarLaboratorioBtn.setBounds(497, 42, 115, 23);
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
		scroller.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int index = JTableLaboratorios.getSelectedRow();
				TableModel model = JTableLaboratorios.getModel();
				String idLaboratorio = model.getValueAt(index, 0).toString();
				String Numero = model.getValueAt(index, 1).toString();
				String Nome = model.getValueAt(index, 2).toString();
				controleHorario.AbrirHorarios(idLaboratorio, Nome, Numero);
			}
		});
		scroller.setVisible(true);
		scroller.setBounds(252, 129, 813, 561);
		this.getContentPane().add(scroller);
		
		controleLaboratorios.readJtableLaboratório(JTableLaboratorios);
		
		LaboratoriosLabel = new JLabel("Laborat\u00F3rios:");
		LaboratoriosLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		LaboratoriosLabel.setBounds(252, 94, 105, 14);
		contentPane.add(LaboratoriosLabel);
		
		JButton LogoutBtn = new JButton("Logout");
		LogoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ControleCoordenador().Logout();
				dispose();
			}
		});
		LogoutBtn.setBounds(1202, 677, 89, 23);
		contentPane.add(LogoutBtn);
		
		JButton VerTodosBtn = new JButton("Ver Todos");
		VerTodosBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controleLaboratorios.readJtableLaboratório(JTableLaboratorios);
			}
		});
		VerTodosBtn.setBounds(497, 76, 115, 23);
		contentPane.add(VerTodosBtn);
	}
}
