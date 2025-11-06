package oblig4;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class PersonController {

    @Autowired
    private DeltagerService deltagerservice;

    @Autowired
    private DeltagerRepository deltagerRepository; 

    @Autowired
    private PassordService passordService; 

    @Autowired
    private ValidatorService validatorService; 

    @GetMapping("paamelding_med_melding")
    public String paamelding() {
        return "paamelding_med_melding";
    }

    @GetMapping("/deltagerliste")
    public String deltagerliste(Model model, HttpServletRequest request) {
        if(!LoginUtil.erBrukerInnlogget(request)) {
            model.addAttribute("feilmeldinger", List.of("Du må være innlogget.")); 
            return "login"; 
        }
        model.addAttribute("alleDeltagere", deltagerservice.finnAlleDeltagereSortert()); 
        return "deltagerliste";
    }

    @PostMapping("/validerOgRegistrer")
    public String validerOgRegistrer(
        Model model,
        @Valid @ModelAttribute("deltager") Deltagerskjema nyDeltager,
        BindingResult bindingResult,
        @RequestParam("passord") String passord,
        @RequestParam("repetertPassord") String repetertPassord,
        RedirectAttributes redirectAttributes,
        HttpServletRequest request) {

        if (bindingResult.hasErrors()) {
            List<String> feilmeldinger = bindingResult.getAllErrors().stream()
                .map(e -> e.getDefaultMessage())
                .toList();
            model.addAttribute("feilmeldinger", feilmeldinger); 
            return "paamelding_med_melding";
        }

        if(deltagerRepository.existsById(nyDeltager.getMobilnummer())) {
            model.addAttribute("feilmeldinger", List.of("Mobilnummer eksisterer allerede.")); 
            return "paamelding_med_melding"; 
        }

        if(!validatorService.isValidPassord(passord)) {
            model.addAttribute("feilmeldinger", List.of("Passord må være minst 8 tegn langt."));
            return "paamelding_med_melding";
        }

        if(!validatorService.passordMatch(passord, repetertPassord)) {
            model.addAttribute("feilmeldinger", List.of("Passordene stemmer ikke overens.")); 
            return "paamelding_med_melding";
        }

        String salt = passordService.genererTilfeldigSalt(); 
        String hash = passordService.hashMedSalt(passord, salt); 

        Deltager deltager = new Deltager(
            nyDeltager.getFornavn(),
            nyDeltager.getEtternavn(),
            nyDeltager.getMobilnummer(),
            hash,
            salt,
            nyDeltager.getKjonn()
        ); 

        deltagerRepository.save(deltager); 

        
        LoginUtil.loggInnBruker(request, nyDeltager.getMobilnummer(), nyDeltager.getFornavn(), nyDeltager.getEtternavn()); 

        redirectAttributes.addFlashAttribute("deltager", nyDeltager); 
        return "redirect:/paameldt"; 
    }    

    @GetMapping("/paameldt")
    public String paameldt(Model model) {
        return "paameldt"; 
    }

    @GetMapping("/login")
    public String loggInnskjema(Model model) {
        return "login"; 
    }

    @PostMapping("/validerOgLoggInn")
    public String validerOgLoggInn(
        Model model,
        @RequestParam("passord") String passord,
        @RequestParam("mobilnummer") String mobilnummer,
        HttpServletRequest request) {

        if (!validatorService.isValidmoblinummer(mobilnummer)) {
            model.addAttribute("feilmeldinger", List.of("Mobilnummer må være 8 sifre langt.")); 
            return "login"; 
        }

        if(!validatorService.isValidPassord(passord)) {
            model.addAttribute("feilmeldinger", List.of("Passord må være minst 8 tegn langt.")); 
            return "login"; 
        }

        Optional<Deltager> muligDeltager = deltagerservice.finnDeltagerViaMobilnummer(mobilnummer); 
        if(!muligDeltager.isPresent()) {
            model.addAttribute("feilmeldinger", List.of("Ugyldig brukernavn og/eller passord"));
            return "login";
        }

        Deltager loginDeltager = muligDeltager.get(); 
        if(!passordService.erKorrektPassord(passord, loginDeltager.getsalt(), loginDeltager.gethash())) {
            model.addAttribute("feilmeldinger", List.of("Ugyldig brukernavn og/eller passord")); 
            return "login"; 
        }

        LoginUtil.loggInnBruker(request, mobilnummer, loginDeltager.getFornavn(), loginDeltager.getEtternavn()); 
        return "redirect:/deltagerliste"; 
    }

    @PostMapping("/loggUt")
    public String loggUt(Model model, HttpServletRequest request) {
        LoginUtil.loggUtBruker(request.getSession(false)); 
        return "redirect:/login"; 
    }
}
