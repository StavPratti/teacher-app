package gr.aueb.cf.schoolapp.model.static_data;

import gr.aueb.cf.schoolapp.model.Employee;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name =  "educational_units")
public class EducationalUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

    @ManyToMany(mappedBy = "eduUnits")
    private Set<Employee> employees = new HashSet<>();
}
