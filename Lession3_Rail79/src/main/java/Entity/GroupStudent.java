package Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "group_student")
public class GroupStudent {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")

    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id",
            referencedColumnName = "id",
            nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "group_id",
            referencedColumnName = "id",
            nullable = false)
    private Group group;

    @Column(name = "joined_at", nullable = false,updatable = false)
    @CreationTimestamp
    private LocalDateTime joinedAt;


}
