package oblig4;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class LoginUtil {
	
	public static void loggUtBruker(HttpSession session) {
		if (session !=null) {
			session.invalidate();
		}
	}
	
	public static void loggInnBruker(HttpServletRequest request, String mobilnummer, String fornavn, String etternavn) {
		loggUtBruker(request.getSession()); 
		
		HttpSession sesjon = request.getSession();
		sesjon.setAttribute("mobilnummer", mobilnummer);
		sesjon.setAttribute("fornavn", fornavn);
		sesjon.setAttribute("etternavn", etternavn);
		sesjon.setMaxInactiveInterval(600);
	}
	
	public static boolean erBrukerInnloget(HttpServletRequest request) {
		HttpSession sesjon = request.getSession(); 
		return sesjon != null && sesjon.getAttribute("mobilnummer") !=null; 
	}

}
