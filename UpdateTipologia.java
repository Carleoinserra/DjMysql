import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateTipologia {
	
	public static void main(String[] args) throws SQLException {
		
		Scanner input = new Scanner (System.in);
		String query = "UPDATE ListaDj SET resident = (?) WHERE nome = (?)";
		
		 String url = "jdbc:mysql://localhost:3306/mydb";
	        
	        
	        String username = "root";
	        String password = "Ilfoggia1";
	        
	        Connection conn = DriverManager.getConnection(url , username, password);
	        
	        System.out.println("Nome del dj: ");
	        String nome = input.nextLine();
	        Scanner input1 = new Scanner (System.in);
	        System.out.println("Scrivi la nuova residenza: ");
	        String resident = input1.next();
	        
	     // creiamo un preaparedStatement passandogli la query
   	     PreparedStatement stmt = conn.prepareStatement(query);
   		// settiamo il primo segnaposto con il valore della variabile genere
          	stmt.setString(1, resident);
          	stmt.setString(2, nome);
   	
   	// eseguiamo la query chiamando il metodo executeQUery sullo statemnt questo ritorna il numero delle righe cambiate
   	     int rows = stmt.executeUpdate();
   	     
   	     if (rows != 0) {
   	    	 
   	    	 System.out.println(nome + " cambiato correttamente");
   	     }
   	     
   	     else {
   	    	 System.out.println("Dj non trovato!!!");
   	     }
		
		
	}

}
