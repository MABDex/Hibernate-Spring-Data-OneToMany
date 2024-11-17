package dempmaping.ormonetomany.Service;

import dempmaping.ormonetomany.entities.Arzt;
import dempmaping.ormonetomany.entities.Beratung;
import dempmaping.ormonetomany.entities.Patient;
import dempmaping.ormonetomany.entities.Termin;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional

public class KrankHausServiceImpl implements KrankHausService {






    @Override
    public Patient savePatient(Patient patient) {
        return null;
    }

    @Override
    public Arzt savearzt(Arzt medarzt) {
        return null;
    }

    @Override
    public Termin saveTermin(Termin trm) {
        return null;
    }

    @Override
    public Beratung saveBeratung(Beratung beratung) {
        return null;
    }
}
