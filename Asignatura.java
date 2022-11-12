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

public class Asignatura extends JFrame {
	
	 private void limpiarCajas() {
	        textId.setText(null);
	        textNombre_asignatura.setText(null);
	        
	    }
		Conexion con=new Conexion();	 

	private JPanel contentPane;
	private JTextField textId;
	private JTextField textNombre_asignatura;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Asignatura frame = new Asignatura();
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
	public Asignatura() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\user\\OneDrive\\Escritorio\\WhatsApp_Image_2022-11-11_at_10.51.00_AM__1_-removebg-preview.png"));
		setTitle("Asignatura");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 254);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 204, 204));
		contentPane.setForeground(new Color(51, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				con.Id=textId.getText();
				con.Nombre_asignatura=textNombre_asignatura.getText();
				con.InsertarAsignatura();
				limpiarCajas();
			}
		});
		JButton btnSelect = new JButton("Select");
		btnSelect.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				con.Id=textId.getText();
				con.SeleccionarAsignatura();
				textNombre_asignatura.setText(con.Nombre_asignatura);

			}
		});

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				con.Id=textId.getText();
				con.Nombre=textNombre_asignatura.getText();
				con.ActualizarAsignatura();
			}
		});
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				con.Id=textId.getText();

				con.EliminarAsignatura();
				limpiarCajas();

			}
		});
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		
		btnInsert.setBounds(305, 58, 85, 21);
		contentPane.add(btnInsert);
		
		
		btnUpdate.setBounds(305, 120, 85, 21);
		contentPane.add(btnUpdate);
		
		
		btnSelect.setBounds(305, 89, 85, 21);
		contentPane.add(btnSelect);
		
		
		btnDelete.setBounds(305, 151, 85, 21);
		contentPane.add(btnDelete);
		
		
		btnExit.setBounds(105, 182, 69, 21);
		contentPane.add(btnExit);
		
		textId = new JTextField();
		textId.setBounds(164, 59, 106, 19);
		contentPane.add(textId);
		textId.setColumns(10);
		
		textNombre_asignatura = new JTextField();
		textNombre_asignatura.setBounds(164, 90, 106, 19);
		contentPane.add(textNombre_asignatura);
		textNombre_asignatura.setColumns(10);
		
		JLabel lblId = new JLabel("ID: ");
		lblId.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblId.setBounds(10, 62, 45, 13);
		contentPane.add(lblId);
		
		JLabel lblNombre_asignatura = new JLabel("Nombre de la Asignatura:");
		lblNombre_asignatura.setFont(new Font("Century Gothic", Font.BOLD, 11));
		lblNombre_asignatura.setBounds(10, 93, 149, 13);
		contentPane.add(lblNombre_asignatura);
		
		JLabel lblNewLabel = new JLabel("ASIGNATURA");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 21));
		lblNewLabel.setBounds(148, 21, 157, 19);
		contentPane.add(lblNewLabel);
		
		
		btnClean.setBounds(305, 182, 85, 21);
		contentPane.add(btnClean);
		
		JButton btnMenu = new JButton("Return");
		btnMenu.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu M1 = new Menu();
				M1.setVisible(true);
				Asignatura.this.dispose();
				setVisible(false);
			}

			private void setVisible(boolean b) {
				// TODO Auto-generated method stub
				
			}
		});
		btnMenu.setBounds(10, 182, 85, 21);
		contentPane.add(btnMenu);
	}
}
