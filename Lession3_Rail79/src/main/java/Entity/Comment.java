package Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.ManyToAny;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "Comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 200,nullable = false)
    private String Name;

    @Column(name = "email", length = 200,nullable = false)
    private String email;

    @Column(name = "body",length = 200,nullable = false)
    private String body;


    @Column(name = "create_at",nullable = false,updatable = false)
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createAt;


    @Column(name = "update_At",nullable = false,columnDefinition = "DATETIME")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)

    private LocalDateTime updateAt;

//@OneToOne
@ManyToOne //nhiều bài viết cho 1 bài
@JoinColumn(
        name = "post_id",
        referencedColumnName = "id",
//        unique = true, duy nhất khi nó dùng OneToOne
        nullable = false
) // cấu hình 1 cột làm khóa ngoại
    private Post post;
}