import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DuUtente {

	public static void main(String[] args) throws SQLException {
	
		
		Scanner input = new Scanner (System.in);
		
		
		 String url = "jdbc:mysql://localhost:3306/mydb";
	        
	        
	        String username = "root";
	        String password = "Ilfoggia1";
	        
	        Connection conn = DriverManager.getConnection(url , username, password);
	        int scelta = 0;
	        
	        int somma = 0;
	        
	        
	        
	        do {
	        	
	        	System.out.println("1 stampare tutti i dj 2 per acquistare biglietti");
	        	
	        	scelta = input.nextInt();
	        	
	        	if (scelta == 1) {
	        		
	        		 String selectQuery = "SELECT * FROM ListaDj";
	 	            
	   	          
            	     Statement stmt = conn.createStatement();
            	     ResultSet rs = stmt.executeQuery(selectQuery); 
            	while (rs.next()) {
            	String nome = rs.getString("nome");
                String mansione = rs.getString("tipologia");
               String resident = rs.getString("resident");
               int prezzo = rs.getInt("prezzo");
               int posti = rs.getInt("NumeroPosti");
                System.out.println(nome);
                System.out.println(mansione);
                System.out.println(resident);
                System.out.println("Prezzo: " + prezzo);
                System.out.println("Posti disponibili: " + posti);
	        	}}
            	
            	else if (scelta == 2) {
            		System.out.println("Scrivi il nome del dj");
            		Scanner input1 = new Scanner (System.in);
            		String nome = input1.nextLine();
            		System.out.println("Scrivi quanti biglietti vuoi acquistare: ");
            		int numero = input1.nextInt();
            		String query = "UPDATE ListaDj SET NumeroPosti = NumeroPosti - (?) WHERE nome = (?)";
        	       
        	        
        	     // creiamo un preaparedStatement passandogli la query
           	     PreparedStatement stmt = conn.prepareStatement(query);
           		// settiamo il primo segnaposto con il valore della variabile genere
                  	stmt.setInt(1, numero);
                  	stmt.setString(2, nome);
           	
           	// eseguiamo la query chiamando il metodo executeQUery sullo statemnt questo ritorna il numero delle righe cambiate
           	     int rows = stmt.executeUpdate();
           	     
           	     if (rows != 0) {
           	    	 
           	    	 System.out.println(nome + " cambiato correttamente");
           	     }
           	     
           	     else {
           	    	 System.out.println("Dj non trovato!!!");
           	     }
	        	
	        	String selectQuery = "SELECT * FROM ListaDj WHERE nome = (?)";
	            
	            // andiamo a prendere in input il genere che vogliamo cercare
	          
	           
	            		
	            		// creiamo un preaparedStatement passandogli la query
	            	     PreparedStatement stmt1 = conn.prepareStatement(selectQuery);
	            		// settiamo il primo segnaposto con il valore della variabile genere
	            	stmt1.setString(1, nome);
	            	
	            	// eseguiamo la query chiamando il metodo executeQUery sullo statemnt questo ritorna un resultSet
	            	     ResultSet rs = stmt1.executeQuery();
	            	     
	            	     //iteriamo il result set e stampiamo i riusltati della ricerca
	            	while (rs.next()) {
	            	somma += rs.getInt("prezzo") * numero;
	            	}
            		
            	}}
	        
	        
	
	        
	        while (scelta != 0);
	        
	        System.out.println("Grazie per l'acquisto.");
	        System.out.println("La somma da pagare è: "  + somma);
	        System.out.println("Buone feste");


}}
