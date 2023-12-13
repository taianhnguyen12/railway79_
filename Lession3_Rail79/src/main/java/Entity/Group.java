package Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Group")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")

    private Long id;


    @Column(name = "nameGr",length = 50,unique = true,nullable = false)

    private String nameGr;

//@ManyToMany(mappedBy = "groups")
////
////    private List<Student> students;
    @OneToMany(mappedBy = "group")
    private List<GroupStudent> groupStudents;
}
