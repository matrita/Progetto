package mvc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.enterprise.inject.Default;

import org.apache.commons.lang.StringEscapeUtils;

@Default
public class TransazioniAnagJDBC implements TransazioniAnag {

	public void Inserimento(Anagrafica a) {
		Connection cn;
		Statement st;
		String sql;

		try {
			// Creo la connessione al database
			cn = DriverManager.getConnection("jdbc:mysql://root:9225@localhost:3306/anagrafica");

			String matricola = StringEscapeUtils.escapeSql(a.getMatricola());
			String nome = StringEscapeUtils.escapeSql(a.getNome());
			String cognome = StringEscapeUtils.escapeSql(a.getCognome());

			sql = "insert into anagrafica (matricola,nome, cognome) values ('" + matricola + "','" + nome + "','"
					+ cognome + "')";
			System.out.println(sql);
			// ________________________________query

			st = cn.createStatement(); // creo sempre uno statement sulla
										// connessione
			st.execute(sql); // faccio la query su uno statement
			cn.close(); // chiusura connessione
		} catch (SQLException e) {
			System.out.println("errore:" + e.getMessage());
		} // fine try-catch

	}

	public Anagrafica Ricerca(String matricola) {

		String sql = "select nome,cognome,matricola from anagrafica where matricola = " + matricola;
		Anagrafica anag = new Anagrafica();

		// String url1 = "jdbc:ucanaccess://c:\\Database1.accdb";
		String url2 = "jdbc:mysql://root:9225@localhost:3306/anagrafica";
		// String url3 = "jdbc:ucanaccess://D:\\Anagrafica1.accdb";
		try {
			// establishing connection
			Connection con = DriverManager.getConnection(url2);
			if (con != null) {
				System.out.println("Connection Successful!");
			}

			// ------------------------------------------------------------

			Statement stmt = (Statement) con.createStatement();
			ResultSet rset = stmt.executeQuery(sql);

			while (rset.next()) {

				anag.setMatricola(rset.getString("matricola"));
				anag.setNome(rset.getString("nome"));
				anag.setCognome(rset.getString("cognome"));

				// System.out.println(rset.getString("matricola"));
				// System.out.println(rset.getString("nome"));
				// System.out.println(rset.getString("cognome"));

			}
			// ------------------------------------------------------------

			stmt.close();
			con.close();
		} catch (Exception e) {
			System.err.print("SQLException: ");
			System.err.println(e.getMessage());
		}
		return anag;

	}

	public ArrayList<Anagrafica> Visualizzazione() {

		ArrayList<Anagrafica> anagrafiche = new ArrayList<Anagrafica>();

		// String url1 = "jdbc:ucanaccess://c:\\Database1.accdb";
		String url2 = "jdbc:mysql://root:9225@localhost:3306/anagrafica";
		// String url3 = "jdbc:ucanaccess://D:\\Anagrafica1.accdb";
		try {
			// establishing connection
			Connection con = DriverManager.getConnection(url2);
			if (con != null) {
				System.out.println("Connection Successful!");
			}

			// ------------------------------------------------------------

			Statement stmt = (Statement) con.createStatement();
			ResultSet rset = stmt.executeQuery("select matricola,nome,cognome from anagrafica");

			while (rset.next()) {
				Anagrafica anag = new Anagrafica();

				anag.setMatricola(rset.getString(1));
				anag.setNome(rset.getString(2));
				anag.setCognome(rset.getString(3));

				anagrafiche.add(anag);

			}

			// ------------------------------------------------------------

			rset.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("errore:" + e.getMessage());
		} // fine try-catch

		return anagrafiche;

	};

	public void Modifica(Anagrafica a) {
		Connection cn;

		try {
			// Creo la connessione al database
			cn = DriverManager.getConnection("jdbc:mysql://root:9225@localhost:3306/anagrafica");

			String matricola = StringEscapeUtils.escapeSql(a.getMatricola());
			String nome = StringEscapeUtils.escapeSql(a.getNome());
			String cognome = StringEscapeUtils.escapeSql(a.getCognome());

			PreparedStatement pstmt = cn
					.prepareStatement("UPDATE anagrafica SET nome = ?, cognome = ? WHERE matricola = ?");
			pstmt.setString(1, nome);
			pstmt.setString(2, cognome);
			pstmt.setString(3, matricola);
			pstmt.executeUpdate();

			pstmt.close();
			cn.close(); // chiusura connessione
		} catch (SQLException e) {
			System.out.println("errore:" + e.getMessage());
		} // fine try-catch

	}

	public void Cancellazione(String matricola) {
		String url = "jdbc:mysql://root:9225@localhost:3306/anagrafica";
		Connection con;
		String cmdSQL = "delete from anagrafica where matricola =" + matricola;
		Statement stmt;
		int righe;

		try {
			con = DriverManager.getConnection(url, "", "");
			stmt = con.createStatement();
			righe = stmt.executeUpdate(cmdSQL);
			if (righe > 0) {
				System.out.print("Matricola eliminata");
			} else {
				System.out.print("Matricola da eliminare non trovato");
			}
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("errore:" + e.getMessage());
		} // fine try-catch
	}
}
