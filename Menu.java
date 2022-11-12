package Conexion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.SwingConstants;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\user\\OneDrive\\Escritorio\\WhatsApp_Image_2022-11-11_at_10.51.00_AM-removebg-preview.png"));
		setForeground(new Color(255, 215, 0));
		setFont(new Font("Century Gothic", Font.PLAIN, 12));
		setAlwaysOnTop(true);
		setBackground(new Color(255, 255, 255));
		setTitle("Menú   ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 718, 545);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 160, 122));
		contentPane.setForeground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Control Escolar");
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Eras Bold ITC", Font.BOLD, 32));
		lblNewLabel.setBounds(204, 10, 261, 52);
		contentPane.add(lblNewLabel);
		
		JButton btnAlumno = new JButton("Alumno");
		btnAlumno.setForeground(new Color(255, 255, 255));
		btnAlumno.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Escritorio\\WhatsApp_Image_2022-11-11_at_10.51.01_AM__2_-removebg-preview.png"));
		btnAlumno.setSelectedIcon(new ImageIcon("C:\\Users\\Valeria\\Downloads\\alumno.png"));
		btnAlumno.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 21));
		btnAlumno.setBackground(new Color(250, 235, 215));
		btnAlumno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Alumnos2 A1 = new Alumnos2();
				A1.setVisible(true);
				Menu.this.dispose();
				setVisible(false);
				
			}

			private void setVisible(boolean b) {
				// TODO Auto-generated method stub
				
			}
		});
		btnAlumno.setBounds(73, 83, 261, 108);
		contentPane.add(btnAlumno);
		
		JButton btnAsignatura = new JButton("Asignatura");
		btnAsignatura.setForeground(new Color(255, 255, 255));
		btnAsignatura.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Escritorio\\WhatsApp_Image_2022-11-11_at_10.51.00_AM__1_-removebg-preview.png"));
		btnAsignatura.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 21));
		btnAsignatura.setBackground(new Color(250, 235, 215));
		btnAsignatura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Asignatura As1 = new Asignatura();
				As1.setVisible(true);
				Menu.this.dispose();
				setVisible(false);
			}

			private void setVisible(boolean b) {
				// TODO Auto-generated method stub
				
			}
		});
		btnAsignatura.setBounds(73, 214, 261, 118);
		contentPane.add(btnAsignatura);
		
		JButton btnProfesor = new JButton("Profesor");
		btnProfesor.setForeground(new Color(255, 255, 255));
		btnProfesor.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Escritorio\\WhatsApp_Image_2022-11-11_at_10.51.01_AM__1_-removebg-preview.png"));
		btnProfesor.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 21));
		btnProfesor.setBackground(new Color(250, 235, 215));
		btnProfesor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Profesor P1 = new Profesor();
				P1.setVisible(true);
				Menu.this.dispose();
				setVisible(false);
			}

			private void setVisible(boolean b) {
				// TODO Auto-generated method stub
				
			}
		});
		btnProfesor.setBounds(345, 83, 261, 108);
		contentPane.add(btnProfesor);
		
		JButton btnInscripcion = new JButton("Inscripción");
		btnInscripcion.setForeground(new Color(255, 255, 255));
		btnInscripcion.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Escritorio\\WhatsApp_Image_2022-11-11_at_10.51.00_AM__2_-removebg-preview.png"));
		btnInscripcion.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 21));
		btnInscripcion.setBackground(new Color(250, 235, 215));
		btnInscripcion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Incripcion I1 = new Incripcion();
				I1.setVisible(true);
				Menu.this.dispose();
				setVisible(false);
			}

			private void setVisible(boolean b) {
				// TODO Auto-generated method stub
				
			}
		});
		btnInscripcion.setBounds(344, 214, 262, 118);
		contentPane.add(btnInscripcion);
		
		JButton btnSalir = new JButton("Exit");
		btnSalir.setVerticalAlignment(SwingConstants.BOTTOM);
		btnSalir.setForeground(new Color(255, 255, 255));
		btnSalir.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Escritorio\\WhatsApp_Image_2022-11-11_at_10.50.59_AM-removebg-preview.png"));
		btnSalir.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 21));
		btnSalir.setBackground(new Color(250, 235, 215));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(273, 373, 153, 59);
		contentPane.add(btnSalir);
	}
}
