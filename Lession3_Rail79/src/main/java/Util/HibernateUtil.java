package Util;


import Entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    @SuppressWarnings("removal")
    public static SessionFactory builSessionFactory() {
        // nếu chưa có table , tạo Table mới luôn thêm " ?createDatabaseIfNoteExist=true " vào sau table new
        var url = "jdbc:mysql://localhost:3306/lession03?createDatabaseIfNoteExist=true";

        var configuration = new Configuration()
                .addAnnotatedClass(GroupStudent.class)
                .addAnnotatedClass(Post.class)
                .addAnnotatedClass(Comment.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Group.class)
                .setProperty(AvailableSettings.URL,url)
                .setProperty(AvailableSettings.USER,"root")
                .setProperty(AvailableSettings.PASS,"root")
                .setProperty(AvailableSettings.DIALECT,"org.hibernate.dialect.MySQL57Dialect")
                .setProperty(AvailableSettings.SHOW_SQL,"true")
                .setProperty(AvailableSettings.HIGHLIGHT_SQL,"true")
                .setProperty(AvailableSettings.HBM2DDL_AUTO,"create") // tự động tạo bảng nếu như chưa có
                .setProperty(AvailableSettings.ENABLE_LAZY_LOAD_NO_TRANS, "true")
                .setProperty(AvailableSettings.KEYWORD_AUTO_QUOTING_ENABLED,"true");
        return configuration.buildSessionFactory();



    }
}
