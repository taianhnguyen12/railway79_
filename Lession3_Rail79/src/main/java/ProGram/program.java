package ProGram;

import Entity.*;
import Util.HibernateUtil;

import java.lang.reflect.Array;
import java.util.Arrays;

public class program {

    public static void main(String[] args) {
         try(var factory = HibernateUtil.builSessionFactory()) {
            factory.inTransaction(session -> {
                var post = new Post() ;
                post.setTitle("Java-ad");
                post.setDescription("Hibernate Core");
                post.setContent("Sping FrameWork");
                session.persist(post);


                var comment1= new Comment();
                comment1.setName("Tài");
                comment1.setEmail("taianhnguyen12@gmail.com");
                comment1.setBody("Bài viết cõ ích");
                comment1.setPost(post);
                session.persist(comment1);

                var comment2= new Comment();
                comment2.setName("Tài JAVART");
                comment2.setEmail("taianhnguyen13@gmail.com");
                comment2.setBody("Đây là thông báo ");
                comment2.setPost(post);
                session.persist(comment2);

                var comment3= new Comment();
                comment3.setName("CAR JAVART");
                comment3.setEmail("taianhnguyen14@gmail.com");
                comment3.setBody("KHỞI CHẠYYH ");
                comment3.setPost(post);
                session.persist(comment3);
            });

            var posts  = factory.fromSession(session -> {
               var hqlString = "FROM Post";
               return session
                       .createSelectionQuery(hqlString ,Post.class)
                       .getResultList(); // lấy ra tất cả danh sách
            });
             for (var post : posts) {
                 System.out.println("Title : " + post.getTitle());
                 var comments = post.getComments();
                 for (var comment : comments) {
                     System.out.println("Comment; " + comment.getBody());
                 }
             }

//
//             factory.inTransaction(session -> {
//                 var group1 = new Group();
//                 group1.setNameGr("JAVA_AD");
//
//
//                 var group2 = new Group();
//                 group2.setNameGr("Spring FrameWork");
//
//                 var student1 = new Student();
//                 student1.setName("Nguyễn Xuân tài");
//                 student1.setGender(Student.Gender.FEMALE);
//
//                 var student2 = new Student();
//                 student2.setName("Hoàng Thái bảo");
//                 student2.setGender(Student.Gender.MALE);
//
//
//                 session.persist(group1);
//                 session.persist(group2);
//
//                 var groups = Arrays.asList(group1,group2); // lênh này mới add dc học sinh 1 và học sinh 2 vào 2 bảng gr ngẫu nhiên hoặc addd cả 2 học sinh vào 2 bảng
//                student1.setGroups(groups);
//                 student2.setGroups(groups);
//
//                 session.persist(student1);
//                 session.persist(student2);
//             });

             factory.inTransaction(session -> {
                 var group1 = new Group();
                 group1.setNameGr("JAVA_AD");


                 var group2 = new Group();
                 group2.setNameGr("Spring FrameWork");

                 var student1 = new Student();
                 student1.setName("Nguyễn Xuân tài");
                 student1.setGender(Student.Gender.FEMALE);

                 var student2 = new Student();
                 student2.setName("Hoàng Thái bảo");
                 student2.setGender(Student.Gender.MALE);


                 session.persist(group1); //session.persist để lưu database
                 session.persist(group2);

                 session.persist(student1);
                 session.persist(student2);

                 var groupStudent1 = new GroupStudent();
                 groupStudent1.setStudent(student1);
                 groupStudent1.setGroup(group1);
                 session.persist(groupStudent1);

                 var groupStudent2 = new GroupStudent();
                 groupStudent2.setStudent(student1);
                 groupStudent2.setGroup(group2);
                 session.persist(groupStudent2);

                 var groupStudent3 = new GroupStudent();
                 groupStudent3.setStudent(student2);
                 groupStudent3.setGroup(group1);
                 session.persist(groupStudent3);

                 var groupStudent4 = new GroupStudent();
                 groupStudent4.setStudent(student2);
                 groupStudent4.setGroup(group2);
                 session.persist(groupStudent4);
             });
        }

   }
}
