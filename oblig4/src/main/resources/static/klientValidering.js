const formReg = document.querySelector("#validerOgRegistrer");
const formLoggInn = document.querySelector("#validerOgLoggInn");

formReg.addEventListener("submit", function(event) {
    const fornavn = formReg.elements["fornavn"].value.trim();
    const etternavn = formReg.elements["etternavn"].value.trim();
    const mobilnummer = formReg.elements["mobilnummer"].value.trim();
    const passord = formReg.elements["passord"].value;
    const repetertPassord = formReg.elements["repetertPassord"].value;

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
	const mobilnummber = formLoggInn.elements["mobilnummer"].value.trim(); 
	const passord = formLoggInn.elements["passord"].value; 
	
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
