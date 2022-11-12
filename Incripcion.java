package Conexion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class Incripcion extends JFrame {

	
	private void limpiarCajas(){
		textId.setText(null);
		textIdAlumno.setText(null);;
		textIdProfesor.setText(null);;
		textIdAsignatura.setText(null);;
		textFecha.setText(null);
	}
	Conexion con=new Conexion();	 

	private JPanel contentPane;
	private JTextField textIdAlumno;
	private JTextField textIdProfesor;
	private JTextField textIdAsignatura;
	private JTextField textId;
	private JTextField textFecha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Incripcion frame = new Incripcion();
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
	public Incripcion() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\user\\OneDrive\\Escritorio\\WhatsApp_Image_2022-11-11_at_10.51.00_AM__2_-removebg-preview.png"));
		setForeground(new Color(153, 204, 204));
		setTitle("Inscripción");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 313);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.setBackground(SystemColor.menu);
		btnInsert.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				con.ID=textId.getText();
				con.IdAlumno=textIdAlumno.getText();
				con.IdProfesor=textIdProfesor.getText();
				con.IdAsignatura=textIdAsignatura.getText();
				con.Fecha=textFecha.getText();
				con.InsertarInscripcion();

				limpiarCajas();

			}
		});
		btnInsert.setBounds(306, 90, 85, 21);
		contentPane.add(btnInsert);
		
		JButton btnSelect = new JButton("Select");
		btnSelect.setBackground(SystemColor.menu);
		btnSelect.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				con.ID=textId.getText();
				con.SeleccionarInscripcion();
				textIdAsignatura.setText(con.IdAsignatura);
				textIdAlumno.setText(con.IdAlumno);
				textIdProfesor.setText(con.IdProfesor);
				textFecha.setText(con.Fecha);
			

			}
		});
		btnSelect.setBounds(306, 121, 85, 21);
		contentPane.add(btnSelect);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBackground(SystemColor.menu);
		btnUpdate.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				con.Id=textId.getText();
				textId.setText(con.ID);
				textIdAlumno.setText(con.IdAlumno);
				textIdProfesor.setText(con.IdProfesor);
				textFecha.setText(con.Fecha);
				con.ActualizarInscripcion();
				limpiarCajas();
			}
		});
		btnUpdate.setBounds(306, 152, 85, 21);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(SystemColor.menu);
		btnDelete.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				con.ID=textId.getText();
				con.EliminarInscripcion();
				limpiarCajas();
			}
		});
		btnDelete.setBounds(306, 183, 85, 21);
		contentPane.add(btnDelete);
		
		JButton btnClean = new JButton("Clean");
		btnClean.setBackground(SystemColor.menu);
		btnClean.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		btnClean.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCajas();

			}
		});
		btnClean.setBounds(306, 215, 85, 21);
		contentPane.add(btnClean);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBackground(SystemColor.menu);
		btnExit.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
		btnExit.setBounds(114, 239, 59, 21);
		contentPane.add(btnExit);
		
		textIdAlumno = new JTextField();
		textIdAlumno.setBounds(177, 116, 96, 19);
		contentPane.add(textIdAlumno);
		textIdAlumno.setColumns(10);
		
		textIdProfesor = new JTextField();
		textIdProfesor.setBounds(177, 145, 96, 19);
		contentPane.add(textIdProfesor);
		textIdProfesor.setColumns(10);
		
		textIdAsignatura = new JTextField();
		textIdAsignatura.setBounds(177, 174, 96, 19);
		contentPane.add(textIdAsignatura);
		textIdAsignatura.setColumns(10);
		
		JLabel lblIdAsignatura = new JLabel("Id Asignatura");
		lblIdAsignatura.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblIdAsignatura.setBounds(39, 173, 128, 13);
		contentPane.add(lblIdAsignatura);
		
		JLabel lblIdAlumno = new JLabel("Id Alumno");
		lblIdAlumno.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblIdAlumno.setBounds(39, 117, 85, 13);
		contentPane.add(lblIdAlumno);
		
		JLabel lblIdProfesor = new JLabel("Id Profesor");
		lblIdProfesor.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblIdProfesor.setBounds(39, 146, 85, 13);
		contentPane.add(lblIdProfesor);
		
		textId = new JTextField();
		textId.setBounds(177, 87, 96, 19);
		contentPane.add(textId);
		textId.setColumns(10);
		
		JLabel lblID = new JLabel("ID");
		lblID.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblID.setBounds(39, 88, 45, 13);
		contentPane.add(lblID);
		
		textFecha = new JTextField();
		textFecha.setBounds(177, 205, 96, 19);
		contentPane.add(textFecha);
		textFecha.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblFecha.setBounds(39, 206, 45, 13);
		contentPane.add(lblFecha);
		
		JButton btnMenu = new JButton("Return");
		btnMenu.setBackground(SystemColor.menu);
		btnMenu.setForeground(new Color(0, 0, 0));
		btnMenu.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu M1 = new Menu();
				M1.setVisible(true);
				Incripcion.this.dispose();
				setVisible(false);
			}

			private void setVisible(boolean b) {
				// TODO Auto-generated method stub
				
			}
		});
		btnMenu.setBounds(26, 239, 78, 21);
		contentPane.add(btnMenu);
		
		JLabel lblNewLabel = new JLabel("INSCRIPCIÓN");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 21));
		lblNewLabel.setBounds(158, 30, 141, 33);
		contentPane.add(lblNewLabel);
	}
}
