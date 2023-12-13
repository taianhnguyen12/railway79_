package entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@ToString
@Table(name = "group_student")
//@IdClass(value = GroupSTDPK.class)
public class GroupStudent {
    @EmbeddedId
private GroupSTDPK id;
//@Id
//private Long groupID;
//@Id
//private Long studentID;



    @Column(name = "joined_at", nullable = false,updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private LocalDateTime joinedAt;




}
