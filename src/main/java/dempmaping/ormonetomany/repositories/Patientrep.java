package dempmaping.ormonetomany.repositories;

import dempmaping.ormonetomany.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Patientrep extends JpaRepository<Patient, Long> {


    Patient findByName(String name);
}
