package Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")

    private Long id;

    @Column(name = "name",length = 50,nullable = false)
    private String name;


    @Column(name = "gender",nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Gender gender;
// bảng chung gian giữa student và group
//    @ManyToMany
//    @JoinTable (
//            name = "group_student",
//            joinColumns = @JoinColumn(name = "student_id",
//                    referencedColumnName = "id",
//                    nullable = false),
//            inverseJoinColumns = @JoinColumn(name = "group_id",
//                    referencedColumnName = "id",
//                    nullable = false)
//    )
//    private List<Group> groups;
    @OneToMany(mappedBy = "student")
    private List<GroupStudent> groupStudents;
    public enum Gender{
        FEMALE,MALE
    }
}
