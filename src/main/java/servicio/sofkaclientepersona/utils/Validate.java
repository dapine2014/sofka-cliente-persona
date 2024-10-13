package servicio.sofkaclientepersona.utils;

import org.springframework.stereotype.Component;
import servicio.sofkaclientepersona.aplication.dto.ClienteDto;

import java.util.List;
import java.util.Objects;

import static servicio.sofkaclientepersona.utils.constant.*;

@Component
public class Validate {

    public void ValidateData(ClienteDto dto){
        Objects.requireNonNull(dto, FUND_NULL);

        if (dto.getNombre() == null || dto.getNombre().isEmpty()) {
            throw new IllegalArgumentException(FUND_NAME_NULL);
        }

        if (dto.getIdentificacion() == null || dto.getIdentificacion().isEmpty()) {
            throw new IllegalArgumentException(FUND_IDENTIFICATION_NULL);
        }
    }

    public void ValidateData(Long id){
       Objects.requireNonNull(id, FUND_NULL);
       if (id < 0 || id == null) {
         throw new IllegalArgumentException(FUND_ID_NULL);
       }
    }

    public void ValidateData(List<ClienteDto> clienteDtos){
       if(clienteDtos.isEmpty()){
           throw new IllegalArgumentException(FUND_LIST_NULL);
       }
    }
}
