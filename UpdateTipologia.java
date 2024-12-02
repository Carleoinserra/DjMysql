import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateTipologia {
	
	public static void main(String[] args) throws SQLException {
		
		Scanner input = new Scanner (System.in);
		
		
		 String url = "jdbc:mysql://localhost:3306/mydb";
	        
	        
	        String username = "root";
	        String password = "Ilfoggia1";
	        
	        Connection conn = DriverManager.getConnection(url , username, password);
	        int scelta = 0;
	        
	        
	        
	        do {
	        	
	        	System.out.println("1 per inserire un nuovo dj, 2 per aggiornare la residenza, 3 pre stampare tutti i dj 4 per ricercare un dj 6 per cancellare dal nome");
	        	
	        	scelta = input.nextInt();
	        if (scelta == 2) {
	        	Scanner input1 = new Scanner (System.in);
	        	String query = "UPDATE ListaDj SET resident = (?) WHERE nome = (?)";
	        System.out.println("Nome del dj: ");
	        String nome = input1.nextLine();
	        
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
   	     }}
	        
	        else if (scelta == 1) {
	        	
	        	 
	             System.out.println("Connessione al database riuscita!");

	             // Dati da inserire nella tabella dipendenti
	            Scanner input2 = new Scanner(System.in);
	            System.out.println("Scrivi il nome del dj");
	            String nome = input2.nextLine();
	            Scanner input3 = new Scanner(System.in);
	            System.out.println("Scrivi il genere");
	            String genere = input3.next();
	            System.out.println("Scrivi la residenza");
	            String residenza = input3.next();
	            System.out.println("Scrivi il prezzo");
	            int prezzo = input3.nextInt();
	            System.out.println("Scrivi il numero dei posti:");
	            int numero = input3.nextInt();
	            
	            
	            
	             

	             // Query SQL per l'inserimento dei dati nella tabella dipendenti
	             // i punti interrogativi si chiamano segnaposto
	             String insertQuery = "INSERT INTO listaDj (nome, tipologia, resident, prezzo, NumeroPosti ) VALUES (?, ?, ?,?,?)";

	             // Crea un PreparedStatement per eseguire la query
	             PreparedStatement stmt = conn.prepareStatement(insertQuery);
	             stmt.setString(1, nome);
	             stmt.setString(2, genere);
	             stmt.setString(3, residenza);
	             stmt.setInt(4, prezzo);
	             stmt.setInt(5,  numero);
	             
	            

	             // Esegui la query e ottieni il numero di righe aggiornate
	             int rowsAffected = stmt.executeUpdate();

	             // Stampa il numero di righe aggiornate
	             System.out.println("Numero di righe aggiornate: " + rowsAffected);

	             // Chiudi il PreparedStatement
	             stmt.close();
	        }
	        
	        else if (scelta == 3) {
	        	
	        	
	        	// Query SQL per selezionare tutti i dati dalla tabella dipendenti
	            String selectQuery = "SELECT * FROM ListaDj";
	            
	          
	            	     Statement stmt = conn.createStatement();
	            	     ResultSet rs = stmt.executeQuery(selectQuery); 
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
	        
	        else if (scelta == 4) {
	        	// abbiamo creato la query con il segnaposto
	            String selectQuery = "SELECT * FROM ListaDj WHERE nome = (?)";
	            
	            // andiamo a prendere in input il genere che vogliamo cercare
	            System.out.println("Scrivi il nome del dj da ricercare: ");
	            String nome = input.next();
	           // effetuiamo la connessione con i dati precedentemente assegnati
	            
	            		
	            		// creiamo un preaparedStatement passandogli la query
	            	     PreparedStatement stmt = conn.prepareStatement(selectQuery);
	            		// settiamo il primo segnaposto con il valore della variabile genere
	            	stmt.setString(1, nome);
	            	
	            	// eseguiamo la query chiamando il metodo executeQUery sullo statemnt questo ritorna un resultSet
	            	     ResultSet rs = stmt.executeQuery();
	            	     
	            	     //iteriamo il result set e stampiamo i riusltati della ricerca
	            	while (rs.next()) {
	            	String nome1 = rs.getString("nome");
	                String mansione = rs.getString("tipologia");
	               String resident = rs.getString("resident");
	                System.out.println(nome1);
	                System.out.println(mansione);
	                System.out.println(resident);
	            	}
	            	
	        }
	        
	        else if (scelta == 5) {
	        	String query = "DELETE FROM ListaDj WHERE nome = (?)";
	     	        System.out.println("Nome del dj: ");
	     	        Scanner input6 = new Scanner(System.in);
	     	        String nome = input6.nextLine();
	     	        
	     	        
	     	     // creiamo un preaparedStatement passandogli la query
	        	     PreparedStatement stmt = conn.prepareStatement(query);
	        		// settiamo il primo segnaposto con il valore della variabile genere
	               	
	               	stmt.setString(1, nome);
	        	
	        	// eseguiamo la query chiamando il metodo executeQUery sullo statemnt questo ritorna il numero delle righe cambiate
	        	     int rows = stmt.executeUpdate();
	        	     
	        	     if (rows != 0) {
	        	    	 
	        	    	 System.out.println(nome + " cancellatto corretamente");
	        	     }
	        	     
	        	     else {
	        	    	 System.out.println("Dj non trovato!!!");
	        	     }}
	        	
	        	
	        
		
		
	}
	   while (scelta != 0);     
	}
	
	

}
