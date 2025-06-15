package gr.aueb.cf.schoolapp.model;

import gr.aueb.cf.schoolapp.model.static_data.EducationalUnit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "employees")
public class Employee extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String uuid;

    @Column(name = "is_active")
    private Boolean isActive;

    @ManyToMany
    @JoinTable (
            name = "employees_edu_units"
    )
    private Set<EducationalUnit> eduUnits = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    public void addEducationalUnit(EducationalUnit educationalUnit) {
        if (eduUnits == null) eduUnits = new HashSet<>();
        eduUnits.add(educationalUnit);
        educationalUnit.getEmployees().add(this);
    }


    public void initializeUUID() {
        if (uuid == null) uuid = UUID.randomUUID().toString();
    }

}
