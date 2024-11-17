package dempmaping.ormonetomany.Service;

import dempmaping.ormonetomany.entities.Arzt;
import dempmaping.ormonetomany.entities.Beratung;
import dempmaping.ormonetomany.entities.Patient;
import dempmaping.ormonetomany.entities.Termin;

public interface KrankHausService {



    Patient savePatient(Patient patient);
    Arzt savearzt(Arzt medarzt);
    Termin saveTermin(Termin trm);
    Beratung saveBeratung(Beratung beratung);





}
