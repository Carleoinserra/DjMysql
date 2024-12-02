import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CreaDipedente {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		int scelta = 0;
		 // URL di connessione al database
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "Ilfoggia1";
     // Effettua la connessione
        Connection connection = DriverManager.getConnection(url, username, password);;
		
		do {
			
			Scanner input = new Scanner(System.in);
			System.out.println("Coasa vuoi fare  \n"
					+ " 1 per inserire un nuovo dipendente \n"
					+ " 2 per stampare tutti i dipedenti \n"
					+ " 3 per stampare un dipedente dal nome \n"
					+ " 4 per aggiornare lo stipendio di un dipedente dal nome \n"
			+ " 5 per stampare la somma degli stipendi \n"
			+ " 6 per cancellare un elmento dal nome \n");
			scelta = input.nextInt();
			
			if (scelta == 1) {
				
				 try {
			            // Carica il driver MySQL
			            Class.forName("com.mysql.cj.jdbc.Driver");

			            
			            
			            

			            // Dati da inserire nella tabella dipendenti
			           Scanner input1 = new Scanner(System.in);
			           System.out.println("Scrivi il nome del dipendente");
			           String nome = input1.next();
			           System.out.println("Scrivi la mansione");
			           String mansione = input1.next();
			           System.out.println("Scrivi lo stipendio");
			           int stipendio = input1.nextInt();
			           
			           
			           
			            

			            // Query SQL per l'inserimento dei dati nella tabella dipendenti
			            // i punti interrogativi si chiamano segnaposto
			            String insertQuery = "INSERT INTO dipendenti (nome, mansione, stipendio) VALUES (?, ?, ?)";

			            // Crea un PreparedStatement per eseguire la query
			            PreparedStatement stmt = connection.prepareStatement(insertQuery);
			            stmt.setString(1, nome);
			            stmt.setString(2, mansione);
			            stmt.setInt(3, stipendio);
			           

			            // Esegui la query e ottieni il numero di righe aggiornate
			            int rowsAffected = stmt.executeUpdate();

			            // Stampa il numero di righe aggiornate
			            System.out.println("Dipendente aggiunto con successo: " + rowsAffected);

			            // Chiudi il PreparedStatement
			            stmt.close();
			        } catch (SQLException e) {
			            System.out.println("Errore nella connessione o esecuzione della query");
			            e.printStackTrace();
			        } catch (ClassNotFoundException e) {
			            System.out.println("Driver JDBC non trovato");
			            e.printStackTrace();
			        }
				
			}
			
			else if (scelta == 2) {
				
				// Query SQL per selezionare tutti i dati dalla tabella dipendenti
		        String selectQuery = "SELECT * FROM dipendenti";
		        
		        try (Connection conn = DriverManager.getConnection(url , username, password);
		        	     Statement stmt = conn.createStatement();
		        	     ResultSet rs = stmt.executeQuery(selectQuery)) {
		        	while (rs.next()) {
		        	String nome = rs.getString("nome");
		            String mansione = rs.getString("mansione");
		            int stipendio = rs.getInt("stipendio");
		            System.out.println(nome);
		            System.out.println(mansione);
		            System.out.println(stipendio);
		        	}
		        	
		        	    // Codice per iterare sui risultati e leggere i dati qui...
		        	} catch (SQLException e) {
		        	    // Gestione delle eccezioni qui...
		        	}


				
			}
			
			else if (scelta == 3) {
			
				
				 // i punti interrogativi si chiamano segnaposto
	            String insertQuery = "SELECT * FROM dipendenti WHERE nome = (?)";
	            
	         
	           
				
					
					// dallo scanner andiamo a prednere la variabile nome
					 Scanner input1 = new Scanner(System.in);
			           System.out.println("Scrivi il nome del dipendente");
			           String nome = input1.next();
			           
			        // Crea un PreparedStatement per eseguire la query
			           PreparedStatement stmt = connection.prepareStatement(insertQuery);
			        // settiamo il primo segnamo posto con il nome che vogliamo ricercare nella tabella
			           stmt.setString(1, nome);
			           
			           ResultSet rs = stmt.executeQuery();
			           
			           
			          boolean ok = false;
			           
			           // finchè ci sono risultati nel result set
			           while (rs.next()) {
			        	   
			        	   String nome1 = rs.getString("nome");
			        	   String mansione = rs.getString("mansione");
			        	   int stipendio = rs.getInt("stipendio");
			        	   
			        	   System.out.println(nome1 + " ," + mansione + " ," + stipendio);
			        	   ok = true;
			        	   
			           }
			           
			           if (ok == false) {
			        	   
			        	   System.out.println("dip non presente");
			           }
			           
				
			          
				
	           
				
			}
			
			else if (scelta == 4) {
				
				 // i punti interrogativi si chiamano segnaposto
	            String insertQuery = "UPDATE dipendenti SET stipendio = (?) WHERE nome = (?)";
	            
	         
	           
				
					
					// dallo scanner andiamo a prednere la variabile nome
					 Scanner input1 = new Scanner(System.in);
			           System.out.println("Scrivi il nome del dipendente");
			           String nome = input1.next();
			           
			           System.out.println("Scrivi il nuovo stipendio");
			           int nStipendio = input1.nextInt();
			           
			        // Crea un PreparedStatement per eseguire la query
			           PreparedStatement stmt = connection.prepareStatement(insertQuery);
			        // settiamo il primo segnamo posto con il nome che vogliamo ricercare nella tabella
			           stmt.setInt(1, nStipendio);
			           stmt.setString(2, nome);
			           
			           // Esegui la query e ottieni il numero di righe aggiornate
			            int rowsAffected = stmt.executeUpdate();

			            // Stampa il numero di righe aggiornate
			            System.out.println("Numero di righe aggiornate: " + rowsAffected);

				
				
				
				
				
				
				
			}
			
else if (scelta == 5) {
				
				// Query SQL per selezionare tutti i dati dalla tabella dipendenti
		        String selectQuery = "SELECT * FROM dipendenti";
		        int somma = 0;
		        try (Connection conn = DriverManager.getConnection(url , username, password);
		        	     Statement stmt = conn.createStatement();
		        	     ResultSet rs = stmt.executeQuery(selectQuery)) {
		        	while (rs.next()) {
		        	String nome = rs.getString("nome");
		            String mansione = rs.getString("mansione");
		            int stipendio = rs.getInt("stipendio");
		            somma += stipendio;
		        	}
		        	
		        	    // Codice per iterare sui risultati e leggere i dati qui...
		        	} catch (SQLException e) {
		        	    // Gestione delle eccezioni qui...
		        	}

		        
		        System.out.println("La somma degli stipendi è " + somma + " euro");

				
			}
			
			
else if (scelta == 6) {

	 // i punti interrogativi si chiamano segnaposto
    String insertQuery = "DELETE from dipendenti  WHERE nome = (?)";
    
 
   
	
		
		// dallo scanner andiamo a prednere la variabile nome
		 Scanner input1 = new Scanner(System.in);
           System.out.println("Scrivi il nome del dipendente");
           String nome = input1.next();
           
           
           
        // Crea un PreparedStatement per eseguire la query
           PreparedStatement stmt = connection.prepareStatement(insertQuery);
        // settiamo il primo segnamo posto con il nome che vogliamo ricercare nella tabella
           
           stmt.setString(1, nome);
           
           // Esegui la query e ottieni il numero di righe aggiornate
            int rowsAffected = stmt.executeUpdate();

            // Stampa il numero di righe aggiornate
            System.out.println("Dipendente cancellato in numero: " + rowsAffected);

	
	
	
	
	




}
			
		
		
		
		
		
		}
			
		
while (scelta != 0);
	}

}
