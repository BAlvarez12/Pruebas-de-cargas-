/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import javax.swing.JOptionPane;

/**
 *
 * @author Bomiki
 */
public class Empleado extends Persona {
     private String codigo_empleado,salario,bonificacion;

    public String getCodigo_empleado() {
        return codigo_empleado;
    }

    public void setCodigo_empleado(String codigo_empleado) {
        this.codigo_empleado = codigo_empleado;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }
    
    public String getBonificacion() {
      return bonificacion;   
    }
    
    public void setBonificacion(String bonificacion) {
   this.bonificacion = bonificacion;     
}
    
    
    public String[] crear(){
           try
            {         
                    String datos[]= new String[9];      
                      datos[0] = getCodigo_empleado();
                      datos[1] = getNombres();
                      datos[2] = getApellidos();
                      datos[3] = getDireccion();
                      datos[4] = getTelefono();
                      datos[5] = getFecha_nacimiento();
                      datos[6] = getSalario();
                      datos[7] = getBonificacion();
                      datos[8] = String.valueOf(total());
              return  datos;            
                 }
                 
        catch(Exception ex)
            {
                  
                    JOptionPanel.showMessageDialog(null,ex.getMessage(),"Error en Query",JOptionPane.ERROR_MESSAGE);
                    return  null;
            }
           
           
   }
    
     @Override
     public void agregar(){
         
        System.out.println("Codigo Empleado " + this.getCodigo_empleado() );
        System.out.println(" "+this.getSalario() );
        System.out.println(" "+this.getBonificacion());
        System.out.println("Total Compensación: " + total());
  
    
}
      public double total() {
        double salarioN = Double.parseDouble(this.getSalario());
        double bonificacionN = Double.parseDouble(this.getBonificacion());
        return salarioN + bonificacionN;
    }
}