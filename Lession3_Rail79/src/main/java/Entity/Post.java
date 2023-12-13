package Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Post")
public class Post {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
    private Long id;



@Column(name = "title",length = 100,unique = true ,nullable = false)
    private String title;
@Column(name = "description",length = 150,nullable = false)
    private String description;
@Column(name = "content",length = 250,nullable = false)
    private String content;


@Column(name = "create_at",nullable = false,updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp

    private LocalDateTime createAt;

@Column(name = "update_at", nullable = false,columnDefinition = "DATETIME")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime updateAt;

//    @OneToOne(mappedBy = "post")
@OneToMany(mappedBy = "post")
    private List<Comment> comments;
}
