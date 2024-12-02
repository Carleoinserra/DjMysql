import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProvaSelect {

	public static void main(String[] args) {
		 // URL di connessione al database
		
        String url = "jdbc:mysql://localhost:3306/mydb";
        
        
        String username = "root";
        String password = "Ilfoggia1";
		
		// Query SQL per selezionare tutti i dati dalla tabella dipendenti
        String selectQuery = "SELECT * FROM ListaDj";
        
        try (Connection conn = DriverManager.getConnection(url , username, password);
        	     Statement stmt = conn.createStatement();
        	     ResultSet rs = stmt.executeQuery(selectQuery)) {
        	while (rs.next()) {
        	String nome = rs.getString("nome");
            String mansione = rs.getString("tipologia");
           String resident = rs.getString("resident");
            System.out.println(nome);
            System.out.println(mansione);
            System.out.println(resident);
        	}
        	
        	
        	
        	    // Codice per iterare sui risultati e leggere i dati qui...
        	} catch (SQLException e) {
        	    // Gestione delle eccezioni qui...
        	}



	}

}
