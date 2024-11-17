package dempmaping.ormonetomany.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // creer une entity jpa
    private long id;

    @Column(length= 50)  // setzen wir lenght in 50  in Base de donnes
    private String name;

    @Temporal(TemporalType.DATE)
    private Date Geburtsdatum;

    private boolean Istkrank;




    @OneToMany(mappedBy = "patient" ,fetch =FetchType.LAZY)
    private Collection<Termin> Terminobj;
    // Hadi kat3ni bli had relation OneToMany representer dans la Class Rendezvous b attribut patient
    // Donc hatmchi l Class Rendezvous hatl9a Atribut patient dakchi 3lach darori tkteb nfs smiyt attribut

    /*
      Dans la classe Rendezvous, nous avons un attribut qui s'appelle patient,
       représentant cette même relation. Si nous n'utilisons pas mappedBy, cela serait considéré comme une clé étrangère
     */




}
