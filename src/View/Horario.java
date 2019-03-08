package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Controller.ControleHorario;
import model.Laboratorio;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/*
 * @author Matheus Levy
 * @GitHub github.com/MatheusLevy
 */

public class Horario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField NomeLaboratorioField;
	private JTable HorárioTable;
	private JLabel lblHorrio;
	private JTextField HorarioField;
	private JTextField NumeroLaboratorioField;
	private JTextField SegundaField;
	private JTextField TerçaField;
	private JTextField QuartaField;
	private JTextField QuintaField;
	private JTextField SextaField;
	private JLabel IdLabel;
	private JTextField idField;
	private JButton DeletarBtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Horario frame = new Horario();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Horario(Laboratorio lab) {
		ControleHorario controleHorario = ControleHorario.getInstance();
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 854, 669);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLaboratrio = new JLabel("Laborat\u00F3rio:");
		lblLaboratrio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLaboratrio.setBounds(10, 21, 83, 14);
		contentPane.add(lblLaboratrio);
		
		NomeLaboratorioField = new JTextField();
		NomeLaboratorioField.setBounds(91, 20, 124, 23);
		contentPane.add(NomeLaboratorioField);
		NomeLaboratorioField.setColumns(10);
		NomeLaboratorioField.setEditable(false);
		NomeLaboratorioField.setText(lab.getNome());
		
		HorárioTable = new JTable();
		HorárioTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "Hor\u00E1rios", "Segunda-feira", "Ter\u00E7a-feira", "Quarta-feira", "Quinta-Feira", "Sexta-Feira"
			}
		));
		HorárioTable.getColumnModel().getColumn(0).setPreferredWidth(0);
		HorárioTable.getColumnModel().getColumn(0).setMinWidth(0);
		HorárioTable.getColumnModel().getColumn(0).setMaxWidth(0);
		HorárioTable.getColumnModel().getColumn(1).setPreferredWidth(86);
		HorárioTable.setBounds(46, 88, 757, 337);
		contentPane.add(HorárioTable);
		
		JScrollPane scroller = new JScrollPane(HorárioTable);
		scroller.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// PASSANDO VALORES DA TABELA PARA OS CAMPOS 
				int index = HorárioTable.getSelectedRow();
				TableModel model = HorárioTable.getModel();
				String id = model.getValueAt(index, 0).toString();
				String Horário = model.getValueAt(index, 1).toString();
				String Segunda = model.getValueAt(index, 2).toString();
				String Terça = model.getValueAt(index, 3).toString();
				String Quarta = model.getValueAt(index, 4).toString();
				String Quinta = model.getValueAt(index, 5).toString();
				String Sexta = model.getValueAt(index, 6).toString();
				IdLabel.setVisible(true);
				idField.setVisible(true);
				idField.setText(id);
				HorarioField.setText(Horário);
				SegundaField.setText(Segunda);
				TerçaField.setText(Terça);
				QuartaField.setText(Quarta);
				QuintaField.setText(Quinta);
				SextaField.setText(Sexta);
			}
		});
		scroller.setVisible(true);
		scroller.setBounds(10, 88, 818, 337);
		this.getContentPane().add(scroller);
	
		controleHorario.readJtableHorario(HorárioTable, lab.getIdLaboratorio());
	
		lblHorrio = new JLabel("Hor\u00E1rio:");
		lblHorrio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHorrio.setBounds(10, 447, 57, 14);
		contentPane.add(lblHorrio);
		
		HorarioField = new JTextField();
		HorarioField.setBounds(77, 445, 83, 23);
		contentPane.add(HorarioField);
		HorarioField.setColumns(10);
		
		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumero.setBounds(32, 59, 61, 14);
		contentPane.add(lblNumero);
		
		NumeroLaboratorioField = new JTextField();
		NumeroLaboratorioField.setBounds(91, 59, 124, 23);
		contentPane.add(NumeroLaboratorioField);
		NumeroLaboratorioField.setColumns(10);
		NumeroLaboratorioField.setEditable(false);
		NumeroLaboratorioField.setText(""+lab.getNumero());
		
		JLabel lblSegunda = new JLabel("Segunda:");
		lblSegunda.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSegunda.setBounds(10, 478, 57, 14);
		contentPane.add(lblSegunda);
		
		SegundaField = new JTextField();
		SegundaField.setBounds(77, 476, 141, 23);
		contentPane.add(SegundaField);
		SegundaField.setColumns(10);
		
		JLabel lblTera = new JLabel("Ter\u00E7a:");
		lblTera.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTera.setBounds(10, 503, 46, 14);
		contentPane.add(lblTera);
		
		TerçaField = new JTextField();
		TerçaField.setBounds(77, 507, 141, 23);
		contentPane.add(TerçaField);
		TerçaField.setColumns(10);
		
		JLabel lblQuarta = new JLabel("Quarta:");
		lblQuarta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblQuarta.setBounds(10, 536, 46, 14);
		contentPane.add(lblQuarta);
		
		QuartaField = new JTextField();
		QuartaField.setBounds(77, 534, 141, 23);
		contentPane.add(QuartaField);
		QuartaField.setColumns(10);
		
		JLabel lblQuinta = new JLabel("Quinta:");
		lblQuinta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblQuinta.setBounds(10, 561, 46, 14);
		contentPane.add(lblQuinta);
		
		QuintaField = new JTextField();
		QuintaField.setBounds(78, 564, 141, 23);
		contentPane.add(QuintaField);
		QuintaField.setColumns(10);
		
		JLabel lblSexta = new JLabel("Sexta:");
		lblSexta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSexta.setBounds(10, 592, 46, 14);
		contentPane.add(lblSexta);
		
		SextaField = new JTextField();
		SextaField.setBounds(77, 590, 141, 23);
		contentPane.add(SextaField);
		SextaField.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(IdLabel.isVisible()) {
					int idHorario = Integer.parseInt(idField.getText().toString());
					String Horario = HorarioField.getText();
					String Segunda = SegundaField.getText();
					String Terça = TerçaField.getText();
					String Quarta = QuartaField.getText();
					String Quinta = QuintaField.getText();
					String Sexta = SextaField.getText();
					int NumeroLaboratorio = Integer.parseInt(NumeroLaboratorioField.getText());
					controleHorario.atualizar(idHorario, Horario, Segunda, Terça, Quarta, Quinta, Sexta, NumeroLaboratorio);
					idField.setVisible(false);
					IdLabel.setVisible(false);
					
				}else {
					String Horario = HorarioField.getText();
					String Segunda = SegundaField.getText();
					String Terça = TerçaField.getText();
					String Quarta = QuartaField.getText();
					String Quinta = QuintaField.getText();
					String Sexta = SextaField.getText();
					controleHorario.criarhorario(Horario, Segunda, Terça, Quarta, Quinta, Sexta, lab.getIdLaboratorio());
					
				}
				controleHorario.readJtableHorario(HorárioTable, lab.getIdLaboratorio());
				HorarioField.setText("");
				SegundaField.setText("");
				TerçaField.setText("");
				QuartaField.setText("");
				QuintaField.setText("");
				SextaField.setText("");
			}
		});
		btnSalvar.setBounds(264, 589, 89, 23);
		contentPane.add(btnSalvar);
		
		IdLabel = new JLabel("ID:");
		IdLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		IdLabel.setBounds(188, 448, 26, 14);
		IdLabel.setVisible(false);
		contentPane.add(IdLabel);
		
		idField = new JTextField();
		idField.setBounds(208, 445, 86, 20);
		idField.setVisible(false);
		idField.setEditable(false);
		contentPane.add(idField);
		idField.setColumns(10);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(idField.isVisible()) {
					idField.setVisible(false);
					IdLabel.setVisible(false);
				}
				HorarioField.setText("");
				SegundaField.setText("");
				TerçaField.setText("");
				QuartaField.setText("");
				QuintaField.setText("");
				SextaField.setText("");
			}
		});
		btnLimpar.setBounds(264, 547, 89, 23);
		contentPane.add(btnLimpar);
		
		DeletarBtn = new JButton("Deletar");
		DeletarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int IdHorario = Integer.parseInt( idField.getText());
				controleHorario.DeletarHorario(IdHorario);
				controleHorario.readJtableHorario(HorárioTable, lab.getIdLaboratorio());
			}
		});
		DeletarBtn.setBounds(264, 507, 89, 23);
		contentPane.add(DeletarBtn);
	}
}
