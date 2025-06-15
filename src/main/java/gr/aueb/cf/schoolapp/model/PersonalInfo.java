package gr.aueb.cf.schoolapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "personal_information")
public class PersonalInfo extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String amka;

    @Column(name = "identity_number")
    private String identityNumber;

    @Column(name = "place_of_birth")
    private String placeOfBirth;

    @Column(name = "municipality_of_registration")
    private String municipalityOfRegistration;

    @OneToOne
    @JoinColumn(name = "amka_file_id")
    private Attachment amkaFile;
}
