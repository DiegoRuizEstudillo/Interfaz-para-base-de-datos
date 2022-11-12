package Conexion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;

public class Alumnos2 extends JFrame {
	
	private void limpiarCajas(){
		textId.setText(null);
		textNombre.setText(null);;
		textApellido.setText(null);;
		textDirección.setText(null);;
		textFecha_nacimiento.setText(null);
		
	}
		Conexion con=new Conexion();	 

	private JPanel content;
	private JTextField textId;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textDirección;
	private JTextField textFecha_nacimiento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Alumnos2 frame = new Alumnos2();
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
	
	
	
	public Alumnos2() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\user\\OneDrive\\Escritorio\\WhatsApp_Image_2022-11-11_at_10.51.01_AM__2_-removebg-preview.png"));
		setTitle("Alumno");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 300);
		content = new JPanel();
		content.setBackground(new Color(250, 235, 215));
		content.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(content);
		content.setLayout(null);
		JButton btnInsert = new JButton("Insert");
		btnInsert.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				con.Id=textId.getText();
				con.Nombre=textNombre.getText();
				con.Apellido=textApellido.getText();
				con.Dirección=textDirección.getText();
				con.Fecha_nacimiento=textFecha_nacimiento.getText();
				con.InsertarAlumno();
				limpiarCajas();
			}
				
		});
		JButton btnSelect = new JButton("Select");
		btnSelect.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				con.Id=textId.getText();
				con.SeleccionarAlumno();
				textNombre.setText(con.Nombre);
				textApellido.setText(con.Apellido);
				textDirección.setText(con.Dirección);
				textFecha_nacimiento.setText(con.Fecha_nacimiento);
			}
		});
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				con.Id=textId.getText();
				con.Nombre=textNombre.getText();
				con.Apellido=textApellido.getText();
				con.Dirección=textDirección.getText();
				con.Fecha_nacimiento=textFecha_nacimiento.getText();
				con.ActualizarAlumno();
				limpiarCajas();

			}
		});
		btnUpdate.setBounds(384, 114, 85, 21);
		content.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				con.Id=textId.getText();
				con.EliminarAlumno();
				limpiarCajas();

			}
		});
		btnDelete.setBounds(384, 145, 85, 21);
		content.add(btnDelete);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				System.exit(0);
			}
			
		});
		JButton btnClean = new JButton("Clean");
		btnClean.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		btnClean.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCajas();

			}
		});
		
		btnExit.setBounds(125, 212, 67, 21);
		content.add(btnExit);
		
		
		btnSelect.setBounds(384, 83, 85, 21);
		content.add(btnSelect);
		
	
		btnInsert.setBounds(384, 52, 85, 21);
		content.add(btnInsert);
		
		textId = new JTextField();
		textId.setBounds(186, 53, 165, 19);
		content.add(textId);
		textId.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setBounds(186, 84, 165, 19);
		content.add(textNombre);
		textNombre.setColumns(10);
		
		textApellido = new JTextField();
		textApellido.setBounds(186, 115, 165, 19);
		content.add(textApellido);
		textApellido.setColumns(10);
		
		textDirección = new JTextField();
		textDirección.setBounds(186, 146, 165, 19);
		content.add(textDirección);
		textDirección.setColumns(10);
		
		textFecha_nacimiento = new JTextField();
		textFecha_nacimiento.setBounds(212, 177, 139, 19);
		content.add(textFecha_nacimiento);
		textFecha_nacimiento.setColumns(10);
		
		JLabel lblId = new JLabel("Id");
		lblId.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblId.setBounds(52, 55, 82, 13);
		content.add(lblId);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblNombre.setBounds(52, 86, 82, 13);
		content.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblApellido.setBounds(52, 117, 82, 13);
		content.add(lblApellido);
		
		JLabel lblDirección = new JLabel("Dirección");
		lblDirección.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblDirección.setBounds(52, 148, 82, 13);
		content.add(lblDirección);
		
		JLabel lblFecha_nacimiento = new JLabel("Fecha de Nacimiento");
		lblFecha_nacimiento.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblFecha_nacimiento.setBounds(52, 179, 144, 13);
		content.add(lblFecha_nacimiento);
		
		JLabel lblNewLabel = new JLabel("ALUMNOS");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 21));
		lblNewLabel.setBounds(216, 16, 107, 21);
		content.add(lblNewLabel);
		
		
		btnClean.setBounds(384, 176, 85, 21);
		content.add(btnClean);
		
		JButton btnMenu = new JButton("Return");
		btnMenu.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Menu M1 = new Menu();
				M1.setVisible(true);
				Alumnos2.this.dispose();
				setVisible(false);
				
			}

			private void setVisible(boolean b) {
				// TODO Auto-generated method stub
				
			}
		});
		btnMenu.setBounds(22, 212, 85, 21);
		content.add(btnMenu);
	}
}
