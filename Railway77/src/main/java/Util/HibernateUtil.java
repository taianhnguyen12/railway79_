package Util;

import entity.Department;
import entity.GroupStudent;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    @SuppressWarnings("removal")
    public static SessionFactory builSessionFactory() {
        // nếu chưa có table , tạo Table mới luôn thêm " ?createDatabaseIfNoteExist=true " vào sau table new
        var url = "jdbc:mysql://localhost:3306/visus?createDatabaseIfNoteExist=true";

        var configuration = new Configuration()
                .addAnnotatedClass(Department.class)
                .addAnnotatedClass(GroupStudent.class)
                .setProperty(AvailableSettings.URL,url)
                .setProperty(AvailableSettings.USER,"root")
                .setProperty(AvailableSettings.PASS,"root")
                .setProperty(AvailableSettings.DIALECT,"org.hibernate.dialect.MySQL57Dialect")
                .setProperty(AvailableSettings.SHOW_SQL,"true")
                .setProperty(AvailableSettings.HIGHLIGHT_SQL,"true")
                .setProperty(AvailableSettings.HBM2DDL_AUTO,"create") ;// tự động tạo bảng nếu như chưa có

        return configuration.buildSessionFactory();



    }
}
