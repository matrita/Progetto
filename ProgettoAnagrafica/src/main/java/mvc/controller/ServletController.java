package mvc.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.model.Anagrafica;
import mvc.model.TransazioniAnag;

/**
 * Servlet implementation class ServletController
 */
@WebServlet("/ServletController")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	TransazioniAnag TrAnag;

	public ServletController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		final int INSERIMENTO = 1;
		final int VISUALIZZAZIONE = 2;
		final int RICERCA = 3;
		final int MODIFICA = 4;
		final int CANCELLAZIONE = 5;

		String action = request.getParameter("action");

		// String nome = request.getParameter("nome");
		// String cognome = request.getParameter("cognome");
		// String matricola = request.getParameter("matricola");

		int azione = Integer.valueOf(action).intValue();
		System.out.println(azione);

		switch (azione) {

		case INSERIMENTO: {
			String nome = request.getParameter("nome");
			String cognome = request.getParameter("cognome");
			String matricola = request.getParameter("matricola");

			// inserire le anagrafiche in un vettore dinamico Vector o ArrayList

			Anagrafica a1 = new Anagrafica();
			a1.setMatricola(matricola);
			a1.setNome(nome);
			a1.setCognome(cognome);

			System.out.println(a1.getMatricola());
			System.out.println(a1.getNome());
			System.out.println(a1.getCognome());

			TrAnag.Inserimento(a1);

			// anagrafiche.addElement(a1);

			// fine inserimento

			request.getRequestDispatcher("AddUser.jsp").forward(request, response);
			break;
		}
		case VISUALIZZAZIONE: {
			// scansionare il vettore per la visualizzazione

			// System.out.println(anagrafiche.get(0).toString());
			ArrayList<Anagrafica> anagrafiche = TrAnag.Visualizzazione();

			request.setAttribute("anagrafiche", anagrafiche);

			request.getRequestDispatcher("RispVisualizzazione.jsp").forward(request, response);

			// fine visualizzazione
			break;
		}
		case RICERCA: {
			String matricola = request.getParameter("matricola");
			System.out.println(matricola);

			Anagrafica a = TrAnag.Ricerca(matricola);

			if (a.getMatricola() != null) {
				System.out.println("Matricola trovata");
				request.getRequestDispatcher("RispRicerca.jsp?esiste=si").forward(request, response);
				break;
			} else {
				System.out.println("Matricola non trovata");
				request.getRequestDispatcher("RispRicerca.jsp?esiste=no").forward(request, response);
				break;
			}

		}
		case MODIFICA: {
			String nome = request.getParameter("nome");
			String cognome = request.getParameter("cognome");
			String matricola = request.getParameter("matricola");
			// System.out.println(matricola);
			// System.out.println(nome);
			// System.out.println(cognome);

			Anagrafica a1 = new Anagrafica();
			a1.setMatricola(matricola);
			a1.setNome(nome);
			a1.setCognome(cognome);

			System.out.println(a1.getMatricola());
			System.out.println(a1.getNome());
			System.out.println(a1.getCognome());

			TrAnag.Modifica(a1);

			request.getRequestDispatcher("RispModifica.jsp").forward(request, response);

			break;
		}
		case CANCELLAZIONE: {
			String matricola = request.getParameter("matricola");
			System.out.println(matricola);

			TrAnag.Cancellazione(matricola);

			request.getRequestDispatcher("RispCancellazione.jsp").forward(request, response);

			break;
		}

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
