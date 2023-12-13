package entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.*;

import java.sql.Types;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
@Table(name = "department")
public class Department
{
    @Id //PRIMARY KEY
//    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @JdbcTypeCode(Types.VARCHAR)
  @GenericGenerator(name = "department-id-generator",
  type = DepartmentIdGenerator.class )
    @GeneratedValue(generator = "department-id-generator")
    @Column(name = "id")

    private String id; // gắn liền với AUTO
//    private Long id;
    @Column(name = "name",length = 50,unique = true,nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    @Convert(converter = departmentTypeConverter.class)
// @Enumerated(value = EnumType.ORDINAL)
//@Enumerated(value = EnumType.STRING)
    private Type type;
/*
lenght : tối đa 50 ký tự
unique : khóa duy nhất
nullable = not null
 */
   @Column(name = "created_at")
   @Temporal(TemporalType.TIMESTAMP)
   @CreationTimestamp

   private LocalDateTime createAt;

   @Column(name = "updated_at",nullable = false , columnDefinition = "DATETIME")
   @CreationTimestamp
   @Temporal(TemporalType.TIMESTAMP)
   private LocalDateTime updateAt;


   public enum Type {
       //0,1,2,3,4
       DEVELOPER,TESTER , SCRUM_MASTER,PROJECT_MANAGER

   }
}
