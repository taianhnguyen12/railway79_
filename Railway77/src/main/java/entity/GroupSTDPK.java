package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@Embeddable // nhusng vào entity khác

public class GroupSTDPK {
    @Column(name = "group_id", nullable = false)

    private Long groupID;
    @Column(name = "student_id",nullable = false)
    private Long StudentID;

}
