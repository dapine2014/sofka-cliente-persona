package servicio.sofkaclientepersona.aplication.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class RatingAverageDto {
    @NotNull
    Integer idprofessional;

    @NotNull
    @PositiveOrZero
    @Range(min = 0, max = 5)
    Integer numrating;
}
