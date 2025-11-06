package oblig4;

import org.springframework.stereotype.Service;

@Service
public class ValidatorService {
	
	public static final String NOOYAKTIG_AATE_SIFFER = "^\\d{8}$";
	public static final String MINST_AATE_TEGN = "^.{8,}$";
	
	public boolean isValidPassord(String passord) {
		return passord != null && passord.matches(MINST_AATE_TEGN); 
	}
	
	public boolean isValidmoblinummer(String moblinummer) {
		return moblinummer != null && moblinummer.matches(NOOYAKTIG_AATE_SIFFER); 
	}
	
	public boolean passordMatch(String passord, String repPassord) {
		return passord != null && passord.equals(repPassord); 
	}

}
