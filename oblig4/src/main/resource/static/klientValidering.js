
const form = document.querySelector("form");
form.addEventListener("submit", function(event) {
    const fornavn = form.elements["fornavn"].value.trim();
    const etternavn = form.elements["etternavn"].value.trim();
    const mobilnummer = form.elements["mobilnummer"].value.trim();
    const passord = form.elements["passord"].value;
    const repetertPassord = form.elements["repetertPassord"].value;

    let feilmeldinger = [];

    if (fornavn.length < 2) {
        feilmeldinger.push("Fornavn må inneholde minst 2 tegn.");
    } else if (!/^[A-ZÆØÅ][a-zA-ZæøåÆØÅ\- ]*$/.test(fornavn)) {
        feilmeldinger.push("Fornavn må starte med stor bokstav og kan bare inneholde bokstaver, bindestreker og mellomrom.");
    }

    if (etternavn.length < 2) {
        feilmeldinger.push("Etternavn må inneholde minst 2 tegn.");
    } else if (!/^[A-ZÆØÅ][a-zA-ZæøåÆØÅ\-]*$/.test(etternavn)) {
        feilmeldinger.push("Etternavn må starte med stor bokstav og kan bare inneholde bokstaver og bindestreker.");
    }

    if (!/^[0-9]{8}$/.test(mobilnummer)) {
        feilmeldinger.push("mobilnummer må bestå av nøyaktig 8 sifre.");
    }

    if (passord.length < 8) {
        feilmeldinger.push("Passord må være minst 8 tegn langt.");
    }

    if (passord !== repetertPassord) {
        feilmeldinger.push("Passord og repetert passord må være like.");
    }

    if (feilmeldinger.length > 0) {
        event.preventDefault();
        alert(feilmeldinger.join("\n"));
    }
});

formLoggInn.addEventListener("submit" , function(event){
	let feilmeldinger = []; 
	const mobilnummber = fromLoggInn.elements["mobilnummer"].value.trim(); 
	const passord = fromLoggInn.elments["passord"].value; 
	
	if(!/^[0-9]{8}/.test(mobilnummber)){
		feilmeldinger.push("mobilnummer må bestå av nøyaktig 8 sifre."); 
	}
	if(passord.length < 8){
		feilmeldinger.push("Passord må være minst 8 tegn langt."); 
	}
	if(feilmeldinger.length > 0){
		event.preventDefault();
		alert(feilmeldinger.join("\n")); 
	}
}); 
