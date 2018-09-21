package fatec.proo.control;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;

import fatec.proo.model.Departamento;

public class DaoDepartamento {

    private Connection conn;
    
    public DaoDepartamento(Connection conn) {
         this.conn = conn;
    }
    
    public void inserir(Departamento departamento) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO tb_departamento(sigla, departamento) VALUES(?,?)");
            ps.setString(1, departamento.getSigla());
            ps.setString(2, departamento.getNome());
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
    public void alterar(Departamento departamento) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE tb_departamento set departamento = ? " +
                                                 "where sigla = ?");
            
            ps.setString(1, departamento.getNome());
            ps.setString(2, departamento.getSigla());
           
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
        
     public  Departamento consultar (String sigla) {
        Departamento d = null;
       
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM tb_departamento WHERE " +
                                                 "tb_departamento.sigla = ?");
            ps.setString(1, sigla);
            
            ResultSet rs = ps.executeQuery();
                      
            if (rs.next() == true) {
                d = new Departamento (sigla, rs.getString("tb_departamento.departamento"));
            }
        }
        catch (SQLException ex) { 
             System.out.println(ex.toString());   
        }
        return (d);
    }    
     
     public void excluir(Departamento departamento) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM tb_departamento where sigla = ?");
            
            ps.setString(1, departamento.getSigla());
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
}





