package Conexion;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;

public class Profesor extends JFrame {
	
	private void limpiarCajas() {
        textId.setText(null);
        textNombre.setText(null);
        textApellido.setText(null);
        textDirección.setText(null);
        textFecha_Nacimiento.setText(null);
        textNivel_Academico.setText(null);
    }
	Conexion con=new Conexion();	 

	private JPanel contentPane;
	private JTextField textId;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textDirección;
	private JTextField textFecha_Nacimiento;
	private JTextField textNivel_Academico;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profesor frame = new Profesor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Profesor() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\user\\OneDrive\\Escritorio\\WhatsApp_Image_2022-11-11_at_10.51.01_AM__1_-removebg-preview.png"));
		setTitle("Profesor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 437, 312);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				con.Id=textId.getText();
				con.Nombre=textNombre.getText();
				con.Apellido=textApellido.getText();
				con.Dirección=textDirección.getText();
				con.Fecha_Nacimiento=textFecha_Nacimiento.getText();
				con.Nivel_Academico=textNivel_Academico.getText();
				con.InsertarProfesor();
				limpiarCajas();
			}
		});
		btnInsert.setBounds(304, 48, 85, 21);
		contentPane.add(btnInsert);
		
		JButton btnSelect = new JButton("Select");
		btnSelect.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				con.Id=textId.getText();
				con.SeleccionarProfesor();
				textNombre.setText(con.Nombre);
				textApellido.setText(con.Apellido);
				textDirección.setText(con.Dirección);
				textFecha_Nacimiento.setText(con.Fecha_Nacimiento);
				textNivel_Academico.setText(con.Nivel_Academico);
			}
		});
		btnSelect.setBounds(304, 77, 85, 21);
		contentPane.add(btnSelect);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				con.Id=textId.getText();
				con.Nombre=textNombre.getText();
				con.Apellido=textApellido.getText();
				con.Dirección=textDirección.getText();
				con.Fecha_Nacimiento=textFecha_Nacimiento.getText();
				con.Nivel_Academico=textNivel_Academico.getText();
				con.ActualizarProfesor();
				limpiarCajas();
			}
			
		});
		btnUpdate.setBounds(304, 108, 85, 21);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				con.Id=textId.getText();
				con.EliminarProfesor();
				limpiarCajas();
			}
		});
		
		
		JButton btnClean = new JButton("Clean");
		btnClean.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		btnClean.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCajas();

			}
		});
		btnClean.setBounds(304, 164, 85, 21);
		contentPane.add(btnClean);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
		
		btnDelete.setBounds(304, 139, 85, 21);
		contentPane.add(btnDelete);
		
		textId = new JTextField();
		textId.setBounds(168, 51, 96, 19);
		contentPane.add(textId);
		textId.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setBounds(168, 80, 96, 19);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textApellido = new JTextField();
		textApellido.setBounds(168, 109, 96, 19);
		contentPane.add(textApellido);
		textApellido.setColumns(10);
		
		textDirección = new JTextField();
		textDirección.setBounds(168, 138, 96, 19);
		contentPane.add(textDirección);
		textDirección.setColumns(10);
		
		textFecha_Nacimiento = new JTextField();
		textFecha_Nacimiento.setBounds(168, 167, 96, 19);
		contentPane.add(textFecha_Nacimiento);
		textFecha_Nacimiento.setColumns(10);
		
		textNivel_Academico = new JTextField();
		textNivel_Academico.setBounds(168, 196, 96, 19);
		contentPane.add(textNivel_Academico);
		textNivel_Academico.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Id");
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblNewLabel.setBounds(21, 52, 45, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblNewLabel_1.setBounds(21, 81, 72, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido");
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblNewLabel_2.setBounds(21, 112, 58, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Dirección");
		lblNewLabel_3.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblNewLabel_3.setBounds(21, 139, 72, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Fecha de Nacimiento");
		lblNewLabel_4.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblNewLabel_4.setBounds(21, 170, 144, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Nivel Académico");
		lblNewLabel_5.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblNewLabel_5.setBounds(21, 199, 137, 13);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("PROFESOR");
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setFont(new Font("Century Gothic", Font.BOLD, 21));
		lblNewLabel_6.setBounds(167, 13, 122, 22);
		contentPane.add(lblNewLabel_6);
		
		
		btnExit.setBounds(116, 244, 63, 21);
		contentPane.add(btnExit);
		
		JButton btnMenu = new JButton("Return");
		btnMenu.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu M1 = new Menu();
				M1.setVisible(true);
				Profesor.this.dispose();
				setVisible(false);
			}

			private void setVisible(boolean b) {
				// TODO Auto-generated method stub
				
			}
		});
		btnMenu.setBounds(21, 244, 85, 21);
		contentPane.add(btnMenu);
	}

}
