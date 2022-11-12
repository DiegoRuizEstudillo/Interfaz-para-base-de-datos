package Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
	
	
	Connection conexion=null;
	String usuario="sa";
	String contraseña="080626";
	String db= "Escuela";
	String puerto="1433";
	
	String Id;
	String Nombre;
	String Apellido;
	String Dirección;
	String Fecha_nacimiento;
	String Fecha_Nacimiento;
	String Nivel_Academico;
	String Nombre_asignatura;
	String ID;
	String IdAsignatura;
	String IdAlumno;
	String IdProfesor;
	String Fecha;

private void limpiarCajas() {
	 Id=" ";
	Nombre=" ";
	Apellido=" ";
	Dirección=" ";
	Fecha_nacimiento=" ";
	Fecha_Nacimiento=" ";
	Nivel_Academico=" ";
	Nombre_asignatura=" ";
	ID=" ";
	IdAsignatura=" ";
	IdAlumno=" ";
	IdProfesor=" ";
	Fecha=" ";
}
	public Connection obtenerConexion() {
		try {
			String cadena="jdbc:sqlserver://DRE08:"+ puerto+";"+"databaseName="+db;
			conexion=DriverManager.getConnection(cadena,usuario, contraseña);
			JOptionPane.showMessageDialog(null,"Conexión exitosa");
		}catch (Exception e) {
			System.out.printf("Error: "+e.toString());
		}
		return conexion;
	}
	
	//TABLA ALUMNO
	//Insertar
	public PreparedStatement InsertarAlumno() {
		Conexion op = new Conexion();
		Connection cn=null;
		PreparedStatement ps=null;
        try {
            cn = op.obtenerConexion();
            String insert="Insert into Alumnos values(?,?,?,?,?)";
			ps=cn.prepareStatement(insert);
            ps.setString(1, Id);
            ps.setString(2, Nombre);
            ps.setString(3, Apellido);
            ps.setString(4, Dirección);
            ps.setString(5, Fecha_nacimiento);

            ps.executeUpdate();
            System.out.println("Registro Insertado ");
            JOptionPane.showMessageDialog(null, "Registro Agregado");
			
			}catch(Exception e){
			System.out.println("Error de registro");
			e.printStackTrace();
		}
		return ps;
	}
	//Seleccionar
	public PreparedStatement SeleccionarAlumno() {
		Conexion op = new Conexion();
		Connection cn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
        try {
            cn = op.obtenerConexion();
            String select="Select * from Alumnos where Id=?";
			ps=cn.prepareStatement(select);
            ps.setString(1, Id);
            rs=ps.executeQuery();
            
            if(rs.next()) {
            	Id=rs.getString(1);
            	Nombre=rs.getString(2);
            	Apellido=rs.getString(3);
            	Dirección=rs.getString(4);
            	Fecha_nacimiento=rs.getString(5);
            }else {
                JOptionPane.showMessageDialog(null, "Error,verifica el Id");
                limpiarCajas();
            }
			}catch(Exception e){
			System.out.println("Error al consultar");
			e.printStackTrace();
		}
		return ps;
	}
	//Actualizar
	public PreparedStatement ActualizarAlumno() {
		Conexion op = new Conexion();
		Connection cn=null;
		PreparedStatement ps=null;
		try {
			 cn = op.obtenerConexion();
	            String update="UPDATE Alumnos SET Nombre=?,Apellido=?,Dirección=?, Fecha_nacimiento=? where Id=?";
				ps=cn.prepareStatement(update);
		            ps.setString(1, Nombre);
		            ps.setString(2, Apellido);
		            ps.setString(3, Dirección);
		            ps.setString(4, Fecha_nacimiento);
		            ps.setString(5, Id);


	            ps.executeUpdate();
	            System.out.println("Registro actualizado");
				JOptionPane.showMessageDialog(null, "Registro Actualizado");
		}catch(Exception e) {
			System.out.println("Error de actualizacion");
			e.printStackTrace();
		} return ps;	
		}
	//Eliminar
	public PreparedStatement EliminarAlumno() {
		Conexion op = new Conexion();
		Connection cn=null;
		PreparedStatement ps=null;
		
		try {
			 cn = op.obtenerConexion();
			 String delete="Delete from Alumnos where id=?";
			ps=cn.prepareStatement(delete);
			ps.setString(1, Id);
			int res= ps.executeUpdate();
			if(res>0) {
				JOptionPane.showMessageDialog(null, "Registro Eliminado");
			} else {
				JOptionPane.showMessageDialog(null, "Error al borrar registro");
			}
		cn.close();
			
		}catch(Exception e) {
			System.out.println("Error al eliminar");
			e.printStackTrace();
		}return ps;
	}
	//TABLA PROFESOR
		//Insertar
		public PreparedStatement InsertarProfesor() {
			Conexion op = new Conexion();
			Connection cn=null;
			PreparedStatement ps=null;
	        try {
	            cn = op.obtenerConexion();
	            String insert="Insert into Profesor values(?,?,?,?,?,?)";
				ps=cn.prepareStatement(insert);
	            ps.setString(1, Id);
	            ps.setString(2, Nombre);
	            ps.setString(3, Apellido);
	            ps.setString(4, Dirección);
	            ps.setString(5, Fecha_Nacimiento);
	            ps.setString(6, Nivel_Academico);

	            ps.executeUpdate();
	            System.out.println("Registro Insertado ");
	            JOptionPane.showMessageDialog(null, "Registro Agregado");
				
				}catch(Exception e){
				System.out.println("Error de registro");
				e.printStackTrace();
			}
			return ps;
		}
		//Seleccionar
		public PreparedStatement SeleccionarProfesor() {
			Conexion op = new Conexion();
			Connection cn=null;
			PreparedStatement ps=null;
			ResultSet rs=null;
	        try {
	            cn = op.obtenerConexion();
	            String select="Select * from Profesor where Id=?";
				ps=cn.prepareStatement(select);
	            ps.setString(1, Id);
	            rs=ps.executeQuery();
	            
	            if(rs.next()) {
	            	Id=rs.getString(1);
	            	Nombre=rs.getString(2);
	            	Apellido=rs.getString(3);
	            	Dirección=rs.getString(4);
	            	Fecha_Nacimiento=rs.getString(5);
	            	Nivel_Academico=rs.getString(6);
	            }else {
	                JOptionPane.showMessageDialog(null, "Error,verifica el Id");
	                limpiarCajas();
	            }
				}catch(Exception e){
				System.out.println("Error al consultar");
				e.printStackTrace();
			}
			return ps;
		}
		//Actualizar
		public PreparedStatement ActualizarProfesor() {
			Conexion op = new Conexion();
			Connection cn=null;
			PreparedStatement ps=null;
			try {
				 cn = op.obtenerConexion();
		            String update="UPDATE Profesor SET Nombre=?,Apellido=?,Dirección=?, Fecha_Nacimiento=?, Nivel_Academico=? where Id=?";
					ps=cn.prepareStatement(update);
			            ps.setString(1, Nombre);
			            ps.setString(2, Apellido);
			            ps.setString(3, Dirección);
			            ps.setString(4, Fecha_Nacimiento);
			            ps.setString(5, Nivel_Academico);
			            ps.setString(6,Id );

		            ps.executeUpdate();
		            System.out.println("Registro actualizado");
					JOptionPane.showMessageDialog(null, "Registro Actualizado");
			}catch(Exception e) {
				System.out.println("Error de actualizacion");
				e.printStackTrace();
			} return ps;	
			}
		//Eliminar
		public PreparedStatement EliminarProfesor() {
			Conexion op = new Conexion();
			Connection cn=null;
			PreparedStatement ps=null;
			
			try {
				 cn = op.obtenerConexion();
				 String delete="Delete from Profesor where Id=?";
				ps=cn.prepareStatement(delete);
				ps.setString(1, Id);
				int res= ps.executeUpdate();
				if(res>0) {
					JOptionPane.showMessageDialog(null, "Registro Eliminado");
				} else {
					JOptionPane.showMessageDialog(null, "Error al borrar registro");
				}
			cn.close();
				
			}catch(Exception e) {
				System.out.println("Error al eliminar");
				e.printStackTrace();
			}return ps;
		}
		//TABLA ASIGNATURA
		//Insertar
		public PreparedStatement InsertarAsignatura() {
			Conexion op = new Conexion();
			Connection cn=null;
			PreparedStatement ps=null;
	        try {
	            cn = op.obtenerConexion();
	            String insert="Insert into Asignatura values(?,?)";
				ps=cn.prepareStatement(insert);
	            ps.setString(1, Id);
	            ps.setString(2, Nombre_asignatura);
	          
	            ps.executeUpdate();
	            System.out.println("Registro Insertado ");
	            JOptionPane.showMessageDialog(null, "Registro Agregado");
				
				}catch(Exception e){
				System.out.println("Error de registro");
				e.printStackTrace();
			}
			return ps;
		}
		//Seleccionar
		public PreparedStatement SeleccionarAsignatura() {
			Conexion op = new Conexion();
			Connection cn=null;
			PreparedStatement ps=null;
			ResultSet rs=null;
	        try {
	            cn = op.obtenerConexion();
	            String select="Select * from Asignatura where Id=?";
				ps=cn.prepareStatement(select);
	            ps.setString(1, Id);
	            rs=ps.executeQuery();
	            
	            if(rs.next()) {
	            	Id=rs.getString(1);
	            	Nombre_asignatura=rs.getString(2);
	            	
	            }else {
	                JOptionPane.showMessageDialog(null, "Error,verifica el Id");
	                limpiarCajas();
	            }
				}catch(Exception e){
				System.out.println("Error al consultar");
				e.printStackTrace();
			}
			return ps;
		}
		//Actualizar
		public PreparedStatement ActualizarAsignatura() {
			Conexion op = new Conexion();
			Connection cn=null;
			PreparedStatement ps=null;
			try {
				 cn = op.obtenerConexion();
		            String update="UPDATE Asignatura set Nombre=? where Id=?";
					ps=cn.prepareStatement(update);
			        ps.setString(1, Nombre );
					ps.setString(2, Id);

		            ps.executeUpdate();
		            System.out.println("Registro actualizado");
					JOptionPane.showMessageDialog(null, "Registro Actualizado");
			}catch(Exception e) {
				System.out.println("Error de actualizacion");
				e.printStackTrace();
			} return ps;	
		}
		//Eliminar
		public PreparedStatement EliminarAsignatura() {
			Conexion op = new Conexion();
			Connection cn=null;
			PreparedStatement ps=null;
			
			try {
				 cn = op.obtenerConexion();
				 String delete="Delete from Asignatura where id=?";
				ps=cn.prepareStatement(delete);
				ps.setString(1, Id);
				int res= ps.executeUpdate();
				if(res>0) {
					JOptionPane.showMessageDialog(null, "Registro Eliminado");
				} else {
					JOptionPane.showMessageDialog(null, "Error al borrar registro");
				}
			cn.close();
				
			}catch(Exception e) {
				System.out.println("Error al eliminar");
				e.printStackTrace();
			}return ps;
		}
		//TABLA INSCRIPCIÓN
		//Insertar
		public PreparedStatement InsertarInscripcion() {
			Conexion op = new Conexion();
			Connection cn=null;
			PreparedStatement ps=null;
	        try {
	            cn = op.obtenerConexion();
	            String insert="INSERT into Inscripcion values(?,?,?,?,?)";
				ps=cn.prepareStatement(insert);
	            ps.setString(1, ID);
	            ps.setString(3, IdAlumno);
	            ps.setString(4, IdProfesor);
	            ps.setString(2, IdAsignatura);
	            ps.setString(5, Fecha);

	            ps.executeUpdate();
	            System.out.println("Registro Insertado ");
	            JOptionPane.showMessageDialog(null, "Registro Agregado");
				
				}catch(Exception e){
				System.out.println("Error de registro");
				e.printStackTrace();
			}
			return ps;
		}
		//Seleccionar
		public PreparedStatement SeleccionarInscripcion() {
			Conexion op = new Conexion();
			Connection cn=null;
			PreparedStatement ps=null;
			ResultSet rs=null;
	        try {
	            cn = op.obtenerConexion();
	            String select="Select * from Inscripcion where ID=?";
				ps=cn.prepareStatement(select);
	            ps.setString(1, ID);
	            rs=ps.executeQuery();
	            
	            if(rs.next()) {
	            	ID=rs.getString(1);
	            	IdAsignatura=rs.getString(2);
	            	IdAlumno=rs.getString(3);
	            	IdProfesor=rs.getString(4);
	            	Fecha=rs.getString(5);


	            	
	            }else {
	                JOptionPane.showMessageDialog(null, "Error,verifica el Id");
	                limpiarCajas();
	            }
				}catch(Exception e){
				System.out.println("Error al consultar");
				e.printStackTrace();
			}
			return ps;
		}
		//Actualizar
		public PreparedStatement ActualizarInscripcion() {
			Conexion op = new Conexion();
			Connection cn=null;
			PreparedStatement ps=null;
			try {
				 cn = op.obtenerConexion();
		            String update="UPDATE Inscripcion set IdAlumno=?, IdProfesor=?, IdAsignatura=?, Fecha=? where ID=?";
					ps=cn.prepareStatement(update);
			        ps.setString(1, IdAlumno );
			        ps.setString(2, IdProfesor );
			        ps.setString(3, IdAsignatura );
			        ps.setString(4, Fecha );
					ps.setString(5, ID);

		            ps.executeUpdate();
		            System.out.println("Registro actualizado");
					JOptionPane.showMessageDialog(null, "Registro Actualizado");
			}catch(Exception e) {
				System.out.println("Error de actualizacion");
				e.printStackTrace();
			} return ps;	
		}
		//Eliminar
		public PreparedStatement EliminarInscripcion() {
			Conexion op = new Conexion();
			Connection cn=null;
			PreparedStatement ps=null;
			
			try {
				 cn = op.obtenerConexion();
				 String delete="Delete from Inscripcion where id=?";
				ps=cn.prepareStatement(delete);
				ps.setString(1, ID);
				int res= ps.executeUpdate();
				if(res>0) {
					JOptionPane.showMessageDialog(null, "Registro Eliminado");
				} else {
					JOptionPane.showMessageDialog(null, "Error al borrar registro");
				}
			cn.close();
				
			}catch(Exception e) {
				System.out.println("Error al eliminar");
				e.printStackTrace();
			}return ps;
		}
		
		
}
	
