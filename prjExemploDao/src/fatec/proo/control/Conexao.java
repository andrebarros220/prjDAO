package fatec.proo.control;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;


public class Conexao {
   private String connectionString;
   private String driver;
   private String banco;
   private String usuario;
   private String senha;
   private String host;
   private Connection connection=null;

   public Conexao(String host,String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
        this.host = host;
        connectionString = "jdbc:postgresql://localhost:5432/postgres";        
   }

    public Conexao(String usuario, String senha) {   
        this.usuario = usuario;
        this.senha = senha;        
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }
   
   public Connection conectar() {
        
	   if (connection == null){
	      try {                 
             connection = DriverManager.getConnection(connectionString, usuario, senha);
	         System.out.println("Conexao OK");
              }catch (Exception ex) {
                  System.out.println("Falha na Conexao");
                  System.out.println(ex.toString() + ex.getMessage());
          }
	   }
       
	   return connection;
   }
   
   public void fecharConexao(){
        if (connection != null){
	       try {
                  connection.close();
           } catch (SQLException ex) {
                   System.out.println(ex.toString());    
           }
        }   
    }
}