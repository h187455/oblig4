package oblig4;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Person {
    @Size(min=2, max=20, message="Fornavn må inneholde fra 2 til 20")
    @NotNull(message = "Fornavn er obligatorisk")
    private String fornavn;

    @Size(min = 2, max = 20, message = "Etternavn må inneholde fra 2 til 20")
    @NotNull(message = "Etternavn er obligatorisk")
    private String etternavn;

    @Pattern(regexp = "^\\d{8}$", message = "Mobilnummer må være 8 siffer")
    @NotNull(message = "Mobilnummer er obligatorisk")
    private String mobilnummer;

    @Size(min = 8, message = "Passord må ha minst 8 tegn")
    private String passord;

}
