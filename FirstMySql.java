import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class FirstMySql {

    public static void main(String[] args) {
        // URL di connessione al database
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "Ilfoggia1";

        Connection connection = null;

        try {
            // Carica il driver MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Effettua la connessione
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connessione al database riuscita!");

            // Dati da inserire nella tabella dipendenti
           Scanner input = new Scanner(System.in);
           System.out.println("Scrivi il nome del dj");
           String nome = input.nextLine();
           Scanner input1 = new Scanner(System.in);
           System.out.println("Scrivi il genere");
           String genere = input1.next();
           System.out.println("Scrivi la residenza");
           String residenza = input1.next();
           
           
           
            

            // Query SQL per l'inserimento dei dati nella tabella dipendenti
            // i punti interrogativi si chiamano segnaposto
            String insertQuery = "INSERT INTO listaDj (nome, tipologia, resident) VALUES (?, ?, ?)";

            // Crea un PreparedStatement per eseguire la query
            PreparedStatement stmt = connection.prepareStatement(insertQuery);
            stmt.setString(1, nome);
            stmt.setString(2, genere);
            stmt.setString(3, residenza);
           

            // Esegui la query e ottieni il numero di righe aggiornate
            int rowsAffected = stmt.executeUpdate();

            // Stampa il numero di righe aggiornate
            System.out.println("Numero di righe aggiornate: " + rowsAffected);

            // Chiudi il PreparedStatement
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Errore nella connessione o esecuzione della query");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC non trovato");
            e.printStackTrace();
        } finally {
            // Chiude la connessione se aperta
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                    System.out.println("Connessione chiusa.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
