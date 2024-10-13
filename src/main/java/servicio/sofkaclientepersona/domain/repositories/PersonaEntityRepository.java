package servicio.sofkaclientepersona.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import servicio.sofkaclientepersona.domain.entities.Persona;

@Repository
public interface PersonaEntityRepository extends JpaRepository<Persona, Long> {
}