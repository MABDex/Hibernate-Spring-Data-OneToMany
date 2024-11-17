package dempmaping.ormonetomany;

import dempmaping.ormonetomany.Service.KrankHausService;
import dempmaping.ormonetomany.Service.KrankHausServiceImpl;
import dempmaping.ormonetomany.entities.*;
import dempmaping.ormonetomany.repositories.Artztrep;
import dempmaping.ormonetomany.repositories.Beratungsrep;
import dempmaping.ormonetomany.repositories.Patientrep;
import dempmaping.ormonetomany.repositories.Terminsrep;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class OrmOneToManyApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrmOneToManyApplication.class, args);
    }



    @Bean
    CommandLineRunner start(KrankHausServiceImpl krankHausService , Patientrep patientsrep , Artztrep artztrep ,
                            Terminsrep terminsrep , Beratungsrep beratungsrep) {
        // Methode Plus simple utilisation direkt de CommandlineRunner on l appele cette Method Start

        return args -> {


            Stream.of("DR MAB", "DR LAM", "DR YAMAL").forEach(name -> {

                Arzt arzt1 = new Arzt();
                arzt1.setName(name);
                arzt1.setEmail(name + "@gmail.com");
                arzt1.setSpezialisierung(Math.random()>0.5 ? "Cardio" :"Dentiste");
                artztrep.save(arzt1);


            });

            Stream.of("Hanato", "Nour", "Halim").forEach(name -> {

                Patient patient = new Patient();
                patient.setName(name);
                patient.setGeburtsdatum(new Date());
                patient.setIstkrank(false);
                patientsrep.save(patient);


            });


            Patient p1 = patientsrep.findById(1L).orElse(null) ;
            Patient p2 = patientsrep.findByName("MOHAMED"); // Error parceque on a 3 patient on a besoin d un Liste

            Arzt m1 = artztrep.findByName("DR YAMAL");
            Arzt m2 = artztrep.findById(2L).orElse(null) ;

            //  créer et enregistrer des rendez-vous
            Termin rdv = new Termin();
            rdv.setDateRendezvous(new Date());
            rdv.setStatus(TerminsStatus.PENDING);
            rdv.setArzt(m1);
            rdv.setPatient(p1);

            terminsrep.save(rdv);



            // Consultation :
            Termin terminsberatung = terminsrep.findById(1L).orElse(null) ;
            if (terminsberatung != null) {
                Beratung brtg = new Beratung();
                brtg.setKonsultationsdatum(terminsberatung.getDateRendezvous());
                brtg.setTermin(terminsberatung);
                brtg.setKonsultationsbericht("Patient hat ......");
                beratungsrep.save(brtg);
            };




        };

    }




}
