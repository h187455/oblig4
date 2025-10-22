package oblig4;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import jakarta.validation.Valid;

@Controller
public class PersonController {

    @Autowired
    private DeltagerService service;

    @GetMapping("paamelding_med_melding")
    public String visSkjema(Model model) {
        if (!model.containsAttribute("deltager")) {
            model.addAttribute("deltager", new Deltager("", "", "", "", ""));
        }
        return "paamelding_med_melding";
    }

    @PostMapping("/validerOgRegistrer")
    public String validerOgRegistrer(
        Model model,
        @Valid @ModelAttribute("deltager") Deltager deltager,
        BindingResult bindingResult,
        @RequestParam("repetertPassord") String repetertPassord,
        RedirectAttributes redirectAttributes) {

        // Validering fra @Pattern / @NotNull
        if (bindingResult.hasErrors()) {
            model.addAttribute("feilmeldinger",
                bindingResult.getAllErrors().stream()
                .map(e -> e.getDefaultMessage()).toList());
            return "paamelding_med_melding";
        }

        // Unikt mobilnummer
        if (service.finnesMobil(deltager.getMobilnummer())) {
            model.addAttribute("feilmeldinger", List.of("Mobilnummer eksisterer allerede."));
            return "paamelding_med_melding";
        }

        // Passord gjentatt korrekt
        if (!deltager.getPassord().equals(repetertPassord)) {
            model.addAttribute("feilmeldinger", List.of("Passordene stemmer ikke overens."));
            return "paamelding_med_melding";
        }

        // Legg til deltager i service
        service.leggTil(deltager);

        // send deltager til bekreftelse
        redirectAttributes.addFlashAttribute("deltager", deltager);
        return "redirect:/paameldt";
    }

    @GetMapping("/paameldt")
    public String visBekreftelse() {
        return "paameldt";
    }

    @GetMapping("/deltagerliste")
    public String visDeltagerliste(Model model) {
        model.addAttribute("deltagere", service.hentAlleSortert());
        return "deltagerliste";
    }
}
