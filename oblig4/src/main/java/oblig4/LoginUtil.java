package oblig4;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class LoginUtil {

    private static final int SESSION_TIMEOUT_SECONDS = 600;

    
    public static void loggUtBruker(HttpSession session) {
        if (session != null) {
            session.invalidate();
        }
    }

    
    public static void loggInnBruker(HttpServletRequest request, String mobilnummer, String fornavn, String etternavn) {
        if (request == null) return;

        
        loggUtBruker(request.getSession(false));

        HttpSession sesjon = request.getSession(true); 
        sesjon.setAttribute("mobilnummer", mobilnummer);
        sesjon.setAttribute("fornavn", fornavn);
        sesjon.setAttribute("etternavn", etternavn);
        sesjon.setMaxInactiveInterval(SESSION_TIMEOUT_SECONDS);
    }

    
    public static boolean erBrukerInnlogget(HttpServletRequest request) {
        if (request == null) return false;
        HttpSession sesjon = request.getSession(false); 
        return sesjon != null && sesjon.getAttribute("mobilnummer") != null;
    }
}
