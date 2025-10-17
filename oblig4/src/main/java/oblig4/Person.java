package oblig4;

import java.time.LocalDate;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Person {
    @Size(min=2, max=20, message="Fornavn må inneholde fra 2 til 20")
    @NotNull(message = "Fornavn er obligatorisk")
    private String fornavn;

    @Size(min = 2, max = 20, message = "Etternavn må inneholde fra 2 til 20")
    @NotNull(message = "Etternavn er obligatorisk")
    private String etternavn;

    

}
