        package dempmaping.ormonetomany.entities;

        import com.fasterxml.jackson.annotation.JsonProperty;
        import jakarta.persistence.*;
        import lombok.AllArgsConstructor;
        import lombok.Data;
        import lombok.NoArgsConstructor;

        import java.util.Collection;

        @Entity
        @Data
        @NoArgsConstructor
        @AllArgsConstructor


        public class Arzt {




            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private long id;

            @Column(length= 50)  // setzen wir lenght in 50  in Base de donnes
            private String name;

            private String email;
            private String Spezialisierung;


            @OneToMany(mappedBy = "arzt" , fetch = FetchType.LAZY)
            private Collection<Termin> Terminobj;



        }
