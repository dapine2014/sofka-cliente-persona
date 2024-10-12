package servicio.sofkaclientepersona.aplication.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MessageResponceDto {
    public String uuIdFrom;
    public String from;
    @JsonProperty("to")
    public String myto;
    public String uuIdTo;
    public Object query;
    public ArrayList<RatingAverageDto> response;
}
