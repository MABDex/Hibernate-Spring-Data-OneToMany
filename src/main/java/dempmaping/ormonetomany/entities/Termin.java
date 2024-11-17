package dempmaping.ormonetomany.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Termin {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Temporal(TemporalType.DATE)
    private Date dateRendezvous;

    @Enumerated(EnumType.STRING)
    private TerminsStatus status;   // Status de RendezVous

    @ManyToOne        // Bzaf de rendzvous (Many) y9der yakhdhom Medcin (ToOne)
    private Arzt arzt;

    @ManyToOne       // Bzaf de rendzvous (Many) y9der yakhdhom patient (ToOne)
    private Patient patient;

    @OneToOne (mappedBy = "termin")
    private Beratung beratung;


}
