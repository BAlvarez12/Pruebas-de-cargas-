    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Timestamp;

/**
 *
 * @author Bomiki
 */
public class Docente {
    
    public double salario;
    public String codigo_docente, genero, fec_ingreso_laboral ;
    Conexion cn;
    
    public Docente(){}

    public Docente(String codigo_docente, double salario, String genero, String fec_ingreso_laboral) {
      this.codigo_docente = codigo_docente;
      this.salario = salario;
      this.genero = genero;
      this.fec_ingreso_laboral = fec_ingreso_laboral;
      
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCodigo_docente() {
        return codigo_docente;
    }

    public void setCodigo_docente(String codigo_docente) {
        this.codigo_docente = codigo_docente;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFec_ingreso_laboral() {
        return fec_ingreso_laboral;
    }

    public void setFec_ingreso_laboral(String fec_ingreso_laboral) {
        this.fec_ingreso_laboral = fec_ingreso_laboral;
    }


    
    
    protected void crear(){}
    protected void leer(){}
    protected void eliminar(){}
    protected void actualizar(){} 
}

    
    
   