package neuroassistant.server;

import java.sql.*;

/**
 * Classe Server
 *
 * @author Abdul Rasheed Tutakhail
 */
public class ServerNeuro {

    public static Connection conn;

    public static Connection getConnessione() {
        System.out.println("connection");
        return conn;
    }

    //serve per la connessione con il database
    public String connetti() {
        System.out.println("connetti");
        String risposta = "";
        System.out.println("avvio della connessione");
        try {
            //carico il driver di connessione
            Class.forName("com.mysql.jdbc.Driver");
            //stabilisco la connessione
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/NeuroDatabase?user=root&password=alphabravo");
            System.out.println("Connessione stabilita");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver di connessione non trovato");
            risposta = "no";
            return risposta;
        } catch (SQLException e) {
            System.out.println("Eccezione:" + e.getMessage());
            risposta = "no";
            return risposta;
        }
        return risposta;
    }

    /**
     * Metodo utilizzato per verificare se un utente è contenuto nel database
     *
     * @param username Stringa rappresentante il nome dell'utente
     * @param password Stringa rappresentante la password dell'utente
     * @param ruolo Stringa il ruolo con cui esiste nel database
     * @return Restituisce si se è presente, no se non lo è e errore negli altri
     * casi
     */
    public String login(String user, String password, String ruolo) {

        String risposta = "";
        //Preparo la query
        String query = "SELECT * FROM login WHERE username = ? AND password = ? AND ruolo = ?";
        String errore = connetti();
        if (errore.equals("")) {
            try {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, user);
                ps.setString(2, password);
                ps.setString(3, ruolo);
                ResultSet rs = ps.executeQuery();
                if (!rs.last()) {
                    risposta = "no";
                } else {
                    risposta = "si";
                }
                ps.close();
                conn.close();
            } catch (SQLException e) {
                System.out.println("Errore: " + e.getMessage());
                risposta = "error-query";
                //return risposta;
            }
        } else {
            risposta = "error-connessione";
        }
        return risposta;

    }

    /**
     * Metodo utilizato per verificare se l'utente con dato username e ruolo
     * esiste
     *
     * @param utente Stringa rappresentante del username con cui esiste nel
     * database
     * @param ruolo Stringa rappresentante del ruolo con cui tale utente esiste
     * nel database
     * @return resitituisce Si se l'utente esiste e No se non esiste
     */
    public String verifica_elimina(String utente, String ruolo) {

        String risposta = "";
        String query = "SELECT * FROM login WHERE username = ? AND  ruolo = ?";

        String errore = connetti();
        if (errore.equals("")) {
            try {

                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, utente);
                ps.setString(2, ruolo);

                ResultSet rs = ps.executeQuery();
                if (!rs.last()) {
                    risposta = "no";
                } else {
                    risposta = "si";
                }
                ps.close();
                conn.close();
            } catch (SQLException e) {
                System.out.println("Errore: " + e.getMessage());
                risposta = "error-query";

            }
        } else {
            risposta = "error-connessione";
        }
        return risposta;

    }

    /**
     * Metodo che viene utilizzato per cancellare un utente dal database.
     *
     * @param utente Stringa rappresentante del username con cui esiste nel
     * database
     * @param ruolo Stringa rappresentante del ruolo con cui tale utente esiste
     * nel database
     * @return restituisce Si se l'utente viene cancellato con successo,
     * resistuisce "error-query" oppure "errore-connession" se l'operazione
     * fallisce perchè ci sono errori nella esecuzione della query e errori
     * nella connessione al database respettivamente.
     */
    public String elimina_utente(String utente, String ruolo) {

        String risposta = "";
        String errore = connetti();
        String query = "DELETE FROM login WHERE username = ? AND  ruolo = ?";

        if (errore.equals("")) {
            try {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, utente);
                ps.setString(2, ruolo);
                ps.executeUpdate();
                risposta = "si";
                ps.close();
                conn.close();
            } catch (SQLException e) {
                System.out.println("Errore: " + e.getMessage());
                risposta = "error-query";
            }

        } else {
            risposta = "error-connessione";
        }

        return risposta;
    }

    /**
     * Metodo per aggiungere nuovi utenti nel database
     *
     * @param username Stringa rappresentante il nome dell'utente
     * @param password Stringa rappresentante la password dell'utente
     * @param ruolo Stringa il ruolo con cui esiste nel database
     * @return restituisce Si se l'utente viene aggiunto con successo,
     * resistuisce "error-query" oppure "errore-connession" se l'operazione
     * fallisce perchè ci sono errori nella esecuzione della query e errori
     * nella connessione al database respettivamente.
     */
    public String aggiungi_utente(String user, String password, String ruolo) {

        String risposta = "";
        String query = "INSERT INTO login (username, password, ruolo) values (?, ?, ?)";
        String errore = connetti();

        //inserimeto dei dati del utente dentro la tabella login
        if (errore.equals("")) {
            try {

                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, user);
                ps.setString(2, password);
                ps.setString(3, ruolo);
                ps.executeUpdate();
                ps.close();
                conn.close();
                risposta = "si";
            } catch (SQLException e) {
                System.out.println("Errore: " + e.getMessage());
                risposta = "error-query";
            }
        } else {
            risposta = "error-connessione";
        }

        return risposta;
    }

    /**
     * Metodo che viene utilizzato per aggiungere nuove malattie nel database
     *
     * @param malattia Stringa rappresentante il nome della malattia
     * @param eta Intero rappresenta l'età dopo il quale è più probabile
     * @param descrizione Stringa rappresenta ulteriori informazione riguardante
     * la malattia
     * @param sexarra Array di Stringhe che esprime quale sesso è piu a rischio
     * a detta malattia
     * @param selec Array di Stringhe che esprime quale etnia è più a rischio
     * della malattia in questione.
     * @param sintom Array di Stringhe che rappresenta lista di Sintomi
     * accompagnati dalla malattia
     * @return Restituisce Si se la malattia viene aggiunta con successo nel
     * database,resistuisce "error-query" oppure "errore-connession" se
     * l'operazione fallisce perchè ci sono errori nella esecuzione della query
     * e errori nella connessione al database respettivamente.
     */
    public String aggiungi_malattia(String malattia, int eta, String descrizione, String[] sexarra, String[] selec, String[] sintom) {

        String risposta = "no";
        String query = "INSERT INTO malattia (nome, eta, descrizione, sesso, etnia, sintomi) values (?, ?, ?, ?, ?, ?)";

        int k = 0;
        String errore = connetti();

        if (errore.equals("")) {
            try {
                PreparedStatement ps = conn.prepareStatement(query);
                //Tutte e due sesso sono a rischio della malattia
                if (sexarra.length == 2) {

                    while (k < sexarra.length) {
                        for (int i = 0; i < selec.length; i++) {
                            for (int j = 0; j < sintom.length; j++) {

                                ps.setString(1, malattia);
                                ps.setInt(2, eta);
                                ps.setString(3, descrizione);
                                ps.setString(4, sexarra[k]);
                                ps.setString(5, selec[i]);
                                ps.setString(6, sintom[j]);
                                ps.executeUpdate();
                            }
                        }

                        k++;
                    }

                } else {

                    for (int i = 0; i < selec.length; i++) {
                        for (int j = 0; j < sintom.length; j++) {

                            ps.setString(1, malattia);
                            ps.setInt(2, eta);
                            ps.setString(3, descrizione);
                            ps.setString(4, sexarra[0]);
                            ps.setString(5, selec[i]);
                            ps.setString(6, sintom[j]);
                            ps.executeUpdate();

                        }
                    }
                }

                ps.close();
                conn.close();
                risposta = "si";
            } catch (SQLException e) {

                System.out.println("Errore: " + e.getMessage());
                risposta = "error-query";
            }
        } else {

            risposta = "error-connessione";
        }
        return risposta;
    }

    /**
     * Metodo utlizzato dal Medico per controllare se esiste qualche malattia
     * nel database con caratteristiche specificate dai parametri
     *
     * @param age Intero rappresentante dell'età del paziente.
     * @param sexstr Stringa rappresentante del sesso del paziente.
     * @param etniastr Stringa rappresentate dell'etnia del paziente.
     * @param sintom Array di Stringhe che rappresentano la lista di sintomi del
     * paziente.
     * @return Restituisce la lista delle malattie se vengono trovate nel
     * database con carateristiche dei parametri passati. Restituisce No se non
     * viene trovato nessuna malattia. resistuisce "error-query" oppure
     * "errore-connession" se l'operazione fallisce perchè ci sono errori nella
     * esecuzione della query e errori nella connessione al database
     * respettivamente.
     */
    public String medico(int age, String sexstr, String etniastr, String[] sintom) {

        int i = 0;
        String risposta = "";
        String query;
        String newline = "\n";
        String errore = connetti();
        Array arr;

        if (errore.equals("")) {

            try {

                arr = conn.createArrayOf("VARCHAR", sintom);
                Statement st = conn.createStatement();
                //ESECUZIONE QUERY
                query = "SELECT DISTINCT nome FROM malattia WHERE eta<= ? AND  sesso = ? AND etnia = ? AND sintomi = ? IN(?) ";

                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, age);
                ps.setString(2, sexstr);
                ps.setString(3, etniastr);
                ps.setArray(4, arr);

                ResultSet rs = ps.executeQuery();
                if (!rs.last()) {
                    risposta = "no";
                } else {

                    // il ResulSet viene mandato al metodo getRowCount per calcolare il numero di righe che viene
                    int teta = getRowCount(rs);
                    // utilizzato per dichiarare la dimensione dell'array alpha che conterrà il resultato della query
                    String[] alpha = new String[teta];
                    rs.beforeFirst();
                    while (rs.next()) {
                        alpha[i] = rs.getString("nome");
                        i++;
                    }

                    risposta = arrayToString(alpha, newline);
                }

                ps.close();
                conn.close();
            } catch (Exception e) {
                risposta = "error-query";

            }
        } else {
            risposta = "error-connessione";
        }

        return risposta;

    }

    /**
     * Metodo che viene utilizzato dal metodo medico per calcolare il numero di
     * righe
     *
     * @param set ResultSet rappresenta il resultato della query
     * @return restituisce l'intero che rappresenta il numero di righe
     * @throws SQLException
     */
    public static int getRowCount(ResultSet set) throws SQLException {
        int rowCount;
        int currentRow = set.getRow();
        rowCount = set.last() ? set.getRow() : 0;
        if (currentRow == 0) {
            set.beforeFirst();
        } else {
            set.absolute(currentRow);
        }
        return rowCount;
    }

    /**
     * Metodo che viene utilizzato dal metodo medico per trasformare un'array in
     * una stringa per facilità nel trasferimento dei dati al Cliente.
     *
     * @param array Array di Stringhe rappresenta l'array dove ogni singolo
     * elemento è un riga del resultato della query
     * @param delimiter Stringa rappresenta il delimitatore che vogliamo porre
     * tra elementi della stringa
     * @return Restituisce la Stringa corrispondente all'array introdotta
     * nell'ingresso
     */
    public String arrayToString(String[] array, String delimiter) {
        StringBuilder arTostr = new StringBuilder();
        if (array.length > 0) {
            arTostr.append(" ").append("1. ").append(array[0]);
            for (int i = 1; i < array.length; i++) {
                arTostr.append(delimiter);
                arTostr.append(" ").append(i + 1).append(". ").append(array[i]);
            }
        }
        return arTostr.toString();
    }

}
