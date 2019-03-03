package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Controller.ControleCoordenador;
import Controller.ControleLaboratório;
import dao.CoordenadorDAO;
import model.Coordenador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Panel;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.ComponentOrientation;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaAdministrador extends JFrame {

	private JPanel contentPane;
	private JTextField NomeCoordenadorTextField;
	private JTextField NumeroBuscarLaboratorioTextField;
	private JTable JTableCoordenadores;
	private JTextField UsárioCoordenadorField;
	private JTextField SenhaCoordenadorField;
	private JTable LaboratórioTable;
	private JTextField NumeroLaboratórioField;
	private JTextField NomeLaboratórioField;
	private JTextField IdCoordenadorField;
	private JTextField IdLaboratorioField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAdministrador frame = new TelaAdministrador();
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
	public TelaAdministrador() {
		ControleCoordenador controleCoordenador = new ControleCoordenador();
		ControleLaboratório controleLaboratório = new ControleLaboratório();
		
		setMaximumSize(new Dimension(1920, 1080));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		panel.setBackground(UIManager.getColor("MenuItem.disabledForeground"));
		panel.setBounds(0, 0, 1350, 35);
		contentPane.add(panel);
		
		JLabel lblAdministrador = new JLabel("Administrador");
		lblAdministrador.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		panel.add(lblAdministrador);
		
		JLabel lblCoordenador = new JLabel("Coordenador:");
		lblCoordenador.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCoordenador.setBounds(51, 116, 118, 14);
		contentPane.add(lblCoordenador);
		
		JLabel BuscarLabel = new JLabel("Buscar:");
		BuscarLabel.setBounds(51, 65, 53, 14);
		contentPane.add(BuscarLabel);
		
		NomeCoordenadorTextField = new JTextField();
		NomeCoordenadorTextField.setBounds(114, 62, 197, 20);
		contentPane.add(NomeCoordenadorTextField);
		NomeCoordenadorTextField.setColumns(10);
		
		JButton BuscarCoordenadorBtn = new JButton("Buscar");
		BuscarCoordenadorBtn.setBounds(321, 61, 89, 23);
		contentPane.add(BuscarCoordenadorBtn);
		
		JLabel lblBuscar = new JLabel("Buscar:");
		lblBuscar.setBounds(715, 65, 46, 14);
		contentPane.add(lblBuscar);
		
		NumeroBuscarLaboratorioTextField = new JTextField();
		NumeroBuscarLaboratorioTextField.setBounds(771, 62, 197, 20);
		contentPane.add(NumeroBuscarLaboratorioTextField);
		NumeroBuscarLaboratorioTextField.setColumns(10);
		
		JButton BuscarAdministradorBtn = new JButton("Buscar");
		BuscarAdministradorBtn.setBounds(996, 61, 89, 23);
		contentPane.add(BuscarAdministradorBtn);
		
		JLabel lblAdministrador_1 = new JLabel("Laborat\u00F3rio:");
		lblAdministrador_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAdministrador_1.setBounds(715, 116, 95, 14);
		contentPane.add(lblAdministrador_1);
		
		JLabel idCoordenadorLabel = new JLabel("Id:");
		idCoordenadorLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		idCoordenadorLabel.setBounds(36, 530, 46, 14);
		idCoordenadorLabel.setVisible(false);
		contentPane.add(idCoordenadorLabel);
		
		JLabel IdLaboratorioLabel = new JLabel("Id:");
		IdLaboratorioLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		IdLaboratorioLabel.setBounds(715, 525, 46, 14);
		IdLaboratorioLabel.setVisible(false);
		contentPane.add(IdLaboratorioLabel);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controleCoordenador.readJtableCoordenador(JTableCoordenadores);
				controleLaboratório.readJtableLaboratório(LaboratórioTable);
				UsárioCoordenadorField.setText("");
				SenhaCoordenadorField.setText("");
				if(idCoordenadorLabel.isVisible()) {
					idCoordenadorLabel.setVisible(false);
				}
				IdCoordenadorField.setText("");
				if(IdCoordenadorField.isVisible()) {
					IdCoordenadorField.setVisible(false);
				}
				NomeLaboratórioField.setText("");
				NumeroLaboratórioField.setText("");
				if(IdLaboratorioLabel.isVisible()) {
					IdLaboratorioLabel.setVisible(false);
				}
				if(IdLaboratorioField.isVisible()) {
					IdLaboratorioField.setVisible(false);
				}
				NomeCoordenadorTextField.setText("");
				NumeroBuscarLaboratorioTextField.setText("");
			}
			
		});
		btnRefresh.setBounds(573, 61, 89, 23);
		contentPane.add(btnRefresh);
			
		JTableCoordenadores = new JTable();
		JTableCoordenadores.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Usu\u00E1rio", "Senha"
			}
		));
		JTableCoordenadores.setBounds(51, 141, 518, 321);
		contentPane.add(JTableCoordenadores);
		JTableCoordenadores.setVisible(true);
		JScrollPane scroller = new JScrollPane(JTableCoordenadores);
		scroller.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
					// PASSANDO VALORES DA TABELA PARA OS CAMPOS 
					int index = JTableCoordenadores.getSelectedRow();
					TableModel model = JTableCoordenadores.getModel();
					String idCoordenador = model.getValueAt(index, 0).toString();
					String UsuárioCoordenador = model.getValueAt(index, 1).toString();
					String SenhaCoordenador = model.getValueAt(index, 2).toString();
					UsárioCoordenadorField.setText(UsuárioCoordenador);
					SenhaCoordenadorField.setText(SenhaCoordenador);
					IdCoordenadorField.setText(idCoordenador);
					IdCoordenadorField.setVisible(true);
					idCoordenadorLabel.setVisible(true);
			}
		});
		scroller.setVisible(true);
		scroller.setBounds(51, 141, 518, 321);
		this.getContentPane().add(scroller);
		//preenche a tabela coordenadores com os dados do banco
		controleCoordenador.readJtableCoordenador(JTableCoordenadores);
		
		JLabel LabelUsuárioCoordenador = new JLabel("Usu\u00E1rio: ");
		LabelUsuárioCoordenador.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LabelUsuárioCoordenador.setBounds(36, 555, 61, 14);
		contentPane.add(LabelUsuárioCoordenador);
		
		UsárioCoordenadorField = new JTextField();
		UsárioCoordenadorField.setBounds(110, 554, 164, 23);
		contentPane.add(UsárioCoordenadorField);
		UsárioCoordenadorField.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSenha.setBounds(36, 586, 46, 14);
		contentPane.add(lblSenha);
		
		SenhaCoordenadorField = new JTextField();
		SenhaCoordenadorField.setColumns(10);
		SenhaCoordenadorField.setBounds(110, 585, 164, 23);
		contentPane.add(SenhaCoordenadorField);
		
		JButton SalvarCoordenadorBtn = new JButton("Salvar");
		SalvarCoordenadorBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(idCoordenadorLabel.isVisible()) {
					int idCoordenador = Integer.parseInt(IdCoordenadorField.getText());
					controleCoordenador.atualizarCoordenador(idCoordenador, UsárioCoordenadorField.getText(), SenhaCoordenadorField.getText());
				}else {
					controleCoordenador.inserirCoordenador(UsárioCoordenadorField.getText(), SenhaCoordenadorField.getText());
				}
				controleCoordenador.readJtableCoordenador(JTableCoordenadores);
				
			}
		});
		SalvarCoordenadorBtn.setBounds(51, 635, 89, 23);
		contentPane.add(SalvarCoordenadorBtn);
		
		JButton DeletarCoordenadorBtn = new JButton("Deletar");
		DeletarCoordenadorBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(idCoordenadorLabel.isVisible()) {
				int idCoordenador = Integer.parseInt(IdCoordenadorField.getText());
				controleCoordenador.deletarCoordenador(idCoordenador);
				controleCoordenador.readJtableCoordenador(JTableCoordenadores);
				idCoordenadorLabel.setVisible(false);
				IdCoordenadorField.setVisible(false);
				IdCoordenadorField.setText("");
				}else {
					JOptionPane.showMessageDialog(null,"Nenhum coordenador selecionado");
				}
				}
		});
		DeletarCoordenadorBtn.setBounds(185, 635, 89, 23);
		contentPane.add(DeletarCoordenadorBtn);
		
		LaboratórioTable = new JTable();
		LaboratórioTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Numero", "Nome"
			}
		));
		LaboratórioTable.setBounds(715, 141, 597, 321);
		contentPane.add(LaboratórioTable);
		
		JScrollPane scrollerLaboratorio = new JScrollPane(LaboratórioTable);
		scrollerLaboratorio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int index = LaboratórioTable.getSelectedRow();
				TableModel model = LaboratórioTable.getModel();
				String idLaboratorio = model.getValueAt(index, 0).toString();
				String Numero = model.getValueAt(index, 1).toString();
				String nome = model.getValueAt(index, 2).toString();
				IdLaboratorioField.setVisible(true);
				IdLaboratorioLabel.setVisible(true);
				IdLaboratorioField.setText(idLaboratorio);
				NumeroLaboratórioField.setText(Numero);
				NomeLaboratórioField.setText(nome);
			}
		});
		scrollerLaboratorio.setVisible(true);
		scrollerLaboratorio.setBounds(715, 141, 597, 321);
		getContentPane().add(scrollerLaboratorio);
		controleLaboratório.readJtableLaboratório(LaboratórioTable);
		
		JLabel NumeroLaboratorio = new JLabel("N\u00FAmero: ");
		NumeroLaboratorio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		NumeroLaboratorio.setBounds(715, 555, 61, 14);
		contentPane.add(NumeroLaboratorio);
		
		NumeroLaboratórioField = new JTextField();
		NumeroLaboratórioField.setColumns(10);
		NumeroLaboratórioField.setBounds(786, 553, 164, 23);
		NumeroLaboratórioField.setDocument(new ControleEntrada());
		contentPane.add(NumeroLaboratórioField);
		
		JLabel NomeLaboratório = new JLabel("Nome:");
		NomeLaboratório.setFont(new Font("Tahoma", Font.PLAIN, 14));
		NomeLaboratório.setBounds(715, 586, 46, 14);
		contentPane.add(NomeLaboratório);
		
		NomeLaboratórioField = new JTextField();
		NomeLaboratórioField.setColumns(10);
		NomeLaboratórioField.setBounds(786, 584, 164, 23);
		contentPane.add(NomeLaboratórioField);
		
		JButton SalvarLaboratório = new JButton("Salvar");
		SalvarLaboratório.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i = Integer.parseInt(NumeroLaboratórioField.getText());
				if(IdLaboratorioLabel.isVisible()) {
					int Idlaboratorio = Integer.parseInt(IdLaboratorioField.getText());
					controleLaboratório.AtualizarLaboratório(Idlaboratorio, i, NomeLaboratórioField.getText());
				}else {
					
					controleLaboratório.inserirLaboratório(i, NomeLaboratórioField.getText());
				 }
				 controleLaboratório.readJtableLaboratório(LaboratórioTable);
			}
		});
		SalvarLaboratório.setBounds(715, 635, 89, 23);
		contentPane.add(SalvarLaboratório);
		
		JButton DeletarLaboratório = new JButton("Deletar");
		DeletarLaboratório.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(IdLaboratorioLabel.isVisible()) {
				int idlaboratório = Integer.parseInt(IdLaboratorioField.getText());
				controleLaboratório.DeletarLaboratório(idlaboratório);
				controleLaboratório.readJtableLaboratório(LaboratórioTable);
				NomeLaboratórioField.setText("");
				NumeroLaboratórioField.setText("");
				IdLaboratorioLabel.setVisible(false);
				IdLaboratorioField.setVisible(false);
				IdLaboratorioField.setText("");
			}else {
				JOptionPane.showMessageDialog(null, "Nenhum laboratório selecionado");
			}
				}
		});
		DeletarLaboratório.setBounds(861, 635, 89, 23);
		contentPane.add(DeletarLaboratório);
		
		IdCoordenadorField = new JTextField();
		IdCoordenadorField.setEditable(false);
		IdCoordenadorField.setBounds(110, 523, 163, 23);
		IdCoordenadorField.setVisible(false);
		contentPane.add(IdCoordenadorField);
		IdCoordenadorField.setColumns(10);
		
		IdLaboratorioField = new JTextField();
		IdLaboratorioField.setEditable(false);
		IdLaboratorioField.setColumns(10);
		IdLaboratorioField.setBounds(786, 523, 164, 23);
		IdLaboratorioField.setVisible(false);
		contentPane.add(IdLaboratorioField);
	}
	
}
