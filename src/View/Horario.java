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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.ControleHorario;
import model.Laboratorio;

import javax.swing.JButton;


public class Horario extends JFrame {
	private static Horario UnicaInstancia;
	private JPanel contentPane;
	private JTextField NomeLaboratorioField;
	private JTable HorárioTable;
	private JTextField DisciplinaHorario;
	private JLabel lblHorrio;
	private JTextField HorarioField;
	private JTextField NumeroLaboratorioField;

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
		ControleHorario controleHorario = new ControleHorario();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 854, 587);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLaboratrio = new JLabel("Laborat\u00F3rio:");
		lblLaboratrio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLaboratrio.setBounds(10, 34, 83, 14);
		contentPane.add(lblLaboratrio);
		
		NomeLaboratorioField = new JTextField();
		NomeLaboratorioField.setBounds(91, 33, 124, 20);
		contentPane.add(NomeLaboratorioField);
		NomeLaboratorioField.setColumns(10);
		NomeLaboratorioField.setEditable(false);
		NomeLaboratorioField.setText(lab.getNome());
		
		HorárioTable = new JTable();
		HorárioTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Hor\u00E1rios", "Segunda-feira", "Ter\u00E7a-feira", "Quarta-feira", "Quinta-Feira", "Sexta-Feira"
			}
		));
		HorárioTable.getColumnModel().getColumn(1).setPreferredWidth(86);
		HorárioTable.setBounds(46, 88, 757, 337);
		contentPane.add(HorárioTable);
		
		JScrollPane scroller = new JScrollPane(HorárioTable);
		scroller.setVisible(true);
		scroller.setBounds(46, 88, 757, 337);
		this.getContentPane().add(scroller);
	
		controleHorario.readJtableHorario(HorárioTable, lab.getIdLaboratorio());
		JLabel lblDisciplina = new JLabel("Disciplina:");
		lblDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDisciplina.setBounds(10, 472, 71, 14);
		contentPane.add(lblDisciplina);
		
		DisciplinaHorario = new JTextField();
		DisciplinaHorario.setBounds(77, 470, 168, 20);
		contentPane.add(DisciplinaHorario);
		DisciplinaHorario.setColumns(10);
	
		lblHorrio = new JLabel("Hor\u00E1rio:");
		lblHorrio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHorrio.setBounds(10, 447, 54, 14);
		contentPane.add(lblHorrio);
		
		HorarioField = new JTextField();
		HorarioField.setBounds(77, 445, 83, 20);
		contentPane.add(HorarioField);
		HorarioField.setColumns(10);
		HorarioField.setEditable(false);
		
		JButton ReservarBtn = new JButton("Reservar");
		ReservarBtn.setBounds(20, 501, 89, 23);
		contentPane.add(ReservarBtn);
		
		JButton LiberarBtn = new JButton("Liberar");
		LiberarBtn.setBounds(126, 501, 89, 23);
		contentPane.add(LiberarBtn);
		
		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumero.setBounds(32, 59, 61, 14);
		contentPane.add(lblNumero);
		
		NumeroLaboratorioField = new JTextField();
		NumeroLaboratorioField.setBounds(91, 59, 124, 20);
		contentPane.add(NumeroLaboratorioField);
		NumeroLaboratorioField.setColumns(10);
		NumeroLaboratorioField.setEditable(false);
		NumeroLaboratorioField.setText(""+lab.getNumero());
	}
	
	public static synchronized Horario getInstance(Laboratorio lab) {
		if(UnicaInstancia== null)
			UnicaInstancia = new Horario(lab);
		return UnicaInstancia;
	}
	 
	
}
