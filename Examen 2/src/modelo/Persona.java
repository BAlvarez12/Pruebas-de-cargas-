/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.text.ParseException;

/**
 *
 * @author Bomiki
 */
public class Persona extends Docente {
    private String nombres, apellidos, direccion, telefono, fecha_nacimiento;
    Conexion cn;
    private int id_persona;
    
    public Persona(){}

    public Persona( String codigo_docente, double salario, String nombres, String apellidos, String direccion, String telefono, String fecha_nacimiento, String genero, String fec_ingreso_laboral) {
        super(codigo_docente, salario, genero, fec_ingreso_laboral);
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fecha_nacimiento = fecha_nacimiento;
    }
    public Persona(String codigo_docente, double salario, String nombres, String apellidos, String direccion, String telefono, String fecha_nacimiento, String genero, String fec_ingreso_laboral, int id_persona) {
        super(codigo_docente, salario, genero, fec_ingreso_laboral);
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fecha_nacimiento = fecha_nacimiento;
        this.id_persona = id_persona;
    }
    
       public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
    

 public void crearp() throws ParseException {
    try {
        cn = new Conexion();
        cn.abrir_conexion();
        cn.conexionDB.setAutoCommit(false);
        
        String queryPersona = "INSERT INTO docente (nombres, apellidos, direccion, telefono, fec_nacimiento, codigo_docente, genero, salario, fec_ingreso_laboral) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement parametroPersona = cn.conexionDB.prepareStatement(queryPersona);

        parametroPersona.setString(1, getNombres());
        parametroPersona.setString(2, getApellidos());
        parametroPersona.setString(3, getDireccion());
        parametroPersona.setString(4, getTelefono());
        parametroPersona.setString(5, getFecha_nacimiento());
        parametroPersona.setString(6, getCodigo_docente());
        parametroPersona.setString(7, getGenero());
        parametroPersona.setDouble(8, getSalario());
       
        parametroPersona.setString(9, getFec_ingreso_laboral());

        int executar = parametroPersona.executeUpdate();

        cn.conexionDB.commit();
        JOptionPane.showMessageDialog(null, "Ingreso Exitoso de la Persona");
    } catch (SQLException ex) {
        try {
            if (cn.conexionDB != null) {
                cn.conexionDB.rollback();
            }
        } catch (SQLException rollbackEx) {
            JOptionPane.showMessageDialog(null, "Error al hacer rollback: " + rollbackEx.getMessage());
        }
        JOptionPane.showMessageDialog(null, "Error al ingresar los datos: " + ex.getMessage());
    } finally {
        try {
            if (cn.conexionDB != null) {
                cn.conexionDB.setAutoCommit(true);
            }
            cn.cerrar_conexion();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + ex.getMessage());
        }
    }
}


    
    public DefaultTableModel leerp(){
        DefaultTableModel tabla = new DefaultTableModel();
        try{
            cn = new Conexion();
            cn.abrir_conexion();
            String query = "select * from docente";
            ResultSet consulta = cn.conexionDB.createStatement().executeQuery(query);
            String encabezado[] = {"id_persona","nombres", "apellidos","direccion","telefono","fec_nacimiento","codigo_docente" ,"salario","genero","fec_ingreso_laboral"};
            tabla.setColumnIdentifiers(encabezado);
            String datos[] = new String[10];
            while(consulta.next()){
                datos[0]= consulta.getString("id_persona");
                datos[1]= consulta.getString("nombres");
                datos[2]= consulta.getString("apellidos");
                datos[3]= consulta.getString("direccion");
                datos[4]= consulta.getString("telefono");
                datos[5]= consulta.getString("fec_nacimiento");
                datos[6]= consulta.getString("codigo_docente");
                datos[7]= consulta.getString("salario");
                datos[8]= consulta.getString("genero");
                datos[9]= consulta.getString("fec_ingreso_laboral");
                tabla.addRow(datos);
        }
            cn.cerrar_conexion();
        }catch(SQLException ex){
            cn.cerrar_conexion();
             JOptionPane.showMessageDialog(null,"Error al leer los datos"  + ex.getMessage());
        }
        return tabla;
    }
    
 public void actualizarp() throws ParseException {
    try {
        cn = new Conexion();
        cn.abrir_conexion();
        cn.conexionDB.setAutoCommit(false);

        String queryPersona = "INSERT INTO docente (id_docente, nombres, apellidos, direccion, telefono, fec_nacimiento, codigo_docente, genero, salario, fec_ingreso_laboral) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE nombres = VALUES(nombres), apellidos = VALUES(apellidos), direccion = VALUES(direccion), telefono = VALUES(telefono), fec_nacimiento = VALUES(fec_nacimiento), codigo_docente = VALUES(codigo_docente), genero = VALUES(genero), salario = VALUES(salario), fec_ingreso_laboral = VALUES(fec_ingreso_laboral);";
        
        PreparedStatement parametroPersona = cn.conexionDB.prepareStatement(queryPersona);
        parametroPersona.setInt(1, getId_persona());
        parametroPersona.setString(2, getNombres());
        parametroPersona.setString(3, getApellidos());
        parametroPersona.setString(4, getDireccion());
        parametroPersona.setString(5, getTelefono());
        parametroPersona.setString(6, getFecha_nacimiento());
        parametroPersona.setString(7, getCodigo_docente());
        parametroPersona.setString(8, getGenero());
        parametroPersona.setDouble(9, getSalario());
        parametroPersona.setString(10, getFec_ingreso_laboral());

        int executar = parametroPersona.executeUpdate();
        cn.conexionDB.commit();
        JOptionPane.showMessageDialog(null, "Actualización Exitosa de la Persona");
    } catch (SQLException ex) {
        try {
            if (cn.conexionDB != null) {
                cn.conexionDB.rollback();
            }
        } catch (SQLException rollbackEx) {
            JOptionPane.showMessageDialog(null, "Error al hacer rollback: " + rollbackEx.getMessage());
        }
        JOptionPane.showMessageDialog(null, "Error al actualizar los datos: " + ex.getMessage());
    } finally {
        try {
            if (cn.conexionDB != null) {
                cn.conexionDB.setAutoCommit(true);
            }
            cn.cerrar_conexion();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + ex.getMessage());
        }
    }
}


    
    public void eliminarp() {
    try {
        PreparedStatement parametroPersona;
        cn = new Conexion();
        cn.abrir_conexion();
        String queryp = "DELETE FROM docente WHERE id_persona = ?";
        parametroPersona = (PreparedStatement) cn.conexionDB.prepareStatement(queryp);
        parametroPersona.setInt(1, getId_persona());
        int executar = parametroPersona.executeUpdate();
        JOptionPane.showMessageDialog(null, "Registro Eliminado: " + Integer.toString(executar));
        cn.cerrar_conexion();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al eliminar: " + ex.getMessage());
    }
}

    
}
