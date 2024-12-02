import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateDj {

	public static void main(String[] args) throws SQLException {
		
		
String url = "jdbc:mysql://localhost:3306/mydb";
        
        Scanner input = new Scanner (System.in);
        String username = "root";
        String password = "Ilfoggia1";

        
     // Query SQL per selezionare tutti i dati dalla tabella dipendenti
        
        // abbiamo creato la query con il segnaposto
        String selectQuery = "SELECT * FROM ListaDj WHERE tipologia = (?)";
        
        // andiamo a prendere in input il genere che vogliamo cercare
        System.out.println("Che genere vuoi cercare: ");
        String genere = input.next();
       // effetuiamo la connessione con i dati precedentemente assegnati
         Connection conn = DriverManager.getConnection(url , username, password);
        		
        		// creiamo un preaparedStatement passandogli la query
        	     PreparedStatement stmt = conn.prepareStatement(selectQuery);
        		// settiamo il primo segnaposto con il valore della variabile genere
        	stmt.setString(1, genere);
        	
        	// eseguiamo la query chiamando il metodo executeQUery sullo statemnt questo ritorna un resultSet
        	     ResultSet rs = stmt.executeQuery();
        	     
        	     //iteriamo il result set e stampiamo i riusltati della ricerca
        	while (rs.next()) {
        	String nome = rs.getString("nome");
            String mansione = rs.getString("tipologia");
           String resident = rs.getString("resident");
            System.out.println(nome);
            System.out.println(mansione);
            System.out.println(resident);
        	}
        	
        	
        	
        	    // Codice per iterare sui risultati e leggere i dati qui...
        	} 
	}


