package frontend;

import Util.HibernateUtil;
import entity.Department;

import entity.GroupSTDPK;
import entity.GroupStudent;
import org.hibernate.internal.build.AllowSysOut;

import java.security.acl.Group;

public class Program {
    public static void main(String[] args) {
        try (var factory = HibernateUtil.builSessionFactory()) {

            //cách 1
            var departmentA = new Department();
            departmentA.setName(" Giám Đốc");
            departmentA.setType((Department.Type.PROJECT_MANAGER));

            var session = factory.openSession();

            session.beginTransaction();  // bắt đầu

            session.persist(departmentA);// tương ứng câu lệnh insert

            session.getTransaction().commit();       // kết thúc

// phòng ban A
            var departmentB = new Department();
            departmentB.setName("nhân sụ");
            departmentB.setType(Department.Type.TESTER);
            factory.inTransaction(s -> s.persist(departmentB));
            //cách 2

//Phòng ban C
            var departmentC = new Department();
            departmentC.setName("Bảo ");
            departmentC.setType((Department.Type.TESTER));
            factory.inTransaction(s -> s.persist(departmentC));


            //UPDATE
            departmentB.setName("Kỹ ");
            factory.inTransaction(s -> s.merge(departmentB));

//            //DELETE BY ID
//            factory.inTransaction(s -> s.remove(departmentB));


            // FIND ALL

            var departments = factory.fromSession(s -> {
                var sql = " FROM Department"; // D hoa này là tên của class ko phải create
                return s.createQuery(sql, Department.class)
                        .getResultList(); // trả về danh sách kết quả

            }) ;// nhiều hơn 1 câu lệnh dùng ngoặc nhọn
            for(var department : departments) {
                System.out.println(department);
            }
            // Tạo mói group
            factory.inTransaction(s -> {
                var groupStudent = new GroupStudent();
                var pk = new GroupSTDPK();
              pk.setGroupID(1L);
              pk.setStudentID(1L);
              groupStudent.setId(pk);
//                groupStudent.setGroupID(2L);
//                groupStudent.setStudentID(2L);
              s.persist(groupStudent);
            });
        }
    }
}

