package dempmaping.ormonetomany.repositories;

import dempmaping.ormonetomany.entities.Arzt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Artztrep extends JpaRepository<Arzt , Long> {

    Arzt findByName(String name);


}
